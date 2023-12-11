package Controlador;

import DAO.crudAlumnoNotas;
import Procesos.ProcesosAlumnos;
import VISTA_DIRECTIVO.Estudiante_Notas;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class CAlumnoNotas{

    Estudiante_Notas vista;
    crudAlumnoNotas crudANotas = new crudAlumnoNotas();
    ProcesosAlumnos procesosAux= new ProcesosAlumnos();
    
    public CAlumnoNotas(Estudiante_Notas estNotas){
        vista=estNotas;
        procesosAux.cargarNiveles(vista.cbxNivel);
        ArrayList<String> periodos=crudANotas.buscarPeriodos();
        procesosAux.CargarCombosEnlazados(vista.cbxNivel, vista.cbxGrado, vista.cbxArea);
        procesosAux.CargarCombosEnlazadosAreas( vista.cbxArea,vista.cbxComp);
        CargarNombreCompetencia(vista.cbxComp);
        CargarAreaPeriodo(vista.cbxArea, vista.cbxPeriodo);
    }
    
    public void CargarNombreCompetencia(JComboBox cbxComp){ 
        
        cbxComp.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange()==ItemEvent.SELECTED){
                    String CompSelect = cbxComp.getSelectedItem().toString();
                    vista.lblNomCompetencia.setText(CompSelect);
                }
            }
        });

    }
    
    public void CargarAreaPeriodo(JComboBox cbxArea,JComboBox cbxPeriodo){ 
        
        cbxArea.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange()==ItemEvent.SELECTED){
                    String AreaSelect = cbxArea.getSelectedItem().toString();
                    vista.lblCurso.setText("Curso: "+AreaSelect);
                }
            }
        });
        
        cbxPeriodo.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange()==ItemEvent.SELECTED){
                    String periodoSelect = cbxPeriodo.getSelectedItem().toString();
                    String infArea=vista.lblNomCompetencia.getText();
                    vista.lblPeriodo.setText("Periodo: "+periodoSelect);
                    
                }
            }
        });
    }
   

    
}
