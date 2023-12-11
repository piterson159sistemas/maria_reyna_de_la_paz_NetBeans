
package Modelo;

import java.util.List;


public class Usuario extends Persona implements Modificable, Registrable{
    public String codigo;
    protected String clave;
    private String Preg[]=new String[3];
    private String Resp[]=new String[3];
    private List<String> areas;
    
    public Usuario(String codigo, String clave){
        this.codigo=codigo;
        this.clave=clave;
    }

    public Usuario(int NumDocumento, 
            String Nombre, String ApellidoP, String ApellidoM) {
        super(NumDocumento, Nombre, ApellidoP, ApellidoM);
    }
    
    public Usuario(String Nombre){
        super(Nombre);
    }
    
    public List<String> getAreas() {
        return areas;
    }
    
    public void setAreas(List<String> areas) {
        this.areas = areas;
    }

       // Constructor sin argumentos
    public Usuario() {
        // Inicializa el objeto sin argumentos
        super(0, "", "", "");
        this.codigo = "";
    }
    
//    public String getarea(){
//        return area;
//    }
//    
//    public void setarea(String area){
//        this.area = area;
//    }
    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String[] getPreg() {
        return Preg;
    }

    public void setPreg(String[] Preg) {
        this.Preg = Preg;
    }

    public String[] getResp() {
        return Resp;
    }

    public void setResp(String[] Resp) {
        this.Resp = Resp;
    }

    @Override
    public void cambioContraseña() {
           }

    @Override
    public void crearCodigo() {

    }

    @Override
    public void Actualizar() {

    }

    public String ValidarTipoUsuario(String cod){
        
            if (cod.startsWith("D") || cod.startsWith("d") ) {return "DIRECTOR"; } 
            else {return "PROFESOR"; }
}

}
