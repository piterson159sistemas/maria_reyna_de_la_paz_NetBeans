
package DAO;

import Modelo.Tutoria;
import Procesos.ProcesosAlumnos;
import Procesos.ProcesosTutoria;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class crudTutoria {
    Conexion con= new Conexion();
    ProcesosTutoria procesos = new ProcesosTutoria();
    ProcesosAlumnos procesosAux = new ProcesosAlumnos();
    
    public ArrayList<String> BuscarGrados(int anio,String codDocente){
        ArrayList<String> grados = new ArrayList<>();
        String sqlST="select DISTINCT g.Grado from tutor t inner join grado g"
                + " on (t.Codigo_Grado=g.Codigo_Grado) where t.Año="+anio+
                  " and Codigo_Usuario <> '"+codDocente+"';"; 
        
        try {
            Connection cn = con.conectar();
            con.st = cn.createStatement();
            con.rs = con.st.executeQuery(sqlST);
            
            while (con.rs.next()) {
                grados.add(con.rs.getString(1));
            }
            cn.close();
        } catch (SQLException e) {}
        return grados;
    }
    
    public ArrayList<String> BuscarGrados(int anio){
        ArrayList<String> grados = new ArrayList<>();
        String sqlST="select DISTINCT g.Grado from tutor t inner join grado g"
                + " on (t.Codigo_Grado=g.Codigo_Grado) where t.Año="+anio+";"; 
        
        try {
            Connection cn = con.conectar();
            con.st = cn.createStatement();
            con.rs = con.st.executeQuery(sqlST);
            
            while (con.rs.next()) {
                grados.add(con.rs.getString(1));
            }
            cn.close();
        } catch (SQLException e) {}
        return grados;
    }
    
    public boolean BuscarTutoria(int anio,String codDocente){
        int cantRegistros=0;
        String sqlST="select count(*) from tutor where Año="+anio+" and"
                + " Codigo_Usuario like '"+codDocente+"';";
        try {
            Connection cn = con.conectar();
            con.st = cn.createStatement();
            con.rs = con.st.executeQuery(sqlST);
            
            if(con.rs.next()){
                cantRegistros=con.rs.getInt(1); }
            cn.close();
            
            if(cantRegistros>=1){
                return true;
            }
        } catch (SQLException e) {}
        return false; 
    }
    
    public ArrayList<String> BuscarDocentes(int anio){
        ArrayList<String> docentes = new ArrayList<>();
        String sqlST="SELECT concat(u.Nombres,' ',u.Apellido_P,' ',u.Apellido_M) as"
                + " NombreCompleto FROM usuario u WHERE NOT EXISTS ("
                + " SELECT 1 FROM tutor t WHERE t.Codigo_Usuario = u.Codigo_Usuario" 
                + " AND t.Año = "+anio+") and Codigo_Rol=2 and u.Codigo_EstadoU=1;";
        try {
            Connection cn = con.conectar();
            con.st = cn.createStatement();
            con.rs = con.st.executeQuery(sqlST);
            
            while(con.rs.next()){ 
                docentes.add(con.rs.getString(1));
            }
            cn.close();
        } catch (Exception e) {}
        return docentes;
    }
    
    public String obtenerCodDocente(String nombreCompleto){
        String codDocente="";
        String sqlST="select Codigo_Usuario from usuario where concat"
                 + "(Nombres,' ',Apellido_P,' ',Apellido_M) like '"+nombreCompleto+"';";
        try {
            Connection cn = con.conectar();
            con.st = cn.createStatement();
            con.rs = con.st.executeQuery(sqlST);

            if(con.rs.next()){ 
                codDocente = con.rs.getString(1);
            }
            cn.close();
        } catch (SQLException e) {}
        return codDocente;
    }
         
    
    public int obtenerCodGrado(String grado){
        int codGrado=0;
        String nivel;
        if(grado.endsWith("I")){
            nivel="Inicial";
        }else if(grado.endsWith("P")){
            nivel="Primaria";
        }else{
            nivel="Secundaria";
        }
        grado = grado.substring(0,grado.length()-1);
        String sqlST="select Codigo_Grado from grado where Grado like '"+grado+"'"
                + " and Nivel like '"+nivel+"';";
        try {
            Connection cn = con.conectar();
            con.st = cn.createStatement();
            con.rs = con.st.executeQuery(sqlST);

            if(con.rs.next()){ 
                codGrado = con.rs.getInt(1);
            }
            cn.close();
        } catch (SQLException e) {}
        return codGrado;
        
    }
    
    public void ListarDocentes(JTable tabla){
        //Definimos un modelo de encabezados para la tabla 
        String[] Titulos= {"Año","Codigo Docente","Nombre Completo"};
        DefaultTableModel tableModel = new DefaultTableModel(null,Titulos);
        tabla.setModel(tableModel);
        tabla.setDefaultEditor(Object.class, null);
        
        String sqlST="SELECT DISTINCT t.Año,t.Codigo_Usuario,concat(u.Nombres,"
                + " ' ',u.Apellido_P,' ',u.Apellido_M) as nombreCompleto"
                + " from tutor t inner join usuario u "
                + " on (t.Codigo_Usuario=u.Codigo_Usuario);";
        
        Object[] data = new Object[3];
        try {
            Connection cn = con.conectar();
            con.st = cn.createStatement();
            con.rs = con.st.executeQuery(sqlST);
            
            while( con.rs.next()){
                data[0]= con.rs.getInt(1);
                data[1]= con.rs.getString(2);
                data[2]= con.rs.getString(3);
                tableModel.addRow(data);
            }
            cn.close();
        } catch (SQLException e) {
            procesosAux.msjDialog("ERROR al mostrar la lista de tutorias"+e);
        }
        
    }
    
    public void ListarGradosAsignados(JTable tabla,String codigo,int anio){
        //Definimos un modelo de encabezados para la tabla 
        String[] Titulos= {"Grado"};
        DefaultTableModel tableModel = new DefaultTableModel(null,Titulos);
        tabla.setModel(tableModel);
        tabla.setDefaultEditor(Object.class, null);
        
        String sqlST="select concat(g.Grado,'  ',g.Nivel) as Grado from tutor t" 
                + " inner join grado g on (t.Codigo_Grado=g.Codigo_Grado)"
                + " where t.Codigo_Usuario like '"+codigo+"' and t.Año="+anio+";";
        
        Object[] data = new Object[1];
        try {
            Connection cn = con.conectar();
            con.st = cn.createStatement();
            con.rs = con.st.executeQuery(sqlST);
            
            while( con.rs.next()){
                data[0]= con.rs.getString(1);
                tableModel.addRow(data);
            }
            cn.close();
        } catch (SQLException e) {
            procesosAux.msjDialog("ERROR al mostrar la lista de tutorias"+e);
        }    
    }
    
    
    public void insertar(Tutoria t,int codGrado){
        String sqlST="INSERT INTO tutor(Año,Codigo_Usuario,Codigo_Grado)"
                + " values (?,?,?);";
        try {
            Connection cn = con.conectar();
            con.pst =cn.prepareStatement(sqlST);
            con.pst.setInt(1, t.getAnio());
            con.pst.setString(2, t.getDocente().getCodigo());
            con.pst.setInt(3, codGrado);
            con.pst.executeUpdate();
            cn.close();
        } catch (SQLException e) {
            procesosAux.msjDialog("ERROR al insertar registro "+e);
        }
    }
    
    public void eliminar(int anio,String codDocente){
        String sqlST="DELETE FROM tutor where Año=(?) and Codigo_Usuario like (?);";
        try {
            Connection cn = con.conectar();
            con.pst =cn.prepareStatement(sqlST);
            con.pst.setInt(1, anio);
            con.pst.setString(2, codDocente);
            con.pst.executeUpdate();
            cn.close();
            
        } catch (SQLException e) {
            procesosAux.msjDialog("ERROR al eliminar registros "+e);
        }
    }
    
    
    
    
}
