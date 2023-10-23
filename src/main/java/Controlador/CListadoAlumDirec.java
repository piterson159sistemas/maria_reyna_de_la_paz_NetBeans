
package Controlador;
import DAO.crudAlumno;
import Modelo.Alumno;
import Vista.lista_estudiantes_directivo_1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

public class CListadoAlumDirec implements ActionListener{
    lista_estudiantes_directivo_1 vista;
    Alumno alum;
    crudAlumno crudAlum = new crudAlumno();;


    public CListadoAlumDirec(lista_estudiantes_directivo_1 listaEst) {
        vista=listaEst;
        vista.btnBuscar.addActionListener(this);
        vista.btnBorrar.addActionListener(this);
        vista.btnInsertar.addActionListener(this);
        vista.btnActualizar.addActionListener(this);
        listaEst.setTitle("Gestion de Estudiantes");
        listaEst.setVisible(true);
        Actualizarlista();
    }

    public  ArrayList<String> leerAlumno(){
        JComponent campos[]= {vista.cbxTipoDoc,vista.txtNumDoc,vista.txtNombres,
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
    
    public void Actualizarlista(){
        Stack<String> Alumnos = crudAlum.Listar();
        DefaultListModel<String> listModel = new DefaultListModel<>();;
        Iterator<String> iterator = Alumnos.iterator();

        while (iterator.hasNext()) {
            String Alumno = iterator.next();
            listModel.addElement(Alumno);
            iterator.remove(); 
        }
        vista.List.setModel(listModel);
    }
    
    public void mostraAlumno(ArrayList<String> data){
        JComponent campos[]= {vista.cbxTipoDoc,vista.txtNumDoc,vista.txtNombres,
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

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==vista.btnBuscar){
            //falta
            int NumDoc = Integer.parseInt(vista.txtSearch.getText());
            ArrayList<String> dataAlumno = crudAlum.Buscar(NumDoc);
            mostraAlumno(dataAlumno);            
        }
        
        if(e.getSource()==vista.btnActualizar){
            int NumDoc = Integer.parseInt(vista.txtSearch.getText());
            alum = new Alumno(leerAlumno());
            crudAlum.Actualizar(alum);
            Actualizarlista();
        }
        
        if(e.getSource()==vista.btnBorrar){
            int NumDoc = Integer.parseInt(vista.txtSearch.getText());
            crudAlum.Eliminar(NumDoc);
            Actualizarlista();
        }
        
        if(e.getSource()==vista.btnInsertar){
            alum = new Alumno(leerAlumno());
            crudAlum.Insertar(alum);
            Actualizarlista();
            
        }
    }
    
    
    
    
    
}
