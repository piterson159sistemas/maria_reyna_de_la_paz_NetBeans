
package DAO;

import Modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RecopilarCodigo {

    public String Rcodigo(Usuario us) {
        Conexion db = new Conexion();
        Connection conexion = db.conectar();

        PreparedStatement stmt = null;
        ResultSet rs = null;
        String codigoUsuarioEncontrado = null;

        try {
            // Verificar el formato del código de usuario (Pxxxxxxx) para asegurarse de que es un docente
            String codigo = us.getCodigo();
            if (codigo != null && codigo.matches("P\\d{7}")) {
                String sql = "SELECT Codigo_Usuario FROM acceso WHERE Codigo_Usuario = ?";
                stmt = conexion.prepareStatement(sql);
                stmt.setString(1, codigo);

                rs = stmt.executeQuery();

                if (rs.next()) {
                    codigoUsuarioEncontrado = rs.getString("Codigo_Usuario");
                } else {
                    // Si no se encontró ningún usuario con ese código, devuelve null
                    codigoUsuarioEncontrado = null;
                }
            } else {
                // Si el código de usuario no cumple con el formato, no se encuentra en la base de datos
                codigoUsuarioEncontrado = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return codigoUsuarioEncontrado;
    }
    
    public String[] obtenerPreguntas(Usuario us) {
        Conexion db = new Conexion();
        Connection conexion = db.conectar();

        PreparedStatement stmt = null;
        ResultSet rs = null;
        String[] preguntas = new String[3];  // Asumimos que hay 3 preguntas por usuario

        try {
            // Antes de la llamada a stmt.setString(1, us.getCodigo());
            System.out.println("Código de usuario para la consulta: " + us.getCodigo());

            // Ajuste en la consulta SQL
            String sql = "SELECT Pregunta1, Pregunta2, Pregunta3 FROM preguntas WHERE Codigo_Preguntas = ?";
            stmt = conexion.prepareStatement(sql);
            stmt.setString(1, us.getCodigo());

            rs = stmt.executeQuery();

            if (rs.next()) {
                // Obtener las preguntas del resultado de la consulta y asignarlas al usuario
                us.getPreg()[0] = rs.getString("Pregunta1");
                us.getPreg()[1] = rs.getString("Pregunta2");
                us.getPreg()[2] = rs.getString("Pregunta3");

                // Obtener las preguntas del usuario
                preguntas[0] = us.getPreg()[0];
                preguntas[1] = us.getPreg()[1];
                preguntas[2] = us.getPreg()[2];

                // Dentro del bloque if (preguntas != null && preguntas.length == 3)
                System.out.println("Pregunta 1: " + preguntas[0]);
                System.out.println("Pregunta 2: " + preguntas[1]);
                System.out.println("Pregunta 3: " + preguntas[2]);
            } else {
                // Si no se encuentran preguntas para el usuario, devolver un array nulo
                preguntas = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return preguntas;
    }
    
    public String[] obtenerRespuestas(Usuario us) {
        Conexion db = new Conexion();
        Connection conexion = db.conectar();

        PreparedStatement stmt = null;
        ResultSet rs = null;
        String[] respuestas = new String[3];  // Asumimos que hay 3 respuestas por usuario

        try {
            String sql = "SELECT Respuesta1, Respuesta2, Respuesta3 FROM preguntas WHERE Codigo_Preguntas = ?";
            stmt = conexion.prepareStatement(sql);
            stmt.setString(1, us.getCodigo());

            rs = stmt.executeQuery();

            if (rs.next()) {
                respuestas[0] = rs.getString("Respuesta1");
                respuestas[1] = rs.getString("Respuesta2");
                respuestas[2] = rs.getString("Respuesta3");
            } else {
                // Manejar el caso en el que no se encuentran respuestas
                respuestas = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return respuestas;
    }
    
    public boolean actualizarContraseña(Usuario us, String nuevaContraseña) {
        Conexion db = new Conexion();
        Connection conexion = db.conectar();

        PreparedStatement stmt = null;
        boolean actualizacionExitosa = false;

        try {
            String sql = "UPDATE acceso SET Acceso = ? WHERE Codigo_Usuario = ?";
            stmt = conexion.prepareStatement(sql);
            stmt.setString(1, nuevaContraseña);
            stmt.setString(2, us.getCodigo());

            int filasAfectadas = stmt.executeUpdate();

            if (filasAfectadas > 0) {
                actualizacionExitosa = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Cerrar recursos
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return actualizacionExitosa;
    }
    
}
