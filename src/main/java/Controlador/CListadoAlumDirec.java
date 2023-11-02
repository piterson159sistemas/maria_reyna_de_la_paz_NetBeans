
package Controlador;
import DAO.crudAlumno;
import Modelo.Alumno;
import Procesos.ListaAlumnos;
import Vista.lista_estudiantes_directivo_1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

public class CListadoAlumDirec implements ActionListener,MouseListener{
    lista_estudiantes_directivo_1 vista;
    Alumno alum;
    crudAlumno crudAlum = new crudAlumno();
    ListaAlumnos listaA=new ListaAlumnos();

    public CListadoAlumDirec(lista_estudiantes_directivo_1 listaEst) {
        vista=listaEst;
        vista.btnFiltrar.addActionListener(this);
        vista.btnBuscar.addActionListener(this);
        vista.btnActualizar.addActionListener(this);
        vista.btnBorrar.addActionListener(this);
        vista.btnInsertar.addActionListener(this);
        vista.tblListaAlumnos.addMouseListener(this);
        listaEst.setTitle("Gestion de Estudiantes");
        listaEst.setVisible(true);
        
        listaA.cargaInicialCombos(vista.cbxFiltrarNivel, vista.cbxFiltrarGrado);
        listaA.cargaInicialCombos(vista.cbxNivel, vista.cbxGrado);
        listaA.cargarNiveles(vista.cbxFiltrarNivel);
        listaA.cargarNiveles(vista.cbxNivel);
        ActualizarLista();
        //Combos para filtrar
        CargarCombosEnlazados(vista.cbxFiltrarNivel,vista.cbxFiltrarGrado);
        //combos para ver datos Alumno
        CargarCombosEnlazados(vista.cbxNivel,vista.cbxGrado);
    }

    public  ArrayList<String> leerAlumno(){
        JComponent campos[]= {vista.cbxFiltrarNivel,vista.txtNumDoc,vista.txtNombres,
        vista.txtApellidoP,vista.txtApellidoM};
        int numCampos= campos.length;
        
        ArrayList<String>data = new ArrayList<>();
        String dato;
        
        //for para recorrer todos los campos, guardando su valor en una lista
        for(int i=0; i<numCampos;i++){
            if(campos[i] instanceof JTextField){
                dato= ((JTextField)campos[i]).getText();
            }else{
                dato= ((JComboBox)campos[i]).getSelectedItem().toString();
            }
            data.add(dato);
        }
        //retornamos los datos del alumno
       return data;
        
    
    }
    
    public void ActualizarLista(){
        String nivel=vista.cbxFiltrarNivel.getSelectedItem().toString();
        String grado=vista.cbxFiltrarGrado.getSelectedItem().toString();
        String estado=vista.cbxFiltrarEstadoGrado.getSelectedItem().toString();
        String[] filtros = crudAlum.Filtrar(nivel, grado,estado);
        
        crudAlum.Listar(vista.tblListaAlumnos, vista.lblNumAlumnos,filtros);
        listaA.formatoColumnasTabla(vista.tblListaAlumnos);
    }
    
    public void mostraAlumno(ArrayList<String> data){
        JComponent campos[]= {vista.cbxFiltrarNivel,vista.txtNumDoc,vista.txtNombres,
        vista.txtApellidoP,vista.txtApellidoM};
        int numCampos= campos.length;
        
        for(int i=0; i<numCampos;i++){
            if(campos[i] instanceof JTextField){
                ((JTextField)campos[i]).setText(data.get(i));
            }else{
                switch(data.get(1)){
                    case "DNI":
                    ((JComboBox)campos[i]).setSelectedIndex(0);
                    break;
                
                    case "Pasaporte":
                        ((JComboBox)campos[i]).setSelectedIndex(1);
                    break;
                
                    case "Carnet de extranjeria":
                    ((JComboBox)campos[i]).setSelectedIndex(2);
                    break;
                }
            }
        }
        vista.txtNumDoc.setText(data.get(0));
    }

    
    /* Metodo para cargar los comboBox Nivel y Grado de forma enlazada, es decir,
    segun que Nivel se escoge se muestra los grados enlazados(pertenecientes)
    a ese nivel */
    public void CargarCombosEnlazados(JComboBox cbxNivel,JComboBox cbxGrado){ 
        
        /*Usamos un ItemListener en el comboBox Nivel para mostrar los grados
        correspondientes al Nivel que se seleccione*/
        cbxNivel.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange()==ItemEvent.SELECTED){
                    String nivelSelect = cbxNivel.getSelectedItem().toString();
                    
                    // remueve todos los grados del anterior nivel seleccionado
                    cbxGrado.removeAllItems();
                    //cargamos los grados del actual el nivel seleccionado
                    listaA.cargarGrados(cbxGrado, nivelSelect);
                }
            }
        });
    }
    
    // para controlar eventos(click) en los botones
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==vista.btnFiltrar){
            ActualizarLista();         
        }
        
        if(e.getSource()==vista.btnBuscar){
            //falta detallar
            int NumDoc = Integer.parseInt(vista.txtBuscar.getText());
            ArrayList<String> dataAlumno = crudAlum.Buscar(NumDoc);
            mostraAlumno(dataAlumno);            
        }
        
        if(e.getSource()==vista.btnActualizar){
            int NumDoc = Integer.parseInt(vista.txtBuscar.getText());
            alum = new Alumno(leerAlumno());
            crudAlum.Actualizar(alum);
            ActualizarLista();
        }
        
        if(e.getSource()==vista.btnBorrar){
            int NumDoc = Integer.parseInt(vista.txtBuscar.getText());
            crudAlum.Eliminar(NumDoc);
            ActualizarLista();
        }
        
        if(e.getSource()==vista.btnInsertar){
            alum = new Alumno(leerAlumno());
            crudAlum.Insertar(alum);
            ActualizarLista();
            
        }
    }

    
    // para controlar eventos(click) en la tabla de Alumnos
    @Override
    public void mouseClicked(MouseEvent e) {
        //captura la fila que se selecciona
        int numfila = vista.tblListaAlumnos.rowAtPoint(e.getPoint());
        int columNumDoc = 0; //num de coliumna de Num Doc dentro de la fila seleccionada
        int columEstado = 2; //num de coliumna de estado dentro de la fila seleccionada
        
        if(numfila>-1){
            String numDocAlumno= vista.tblListaAlumnos.getValueAt(numfila, columNumDoc).toString();
            String estado=vista.tblListaAlumnos.getValueAt(numfila, columEstado).toString();
            String[] data= crudAlum.Buscar(numDocAlumno,estado);
            listaA.MostrarAlumno(data, vista);
            
            
        }
        
    }
    
    // no se usaran estos metodos asi que se dejan vacios
    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
    
    
    
    
    
}
