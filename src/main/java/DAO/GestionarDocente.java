package DAO;

import Modelo.Usuario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

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
  public boolean actualizarDocenteCompleto(Usuario docenteActualizado) {
    String UPDATE_USUARIO_SQL = "UPDATE usuario " +
            "SET Nombres=?, Apellido_P=?, Apellido_M=?, N_Documento=? " +
            "WHERE Codigo_Usuario=?";

    String UPDATE_ACCESO_SQL = "UPDATE acceso " +
            "SET Acceso=? " +
            "WHERE Codigo_Usuario=?";

    String UPDATE_PREGUNTAS_SQL = "UPDATE preguntas " +
            "SET Pregunta1=?, Respuesta1=?, Pregunta2=?, Respuesta2=?, Pregunta3=?, Respuesta3=? " +
            "WHERE Codigo_Preguntas=?";

    try (Connection connection = new Conexion().conectar();
         PreparedStatement psUsuario = connection.prepareStatement(UPDATE_USUARIO_SQL);
         PreparedStatement psAcceso = connection.prepareStatement(UPDATE_ACCESO_SQL);
         PreparedStatement psPreguntas = connection.prepareStatement(UPDATE_PREGUNTAS_SQL)) {

        // Establecer los parámetros del docente actualizado en la tabla 'usuario'
        psUsuario.setString(1, docenteActualizado.getNombre());
        psUsuario.setString(2, docenteActualizado.getApellidoP());
        psUsuario.setString(3, docenteActualizado.getApellidoM());
        psUsuario.setInt(4, docenteActualizado.getNumDocumento());
        psUsuario.setString(5, docenteActualizado.getCodigo());

        // Ejecutar la actualización en la tabla 'usuario'
        int filasAfectadasUsuario = psUsuario.executeUpdate();

        // Establecer los parámetros del docente actualizado en la tabla 'acceso'
        psAcceso.setString(1, docenteActualizado.getClave());
        psAcceso.setString(2, docenteActualizado.getCodigo());

        // Ejecutar la actualización en la tabla 'acceso'
        int filasAfectadasAcceso = psAcceso.executeUpdate();

        // Establecer los parámetros del docente actualizado en la tabla 'preguntas'
        psPreguntas.setString(1, docenteActualizado.getPreg()[0]);
        psPreguntas.setString(2, docenteActualizado.getResp()[0]);
        psPreguntas.setString(3, docenteActualizado.getPreg()[1]);
        psPreguntas.setString(4, docenteActualizado.getResp()[1]);
        psPreguntas.setString(5, docenteActualizado.getPreg()[2]);
        psPreguntas.setString(6, docenteActualizado.getResp()[2]);
        psPreguntas.setString(7, docenteActualizado.getCodigo());

        // Ejecutar la actualización en la tabla 'preguntas'
        int filasAfectadasPreguntas = psPreguntas.executeUpdate();

        // Devolver true si al menos una fila fue afectada en ambas tablas
        return filasAfectadasUsuario > 0 && filasAfectadasAcceso > 0 && filasAfectadasPreguntas > 0;

    } catch (SQLException e) {
        // Manejar la excepción apropiadamente, ya sea registrándola o lanzándola de nuevo
        e.printStackTrace();
        return false;
    }
}
public boolean borrarDocente(String codigoUsuario) {
    String DELETE_ACCESO_SQL = "DELETE FROM acceso WHERE Codigo_Usuario=?";
    String DELETE_PREGUNTAS_SQL = "DELETE FROM preguntas WHERE Codigo_Preguntas=?";
    String DELETE_USUARIO_SQL = "DELETE FROM usuario WHERE Codigo_Usuario=?";

    try (Connection connection = new Conexion().conectar();
         PreparedStatement psAcceso = connection.prepareStatement(DELETE_ACCESO_SQL);
         PreparedStatement psPreguntas = connection.prepareStatement(DELETE_PREGUNTAS_SQL);
         PreparedStatement psUsuario = connection.prepareStatement(DELETE_USUARIO_SQL)) {

        // Establecer el parámetro del código de usuario en las tablas correspondientes
        psAcceso.setString(1, codigoUsuario);
        psPreguntas.setString(1, codigoUsuario);
        psUsuario.setString(1, codigoUsuario);

        // Ejecutar la eliminación en la tabla 'acceso'
        int filasAfectadasAcceso = psAcceso.executeUpdate();

        // Ejecutar la eliminación en la tabla 'preguntas'
        int filasAfectadasPreguntas = psPreguntas.executeUpdate();

        // Ejecutar la eliminación en la tabla 'usuario'
        int filasAfectadasUsuario = psUsuario.executeUpdate();

        // Devolver true si al menos una fila fue afectada en todas las tablas
        return filasAfectadasAcceso > 0 && filasAfectadasPreguntas > 0 && filasAfectadasUsuario > 0;

    } catch (SQLException e) {
        // Manejar la excepción apropiadamente, ya sea registrándola o lanzándola de nuevo
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error al borrar docente: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        return false;
    }
}




}
