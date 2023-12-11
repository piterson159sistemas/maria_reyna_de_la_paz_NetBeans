package Procesos;

import DAO.DAOHorario;
import VISTA_DIRECTIVO.Asignar_Horario;

import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.Border;

public class ProcesosHorario {
    DAOHorario daoHora=new DAOHorario();
    Color color=null;
    String none="...";
    
    public void seleccionaColor(){
        // Abre un selector de color (puedes personalizar esto según tus necesidades)
        color = JColorChooser.showDialog(null, "Seleccionar color", Color.RED);
    }
    
    public void aplicarColor(JButton boton){
        // Verifica si se ha seleccionado un color antes de aplicarlo
        if (color != null) {
            // Aplica el color al fondo del botón especificado
            boton.setBackground(color);
            
            System.out.println("color seleccionado: " + color);
        } else {
            // Manejo si no se ha seleccionado un color
            System.out.println("Por favor, selecciona un color antes de aplicar.");
        }
    }
    public Color devolverColor(){
        return color;
    }
    public void aplicarColor2(JButton boton, Color color, String colorString){
        
        // Verifica si se ha seleccionado un color antes de aplicarlo
        if (color != null && colorString != null) {
            //aplica el texto al boton
            boton.setText(colorString);
            //setBordeNegro(boton);
            // Aplica el color al fondo del botón especificado
            boton.setBackground(color);
            System.out.println("color seleccionado" + color);
            // Imprime el valor del color en consola
            System.out.println("Color aplicado a " + boton.getName() + ": " + colorString);
        } else {
            // Manejo si no se ha seleccionado un color
            System.out.println("Por favor, selecciona un color antes de aplicar.");
        }
    }
    
    public void cargaInicialCombo(JComboBox combo){
        combo.removeAll();
        combo.addItem(none);
    }
    
    public void cargarGrados(JComboBox combo, ArrayList<String> grados){
        combo.removeAllItems();
        combo.addItem(none);
        for (String grado: grados) {
            combo.addItem(grado);
        }
    }
    
    public void setBordeNegro(JButton boton) {
        // Crea un borde negro y lo establece en el botón
        Border bordeNegro = BorderFactory.createLineBorder(Color.BLACK, 2);
        boton.setBorder(bordeNegro);
    }
    
    //con fe me sale
    
    
    
    
    
    
    
    /*public ArrayList<Integer> leerCodHorario(){
        ArrayList<Integer> codHorario=new ArrayList<>();
        String dia="Lunes";
        
        
    }*/
    
    
}
