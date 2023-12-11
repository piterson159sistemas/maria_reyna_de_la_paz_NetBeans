
package Controlador;

import DAO.IntoDocentes;
import Main.Main;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import RSMaterialComponent.*;
import rsbuttom.RSButtonMetro;
import Modelo.*;
import VISTA_DIRECTIVO.Administrar;//importamos las vistas portadas de menu directivo
import VISTA_DIRECTIVO.Asignar;
import VISTA_DIRECTIVO.Docente;
import VISTA_DIRECTIVO.Estudiante;
import VISTA_DIRECTIVO.MenuDirec2; //importamos la vista del menu del directivo
import java.awt.BorderLayout;


public class CMenuDirec2 implements ActionListener{
    MenuDirec2 vista;
    IntoDocentes intoDocente= new IntoDocentes();
    
    public CMenuDirec2(MenuDirec2 menu,String codUsuario){
        vista=menu;
        menu.setExtendedState(JFrame.MAXIMIZED_BOTH);
        //mostramos el codigo
        vista.lblCodUsuario.setText(codUsuario);
        //mostramos el nombre del usuario
        vista.lblNombreUsuario.setText("<html><center>"+
                intoDocente.obtenerNombreUsuario(codUsuario)+"</center></html>");
        menu.setVisible(true);
        menu.setTitle("Menu de Gestión Directivo");
        vista.btnAdministrarCuentas.addActionListener(this);
        vista.btnAsignar.addActionListener(this);
        vista.btnDocente.addActionListener(this);
        vista.btnEstudiantes.addActionListener(this);
        vista.btnSalir.addActionListener(this);
    }
    
    //metodos para los eventos de los botones del menu vertical
    //formato (colores)
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==vista.btnAdministrarCuentas){//getSource
            System.out.println("administrar controlador");
            Administrar adm=new Administrar(); 
            vista.Principal.removeAll();
            vista.Principal.setLayout(new BorderLayout());
            vista.Principal.add(adm.getContentPane(),BorderLayout.CENTER);
            vista.Principal.revalidate();
            vista.Principal.repaint();
        }
        
        if(e.getSource()==vista.btnAsignar){
            Asignar asi=new Asignar();
            vista.Principal.removeAll();
            vista.Principal.setLayout(new BorderLayout());
            vista.Principal.add(asi.getContentPane(),BorderLayout.CENTER);
            vista.Principal.revalidate();
            vista.Principal.repaint();
        }
        
        if(e.getSource()==vista.btnDocente){
            Docente doc=new Docente();
            vista.Principal.removeAll();
            vista.Principal.setLayout(new BorderLayout());
            vista.Principal.add(doc.getContentPane(),BorderLayout.CENTER);
            vista.Principal.revalidate();
            vista.Principal.repaint();
        }
        
        if(e.getSource()==vista.btnEstudiantes){
            Estudiante est=new Estudiante();
            vista.Principal.removeAll();
            vista.Principal.setLayout(new BorderLayout());
            vista.Principal.add(est.getContentPane(),BorderLayout.CENTER);
            vista.Principal.revalidate();
            vista.Principal.repaint();
        }
        
        if(e.getSource()==vista.btnSalir){
            vista.dispose();
            Main.iniciarSesion();
        }
    }

    
}
