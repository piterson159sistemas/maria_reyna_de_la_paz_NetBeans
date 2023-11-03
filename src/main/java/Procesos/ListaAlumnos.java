
package Procesos;
import DAO.crudAlumno;
import Vista.lista_estudiantes_directivo_1;
import Modelo.Alumno;
import Modelo.Grado;
import Modelo.GradoAlumno;
import Modelo.Nivel;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Queue;
import java.util.Stack;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.JTextField;

public class ListaAlumnos {
    crudAlumno crudA=new crudAlumno();
    String all="..."; // los "..." indica filtrar todo
    
    public void leerAlumno(lista_estudiantes_directivo_1 led){
        
        JComponent campos[]= {led.txtNumDoc,led.cbxTipoDoc,led.txtNombres,
        led.txtApellidoP,led.txtApellidoM,led.cbxGrado,led.cbxNivel,led.cbxEstadoGrado};
        int numCampos= campos.length;
        
        ArrayList<String>data = new ArrayList<>();
        String dato;
        
        for (int i = 0; i < numCampos; i++) {
            if(campos[i] instanceof JTextField){
                data.add(i, ((JTextField)campos[i]).getText());
            }
            else {
                data.add(i, ((JComboBox)campos[i]).getSelectedItem().toString());
            }
        }
        
        Alumno alum=new Alumno(data);
        
    }
    
    public void MostrarAlumno(String[] data,lista_estudiantes_directivo_1 led){
        JComponent campos[]= {led.txtNumDoc,led.txtNombres,
        led.txtApellidoP,led.txtApellidoM,led.cbxTipoDoc, led.cbxNivel,
        led.cbxGrado,led.cbxEstadoGrado};
        int numCampos= campos.length;
        
        for (int i = 0; i < numCampos; i++) {
            if(campos[i] instanceof JTextField){
                ((JTextField)campos[i]).setText(data[i]);
            }else{
                ((JComboBox)campos[i]).setSelectedItem(data[i]);
            }
        }
    }
    
    public void formatoColumnasTabla (JTable tabla){
        tabla.getColumnModel().getColumn(0).setMaxWidth(0);
        tabla.getColumnModel().getColumn(0).setMinWidth(0);
        tabla.getColumnModel().getColumn(0).setPreferredWidth(0);
        tabla.getColumnModel().getColumn(1).setPreferredWidth(160);
        tabla.getColumnModel().getColumn(2).setPreferredWidth(60);
    }
    
    public void cargarNiveles(JComboBox cbxNiveles){
        Queue<String> niveles = crudA.BuscarNiveles();
        while(!niveles.isEmpty()){
            cbxNiveles.addItem(niveles.poll());
        }
    }
    
    public void cargarGrados(JComboBox cbxGrados,String nivel){
        Queue<String> grados = crudA.BuscarGrados(nivel);
        cbxGrados.addItem(all);
        while(!grados.isEmpty()){
            cbxGrados.addItem(grados.poll());
            
        }
        
    }
    
    public void cargaInicialCombos(JComboBox cbxNiveles,JComboBox cbxGrados){
        cbxNiveles.addItem(all);
        cbxGrados.addItem(all);
    }
    

}