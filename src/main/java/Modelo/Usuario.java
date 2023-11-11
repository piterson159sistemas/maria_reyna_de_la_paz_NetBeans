package Modelo;

public class Usuario extends Persona implements Modificable, Registrable {
    protected String codigo;
    protected String clave;
    protected String Preg[] = new String[3];
    protected String Resp[] = new String[3];

    public Usuario(String codigo, int NumDocumento, String Nombre, String ApellidoP, String ApellidoM) {
        super(NumDocumento, Nombre, ApellidoP, ApellidoM);
        this.codigo = codigo;
    }

    public Usuario(String codigo, String clave) {
        this.codigo = codigo;
        this.clave = clave;
    }

    // Constructor sin argumentos
    public Usuario() {
        // Inicializa el objeto sin argumentos
        super(0, "", "", "");
        this.codigo = "";
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
        // Implementación de cambio de contraseña
    }

    @Override
public void crearCodigo() {
    
}

    @Override
    public void Actualizar() {
        // Implementación de actualización
    }

    public String ValidarTipoUsuario(String cod) {
        if (cod.startsWith("D") || cod.startsWith("d")) {
            return "DIRECTOR";
        } else {
            return "PROFESOR";
        }
    }

    
}
