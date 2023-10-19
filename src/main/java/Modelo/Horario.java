
package Modelo;

import java.time.LocalTime;

public class Horario {
    private String Dia;
    private LocalTime horaInicio;
    private LocalTime horaFin;

    public Horario(String Dia, LocalTime horaInicio, LocalTime horaFin) {
        this.Dia = Dia;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    public String getDia() {
        return Dia;
    }

    public void setDia(String Dia) {
        this.Dia = Dia;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    }
    
    
}
