
package Procesos;
import DAO.crudAlumno;
import Vista.lista_estudiantes_directivo_1;
import java.util.ArrayList;
import java.util.Queue;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import org.jdesktop.swingx.autocomplete.ObjectToStringConverter;



public class ProcesosAlumnos {
    crudAlumno crudA=new crudAlumno();
    String all="..."; // los "..." indica filtrar todo
    
    public ArrayList<String> leerAlumno(lista_estudiantes_directivo_1 led){
        
        JComponent campos[]= {led.txtNumDoc,led.cbxTipoDoc,led.txtNombres,
        led.txtApellidoP,led.txtApellidoM,led.txtAnio,led.cbxGrado,led.cbxNivel,
        led.cbxEstadoGrado};
        int numCampos= campos.length;
        
        ArrayList<String>data = new ArrayList<>();
        String dato;
        boolean campoVacio;
                
        
        for (int i = 0; i < numCampos; i++) {
            if(campos[i] instanceof JTextField){
                campoVacio= ((JTextField)campos[i]).getText().isBlank();
                if(!campoVacio )
                    data.add(i, ((JTextField)campos[i]).getText());
                else 
                    data.add("0");
            }
            else {
                data.add(i, ((JComboBox)campos[i]).getSelectedItem().toString());

            }
        }
        return data;
    }
    
    
    //muestra sugerencias de autocompletado de nombres en la barra de busqueda
    public void MostrarSugerencias(JTextField campo,ArrayList<String> nombresAlumnos){
         AutoCompleteDecorator.decorate(campo, nombresAlumnos, false);
    }
    
    //muestra en el frm todos los datos del alumno seleccionado de la tabla 
    public void MostrarAlumno(String[] data,lista_estudiantes_directivo_1 led){
        JComponent campos[]= {led.txtNumDoc,led.cbxTipoDoc,led.txtNombres,
        led.txtApellidoP,led.txtApellidoM,led.cbxNivel,led.cbxGrado,
        led.cbxEstadoGrado,led.txtAnio};
        
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
    
    public void cargarEstados(JComboBox cbxEstados){
        String[] estados={"...","Aprobado","En Curso","Desaprobado","Retirado"};
        for(String estado:estados){
            cbxEstados.addItem(estado);
        }
    }
    
    public void cargarTiposDoc(JComboBox cbxTiposDoc){
        String[] tiposDoc={"...","DNI","Carnet de extranjeria","Pasaporte"};
        for(String tipo:tiposDoc){
            cbxTiposDoc.addItem(tipo);
        }
        
    }
    
    public void cargaInicialCombos(JComboBox cbxNiveles,JComboBox cbxGrados){
        cbxNiveles.addItem(all);
        cbxGrados.addItem(all);
    }
    
    public void Limpiarcampos(lista_estudiantes_directivo_1 led){
        JComponent campos[]= {led.txtNumDoc,led.cbxTipoDoc,led.txtNombres,
            led.txtApellidoP,led.txtApellidoM,led.cbxNivel,led.cbxGrado,
            led.cbxEstadoGrado,led.txtAnio};
        
            int numCampos= campos.length;
        
            for (int i = 0; i < numCampos; i++) {
                if(campos[i] instanceof JTextField){
                    ((JTextField)campos[i]).setText("");
                }else{
                    ((JComboBox)campos[i]).setSelectedItem("...");
                }
            }
        
    }
    
    public static void msjDialog(String mensaje){
        JOptionPane.showMessageDialog(null,mensaje);
    } 
    
}