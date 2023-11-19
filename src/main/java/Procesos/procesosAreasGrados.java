package Procesos;

import DAO.crudAreasGrados;
import Vista.asignar_area_directivo_1;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JLabel;

public class procesosAreasGrados {

    String none = "..."; // los "..." indica ningun elemento seleccionado
    crudAreasGrados crudAG = new crudAreasGrados();

    public void cargarDocentes(JComboBox combo, int codArea) {
        ArrayList<String> docentes = crudAG.BuscarDocente(codArea);
        combo.removeAllItems();
        combo.addItem(none);
        for (String docente : docentes) {
            combo.addItem(docente);
        }
    }

    public void cargarDocentes(JComboBox combo, String opcion,int anio) {
        ArrayList<String> docentes = crudAG.BuscarDocente(opcion,anio);
        combo.removeAllItems();
        combo.addItem(none);
        for (String docente : docentes) {
            combo.addItem(docente);
        }
    }

    public void cargarAreas(JLabel[] nombreAreas, String nivel) {
        ArrayList<String> areas = crudAG.buscarAreas(nivel);
        int lastIndex = nombreAreas.length - 1;
        for (int i = 0; i <= lastIndex; i++) {
            nombreAreas[i].setText(areas.get(i));
        }
        if (nivel.equals("Secundaria")) {
            String edT="<html>Educacion para<br>el trabajo</html>";
            String codedT="";
            String PCC="<html>Desarrollo Personal,<br>Ciudadania y Civica</html>";
            String codPCC="";
            String nombreFormateado = "<html>"
                    + nombreAreas[0].getText().substring(0, 14)
                    + "<br>" + nombreAreas[0].getText().substring(14) + "</html>";
            nombreAreas[0].setText(nombreFormateado);

            String nombreFormateado2 = "<html>"
                    + nombreAreas[2].getText().substring(0, 20)
                    + "<br>" + nombreAreas[2].getText().substring(20) + "</html>";
            nombreAreas[2].setText(nombreFormateado2);
        }
    }

    public Component[] UbicarCombosVentana(int indiceVentana, asignar_area_directivo_1 frm) {
        Component[] Elementos;
        switch (indiceVentana) {
            case 0 ->
                Elementos = frm.Inicial.getComponents();
            case 1 ->
                Elementos = frm.Primaria.getComponents();
            default ->
                Elementos = frm.Secundaria.getComponents();
        }
        return Elementos;
    }

    public void limpiarCampos(int indiceVentana, asignar_area_directivo_1 frm) {
        frm.txtAnio.setText(String.valueOf(0));
        Component[] comboBoxes = UbicarCombosVentana(indiceVentana, frm);
        for (Component comboBox : comboBoxes) {
            if (comboBox instanceof JComboBox) {
                ((JComboBox) comboBox).setSelectedItem("...");
            }
        }

    }

    public ArrayList<String> leerCampos(int indiceVentana, asignar_area_directivo_1 frm) {
        ArrayList<String> data = new ArrayList<>();
        if (!frm.txtAnio.getText().isBlank()) {
            data.add(frm.txtAnio.getText()); // 1° dato: Año
        } else {
            data.add("0");
        }
        //2° dato: Grado
        Component[] elementos = UbicarCombosVentana(indiceVentana, frm);
        if (elementos[0] instanceof JComboBox) {
            data.add(((JComboBox) elementos[0]).getSelectedItem().toString());
        }
        
        // 3° dato: combinacion {Area,Docente}
        ArrayList<String> dataAreDocente = obtenerAreaDocente(indiceVentana, frm);
        for(String dato:dataAreDocente){
            data.add(dato);
        }
        return data;
    }

    public int obtenerCantAreas(int indiceVentana, asignar_area_directivo_1 frm) {
        int cantAreas = 0;
        Component[] elementos = UbicarCombosVentana(indiceVentana, frm);
        for (Component elemento : elementos) {
            if (elemento instanceof JLabel) {
                cantAreas++;
                
            }
        }
        cantAreas-=4; // se resta 4 porque 4 JLabels no son nombres de areas solo son informativas
        
        
        return cantAreas;
    }
    
    public ArrayList<String> obtenerAreaDocente(int indiceVentana, asignar_area_directivo_1 frm){
        ArrayList<String> AreaDocente = new ArrayList<>();
        ArrayList<String> Area = new ArrayList<>();
        ArrayList<String> Docente = new ArrayList<>();
        Component[] elementos = UbicarCombosVentana(indiceVentana, frm);
        int cont=0;
        for (Component elemento : elementos) {
            if (elemento instanceof JLabel) {
                Area.add(((JLabel) elemento).getText());
            }
        }
        
        for(int i=0;i<=3;i++){
            Area.remove(0);

        }

        for (Component elemento : elementos) {
            if (elemento instanceof JComboBox) {
                if (elemento.isVisible()) {
                    Docente.add(((JComboBox) elemento).getSelectedItem().toString());
                }
            }
        }
        Docente.remove(0);

        switch (Docente.size()) {
            case 2 -> {
                for(int j=0;j<8;j++){
                    AreaDocente.add(Area.get(j)+","+Docente.get(0));
                }
                AreaDocente.add(Area.get(8)+","+Docente.get(1));
            }
            case 3 ->{
                for(int j=0;j<7;j++){
                    AreaDocente.add(Area.get(j)+","+Docente.get(0));
                }   
                AreaDocente.add(Area.get(7)+","+Docente.get(1));
                AreaDocente.add(Area.get(8)+","+Docente.get(2));
            }
            default -> {
                for(int j=0;j<Area.size();j++){
                    AreaDocente.add(Area.get(j)+","+Docente.get(j));
                } 
            }
        }

        return AreaDocente;
    }

}
