package DAO;

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

public class DAOHorario {
    Conexion con=new Conexion();
    ResultSet rs;
//////////////////
// SELECT
//////////////////      
    public ArrayList<Integer> leerCodHorario(){
        ArrayList<Integer> codigosHorario = new ArrayList<>();
        String Dia = "Lunes";
        String sqlST="select Codigo_Horario from horario where Dia like '"+Dia+"';"; //declara el sql
        try {
            Connection cn = con.conectar(); //se realiza conexion a la bd "usamos el metodo conectar"
            con.st = cn.createStatement();  //se crea un objeto "statement"
            con.rs = con.st.executeQuery(sqlST);    //aqui llama el sql y se almacena en un objeto "resulSet"
            while (con.rs.next()) {                
               int codHorario = con.rs.getInt("Codigo_Horario");
               codigosHorario.add(codHorario);
            }
            // Cerramos los recursos (ResultSet, Statement)
            con.rs.close();
            con.st.close();
        } catch (SQLException e) {
            // Manejar la excepción según necesidades
            e.printStackTrace();
        }
        return codigosHorario;
    }
    
    public int obtenerUltimoCodigoHorario(int ultimoCodigo){
        ultimoCodigo=0;
        String sqlLST="SELECT MAX(Codigo_Horario) AS UltimoCodigo FROM horario;";
        try (Connection cn = con.conectar();
             PreparedStatement pst = cn.prepareStatement(sqlLST);
             ResultSet rs = pst.executeQuery()) {

            if (rs.next()) {
                ultimoCodigo = rs.getInt("UltimoCodigo");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ultimoCodigo;
    }
    
    public ArrayList<String> obtenerNombreGrados(){
        ArrayList<String> nombresGrados= new ArrayList<>();
        String sqlLST="select Grado from grado;";
        try (Connection cn=con.conectar();
            PreparedStatement pst=cn.prepareStatement(sqlLST);
            ResultSet rs = pst.executeQuery())
        {
            // Agrega los nombres de los grados al ArrayList
            while (rs.next()) {
                nombresGrados.add(rs.getString("Grado"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nombresGrados;
    }
    
    public ArrayList<String> obtenerNombreAreasI(){
        ArrayList<String> nombresAreas=new ArrayList<>();
        String sqlLST="select Area from area where Area<>'Educacion para el Trabajo' and Area<>'Educacion Fisica' and Area<>'Desarrollo Personal,Ciudadania y Civica' and Area<>'Ciencias Sociales';";
        try (Connection cn=con.conectar();
            PreparedStatement pst=cn.prepareStatement(sqlLST);
            ResultSet rs = pst.executeQuery())
        {
            // Agrega los nombres de los grados al ArrayList
            while (rs.next()) {
                nombresAreas.add(rs.getString("Area"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nombresAreas;
    }
    
    public ArrayList<String> obtenerNombreAreasP(){
        ArrayList<String> nombresAreas=new ArrayList<>();
        String sqlLST="select Area from area where Area<>'Educacion para el Trabajo' and Area<>'Psicomotriz' and Area<>'Desarrollo Personal,Ciudadania y Civica' and Area<>'Ciencias Sociales';";
        try (Connection cn=con.conectar();
            PreparedStatement pst=cn.prepareStatement(sqlLST);
            ResultSet rs = pst.executeQuery())
        {
            // Agrega los nombres de los grados al ArrayList
            while (rs.next()) {
                nombresAreas.add(rs.getString("Area"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nombresAreas;
    }
    
    public ArrayList<String> obtenerNombreAreasS(){
        ArrayList<String> nombresAreas=new ArrayList<>();
        String sqlLST="select Area from area where Area<>'Personal Social' and Area<>'Psicomotriz' and Area<>'Computacion';";
        try (Connection cn=con.conectar();
            PreparedStatement pst=cn.prepareStatement(sqlLST);
            ResultSet rs = pst.executeQuery())
        {
            // Agrega los nombres de los grados al ArrayList
            while (rs.next()) {
                nombresAreas.add(rs.getString("Area"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nombresAreas;
    }
    
    public ArrayList<ArrayList<Object>> obtenerInfoDocentes(){
        ArrayList<ArrayList<Object>> infoDocentes = new ArrayList<>();
        String sqlLST = "SELECT Grado, Año, a.Area, u.Nombres, u.Apellido_P, u.Apellido_M " +
                        "FROM docente_area da " +
                        "INNER JOIN docente_grado dg ON da.Codigo_Docente_Area = dg.Codigo_Docente_Area " +
                        "INNER JOIN grado g ON dg.Codigo_Grado = g.Codigo_Grado " +
                        "INNER JOIN usuario u ON da.Codigo_Usuario = u.Codigo_Usuario "+
                        "INNER JOIN area a ON da.Codigo_Area=a.Codigo_Area;";
        try (Connection cn = con.conectar();
             PreparedStatement pst = cn.prepareStatement(sqlLST);
             ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                ArrayList<Object> docenteInfo = new ArrayList<>();
                docenteInfo.add(rs.getString("Grado"));
                docenteInfo.add(rs.getString("Año"));
                docenteInfo.add(rs.getString("Area"));
                docenteInfo.add(rs.getString("Nombres"));
                docenteInfo.add(rs.getString("Apellido_P"));
                docenteInfo.add(rs.getString("Apellido_M"));

                infoDocentes.add(docenteInfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return infoDocentes;
    }
    
    public boolean existeHorario( String dia, String hora, int año, String grado) {
        String consulta = "SELECT COUNT(*) FROM horario h " +
                      "INNER JOIN docente_grado dg ON h.Codigo_docente_grado = dg.Codigo_docente_grado " +
                      "INNER JOIN grado g ON dg.Codigo_Grado = g.Codigo_Grado " +
                      "WHERE h.Dia = ? AND h.Horario = ? AND dg.Año = ? AND g.Grado = ?";
        int cantidad = 0;
        try (Connection conexion = con.conectar();
             PreparedStatement preparedStatement = conexion.prepareStatement(consulta)) {
            //preparedStatement.setInt(1, codigoHorario);
            preparedStatement.setString(1, dia);
            preparedStatement.setString(2, hora);
            preparedStatement.setInt(3, año);
            preparedStatement.setString(4, grado);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    cantidad = resultSet.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Manejo adecuado de excepciones en tu aplicación
        }
        return  cantidad>0;
    }
    
    public int obtenerCodigoDocenteGrado(String Año, String grado, String area){
        int codigoDocenteGrado=0;
        String consulta=  "SELECT dg.Codigo_docente_grado " +
                            "FROM docente_grado dg " +
                            "INNER JOIN grado g ON dg.Codigo_Grado = g.Codigo_Grado " +
                            "INNER JOIN docente_area da ON dg.Codigo_Docente_Area = da.Codigo_Docente_Area " +
                            "INNER JOIN area a ON da.Codigo_Area = a.Codigo_Area " +
                            "WHERE dg.Año = ? AND g.Grado = ? AND a.Area = ?";
        try (Connection conexion = con.conectar();
             PreparedStatement preparedStatement = conexion.prepareStatement(consulta)){
            preparedStatement.setString(1, Año);
            preparedStatement.setString(2, grado);
            preparedStatement.setString(3, area);
            try (ResultSet rs = preparedStatement.executeQuery()) {
                if (rs.next()) {
                    codigoDocenteGrado = rs.getInt("Codigo_docente_grado");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return codigoDocenteGrado;
    }
    
    public int obtenerCodigoHorario(String año, String grado, String dia, String horario){
        int codigoHorario=0;
        String consulta="SELECT h.Codigo_Horario " +
                        "FROM horario h " +
                        "INNER JOIN docente_grado dg ON h.Codigo_docente_grado = dg.Codigo_docente_grado " +
                        "INNER JOIN grado g ON dg.Codigo_Grado = g.Codigo_Grado " +
                        "WHERE dg.Año = ? AND g.Grado = ? AND h.Dia = ? AND h.Horario = ?";
        try (Connection conexion = con.conectar();
            PreparedStatement preparedStatement = conexion.prepareStatement(consulta)) {
            preparedStatement.setString(1, año);
            preparedStatement.setString(2, grado);
            preparedStatement.setString(3, dia);
            preparedStatement.setString(4, horario);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    codigoHorario = resultSet.getInt("Codigo_Horario");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Manejo adecuado de excepciones en tu aplicación
        }
        return codigoHorario;
    }
    
    public ArrayList<String> obtnerHorarioDia(String grado, String año){
        ArrayList<String> horarioDia=new ArrayList<>();
        String sqlLST="SELECT h.Dia " +
                      "FROM horario h " +
                      "INNER JOIN docente_grado dg ON dg.Codigo_docente_grado = h.Codigo_docente_grado " +
                      "INNER JOIN grado g ON dg.Codigo_Grado = g.Codigo_Grado " +
                      "WHERE g.Grado = ? AND dg.Año = ?";
        try (Connection cn=con.conectar();
            PreparedStatement pst=cn.prepareStatement(sqlLST)) {

            pst.setString(1, grado);
            pst.setString(2, año);

            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                horarioDia.add(rs.getString("Dia"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return horarioDia;
    }
    
    public ArrayList<String> obtnerHorarioHora(String grado, String año){
        ArrayList<String> horarioHora=new ArrayList<>();
        String sqlLST="SELECT h.Horario " +
                      "FROM horario h " +
                      "INNER JOIN docente_grado dg ON dg.Codigo_docente_grado = h.Codigo_docente_grado " +
                      "INNER JOIN grado g ON dg.Codigo_Grado = g.Codigo_Grado " +
                      "WHERE g.Grado = ? AND dg.Año = ?";
        try (Connection cn=con.conectar();
            PreparedStatement pst=cn.prepareStatement(sqlLST)) {

            pst.setString(1, grado);
            pst.setString(2, año);

            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                horarioHora.add(rs.getString("Horario"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return horarioHora;
    }
    
    public ArrayList<String> obtnerHorarioColor(String grado, String año){
        ArrayList<String> horarioColor=new ArrayList<>();
        String sqlLST="SELECT h.Color " +
                      "FROM horario h " +
                      "INNER JOIN docente_grado dg ON dg.Codigo_docente_grado = h.Codigo_docente_grado " +
                      "INNER JOIN grado g ON dg.Codigo_Grado = g.Codigo_Grado " +
                      "WHERE g.Grado = ? AND dg.Año = ?";
        try (Connection cn=con.conectar();
            PreparedStatement pst=cn.prepareStatement(sqlLST)) {

            pst.setString(1, grado);
            pst.setString(2, año);

            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                horarioColor.add(rs.getString("Color"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return horarioColor;
    }
    
    public ArrayList<String> obtnerHorarioArea(String grado, String año){
        ArrayList<String> horarioArea=new ArrayList<>();
        String sqlLST="SELECT h.Area " +
                      "FROM horario h " +
                      "INNER JOIN docente_grado dg ON dg.Codigo_docente_grado = h.Codigo_docente_grado " +
                      "INNER JOIN grado g ON dg.Codigo_Grado = g.Codigo_Grado " +
                      "WHERE g.Grado = ? AND dg.Año = ?";
        try (Connection cn=con.conectar();
            PreparedStatement pst=cn.prepareStatement(sqlLST)) {

            pst.setString(1, grado);
            pst.setString(2, año);

            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                horarioArea.add(rs.getString("Area"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return horarioArea;
    }
    
    
/*    public ArrayList<ArrayList<Object>> obtenerHorarioPorGradoYAño(String grado, String año){
        ArrayList<ArrayList<Object>> horarios=new ArrayList<>();
        String consulta = "SELECT h.Dia, h.Horario, h.Color, h.Area " +
                      "FROM horario h " +
                      "INNER JOIN docente_grado dg ON dg.Codigo_docente_grado = h.Codigo_docente_grado " +
                      "INNER JOIN grado g ON dg.Codigo_Grado = g.Codigo_Grado " +
                      "WHERE g.Grado = ? AND dg.Año = ?";
        try (Connection cn = con.conectar();
             PreparedStatement pst = cn.prepareStatement(consulta);
             ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                ArrayList<Object> horariosInfo = new ArrayList<>();
                horariosInfo.add(rs.getString("Dia"));
                horariosInfo.add(rs.getString("Horario"));
                horariosInfo.add(rs.getString("Color"));
                horariosInfo.add(rs.getString("Area"));
                
                horarios.add(horariosInfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return horarios;
    }*/
    
//////////////////
// INSERT
//////////////////    
    public void insertarHorario(int codigoHorario, String dia, String horario, int codigoDocenteGrado, String color, String area){
        //obtenemos el ultimo codigo de horario para tomarlo en cuenta e incrementar a partir de el para que no me salga error
        int ultimoCodigoHorario=obtenerUltimoCodigoHorario(codigoHorario);
        int nuevoCodigoHorario=ultimoCodigoHorario + 1; //hacer un increment si el ultimo codigo es 20 le aumenta 1 e insertaria 21 como codigo
        String sqlInsert = "INSERT INTO horario (Codigo_Horario, Dia, Horario, Color, Area, Codigo_docente_grado) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection cn = con.conectar();
             PreparedStatement pst = cn.prepareStatement(sqlInsert)) {

            pst.setInt(1, nuevoCodigoHorario);
            pst.setString(2, dia);
            pst.setString(3, horario);
            //
            pst.setString(4, color);
            pst.setString(5, area);
            pst.setInt(6, codigoDocenteGrado);

            // Ejecutar la inserción
            pst.executeUpdate();

            System.out.println("Insert exitoso en la tabla horario.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
//////////////////
// UPDATE 
////////////////// 
    public boolean actualizarHorario(int codigoHorario, String dia, String hora, int codigoDocenteGrado, String color, String area){
        boolean actualizado = false;
        String sqlU="UPDATE horario SET Dia=?, Horario=?, Color=?, Area=?, Codigo_docente_grado=? WHERE Codigo_Horario=?";
        try (Connection conn = con.conectar();
         PreparedStatement pstmt = conn.prepareStatement(sqlU)) {
        pstmt.setString(1, dia);
        pstmt.setString(2, hora);
        pstmt.setString(3, color);
        pstmt.setString(4, area);
        pstmt.setInt(5, codigoDocenteGrado);
        pstmt.setInt(6, codigoHorario);

        int rowsUpdated = pstmt.executeUpdate();
        actualizado = rowsUpdated > 0;
    } catch (SQLException e) {
        e.printStackTrace();
    }
    
    return actualizado;
    }
    
    
/*    public void mostrarInfoDocentes(JTable tblAreas) {
        ArrayList<String> infoDocentes = obtenerInfoDocentes();
        
        // Definir las columnas
        String[] columnas = {"Grado", "Año", "Nombres", "Apellido_P", "Apellido_M"};

        // Crear el modelo de la tabla
        DefaultTableModel modeloTabla = new DefaultTableModel(null, columnas);

        // Agregar los datos al modelo de la tabla
        for (String docenteInfo : infoDocentes) {
            String[] fila = docenteInfo.split(", ");
            modeloTabla.addRow(fila);
        }

        // Configurar la tabla con el modelo
        tblAreas.setModel(modeloTabla);
    }*/
        
        
    
    
/*    public String FiltrarANG(String año, String nivel, String grado){
        
       StringBuilder sb = new StringBuilder();
        // 1° Filtro: Nivel 
        String filtroNG = " ",filtroAnio=" ",filtroNom=" ";
        if(!(nivel.equals("..."))){ //Si el nivel es diferente a "..."
        // 2° Filtro: Nivel y Grado
            if(!(grado.equals("..."))){  // y si además el grado es diferente a "..."
                // Filtrando por Nivel y grado
                filtroNG= " where g.Codigo_Grado"
                        +" =(select Codigo_Grado from grado where Grado='"+grado+"'"
                        +" and Nivel='"+nivel+"')";                       
                
            }else{ //Filtrando solo por Nivel
                switch(nivel){
                    case "Inicial" ->  filtroNG=" where g.Codigo_Grado<=3";
                    case "Primaria" ->  filtroNG=" where g.Codigo_Grado>3 and Codigo_Grado<=9";
                    default ->  filtroNG=" where g.Codigo_Grado >9 ";  
                }
            }
        }else{ //Sin filtrar por nivel y grado
            filtroNG=" where Codigo_Grado is null or Codigo_Grado>=1 "; 
        }
        //3° Filtro: Año
        if(!(año.isBlank()) && (año != null)){ //si el año no está vacio y no es nulo
            filtroAnio=" and Año='"+año+"'";
        }
        
        
        
        if( !(filtroNom.isBlank()) && 
             filtroNG.equals(" where Codigo_Grado is null or Codigo_Grado>=1 ")){
            filtroNG=" where nombres is not null "; 
        }
       
        return sb.append(filtroNG).append(filtroAnio).toString();
        
    }*/
    
    //////
    //las consultas para cargar los combobox (Nivel y Grado esta en crudAlumno "BuscarGrados y BuscarNiveles ") usar esos metodos
    //////
/*    public ArrayList<String> leerNombreGrado(){
        ArrayList<String> grado=new ArrayList<>();
        String sqlLST="select Grado from grado;";
        try {
            Connection cn = con.conectar();
            con.st = cn.createStatement();
            con.rs = con.st.executeQuery(sqlLST);
            while (con.rs.next()) {                
               String gradoNombre= con.rs.getString("Grado");
               grado.add(gradoNombre);
            }
            con.rs.close();
            con.st.close();
        } catch (Exception e) {
            // Manejar la excepción según necesidades
            e.printStackTrace();
        }
        return grado;
    }*/
    //////

    public boolean existeHorario(String Dia, String Hora, String textoAño, String grado) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
}
