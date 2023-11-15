package DAO;

import Modelo.Usuario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GestionarDocente {
    private static final String CONSULTA_SQL = "SELECT u.Nombres, u.Apellido_P, u.Apellido_M, u.Codigo_Usuario, u.N_Documento, a.Acceso, " +
            "p.Pregunta1, p.Respuesta1, p.Pregunta2, p.Respuesta2, p.Pregunta3, p.Respuesta3 " +
            "FROM usuario u " +
            "JOIN acceso a ON u.Codigo_Usuario = a.Codigo_Usuario " +
            "JOIN preguntas p ON u.Codigo_Usuario = p.Codigo_Preguntas";

    public List<Usuario> obtenerDatosDocentes() {
        List<Usuario> usuarios = new ArrayList<>();

        try (Connection connection = new Conexion().conectar();
             PreparedStatement ps = connection.prepareStatement(CONSULTA_SQL);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setNombre(rs.getString("Nombres"));
                usuario.setApellidoP(rs.getString("Apellido_P"));
                usuario.setApellidoM(rs.getString("Apellido_M"));
                usuario.setCodigo(rs.getString("Codigo_Usuario"));
                usuario.setNumDocumento(rs.getInt("N_Documento"));
                usuario.setClave(rs.getString("Acceso"));

                // Establecer preguntas y respuestas, asegurando que haya tres elementos
                usuario.setPreg(new String[]{
                        rs.getString("Pregunta1"),
                        rs.getString("Pregunta2"),
                        rs.getString("Pregunta3")
                });

                usuario.setResp(new String[]{
                        rs.getString("Respuesta1"),
                        rs.getString("Respuesta2"),
                        rs.getString("Respuesta3")
                });

                // Validar y asignar cadenas vacías para preguntas y respuestas nulas
                for (int i = 0; i < 3; i++) {
                    if (usuario.getPreg()[i] == null) {
                        usuario.getPreg()[i] = "";
                    }

                    if (usuario.getResp()[i] == null) {
                        usuario.getResp()[i] = "";
                    }
                }

                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            // Trata la excepción adecuadamente, ya sea registrándola o lanzándola de nuevo
            e.printStackTrace();
        }

        return usuarios;
    }
    // Otras operaciones DAO relacionadas con la entidad Usuario
}
