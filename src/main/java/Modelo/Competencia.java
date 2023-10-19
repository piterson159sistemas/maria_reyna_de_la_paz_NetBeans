
package Modelo;

public class Competencia {
    private String nombre;
    private Area area;

    public Competencia(String nombre, Area area) {
        this.nombre = nombre;
        this.area = area;
    }

    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }
    
}
