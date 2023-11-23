
package DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;


public class crudAlumnoNotas {
    
    Conexion con= new Conexion();
    
    public ArrayList<String> buscarPeriodos(){
        ArrayList<String> periodos = new ArrayList<>();
        
        String sqlST="select Periodo from periodo;";

        try {
            Connection cn = con.conectar();
            con.st = cn.createStatement();
            con.rs = con.st.executeQuery(sqlST);
            while(con.rs.next()){
                periodos.add(con.rs.getString(1));
            }
            cn.close();
           } catch (SQLException e) {}
        return periodos;
        
    }
    
    public ArrayList<String> buscarAreas(String Nivel){
        String sqlST="select area from area where ";
        ArrayList<String> areas = new ArrayList<>();
        switch (Nivel) {
            case "Inicial" -> sqlST+="Codigo_Area=1 or Codigo_Area=3 or Codigo_Area=5"
                    + " or Codigo_Area=7 or Codigo_Area=13;";
            
            case "Primaria" -> sqlST+="Codigo_Area>=1 and Codigo_Area<=9 and Codigo_Area!=8;";
            
            default -> sqlST+="Codigo_Area>=2 and Codigo_Area<=12 and Codigo_Area!=8;";
        }

        try {
            Connection cn = con.conectar();
            con.st = cn.createStatement();
            con.rs = con.st.executeQuery(sqlST);
            while(con.rs.next()){
                areas.add(con.rs.getString(1));
            }
            cn.close();
           } catch (SQLException e) {}
        return areas;

    }
    
    public ArrayList<String> buscarCompetencias(String Area){
        String sqlST="select Competencia from competencias;";
        ArrayList<String> comps = new ArrayList<>();

        try {
            Connection cn = con.conectar();
            con.st = cn.createStatement();
            con.rs = con.st.executeQuery(sqlST);
            while(con.rs.next()){
                comps.add(con.rs.getString(1));
            }
            cn.close();
           } catch (SQLException e) {}
        return comps;

    }
    
    
}
