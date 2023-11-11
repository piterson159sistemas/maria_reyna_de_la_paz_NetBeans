
package Modelo;

import java.util.Date;


public class Tutoria {
    private Docente docente;
    private GradoAlumno grado;
    private Date anio;

    public Tutoria(Docente docente, GradoAlumno grado, Date anio) {
        this.docente = docente;
        this.grado = grado;
        this.anio = anio;
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

    public Date getAnio() {
        return anio;
    }

    public void setAnio(Date anio) {
        this.anio = anio;
    }
    
    
}
