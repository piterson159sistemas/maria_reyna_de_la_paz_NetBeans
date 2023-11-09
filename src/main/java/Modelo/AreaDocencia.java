
package Modelo;

import java.util.ArrayList;


public class AreaDocencia {
    private Docente docente;
    private ArrayList<String> areas; 
    
    public AreaDocencia(Docente docente, ArrayList<String> area ) {
        this.docente = docente;
        this.areas = area;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public ArrayList<String> getArea() {
        return areas;
    }

    public void setArea(ArrayList<String> area) {
        this.areas = area;
    }


}
