
package Controlador;
import Vista.MenuDocente;
import javax.swing.JFrame;

public class CMenuDocente {
    MenuDocente vista;
    
    public CMenuDocente(MenuDocente menu){
        vista=menu;
        menu.setExtendedState(JFrame.MAXIMIZED_BOTH);
        menu.setDefaultCloseOperation(menu.EXIT_ON_CLOSE);
        menu.setVisible(true);
        menu.setTitle("Menu de Gestión Docente");
    }
}
