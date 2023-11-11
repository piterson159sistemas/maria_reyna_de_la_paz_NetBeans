package DAO;

import Modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class QueryLogin {

     public boolean consultarUsuario(Usuario u){
       boolean usuarioEncontrado = false;
        // TODO add your handling code here:
        Conexion db = new Conexion();
        // Se inicializa a null
        try{

            Connection conexion = db.conectar();
            PreparedStatement pst = conexion.prepareStatement("SELECT Codigo_Usuario, Acceso FROM acceso WHERE Codigo_Usuario = ? AND Acceso = ?");
            pst.setString(1, u.getCodigo());
            pst.setString(2, u.getClave());
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                usuarioEncontrado = true;
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error consulta" + e);
        }
         return usuarioEncontrado;
    }
    
}