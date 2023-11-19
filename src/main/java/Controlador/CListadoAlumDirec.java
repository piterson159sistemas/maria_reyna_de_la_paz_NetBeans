
package Controlador;
import DAO.crudAlumno;
import Modelo.Alumno;
import Procesos.ProcesosAlumnos;
import Vista.lista_estudiantes_directivo_1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;
//dependencias para manejar restricciones en un JtextField 
import javax.swing.text.PlainDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import java.awt.event.KeyEvent;

public class CListadoAlumDirec implements ActionListener,MouseListener{
    lista_estudiantes_directivo_1 vista;
    Alumno alumno;
    String[] dataAlumno;
    crudAlumno crudAlumno = new crudAlumno();
    ProcesosAlumnos procesos=new ProcesosAlumnos();
    String msjError="";

    public CListadoAlumDirec(lista_estudiantes_directivo_1 listaEst) {
        vista=listaEst;
        vista.btnFiltrar.addActionListener(this);
        vista.btnBuscar.addActionListener(this);
        vista.btnModificar.addActionListener(this);
        vista.btnInsertar.addActionListener(this);
        vista.btnLimpiar.addActionListener(this);
        vista.tblListaAlumnos.addMouseListener(this);
        listaEst.setTitle("Gestion de Estudiantes");
        listaEst.setVisible(true);
        //TextFiled del buscador mostrará sugerecias segun se escriba
        ArrayList<String> nombres= crudAlumno.BuscarNombresAlumno();
        procesos.MostrarSugerencias(vista.txtBuscar, nombres);
        
        // carga de los elemento de todos los combos del frm
        procesos.cargaInicialCombos(vista.cbxFiltrarNivel, vista.cbxFiltrarGrado);
        procesos.cargaInicialCombos(vista.cbxNivel, vista.cbxGrado);
        procesos.cargarNiveles(vista.cbxFiltrarNivel);
        procesos.cargarNiveles(vista.cbxNivel);
        procesos.cargarEstados(vista.cbxFiltrarEstadoGrado);
        procesos.cargarEstados(vista.cbxEstadoGrado);
        procesos.cargarTiposDoc(vista.cbxTipoDoc);
        
        //cargamos las restricciones de los campos y combos del frm
        PermitirSoloLetras(vista.txtNombres);
        PermitirSoloLetras(vista.txtApellidoP);
        PermitirSoloLetras(vista.txtApellidoM);
        PermitirSoloNumeros(vista.txtAnio, 4);
        PermitirSoloNumeros(vista.txtFiltrarAnio, 4);
        vista.txtNumDoc.setEditable(false);
        detectarCambioCombo(vista.cbxTipoDoc, vista.txtNumDoc);
        
        
        ActualizarLista();
        //Combos para filtrar
        CargarCombosEnlazados(vista.cbxFiltrarNivel,vista.cbxFiltrarGrado);
        //combos para ver y modificar datos de Alumno
        CargarCombosEnlazados(vista.cbxNivel,vista.cbxGrado);
    }

    
    public void ActualizarLista(){
        String filtro = definirFiltros(null);
        crudAlumno.Listar(vista.tblListaAlumnos, vista.lblNumAlumnos,filtro);
        procesos.formatoColumnasTabla(vista.tblListaAlumnos);
        //procesos.CargarIconoEstado(vista.tblListaAlumnos);
    }
    
    public String definirFiltros(String nombreAlumno){
        String nivel=vista.cbxFiltrarNivel.getSelectedItem().toString();
        String grado=vista.cbxFiltrarGrado.getSelectedItem().toString();
        String estado=vista.cbxFiltrarEstadoGrado.getSelectedItem().toString();
        String anio=vista.txtFiltrarAnio.getText();
        String nombre=nombreAlumno;
        
        String filtro = crudAlumno.Filtrar(nivel, grado,estado,nombre,anio);
        return filtro;
    }
     
