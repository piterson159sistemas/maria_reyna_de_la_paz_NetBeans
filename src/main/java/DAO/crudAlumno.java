
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
   
    public boolean buscarRegistroGradoAlumno(int[] data){
        
        String sqlST="select Codigo_Grado_Alumno from grado_alumno where Año="+data[0]
            + " and CodigoA="+data[1]+" and Codigo_Grado="+data[2]+" and"
            + " Codigo_EstadoGA="+data[3]+";";
        try {
            Connection cn = con.conectar();
            con.st = cn.createStatement();
            con.rs = con.st.executeQuery(sqlST);

            if(con.rs.next()){
                return true;
            }
            } catch (SQLException e) {}
        return false;
   }
    
   public int obtenerCodGrado(String Nivel,String Grado){
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
        } catch (SQLException e) {
            
        }
        return codGrado;
   } 
   
   public int obtenerCodEstado(String Estado){
       int codEstado=0;
        String sqlST="select Codigo_EstadoGA from estado_grado_alumno where "
                + "Estado like '"+Estado+"';";
        try {
            Connection cn = con.conectar();
            con.st = cn.createStatement();
            con.rs = con.st.executeQuery(sqlST);
            
            if(con.rs.next()){
                codEstado= con.rs.getInt(1);
            }
        } catch (SQLException e) {
            
        }
        return codEstado; 
   } 
    
    
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
        String sqlST="select Grado from grado where Nivel='"+nivel+"';";
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
    
    public String[] BuscarAlumno(int numDoc){
        String data[]= new String[5];
        String sqlST="Select N_DocumentoA,Tipo_Documento,Nombres,Apellido_P,Apellido_M"
                + " from alumno where N_DocumentoA="+numDoc+";";
        try {
            Connection cn = con.conectar();
            con.st = cn.createStatement();
            con.rs = con.st.executeQuery(sqlST);
            if(con.rs.next()){
                data[0]=String.valueOf(con.rs.getInt(1));
                for(int i=1;i<5;i++){
                    data[i]=con.rs.getString(i+1);
                }
            }
        } catch (Exception e) {
        }
        return data;
    }
    
    public String[] buscarGradoAlumno(int codGradoAlumno){
        String[] data=new String[4];
        String sqlST="select  ga.Año, g.Nivel,g.Grado,ega.Estado from grado_alumno ga"
                +" inner join grado g on (ga.Codigo_Grado=g.Codigo_Grado)" 
                + " inner join estado_grado_alumno ega on "
                + " (ga.Codigo_EstadoGA=ega.Codigo_EstadoGA)" 
                + " where Codigo_Grado_Alumno="+codGradoAlumno+";";
        try {
            Connection cn = con.conectar();
            con.st = cn.createStatement();
            con.rs = con.st.executeQuery(sqlST);
            if(con.rs.next()){
                data[0]=(con.rs.getString(1)).substring(0, 4);;
                for(int i=1;i<4;i++){
                    data[i]=con.rs.getString(i+1);    
                }
            }
        }catch (SQLException e) {
            ProcesosAlumnos.msjDialog("ERROR al buscar GradoAlumno "+e);
        }
        return data;
        
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
        String[] Titulos= {"Cod","Alumno","Estado","Estado","codGradoAlumno"};
        DefaultTableModel tableModel = new DefaultTableModel(null,Titulos);
        tabla.setModel(tableModel);
        
        //Se configura para que no sea editable
        tabla.setDefaultEditor(Object.class, null);
        
        /* consulta para extraer [cod. alumno, nombre completo, estado de grado]
         de todos los alumnos del colegio */
        String sqlStatement="select a.N_DocumentoA as cod,"
                +" concat(Nombres,' ',Apellido_P,' ',Apellido_M)"
                +" as Alumno, e.Estado,g.Codigo_Grado_Alumno from grado_alumno g" 
                +" inner join alumno a on (g.CodigoA = a.N_DocumentoA)" 
                +" inner join estado_grado_alumno e on"
                +" (g.Codigo_EstadoGA = e.Codigo_EstadoGA) "
                +filtroCompleto+" ;";
        
        Object[] dataAlumno = new Object[5];
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
                //codGrado_Alumno
                dataAlumno[4]= con.rs.getInt(4);
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
    
    public void insertarAlumno(Alumno a){
        String sqlST="INSERT INTO alumno (?,?,?,?,?)";
        try{
            Connection cn = con.conectar();
            con.pst =cn.prepareStatement(sqlST);
            con.pst.setInt(1, a.getNumDocumento());
            con.pst.setString(2, a.getTipoDocumento());
            con.pst.setString(3, a.getNombre());
            con.pst.setString(4, a.getApellidoP());
            con.pst.setString(5, a.getApellidoM());
            con.pst.executeUpdate();
            ProcesosAlumnos.msjDialog("Alumno registrado  exitosamente");
            cn.close();
        } catch (SQLException e) {
            ProcesosAlumnos.msjDialog("ERROR al registrar alumno "+e);
        }
    }

    public void insertarGradoAlumno(int[] data){
        String sqlST="insert into grado_alumno(Año,CodigoA,Codigo_Grado,Codigo_EstadoGA)"
                + " values (?,?,?,?);";
                
        try {
            Connection cn = con.conectar();
            con.pst =cn.prepareStatement(sqlST);
            con.pst.setInt(1, data[0]);
            con.pst.setInt(2,  data[1]);
            con.pst.setInt(3,  data[2]);
            con.pst.setInt(4,  data[3]);
            con.pst.executeUpdate();
            ProcesosAlumnos.msjDialog("Informacion de grado ingresada exitosamente");
            cn.close();
        } catch (SQLException e) {
            ProcesosAlumnos.msjDialog("ERROR al ingresar informaci+on de grado "+e);
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
    
    public void eliminarGradoAlumno(int codGradoAlumno){
        String sqlST="DELETE from grado_alumno where Codigo_Grado_Alumno=(?);";
        
        try {
            Connection cn = con.conectar();
            con.pst =cn.prepareStatement(sqlST);
            con.pst.setInt(1, codGradoAlumno);
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
    
    public void actualizarAlumno( ArrayList<String> data,int codAlumno){
        String sqlST="UPDATE alumno set Nombres=(?),Apellido_P=(?),Apellido_M=(?)"
                + " where N_DocumentoA="+codAlumno+";";
        try {
            Connection cn = con.conectar();
            con.pst =cn.prepareStatement(sqlST);
            con.pst.setString(1, data.get(2));
            con.pst.setString(2, data.get(3));
            con.pst.setString(3, data.get(4));
            con.pst.executeUpdate();
            ProcesosAlumnos.msjDialog("Alumno actualizado exitosamente");
            cn.close();
        } catch (SQLException e) {
            ProcesosAlumnos.msjDialog("ERROR al actualizar registro "+e);
        }
    }
    
    public void actualizarGradoAlumno(int[] data,int codGradoAlumno){
        String sqlST="UPDATE grado_alumno set Año=(?),Codigo_Grado=(?),Codigo_EstadoGA=(?)"
            + " where Codigo_Grado_Alumno="+codGradoAlumno+";";
    
        try {
            Connection cn = con.conectar();
            con.pst =cn.prepareStatement(sqlST);
            con.pst.setInt(1, data[0]);
            con.pst.setInt(2, data[1]);
            con.pst.setInt(3, data[2]);
            con.pst.executeUpdate();
            ProcesosAlumnos.msjDialog("Informacion de Grado actualizada exitosamente");
            cn.close();
        } catch (SQLException e) {
            ProcesosAlumnos.msjDialog("ERROR al actualizar informacion de grado "+e);
        }
    }
     
}
