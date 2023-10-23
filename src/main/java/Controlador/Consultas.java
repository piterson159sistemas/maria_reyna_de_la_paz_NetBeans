package Controlador;

import Conexion.Conexion;
import Vista.MenuDirec;
import Vista.MenuDocente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class Consultas {
     public void consultarUsuario(String user, String pass)
    {
        // TODO add your handling code here:
        Conexion db = new Conexion();
        // Se inicializa a null
        String usuarioCorrecto = null;
        String passCorrecto = null;
    try {

        Connection conexion = db.conectar();
PreparedStatement pst = conexion.prepareStatement("SELECT Codigo_Usuario, Acceso FROM acceso WHERE Codigo_Usuario = ? AND Acceso = ?");
pst.setString(1, user);
pst.setString(2, pass);
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            usuarioCorrecto = rs.getString(1);
            passCorrecto = rs.getString(2);
        }

        if (usuarioCorrecto.startsWith("D") && pass.equals(passCorrecto)) {
            JOptionPane.showMessageDialog(null, "Bienvenido Directivo: " + user);

                 MenuDirec menu = new MenuDirec();
                menu.setVisible(true);

        } else if (usuarioCorrecto.startsWith("P") && pass.equals(passCorrecto)) {

            JOptionPane.showMessageDialog(null, "Bienvenido Profesor:"+ user);
            
                                 MenuDocente menud = new MenuDocente();
                                   menud.setVisible(true);
        }else {
            // Usuario o contraseña incorrectos.
            JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error " + e);
    }
    }
    
}