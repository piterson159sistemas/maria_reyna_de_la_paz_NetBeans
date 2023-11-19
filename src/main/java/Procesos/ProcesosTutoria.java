package Procesos;

import DAO.crudAlumno;
import Vista.asignar_tutor_directivo_1;
import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import java.util.Queue;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ProcesosTutoria {
    String none="...";
    crudAlumno crudAlumno=new crudAlumno();
    
    
    public void limpiarCampos(asignar_tutor_directivo_1 frm){
        frm.txtAnio.setText("");
        frm.cbxTutor.setSelectedIndex(0);
        vaciarChekBox(frm);
    }
    
    public void vaciarChekBox(asignar_tutor_directivo_1 frm){
        JPanel[] paneles={frm.panelInicial,frm.panelPrimaria,frm.panelSecundaria};
        for(JPanel panel: paneles){
            for(Component checkBox: panel.getComponents()){
                ((JCheckBox) checkBox).setForeground(Color.BLACK);
                if( ((JCheckBox) checkBox).isSelected() ){
                    ((JCheckBox) checkBox).doClick();
                }
            }
        }
        
    }
    
    public ArrayList<String> leerDatos(asignar_tutor_directivo_1 frm){
        JPanel[] paneles={frm.panelInicial,frm.panelPrimaria,frm.panelSecundaria};
        ArrayList<String> data = new ArrayList<>();
        if(!frm.txtAnio.getText().isBlank()){
            data.add(frm.txtAnio.getText()); // 1° dato Año
        }else{
            data.add("0");
        }
        
        data.add(frm.cbxTutor.getSelectedItem().toString()); // 2° Nombre Docente
        
        for(JPanel panel: paneles){
            for(Component checkBox: panel.getComponents()){
                if(((JCheckBox) checkBox).isSelected()){
                    String grado=((JCheckBox) checkBox).getText();
                    //le colocamos una letra para identificar el Nivel al que pertenece el grado
                    if(panel.equals(paneles[0])){
                        grado+="I";
                    }else if(panel.equals(paneles[1])){
                        grado+="P";
                    }else{
                        grado+="S";
                    }
                    data.add(grado);
                }
            }
        }
        
        if(data.size()<3){
            data.add("...");
        }
        
        return data;
        
    }
    
    public void cargarDocentes(JComboBox combo,ArrayList<String> docentes){
        combo.removeAllItems();
        combo.addItem(none);
        for(String docente: docentes){
            combo.addItem(docente);
        }
    }
    
    public void cargarGrados(asignar_tutor_directivo_1 frm){
        JPanel[] paneles={frm.panelInicial,frm.panelPrimaria,frm.panelSecundaria};
        String nivel;
        for(JPanel panel:paneles){
            if(panel.equals(paneles[0])){
                nivel="Inicial";
            }else if(panel.equals(paneles[1])){
                nivel="Primaria";
            }else{
                nivel="Secundaria";
            }
            Queue<String> grados=crudAlumno.BuscarGrados(nivel);
            for(Component checkBox: panel.getComponents()){
                ((JCheckBox) checkBox).setText(grados.poll());
            }
        }
    }
    
    
}
