package DAO;

import Modelo.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// Clase DAO para buscar preguntas y respuestas y realizar cambios de contraseña
public class BuscarPYcambioC {

    // Método para obtener preguntas por usuario y actualizar el objeto Usuario con la información obtenida
    public Usuario obtenerPreguntasPorUsuario(Usuario us) {
        Conexion db = new Conexion(); // Objeto para gestionar la conexión a la base de datos

        try (Connection conexion = db.conectar();
             PreparedStatement stmt = conexion.prepareStatement("SELECT Pregunta1, Respuesta1, Pregunta2, Respuesta2, Pregunta3, Respuesta3 FROM preguntas WHERE Codigo_Usuario = ?")) {

            stmt.setString(1, us.getCodigo()); // Establecer el código de usuario en la consulta SQL

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    // Obtener las preguntas y respuestas del resultado
                    String pregunta1 = rs.getString("Pregunta1");
                    String respuesta1 = rs.getString("Respuesta1");
                    String pregunta2 = rs.getString("Pregunta2");
                    String respuesta2 = rs.getString("Respuesta2");
                    String pregunta3 = rs.getString("Pregunta3");
                    String respuesta3 = rs.getString("Respuesta3");

                    // Establecer las preguntas y respuestas en los arreglos de la clase Usuario
                    String[] preguntas = {pregunta1, pregunta2, pregunta3};
                    String[] respuestas = {respuesta1, respuesta2, respuesta3};

                    // Actualizar el objeto Usuario con las preguntas y respuestas
                    us.setPreg(preguntas);
                    us.setResp(respuestas);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return us; // Devolver el objeto Usuario actualizado
    }
}
