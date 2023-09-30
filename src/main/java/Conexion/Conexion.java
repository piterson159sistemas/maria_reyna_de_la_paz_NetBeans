package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Conexion implements paramsConexion{
    Connection conexion=null;
    Statement st;
    PreparedStatement ps;
    ResultSet rs;
    ResultSetMetaData mdata;
    
   
    public Connection setConexion(){
        try{
            Class.forName(driver);
            conexion = DriverManager.getConnection(ruta,user,pass);
        }catch(ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, "Error:"
                    + " Revisar clase paramsConexion "+e.getMessage());
        }
        return conexion;
    }
    
}
