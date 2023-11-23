
package Controlador;
import Modelo.Usuario;
import Vista.MenuDirec;
import Vista.asignar_area_directivo_1;
import Vista.asignar_tutor_directivo_1;
import Vista.crear_cuenta_docentes_directivo_1;
import Vista.gestionar_cuenta_docente_directivo_1;
import Vista.lista_estudiantes_directivo_1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class CMenuDirec implements ActionListener{
    MenuDirec vista;

    public CMenuDirec(MenuDirec menu){
        vista=menu;
        vista.ListaAlumnos.addActionListener(this);
        vista.Tutoria.addActionListener(this);
        vista.Area.addActionListener(this);
        vista.CD.addActionListener(this);
        vista.GDC.addActionListener(this);
        menu.setExtendedState(JFrame.MAXIMIZED_BOTH);
        menu.setDefaultCloseOperation(menu.EXIT_ON_CLOSE);
        menu.setVisible(true);
        menu.setTitle("Menu de Gestión Directivo");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==vista.ListaAlumnos){
            lista_estudiantes_directivo_1 lista = new lista_estudiantes_directivo_1();
            //CListadoAlumDirec cListaAlum = new CListadoAlumDirec(lista);
            vista.Panel.add(lista);
            
        }
        
        if(e.getSource()==vista.Tutoria){
            asignar_tutor_directivo_1 tutoria = new asignar_tutor_directivo_1();
            //CAsignarTutoria cTutoria = new CAsignarTutoria(tutoria);
            vista.Panel.add(tutoria);
        }
        
        if(e.getSource()==vista.Area){
            asignar_area_directivo_1 ard= new asignar_area_directivo_1();
           // CAsignarArea CAsignarArea = new CAsignarArea(ard);
            vista.Panel.add(ard);
        }
        
        if(e.getSource()==vista.CD){
            crear_cuenta_docentes_directivo_1 cdd = new crear_cuenta_docentes_directivo_1();
            //CRegistrarUs Cr = new CRegistrarUs(cdd);
            vista.Panel.add(cdd);
        }
        
        if(e.getSource()==vista.GDC){
            gestionar_cuenta_docente_directivo_1 asd = new gestionar_cuenta_docente_directivo_1();
           // CGestionarD xd = new CGestionarD(asd);
            vista.Panel.add(asd);
        }
    }
}
