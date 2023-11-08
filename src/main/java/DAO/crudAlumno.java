
package DAO;

import Procesos.ProcesosAlumnos;
import Modelo.Alumno;
import Modelo.GradoAlumno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
    ResultSet rs;
    
    public boolean BuscarCodigo(String codigo){
        boolean codigoExiste=true;
        String sqlST="select N_DocumentoA from alumno where N_DocumentoA="+codigo+";";
        try {
            Connection cn = con.conectar();
            con.st = cn.createStatement();
            con.rs = con.st.executeQuery(sqlST);
            
            if(!(con.rs.next())){ //si no se encuentra un registro en la busqueda
                codigoExiste=false;
            }
        } catch (Exception e) {
            
        }
        return codigoExiste;
    }
    
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
            cn.close();
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
        String sqlST="Select a.N_DocumentoA, a.Tipo_Documento, a.Nombres,"
                +" a.Apellido_P, a.Apellido_M, g.Nivel, g.Grado, e.Estado,"
                +" ga.Año, ga.Codigo_Grado_Alumno"
                +" from grado_alumno ga" 
                +" inner join alumno a on (ga.CodigoA = a.N_DocumentoA)" 
                +" inner join grado g on (ga.Codigo_Grado = g.Codigo_Grado)" 
                +" inner join estado_grado_alumno e on (ga.Codigo_EstadoGA = e.Codigo_EstadoGA)"
                +" where a.N_DocumentoA='"+numDoc+"'"
                +" and e.Estado='"+estado+"';";
        String[] dataAlumno=new String[10];
        int longitud=dataAlumno.length;
        try {
            Connection cn = con.conectar();
            con.st = cn.createStatement();
            con.rs = con.st.executeQuery(sqlST);
            if(con.rs.next()){
                //1° dato es dni del alumno
                dataAlumno[0]= Integer.toString(con.rs.getInt(1));
                
                // este campo devuelve una fecha, lo convertimos a Año "YYYY"
                dataAlumno[8]= (con.rs.getString(9)).substring(0, 4);
                
                /* este campo devuelve el cod del registro exacto encontrado
                en la tabla GradoAlumno */
                dataAlumno[9]= String.valueOf(con.rs.getInt(10));
                for (int i = 1; i < longitud-2; i++) {
                    dataAlumno[i]= con.rs.getString(i+1);
                }
            }
            cn.close();
        } catch (SQLException e) {
            ProcesosAlumnos.msjDialog("ERROR al buscar alumno de la Tabla "+e);
        }
        return dataAlumno;
    }
    
    //Filra a los alumnos en la tabla segun nivel,grado y estadoGrado
    public String Filtrar(String nivel, String grado,String estadoGrado,
            String nombre,String anio){
        
       StringBuilder sb = new StringBuilder();
        // 1° Filtro: Nivel 
        String filtroNG,filtroEst = " ",filtroAnio=" ",filtroNom=" ";
        if(!(nivel.equals("..."))){ //Si el nivel es diferente a "..."
        // 2° Filtro: Nivel y Grado
            if(!(grado.equals("..."))){  // y si además el grado es diferente a "..."
                // Filtrando por Nivel y grado
                filtroNG= " where Codigo_Grado"
                        +" =(select Codigo_Grado from grado where Grado='"+grado+"'"
                        +" and Nivel='"+nivel+"')";                       
                
            }else{ //Filtrando solo por Nivel
                switch(nivel){
                    case "Inicial" ->  filtroNG=" where Codigo_Grado<=3";
                    case "Primaria" ->  filtroNG=" where Codigo_Grado>3 and Codigo_Grado<=9";
                    default ->  filtroNG=" where Codigo_Grado >9";  
                }
            }
        }else{ //Sin filtrar por nivel y grado
            filtroNG=" where Codigo_Grado is not null"; 
        }

        // 3° Filtro: Estado
        
        if( !( estadoGrado.equals("...") ) ){ 
            switch(estadoGrado){
                case "Aprobado" -> filtroEst=" and e.Estado='Aprobado'";
                case "En Curso" -> filtroEst=" and e.Estado='En Curso'";
                case "Desaprobado"-> filtroEst=" and e.Estado='Desaprobado'";
                default -> filtroEst=" and e.Estado='Retirado'";

            }
        }
        
        //4° Filtro: nombre completo Alumno    
        if( (nombre != null) && !(nombre.isBlank()) ){ //si nombre no esta vacio y no es nulo
            filtroNom=" and concat(Nombres,' ',Apellido_P,' ',Apellido_M) like '"
                    +nombre+"'";
        }
        
        //5° Filtro: Año
        if(!(anio.isBlank()) && (anio != null)){ //si el año no está vacio y no es nulo
            filtroAnio=" and Año='"+anio+"'";
        } 
        return sb.append(filtroNG).append(filtroEst).append(filtroNom).
                append(filtroAnio).toString();
        
    }
    
    //Lista los alumnos en una tabla
    public void Listar(JTable tabla, JLabel cantAulmnos,String filtroCompleto){
        //Definimos un modelo de encabezados para la tabla 
        String[] Titulos= {"Cod","Alumno","Estado","Estado"};
        DefaultTableModel tableModel = new DefaultTableModel(null,Titulos);
        tabla.setModel(tableModel);
        
        //Se configura para que no sea editable
        tabla.setDefaultEditor(Object.class, null);
        
        /* consulta para extraer [cod. alumno, nombre completo, estado de grado]
         de todos los alumnos del colegio */
        String sqlStatement="select a.N_DocumentoA as cod,"
                +" concat(Nombres,' ',Apellido_P,' ',Apellido_M)"
                +" as Alumno, e.Estado from grado_alumno g" 
                +" inner join alumno a on (g.CodigoA = a.N_DocumentoA)" 
                +" inner join estado_grado_alumno e on"
                +" (g.Codigo_EstadoGA = e.Codigo_EstadoGA) "
                +filtroCompleto+" ;";
        
        Object[] dataAlumno = new Object[4];
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
                dataAlumno[3]= con.rs.getString(3);
                tableModel.addRow(dataAlumno);
                
            }
            cantAulmnos.setText(Integer.toString(cantRegisttros));
            cn.close();
        } catch (SQLException e) {
            ProcesosAlumnos.msjDialog("ERROR al mostrar la lista de Alumnos "+e);
        }
    }
    
    /*
            ****************************************************
            *                     INSERTAR                     *
            ****************************************************
    */
    
    public void InsertarAlumno(Alumno a,Connection cn)throws SQLException{
        String sqlST="INSERT INTO Alumno(N_DocumentoA,Tipo_Documento,Nombres,"
                + "Apellido_P,Apellido_M) values(?,?,?,?,?);";
        try( PreparedStatement st=cn.prepareStatement(sqlST)){
            st.setInt(1, a.getNumDocumento());
            st.setString(2, a.getTipoDocumento());
            st.setString(3, a.getNombre());
            st.setString(4, a.getApellidoP());
            st.setString(5, a.getApellidoM());
            st.executeUpdate();
        }
        
    }
    
    
    public int obtenerCodGrado(String grado,String nivel){
        int codGrado=0;
        String sqlST="select Codigo_Grado from grado"
        +" where Grado like '"+grado+"' and Nivel like '"+nivel+"';";
        try{
            Connection cn = con.conectar();
            con.st = cn.createStatement();
            con.rs = con.st.executeQuery(sqlST);
            if(con.rs.next()){
                codGrado=con.rs.getInt(1);
            }
            cn.close();
        }catch(SQLException e){}
        
        return codGrado;
    }
    
    public int obtenerCodEstado(String estado){
        int codEstado=0;
        String sqlST="select Codigo_EstadoGA from"
                +" estado_grado_alumno WHERE Estado like '"+estado+"';";
        try{
            Connection cn = con.conectar();
            con.st = cn.createStatement();
            con.rs = con.st.executeQuery(sqlST);       
            if(con.rs.next()){
                codEstado=con.rs.getInt(1);
            }
            cn.close();
        }catch(Exception e){} 
        return codEstado;
    }
    
    public void InsertarGradoAlumno(int anio,int codAlum,int codGrado, int codEstado,
            Connection cn) throws SQLException{
        String sqlST="INSERT INTO grado_alumno"
                + " (Año,CodigoA,Codigo_Grado,Codigo_EstadoGA)"
                + " values ( (?),?,?,?);";
        try( PreparedStatement st=cn.prepareStatement(sqlST) ){
            st.setInt(1, anio);
            st.setInt(2, codAlum);
            st.setInt(3, codGrado);
            st.setInt(4, codEstado);
            st.executeUpdate(); 
         
        }
    }
    
    public void Insertar(Alumno a,int codGrado, int codEstado){
        Connection cn=null;
        try{
           cn = con.conectar(); //establece conexion
           /* Deshabilita la confirmación automática(autocommit) para
           inicar la transacción */
           cn.setAutoCommit(false);
           //Realizamos las operaciones de insercion en la bd
            InsertarAlumno(a, cn); // 1° op

            int codAlum = a.getNumDocumento();
            int anio=a.getGradoAlumno().getAnio();
            
            InsertarGradoAlumno(anio, codAlum,codGrado,codEstado, cn); // 2° op
            
            cn.commit(); //confirma la transacción
            
            ProcesosAlumnos.msjDialog("Alumno registrado correctamente");
           
        }catch (SQLException e){
            //si ocurre un error deshace la transacción(rollback)
            if (cn != null) {
                try { cn.rollback(); } 
                catch (SQLException ex) {
                    ProcesosAlumnos.msjDialog("ERROR al registrar al alumno");
                    ex.printStackTrace(System.out);
                }
            }
            e.printStackTrace(System.out);
        }finally{
            if (cn != null) {
                try { 
                    cn.setAutoCommit(true);
                    cn.close(); } 
                catch (SQLException e) {e.printStackTrace(System.out);}
            }
        }
    }
    
        /*
            ****************************************************
            *                     ELIMINAR                     *
            ****************************************************
        */
    
    public void Eliminar(int NumDoc){
        String sqlStatement="DELETE FROM Alumno WHERE N_DocumentoA=(?);";
        
        try {
            Connection cn = con.conectar();
            con.pst =cn.prepareStatement(sqlStatement);
            con.pst.setInt(1, NumDoc);
            con.pst.executeUpdate();
            ProcesosAlumnos.msjDialog("Registro eliminado exitosamente");
            cn.close();
        } catch (SQLException e) {
            ProcesosAlumnos.msjDialog("ERROR al eliminar registro "+e);
        }
        
    }
    
        /*
            ****************************************************
            *                    ACTUALIZAR                    *
            ****************************************************
        */
    
    public void Actualizar(Alumno a,int codGrado, int codEstado,int codGradoAlumno){
        Connection cn=null;
        try{
           cn = con.conectar(); //establece conexion
           cn.setAutoCommit(false);
           //Realizamos las operaciones de actualizacion en la bd
            ActualizarAlumno(a, cn); // 1° op

            int anio=a.getGradoAlumno().getAnio();

            ActualizarGradoAlumno(anio, codGrado,codEstado,codGradoAlumno, cn); // 2° op

            cn.commit(); //confirma la transacción

            ProcesosAlumnos.msjDialog("Datos del Alumno actualizados correctamente");

        }catch (SQLException e){
            //si ocurre un error deshace la transacción(rollback)
            if (cn != null) {
                try { cn.rollback(); } 
                catch (SQLException ex) {
                    ProcesosAlumnos.msjDialog("ERROR al actualizar datos del alumno");
                    ex.printStackTrace(System.out);
                }
            }
            e.printStackTrace(System.out);
        }finally{
            if (cn != null) {
                try { 
                    cn.setAutoCommit(true);
                    cn.close(); } 
                catch (SQLException e) {e.printStackTrace(System.out);}
            }
        }
        
    }
    
    public void ActualizarAlumno(Alumno a,Connection cn) throws SQLException{
        String sqlST="UPDATE Alumno SET Nombres=(?), Apellido_P=(?),"
                + " Apellido_M=(?) WHERE N_DocumentoA=(?);";
        try(PreparedStatement st=cn.prepareStatement(sqlST)) {
            st.setString(1, a.getNombre());
            st.setString(2, a.getApellidoP());
            st.setString(3, a.getApellidoM());
            st.setInt(4, a.getNumDocumento());
            st.executeUpdate();
        } 
        
    }
    
    public void ActualizarGradoAlumno(int anio,int codGrado, int codEstado,
            int codGradoAlumno,Connection cn) throws SQLException{
        String sqlST="UPDATE grado_alumno SET Año=(?), Codigo_Grado=(?),"
                + " Codigo_EstadoGA=(?) WHERE Codigo_Grado_Alumno=(?);";
        try(PreparedStatement st=cn.prepareStatement(sqlST)) {
            st.setInt(1, anio );
            st.setInt(2, codGrado);
            st.setInt(3, codEstado);
            st.setInt(4, codGradoAlumno);
            st.executeUpdate();
        } 
        
    }
      
}
