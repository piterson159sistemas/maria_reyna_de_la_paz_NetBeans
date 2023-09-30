
package Conexion;

public interface paramsConexion {
    
    String driver="com.mysql.cj.jdbc.Driver";
    String ip="localhost";
    String puerto="3306";
    String nombreBD="";
    String ruta="jdbc:mysql://"+ip+":"+puerto+"/"+nombreBD;
    String user="root";
    String pass="";    
    
   
}
