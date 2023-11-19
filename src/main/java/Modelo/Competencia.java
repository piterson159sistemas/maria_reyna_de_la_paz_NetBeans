
package Modelo;

public class Competencia {
    private String nombre;
    private String area;

    public Competencia(String nombre, String area) {
        this.nombre = nombre;
        this.area = area;
    }

    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }


    
}
