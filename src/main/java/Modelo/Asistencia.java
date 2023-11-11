
package Modelo;

import java.util.Date;

public class Asistencia {
    private Date fecha;
    private String tipo;
    private AreaDocencia clase;
    private Horario horario;
    private Alumno alumno;

    public Asistencia(Date fecha, String tipo, AreaDocencia clase,
            Horario horario, Alumno alumno) {
        this.fecha = fecha;
        this.tipo = tipo;
        this.clase = clase;
        this.horario = horario;
        this.alumno = alumno;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public AreaDocencia getClase() {
        return clase;
    }

    public void setClase(AreaDocencia clase) {
        this.clase = clase;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }
    
    
    public void RegistrarAsistencia(){}
    public void ResumirContar(){}
    public void Actualizar(){}
    public void Eliminar(){}
    public void HacerReporte(){}
    }

