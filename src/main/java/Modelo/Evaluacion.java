
package Modelo;


public class Evaluacion {
    private Periodo periodo;
    private Competencia comp;
    private AreaDocencia areaDoce;
    private String comentarios[] = new String[8];

    public Evaluacion(Periodo periodo, Competencia comp, AreaDocencia areaDoce) {
        this.periodo = periodo;
        this.comp = comp;
        this.areaDoce = areaDoce;
    }

    
    
    public Periodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }

    public Competencia getComp() {
        return comp;
    }

    public void setComp(Competencia comp) {
        this.comp = comp;
    }

    public AreaDocencia getAreaDoce() {
        return areaDoce;
    }

    public void setAreaDoce(AreaDocencia areaDoce) {
        this.areaDoce = areaDoce;
    }

    public String[] getComentarios() {
        return comentarios;
    }

    public void setComentarios(String[] comentarios) {
        this.comentarios = comentarios;
    }
    
    
    
}
