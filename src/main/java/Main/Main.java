
package Main;
import Vista.login;
import Controlador.CLogin;

public class Main {

    public static login login;
    public static CLogin cLogin;
    
    
    public static void main(String[] args) {
        
        login = new login();
        cLogin = new CLogin(login);
        System.out.println("hola mundo");
    }
    
}
