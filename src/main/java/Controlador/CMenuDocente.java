
package Controlador;
import DAO.IntoDocentes;
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
    
    public CMenuDocente(MenuDocen menu, String codUsuario){
        vista=menu;
        menu.setExtendedState(JFrame.MAXIMIZED_BOTH);
        menu.setDefaultCloseOperation(menu.EXIT_ON_CLOSE);
        menu.setVisible(true);
        menu.setTitle("Menu de Gestión Docente");
        vista.lblCodUsuario.setText(codUsuario); //mostramos el codigo
        vista.lblNombreUsuario.setText(intoDocente.obtenerNomCompletoUser(codUsuario)); //mostramos el nombre del usuario
        vista.btnRegistrar.addActionListener(this);
        vista.btnTutor.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==vista.btnRegistrar){//getSource
            System.out.println("administrar controlador");
            Registrar reg=new Registrar(); 
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
    }
}
