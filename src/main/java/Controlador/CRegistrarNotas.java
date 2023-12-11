
package Controlador;

import DAO.crudAlumno;
import DAO.crudAreasGrados;
import DAO.crudRegistroNotas;
import Procesos.ProcesosAlumnos;
import Procesos.procesosRegistroNotas;
import VISTA_DOCENTE.Registrar_Notas;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
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
import javax.swing.table.TableRowSorter;
import javax.swing.table.TableModel;
import javax.swing.RowFilter;


public class CRegistrarNotas implements ActionListener,ItemListener{
    
    /*
                         ****************
                         CAMPOS DE CLASE
                         ***************
    */ 
    Registrar_Notas vista;
    TableRowSorter<TableModel> rowSorter;
    procesosRegistroNotas procesos = new procesosRegistroNotas();
    crudRegistroNotas crudNotas = new crudRegistroNotas();
    
    crudAlumno crudAux = new crudAlumno();
    crudAreasGrados crudAux2 = new crudAreasGrados();
    
    //Para manejar datos
    String codDocente;
    ArrayList<String> dataAlumno = new ArrayList<>();
    ArrayList<String> competencias = new ArrayList<>();
    int codDocenteGrado = 0;
    int codPeriodo = 0;
    DefaultTableModel[] modelos;
    int cantPaginas = 0;
    
    
    /*
                         ****************
                            CONSTRUCTOR
                         ***************
    */ 
    public CRegistrarNotas(Registrar_Notas frm,String codUsuario){
        vista=frm;
        codDocente=codUsuario;
        //ACTION LISTENERS
        vista.btnMostrar.addActionListener(this);
        vista.btnCantNotas.addActionListener(this);
        vista.btnExportar.addActionListener(this);
        vista.btnBuscar.addActionListener(this);
        vista.btnRetroceder.addActionListener(this);
        vista.btnAvanzar.addActionListener(this);
        vista.btnRegistrar.addActionListener(this);
        
        //ITEM LISTENERS
        vista.cbxAnio.addItemListener(this);
        vista.cbxNivel.addItemListener(this);
        vista.cbxGrado.addItemListener(this);
        vista.cbxArea.addItemListener(this);
        
        procesos.cagarAnios(vista.cbxAnio, codDocente);
        procesos.cargarPeriodos(vista.cbxPeriodo);
        
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
        
        //diseño visual Label pagina
        vista.lblPagina.setBackground(new Color(102,102,255));
        vista.lblPagina.setForeground(Color.WHITE);
        vista.lblPagina.setOpaque(true);
        vista.lblPagina.setHorizontalAlignment(SwingConstants.CENTER);
        
        //diseño visual Label pagina especial
        vista.lblPaginaEsp.setBackground(new Color(102,102,102));
        vista.lblPaginaEsp.setForeground(Color.WHITE);
        vista.lblPaginaEsp.setOpaque(true);
        vista.lblPaginaEsp.setHorizontalAlignment(SwingConstants.CENTER);
        vista.lblPaginaEsp.setVisible(false);
        
        
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
            }else{
                int numPagina = Integer.parseInt(texto);
                if(numPagina<=cantPaginas){
                    //cargamos dato visual: (Nombre Area,Periodo,nombre Competencia) segun la pagina
                    vista.lblNomCompetencia.setText(competencias.get(numPagina-1).split(":")[1]);
                    
                    //cargamos modelo de tabla: segun la pagina
                    vista.tblDatos.setModel(modelos[numPagina-1]);
                    
                }
            }
            
        });

    }
    
    public void definirFiltroTabla(JTable tabla){
        rowSorter = new TableRowSorter<>(tabla.getModel());
        tabla.setRowSorter(rowSorter);
    }
    
    
    
    /*
    ***************************************************************
                         ACCION DE BOTONES
    ***************************************************************
    */
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        //Aca mostramos Info de los Alumnos
        if(e.getSource()==vista.btnMostrar){
            boolean filtrosValidos=procesos.verificarFiltros(vista);
            if(filtrosValidos){
                int[]codigos = procesos.getCodigos(vista);
                
                //obtenemos codigoFiltro(codPeriodo,codDocenteGrado)
                int codDocenteArea = crudAux2.getCodDocenteArea(codDocente, codigos[1]);
                int anio = Integer.parseInt(vista.cbxAnio.getSelectedItem().toString());
                
                int codPeriodo = crudNotas.getCodPeriodo(vista.cbxPeriodo.getSelectedItem().toString());
                codDocenteGrado = crudNotas.getCodDocenteGrado(codDocenteArea, codigos[0], anio);
                
                int[] codFiltro = {codPeriodo,codDocenteGrado};
 
                //obtenemos data Competencia(codgio,NomCompetencia)
                String letraNivel = vista.cbxNivel.getSelectedItem().toString().substring(0,1);
                competencias = crudNotas.listarComp(codigos[1], letraNivel);
                
                //obtenemos data Alumnno(codigo,NombreCompleto)
                dataAlumno = crudNotas.listarDataAlumnos(codigos[0], anio);
                
                //creamos los modelos de tablas
                modelos = procesos.crearTablasNotas(
                        vista, codFiltro, competencias, dataAlumno);
                cantPaginas = modelos .length;
                
                //cargamos datos visuales; (Nombre Area,Periodo,numPagina)
                vista.lblArea.setText(vista.cbxArea.getSelectedItem().toString());
                vista.lblPeriodo.setText(vista.cbxPeriodo.getSelectedItem().toString());
                vista.lblPagina.setText("1");
                
                
            }else{
                ProcesosAlumnos.msjDialog("No puede haber campos con"
                        + " el valor por defecto(\"...\")");
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
        
        if(e.getSource()==vista.btnExportar){
            //Aca se exporta la tabla 
            ProcesosAlumnos.msjDialog("Yo exporto a PDF");
        }
        
        if(e.getSource()==vista.btnAvanzar){
            int numPagina = Integer.parseInt(vista.lblPagina.getText());
            if(numPagina<cantPaginas+2){
                numPagina ++;
                vista.lblPagina.setText(String.valueOf(numPagina));
                if(numPagina>cantPaginas){
                    vista.lblPagina.setVisible(false);
                    vista.lblPaginaEsp.setVisible(true);
                    if(numPagina==cantPaginas+1){
                        vista.lblPaginaEsp.setText("CT");
                    }else if(numPagina==cantPaginas+2){
                        vista.lblPaginaEsp.setText("R");
                    } 
                }

            } 
        }
        
        if(e.getSource()==vista.btnRetroceder){
            int numPagina = Integer.parseInt(vista.lblPagina.getText());
            if(numPagina>=2 ){
                numPagina --;
                vista.lblPagina.setText(String.valueOf(numPagina));
                if(numPagina<cantPaginas+1){
                    vista.lblPagina.setVisible(true);
                    vista.lblPaginaEsp.setVisible(false);
                }
                if(numPagina==cantPaginas+1){
                    vista.lblPaginaEsp.setText("CTpP");   
                }
            }
            
        }
        
        if(e.getSource()==vista.btnRegistrar){
            ArrayList<Integer> indexFilas = new ArrayList<>();
            int numFilas = vista.tblDatos.getRowCount();
            
            // recorremos todas las fillas de la tabla y
            //almacenamos los indices de las filas seleccionadas para gurardar
            for(int i=0;i<numFilas;i++){
                Object value = vista.tblDatos.getValueAt(i, 10);
                boolean seleccionado = (value != null && (Boolean) value);
                if(seleccionado){
                    System.out.println("Fila num: "+i+" seleccionada");;
                    indexFilas.add(i);
                }
            }
             
            //Dterminados si el alumno es REGISTRADO O NO
            int cantFilasSeleccionadas = indexFilas.size();
            //1° recorremos arrayList de las filas seleccionadas
            for(int i=0;i<cantFilasSeleccionadas;i++){
                Object value2 = vista.tblDatos.getValueAt(indexFilas.get(i), 11);
                boolean Registrado = (value2 != null && (Boolean) value2);
                
                if(Registrado){
                    // msj de UPDATE
                    System.out.println("Se ACTUALIZA fila(indice): "+indexFilas.get(i));
  
                }else{
                    //INSERT INTO
                    System.out.println("Se INSERTA fila(indice): "+indexFilas.get(i));
                    //obtenemos los datos(notas y promedio)
                    int[]notas=new int[9]; //+4
                    for (int j = 1; j <=9; j++) {
                        Object value = vista.tblDatos.getValueAt(indexFilas.get(i), j);
                       if (value!=null){
                           int nota = Integer.parseInt(value.toString());
                            notas[j-1]=nota;
                        }
                    }
                    //datos para especificar al alumno(codA, codComp, codPeriodo, codDocenteGrado)
                    
                    int codAlumno = crudNotas.getCodAlumno(vista.tblDatos.getValueAt(
                                                indexFilas.get(i), 0).toString());
                    System.out.println(codAlumno);
                    int codCompetencia = crudNotas.getCodCompetencia(vista.lblNomCompetencia
                                                                    .getText());
                    System.out.println(codCompetencia);
                    
                    crudNotas.insertar(notas, codAlumno, codPeriodo, codDocenteGrado, codCompetencia);
                    
                }  
            }
            //actualizamos en los modelos
            for(int i=0;i<cantFilasSeleccionadas;i++){
                vista.tblDatos.setValueAt(true, indexFilas.get(i), 11);
            }
            DefaultTableModel modeloAct = (DefaultTableModel) vista.tblDatos.getModel();
            int numeroModelo = Integer.parseInt(vista.lblPagina.getText())-1;
            
            modelos[numeroModelo]=modeloAct;
            vista.tblDatos.setModel(modeloAct);
            
        }
        
        if(e.getSource()==vista.btnBuscar){
            String text = vista.txtBuscar.getText();
            if (text.trim().length() == 0) {
                rowSorter.setRowFilter(null);
            } else {
                rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
            }
        }

    }
    
        /*
    ***************************************************************
                         ACCION DE COMBO_BOX
    ***************************************************************
    */

    public int obtenerAnio(){
        int anio;
        try {
            anio=Integer.parseInt(vista.cbxAnio.getSelectedItem().toString());
        } catch (NumberFormatException ex) {
            anio=0;
        }
        return anio;
    } 
    
    @Override
    public void itemStateChanged(ItemEvent e) {
         if (e.getStateChange() == ItemEvent.SELECTED) {
            // Determinar cuál JComboBox generó el evento
            JComboBox<?> sourceComboBox = (JComboBox<?>) e.getSource();
            
            // Acciones específicas según el JComboBox
            if(sourceComboBox==vista.cbxAnio){
                int anio=obtenerAnio();
                procesos.cargarNiveles(vista.cbxNivel, codDocente, anio);
                
            }
            
            if(sourceComboBox==vista.cbxNivel){
                String nivel = vista.cbxNivel.getSelectedItem().toString();
                int anio=obtenerAnio();
                procesos.cargarGrados(vista.cbxGrado, codDocente,
                        anio, nivel);
            }
            
            if(sourceComboBox==vista.cbxGrado){
                String grado=vista.cbxGrado.getSelectedItem().toString();
                String nivel = vista.cbxNivel.getSelectedItem().toString();
                int anio=obtenerAnio();
               
                int codGrado = crudAux.obtenerCodGrado(nivel, grado);
                
                procesos.cargarAreas(vista.cbxArea, codDocente,
                        anio, codGrado);
            }
            
            if(sourceComboBox==vista.cbxArea){

                
            }
            
            
         }
    }

}
