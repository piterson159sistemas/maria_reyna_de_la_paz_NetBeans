package Modelo;

import java.util.ArrayList;

public class Alumno extends Persona{
    GradoAlumno grado;
    
    public Alumno(String TipoDocumento, int NumDocumento, String Nombre, String ApellidoP, String ApellidoM) {
        super(TipoDocumento, NumDocumento, Nombre, ApellidoP, ApellidoM);
    }
    
    public Alumno(ArrayList<String>data){
        super(data);
    }

    public void RegistrarAlumno(){}
    public void AsignarGrado(){}
    public void OrdenarLista(){}
    public void Buscar(){}
    public void Actualizar(){}
    public void Eliminar(){}
}
