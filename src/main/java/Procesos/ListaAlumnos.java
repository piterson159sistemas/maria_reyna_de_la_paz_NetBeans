
package Procesos;
import Vista.lista_estudiantes_directivo_1;
import Modelo.Alumno;
import Modelo.Grado;
import Modelo.GradoAlumno;
import Modelo.Nivel;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JTextField;

public class ListaAlumnos {
    
    public static void leerAlumno(lista_estudiantes_directivo_1 led){
        
        JComponent campos[]= {led.txtNumDoc,led.cbxTipoDoc,led.txtNombres,
        led.txtApellidoP,led.txtApellidoM,led.cbxGrado,led.cbxNivel,led.cbxEstadoGrado};
        int numCampos= campos.length;
        
        ArrayList<String>data = new ArrayList<>();
        String dato;
        
        for (int i = 0; i < numCampos; i++) {
            if(campos[i] instanceof JTextField){
                dato= ((JTextField)campos[i]).getText();
            }
            else {
                dato= ((JComboBox)campos[i]).getSelectedItem().toString();
            }
        }
        
        Alumno alum=new Alumno(data);
        
    }
    

}
