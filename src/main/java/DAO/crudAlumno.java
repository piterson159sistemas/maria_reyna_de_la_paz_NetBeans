
package DAO;

import Procesos.ListaAlumnos;
import Modelo.Alumno;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class crudAlumno {
    Conexion con= new Conexion();
    
   public ArrayList<String> BuscarNombresAlumno(){
       ArrayList<String> nombres = new ArrayList<>();
       String sqlST="select concat(Nombres,' ',Apellido_P,' ',Apellido_M) as Alumno from alumno;";
       
       try {
            Connection cn = con.conectar();
            con.st = cn.createStatement();
            con.rs = con.st.executeQuery(sqlST);
            while(con.rs.next()){
                nombres.add(con.rs.getString(1));
            }
       } catch (SQLException e) {
       }
        return nombres;
   }
    
    
    public Queue<String> BuscarGrados(String nivel){
        Queue<String> grados = new LinkedList<>();
        String sqlST="select Grado from grado where Nivel=\""+nivel+"\";";
        try {
            Connection cn = con.conectar();
            con.st = cn.createStatement();
            con.rs = con.st.executeQuery(sqlST);
            while(con.rs.next()){
                grados.offer(con.rs.getString(1));
            }
            cn.close();
        } catch (SQLException e) {}
        
        return grados;
    }
    
    public Queue<String> BuscarNiveles(){
        Queue<String> niveles = new LinkedList<>();
        String sqlST="select DISTINCT Nivel from grado;";
        try {
            Connection cn = con.conectar();
            con.st = cn.createStatement();
            con.rs = con.st.executeQuery(sqlST);
            while(con.rs.next()){
                niveles.offer(con.rs.getString(1));
            }
            cn.close();
        } catch (SQLException e) {}
        
        return niveles;
    }
    
    
    //Busca un alumno de la tabla de alumnos
    public String[] Buscar(String numDoc,String estado){
        String sqlST="Select a.N_DocumentoA, a.Nombres, a.Apellido_P, a.Apellido_M"
                +" ,a.Tipo_Documento, g.Nivel, g.Grado, e.Estado from"
                +" grado_alumno ga" 
                +" inner join alumno a on (ga.CodigoA = a.N_DocumentoA)" 
                +" inner join grado g on (ga.Codigo_Grado = g.Codigo_Grado)" 
                +" inner join estado_grado_alumno e on (ga.Codigo_EstadoGA = e.Codigo_EstadoGA)"
                +" where a.N_DocumentoA='"+numDoc+"'"
                +" and e.Estado='"+estado+"';";
        String[] dataAlumno=new String[8];
        int max=dataAlumno.length;
        try {
            Connection cn = con.conectar();
            con.st = cn.createStatement();
            con.rs = con.st.executeQuery(sqlST);
            if(con.rs.next()){
                //1° dato es dni del alumno
                dataAlumno[0]= Integer.toString(con.rs.getInt(1));
                for (int i = 1; i < max; i++) {
                    dataAlumno[i]= con.rs.getString(i+1);
                }
            }
        } catch (SQLException e) {
            ListaAlumnos.msjDialog("ERROR al buscar alumno de la Tabla "+e);
        }
        return dataAlumno;
    }
    
    //Filra a los alumnos en la tabla segun nivel,grado y estadoGrado
    public String[] Filtrar(String nivel, String grado,String estadoGrado){
        String[] filtros = new String[3];
        
        // 1° Filtramos por nivel
        
        if(!(nivel.equals("..."))){ //Si el nivel es diferente a "..."
            
        // 2° Filtramos por grado
            if(!(grado.equals("..."))){  // y si además el grado es diferente a "..."
                // entonces filtramos por Nivel y grado
                filtros[0]= "=(select Codigo_Grado from grado where Grado=\""+grado+"\""
                        +" and Nivel=\""+nivel+"\")";                       
                
            }else{ //pero si el grado = "...", filtramos solo por Nivel
                switch(nivel){
                    case "Inicial" ->  filtros[0]="<=3";
                    case "Primaria" ->  filtros[0]=">3 and Codigo_Grado<=9";
                    default ->  filtros[0]=">9";  
                }
            }
        }else{ //Pero si el nivel = "..." mostramos todo(sin filtrar)
            filtros[0]="is not null"; 
        }

        // 3° Filtramos por Estado
        if( !( estadoGrado.equals("...") ) ){ //si el estadoGrado es diferente a "..."
            // filtramos segun un estado especifico
            switch(estadoGrado){
                case "Aprobado" -> filtros[1]="='Aprobado'";
                case "En Curso" -> filtros[1]="='En Curso'";
                case "Desaprobado"-> filtros[1]="='Desaprobado'";
                default -> filtros[1]="='Retirado'";

            }
       }else{ //si el estado = "..." mostramos todos los estados(sin filtrar)
            filtros[1]="is not null"; 
        }
        filtros[2]=""; // espacio designado por si se filtra por nombre en barra de busqueda
        
        return filtros;
    }
    
    //Lista los alumnos en una tabla
    public void Listar(JTable tabla, JLabel cantAulmnos,String[] filtros){
        //Definimos un modelo de encabezados para la tabla 
        String[] Titulos= {"Cod","Alumno","Estado"};
        DefaultTableModel tableModel = new DefaultTableModel(null,Titulos);
        tabla.setModel(tableModel);
        
        //Se configura para que no sea editable
        tabla.setDefaultEditor(Object.class, null);
        
        /* consulta para extraer [cod. alumno, nombre completo, estado de grado]
         de todos los alumnos del colegio */
        String sqlStatement="select a.N_DocumentoA as cod,"
                +" concat(Nombres,\" \",Apellido_P,\" \",Apellido_M)"
                +" as Alumno, e.Estado from grado_alumno g" 
                +" inner join alumno a on (g.CodigoA = a.N_DocumentoA)" 
                +" inner join estado_grado_alumno e on"
                +" (g.Codigo_EstadoGA = e.Codigo_EstadoGA) "
                +" where Codigo_Grado "+filtros[0]
                +" and e.Estado "+filtros[1]
                +" "+filtros[2]+" ;";
        
        Object[] dataAlumno = new Object[3];
        int cantRegisttros=0;
        try {
            Connection cn = con.conectar();
            con.st = cn.createStatement();
            con.rs = con.st.executeQuery(sqlStatement);
            
            while( con.rs.next()){
                cantRegisttros++;
                dataAlumno[0]= con.rs.getInt(1);
                dataAlumno[1]= con.rs.getString(2);
                dataAlumno[2]= con.rs.getString(3);
                tableModel.addRow(dataAlumno);
                
            }
            cantAulmnos.setText(Integer.toString(cantRegisttros));
            cn.close();
        } catch (SQLException e) {
            ListaAlumnos.msjDialog("ERROR al mostrar la lista de Alumnos "+e);
        }
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
            ListaAlumnos.msjDialog("Alumno registrado exitosamente");
            cn.close();
        }catch(SQLException e){
            ListaAlumnos.msjDialog("ERROR al registrar Alumno "+e);
        }
        
    }
    
    public void Eliminar(int NumDoc){
        String sqlStatement="DELETE FROM Alumno WHERE N_DocumentoA=(?);";
        
        try {
            Connection cn = con.conectar();
            con.pst =cn.prepareStatement(sqlStatement);
            con.pst.setInt(1, NumDoc);
            con.pst.executeUpdate();
            ListaAlumnos.msjDialog("Registro eliminado exitosamente");
            cn.close();
        } catch (SQLException e) {
            ListaAlumnos.msjDialog("ERROR al eliminar registro "+e);
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
            ListaAlumnos.msjDialog("Datos de Alumno actualizados exitosamente");
            cn.close();
        } catch (SQLException e) {
            ListaAlumnos.msjDialog("ERROR al Actializar registro "+e);
        }
        
    }
      
}
