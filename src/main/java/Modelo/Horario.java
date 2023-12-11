
package Modelo;

import java.time.LocalTime;

public class Horario {
    private String Dia;
    private String Hora;
    private String Color;
    private String Area;

    public Horario(String Dia, String Hora, String Color, String Area) {
        this.Dia = Dia;
        this.Hora = Hora;
        this.Color = Color;
        this.Area = Area;
    }

    public String getDia() {
        return Dia;
    }

    public void setDia(String Dia) {
        this.Dia = Dia;
    }

    public String getHora() {
        return Hora;
    }

    public void setHora(String Hora) {
        this.Hora = Hora;
    }
    
    public String getColor() {
        return Color;
    }

    public void setColor(String Color) {
        this.Color = Color;
    }

    public String getArea() {
        return Area;
    }

    public void setArea(String Area) {
        this.Area = Area;
    }
    

   
    
}

