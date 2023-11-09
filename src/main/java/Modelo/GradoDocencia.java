package Modelo;

import java.util.ArrayList;


public class GradoDocencia {
    private AreaDocencia areDocencia;
    private int grado;
    private ArrayList<GradoAlumno> grados; 

    public GradoDocencia(AreaDocencia areDocencia, int grado, ArrayList<GradoAlumno> grados) {
        this.areDocencia = areDocencia;
        this.grado = grado;
        this.grados = grados;
    }

    public AreaDocencia getAreDocencia() {
        return areDocencia;
    }

    public void setAreDocencia(AreaDocencia areDocencia) {
        this.areDocencia = areDocencia;
    }

    public int getGrado() {
        return grado;
    }

    public void setGrado(int grado) {
        this.grado = grado;
    }

    public ArrayList<GradoAlumno> getGrados() {
        return grados;
    }

    public void setGrados(ArrayList<GradoAlumno> grados) {
        this.grados = grados;
    }
    
    
    
    
}
