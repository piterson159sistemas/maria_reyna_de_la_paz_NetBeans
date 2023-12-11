
package Procesos;
import DAO.crudAlumno;
import DAO.crudRegistroNotas;
import DAO.crudAlumnoNotas;
import DAO.crudAreasGrados;
import VISTA_DIRECTIVO.Estudiante_Notas;
import VISTA_DOCENTE.Registrar_Notas;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class procesosRegistroNotas {
    String none="...";
    crudRegistroNotas crudNotas=new crudRegistroNotas();
    
    ProcesosAlumnos procesosAux= new ProcesosAlumnos();
    crudAlumno crudAux = new crudAlumno();
    crudAreasGrados crudAux2 = new crudAreasGrados();
    
    public void cagarAnios(JComboBox combo, String codUsuario){
        ArrayList<Integer> anios = crudNotas.listarAnios(codUsuario);
        procesosAux.cargarCombo(combo, anios);
    };
    
    public void cargarNiveles(JComboBox combo, String codUsuario,int anio){
        ArrayList<String> niveles = crudNotas.listarNiveles(codUsuario,anio);
        procesosAux.cargarCombo(combo, niveles);
    }
    
    public void cargarGrados(JComboBox combo, String codUsuario,int anio,String nivel){
        ArrayList<String> grados = crudNotas.listarGrados(codUsuario,anio,nivel);
        procesosAux.cargarCombo(combo, grados);
    }
    
    public void cargarAreas(JComboBox combo, String codUsuario,int anio,int codGrado){
        ArrayList<String> areas = crudNotas.listarAreas(codUsuario,anio,codGrado);
        procesosAux.cargarCombo(combo, areas);
    }
    
    public void cargarPeriodos(JComboBox combo){
        ArrayList<String> periodos = crudNotas.listarPeriodos();
        procesosAux.cargarCombo(combo,periodos);
    }
    
    public boolean verificarFiltros(Registrar_Notas frm){
        JComboBox[] combos = {frm.cbxAnio,frm.cbxNivel,frm.cbxGrado,
                frm.cbxArea,frm.cbxPeriodo};
        
        for(JComboBox combo: combos){
            if(combo.getSelectedItem().toString().equals("...")){
                return false;
            }
        }
        return true;
    }
    
    public void cargarAlumnos(Registrar_Notas frm){
        //Capturamos el modelo actual de la tabla
        DefaultTableModel tableModel = (DefaultTableModel) frm.tblDatos.getModel();
        //eliminamos las filas existentes
        tableModel.setRowCount(0);
        
        int codGrado = crudAux.obtenerCodGrado(
                frm.cbxNivel.getSelectedItem().toString(), 
                frm.cbxGrado.getSelectedItem().toString());
        int anio = Integer.parseInt(frm.cbxAnio.getSelectedItem().toString());
        
        //obtenemos los alumnos y los añadimos a la tabla
        ArrayList<String> alumnos = crudNotas.listarAlumnos(codGrado, anio);
        Object[] data= new Object[11];
        for(String alumno: alumnos){
            data[0]=alumno;
            data[10]=true;
            tableModel.addRow(data);
        }
        
        frm.tblDatos.setModel(tableModel);
    }
    
    public ArrayList<Integer> ObtenerCodAlumnos(Registrar_Notas frm){
        
        int codGrado = crudAux.obtenerCodGrado(
                frm.cbxNivel.getSelectedItem().toString(), 
                frm.cbxGrado.getSelectedItem().toString());
        int anio = Integer.parseInt(frm.cbxAnio.getSelectedItem().toString());
        
        ArrayList<Integer> codAlumnos = crudNotas.listarCodAlumnos(codGrado, anio);

        return codAlumnos;
    }
    
    
    
    public void setCantColumVisibles(int cantColumnas,JTable tabla){
        for (int i = 1; i <=cantColumnas; i++) {
            
        }
    }
    
    public int[] getCodigos(Registrar_Notas frm){
        String nivel = frm.cbxNivel.getSelectedItem().toString();
        String grado = frm.cbxGrado.getSelectedItem().toString();        
        
        int codGrado = crudAux2.obtenerCodGrado(grado, nivel);
        int codArea = crudAux2.obtenerCodArea(frm.cbxArea.getSelectedItem().toString());
        int[] codigos = {codGrado,codArea};
        return codigos;
    }
            
  
    public DefaultTableModel[] crearTablasNotas(Registrar_Notas frm,int[]codFiltro, ArrayList<String> Comp, 
            ArrayList<String> dataAlumno){
 
        int cantComp=Comp.size();
        int cantAlumnos=dataAlumno.size();
        ArrayList<Integer> notas = new ArrayList<>(); //Array de Notas
        Object[] data = new Object[12]; //Registro para para la tabla
        
        //Creamos los modelos de tablas para cada pagina de competencia
        DefaultTableModel[] modelos = new DefaultTableModel[cantComp];

        for(int i=0;i<cantComp;i++){
            modelos[i] = (DefaultTableModel) frm.tblDatos.getModel();
            modelos[i].setRowCount(0);
            
            int cantMaxNotas=-1;
            int cantColumVisibles=0;
            for(int j=0;j<cantAlumnos;j++){
                notas.clear();
                int codAlumno = Integer.parseInt(dataAlumno.get(j).split(",")[0]);
                int codComp = Integer.parseInt(Comp.get(j).split(":")[0]);
                notas = crudNotas.buscarNotas(
                         codAlumno,codFiltro[0], codFiltro[1], codComp);
                // codFiltro = {codPeriodo,codDocenteGrado}
                
                int cantNotas = notas.size();
                //Genereamos los registros para la tabla
                if(!notas.isEmpty()){
                    int sumaNotas= 0;
                    
                    //Nombre del Alumno
                    data[0]=dataAlumno.get(j).split(",")[1];

                    //Notas del Alumno
                    for (int k = 0; k < cantNotas; k++) {
                        data[k+1]=notas.get(k);
                        sumaNotas+=notas.get(k);
                    }
                    
                    //Promedio de Notas del Alumno
                    data[9]=sumaNotas/cantNotas;
                    
                    //Marcador cuando el Alumno YA ESTÁ REGISTRADO en tabla:calificaciones
                    data[11]=true;
                }else{
                    //Nombre del Alumno
                    data[0]=dataAlumno.get(j).split(",")[1];
                    
                    //Marcador cuando el Alumno AUN NO ESTÁ REGISTRADO en tabla:calificaciones
                    data[11]=false;
                }
                
                if(cantNotas>=cantMaxNotas){
                    cantMaxNotas=cantNotas;
                }
                    
                if(j==cantAlumnos-1){
                    cantColumVisibles=cantMaxNotas;
                }
                
                //agrego row al TableModel
                modelos[i].addRow(data);
            }
        }
        return modelos;
        
    }
    
    
    
}
