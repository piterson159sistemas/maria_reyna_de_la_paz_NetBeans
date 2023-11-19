
package Controlador;

import DAO.crudAreasGrados;
import DAO.crudTutoria;
import Modelo.AreaDocencia;
import Modelo.Docente;
import Modelo.GradoAlumno;
import Modelo.GradoDocencia;
import Procesos.ProcesosAlumnos;
import Procesos.procesosAreasGrados;
import Vista.asignar_area_directivo_1;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;


public class CAsignarArea implements ActionListener,MouseListener {
    
    asignar_area_directivo_1 vista;
    ProcesosAlumnos procesosAux=new ProcesosAlumnos();
    procesosAreasGrados procesos=new procesosAreasGrados();
    crudAreasGrados crudAG = new crudAreasGrados();
    crudTutoria crudAux = new crudTutoria();
    int indexVetanaContenedor=0;
    int[] registroaModificar={0,0};
    
    public CAsignarArea(asignar_area_directivo_1 frm){
        vista=frm;
        LocalDate fechaActual = LocalDate.now();
        int anioActual = fechaActual.getYear();
        vista.txtAnio.setText(String.valueOf(anioActual));
                
        vista.btnBorrar.addActionListener(this);
        vista.btnActualizar.addActionListener(this);
        vista.btnCrear.addActionListener(this);
        vista.btnLimpiar.addActionListener(this);
        vista.tblGrados.addMouseListener(this);
        modificarCantCombos(vista.cbxGradoP);
        ConfigurarVisibilidadCombos(false);
        procesosAux.cargarGrados(vista.cbxGradoI, "Inicial");
        procesosAux.cargarGrados(vista.cbxGradoP, "Primaria");
        procesosAux.cargarGrados(vista.cbxGradoS, "Secundaria");
        PermitirSoloNumeros(vista.txtAnio, 4);
        cargarAreasyDocentes();
        detectarCambioVentana(vista.Contenedor);
        DefinirDocentes();
        Actualizar();
        
        frm.setTitle("Asignacion de Area");
        frm.setVisible(true);
    }
    
    
    public void Actualizar(){
        crudAG.listarGrados(vista.tblGrados);
    }
    
    public void cargarAreasyDocentes(){
        int codArea;
        JComponent[][] componentes={
            {vista.lblIni1},{vista.lblIni2},{vista.lblIni3},{vista.lblIni4},
            {vista.lblIni5},{vista.lblIni6},{vista.lblIni7},
            {vista.lblIni8,vista.cbxDocenteI},{vista.lblIni9,vista.cbxComputacionI},
                                    
            {vista.lblPri1,vista.cbxPSocialP},{vista.lblPri2,vista.cbxReligionP},
            {vista.lblPri3,vista.cbxComunicacionP},{vista.lblPri4},
            {vista.lblPri5,vista.cbxMatematicaP},{vista.lblPri6,vista.cbxCienciaP},
            {vista.lblPri7,vista.cbxEdFisicaP},{vista.lblPri8,vista.cbxInglesP},
            {vista.lblPri9,vista.cbxComputacionP},
                                    
            {vista.lblSec1,vista.CbxComputacionS},{vista.lblSec2,vista.cbxCSocialesS},
            {vista.lblSec3,vista.cbxDesarrolloPCCS},{vista.lblSec4,vista.cbxEdFisicaS},
            {vista.lblSec5,vista.cbxCienciaS},{vista.lblSec6,vista.cbxInglesS},
            {vista.lblSec7,vista.cbxMatematicaS},{vista.lblSec8,vista.cbxArteS},
            {vista.lblSec9,vista.cbxComunicacionS},{vista.lblSec10,vista.cbxReligionS}
        };
        
        
        ArrayList<String> nombresAreas=new ArrayList<>(); 
        int lastIndex=componentes.length-1;
        int j = 0;
        for(int i=0;i<=lastIndex;i++){
            if(i==0){
                nombresAreas= crudAG.buscarAreas("Inicial");
            }else if(i==9){
                nombresAreas= crudAG.buscarAreas("Primaria");
                j=0;
            }else if (i==18){
                nombresAreas= crudAG.buscarAreas("Secundaria");
                j=0;
            }
            
            if(componentes[i].length>1){
                if(i==7){
                    procesos.cargarDocentes(((JComboBox)componentes[i][1]), "I",0);
                }
                if(i==18){
                    ((JLabel)componentes[i][0]).setText("<html>Educacion para<br>el trabajo</html>");
                    codArea=12;
                }else if(i==20){
                    ((JLabel)componentes[i][0]).setText("<html>Desarrollo Personal,<br>Ciudadania y Civica</html>");
                    codArea=10;
                }else{
                    ((JLabel)componentes[i][0]).setText(nombresAreas.get(j));
                     codArea= crudAG.obtenerCodArea(((JLabel)componentes[i][0]).getText());
                    
                }
                procesos.cargarDocentes(((JComboBox)componentes[i][1]), codArea);
            }else{
                ((JLabel)componentes[i][0]).setText(nombresAreas.get(j));
            }
            j++;
        }

    }
    
