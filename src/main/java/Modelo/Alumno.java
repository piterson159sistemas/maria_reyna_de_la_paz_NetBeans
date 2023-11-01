package Modelo;

import java.util.ArrayList;

public class Alumno extends Persona{
    private String TipoDocumento;
    GradoAlumno grado;
    
    public Alumno(int NumDocumento,String TipoDocumento,String Nombre,
            String ApellidoP, String ApellidoM) {
        super(NumDocumento, Nombre, ApellidoP, ApellidoM);
        this.TipoDocumento=TipoDocumento;
    }

    public Alumno(ArrayList<String>data){
        super(data);
    }

    public String getTipoDocumento() {
        return TipoDocumento;
    }

    public void setTipoDocumento(String TipoDocumento) {
        this.TipoDocumento = TipoDocumento;
    }

    public GradoAlumno getGrado() {
        return grado;
    }

    public void setGrado(GradoAlumno grado) {
        this.grado = grado;
    }
    
    public void RegistrarAlumno(){}
    public void AsignarGrado(){}
    public void OrdenarLista(){}
    public void Buscar(){}
    public void Actualizar(){}
    public void Eliminar(){}
}
