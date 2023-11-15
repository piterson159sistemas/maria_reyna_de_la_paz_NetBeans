
package Procesos;
import DAO.crudAlumno;
import Vista.lista_estudiantes_directivo_1;
import java.net.URL;
import java.util.ArrayList;
import java.util.Queue;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import org.jdesktop.swingx.autocomplete.ObjectToStringConverter;



public class ProcesosAlumnos {
    crudAlumno crudA=new crudAlumno();
    String none="..."; // los "..." indica ningun elemento seleccionado
    
    public ArrayList<String> leerAlumno(lista_estudiantes_directivo_1 led){
        
        JComponent campos[]= {led.txtNumDoc,led.cbxTipoDoc,led.txtNombres,
        led.txtApellidoP,led.txtApellidoM,led.txtAnio,led.cbxGrado,led.cbxNivel,
        led.cbxEstadoGrado};
        int numCampos= campos.length;
        
        ArrayList<String>data = new ArrayList<>();
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
        JComponent campos[]= {led.cbxTipoDoc,led.txtNombres,
        led.txtApellidoP,led.txtApellidoM,led.cbxNivel,led.cbxGrado,
        led.cbxEstadoGrado,led.txtAnio};
        
        int numCampos= campos.length;
        
        for (int i = 0; i < numCampos; i++) {
            if(campos[i] instanceof JTextField){
                ((JTextField)campos[i]).setText(data[i+1]);
            }else{
                ((JComboBox)campos[i]).setSelectedItem(data[i+1]);
            }
        }
        led.txtNumDoc.setText(data[0]);
    }
    
    
    
    public void formatoColumnasTabla (JTable tabla){
        tabla.getColumnModel().getColumn(0).setMaxWidth(0);
        tabla.getColumnModel().getColumn(0).setMinWidth(0);
        tabla.getColumnModel().getColumn(0).setPreferredWidth(0);
        
        tabla.getColumnModel().getColumn(1).setPreferredWidth(160);
        tabla.getColumnModel().getColumn(2).setPreferredWidth(60);
        
        tabla.getColumnModel().getColumn(3).setMaxWidth(0);
        tabla.getColumnModel().getColumn(3).setMinWidth(0);
        tabla.getColumnModel().getColumn(3).setPreferredWidth(0);
    }
    
    public void cargarNiveles(JComboBox cbxNiveles){
        Queue<String> niveles = crudA.BuscarNiveles();
        while(!niveles.isEmpty()){
            cbxNiveles.addItem(niveles.poll());
        }
    }
    
    public void cargarGrados(JComboBox cbxGrados,String nivel){
        Queue<String> grados = crudA.BuscarGrados(nivel);
        cbxGrados.addItem(none);
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
        cbxNiveles.addItem(none);
        cbxGrados.addItem(none);
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
    
    public void CargarIconoEstado(JTable tblAlumnos){
        tblAlumnos.setDefaultRenderer(Object.class, new ImgRender());
        
        
        URL url_Retirado = getClass().getResource("/img/Retirado.png");
        JLabel lblRetirado = new JLabel(new ImageIcon(url_Retirado));

        URL url_Aprobado = getClass().getResource("/img/Aprobado.png");
        JLabel lblAprobado = new JLabel(new ImageIcon(url_Aprobado));
        
        URL url_EnCurso = getClass().getResource("/img/EnCurso.png");
        JLabel lblEnCurso = new JLabel(new ImageIcon(url_EnCurso));

        URL url_Desaprobado = getClass().getResource("/img/Desaprobado.png");
        JLabel lblDesaprobado = new JLabel(new ImageIcon(url_Desaprobado));
        
        int numFilas=tblAlumnos.getRowCount();
        for(int i=0;i<numFilas;i++){
        String estado= tblAlumnos.getValueAt(i, 2).toString();
            switch (estado) {
                case "Aprobado"-> {tblAlumnos.setValueAt("",i, 2);
                                  tblAlumnos.setValueAt(lblAprobado,i, 2);}
                
                case "Desaprobado"-> {tblAlumnos.setValueAt("",i, 2);
                                  tblAlumnos.setValueAt(lblDesaprobado,i, 2);}
                
                case "En Curso"-> {tblAlumnos.setValueAt("",i, 2);
                                  tblAlumnos.setValueAt(lblEnCurso,i, 2);}
                
                default -> {tblAlumnos.setValueAt("",i, 2);
                                  tblAlumnos.setValueAt(lblRetirado,i, 2);}
            }
        }
    
    }
    
    public static void msjDialog(String mensaje){
        JOptionPane.showMessageDialog(null,mensaje);
    } 
    
}
