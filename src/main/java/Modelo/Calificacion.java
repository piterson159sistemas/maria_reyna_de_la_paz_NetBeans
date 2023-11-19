package Modelo;

public class Calificacion {
    private Alumno alumno;
    private AreaDocencia areaDoce;
    private String periodo;
    private Evaluacion  eval;
    private int notas[]= new int[8];
    private float promedio;

    public Calificacion(Alumno alumno, AreaDocencia areaDoce, String periodo, 
            Evaluacion eval, float promedio) {
        this.alumno = alumno;
        this.areaDoce = areaDoce;
        this.periodo = periodo;
        this.eval = eval;
        this.promedio = promedio;
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

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public Evaluacion getEval() {
        return eval;
    }

    public void setEval(Evaluacion eval) {
        this.eval = eval;
    }

    public int[] getNotas() {
        return notas;
    }

    public void setNotas(int[] notas) {
        this.notas = notas;
    }

    public float getPromedio() {
        return promedio;
    }

    public void setPromedio(float promedio) {
        this.promedio = promedio;
    }
   
    public void RegistrarNotas(){}
    public void CalcularPromedio(){}
    public void ConvertirNota(){}
    public void OrdenDeMerito(){}
    public void NotaMaxima(){}
    public void NotaMinima(){}
    public void Porcentaje(){}
    public void ValidarNota(){}
    public void Actualizar(){}
    public void Eliminar(){}
    public void ExportarPDF(){}
    
}
