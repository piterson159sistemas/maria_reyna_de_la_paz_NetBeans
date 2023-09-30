package Controlador;
import Vista.*;
import Modelo.Usuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class CLogin implements ActionListener{
    login vista;
    Usuario user;
    
    
    public CLogin(login login){
       vista=login;
       login.btnIngresarDire.addActionListener(this);
       login.btnIngresarProfe.addActionListener(this);
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
        if(e.getSource()==vista.btnIngresarDire){
            //Validacion previa
            boolean usuarioValido=false;
            if(usuarioValido){
                MenuDirec menuD=new MenuDirec();
                CMenuDirec cMenuD= new CMenuDirec(menuD);
            }else{
                JOptionPane.showMessageDialog(null, ""
                        + "Codigo/Contraseña incorrectos", "ERROR", 
                        JOptionPane.ERROR_MESSAGE);
            }
        }
        
        if(e.getSource()==vista.btnIngresarProfe){
        
            //Validacion previa
            boolean usuarioValido=false;
            if(usuarioValido){
                MenuDocente menuProfe=new MenuDocente();
                CMenuDocente cMenuProfe= new CMenuDocente(menuProfe);
            }else{
                JOptionPane.showMessageDialog(null, ""
                        + "Codigo/Contraseña incorrectos", "ERROR", 
                        JOptionPane.ERROR_MESSAGE);
            }            
        }
        
        if(e.getSource()==vista.btnCambiarClave){
            
        }
    }
    
}