    public boolean VerificarDatos(ArrayList<String> data){
        String msjError="";
        
        int anio = Integer.parseInt(data.get(0));
        if(anio<1999){
            msjError+="Fecha incorrecta: año sin definir o menor a 1999\n";
        }else{
            //indexVetanaContenedor=0 -->Inicial
            if(indexVetanaContenedor==1 && anio<2000){
                 msjError+="Fecha incorrecta para un grado de nivel Primaria\n";
            }else if(indexVetanaContenedor==2 && anio<2005){
                 msjError+="Fecha incorrecta para un grado de nivel Secundaria\n";
            }
        }
        
        bucle:
        for(String dato:data){
            if(dato.contains("...")){
                msjError+="No puede haber datos vacios o con valor \"...\"";
                 break bucle;
            }
        }
        
        if(!(msjError.isBlank())){
            procesosAux.msjDialog(msjError);
            return false;
        }else {
            return true;
        }
                   
    }

    public void ConfigurarVisibilidadCombos(boolean estado){
    JComboBox[] combos={vista.cbxPSocialP,vista.cbxReligionP,vista.cbxComunicacionP,
            vista.cbxArteComodinP,
            vista.cbxMatematicaP,vista.cbxCienciaP,vista.cbxEdFisicaP};
        for(JComboBox combo: combos){
           combo.setVisible(estado);
        }
    }
    
