
package DAO;

import Modelo.Alumno;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Stack;
import javax.swing.JOptionPane;

public class crudAlumno {
    Conexion con= new Conexion();
    

    
    public ArrayList<String> Buscar(int NumDoc){
        String sqlStatement="SELECT * from Alumno WHERE N_DocumentoA=("+NumDoc+");";
        ArrayList<String> dataAlumno=new ArrayList<>(); 
         try {
            Connection cn = con.conectar();
            con.rs=con.st.executeQuery(sqlStatement);
            int numColum= con.rs.getMetaData().getColumnCount();
            
            if(con.rs.next()){
                for(int i=0;i<numColum;i++){
                    dataAlumno.add(con.rs.getString(i+1));
                    System.err.println(dataAlumno.get(i));
                }
            }
            cn.close();
        } catch (Exception e) {
            msjDialog("Alumno no registrado "+ e);
        }
        return dataAlumno;
    }
    
    public Stack<String> Listar(){
        String sqlStatement="Select concat(Nombres,\" \",Apellido_P,\" \",Apellido_M)"
                + " as Estudiante from Alumno;";
        Stack<String> Alumnos = new Stack<>();
        try {
            Connection cn = con.conectar();
            con.st= cn.createStatement();
            con.rs = con.st.executeQuery(sqlStatement);
            
            while( con.rs.next()){
                Alumnos.add(con.rs.getString(1));
            }
        } catch (SQLException e) {
            msjDialog("ERROR al mostrar la lista de Alumnos "+e);
        }
        return Alumnos;
    }

    public void Insertar(Alumno a){
        String sqlStatement="INSERT INTO Alumno values(?,?,?,?,?);";
        try{
            Connection cn = con.conectar();
            con.pst =cn.prepareStatement(sqlStatement);
            con.pst.setInt(1, a.getNumDocumento());
            con.pst.setString(2, a.getTipoDocumento());
            con.pst.setString(3, a.getNombre());
            con.pst.setString(4, a.getApellidoP());
            con.pst.setString(5, a.getApellidoM());
            con.pst.executeUpdate();
            msjDialog("Alumno registrado exitosamente");
            cn.close();
        }catch(SQLException e){
            msjDialog("ERROR al registrar Alumno "+e);
        }
        
    }
    
    public void Eliminar(int NumDoc){
        String sqlStatement="DELETE FROM Alumno WHERE N_DocumentoA=(?);";
        
        try {
            Connection cn = con.conectar();
            con.pst =cn.prepareStatement(sqlStatement);
            con.pst.setInt(1, NumDoc);
            con.pst.executeUpdate();
            msjDialog("Registro eliminado exitosamente");
            cn.close();
        } catch (SQLException e) {
            msjDialog("ERROR al eliminar registro "+e);
        }
        
    }
    
    public void Actualizar(Alumno a){
        String sqlStatement="UPDATE Alumno SET Nombres=(?), Apellido_P=(?),"
                + " Apellido_M=(?) WHERE N_DocumentoA=(?);";
        try {
            Connection cn = con.conectar();
            con.pst =cn.prepareStatement(sqlStatement);
            con.pst.setString(1, a.getNombre());
            con.pst.setString(2, a.getApellidoP());
            con.pst.setString(3, a.getApellidoM());
            con.pst.setInt(4, a.getNumDocumento());
            con.pst.executeUpdate();
            msjDialog("Datos de Alumno actualizados exitosamente");
            cn.close();
        } catch (SQLException e) {
            msjDialog("ERROR al Actializar registro "+e);
        }
        
    }
    
    public static void msjDialog(String mensaje){
        JOptionPane.showMessageDialog(null,mensaje);
    }    
}
