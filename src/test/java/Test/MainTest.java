
package Test;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainTest {

    public static void main(String[] args) {
         SwingUtilities.invokeLater(() -> new MainTest().createAndShowGUI());
    }

    private void createAndShowGUI() {
        JFrame frame = new JFrame("Deseleccionar Fila en JTable");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear datos de ejemplo para el modelo de tabla
        Object[][] data = {
                {"1", "Nombre1", "Apellido1"},
                {"2", "Nombre2", "Apellido2"},
                {"3", "Nombre3", "Apellido3"}
        };

        // Crear nombres de columnas para el modelo de tabla
        String[] columnNames = {"ID", "Nombre", "Apellido"};

        // Crear el modelo de tabla
        DefaultTableModel model = new DefaultTableModel(data, columnNames);

        // Crear la tabla con el modelo
        JTable table = new JTable(model);

        // Botón para deseleccionar la fila
        JButton deseleccionarButton = new JButton("Deseleccionar Fila");
        deseleccionarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deseleccionarFila(table);
            }
        });

        // Agregar la tabla y el botón al marco
        frame.add(new JScrollPane(table), BorderLayout.CENTER);
        frame.add(deseleccionarButton, BorderLayout.SOUTH);

        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void deseleccionarFila(JTable table) {
        // Utilizar clearSelection() para deseleccionar la fila
        table.clearSelection();
    }
}
