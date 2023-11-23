
package Procesos;

import Controlador.CListadoAlumDirec;
import DAO.crudAlumnoNotas;
import VISTA_DIRECTIVO.Estudiante_Notas;
import java.util.ArrayList;
import javax.swing.JComboBox;

public class procesosAlumnoNotas {
    String none="...";
    crudAlumnoNotas crudANotas=new crudAlumnoNotas();
    
    public void cargarCombo(JComboBox combo,ArrayList<String> data){
        combo.removeAllItems();
        combo.addItem(none);
        for(String dato:data){
            combo.addItem(dato);
        }
    }
    
    public void cargaInicialCombos(Estudiante_Notas en){
       JComboBox[] combos={en.cbxNivel,en.cbxGrado,en.cbxPeriodo,en.cbxArea,en.cbxComp};  
       for(JComboBox combo: combos){
           combo.removeAllItems();
           combo.addItem(none);
       }
    }
    
}
