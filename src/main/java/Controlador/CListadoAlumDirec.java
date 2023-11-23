
package Controlador;
import DAO.crudAlumno;
import Modelo.Alumno;
import Procesos.ProcesosAlumnos;
import Vista.lista_estudiantes_directivo_1;
import VISTA_DIRECTIVO.Estudiante_Lista;

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
    Estudiante_Lista vista;
    Alumno alumno;
    crudAlumno crudAlumno = new crudAlumno();
    ProcesosAlumnos procesos=new ProcesosAlumnos();
    String msjError="";
    String numDocAlumno="0";
    int codGradoAlumno=0;

    public CListadoAlumDirec(Estudiante_Lista listaEst) {
        vista=listaEst;
        vista.btnCrearAlumno.addActionListener(this);
        vista.btnModificarAlumno.addActionListener(this);
        vista.btnLimpiar.addActionListener(this);
        vista.btnModificar.addActionListener(this);
        vista.btnBorrar.addActionListener(this);
        vista.btnInsertar.addActionListener(this);
        vista.btnFiltrar.addActionListener(this);
        vista.btnBuscar.addActionListener(this);
        vista.tblListaAlumnos.addMouseListener(this);
        
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
        procesos.CargarCombosEnlazados(vista.cbxFiltrarNivel,vista.cbxFiltrarGrado);
        //combos para ver y modificar datos de Alumno
        procesos.CargarCombosEnlazados(vista.cbxNivel,vista.cbxGrado);
    }

    
    public void ActualizarLista(){
        String filtro = definirFiltros(null);
        System.out.println(filtro);
        crudAlumno.Listar(vista.tblListaAlumnos, vista.lblNumAlumnos,filtro);
        procesos.formatoColumnasTabla(vista.tblListaAlumnos);
        procesos.CargarIconoEstado(vista.tblListaAlumnos);
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
    
    public boolean VerificarAlumno(ArrayList<String> data){
        msjError="";
        bucle:
        for(String dato:data){
            if(dato.equals("0") || dato.equals("...")){
                msjError+="Ningun dato del alunmno puede estar vacio o ser igual a 0\n";
                break bucle;
            }
        }
        String tipoDoc = data.get(1);
        if(!(tipoDoc.equals("..."))){
            String numDoc = data.get(0);
            int LimitMin;
            if(tipoDoc.equals("DNI") && numDoc.length()<8){
                msjError+="Numero de Documento incorrecto: "+tipoDoc+" con menos"
                    + " de 8 digitos\n";    
                
            }else if((!tipoDoc.equals("DNI")) && numDoc.length()<9){
                msjError+="Numero de Documento incorrecto: "+tipoDoc+" con menos"
                    + " de 9 digitos\n";    
            }
        }
        
        if(!(msjError.isBlank())){
            procesos.msjDialog(msjError);
            return false;
        }else {
            return true;
        }
        
    }
    
    public boolean verificarGradoAlumno(ArrayList<String> dataAlumno,ArrayList<String> dataGrado){
        msjError="";
        VerificarAlumno(dataAlumno);
        bucle:
        for(String dato:dataGrado){
            if(dato.equals("0") || dato.equals("...")){
                msjError+="No puede haber campos vacios o igual a 0 en la información de grado\n";
                break bucle;
            }
        }
        if(!(msjError.isBlank())){
            procesos.msjDialog(msjError);
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
    
    // FUNCIONALIDAD BOTONES
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==vista.btnCrearAlumno){
             ArrayList<String> data= procesos.leerAlumno(vista);
             boolean AlumnoValido=VerificarAlumno(data);
             if(AlumnoValido){
                 boolean registroExiste=crudAlumno.BuscarCodigo(data.get(0));
                 if(registroExiste){
                  procesos.msjDialog("El alumno con codigo: "+data.get(0)+" ya existe");
                 }else{
                     Alumno a = new Alumno(data);
                     crudAlumno.insertarAlumno(alumno);
                 }
             }
        }
        
        if(e.getSource()==vista.btnModificarAlumno){
            if(numDocAlumno.equals("0")){
                procesos.msjDialog("No se ha seleccionado ningun alumno");
            }else{
                ArrayList<String> data= procesos.leerAlumno(vista);
                 boolean AlumnoValido=VerificarAlumno(data);
                 if(AlumnoValido){
                    boolean registroExiste=crudAlumno.BuscarCodigo(data.get(0));
                     if(!registroExiste){
                         procesos.msjDialog("El alumno con codigo: "+data.get(0)+" aun no existe");
                     }else{
                         crudAlumno.actualizarAlumno(data, 
                                 Integer.parseInt(data.get(0)));
                     }
                 }
            }
        }
        
        if(e.getSource()==vista.btnFiltrar){
            ActualizarLista();         
        }
        
        if(e.getSource()==vista.btnLimpiar){
            procesos.Limpiarcampos(vista);
            vista.tblListaAlumnos.clearSelection();
            numDocAlumno="0";
            codGradoAlumno=0;
            
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
            if(codGradoAlumno==0){
                procesos.msjDialog("No se ha seleccionado ningun registro");
            }else{
                ArrayList<String>dataAlumno = procesos.leerAlumno(vista);
                ArrayList<String>dataGrado = procesos.leerGradoAlumno(vista);
                boolean dataValida=verificarGradoAlumno(dataAlumno,dataGrado);
                
                if(dataValida){
                    //led.txtAnio,led.cbxNivel,led.cbxGrado,led.cbxEstadoGrado
                    int codGrado=crudAlumno.obtenerCodGrado(dataGrado.get(1),
                            dataGrado.get(2));
                    int codEstado=crudAlumno.obtenerCodEstado(dataGrado.get(3));
                    int[] valores={Integer.parseInt(dataGrado.get(0)),//1°Año
                                  codGrado,codEstado};  //2°codGrado, 3°codEstado
                    crudAlumno.actualizarGradoAlumno(valores, codGradoAlumno);
                    ActualizarLista();    
                }
            }
        }
        
        if(e.getSource()==vista.btnBorrar){
            if(codGradoAlumno==0){
                procesos.msjDialog("No se ha seleccionado ningun registro");
            }else{
                crudAlumno.eliminarGradoAlumno(codGradoAlumno);
                ActualizarLista();
            }
        }

        if(e.getSource()==vista.btnInsertar){
            ArrayList<String>dataAlumno = procesos.leerAlumno(vista);
            ArrayList<String>dataGrado = procesos.leerGradoAlumno(vista);
            boolean dataValida=verificarGradoAlumno(dataAlumno,dataGrado);
                
            if(dataValida){
                int codGrado=crudAlumno.obtenerCodGrado(dataGrado.get(1),
                        dataGrado.get(2));
                int codEstado=crudAlumno.obtenerCodEstado(dataGrado.get(3));

                int[] valores={Integer.parseInt(dataGrado.get(0)),//1°Año
                               Integer.parseInt(dataAlumno.get(0)),//2°codAlumno
                                codGrado,codEstado};

                boolean registroExiste=crudAlumno.buscarRegistroGradoAlumno(valores);
                if(registroExiste){
                    procesos.msjDialog("Esta informacion de grado ya existe");
                }else{
                    crudAlumno.insertarGradoAlumno(valores);
                    ActualizarLista();    
                }
            }
        }
    }

    
    // FUNCIONALIDAD TABLA (clicks en el JTable)
    @Override
    public void mouseClicked(MouseEvent e) {
        //captura la fila que se selecciona
        int numfila = vista.tblListaAlumnos.rowAtPoint(e.getPoint());
        int columNumDoc = 0; //num de columna de Num Doc dentro de la fila seleccionada
        int columGradoAlumno = 3; //num de columna de codGradoAlumno dentro de la fila seleccionada
        
        if(numfila>-1){
            numDocAlumno= vista.tblListaAlumnos.getValueAt(numfila, columNumDoc).toString();
            String[] dataAlumno= crudAlumno.BuscarAlumno(Integer.parseInt(numDocAlumno));
            procesos.MostrarAlumno(dataAlumno, vista);
            
            codGradoAlumno=Integer.parseInt(vista.tblListaAlumnos.
                    getValueAt(numfila, columGradoAlumno).toString());
            if(codGradoAlumno==0){
                JComponent[] elementos={vista.cbxNivel,vista.cbxGrado,vista.cbxEstadoGrado,vista.txtAnio};
                procesos.InfoGradoDefault(elementos);
            }else{
                String[] dataGradoAlumno= crudAlumno.buscarGradoAlumno(codGradoAlumno);
                procesos.MostrarGradoAlumno(dataGradoAlumno, vista);
            }
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
