
package Modelo;


public class Usuario extends Persona implements Modificable, Registrable{
    protected String codigo;
    protected String clave;
    private String Preg[]=new String[3];
    private String Resp[]=new String[3];
    
    public Usuario(String codigo, String clave){
        this.codigo=codigo;
        this.clave=clave;
    }

    public Usuario(String TipoDocumento, int NumDocumento, 
            String Nombre, String ApellidoP, String ApellidoM) {
        super(TipoDocumento, NumDocumento, Nombre, ApellidoP, ApellidoM);
    }


    

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
        
        //boolean usuarioValido = codigo.equals(userData[0]) && clave.equals(userData[1]);
        //String tipoUsuario;
            if (cod.startsWith("D") ) {return "DIRECTOR"; } 
            else {return "PROFESOR"; } 
     
        
 
    } 
    
}
    

