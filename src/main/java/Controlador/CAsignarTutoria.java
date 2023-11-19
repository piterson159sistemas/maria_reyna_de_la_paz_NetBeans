///asdsada
package Controlador;
import DAO.crudTutoria;
import Modelo.Docente;
import Modelo.GradoAlumno;
import Modelo.Tutoria;
import Procesos.ProcesosAlumnos;
import Procesos.ProcesosTutoria;
import Vista.asignar_tutor_directivo_1;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class CAsignarTutoria implements ActionListener,MouseListener{
    asignar_tutor_directivo_1 vista;
    crudTutoria crudTutoria = new crudTutoria();
    ProcesosTutoria procesos = new ProcesosTutoria();
    ProcesosAlumnos procesosAux = new ProcesosAlumnos();
    String[] registroaModificar={"0","0"};
    
    public CAsignarTutoria(asignar_tutor_directivo_1 tutoria){
        vista=tutoria;
        vista.btnBorrar.addActionListener(this);
        vista.btnActualizar.addActionListener(this);
        vista.btnCrear.addActionListener(this);
        vista.btnLimpiar.addActionListener(this);
        vista.txtAnio.addActionListener(this);
        vista.tblProfes.addMouseListener(this);
        PermitirSoloNumeros(vista.txtAnio, 4);
        limitarNumeroGrados();
        LimitarGrados();
        procesos.cargarGrados(vista);
        actualizarDatos();
        
        tutoria.setTitle("Asignacion de Tutoria");
        tutoria.setVisible(true);
    }

    public void actualizarDatos(){
        //Actualizar tabla
        crudTutoria.ListarDocentes(vista.tblProfes);
        //Actualizar lista Docentes
        //procesos.cargarDocentes(vista.cbxTutor, crudTutoria.BuscarDocentes());

    }
    
    public void actualizarGrados(int anio,String codDocente){
        /*Se colorea de verde aquellos grados que ya están tomados(tienen un tutor asignado)
          en un determinado año sin contar los tomados por el propio docente
        */
        ArrayList<String> gradosTomados = crudTutoria.BuscarGrados(anio,codDocente);
        JPanel[] paneles={vista.panelInicial,vista.panelPrimaria,vista.panelSecundaria};
        for(JPanel panel: paneles){
            for(Component checkBox: panel.getComponents()){   
                bucle:
                for(String grado:gradosTomados){
                    if( ((JCheckBox) checkBox).getText().equals(grado)){
                        checkBox.setForeground(Color.GREEN);
                        break bucle;
                    }
                }
            }
        }
    }
    
    public void actualizarGrados(int anio){
        /*se colorea de verde aquellos grados tomados en un determinado año de forma general */
        ArrayList<String> gradosTomados = crudTutoria.BuscarGrados(anio);
        JPanel[] paneles={vista.panelInicial,vista.panelPrimaria,vista.panelSecundaria};
        for(JPanel panel: paneles){
            for(Component checkBox: panel.getComponents()){   
                bucle:
                for(String grado:gradosTomados){
                    if( ((JCheckBox) checkBox).getText().equals(grado)){
                        checkBox.setForeground(Color.GREEN);
                        break bucle;
                    }
                }
            }
        }
    }
    
    public boolean verificarDatos(ArrayList<String> data){
        /*
        *************VERIFICACION:FORMATO AÑO**********************************
        */
        
        int anio = Integer.parseInt(data.get(0));
        String msjError="";
        if(anio<1999){
            msjError+="Fecha incorrecta: año sin definir o menor a 1999\n";
        }else{
            
            if(!data.get(2).equals("...")){
                int lastIndex=data.size()-1;
                int erroresPrimaria=0;
                int erroresSecundaria=0;
                for (int i = 2; i <= lastIndex; i++) {
                    if( data.get(i).endsWith("P") && anio<2000)
                        erroresPrimaria++;
                    
                    if( data.get(i).endsWith("S") && anio<2005)
                        erroresSecundaria++;
                }
                if( (erroresSecundaria>0 && erroresPrimaria>0) || erroresSecundaria>0 ){
                    msjError+="Fecha incorrecta para asignar una tutoria a un grado de Secundaria\n";
                }else if (erroresPrimaria>0){
                    msjError+="Fecha incorrecta para asignar una tutoria a un grado de Primaria\n";
                }
            }
        }
        
        /*
        *************VERIFICACION:CAMPOS VACIOS O "..."************************
        */
        if(data.get(1).equals("...")){
            msjError+="No se ha seleccionado un tutor\n";
        }
        if(data.get(2).equals("...")){
            msjError+="No se ha seleccionado ningun grado\n";
            
        }
        
        if(!(msjError.isBlank())){
            procesosAux.msjDialog(msjError);
            return false;
        }else {
            return true;
        }
        
    }
    
    public boolean VerificarGrados(ArrayList<String> data){
        int lastIndex=data.size()-1;
        String msjError="";
        String codDocente = crudTutoria.obtenerCodDocente(data.get(1));
        ArrayList<String> gradosTomados = crudTutoria.BuscarGrados(
                Integer.parseInt(data.get(0)),codDocente);
        for(int i=2;i<=lastIndex;i++){
            bucle:
            for(String grado: gradosTomados){
                // le quitamos la ultima letra que era para indetificar de que nivel es el grado
                String Seleccionado= data.get(i).substring(0,
                                               data.get(i).length()-1);
                if(Seleccionado.equals(grado)){
                    msjError+=Seleccionado+" ya tiene un tutor asignado\n";
                }
            }
        }
        if(!(msjError.isBlank())){
            procesosAux.msjDialog(msjError);
            return false;
        }else {
            return true;
        }
    }
    
    /*Este metodo limita que solo se puede seleccionar un grado por nivel
    dando maximo de 3 y un minimo de 1 , se besabilita la seleccion de otros
    chechkBoxes cuando se ha seleccionado la cantidad limite*/
    public void limitarNumeroGrados(){
        JPanel[] paneles={vista.panelInicial,vista.panelPrimaria,vista.panelSecundaria};
        int maxCheckBoxes = 1;
        
        for(JPanel panel: paneles){
            for(Component checkBox: panel.getComponents()){
                   ((JCheckBox) checkBox).addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            int checkedCount = 0;
                            for (Component checkBox: panel.getComponents()) {
                                if (((JCheckBox) checkBox).isSelected()) {
                                    checkedCount++;
                                }
                            }
                            if (checkedCount >= maxCheckBoxes) {
                                for (Component checkBox: panel.getComponents()) {
                                    if (!((JCheckBox) checkBox).isSelected()) {
                                        checkBox.setEnabled(false);
                                    }
                                }
                            } else {
                                for (Component checkBox: panel.getComponents()) {
                                    checkBox.setEnabled(true);
                                }
                            }
                        }
                   });
            }
        }   
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
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==vista.btnLimpiar){
            procesos.limpiarCampos(vista);
            registroaModificar[0]="0";
            registroaModificar[1]="0";
            vista.tblProfes.clearSelection();
        }
        
        if(e.getSource()==vista.btnBorrar){
            if(registroaModificar[0].equals("0") || 
               registroaModificar[1].equals("0")){
                procesosAux.msjDialog("Ningun resgistro se ha seleccionado para eliminar");
            }else{
                crudTutoria.eliminar(
                        Integer.parseInt(registroaModificar[0]), 
                            registroaModificar[1]);
                procesosAux.msjDialog("Registro eliminado exitosamente");
                actualizarDatos();
                procesos.limpiarCampos(vista);
                
                DefaultTableModel tableModel = new DefaultTableModel(0, 0);
                vista.tblGrados.setModel(tableModel);
            }
            
        }
        
        if(e.getSource()==vista.btnActualizar){
            ArrayList<String> data=procesos.leerDatos(vista);
            boolean datosValidos=verificarDatos(data);
            if(registroaModificar[0].equals("0") || registroaModificar[1].equals("0")){
                procesosAux.msjDialog("Ningun resgistro se ha seleccionado para actualizar");
            }else{
                if(datosValidos){
                    boolean SeleccionCorrecta=VerificarGrados(data);
                    if(SeleccionCorrecta){
                        //Aca empieza la actualizacion
                        String codDocente=crudTutoria.obtenerCodDocente(data.get(1));
                        crudTutoria.eliminar(Integer.parseInt(registroaModificar[0]), 
                            registroaModificar[1]);
                        int lastIndex=data.size()-1;
                        for(int i=2;i<=lastIndex;i++){
                            int codGrado=crudTutoria.obtenerCodGrado(data.get(i));

                            String gradoFormateado = data.get(i).
                                    substring(0,data.get(i).length()-1);
                            data.set(i, gradoFormateado);

                            Tutoria t= new Tutoria(Integer.parseInt(data.get(0)), 
                                                   new Docente(codDocente), 
                                                   new GradoAlumno(data.get(i)));
                            crudTutoria.insertar(t, codGrado);

                        }
                        actualizarDatos();
                        crudTutoria.ListarGradosAsignados(vista.tblGrados, 
                                codDocente, 
                                Integer.parseInt(data.get(0)));

                        procesosAux.msjDialog("Se ha actualizado el registro exitosamente");
                        
                    }
                }
            }
        }
        
        if(e.getSource()==vista.btnCrear){
            ArrayList<String> data=procesos.leerDatos(vista);
            boolean datosValidos=verificarDatos(data);
            
            if(datosValidos){
                //obtenemos codigo del Docente
                String codDocente=crudTutoria.obtenerCodDocente(data.get(1));
                
                boolean registroExiste=crudTutoria.BuscarTutoria(
                          Integer.parseInt(data.get(0)),codDocente);
                if(registroExiste){
                    procesosAux.msjDialog("Ese registro ya existe");
                }else{
                    boolean SeleccionCorrecta=VerificarGrados(data);
                    if(SeleccionCorrecta){
                        //Insertamos segun la cantidad de grados asignados
                        int lastIndex=data.size()-1;
                        int cantRegistrosInsertados=0;
                        for(int i=2;i<=lastIndex;i++){
                            int codGrado=crudTutoria.obtenerCodGrado(data.get(i));

                            String gradoFormateado = data.get(i).
                                    substring(0,data.get(i).length()-1);
                            data.set(i, gradoFormateado);

                            Tutoria t= new Tutoria(Integer.parseInt(data.get(0)), 
                                                   new Docente(codDocente), 
                                                   new GradoAlumno(data.get(i)));
                            crudTutoria.insertar(t, codGrado);
                            cantRegistrosInsertados++;
                        }
                        procesosAux.msjDialog(cantRegistrosInsertados+" Registros ingresados exitosamente");
                        actualizarDatos();

                    }
                }
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int numfila = vista.tblProfes.rowAtPoint(e.getPoint());
        int columAnio = 0; //num de columna de año de la tutoria
        int columCodDocente = 1; //num de columna de codigo del docente
        int columNomDocente = 2; //num de columna de nombre completo del docente
        
        if(numfila>-1){
            
            int anio=Integer.parseInt(vista.tblProfes.getValueAt(numfila, columAnio).toString());
            String codDocente= vista.tblProfes.getValueAt(numfila, columCodDocente).toString();
            String nomDocente= vista.tblProfes.getValueAt(numfila, columNomDocente).toString();
            crudTutoria.ListarGradosAsignados(vista.tblGrados, codDocente, anio);
            registroaModificar[0]=String.valueOf(anio);
            registroaModificar[1]=codDocente;
            
            /* **************************************************************
                     RELLENAR DATOS SEGUN QUE REGISTRO SE CLICKEA DE LA TABLA
            **************************************************************  */
            vista.txtAnio.setText(String.valueOf(anio));
            vista.cbxTutor.addItem(nomDocente);
            vista.cbxTutor.setSelectedItem(nomDocente);
            
            /* **************************************************************
                     AUTOMARCAR CHECKBOX SEGUN QUE REGISTRO SE CLICKEA DE LA TABLA
            **************************************************************  */
            //creamos una lista con los grados asignados en la tabla Grados Asignados
            ArrayList<String> grados=new ArrayList<>();
            for(int i=0;i<vista.tblGrados.getRowCount();i++){
                String grado = vista.tblGrados.getValueAt(i, 0).toString();
                int numvuelta=0;
                int indexWhiteSpace=0;
                bucle:
                for(int j=0;j<grado.length();j++){
                    if(Character.isWhitespace(grado.charAt(j))){
                        numvuelta++;
                        indexWhiteSpace=j;
                    }
                    if(numvuelta==2){
                        break bucle;
                    }
                }
                grados.add(grado.substring(0, indexWhiteSpace));
                
            }
            
            //desmarcamos algun cehckbox previamente seleccionado
            procesos.vaciarChekBox(vista);
            
            //marcamos los checkbox que se encuentran en la lista grados
            JPanel[] paneles={vista.panelInicial,vista.panelPrimaria,vista.panelSecundaria};
            for(JPanel panel: paneles){
                for(Component checkBox: panel.getComponents()){   
                    bucle:
                    for(String grado:grados){
                        if( ((JCheckBox) checkBox).getText().equals(grado) ){
                            ((JCheckBox) checkBox).doClick();
                            break bucle;
                        }
                    }
                }
            }
            
            actualizarGrados(anio,codDocente);
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
    
    public void LimitarGrados(){
            
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
            // Colorea de verde aquellos grados tomados en ese año
            int anio=Integer.parseInt(vista.txtAnio.getText());
            actualizarGrados(anio);
            //Carga los docentes disponibles en ese año
            procesos.cargarDocentes(vista.cbxTutor,
                    crudTutoria.BuscarDocentes(anio));
        }else{
            procesos.vaciarChekBox(vista);
        }
    }

}