    public void modificarCantCombos(JComboBox comboGrado){
        comboGrado.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    int anio=2023;
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        String selectedOption = comboGrado.getSelectedItem().toString();
                        anio= Integer.parseInt(vista.txtAnio.getText());
                        if(selectedOption.equals("...")){
                            ConfigurarVisibilidadCombos(false);
                        }else if(selectedOption.equals("4to Grado") ||
                                 selectedOption.equals("5to Grado") ||
                                 selectedOption.equals("6to Grado") ){
                            ConfigurarVisibilidadCombos(true);
                            //carga de combo comodin
                            int codDocente = crudAG.obtenerCodArea(vista.lblPri4.getText());
                            procesos.cargarDocentes(vista.cbxArteComodinP, codDocente);
                        }else{
                            ConfigurarVisibilidadCombos(false);
                            vista.cbxArteComodinP.setVisible(true);
                            //carga de combo comodin
                            procesos.cargarDocentes(vista.cbxArteComodinP, "P",anio);

                        }
                        
                        
                    }
                }
        });
        
    }

    public void detectarCambioVentana(JTabbedPane tabbedPane){
        tabbedPane.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                // Obtener el índice de la pestaña seleccionada
                indexVetanaContenedor = tabbedPane.getSelectedIndex();
                System.out.println("Estás en la pestaña " + (indexVetanaContenedor));
            }
        });
    }
    
       public void PermitirSoloNumeros(JTextField campo,int limit){
        campo.setDocument(new PlainDocument() {
                @Override
                public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {         
                    if (str == null) {
                        return;
                    }
                    if (str.matches("\\d+") && 
                            (limit <= 0 ||(getLength() + str.length() <= limit)) ) {
                        super.insertString(offset, str, attr);
                    }
                }
            }); 
    }

    @Override
    @SuppressWarnings("empty-statement")
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==vista.btnLimpiar){
            procesos.limpiarCampos(indexVetanaContenedor, vista);
            registroaModificar[0]=0;
            registroaModificar[1]=0;
            vista.tblGrados.clearSelection();
        }
        
        if(e.getSource()==vista.btnBorrar){
            if(registroaModificar[0]==0 || registroaModificar[1]==0){
                procesosAux.msjDialog("Ningun resgistro se ha seleccionado para eliminar");
            }else{
                crudAG.eliminar(registroaModificar[0], registroaModificar[1]);
                Actualizar();
                procesos.limpiarCampos(indexVetanaContenedor, vista);
                registroaModificar[0]=0;
                registroaModificar[1]=0;
                vista.tblGrados.clearSelection();
                DefaultTableModel tableModel = new DefaultTableModel(0, 0);
                vista.tblAreas.setModel(tableModel);   
            }
        }
        
        if(e.getSource()==vista.btnActualizar){
            
            ArrayList<String> data = procesos.leerCampos(indexVetanaContenedor, vista);
            if(registroaModificar[0]==0 || registroaModificar[1]==0){
                procesosAux.msjDialog("Ningun resgistro se ha seleccionado para actualizar");
            }else{
                boolean datosValidos=VerificarDatos(data);
                if(datosValidos){
                    int codGrado=crudAG.obtenerCodGrado(indexVetanaContenedor, vista);
                    int anio=Integer.parseInt(vista.txtAnio.getText());
                    boolean registroExiste=crudAG.buscarRegistro(anio,codGrado);
                    //-----------------------------------------------------------------
                    if(!registroExiste){
                         procesosAux.msjDialog("Este registro aun no ha sido creado");   
                    }else{
                        ArrayList<Integer> codADactual = crudAG.obtenerCodAreaDocente(
                                Integer.parseInt(data.get(0)),
                                crudAG.obtenerCodGrado(indexVetanaContenedor, vista));
                        for(Integer cod:codADactual ){
                            System.out.print(cod+" ");
                        }
                        System.out.println();
                        //aqui se actualiza
                        int cantInserciones=procesos.obtenerCantAreas(
                            indexVetanaContenedor, vista);
                            
                        System.out.println("Se realizaran "+cantInserciones+" inserciones");
                        for (int i = 0; i <cantInserciones; i++) {
                            String nomArea="", nomDocente="";
                            String[] partes = data.get(i+2).split(",");
                                nomArea=partes[0]; 
                                nomDocente=partes[1];
                            int codArea = crudAG.obtenerCodArea(nomArea);
                            String codDocente = crudAux.obtenerCodDocente(nomDocente);
                            int codADnuevo=crudAG.obtenerCodAreaDocente(codDocente, codArea);
                            System.out.println(codADactual.get(i)+"-->"+codADnuevo);
                            crudAG.actualizar(codADnuevo, 
                                    codADactual.get(i), registroaModificar[0], 
                                    registroaModificar[1]);
                        }
                        Actualizar();
                        procesosAux.msjDialog("Registro de actualizado exitosamente");
                        
                    }
                }
            }
        }
        
        if(e.getSource()==vista.btnCrear){
            ArrayList<String> data = procesos.leerCampos(indexVetanaContenedor, vista);
            
            boolean datosValidos=VerificarDatos(data);

            if(datosValidos){
                //verificar si el registro ya exsiste para evitar duplicados
                int codGrado=crudAG.obtenerCodGrado(indexVetanaContenedor, vista);
                int anio=Integer.parseInt(vista.txtAnio.getText());
                boolean registroExiste=crudAG.buscarRegistro(anio,codGrado);
                //-----------------------------------------------------------------
                if(registroExiste){
                    procesosAux.msjDialog("Este registro ya existe \n"
                            + "o este grado ya tiene docentes asignados a todas las areas");
                }else{
                    /******************************
                        Aca empieza la inserción
                    *******************************/
                    int cantInserciones=procesos.obtenerCantAreas(
                            indexVetanaContenedor, vista);
                            
                    System.out.println("Se realizaran "+cantInserciones+" inserciones");
                    for (int i = 0; i <cantInserciones; i++) {
                        String nomArea="", nomDocente="";
                        if(cantInserciones==10){
                            data.set(2, "Educacion para el Trabajo,"+
                                    vista.CbxComputacionS.getSelectedItem().toString());
                            data.set(4, "Desarrollo Personal,Ciudadania y Civica,"+
                                    vista.cbxDesarrolloPCCS.getSelectedItem().toString());
                        }

                        if(cantInserciones==10 && i==2){
                            String[] partes = data.get(i+2).split(",");
                            nomArea=partes[0]+","+partes[1];
                            nomDocente=partes[2];
                        }else{
                            String[] partes = data.get(i+2).split(",");
                            nomArea=partes[0]; 
                            nomDocente=partes[1];
                        }

                        int codArea = crudAG.obtenerCodArea(nomArea);
                        String codDocente = crudAux.obtenerCodDocente(nomDocente);
                        int codAreaDocente=crudAG.obtenerCodAreaDocente(codDocente, codArea);
                    
                        GradoDocencia gd = new GradoDocencia(
                                Integer.parseInt(data.get(0)),//Año 
                                new GradoAlumno(data.get(1)+","+codGrado) , //CodGrado
                                new AreaDocencia(new Docente(codDocente), nomArea+","+codArea));
                                //                             CodDocente,   CodArea
                        System.out.println(gd);
                        System.out.println();
                        crudAG.insertar(gd, codAreaDocente);
                                
                    }
                    Actualizar();
                    procesosAux.msjDialog("Registro de datos exitoso");
                }
                
            }
        }
        
        
    }
       
       
    @Override
    public void mouseClicked(MouseEvent e) {
        
        //recogemos datos
        int numfila = vista.tblGrados.rowAtPoint(e.getPoint());
        int columAnio = 0; //num de columna del año
        int columGrado = 1; //num de columna del Grado
        int columNivel = 2; //num de columna del Nivel
        
        
        if(numfila>-1){
            //hacemos algo
            int anio=Integer.parseInt(vista.tblGrados.getValueAt(numfila, columAnio).toString());
            String Grado= vista.tblGrados.getValueAt(numfila, columGrado).toString();
            String Nivel=vista.tblGrados.getValueAt(numfila, columNivel).toString();
            int codGrado= crudAG.obtenerCodGrado(Grado,Nivel);
            registroaModificar[0]=anio;
            registroaModificar[1]=codGrado;
            // se carga la tabla area con los datos de latabla Grados segun que fila se clickea
            crudAG.listarAreas(vista.tblAreas, anio, codGrado);
            
            vista.txtAnio.setText(String.valueOf(anio));
            //Se carga datos en el panel de edicion a la izquierda
            if(Nivel.equals("Inicial")){
                vista.Contenedor.setSelectedIndex(0);
                vista.cbxGradoI.setSelectedItem(Grado);
                vista.tblGrados.getValueAt(0, 2).toString();
                
                String docente= vista.tblAreas.getValueAt(0, 2).toString();
                vista.cbxDocenteI.addItem(docente);
                vista.cbxDocenteI.setSelectedItem(docente);
                vista.cbxComputacionI.setSelectedItem(vista.tblAreas.getValueAt(8, 2).toString());
                
            }else if(Nivel.equals("Primaria")){
                vista.Contenedor.setSelectedIndex(1);
                vista.cbxGradoP.setSelectedItem(Grado);
                
                
                if(Grado.equals("1er Grado") || Grado.equals("2do Grado") ||
                    Grado.equals("3er Grado")){
                    
                    ConfigurarVisibilidadCombos(false);
                    vista.cbxArteComodinP.setVisible(true);
                    
                    String docente= vista.tblAreas.getValueAt(0, 2).toString();
                    vista.cbxArteComodinP.addItem(docente);
                    vista.cbxArteComodinP.setSelectedItem(docente);
                    vista.cbxInglesP.setSelectedItem(vista.tblAreas.getValueAt(7, 2).toString());
                    vista.cbxComputacionP.setSelectedItem(vista.tblAreas.getValueAt(8, 2).toString());
                    
                    
                }else{
                    ConfigurarVisibilidadCombos(true);
                    Component[] Elementos = vista.Primaria.getComponents();
                    ArrayList<JComboBox> combos=new ArrayList<>();
                    for(Component elemento: Elementos){
                        if(elemento instanceof JComboBox){
                            combos.add( ((JComboBox)elemento));
                        }
                    }
                    combos.remove(0);
                    for(int i=0;i<9;i++){
                        String docente=vista.tblAreas.getValueAt(i, 2).toString();
                        combos.get(i).setSelectedItem(docente);
                            
                    }
                }
            }else{
                vista.Contenedor.setSelectedIndex(2);
                vista.cbxGradoS.setSelectedItem(Grado);

                Component[] Elementos = vista.Secundaria.getComponents();
                ArrayList<JComboBox> combos=new ArrayList<>();
                for(Component elemento: Elementos){
                    if(elemento instanceof JComboBox){
                        combos.add( ((JComboBox)elemento));
                    }
                }
                combos.remove(0);
                for(int i=0;i<10;i++){
                    String docente=vista.tblAreas.getValueAt(i, 2).toString();
                    combos.get(i).setSelectedItem(docente);

                }
                
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
    public void DefinirDocentes(){
            
        // Agregar un DocumentListener al Document asociado al JTextField
        vista.txtAnio.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                handleChange();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                handleChange();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                handleChange();
            }
        });

    }

    private void handleChange() {
        // Verificar si el JTextField tiene exactamente 4 dígitos
        if (vista.txtAnio.getText().length() == 4) {
            // Busca los profesores de inicial Disponibles ese año 
            int anio=Integer.parseInt(vista.txtAnio.getText());
            procesos.cargarDocentes(vista.cbxDocenteI, "I",anio);

        }else{
            vista.cbxDocenteI.removeAllItems();
        }
    }
    
    
}
