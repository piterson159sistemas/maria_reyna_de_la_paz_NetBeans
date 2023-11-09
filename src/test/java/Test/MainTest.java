
package Test;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.Color;

public class MainTest {


    public static void main(String[] args) {
        JFrame frame = new JFrame("JTable with Colored Headers");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        DefaultTableModel model = new DefaultTableModel();
        JTable table = new JTable(model);
        model.addColumn("Columna 1");
        model.addColumn("Columna 2");

        // Personaliza el renderizado de los encabezados
        table.getTableHeader().setDefaultRenderer(new ColoredHeaderRenderer());

        // Asigna un color a los encabezados
        table.getTableHeader().setBackground(Color.YELLOW);

        // Agrega algunos datos de ejemplo
        model.addRow(new Object[]{"Dato 1", "Dato 2"});
        model.addRow(new Object[]{"Dato 3", "Dato 4"});

        // Agrega un ListSelectionListener para monitorear la selección de celdas
        ListSelectionModel cellSelectionModel = table.getSelectionModel();
        cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        cellSelectionModel.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = table.getSelectedRow();
                    int selectedColumn = table.getSelectedColumn();

                    if (selectedRow >= 0 && selectedColumn >= 0) {
                        String columnName = table.getColumnName(selectedColumn);
                        Color headerColor = table.getTableHeader().getBackground();

                        // Muestra un cuadro de diálogo con información
                        JOptionPane.showMessageDialog(frame, "Color del encabezado de la columna: " + headerColor.toString() + "\nNúmero de columna: " + selectedColumn);
                    }
                }
            }
        });

        frame.add(new JScrollPane(table));
        frame.setSize(400, 300);
        frame.setVisible(true);
    }

    static class ColoredHeaderRenderer extends DefaultTableCellRenderer {
        public ColoredHeaderRenderer() {
            setHorizontalAlignment(SwingConstants.CENTER);
            setForeground(Color.WHITE);  // Color del texto
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            // Personaliza el color del fondo del encabezado aquí
            setBackground(Color.BLUE);

            return this;
        }
    }
    
}
