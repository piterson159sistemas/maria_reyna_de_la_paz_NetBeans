
package Modelo;

import java.util.ArrayList;


public class AreaDocencia {
    private Docente docente;
    private String area; 
    
    public AreaDocencia(Docente docente, String area ) {
        this.docente = docente;
        this.area = area;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }


}
