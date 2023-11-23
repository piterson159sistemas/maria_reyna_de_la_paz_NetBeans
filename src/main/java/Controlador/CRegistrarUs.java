package Controlador;

import DAO.IntoDocentes;
import Modelo.Usuario;
import Vista.crear_cuenta_docentes_directivo_1;
import VISTA_DIRECTIVO.Docente_CrearDocent;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

// Controlador para la creación de cuentas de docentes en un entorno dirigido por un directivo
public class CRegistrarUs implements ActionListener {

    Usuario us;
    Docente_CrearDocent v;
    IntoDocentes intd = new IntoDocentes();
    private String nombre; // Variable para almacenar el nombre

    //variables de las areas
    String matematica, personalsocial, artecultura, comunicacion, cienciassociales, edufisica,
            ingles, religion, computacion, ciudadaniaetica, edutrabajo, cienciatecnologia, psicomotriz;

    public CRegistrarUs(Docente_CrearDocent cd) {
        v = cd;
        v.jbtnRegistrar.addActionListener(this);
        v.setTitle("Crear cuenta Docente");
        try {
            us = new Usuario();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al inicializar Usuario: " + e.getMessage());
        }
        v.setVisible(true);
    }

    public void ValidacionYregistro() {
        // Obtener valores de los campos de texto
        nombre = v.Jtxtnombre.getText();
        String apellidoP = v.jTextFieldApellidoP.getText();
        String apellidoM = v.jTextFieldApellidoM.getText();
        int numeroDocumento = Integer.parseInt(v.jTextFieldNumDocumento.getText());

        // Obtener valores de los campos de preguntas y respuestas
        String pregunta1 = v.jTextFieldPregunta1.getSelectedItem().toString();
        String respuesta1 = v.jTextFieldRespuesta1.getText();
        String pregunta2 = v.jTextFieldPregunta2.getSelectedItem().toString();
        String respuesta2 = v.jTextFieldRespuesta2.getText();
        String pregunta3 = v.jTextFieldPregunta3.getSelectedItem().toString();
        String respuesta3 = v.jTextFieldRespuesta3.getText();

        String clave1 = v.jTextFieldClave.getText();
        String clave2 = v.textFieldClave2.getText(); // Segundo campo de contraseña

        // Validar que todos los campos obligatorios estén llenos
        if (nombre.isEmpty() || apellidoP.isEmpty() || apellidoM.isEmpty() || numeroDocumento == 0 || clave1.isEmpty() || clave2.isEmpty()
                || pregunta1.isEmpty() || respuesta1.isEmpty() || pregunta2.isEmpty() || respuesta2.isEmpty() || pregunta3.isEmpty() || respuesta3.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Todos los campos obligatorios deben estar llenos.");
            return; // Salir del método si falta algún campo obligatorio
        }

        // Verificar si las contraseñas coinciden
        if (!clave1.equals(clave2)) {
            JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden. Por favor, verifíquelas.");
            return; // Salir del método si las contraseñas no coinciden
        }

        // Asignar valores al objeto Usuario
        us.setNombre(nombre);
        us.setApellidoP(apellidoP);
        us.setApellidoM(apellidoM);
        us.setNumDocumento(numeroDocumento);
        us.setClave(clave1);

        // Configurar las preguntas y respuestas en los arreglos
        String[] preguntas = {pregunta1, pregunta2, pregunta3};
        String[] respuestas = {respuesta1, respuesta2, respuesta3};
        us.setPreg(preguntas);
        us.setResp(respuestas);
    }

    public void validarareas() throws SQLException {
        
        
        try {//lplp
            
            // Lista para almacenar los valores de los checkboxes seleccionados
        List<String> areasSeleccionadas = new ArrayList<>();

// Obtener los valores del checkbox del campo elegir Áreas
        if (v.cb_PersonalSocial.isSelected()) {
            areasSeleccionadas.add("1");
        }
        if (v.cb_religion1.isSelected()) {
            areasSeleccionadas.add("2");
        }
        if (v.cb_comunicacion.isSelected()) {
            areasSeleccionadas.add("3");
        }
        if (v.cb_ArteCultura.isSelected()) {
            areasSeleccionadas.add("4");
        }
        if (v.cb_matematica.isSelected()) {
            areasSeleccionadas.add("5");
        }
        if (v.cb_ingles.isSelected()) {
            areasSeleccionadas.add("6");
        }
        if (v.cb_psicomotriz.isSelected()) {
            areasSeleccionadas.add("7");
        }
        if (v.cb_computacion.isSelected()) {
            areasSeleccionadas.add("8");
        }
        if (v.cb_EduFisica.isSelected()) {
            areasSeleccionadas.add("9");
        }
        if (v.cb_CiudadaniaCivica.isSelected()) {
            areasSeleccionadas.add("10");
        }
        if (v.cb_CienciasSociales.isSelected()) {
            areasSeleccionadas.add("11");
        }
        if (v.cb_EduTrabajo.isSelected()) {
            areasSeleccionadas.add("12");
        }
        if (v.cb_psicomotriz.isSelected()) {
            areasSeleccionadas.add("13");
        }

        // Iterar sobre la lista y realizar el insert para cada área seleccionada
        for (String area : areasSeleccionadas) {
            
            
            
        }
        
        JOptionPane.showMessageDialog(null, "si se pudo registrar las areas ");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en registrar las areas  " + e.getMessage());
        }
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == v.jbtnRegistrar) {
            try {
                ValidacionYregistro();
                validarareas();
                // Llamar al método para guardar el usuario en la base de datos
                String codigoUsuario = intd.guardarUsuario(us);

                // Obtener el nombre de usuario usando el método del DAO
                String nombreUsuario = intd.obtenerNombreUsuario(codigoUsuario);

                // Construir el mensaje para el JOptionPane
                String mensaje = "Bienvenido/a profesor/a " + nombreUsuario + " a la I.E.P. Maria Reyna de la Paz\n"
                        + "Su código institucional es: " + codigoUsuario + "\n"
                        + "Su contraseña es: " + us.getClave() + "\n"
                        + "Anoté su código institucional y su contraseña\n"
                        + "Por favor, no comparta con nadie su código institucional o su contraseña a menos que un directivo se lo pida personalmente.";

                // Mostrar un mensaje de éxito
                JOptionPane.showMessageDialog(null, "Usuario registrado correctamente\n" + mensaje);
            } catch (Exception ex) {
                // Muestra un JOptionPane con el mensaje de error
                JOptionPane.showMessageDialog(null, "Error SQL: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
    }
}