    public boolean VerificarDatos( ArrayList<String> dataAlumno){
            
        /*
        *************VERIFICACION:FORMATO AÑO**********************************
        */
        int anio=Integer.parseInt(dataAlumno.get(5));
        int LimitMin;
        String nivel=dataAlumno.get(7);

        if(anio<1999){
            msjError+="Fecha incorrecta: año menor a 1999\n";
        }else{
            if(!nivel.equals("...")){

                if( (nivel.equals("Primaria") && anio<2000) 
                      || (nivel.equals("Secundaria") && anio<2005)){

                    switch (nivel) {
                        case "Primaria" -> LimitMin=2000;
                        default-> LimitMin=2005;
                    }
                    msjError+="Fecha incorrecta: estudiante de nivel "+nivel+" con año"
                             + " de registro menor a "+LimitMin+"\n";
                }
            }                
        }
            
        /*
        *************VERIFICACION:NUMERO DE DOCUMENTO**************************
        */
            
        String tipoDoc=dataAlumno.get(1);
        String numDoc=dataAlumno.get(0);
        if(!(tipoDoc.equals("..."))){
            //Se comprueba si NumDoc tiene la longitud correcta
            if( (tipoDoc.equals("DNI") && numDoc.length()<8)
                ||( !(tipoDoc.equals("DNI")) && numDoc.length()<9) ){

                switch (tipoDoc) {
                    case "DNI" -> LimitMin=8;
                    default-> LimitMin=9;
                }
                msjError+="Numero de Documento incorrecto: "+tipoDoc+" con menos"
                        + " de "+LimitMin+" digitos\n";
            }
        }
            
        /*
        *************VERIFICACION:CAMPOS VACIOS O "..."************************
        */
        bucle:
        for(String dato:dataAlumno){
            if(dato.equals("0") || dato.equals("...")){
                 msjError+="No puede haber datos vacios o con valor \"...\"";
                 break bucle;
            }
        }
        
        if(!(msjError.isBlank())){
            return false;
        }else {
            return true;
        }
        
    }
    
