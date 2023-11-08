
package Procesos;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class ImgRender extends DefaultTableCellRenderer {
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object object, 
            boolean isSelected, boolean hasFocus, int row, int column) {
            
        if(object instanceof JLabel){
            JLabel lblEstadoGrado = (JLabel)object;
            return lblEstadoGrado;
        }
        
        return super.getTableCellRendererComponent(table, object, isSelected, 
                hasFocus, row, column); 
    }
}
