
package Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class MainTest {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainTest().createAndShowGUI());
    }

    private void createAndShowGUI() {
        JFrame frame = new JFrame("JLabel Encima de JComboBox");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JComboBox<String> comboBox1 = new JComboBox<>(new String[]{"Mayor", "Menor"});
        JComboBox<String> comboBox2 = new JComboBox<>(new String[]{"Opción 1", "Opción 2", "Opción 3"});

        JLabel label = new JLabel("Etiqueta sobre JComboBox");
        label.setForeground(Color.RED);

        // Configurar la posición y el tamaño del JComboBox y JLabel
        comboBox1.setPreferredSize(new Dimension(100, 30));
        comboBox2.setPreferredSize(new Dimension(100, 30));

        // Agregar ActionListener al JComboBox para ajustar la visibilidad del otro JComboBox
        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedOption = (String) comboBox1.getSelectedItem();
                ajustarVisibilidadComboBox(selectedOption, comboBox2);
            }
        });

        panel.add(comboBox1);
        panel.add(comboBox2);
        panel.add(label);

        frame.getContentPane().add(panel);
        frame.setSize(250, 180);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void ajustarVisibilidadComboBox(String selectedOption, JComboBox<String> comboBox) {
        if ("Mayor".equals(selectedOption)) {
            // Ocultar el JComboBox
            comboBox.setVisible(false);
        } else if ("Menor".equals(selectedOption)) {
            // Mostrar el JComboBox
            comboBox.setVisible(true);
        }
    }
}
