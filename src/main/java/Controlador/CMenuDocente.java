
package Controlador;
import DAO.IntoDocentes;
import Main.Main;
import VISTA_DIRECTIVO.Administrar;
import VISTA_DIRECTIVO.Asignar;
import VISTA_DOCENTE.MenuDocen;
import VISTA_DOCENTE.Registrar;
import VISTA_DOCENTE.Tutor;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class CMenuDocente implements ActionListener{
    MenuDocen vista;
    IntoDocentes intoDocente = new IntoDocentes();
    String codDocente;
    public CMenuDocente(MenuDocen menu, String codUsuario){
        vista=menu;
        codDocente=codUsuario;
        menu.setExtendedState(JFrame.MAXIMIZED_BOTH);
        //mostramos el codigo
        vista.lblCodUsuario.setText(codUsuario);
        //mostramos el nombre del usuario
        vista.lblNombreUsuario.setText("<html><center>"
                +intoDocente.obtenerNombreUsuario(codUsuario)+"</center></html>");
        menu.setVisible(true);
        menu.setTitle("Menu de Gestión Docente");
        vista.btnRegistrar.addActionListener(this);
        vista.btnTutor.addActionListener(this);
        vista.btnSalir.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==vista.btnRegistrar){//getSource
            System.out.println("administrar controlador");
            Registrar reg=new Registrar(codDocente); 
            vista.Principal.removeAll();
            vista.Principal.setLayout(new BorderLayout());
            vista.Principal.add(reg.getContentPane(),BorderLayout.CENTER);
            vista.Principal.revalidate();
            vista.Principal.repaint();
        }
        
        if(e.getSource()==vista.btnTutor){
            Tutor tut=new Tutor();
            vista.Principal.removeAll();
            vista.Principal.setLayout(new BorderLayout());
            vista.Principal.add(tut.getContentPane(),BorderLayout.CENTER);
            vista.Principal.revalidate();
            vista.Principal.repaint();
        }
        
        if(e.getSource()==vista.btnSalir){
            vista.dispose();
            Main.iniciarSesion();
        }
    }
}
