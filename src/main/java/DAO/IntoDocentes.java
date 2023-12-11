package DAO;

import Modelo.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.List;
import javax.swing.JOptionPane;

public class IntoDocentes {

    public String guardarUsuario(Usuario us) {
        Conexion db = new Conexion();
        String nuevoCodigoUsuario = null;
        Connection conexion = db.conectar();

        try {
            // Obtener el último código de usuario registrado
            String consultaUltimoCodigoSQL = "SELECT MAX(Codigo_Usuario) FROM usuario";
            Statement stmt = conexion.createStatement();
            ResultSet resultSet = stmt.executeQuery(consultaUltimoCodigoSQL);

            //extraer los 2 últimos dígitos del año
            int dosdigitosaño = LocalDate.now().getYear() % 100;

            //extraer el mes en número
            String mesdosdigitos = String.format("%02d", LocalDate.now().getMonthValue());

            //extraer el día en número
            String diadosdigitos = String.format("%02d", LocalDate.now().getDayOfMonth());

            //crear el formato del código profesor
            String formatodocente = "P" + dosdigitosaño + mesdosdigitos + diadosdigitos;

            if (resultSet.next()) {
                String ultimoCodigo = resultSet.getString(1);
                if (ultimoCodigo != null && ultimoCodigo.startsWith(formatodocente)) {
                    // Extraer los dos últimos dígitos
                    String ultimosDigitos = ultimoCodigo.substring(ultimoCodigo.length() - 2);

                    // Incrementar el número y formatearlo para asegurarse de que tenga dos dígitos
                    int numero = Integer.parseInt(ultimosDigitos) + 1;
                    String nuevoNumero = String.format("%02d", numero);

                    nuevoCodigoUsuario = formatodocente + nuevoNumero;
                } else {
                    // No hay ningún registro previo, generar el primer código
                    nuevoCodigoUsuario = formatodocente + "01";
                }
            }

            // Consulta preparada para insertar en la tabla usuario
            String insertUsuarioSQL = "INSERT INTO usuario (Codigo_Usuario, N_Documento, Nombres, Apellido_P, Apellido_M) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmtUsuario = conexion.prepareStatement(insertUsuarioSQL);
            stmtUsuario.setString(1, nuevoCodigoUsuario);
            stmtUsuario.setInt(2, us.getNumDocumento());
            stmtUsuario.setString(3, us.getNombre());
            stmtUsuario.setString(4, us.getApellidoP());
            stmtUsuario.setString(5, us.getApellidoM());

            // Consulta preparada para insertar en la tabla acceso
            String insertAccesoSQL = "INSERT INTO acceso (Codigo_Usuario, Acceso) VALUES (?, ?)";
            PreparedStatement stmtAcceso = conexion.prepareStatement(insertAccesoSQL);
            stmtAcceso.setString(1, nuevoCodigoUsuario);
            stmtAcceso.setString(2, us.getClave());

            // Consulta preparada para insertar en la tabla preguntas
            String insertPreguntasSQL = "INSERT INTO preguntas (Codigo_Preguntas, Pregunta1, Respuesta1, Pregunta2, Respuesta2, Pregunta3, Respuesta3) VALUES (?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement stmtPreguntas = conexion.prepareStatement(insertPreguntasSQL);
            stmtPreguntas.setString(1, nuevoCodigoUsuario);
            String[] preguntas = us.getPreg();
            String[] respuestas = us.getResp();
            for (int i = 0; i < 3; i++) {
                if (i < preguntas.length) {
                    stmtPreguntas.setString(2 + i * 2, preguntas[i]); // Pregunta
                }
                if (i < respuestas.length) {
                    stmtPreguntas.setString(3 + i * 2, respuestas[i]); // Respuesta
                }
            }

            // Ejecutar las consultas preparadas
            stmtUsuario.executeUpdate();
            stmtAcceso.executeUpdate();
            stmtPreguntas.executeUpdate();

            JOptionPane.showMessageDialog(null, "Guardado correctamente");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error SQL: " + e.getMessage());
            e.printStackTrace();
            return null;
        }

        return nuevoCodigoUsuario;
    }

    public String obtenerNombreUsuario(String codigoUsuario) {
        Conexion db = new Conexion();
        String nombreUsuario = "";

        try ( Connection conexion = db.conectar();  PreparedStatement stmt = conexion.prepareStatement("SELECT Nombres FROM usuario WHERE Codigo_Usuario = ?")) {

            stmt.setString(1, codigoUsuario);

            try ( ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    // Obtener el nombre del resultado
                    nombreUsuario = rs.getString("Nombres");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return nombreUsuario;
    }

    public String insertarDocenteArea(Usuario usu, List<String> areas) throws SQLException {

        try ( Connection conexion = new Conexion().conectar()) {
            // Consulta preparada para insertar en la tabla docente_area
            String insertAreaSQL = "INSERT INTO docente_area (Codigo_Usuario, Codigo_Area) VALUES (?, ?)";
            try ( PreparedStatement stmtArea = conexion.prepareStatement(insertAreaSQL)) {
                for (String area : areas) {
                    stmtArea.setString(1, usu.getCodigo()); // Considerando que el código de usuario se obtiene de la instancia de Usuario
                    stmtArea.setString(2, area);
                    
                    // Ejecutar la consulta preparada para cada área seleccionada
                    stmtArea.executeUpdate();
                }
                JOptionPane.showMessageDialog(null, "for corriendo correctamente de inserts");
                
            } catch (SQLException ft) {
                
                JOptionPane.showMessageDialog(null, "error en el for insertar" + ft.getMessage());
                ft.printStackTrace();
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error al conectar a la base de datos: " + e.getMessage();
        }
        
        return null;
 }
}
