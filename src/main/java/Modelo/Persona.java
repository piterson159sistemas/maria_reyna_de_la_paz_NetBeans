
package Modelo;

import java.util.ArrayList;

public abstract class Persona {
    private String TipoDocumento;
    private int NumDocumento;
    private String Nombre;
    private String ApellidoP;
    private String ApellidoM;

    
    public Persona(){}

    public Persona(String TipoDocumento, int NumDocumento, 
            String Nombre, String ApellidoP, String ApellidoM) {
        this.TipoDocumento = TipoDocumento;
        this.NumDocumento = NumDocumento;
        this.Nombre = Nombre;
        this.ApellidoP = ApellidoP;
        this.ApellidoM = ApellidoM;
    }

    public Persona(ArrayList<String>data) {
        this.TipoDocumento = data.get(0);
        this.NumDocumento = Integer.parseInt(data.get(1));
        this.Nombre = data.get(2);;
        this.ApellidoP = data.get(3);
        this.ApellidoM = data.get(4);
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

}
