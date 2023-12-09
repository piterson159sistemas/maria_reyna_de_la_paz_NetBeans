
package Main;
import VISTA_INICIARSESION.login;
import Controlador.CLogin;

public class Main {

    public static void iniciarSesion(){
        login login = new login();
        CLogin cLogin = new CLogin(login);
        
    }
    
    public static void main(String[] args) {
        
        iniciarSesion();    

        /* Para inicar sesion rapido cuando hago pruebas
        login.txtCod.setText("P0101231");
        login.txtClave.setText("sa");
        login.btnIngresar.doClick();
        */
            
    }
    
}
