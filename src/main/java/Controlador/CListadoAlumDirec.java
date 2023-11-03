
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
//dependencias para manejar restricciones en un JtextField 
import javax.swing.text.PlainDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import java.awt.event.KeyEvent;

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
        //TextFiled del buscador mostrará sugerecias segun se escriba
        ArrayList<String> nombres= crudAlum.BuscarNombresAlumno();
        listaA.MostrarSugerencias(vista.txtBuscar, nombres);
        
        // carga de los elemento de todos los combos del frm
        listaA.cargaInicialCombos(vista.cbxFiltrarNivel, vista.cbxFiltrarGrado);
        listaA.cargaInicialCombos(vista.cbxNivel, vista.cbxGrado);
        listaA.cargarNiveles(vista.cbxFiltrarNivel);
        listaA.cargarNiveles(vista.cbxNivel);
        listaA.cargarEstados(vista.cbxFiltrarEstadoGrado);
        listaA.cargarEstados(vista.cbxEstadoGrado);
        listaA.cargarTiposDoc(vista.cbxTipoDoc);
        
        //cargamos las restricciones de los campos y combos del frm
        PermitirSoloLetras(vista.txtNombres);
        PermitirSoloLetras(vista.txtApellidoP);
        PermitirSoloLetras(vista.txtApellidoM);
        vista.txtNumDoc.setEditable(false);
        detectarCambioCombo(vista.cbxTipoDoc, vista.txtNumDoc);
        
        ActualizarLista();
        //Combos para filtrar
        CargarCombosEnlazados(vista.cbxFiltrarNivel,vista.cbxFiltrarGrado);
        //combos para ver y modificar datos de Alumno
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
        String[] filtros = definirFiltros();
        crudAlum.Listar(vista.tblListaAlumnos, vista.lblNumAlumnos,filtros);
        listaA.formatoColumnasTabla(vista.tblListaAlumnos);
    }
    
    public String[] definirFiltros(){
        String nivel=vista.cbxFiltrarNivel.getSelectedItem().toString();
        String grado=vista.cbxFiltrarGrado.getSelectedItem().toString();
        String estado=vista.cbxFiltrarEstadoGrado.getSelectedItem().toString();
        
        String[] filtros = crudAlum.Filtrar(nivel, grado,estado);
        return filtros;
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
    
    public boolean VerificarDatos( ArrayList<String> dataAlumno){
         for(String dato:dataAlumno){
             System.out.println(dato);
             if(dato.equals("0") || dato.equals("...")){
                 ListaAlumnos.msjDialog("Los campos no puden ser vacios o \"...\"");
                 return false;
             }
         }
         return true;
    }
    
    //metodo que permite ingresar solo letras y espacios en blaco en un txtField
    public void PermitirSoloLetras(JTextField campo){
        campo.setDocument(new PlainDocument() {
            @Override
            //sobreescribe este metodo para limitar los datos que se insertan
            public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
                // se verifica si lo que se inserta es nulo para salir del metodo con return
                if (str == null) {
                    return;
                }
                 
                //for que recorre cada uno de los caracteres de un string
                for (int i = 0; i < str.length(); i++) {
                    char c = str.charAt(i);
                    //se valida si el caracter es una letra, espacio en blanco o tecla retroceso
                    if (Character.isLetter(c) || Character.isWhitespace(c) || c == KeyEvent.VK_BACK_SPACE) {
                        //si es un caracter valido se inserta 
                        super.insertString(offset, String.valueOf(c), attr);
                        offset++;
                    }
                }
            }
        });
        
    }

    public void PermitirSoloNumeros(JTextField campo,int limit){
        campo.setDocument(new PlainDocument() {
                @Override
                public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {         
                    if (str == null) {
                        return;
                    }
                    /* Se comprueba si:
                    Lo ingresado contiene solo digitos con la expresion regular "\\d"  
                    La cant de digitos esta dentro del limite
                    */
                    if (str.matches("\\d+") && 
                            (limit <= 0 ||(getLength() + str.length() <= limit)) ) {
                        super.insertString(offset, str, attr);
                    }
                            
                    
                }
            }); 
        
    }

    public void detectarCambioCombo(JComboBox combo,JTextField campo){
        combo.addItemListener(new ItemListener() {
        int limit=0; 
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    /*Cada vez que se cambia de un item a otro dentro del combo
                    se limpia el campo
                    */
                    campo.setText("");
                    String tipoDoc=vista.cbxTipoDoc.getSelectedItem().toString();
                    
                    //si el tipoDoc es valido (diferente a "..." )
                    if( !("...".equals(tipoDoc)) ){
                        campo.setEditable(true);
                        // verificamos si es del tipo DNI o un tipo diferente
                        if ("DNI".equals(tipoDoc)) {
                             limit=8;
                             PermitirSoloNumeros(campo, 8);
                        } else {
                            limit=9;
                            PermitirSoloNumeros(campo, 9);
                        }
                    }else{
                        campo.setEditable(false);
                        PermitirSoloNumeros(campo, 0);
                    }
                }
            }
        });
        
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
            //1° obtenemos nombre completo del alumno
            String nombreAlumno = vista.txtBuscar.getText();
            //2° Se establcen los filtros de nivel, grado y estado para la busqueda
            String[] filtros = definirFiltros();
            //3° se establece el filtro para buscar por nombre
            filtros[2]="and concat(Nombres,' ',Apellido_P,' ',Apellido_M)='"+nombreAlumno+"'";
            //4° listamos al alumno en la tabla segun nombre,nivel,grado y estado
            crudAlum.Listar(vista.tblListaAlumnos, vista.lblNumAlumnos, filtros);
            //5° aplicamos un foramto de presentacion a la tabla
            listaA.formatoColumnasTabla(vista.tblListaAlumnos);
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
            ArrayList<String>data = listaA.leerAlumno(vista);
            boolean alumnoValido=VerificarDatos(data);
            if(alumnoValido){
                alum=new Alumno(data);
            }
            //insercion en la bd
            /*alum = new Alumno(leerAlumno());
            crudAlum.Insertar(alum);
            ActualizarLista();*/
            
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
