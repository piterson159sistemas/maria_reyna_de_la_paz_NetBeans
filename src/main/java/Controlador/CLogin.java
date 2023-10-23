package Controlador;
import Vista.*;
import Modelo.Usuario;
import DAO.QueryLogin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class CLogin implements ActionListener{
    login vista;
    Usuario user;
    QueryLogin queryLogin;
    
    
    public CLogin(login login){
       vista=login;
       login.btnIngresar.addActionListener(this);
       login.btnCambiarClave.addActionListener(this);
       login.setTitle("LOGIN");
       login.setVisible(true);
    }

    public void leerUser(){
            String cod= vista.txtCod.getText();
            String clave= String.valueOf(vista.txtClave.getPassword());
            user = new Usuario(cod,clave);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==vista.btnIngresar){
            //Validacion previa
            leerUser();
            queryLogin = new QueryLogin();
             boolean usuarioExiste = queryLogin.consultarUsuario(user);
            
            //se comprueba si existe el usuario
            if(usuarioExiste){
                
                // se comprueba si el usuario es director o docente
                String tipoUsuario = user.ValidarTipoUsuario(user.getCodigo());
                
                if(tipoUsuario.equals("DIRECTOR")){
                    vista.dispose();
                    MenuDirec menuD=new MenuDirec();
                    CMenuDirec cMenuD= new CMenuDirec(menuD);
                    
                }else{
                    vista.dispose();
                    MenuDocente menuProfe=new MenuDocente();
                    CMenuDocente cMenuProfe= new CMenuDocente(menuProfe);
                }
                
            }else{
                JOptionPane.showMessageDialog(null, ""
                        + "Codigo/Contraseña incorrectos", "ERROR", 
                        JOptionPane.ERROR_MESSAGE);
            }
        }
        
        if(e.getSource()==vista.btnCambiarClave){
            recopilar_codigo_cambioContraseña RcopilarCodigoC = new recopilar_codigo_cambioContraseña();
            RcopilarCodigoC.setVisible(true);
            
        }
        
            
        
    }
    
}
