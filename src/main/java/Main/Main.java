
package Main;
import Controlador.CListadoAlumDirec;
import VISTA_INICIARSESION.login;
import Controlador.CLogin;
import Vista.lista_estudiantes_directivo_1;

public class Main {

    public static login login;
    public static CLogin cLogin;
    
    
    public static void main(String[] args) {
        
        login = new login();
        cLogin = new CLogin(login);
        

        /* Para inicar sesion rapido cuando hago pruebas
        login.txtCod.setText("D0101232");
        login.txtClave.setText("raul");
        login.btnIngresar.doClick();
        */
            
    }
    
}
