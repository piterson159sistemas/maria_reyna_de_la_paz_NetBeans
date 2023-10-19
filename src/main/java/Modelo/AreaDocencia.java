
package Modelo;


public class AreaDocencia {
    private Docente docente;
    private Area area;
    private GradoAlum grado;

    public AreaDocencia(Docente docente, Area area, GradoAlum grado) {
        this.docente = docente;
        this.area = area;
        this.grado = grado;
    }

    
    
    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public GradoAlum getGrado() {
        return grado;
    }

    public void setGrado(GradoAlum grado) {
        this.grado = grado;
    }
    
    
    
}