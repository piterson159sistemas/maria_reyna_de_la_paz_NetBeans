
package Modelo;

public class Grado {
    public int CodigoGrado;
    public String Grado;
    public String Tutor;
    public int año;
    public String Area;

    public Grado(int CodigoGrado, String Grado, String Tutor, int año, String Area) {
        this.CodigoGrado = CodigoGrado;
        this.Grado = Grado;
        this.Tutor = Tutor;
        this.año = año;
        this.Area = Area;
    }

    public int getCodigoGrado() {
        return CodigoGrado;
    }

    public void setCodigoGrado(int CodigoGrado) {
        this.CodigoGrado = CodigoGrado;
    }

    public String getGrado() {
        return Grado;
    }

    public void setGrado(String Grado) {
        this.Grado = Grado;
    }

    public String getTutor() {
        return Tutor;
    }

    public void setTutor(String Tutor) {
        this.Tutor = Tutor;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public String getArea() {
        return Area;
    }

    public void setArea(String Area) {
        this.Area = Area;
    }
    public void RegistrarGrado(){}
    public void CrearCodigo(){}
    public void HacerReporte(){}
    
}
