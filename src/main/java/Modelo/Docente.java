package Modelo;

import java.util.Collection;

public class Docente extends Usuario implements Gestionable{

    public Docente(int numDoc,String nom, String apeP, String ApeM,
            String codigo, String clave) {
        super(numDoc, nom, apeP, ApeM);
        this.codigo=codigo;
        this.clave=clave;
    }

                  
    public void RegistrarDocente(){}
    
    
    @Override
    public void gestionarContraDocente() {
        
    }
}
