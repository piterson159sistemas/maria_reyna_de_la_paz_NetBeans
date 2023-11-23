package Controlador;
import VISTA_INICIARSESION.login;
import VISTA_DIRECTIVO.MenuDirec2;
import Vista.MenuDocente;
import VISTA_DOCENTE.MenuDocen;
import VISTA_CAMBIARCONTRA.CambiarContraseña;
import Modelo.Usuario;
import DAO.QueryLogin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class CLogin implements ActionListener {
    login vista;
    Usuario user;
    QueryLogin queryLogin;

    public CLogin(login login) {
       vista = login;
       
       login.btnIngresar.addActionListener(this);
       login.btnCambiarClave.addActionListener(this);
       login.setTitle("LOGIN");
       login.setVisible(true);
    }

    // Método que lee los datos de usuario desde la vista
    public void leerUser() {
        String cod = vista.txtCod.getText();
        String clave = String.valueOf(vista.txtClave.getPassword());
        user = new Usuario(cod, clave);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnIngresar) {
            leerUser();
            queryLogin = new QueryLogin();
            boolean usuarioExiste = queryLogin.consultarUsuario(user);

            if (usuarioExiste) {
                String tipoUsuario = user.ValidarTipoUsuario(user.getCodigo());
                if (tipoUsuario.equals("DIRECTOR")) {
                    vista.dispose();
                    MenuDirec2 menuD = new MenuDirec2();
                    //paasamo el codigo de usuario al contralador para que el menu de inicio lo muestre 
                    CMenuDirec2 cMenuD = new CMenuDirec2(menuD,user.getCodigo());
                    
                    //Menu anterior por si se necesitara mostrar
                    //MenuDirec menuD1 = new MenuDirec();
                    //CMenuDirec cMenuD1 = new CMenuDirec(menuD1);
                    
                } else {
                    vista.dispose();
                    MenuDocen menuProfe = new MenuDocen();
                    CMenuDocente cMenuP = new CMenuDocente(menuProfe, tipoUsuario);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Código/Contraseña incorrectos", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }

        if (e.getSource() == vista.btnCambiarClave) {   
            CambiarContraseña recopilarCodigo = new CambiarContraseña();
            CCambioContraseñaYRecopilasCodigo CCRC = new CCambioContraseñaYRecopilasCodigo(recopilarCodigo);

            
        }
        
    }
}