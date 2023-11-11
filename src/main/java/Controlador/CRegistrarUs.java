
package Controlador;
import DAO.IntoDocentes;
import Modelo.Usuario;
import Vista.crear_cuenta_docentes_directivo_1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class CRegistrarUs implements ActionListener{

    Usuario us;
    crear_cuenta_docentes_directivo_1 v;
    IntoDocentes intd = new IntoDocentes();
    private String nombre; // Variable para almacenar el nombre
    
    public CRegistrarUs(crear_cuenta_docentes_directivo_1 cd) {
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
                String pregunta1 = v.jTextFieldPregunta1.getText();
                String respuesta1 = v.jTextFieldRespuesta1.getText();
                String pregunta2 = v.jTextFieldPregunta2.getText();
                String respuesta2 = v.jTextFieldRespuesta2.getText();
                String pregunta3 = v.jTextFieldPregunta3.getText();
                String respuesta3 = v.jTextFieldRespuesta3.getText();
                
                
                
                
                String clave1 = v.jTextFieldClave.getText();
                String clave2 = v.textFieldClave2.getText(); // Segundo campo de contraseña

                
                
                // Validar que todos los campos obligatorios estén llenos
            if (nombre.isEmpty() || apellidoP.isEmpty() || apellidoM.isEmpty() || numeroDocumento == 0 || clave1.isEmpty() || clave2.isEmpty() ||
                pregunta1.isEmpty() || respuesta1.isEmpty() || pregunta2.isEmpty() || respuesta2.isEmpty() || pregunta3.isEmpty() || respuesta3.isEmpty()) {
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
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == v.jbtnRegistrar) {
            try {
                ValidacionYregistro();
                // Llamar al método para guardar el usuario en la base de datos
                intd.guardarUsuario(us);

                // Mostrar un mensaje de éxito
                JOptionPane.showMessageDialog(null, "Usuario registrado correctamente"+" "+nombre);
            } catch (Exception ex) {
                // Muestra un JOptionPane con el mensaje de error
                JOptionPane.showMessageDialog(null, "Error SQL: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
    }

    
}