
package Modelo;

import java.util.ArrayList;
import java.util.Date;


public class Tutoria {
    private int anio;
    private Docente docente;
    private GradoAlumno grado;

    public Tutoria(int anio,Docente docente, GradoAlumno grado) {
        this.anio = anio;
        this.docente = docente;
        this.grado = grado;
    }


    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public GradoAlumno getGrado() {
        return grado;
    }

    public void setGrado(GradoAlumno grado) {
        this.grado = grado;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }
    
    
}
