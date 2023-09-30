
package Modelo;
    

public class Usuario extends Persona{
    private String codigo;
    private String clave;
    private String Preg1, Preg2, Preg3, Preg4, Preg5;
    private String Resp1, Resp2, Resp13, Resp14, Resp15;
    
    public Usuario(String Nombre, String ApellidoP, String ApellidoM, 
                   String TipoDocumento, int NumDocumento,String codigo, String clave){
        
        super(Nombre, ApellidoP, ApellidoM, TipoDocumento, NumDocumento);
        this.codigo=codigo;
        this.clave=clave;
    }
    
    public Usuario(String codigo, String clave){
        this.codigo=codigo;
        this.clave=clave;
    }

}
