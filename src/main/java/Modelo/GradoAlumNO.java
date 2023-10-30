
package Modelo;

import java.util.Date;

public class GradoAlumno {
    private Nivel nivel;
    private Grado grado;
    private Date Anio;
    private String Estado;

    public GradoAlumno(Nivel nivel,Grado grado, Date Anio) {
        this.nivel = nivel;
        this.grado = grado;
        this.Anio = Anio;
    }

    public Nivel getNivel() {
        return nivel;
    }

    public void setNivel(Nivel nivel) {
        this.nivel = nivel;
    }

    public Grado getGrado() {
        return grado;
    }

    public void setGrado(Grado grado) {
        this.grado = grado;
    }

    public Date getAnio() {
        return Anio;
    }

    public void setAnio(Date Anio) {
        this.Anio = Anio;
    }
    
    public void RegistrarGrado(){}
    public void CrearCodigo(){}
    public void HacerReporte(){}

    
}
