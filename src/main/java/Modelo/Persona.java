
package Modelo;

public class Persona {
    public String Nombre;
    public String ApellidoP;
    public String ApellidoM;
    public String TipoDocumento;
    public int NumDocumento;

    
    public Persona(){}
    
    public Persona(String Nombre, String ApellidoP, String ApellidoM, 
                   String TipoDocumento, int NumDocumento) {
        this.Nombre = Nombre;
        this.ApellidoP = ApellidoP;
        this.ApellidoM = ApellidoM;
        this.TipoDocumento = TipoDocumento;
        this.NumDocumento = NumDocumento;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellidoP() {
        return ApellidoP;
    }

    public void setApellidoP(String ApellidoP) {
        this.ApellidoP = ApellidoP;
    }

    public String getApellidoM() {
        return ApellidoM;
    }

    public void setApellidoM(String ApellidoM) {
        this.ApellidoM = ApellidoM;
    }

    public String getTipoDocumento() {
        return TipoDocumento;
    }

    public void setTipoDocumento(String TipoDocumento) {
        this.TipoDocumento = TipoDocumento;
    }

    public int getNumDocumento() {
        return NumDocumento;
    }

    public void setNumDocumento(int NumDocumento) {
        this.NumDocumento = NumDocumento;
    }

    
}
