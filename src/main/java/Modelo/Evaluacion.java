
package Modelo;


public class Evaluacion {
    private String periodo;
    private Competencia comp;
    private String comentarios[] = new String[8];

    public Evaluacion(String periodo, Competencia comp) {
        this.periodo = periodo;
        this.comp = comp;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public Competencia getComp() {
        return comp;
    }

    public void setComp(Competencia comp) {
        this.comp = comp;
    }

    public String[] getComentarios() {
        return comentarios;
    }

    public void setComentarios(String[] comentarios) {
        this.comentarios = comentarios;
    }
    
    
    
}
