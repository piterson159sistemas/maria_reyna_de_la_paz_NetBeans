
package Modelo;
import java.util.Date;

public class GradoAlumno {
    private int anio;
    private String grado;
    private String nivel;
    private String estado;

    public GradoAlumno(int anio,String grado, String nivel,String estado) {
        this.anio = anio;
        this.grado = grado;
        this.nivel = nivel;
        this.estado=estado;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }
    
    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    
    public void RegistrarGrado(){}
    public void CrearCodigo(){}
    public void HacerReporte(){}
    
}
