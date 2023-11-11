
package Modelo;


public class CompTransversal {
    private Alumno alumno;
    private AreaDocencia areaDoce;
    private Periodo periodo;
    private int tic;
    private int conducta;
    private int gestioAprendizaje;

    public CompTransversal(Alumno alumno, AreaDocencia areaDoce, Periodo periodo, int tic, int conducta, int gestioAprendizaje) {
        this.alumno = alumno;
        this.areaDoce = areaDoce;
        this.periodo = periodo;
        this.tic = tic;
        this.conducta = conducta;
        this.gestioAprendizaje = gestioAprendizaje;
    }

    
    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public AreaDocencia getAreaDoce() {
        return areaDoce;
    }

    public void setAreaDoce(AreaDocencia areaDoce) {
        this.areaDoce = areaDoce;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }

    public int getTic() {
        return tic;
    }

    public void setTic(int tic) {
        this.tic = tic;
    }

    public int getConducta() {
        return conducta;
    }

    public void setConducta(int conducta) {
        this.conducta = conducta;
    }

    public int getGestioAprendizaje() {
        return gestioAprendizaje;
    }

    public void setGestioAprendizaje(int gestioAprendizaje) {
        this.gestioAprendizaje = gestioAprendizaje;
    }
    
    
    
    
}
