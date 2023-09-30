package Modelo;

import java.util.Collection;

public class Docente extends Usuario{

               
    public Collection<Area> Areas;

    public Docente(String Nombre, String ApellidoP, String ApellidoM, 
                   String TipoDocumento, int NumDocumento, String codigo, String clave){
        super(Nombre, ApellidoP, ApellidoM, TipoDocumento, NumDocumento, codigo, clave);
    }
    
            

    /*
    public Docente(String Pregunta1, String Pregunta2, String Pregunta3, String Pregunta4, String Pregunta5, String Respuesta1, String Respuesta2, String Respuesta3, String Respuesta4, String Respuesta5, String Area) {
    this.Pregunta1 = Pregunta1;
    this.Pregunta2 = Pregunta2;
    this.Pregunta3 = Pregunta3;
    this.Pregunta4 = Pregunta4;
    this.Pregunta5 = Pregunta5;
    this.Respuesta1 = Respuesta1;
    this.Respuesta2 = Respuesta2;
    this.Respuesta3 = Respuesta3;
    this.Respuesta4 = Respuesta4;
    this.Respuesta5 = Respuesta5;
    this.Area = Area;
    }
     */
    
   
    
    public void RegisDocente(){}
    public void CrearCodigo(){}
    public void RegistrarPreguntas(){}
    public void CambiarContraseña(){}
    public void Actualizar(){}
    public void Eliminar(){}
}
