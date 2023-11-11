
package Controlador;
import Modelo.Usuario;
import Vista.MenuDirec;
import Vista.asignar_tutor_directivo_1;
import Vista.crear_cuenta_docentes_directivo_1;
import Vista.lista_estudiantes_directivo_1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class CMenuDirec implements ActionListener{
    MenuDirec vista;

    public CMenuDirec(MenuDirec menu){
        vista=menu;
        vista.jmiListaAlumnos.addActionListener(this);
        vista.jmiTutoria.addActionListener(this);
        vista.CD.addActionListener(this);
        menu.setExtendedState(JFrame.MAXIMIZED_BOTH);
        menu.setDefaultCloseOperation(menu.EXIT_ON_CLOSE);
        menu.setVisible(true);
        menu.setTitle("Menu de Gestión Directivo");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==vista.jmiListaAlumnos){
            lista_estudiantes_directivo_1 lista = new lista_estudiantes_directivo_1();
            CListadoAlumDirec cListaAlum = new CListadoAlumDirec(lista);
            vista.Panel.add(lista);
            
        }
        
        if(e.getSource()==vista.jmiTutoria){
            asignar_tutor_directivo_1 tutoria = new asignar_tutor_directivo_1();
            CAsignarTutoria cTutoria = new CAsignarTutoria(tutoria);
            vista.Panel.add(tutoria);
        }
                if(e.getSource()==vista.CD){
            crear_cuenta_docentes_directivo_1 cdd = new crear_cuenta_docentes_directivo_1();
            CRegistrarUs Cr = new CRegistrarUs(cdd);
            vista.Panel.add(cdd);
        }
    }
}
