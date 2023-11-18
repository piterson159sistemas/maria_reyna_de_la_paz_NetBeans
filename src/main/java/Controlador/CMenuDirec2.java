
package Controlador;

import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Animacion.Animacion;
import RSMaterialComponent.*;
import rsbuttom.RSButtonMetro;
import Modelo.*;
import Vista.MenuDirec2;
import Vista.AdministrarCuenta.Principal;
//import Vista.Asignar.Principal;
//import Vista.Docente.Principal;
//import Vista.Estudiantes.Principal;


public class CMenuDirec2 implements ActionListener{
    MenuDirec2 vista;
    
    public CMenuDirec2(MenuDirec2 menu){
        vista=menu;
        menu.setExtendedState(JFrame.MAXIMIZED_BOTH);
        menu.setDefaultCloseOperation(menu.EXIT_ON_CLOSE);
        menu.setVisible(true);
        menu.setTitle("Menu de Gestión Directivo");
        vista.btnAdministrarCuentas.addActionListener(this);
        vista.btnAsignar.addActionListener(this);
        vista.btnDocente.addActionListener(this);
        vista.btnEstudiantes.addActionListener(this);
    }
    
    //metodos para los eventos de los botones del menu vertical
    //formato (colores)
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==vista.btnAdministrarCuentas){//getSource
            Vista.AdministrarCuenta.Principal admi = new Vista.AdministrarCuenta.Principal();
            
        }
    }

    
}
