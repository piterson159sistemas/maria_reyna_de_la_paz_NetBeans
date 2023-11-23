
package DAO;

import Modelo.GradoDocencia;
import Procesos.ProcesosAlumnos;
import Procesos.procesosAreasGrados;
import Vista.asignar_area_directivo_1;
import VISTA_DIRECTIVO.Asignar_Area;

import java.awt.Component;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class crudAreasGrados {
     Conexion con= new Conexion();
     ProcesosAlumnos procesosAux = new ProcesosAlumnos();
     //procesosAreasGrados procesos=new procesosAreasGrados();
    
     public void listarGrados(JTable tabla){
        String[] Titulos= {"Año","Grado","Nivel"};
        DefaultTableModel tableModel = new DefaultTableModel(null,Titulos);
        tabla.setModel(tableModel);
        tabla.setDefaultEditor(Object.class, null);   
        
        String sqlST=" select distinct Año,g.Grado,g.Nivel from Docente_Grado dg "
                + " inner join Grado g on (dg.Codigo_Grado=g.Codigo_Grado);";
        
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
     
    public void listarAreas(JTable tabla,int anio,int codGrado){
        String[] Titulos= {"Area","Codigo","Docente"};
        DefaultTableModel tableModel = new DefaultTableModel(null,Titulos);
        tabla.setModel(tableModel);
        tabla.setDefaultEditor(Object.class, null);   
        
        String sqlST="select a.Area,da.Codigo_Usuario,CONCAT(u.Nombres, ' ',"
                + " u.Apellido_P, ' ', u.Apellido_M) AS NombreCompleto from "
                + " Docente_Grado dg inner join Docente_Area da on "
                + " (dg.Codigo_Docente_Area=da.Codigo_Docente_Area) inner join "
                + " usuario u on (da.Codigo_Usuario = u.Codigo_Usuario) inner join "
                + " area a on (da.Codigo_Area=a.Codigo_Area)" 
                + " where dg.Año="+anio+" and dg.Codigo_Grado="+codGrado+";";
        
        Object[] data = new Object[3];
        try {
            Connection cn = con.conectar();
            con.st = cn.createStatement();
            con.rs = con.st.executeQuery(sqlST);
            
            while( con.rs.next()){
                data[0]= con.rs.getString(1);
                data[1]= con.rs.getString(2);
                data[2]= con.rs.getString(3);
                tableModel.addRow(data);
            }
            cn.close();
        } catch (SQLException e) {
            procesosAux.msjDialog("ERROR al mostrar la lista de tutorias"+e);
        }          
        
    }
     
     
    public boolean buscarRegistro(int anio, int codGrado){
        int cantRegistros=0;
        String sqlST="Select count(*) from docente_grado where Año="+anio
                + " and Codigo_Grado="+codGrado+";";
        try {
            Connection cn = con.conectar();
            con.st = cn.createStatement();
            con.rs = con.st.executeQuery(sqlST);
            if(con.rs.next()){
                cantRegistros=con.rs.getInt(1);
            }
            cn.close();
           } catch (SQLException e) {}
        
        if(cantRegistros>0){return true;}
        else{return false;}
    }
     
    public ArrayList<String> BuscarDocente(String opcion,int anio){
        ArrayList<String> docentes = new ArrayList<>();
        String sqlST="SELECT CONCAT(u.Nombres, ' ', u.Apellido_P, ' ', u.Apellido_M)"
        + " AS NombreCompleto FROM usuario u INNER JOIN docente_area da"
        + " ON da.Codigo_Usuario = u.Codigo_Usuario"
        + " WHERE NOT EXISTS ( SELECT 1 FROM usuario u2 INNER JOIN docente_area da2"
        + " ON da2.Codigo_Usuario = u2.Codigo_Usuario"
        + " LEFT JOIN docente_grado dg ON dg.Codigo_Docente_Area = da2.Codigo_Docente_Area" 
        + " WHERE dg.Año = "+anio+" AND CONCAT(u.Nombres, ' ', u.Apellido_P, ' ', u.Apellido_M)"
        + " = CONCAT(u2.Nombres, ' ', u2.Apellido_P, ' ', u2.Apellido_M) )"
        + " GROUP BY u.Codigo_Usuario";
        
        if(opcion.equals("I")){
            //consultar solo profes de inicial
            sqlST+=" HAVING COUNT(da.Codigo_Usuario)=8;";
        }else{
            //consultar solo profes de primaria de grado menor(1|,2°,3°)
            sqlST+=" HAVING COUNT(da.Codigo_Usuario)=7;";
        }
        
        try {
            Connection cn = con.conectar();
            con.st = cn.createStatement();
            con.rs = con.st.executeQuery(sqlST);
            while(con.rs.next()){
                docentes.add(con.rs.getString(1));
            }
            cn.close();
           } catch (SQLException e) {}
        return docentes;
        
    }
    
    public ArrayList<String> BuscarDocente(int codArea){
        ArrayList<String> docentes = new ArrayList<>();
        
        //consultar los profes de algun curso determinado menos los de Inicial y Primaria(grados menores)
        String sqlST="SELECT DISTINCT CONCAT(u.Nombres, ' ', u.Apellido_P, ' ',"
            + " u.Apellido_M) AS NombreCompleto FROM usuario u" 
            + " INNER JOIN docente_area da ON "
            + " da.Codigo_Usuario = u.Codigo_Usuario WHERE NOT EXISTS(" 
            + " SELECT 1 FROM usuario u2 INNER JOIN docente_area da2 "
            + " ON da2.Codigo_Usuario = u2.Codigo_Usuario" 
            + " WHERE CONCAT(u2.Nombres, ' ', u2.Apellido_P, ' ',u2.Apellido_M) "
            + " = CONCAT(u.Nombres, ' ', u.Apellido_P,' ', u.Apellido_M)"
            + " GROUP BY u2.Codigo_Usuario HAVING COUNT(da2.Codigo_Usuario)>= 7)"
            + " and da.Codigo_Area="+codArea+";";

        try {
            Connection cn = con.conectar();
            con.st = cn.createStatement();
            con.rs = con.st.executeQuery(sqlST);
            while(con.rs.next()){
                docentes.add(con.rs.getString(1));
            }
            cn.close();
           } catch (SQLException e) {}
        return docentes;
        
    }
    
    public ArrayList<String> buscarAreas(String Nivel){
        ArrayList<String> areas = new ArrayList<>();
        String sqlST;
        switch (Nivel) {
            case "Inicial" ->
                sqlST="SELECT Area FROM area WHERE Codigo_Area BETWEEN 1 AND 13"
                    + " AND Codigo_Area NOT BETWEEN 9 AND 12 ORDER BY" 
                    + " CASE WHEN Codigo_Area = 13 THEN 2"
                    + " WHEN Codigo_Area = 8 THEN 3 ELSE 1"
                    + " END, Codigo_Area;";
            case "Primaria" ->
                sqlST="SELECT Area FROM area WHERE Codigo_Area BETWEEN 1 AND 9"
                    + " ORDER BY CASE WHEN Codigo_Area = 6 THEN 2"
                    + " WHEN Codigo_Area = 8 THEN 3 ELSE 1"
                    + " END, Codigo_Area;";
                
            default ->
                sqlST="SELECT Area FROM area WHERE Codigo_Area BETWEEN 2 AND 12 "
                        + " AND Codigo_Area != 8 ORDER BY Codigo_Area Desc;";
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
    
    public int obtenerCodArea(String nomArea){
        int codDocente=0;
        String sqlST="select Codigo_Area from area where Area like '"+nomArea+"';";
        try {
            Connection cn = con.conectar();
            con.st = cn.createStatement();
            con.rs = con.st.executeQuery(sqlST);
            if(con.rs.next()){
                codDocente= con.rs.getInt(1);
            }
            cn.close();
        } catch (SQLException e) {}
        return codDocente;
    }
    
    public int obtenerCodGrado(int indiceVentana,Asignar_Area frm){
        int codGrado=0;
        String Grado="";
        String Nivel="";
        switch (indiceVentana) {
            case 0 -> {Nivel="Inicial";
                      Grado=frm.cbxGradoI.getSelectedItem().toString();}
            case 1 -> {Nivel="Primaria";  
                       Grado=frm.cbxGradoP.getSelectedItem().toString();}
            default -> {Nivel="Secundaria";
                        Grado=frm.cbxGradoS.getSelectedItem().toString();}
        }
        
        String sqlST="select Codigo_Grado from grado where Grado like '"+Grado+"'"
                + " and Nivel like '"+Nivel+"';";
        
       try {
            Connection cn = con.conectar();
            con.st = cn.createStatement();
            con.rs = con.st.executeQuery(sqlST);
            if(con.rs.next()){
                codGrado= con.rs.getInt(1);
            }
            cn.close();
        } catch (SQLException e) {}
        return codGrado;
    }
    
    public int obtenerCodGrado(String Grado,String Nivel){
         int codGrado=0;
        String sqlST="select Codigo_Grado from grado where Grado like '"+Grado+"'"
                + " and Nivel like '"+Nivel+"';";
        try {
            Connection cn = con.conectar();
            con.st = cn.createStatement();
            con.rs = con.st.executeQuery(sqlST);
            if(con.rs.next()){
                codGrado= con.rs.getInt(1);
            }
            cn.close();
        } catch (SQLException e) {}
        return codGrado;   
    }
    
    public int obtenerCodAreaDocente(String codDocente,int CodArea){
        int codAreaDocente=0;
        String sqlST="select Codigo_Docente_Area from Docente_area where"
                + " Codigo_Usuario like '"+codDocente+"' and Codigo_Area="+CodArea+";";
        try {
            Connection cn = con.conectar();
            con.st = cn.createStatement();
            con.rs = con.st.executeQuery(sqlST);
            if(con.rs.next()){
                codAreaDocente= con.rs.getInt(1);
            }
            cn.close();
        } catch (SQLException e) {}
        return codAreaDocente;
    }
    
        
    public ArrayList<Integer> obtenerCodAreaDocente(int anio,int codGrado){
        ArrayList<Integer> codareasDoc = new ArrayList<>();
        String sqlST="select Codigo_Docente_Area from Docente_Grado where "
                + "Año="+anio+" and Codigo_grado="+codGrado+";";
        try {
            Connection cn = con.conectar();
            con.st = cn.createStatement();
            con.rs = con.st.executeQuery(sqlST);
            while(con.rs.next()){
                codareasDoc.add(con.rs.getInt(1));
            }
            cn.close();
        } catch (SQLException e) {}
        return codareasDoc;
    }
  
    
    public void insertar(GradoDocencia gd,int codAreaDocente){
        int anio=gd.getAnio();
        String[] partes= gd.getGrado().getGrado().split(",");
        int codGrado=Integer.parseInt(partes[1]);
        
        String sqlST="INSERT INTO docente_grado(Año,Codigo_Grado,Codigo_Docente_Area)"
                + " VALUES (?,?,?);";
        try {
            Connection cn = con.conectar();
            con.pst =cn.prepareStatement(sqlST);
            con.pst.setInt(1, anio);
            con.pst.setInt(2, codGrado);
            con.pst.setInt(3, codAreaDocente);
            con.pst.executeUpdate();
            cn.close();
        } catch (SQLException e) {
            procesosAux.msjDialog("ERROR al insertar registro "+e);
        }
    }
    
    public void actualizar(int nuevoCod,int actualCod,int anio, int codGrado){
        String sqlST="update Docente_Grado set Codigo_Docente_Area=(?)"
                + "where Codigo_Docente_Area=(?) and Año=(?) and Codigo_grado=(?);";
        try {
            Connection cn = con.conectar();
            con.pst =cn.prepareStatement(sqlST);
            con.pst.setInt(1, nuevoCod);
            con.pst.setInt(2, actualCod);
            con.pst.setInt(3, anio);
            con.pst.setInt(4, codGrado);
            con.pst.executeUpdate();
            cn.close();
        } catch (SQLException e) {
        }
    }
    
    public void eliminar(int anio, int codGrado){
        String sqlST="delete from Docente_Grado where Año=(?) and Codigo_grado=(?);";
        try {
            Connection cn = con.conectar();
            con.pst =cn.prepareStatement(sqlST);
            con.pst.setInt(1, anio);
            con.pst.setInt(2, codGrado);
            con.pst.executeUpdate();
            cn.close();
            procesosAux.msjDialog("Regisro eliminado exitosamente");
        } catch (SQLException e) {
            procesosAux.msjDialog("ERROR al eliminar registro "+e);
        }
        
    }
    
    
    
}
