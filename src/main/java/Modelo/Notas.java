package Modelo;

public class Notas {
    public double NotaNumero;
    public String NotaLetra;
    public String Comentario;
    public String Periodo;

    public Notas(double NotaNumero, String NotaLetra, String Comentario, String Periodo) {
        this.NotaNumero = NotaNumero;
        this.NotaLetra = NotaLetra;
        this.Comentario = Comentario;
        this.Periodo = Periodo;
    }

    public double getNotaNumero() {
        return NotaNumero;
    }

    public void setNotaNumero(double NotaNumero) {
        this.NotaNumero = NotaNumero;
    }

    public String getNotaLetra() {
        return NotaLetra;
    }

    public void setNotaLetra(String NotaLetra) {
        this.NotaLetra = NotaLetra;
    }

    public String getComentario() {
        return Comentario;
    }

    public void setComentario(String Comentario) {
        this.Comentario = Comentario;
    }

    public String getPeriodo() {
        return Periodo;
    }

    public void setPeriodo(String Periodo) {
        this.Periodo = Periodo;
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