    //metodo que permite ingresar solo letras y espacios en blaco en un txtField
    public void PermitirSoloLetras(JTextField campo){
        campo.setDocument(new PlainDocument() {
            @Override
            //sobreescribe este metodo para limitar los datos que se insertan
            public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
                // se verifica si lo que se inserta es nulo para salir del metodo con return
                if (str == null) {
                    return;
                }
                 
                //for que recorre cada uno de los caracteres de un string
                for (int i = 0; i < str.length(); i++) {
                    char c = str.charAt(i);
                    //se valida si el caracter es una letra, espacio en blanco o tecla retroceso
                    if (Character.isLetter(c) || Character.isWhitespace(c) || c == KeyEvent.VK_BACK_SPACE) {
                        //si es un caracter valido se inserta 
                        super.insertString(offset, String.valueOf(c), attr);
                        offset++;
                    }
                }
            }
        });
    }

    //metodo que permite ingresar solo numeros y en cierta cantidad segun el tipo de docuemnto
    public void PermitirSoloNumeros(JTextField campo,int limit){
        campo.setDocument(new PlainDocument() {
                @Override
                public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {         
                    if (str == null) {
                        return;
                    }
                    /* Se comprueba si:
                    Lo ingresado contiene solo digitos con la expresion regular "\\d"  
                    La cant de digitos esta dentro del limite
                    */
                    if (str.matches("\\d+") && 
                            (limit <= 0 ||(getLength() + str.length() <= limit)) ) {
                        super.insertString(offset, str, attr);
                    }
                }
            }); 
    }
    
    /* Metodo que detecta cuando se cambia de Item en el comboBox tipoDocumento
       para que cambie tambien el limite de numeros permitidos para el numDocumento
    */
    public void detectarCambioCombo(JComboBox tipoDoc,JTextField numDoc){
        tipoDoc.addItemListener(new ItemListener() {
        int limit=0; 
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    /*Cada vez que se cambia de un item a otro dentro del tipoDoc
                    se limpia el numDoc
                    */
                    numDoc.setText("");
                    String tipoDoc=vista.cbxTipoDoc.getSelectedItem().toString();
                    
                    //si el tipoDoc es valido (diferente a "..." )
                    if( !("...".equals(tipoDoc)) ){
                        numDoc.setEditable(true);
                        // verificamos si tipoDocumento es un DNI o un tipo diferente
                        if ("DNI".equals(tipoDoc)) {
                             limit=8;
                             PermitirSoloNumeros(numDoc, 8);
                        } else {
                            limit=9;
                            PermitirSoloNumeros(numDoc, 9);
                        }
                    }else{
                        numDoc.setEditable(false);
                        PermitirSoloNumeros(numDoc, 0);
                    }
                }
            }
        });
        
    }
    
    /* Metodo para cargar los comboBox Nivel y Grado de forma enlazada, es decir,
    segun que Nivel se escoge se muestra los grados enlazados(pertenecientes)
    a ese nivel */
    public void CargarCombosEnlazados(JComboBox cbxNivel,JComboBox cbxGrado){ 
        
        /*Usamos un ItemListener en el comboBox Nivel para mostrar los grados
        correspondientes al Nivel que se seleccione*/
        cbxNivel.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange()==ItemEvent.SELECTED){
                    String nivelSelect = cbxNivel.getSelectedItem().toString();
                    
                    // remueve todos los grados del anterior nivel seleccionado
                    cbxGrado.removeAllItems();
                    //cargamos los grados del actual el nivel seleccionado
                    procesos.cargarGrados(cbxGrado, nivelSelect);
                }
            }
        });
    }
    
    // FUNCIONALIDAD BOTONES
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==vista.btnFiltrar){
            ActualizarLista();         
        }
        
        if(e.getSource()==vista.btnLimpiar){
            procesos.Limpiarcampos(vista);
        }
        
        if(e.getSource()==vista.btnBuscar){
            //1° obtenemos nombre completo del alumno
            String nombreAlumno = vista.txtBuscar.getText();
            
            if(nombreAlumno.isBlank()){
                nombreAlumno="''";
            }else{
                nombreAlumno+="%";
            }
            //2° Se establece el nombre de busqueda
            String filtro = definirFiltros(nombreAlumno);
            //4° listamos al alumno en la tabla segun nombre y aplicando los demás filtros
            crudAlumno.Listar(vista.tblListaAlumnos, vista.lblNumAlumnos, filtro);
            //5° aplicamos un foramto de presentacion a la tabla
            procesos.formatoColumnasTabla(vista.tblListaAlumnos);
            procesos.CargarIconoEstado(vista.tblListaAlumnos);
        }
        
        if(e.getSource()==vista.btnModificar){
            ArrayList<String>data = procesos.leerAlumno(vista);
            boolean alumnoValido=VerificarDatos(data);
            boolean codigoExiste=crudAlumno.BuscarCodigo(data.get(0));
            if(alumnoValido && codigoExiste){
                alumno=new Alumno(data);
                //actualizamos
                int codGrado= crudAlumno.obtenerCodGrado(alumno.getGradoAlumno().getGrado()
                                                       ,alumno.getGradoAlumno().getNivel());
                
                int codEstado= crudAlumno.obtenerCodEstado(alumno.getGradoAlumno().getEstado());
                
                int codGradoAlumno=Integer.parseInt(dataAlumno[9]);
                crudAlumno.Actualizar(alumno, codGrado, codEstado, codGradoAlumno);
                ActualizarLista();
                
            }else{
                if( !(codigoExiste) ){
                    msjError+="El Alumno con Numero de Documento "
                            +data.get(0)+ " aun no está registrado\n";
                }
                procesos.msjDialog(msjError);
                msjError="";
            }        
        }
        
        
        if(e.getSource()==vista.btnInsertar){
            ArrayList<String>data = procesos.leerAlumno(vista);
            boolean alumnoValido=VerificarDatos(data);
            boolean codigoExiste=crudAlumno.BuscarCodigo(data.get(0));

            if(alumnoValido && !(codigoExiste)){
                alumno=new Alumno(data);
                int codGrado= crudAlumno.obtenerCodGrado(alumno.getGradoAlumno().getGrado()
                                                       ,alumno.getGradoAlumno().getNivel());
                
                int codEstado= crudAlumno.obtenerCodEstado(alumno.getGradoAlumno().getEstado());
                crudAlumno.Insertar(alumno,codGrado,codEstado);
                ActualizarLista();

            }else{
                if(codigoExiste){
                    msjError+="El Numero de Documento "+data.get(0)
                            + " ya existe, introduzca uno nuevo\n";
                }
                procesos.msjDialog(msjError);
                msjError="";
            }
            
        }
    }

    
    // FUNCIONALIDAD TABLA (clicks en el JTable)
    @Override
    public void mouseClicked(MouseEvent e) {
        //captura la fila que se selecciona
        int numfila = vista.tblListaAlumnos.rowAtPoint(e.getPoint());
        int columNumDoc = 0; //num de columna de Num Doc dentro de la fila seleccionada
        int columEstado = 3; //num de columna de estado dentro de la fila seleccionada
        
        if(numfila>-1){
            String numDocAlumno= vista.tblListaAlumnos.getValueAt(numfila, columNumDoc).toString();
            String estado=vista.tblListaAlumnos.getValueAt(numfila, columEstado).toString();
            dataAlumno= crudAlumno.Buscar(numDocAlumno,estado);
            procesos.MostrarAlumno(dataAlumno, vista);
            
            
        }
        
    }
    
    // no se usan estos metodos pero se deben implementar de todas formas
    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
    
}
