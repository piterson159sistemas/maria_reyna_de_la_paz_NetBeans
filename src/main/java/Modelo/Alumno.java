package Modelo;

import java.awt.GradientPaint;
import java.time.LocalDate;
import java.util.ArrayList;

public class Alumno extends Persona{
    private String TipoDocumento;
    GradoAlumno gradoAlumno;

    public Alumno(String TipoDocumento, int NumDocumento, String Nombre, String ApellidoP, String ApellidoM) {
        super(NumDocumento, Nombre, ApellidoP, ApellidoM);
        this.TipoDocumento = TipoDocumento;
    }

   


    public Alumno(ArrayList<String>data){
        super(data);
        this.TipoDocumento=data.get(1);
        int anio = LocalDate.now().getYear();
        this.gradoAlumno=new GradoAlumno(anio,data.get(5),
                                    data.get(6),data.get(7));
    }

    public String getTipoDocumento() {
        return TipoDocumento;
    }

    public void setTipoDocumento(String TipoDocumento) {
        this.TipoDocumento = TipoDocumento;
    }

    public GradoAlumno getGrado() {
        return gradoAlumno;
    }

    public void setGrado(GradoAlumno gradoAlumno) {
        this.gradoAlumno = gradoAlumno;
    }
    
    public void RegistrarAlumno(){}
    public void AsignarGrado(){}
    public void OrdenarLista(){}
    public void Buscar(){}
    public void Actualizar(){}
    public void Eliminar(){}
}
