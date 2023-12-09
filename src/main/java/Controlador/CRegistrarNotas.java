
package Controlador;

import Procesos.ProcesosAlumnos;
import VISTA_DOCENTE.Registrar_Notas;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import rojeru_san.efectos.ValoresEnum;
import javax.swing.table.TableRowSorter;
import javax.swing.table.TableModel;
import javax.swing.RowFilter;


public class CRegistrarNotas implements ActionListener{
    
    Registrar_Notas vista;
    TableRowSorter<TableModel> rowSorter;
    
    public CRegistrarNotas(Registrar_Notas frm){
        vista=frm;
        vista.btnCantNotas.addActionListener(this);
        vista.btnAvanzar.addActionListener(this);
        vista.btnRetroceder.addActionListener(this);
        vista.btnBuscar.addActionListener(this);
        //cambiar icono de un boton
        //vista.btnAvanzar.setIcons(ValoresEnum.ICONS.CODE);
        cambiarColorEncabezadoRGB(1, 129, 128, 255);
        cambiarColorEncabezadoRGB(3, 129, 128, 255);
        cambiarColorEncabezadoRGB(5, 129, 128, 255);
        cambiarColorEncabezadoRGB(7, 129, 128, 255);
        cambiarColorEncabezadoRGB(2, 153, 153, 153);
        cambiarColorEncabezadoRGB(4, 153, 153, 153);
        cambiarColorEncabezadoRGB(6, 153, 153, 153);
        cambiarColorEncabezadoRGB(8, 153, 153, 153);
        vista.lblPagina.setText("1");
        
        vista.lblPagina.setBackground(new Color(102,102,255));
        vista.lblPagina.setForeground(Color.WHITE);
        vista.lblPagina.setOpaque(true);
        vista.lblPagina.setHorizontalAlignment(SwingConstants.CENTER);
        addPopUpMenu(vista.tblDatos);
        diseñoCheckBox(vista.tblDatos, 10);
        permitirNumeros(vista.tblDatos);
        detectarCambioPagina(vista.lblPagina);
        definirFiltroTabla(vista.tblDatos);
    }
    
    public void modificarColumnas(int cantColumSolicitada){
        int cantColumVisibles=0;
        int indexUltColumVisible=0;
        int cantCeldas = vista.tblDatos.getModel().getRowCount();
        for (int i = 1; i <=8; i++) {
            int longitud = vista.tblDatos.getColumnModel().getColumn(i).getPreferredWidth();
            if(longitud!=0) cantColumVisibles++;
        }
        
        indexUltColumVisible=cantColumVisibles;
        
        int cantVueltas= Math.abs(cantColumSolicitada-indexUltColumVisible);
        bucle:
        for(int i=0;i<cantVueltas;i++){
            if(cantColumSolicitada>cantColumVisibles){
                vista.tblDatos.getColumnModel().getColumn(i+(indexUltColumVisible+1)).setMaxWidth(50);
                vista.tblDatos.getColumnModel().getColumn(i+(indexUltColumVisible+1)).setMinWidth(50);
                vista.tblDatos.getColumnModel().getColumn(i+(indexUltColumVisible+1)).setPreferredWidth(50);
            }else{
                bucle2:
                for (int j = 0; j < cantCeldas; j++) {
                    if( vista.tblDatos.getValueAt(j, (indexUltColumVisible-i))!= null ){
                        ProcesosAlumnos.msjDialog("Aun hay datos en la columna "+
                                vista.tblDatos.getColumnModel()
                                              .getColumn(indexUltColumVisible-i)
                                              .getHeaderValue().toString());
                        break bucle;
                          
                    }
                }
                vista.tblDatos.getColumnModel().getColumn(indexUltColumVisible-i).setMaxWidth(0);
                vista.tblDatos.getColumnModel().getColumn(indexUltColumVisible-i).setMinWidth(0);
                vista.tblDatos.getColumnModel().getColumn(indexUltColumVisible-i).setPreferredWidth(0); 
            }
        }
    }

