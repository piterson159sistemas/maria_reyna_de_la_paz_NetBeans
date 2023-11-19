package Modelo;

import java.util.ArrayList;


public class GradoDocencia {
    private int anio;
    private GradoAlumno grado;
    private AreaDocencia areDocencia;

    public GradoDocencia(int anio, GradoAlumno grado, AreaDocencia areDocencia) {
        this.anio = anio;
        this.grado = grado;
        this.areDocencia = areDocencia;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public GradoAlumno getGrado() {
        return grado;
    }

    public void setGrado(GradoAlumno grado) {
        this.grado = grado;
    }

    public AreaDocencia getAreDocencia() {
        return areDocencia;
    }

    public void setAreDocencia(AreaDocencia areDocencia) {
        this.areDocencia = areDocencia;
    }

    @Override
    public String toString() {
        return anio+" "+getGrado().getGrado()+" "+getAreDocencia().getDocente().getCodigo()
                +" "+getAreDocencia().getArea();
    }
 
    
}
