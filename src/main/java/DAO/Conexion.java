package DAO;

// librerias para el SQL
import java.sql.ResultSet;;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;


public class Conexion {
    
    //atributos para manejo de comandos sql
    Statement st;
    PreparedStatement pst;
    ResultSet rs;
    ResultSetMetaData rsmd;
    
    //atributos de conexion
    String ip="localhost";
    String puerto="3306";
    String nombreBD="colegio";
    String ruta="jdbc:mysql://"+ip+":"+puerto+"/"+nombreBD;
    
    String user="bdColegioUser";
    String pass="12345678";  
    
    //conexion local
    public Connection conectar() {
        try {
            Connection cn = DriverManager.getConnection(ruta,user,pass);
            return cn;
        } catch (SQLException e) {
            System.out.println("Error en la conexion local " + e);
        }
        return null;
    }
}