    private void cambiarColorEncabezadoRGB(int columnIndex, int red, int green, int blue) {
        JTableHeader header = vista.tblDatos.getTableHeader();
        TableCellRenderer renderer = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                Color color = new Color(red, green, blue);
                label.setBackground(color);
                label.setForeground(Color.WHITE);  // Puedes ajustar el color del texto
                label.setHorizontalAlignment(JLabel.CENTER);
                return label;
            }
        };

        header.getColumnModel().getColumn(columnIndex).setHeaderRenderer(renderer);
    }
    
    public void diseñoCheckBox(JTable tabla, int columnIndex){
         // Renderizador personalizado
        tabla.getColumnModel().getColumn(columnIndex).setCellRenderer(new DefaultTableCellRenderer() {
            private final JCheckBox checkBox = new JCheckBox();

            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, 
                    boolean isSelected, boolean hasFocus, int row, int column) {
                // Configurar el valor del JCheckBox
                checkBox.setSelected(Boolean.TRUE.equals(value));
                checkBox.setHorizontalAlignment(CENTER);
                // Heredar propiedades visuales de la tabla
                if(row%2==0 && column==10){
                    checkBox.setBackground(new Color(255,255,255));
                }else{
                    checkBox.setBackground(new Color(204,204,204));
                }
                checkBox.setForeground(table.getForeground());
                checkBox.setFont(table.getFont());
                checkBox.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                return checkBox;
            }
        });
    }
    
    public void addPopUpMenu(JTable tabla){
        JTableHeader header = tabla.getTableHeader();
        header.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (SwingUtilities.isRightMouseButton(e)) {
                    int columnIndex = tabla.columnAtPoint(e.getPoint());
                    //condiciones que haya 1 fila y solo hasta las columnas visibles que tenga nota
                    if (columnIndex == 10) {  // Solo para la columna "Seleccionar"
                        manejoCheckBox(e, header, columnIndex);
                    }else if( (columnIndex>=1 && columnIndex<=8) && tabla.getRowCount()==1 ){
                        manejoComentario(e, header, columnIndex);
                    }
                }
            }
        });
    }
    
    private void manejoCheckBox(MouseEvent e,JTableHeader header,int columnIndex) {
        JPopupMenu popupMenu = new JPopupMenu();
        JMenuItem seleccionarTodos = new JMenuItem("Seleccionar Todos");
        edicionCheckBox(seleccionarTodos, true, columnIndex);
        
        JMenuItem deseleccionarTodos = new JMenuItem("Deseleccionar Todos");
        edicionCheckBox(deseleccionarTodos, false, columnIndex);
        
        popupMenu.add(seleccionarTodos);
        popupMenu.add(deseleccionarTodos);
        popupMenu.show(header, e.getX()+20, e.getY()-60);
    }
    
    private void manejoComentario(MouseEvent e,JTableHeader header,int columnIndex) {
        JPopupMenu popupMenu = new JPopupMenu();
        JMenuItem crear = new JMenuItem("Agregatr Comentario");
        edicionComentario(crear, 0, columnIndex);
        
        JMenuItem editar = new JMenuItem("Editar Comentario");
        edicionComentario(editar, 1, columnIndex);
        
        JMenuItem eliminar = new JMenuItem("Eliminar Comentario");
        edicionComentario(eliminar, 2, columnIndex);
        
        popupMenu.add(crear);
        popupMenu.add(editar);
        popupMenu.add(eliminar);
        popupMenu.show(header, e.getX(), e.getY()-60);
    }
    
    public void edicionCheckBox(JMenuItem item,boolean seleccionar, int columnIndex){
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int cantFilas=vista.tblDatos.getRowCount();
                for (int i = 0; i < cantFilas; i++) {
                    vista.tblDatos.setValueAt(seleccionar, i, columnIndex);
                }
            }
        });
    }
    
    public void edicionComentario(JMenuItem item,int opcion, int columnIndex){
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
            
                switch (opcion) {
                    case 0-> ProcesosAlumnos.msjDialog("Yo agrego un comentario");
                    case 1-> ProcesosAlumnos.msjDialog("Yo edito un comentario");
                    default-> ProcesosAlumnos.msjDialog("Yo elimino un comentario");
                      
                }
                
            }
        });
    }
    
    public void configurarEditorNumerico(JTable tabla, int columnIndex) {
        JTextField textField = new JTextField();
        
        ((AbstractDocument) textField.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(FilterBypass fb, int offset, String text, AttributeSet attr) throws BadLocationException {
                StringBuilder builder = new StringBuilder(fb.getDocument().getText(0, fb.getDocument().getLength()));
                builder.insert(offset, text);

                if (esNumeroEnRango(builder.toString())) {
                    super.insertString(fb, offset, text, attr);
                }
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                StringBuilder builder = new StringBuilder(fb.getDocument().getText(0, fb.getDocument().getLength()));
                builder.replace(offset, offset + length, text);

                if (esNumeroEnRango(builder.toString())) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }
            
            private boolean esNumeroEnRango(String text) {
                try {
                    int valor = Integer.parseInt(text);
                    return valor <= 20;
                } catch (NumberFormatException e) {
                    return false;
                }
            }
        });

        tabla.getColumnModel().getColumn(columnIndex).setCellEditor(new DefaultCellEditor(textField));
    }
    
    public void permitirNumeros(JTable tabla){
        for (int i = 1; i <= 8; i++) {
            configurarEditorNumerico(tabla, i);
        }
   
    }
    
    public void elaborarTablaResumen(){
            vista.tblDatos.setAutoResizeMode(0);
            int cantColum=vista.tblDatos.getColumnCount();
            String[] encabezados=new String[cantColum]; 
            for(int i=0;i<cantColum;i++){
                encabezados[i]=vista.tblDatos.getColumnModel().getColumn(i).getHeaderValue().toString();
            }

            DefaultTableModel modelo = new DefaultTableModel(encabezados, 5);
            modelo.setColumnCount(modelo.getColumnCount()-7);
            modelo.addColumn("Prom");
            
            String[] comp2 = {"C1","C2","C3","C4"};
            for (int i = 0; i <4; i++) {
                modelo.addColumn(comp2[i]);
            }
            modelo.addColumn("Prom");
            
            String[] comp3 = {"C1","C2","C3","C4","C5"};
            for (int i = 0; i <5; i++) {
                modelo.addColumn(comp3[i]);
            }
            modelo.addColumn("Prom");
            
            modelo.addColumn("PROM Area");
            modelo.addColumn("Gestiona");
            modelo.addColumn("TIC");
            modelo.addColumn("Conducta");
            
            vista.tblDatos.setModel(modelo);
            
            for(int i=1;i<=15;i++){
                switch (i){
                    case 1,2,3,5,6,7,8,10,11,12,13,14 -> cambiarColorEncabezadoRGB(i, 153, 153, 153);
                    case 4,9,15 -> cambiarColorEncabezadoRGB(i, 129, 128, 255);
                }
            }
     
    }
    
    public void detectarCambioPagina(JLabel label){
        label.addPropertyChangeListener("text", evt -> {
        String texto = (String) evt.getNewValue();
            if (texto.equals("R")) {
                elaborarTablaResumen();
            }
        });

    }
    
    public void definirFiltroTabla(JTable tabla){
        rowSorter = new TableRowSorter<>(tabla.getModel());
        tabla.setRowSorter(rowSorter);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==vista.btnAvanzar){
            int numPagina = Integer.parseInt(vista.lblPagina.getText());
            if(numPagina<=7){
                numPagina ++;
                if(numPagina==8){
                    vista.lblPagina.setText("R");
                    vista.lblPagina.setBackground(new Color(102,102,102));
                }else{
                    vista.lblPagina.setText(String.valueOf(numPagina));
                }
            } 
        }
        
        if(e.getSource()==vista.btnRetroceder){
            int numPagina;
            try {
                numPagina = Integer.parseInt(vista.lblPagina.getText());
            } catch (NumberFormatException ex) {
                numPagina=8;
            }
            if(numPagina>=2){
                numPagina --;
                vista.lblPagina.setText(String.valueOf(numPagina));
                vista.lblPagina.setBackground(new Color(102,102,255));
            }
            
        }
        
        if(e.getSource()==vista.btnBuscar){
            String text = vista.txtBuscar.getText();
            if (text.trim().length() == 0) {
                rowSorter.setRowFilter(null);
            } else {
                rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
            }
            
        }
        
        if(e.getSource()==vista.btnCantNotas){
            try{
                
               int cantNotas = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "Digite la cantidad de notas para esta competencia",
                        "Cantidad de Notas",JOptionPane.INFORMATION_MESSAGE));
               
               if(cantNotas>0 && cantNotas<=8){
                    modificarColumnas(cantNotas);
               }else{
                    ProcesosAlumnos.msjDialog("valor para la cantidad de notas incorrecto");
               }
                
            } catch(NumberFormatException ex){
                ProcesosAlumnos.msjDialog("el dato ingresado no es un numero");
            }
                
        }
    }

}
