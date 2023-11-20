package DAO;

import Modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// Clase DAO para recopilar información relacionada con el código de usuario, preguntas, respuestas y contraseña
public class RecopilarCodigo {

    // Método para recopilar el código de usuario correspondiente a un Usuario dado
    public String recopilarCodigo(Usuario usuario) {
        Conexion conexionDB = new Conexion();
        Connection conexion = conexionDB.conectar();

        PreparedStatement stmt = null;
        ResultSet rs = null;
        String codigoUsuarioEncontrado = null;

        try {
            // Verificar el formato del código de usuario (Pxxxxxxx) para asegurarse de que es un docente
            String codigo = usuario.getCodigo();
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

        return codigoUsuarioEncontrado;
    }

    // Método para obtener las preguntas asociadas a un Usuario dado
    public String[] obtenerPreguntas(Usuario usuario) {
        Conexion conexionDB = new Conexion();
        Connection conexion = conexionDB.conectar();

        PreparedStatement stmt = null;
        ResultSet rs = null;
        String[] preguntas = new String[3];  // Asumimos que hay 3 preguntas por usuario

        try {
            String sql = "SELECT Pregunta1, Pregunta2, Pregunta3 FROM preguntas WHERE Codigo_Preguntas = ?";
            stmt = conexion.prepareStatement(sql);
            stmt.setString(1, usuario.getCodigo());

            rs = stmt.executeQuery();

            if (rs.next()) {
                // Obtener las preguntas del resultado de la consulta y asignarlas al usuario
                usuario.getPreg()[0] = rs.getString("Pregunta1");
                usuario.getPreg()[1] = rs.getString("Pregunta2");
                usuario.getPreg()[2] = rs.getString("Pregunta3");

                // Obtener las preguntas del usuario
                preguntas[0] = usuario.getPreg()[0];
                preguntas[1] = usuario.getPreg()[1];
                preguntas[2] = usuario.getPreg()[2];
            } else {
                // Si no se encuentran preguntas para el usuario, devolver un array nulo
                preguntas = null;
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

        return preguntas;
    }

    // Método para obtener las respuestas asociadas a un Usuario dado
    public String[] obtenerRespuestas(Usuario usuario) {
        Conexion conexionDB = new Conexion();
        Connection conexion = conexionDB.conectar();

        PreparedStatement stmt = null;
        ResultSet rs = null;
        String[] respuestas = new String[3];  // Asumimos que hay 3 respuestas por usuario

        try {
            String sql = "SELECT Respuesta1, Respuesta2, Respuesta3 FROM preguntas WHERE Codigo_Preguntas = ?";
            stmt = conexion.prepareStatement(sql);
            stmt.setString(1, usuario.getCodigo());

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

        return respuestas;
    }

    // Método para actualizar la contraseña de un Usuario dado
    public boolean actualizarContraseña(Usuario usuario, String nuevaContraseña) {
        Conexion conexionDB = new Conexion();
        Connection conexion = conexionDB.conectar();

        PreparedStatement stmt = null;
        boolean actualizacionExitosa = false;

        try {
            String sql = "UPDATE acceso SET Acceso = ? WHERE Codigo_Usuario = ?";
            stmt = conexion.prepareStatement(sql);
            stmt.setString(1, nuevaContraseña);
            stmt.setString(2, usuario.getCodigo());

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
