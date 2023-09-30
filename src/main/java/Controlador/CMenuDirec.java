
package Controlador;
import Vista.MenuDirec;
import javax.swing.JFrame;

public class CMenuDirec {
    MenuDirec vista;
    
    public CMenuDirec(MenuDirec menu){
        vista=menu;
        menu.setExtendedState(JFrame.MAXIMIZED_BOTH);
        menu.setDefaultCloseOperation(menu.EXIT_ON_CLOSE);
        menu.setVisible(true);
        menu.setTitle("Menu de Gestión Directivo");
    }
}
