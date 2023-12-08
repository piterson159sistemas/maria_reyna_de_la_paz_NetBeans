
package Test;

import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.text.NumberFormat;

public class MainTest {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Mostrar el cuadro de diálogo de entrada
            String input = showNumericInputDialog("Ingrese un número:");

            // Mostrar el resultado
            if (input != null) {
                JOptionPane.showMessageDialog(null, "Número ingresado: " + input);
            }
        });
    }

    private static String showNumericInputDialog(String message) {
        NumberFormat format = NumberFormat.getIntegerInstance();
        NumberFormatter formatter = new NumberFormatter(format);
        formatter.setValueClass(Integer.class);
        formatter.setMinimum(0); // Puedes ajustar el valor mínimo según tus necesidades
        formatter.setMaximum(Integer.MAX_VALUE); // Puedes ajustar el valor máximo según tus necesidades

        JFormattedTextField textField = new JFormattedTextField(formatter);
        textField.setColumns(10); // Puedes ajustar el tamaño del campo de texto según tus necesidades

        int result = JOptionPane.showConfirmDialog(null, textField, message, JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            return textField.getText();
        } else {
            return null;
        }
    }
}
