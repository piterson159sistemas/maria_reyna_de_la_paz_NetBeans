
package Test;
import javax.swing.JFrame;
import org.jdesktop.swingx.JXTreeTable;
import org.jdesktop.swingx.treetable.DefaultMutableTreeTableNode;
import org.jdesktop.swingx.treetable.DefaultTreeTableModel;

public class MainTest {


    public static void main(String[] args) {
        JFrame frame = new JFrame("JXTreeTable Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear un nodo raíz
        DefaultMutableTreeTableNode root = new DefaultMutableTreeTableNode("Root");

        // Crear un modelo de tabla con una estructura de columna personalizada
        DefaultTreeTableModel model = new DefaultTreeTableModel(root,
                java.util.Arrays.asList("Nombre", "Valor", "Subcolumna 1", "Subcolumna 2"));

        // Crear una JXTreeTable con el modelo
        JXTreeTable treeTable = new JXTreeTable(model);

        // Agregar filas y nodos para crear la estructura de la tabla
        DefaultMutableTreeTableNode row1 = new DefaultMutableTreeTableNode(new Object[]{"Fila 1", "Valor 1", "Subvalor 1", "Subvalor 2"});
        DefaultMutableTreeTableNode row2 = new DefaultMutableTreeTableNode(new Object[]{"Fila 2", "Valor 2", "Subvalor 3", "Subvalor 4"});
        model.insertNodeInto(row1, root, root.getChildCount());
        model.insertNodeInto(row2, root, root.getChildCount());

        frame.add(treeTable);
        frame.pack();
        frame.setVisible(true);
    }
    
}
