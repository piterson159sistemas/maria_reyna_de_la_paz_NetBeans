///asd
package Controlador;
import Vista.asignar_tutor_directivo_1;

public class CAsignarTutoria {
    asignar_tutor_directivo_1 vista;
    
    public CAsignarTutoria(asignar_tutor_directivo_1 tutoria){
        vista=tutoria;
        tutoria.setTitle("Asignacion de Tutoria");
        tutoria.setVisible(true);
    }

}
