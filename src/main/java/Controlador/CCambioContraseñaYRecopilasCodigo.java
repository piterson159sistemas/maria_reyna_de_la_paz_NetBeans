package Controlador;

import DAO.RecopilarCodigo;
import Modelo.Usuario;
import Vista.recopilar_codigo_cambioContraseña;
import VISTA_CAMBIARCONTRA.CambiarContraseña;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

public class CCambioContraseñaYRecopilasCodigo implements ActionListener {
    private RecopilarCodigo RC;
    private Usuario us;
    private CambiarContraseña recocodi; // Vista

    public CCambioContraseñaYRecopilasCodigo(CambiarContraseña recocc) {
        // Constructor para la clase controladora
        recocodi = recocc;
        recocodi.btn_RevisarCodigo.addActionListener(this);
        recocodi.jbtnChequeo.addActionListener(this); // Agregado para manejar el nuevo botón "Listo"
        recocodi.btnActualizarz.addActionListener(this); // Agregado para manejar el botón de actualizar contraseña
        recocodi.btn_Cancelarr.addActionListener(this);
        recocc.setVisible(true);

        // Desactivar los campos de contraseña al inicio
        desactivarCamposContraseña();
    }

    private void desactivarCamposContraseña() {
        // Método para desactivar los campos de contraseña
        recocodi.jtxtNuevaContra.setEnabled(false);
        recocodi.jtxtNuevaContraRepitelo.setEnabled(false);
        recocodi.btnActualizarz.setEnabled(false);
    }

    private void activarCamposContraseña() {
        // Método para activar los campos de contraseña
        recocodi.jtxtNuevaContra.setEnabled(true);
        recocodi.jtxtNuevaContraRepitelo.setEnabled(true);
        recocodi.btnActualizarz.setEnabled(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == recocodi.btn_RevisarCodigo) {
            // Manejar el clic en el botón "Revisar Código"
            RC = new RecopilarCodigo();
            us = new Usuario();
            us.setCodigo(recocodi.Jtxt_RecopilarDato_codigo.getText());

            // Obtener las preguntas de seguridad
            String[] preguntas = RC.obtenerPreguntas(us);

            if (preguntas != null) {
                // Asignar preguntas a los JLabel correspondientes
                recocodi.jlbPregunta1.setText(preguntas[0]);
                recocodi.jlbPregunta2.setText(preguntas[1]);
                recocodi.jlbPregunta3.setText(preguntas[2]);

                // Obtener las respuestas
                String[] respuestas = RC.obtenerRespuestas(us);

                // Asignar respuestas a los JTextField correspondientes
                recocodi.jtxtPregunta1.setText("");
                recocodi.jtxtPregunta2.setText("");
                recocodi.jtxtPregunta3.setText("");

            } else {
                // Si no se encuentran preguntas para el usuario, mostrar un mensaje de error
                JOptionPane.showMessageDialog(null, "No se encontraron preguntas para el usuario.", "Error", JOptionPane.ERROR_MESSAGE);

                // Desactivar los campos de contraseña en caso de error
                desactivarCamposContraseña();
            }
        }

        if (e.getSource() == recocodi.jbtnChequeo) {
            // Verificar respuestas al hacer clic en el botón de Chequeo
            String respuesta1 = recocodi.jtxtPregunta1.getText();
            String respuesta2 = recocodi.jtxtPregunta2.getText();
            String respuesta3 = recocodi.jtxtPregunta3.getText();

            // Obtener las respuestas correctas desde la base de datos
            String[] respuestasCorrectas = RC.obtenerRespuestas(us);

            // Imprimir información de depuración
            System.out.println("Respuestas ingresadas: " + respuesta1 + ", " + respuesta2 + ", " + respuesta3);
            System.out.println("Respuestas correctas: " + respuestasCorrectas[0] + ", " + respuestasCorrectas[1] + ", " + respuestasCorrectas[2]);

            // Verificar si las respuestas ingresadas son correctas
            if (respuesta1.equals(respuestasCorrectas[0]) &&
                respuesta2.equals(respuestasCorrectas[1]) &&
                respuesta3.equals(respuestasCorrectas[2])) {
                JOptionPane.showMessageDialog(null, "Preguntas correctas. Puedes cambiar tu contraseña.");
                // Activar los campos de contraseña después de verificar las preguntas
                activarCamposContraseña();

            } else {
                JOptionPane.showMessageDialog(null, "Al menos una de las respuestas es incorrecta. Intenta de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        if (e.getSource() == recocodi.btnActualizarz) {
            // Aquí deberías tener la lógica para obtener las contraseñas nuevas
            String nuevaContraseña = recocodi.jtxtNuevaContra.getText();
            String nuevaContraseñaRepitelo = recocodi.jtxtNuevaContraRepitelo.getText();

            // Verificar si ambas contraseñas son iguales
            if (!nuevaContraseña.isEmpty() && !nuevaContraseñaRepitelo.isEmpty() && nuevaContraseña.equals(nuevaContraseñaRepitelo)) {
                // Ambas contraseñas son iguales, procede con la actualización
                boolean actualizacionExitosa = RC.actualizarContraseña(us, nuevaContraseña);

                if (actualizacionExitosa) {
                    // Mostrar el mensaje con la información del usuario
                    String mensajeBienvenida ="I.E.P. Maria Reyna de la Paz\n"
                            + "Su código institucional es: " + us.getCodigo() + "\n"
                            + "Su contraseña es: " + nuevaContraseña + "\n"
                            + "Anoté su correo institucional y su contraseña\n"
                            + "Por favor, no comparta con nadie su correo institucional o su contraseña a menos que un directivo se lo pida personalmente.";

                    JOptionPane.showMessageDialog(null, mensajeBienvenida);
                } else {
                    // Manejar la actualización de la contraseña no exitosa
                    // Puedes agregar lógica aquí si es necesario
                }
            }
        }
        
        if(e.getSource()== recocodi.btn_Cancelarr){
            recocodi.dispose();
        }
    }

  

    
}

