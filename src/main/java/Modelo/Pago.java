
package Modelo;

import java.util.Date;


public class Pago {
    private Date fechapago,fechaVenc;
    private float monto;
    private String estado;
    private Alumno alumno;

    public Pago(Date fechapago, Date fechaVenc, float monto, String estado, Alumno alumno) {
        this.fechapago = fechapago;
        this.fechaVenc = fechaVenc;
        this.monto = monto;
        this.estado = estado;
        this.alumno = alumno;
    }

    public Date getFechaVenc() {
        return fechaVenc;
    }

    public void setFechaVenc(Date fechaVenc) {
        this.fechaVenc = fechaVenc;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
            
}
