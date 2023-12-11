package Controlador;

import VISTA_DIRECTIVO.Asignar_Horario;
import Modelo.Horario;
import DAO.DAOHorario;
import DAO.crudAlumno;
import Procesos.ProcesosHorario;
import Procesos.ProcesosAlumnos;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import javax.print.DocFlavor;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

public class CAsignar_Horario implements ActionListener{
    Asignar_Horario vista;
    DAOHorario daoHora=new DAOHorario();
    //crudAlumno crudAlumno=new crudAlumno();
    ProcesosHorario procesos=new ProcesosHorario();
    ProcesosAlumnos procesosAlu=new ProcesosAlumnos();
    int i=0; //ejemplo
    Color color=null; //variable para almacenar color seleccionado
    JButton botonSelecionado=null; //aca se guardara la variable para llamar al boton seleccionado
    String colorString="";
    String Dia="";
    String Hora="";
    private String textoAño;
    private String grado;
    private String area;
    //estas variables son por mientras para mi ejemplo
    //Codigo_Horario, Dia, Horario, Codigo_Docente_Area, Color
    int codigoHorario = 0;
    int codigoDocenteGrado = 0;  // este codigo tomara valor cuando sea extraido de la base de datos
    private ArrayList<Horario> botonesSelecionados=new ArrayList<>();
    
    
    
    public CAsignar_Horario(Asignar_Horario menu){
        vista=menu;
        //botones principales
        vista.btnFiltrar.addActionListener(this);
        vista.btnLimpiar.addActionListener(this);
        vista.btnEditar.addActionListener(this);
        vista.btnGuardar.addActionListener(this);
        vista.btnAceptar.addActionListener(this);
        vista.btnAceptar.setEnabled(false);
        //botones colores
        vista.btnColor1.addActionListener(this);
        vista.btnColor2.addActionListener(this);
        vista.btnColor1.setEnabled(false);
        vista.btnColor2.setEnabled(false);
        //botones horario
        vista.btnL1.addActionListener(this);//LUNES
        vista.btnL2.addActionListener(this);
        vista.btnL3.addActionListener(this);
        vista.btnL4.addActionListener(this);
        vista.btnL5.addActionListener(this);
        vista.btnL6.addActionListener(this);
        vista.btnL7.addActionListener(this);
        vista.btnL1.setEnabled(false); //bloquear de frente LUNES
        vista.btnL2.setEnabled(false);
        vista.btnL3.setEnabled(false);
        vista.btnL4.setEnabled(false);
        vista.btnL5.setEnabled(false);
        vista.btnL6.setEnabled(false);
        vista.btnL7.setEnabled(false);
        vista.btnM1.addActionListener(this);//MARTES
        vista.btnM2.addActionListener(this);
        vista.btnM3.addActionListener(this);
        vista.btnM4.addActionListener(this);
        vista.btnM5.addActionListener(this);
        vista.btnM6.addActionListener(this);
        vista.btnM7.addActionListener(this);
        vista.btnM1.setEnabled(false); //bloquear de frente MARTES
        vista.btnM2.setEnabled(false);
        vista.btnM3.setEnabled(false);
        vista.btnM4.setEnabled(false);
        vista.btnM5.setEnabled(false);
        vista.btnM6.setEnabled(false);
        vista.btnM7.setEnabled(false);
        vista.btnMI1.addActionListener(this);//MIERCOLES
        vista.btnMI2.addActionListener(this);
        vista.btnMI3.addActionListener(this);
        vista.btnMI4.addActionListener(this);
        vista.btnMI5.addActionListener(this);
        vista.btnMI6.addActionListener(this);
        vista.btnMI7.addActionListener(this);
        vista.btnMI1.setEnabled(false); //bloquear de frente MIERCOLES
        vista.btnMI2.setEnabled(false);
        vista.btnMI3.setEnabled(false);
        vista.btnMI4.setEnabled(false);
        vista.btnMI5.setEnabled(false);
        vista.btnMI6.setEnabled(false);
        vista.btnMI7.setEnabled(false);
        vista.btnJ1.addActionListener(this);//JUEVES
        vista.btnJ2.addActionListener(this);
        vista.btnJ3.addActionListener(this);
        vista.btnJ4.addActionListener(this);
        vista.btnJ5.addActionListener(this);
        vista.btnJ6.addActionListener(this);
        vista.btnJ7.addActionListener(this);
        vista.btnJ1.setEnabled(false); //bloquear de frente JUEVES
        vista.btnJ2.setEnabled(false);
        vista.btnJ3.setEnabled(false);
        vista.btnJ4.setEnabled(false);
        vista.btnJ5.setEnabled(false);
        vista.btnJ6.setEnabled(false);
        vista.btnJ7.setEnabled(false);
        vista.btnV1.addActionListener(this);//VIERNES
        vista.btnV2.addActionListener(this);
        vista.btnV3.addActionListener(this);
        vista.btnV4.addActionListener(this);
        vista.btnV5.addActionListener(this);
        vista.btnV6.addActionListener(this);
        vista.btnV7.addActionListener(this);
        vista.btnV1.setEnabled(false); //bloquear de frente VIERNES
        vista.btnV2.setEnabled(false);
        vista.btnV3.setEnabled(false);
        vista.btnV4.setEnabled(false);
        vista.btnV5.setEnabled(false);
        vista.btnV6.setEnabled(false);
        vista.btnV7.setEnabled(false);
        vista.btnRecreo.addActionListener(this);//aun no lo uso pero lo pongo porsiacaso
        //otros elementos
        vista.txtAño.addActionListener(this);
        vista.cbxGrado.addActionListener(this);
        vista.cbxArea.addActionListener(this);
        vista.cbxArea.setEnabled(false);
        daoHora.obtenerUltimoCodigoHorario(codigoHorario);
        daoHora.obtenerNombreGrados();
        cargarNombresGrados();
        cargarNombresAreas();
        mostrarInfoDocentesEnTabla("3er Grado","2023");
        procesos.cargaInicialCombo(vista.cbxGrado);
        procesos.cargaInicialCombo(vista.cbxArea);
        //procesosAlu.cargaInicialCombos(vista.cbxNivel, vista.cbxGrado);
        //procesosAlu.cargarNiveles(vista.cbxNivel);
        
        //ActualizarLista();
        //procesosAlu.CargarCombosEnlazados(vista.cbxNivel, vista.cbxGrado);//combos para filtrar
        //vista.txtAño.
        
 //       menu.setTitle("Menu de Gestión Directivo");
 //       menu.setLocationRelativeTo(null);
 //       menu.setDefaultCloseOperation(menu.EXIT_ON_CLOSE);
 //       menu.setVisible(true);
        
    }
    
/*    public void definirFiltros(){
        String grado=vista.cbxGrado.getSelectedItem().toString();
        
        //String filtrar = daoHora.FiltrarANG(grado, nivel, grado);
        //return filtrar;
    }*/
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {   
///////////////////////
/*BOTONES PRINCIPALES*/
///////////////////////
        if(e.getSource()==vista.btnEditar){
            // Al hacer clic en btnEditar, habilitar los botones que deseas editar
            vista.btnL1.setEnabled(true);//LUNES
            vista.btnL2.setEnabled(true);
            vista.btnL3.setEnabled(true);
            vista.btnL4.setEnabled(true);
            vista.btnL5.setEnabled(true);
            vista.btnL6.setEnabled(true);
            vista.btnL7.setEnabled(true);
            vista.btnM1.setEnabled(true);//MARTES
            vista.btnM2.setEnabled(true);
            vista.btnM3.setEnabled(true);
            vista.btnM4.setEnabled(true);
            vista.btnM5.setEnabled(true);
            vista.btnM6.setEnabled(true);
            vista.btnM7.setEnabled(true);
            vista.btnMI1.setEnabled(true);//MIERCOLES
            vista.btnMI2.setEnabled(true);
            vista.btnMI3.setEnabled(true);
            vista.btnMI4.setEnabled(true);
            vista.btnMI5.setEnabled(true);
            vista.btnMI6.setEnabled(true);
            vista.btnMI7.setEnabled(true);
            vista.btnJ1.setEnabled(true);//JUEVES
            vista.btnJ2.setEnabled(true);
            vista.btnJ3.setEnabled(true);
            vista.btnJ4.setEnabled(true);
            vista.btnJ5.setEnabled(true);
            vista.btnJ6.setEnabled(true);
            vista.btnJ7.setEnabled(true);
            vista.btnV1.setEnabled(true); //VIERNES
            vista.btnV2.setEnabled(true);
            vista.btnV3.setEnabled(true);
            vista.btnV4.setEnabled(true);
            vista.btnV5.setEnabled(true);
            vista.btnV6.setEnabled(true);
            vista.btnV7.setEnabled(true);
            vista.btnColor1.setEnabled(true);
            vista.btnColor2.setEnabled(true);
            vista.btnAceptar.setEnabled(true);
            vista.cbxArea.setEnabled(true);
            //bloquear combobox, año, limpiar y filtrar
            vista.btnFiltrar.setEnabled(false);
            vista.txtAño.setEnabled(false);
            vista.cbxGrado.setEnabled(false);
            vista.btnLimpiar.setEnabled(false);
        }
        //////
        if(e.getSource()==vista.btnGuardar){
            vista.btnL1.setEnabled(false);//LUNES
            vista.btnL2.setEnabled(false);
            vista.btnL3.setEnabled(false);
            vista.btnL4.setEnabled(false);
            vista.btnL5.setEnabled(false);
            vista.btnL6.setEnabled(false);
            vista.btnL7.setEnabled(false);
            vista.btnM1.setEnabled(false);//MARTES
            vista.btnM2.setEnabled(false);
            vista.btnM3.setEnabled(false);
            vista.btnM4.setEnabled(false);
            vista.btnM5.setEnabled(false);
            vista.btnM6.setEnabled(false);
            vista.btnM7.setEnabled(false);
            vista.btnMI1.setEnabled(false);//MIERCOLES
            vista.btnMI2.setEnabled(false);
            vista.btnMI3.setEnabled(false);
            vista.btnMI4.setEnabled(false);
            vista.btnMI5.setEnabled(false);
            vista.btnMI6.setEnabled(false);
            vista.btnMI7.setEnabled(false);
            vista.btnJ1.setEnabled(false);//JUEVES
            vista.btnJ2.setEnabled(false);
            vista.btnJ3.setEnabled(false);
            vista.btnJ4.setEnabled(false);
            vista.btnJ5.setEnabled(false);
            vista.btnJ6.setEnabled(false);
            vista.btnJ7.setEnabled(false);
            vista.btnV1.setEnabled(false); //VIERNES
            vista.btnV2.setEnabled(false);
            vista.btnV3.setEnabled(false);
            vista.btnV4.setEnabled(false);
            vista.btnV5.setEnabled(false);
            vista.btnV6.setEnabled(false);
            vista.btnV7.setEnabled(false);
            vista.btnColor1.setEnabled(false);
            vista.btnColor2.setEnabled(false);
            vista.btnAceptar.setEnabled(false);
            vista.cbxArea.setEnabled(false);
            //desbloquear
            vista.btnFiltrar.setEnabled(true);
            vista.txtAño.setEnabled(true);
            vista.cbxGrado.setEnabled(true);
            vista.btnLimpiar.setEnabled(true);
        }
        ////
        if(e.getSource()==vista.btnAceptar){
            System.out.println(area);
            System.out.println(color);
            procesos.aplicarColor(botonSelecionado);//este metodo llama al selector de color
            botonSelecionado.setText(area); //cambiamos el nombre del boton (asigna el area)
            color=procesos.devolverColor();//el color seleccionado lo trae a esta clase
            System.out.println("este debe ser el color: "+color);  //validaciones de que es el color seleccionado
            String colorAlmacenar = getColorStringAlmacenar(color); //le damos formato para almacenar
            System.out.println("color almacenar: "+colorAlmacenar); //imprime en el formato a almacenar
            System.out.println("codigo horario antes del if: " + codigoHorario);
            
            
            // Verifica si ya existe un registro con la misma combinación de día y hora en la BD
            //aca tengo que agregar el codigo grado pero aun no se... tengo que pensar
            
                int año=Integer.parseInt(textoAño);//convertimos el textoAño a entero para que pase el parametro... sino error porque textoAño esta tipo String
                if (!daoHora.existeHorario(Dia, Hora, año, grado)) {
                    //traemos ultimo codigo horario porsiacaso
                    daoHora.obtenerUltimoCodigoHorario(codigoHorario);
                    // Si no existe, realiza la inserción en la base de datos
                    daoHora.insertarHorario(codigoHorario, Dia, Hora, codigoDocenteGrado, colorAlmacenar, area);
                } 
                else {
                    // Si ya existe, intenta actualizar el registro en lugar de insertar
                    //obtenemos el codigohorario para buscarlo y actualizar ese registro
                    codigoHorario=daoHora.obtenerCodigoHorario(textoAño, grado, Dia, Hora);
                    System.out.println("año: "+textoAño+" grado: "+grado+" dia: "+Dia+" hora: "+Hora+" codigo: "+codigoHorario);
                    System.out.println("Parámetros para actualizarHorario: " + codigoHorario + ", " + Dia + ", " + Hora + ", " + codigoDocenteGrado + ", " + colorAlmacenar + ", " + area);
                    if (daoHora.actualizarHorario(codigoHorario, Dia, Hora, codigoDocenteGrado, colorAlmacenar, area)) {
                        System.out.println("Registro actualizado para el día " + Dia + " hora: " + Hora + " codDoce: " + codigoDocenteGrado
                                + " color: " + colorAlmacenar + " area: " + area);
                    } else {
                        System.out.println("No se pudo actualizar el registro para el día " + Dia + " hora: " + Hora + " codDoce: " + codigoDocenteGrado
                                + " color: " + colorAlmacenar + " area: " + area);
                    }                        
                }
            botonesSelecionados.clear();
        }
        ////
        if(e.getSource()==vista.btnFiltrar){
            textoAño=vista.txtAño.getText();
            
            codigoDocenteGrado=daoHora.obtenerCodigoDocenteGrado(textoAño,grado,area);
            mostrarInfoDocentesEnTabla(grado, textoAño);
            cargarHorarioAbtn();
        }
//////////////////////
/*BOTONES HORARIO*/
//////////////////////
        if(e.getSource()==vista.btnL1 || e.getSource()==vista.btnL2 || e.getSource()==vista.btnL3 ||
           e.getSource()==vista.btnL4 || e.getSource()==vista.btnL5 || e.getSource()==vista.btnL5 ||
           e.getSource()==vista.btnL6 || e.getSource()==vista.btnL7 || //lunes
           e.getSource()==vista.btnM1 || e.getSource()==vista.btnM2 || e.getSource()==vista.btnM3 ||
           e.getSource()==vista.btnM4 || e.getSource()==vista.btnM5 || e.getSource()==vista.btnM5 ||
           e.getSource()==vista.btnM6 || e.getSource()==vista.btnM7 || //martes
           e.getSource()==vista.btnMI1 || e.getSource()==vista.btnMI2 || e.getSource()==vista.btnMI3 ||
           e.getSource()==vista.btnMI4 || e.getSource()==vista.btnMI5 || e.getSource()==vista.btnMI5 ||
           e.getSource()==vista.btnMI6 || e.getSource()==vista.btnMI7 || //Miercoles
           e.getSource()==vista.btnJ1 || e.getSource()==vista.btnJ2 || e.getSource()==vista.btnJ3 ||
           e.getSource()==vista.btnJ4 || e.getSource()==vista.btnJ5 || e.getSource()==vista.btnJ5 ||
           e.getSource()==vista.btnJ6 || e.getSource()==vista.btnJ7 || //Jueves
           e.getSource()==vista.btnV1 || e.getSource()==vista.btnV2 || e.getSource()==vista.btnV3 ||
           e.getSource()==vista.btnV4 || e.getSource()==vista.btnV5 || e.getSource()==vista.btnV5 ||
           e.getSource()==vista.btnV6 || e.getSource()==vista.btnV7  //Viernes
           ){
            setBordeBlancoEnTodosLosBotones();
            botonSelecionado=(JButton) e.getSource();
            color=((JButton)e.getSource()).getBackground();
            colorString = getColorString(color);
            procesos.aplicarColor2(vista.btnColor2, color,colorString);
            setBordeNegro(botonSelecionado);
            imprimirInfoHorario(botonSelecionado);//llamamos a la funcion para imprimir en pantalla la info del boton
            botonesSelecionados.add(new Horario(Dia, Hora, colorString, area));
        }
        
        if(e.getSource()==vista.btnL1 || e.getSource()==vista.btnL2 || e.getSource()==vista.btnL3 ||
           e.getSource()==vista.btnL4 || e.getSource()==vista.btnL5 || e.getSource()==vista.btnL5 ||
           e.getSource()==vista.btnL6 || e.getSource()==vista.btnL7){
            
           Dia="Lunes";
            if(e.getSource()==vista.btnL1){Hora="8:00-8:45";} else
            if(e.getSource()==vista.btnL2){Hora="8:45-9:30";} else
            if(e.getSource()==vista.btnL3){Hora="9:30-10:15";} else
            if(e.getSource()==vista.btnL4){Hora="10:30-11:15";} else
            if(e.getSource()==vista.btnL5){Hora="11:15-12:00";} else
            if(e.getSource()==vista.btnL6){Hora="12:00-12:45";} else
            if(e.getSource()==vista.btnL7){Hora="12:45-13:30";} 
            System.out.println("Dia: "+Dia+" Hora: "+Hora);
        }
        if(e.getSource()==vista.btnM1 || e.getSource()==vista.btnM2 || e.getSource()==vista.btnM3 ||
           e.getSource()==vista.btnM4 || e.getSource()==vista.btnM5 || e.getSource()==vista.btnM5 ||
           e.getSource()==vista.btnM6 || e.getSource()==vista.btnM7){
           Dia="Martes";
            if(e.getSource()==vista.btnM1){Hora="8:00-8:45";} else
            if(e.getSource()==vista.btnM2){Hora="8:45-9:30";} else
            if(e.getSource()==vista.btnM3){Hora="9:30-10:15";} else
            if(e.getSource()==vista.btnM4){Hora="10:30-11:15";} else
            if(e.getSource()==vista.btnM5){Hora="11:15-12:00";} else
            if(e.getSource()==vista.btnM6){Hora="12:00-12:45";} else
            if(e.getSource()==vista.btnM7){Hora="12:45-13:30";} 
            System.out.println("Dia: "+Dia+" Hora: "+Hora);
        }
        if(e.getSource()==vista.btnMI1 || e.getSource()==vista.btnMI2 || e.getSource()==vista.btnMI3 ||
           e.getSource()==vista.btnMI4 || e.getSource()==vista.btnMI5 || e.getSource()==vista.btnMI5 ||
           e.getSource()==vista.btnMI6 || e.getSource()==vista.btnMI7){
           Dia="Miercoles";
            if(e.getSource()==vista.btnMI1){Hora="8:00-8:45";} else
            if(e.getSource()==vista.btnMI2){Hora="8:45-9:30";} else
            if(e.getSource()==vista.btnMI3){Hora="9:30-10:15";} else
            if(e.getSource()==vista.btnMI4){Hora="10:30-11:15";} else
            if(e.getSource()==vista.btnMI5){Hora="11:15-12:00";} else
            if(e.getSource()==vista.btnMI6){Hora="12:00-12:45";} else
            if(e.getSource()==vista.btnMI7){Hora="12:45-13:30";} 
            System.out.println("Dia: "+Dia+" Hora: "+Hora);
        }
        if(e.getSource()==vista.btnJ1 || e.getSource()==vista.btnJ2 || e.getSource()==vista.btnJ3 ||
           e.getSource()==vista.btnJ4 || e.getSource()==vista.btnJ5 || e.getSource()==vista.btnJ5 ||
           e.getSource()==vista.btnJ6 || e.getSource()==vista.btnJ7){
           Dia="Jueves";
            if(e.getSource()==vista.btnJ1){Hora="8:00-8:45";} else
            if(e.getSource()==vista.btnJ2){Hora="8:45-9:30";} else
            if(e.getSource()==vista.btnJ3){Hora="9:30-10:15";} else
            if(e.getSource()==vista.btnJ4){Hora="10:30-11:15";} else
            if(e.getSource()==vista.btnJ5){Hora="11:15-12:00";} else
            if(e.getSource()==vista.btnJ6){Hora="12:00-12:45";} else
            if(e.getSource()==vista.btnJ7){Hora="12:45-13:30";} 
            System.out.println("Dia: "+Dia+" Hora: "+Hora);
        }
        if(e.getSource()==vista.btnV1 || e.getSource()==vista.btnV2 || e.getSource()==vista.btnV3 ||
           e.getSource()==vista.btnV4 || e.getSource()==vista.btnV5 || e.getSource()==vista.btnV5 ||
           e.getSource()==vista.btnV6 || e.getSource()==vista.btnV7){
           Dia="Viernes";
            if(e.getSource()==vista.btnV1){Hora="8:00-8:45";} else
            if(e.getSource()==vista.btnV2){Hora="8:45-9:30";} else
            if(e.getSource()==vista.btnV3){Hora="9:30-10:15";} else
            if(e.getSource()==vista.btnV4){Hora="10:30-11:15";} else
            if(e.getSource()==vista.btnV5){Hora="11:15-12:00";} else
            if(e.getSource()==vista.btnV6){Hora="12:00-12:45";} else
            if(e.getSource()==vista.btnV7){Hora="12:45-13:30";} 
            System.out.println("Dia: "+Dia+" Hora: "+Hora);
        }
//////////////////////
/*BOTONES COLORES*/
//////////////////////
        if(e.getSource()==vista.btnColor1){//COLOR BOTON SELECCION
            procesos.seleccionaColor();
            procesos.aplicarColor(vista.btnColor1);
            System.out.println("");
        }

        if(e.getSource()==vista.btnColor2){
            procesos.aplicarColor2(vista.btnColor2, color, colorString);
        }
//////////////////////
/*COMBO BOX*/
//////////////////////   
        if (e.getSource() == vista.cbxGrado) {
            Object seleccionObjeto = vista.cbxGrado.getSelectedItem();
            if (seleccionObjeto != null) {
                grado = seleccionObjeto.toString();
                System.out.println("Seleccionaste: " + grado);
            } else {
                System.out.println("No se ha seleccionado nada.");
            }
            cargarNombresAreas();
            
            codigoDocenteGrado=daoHora.obtenerCodigoDocenteGrado(textoAño, grado, area);
            cargarHorarioAbtn();
            mostrarInfoDocentesEnTabla(grado, textoAño);
        }
        //////
        if(e.getSource() == vista.cbxArea){
            Object seleccionObjeto = vista.cbxArea.getSelectedItem();
            if (seleccionObjeto != null) {
                area = seleccionObjeto.toString();
                System.out.println("Seleccionaste: " + area);
            } else {
                System.out.println("No se ha seleccionado nada.");
            }
            codigoDocenteGrado=daoHora.obtenerCodigoDocenteGrado(textoAño, grado, area);
        }
//////////////////////
/*TEXT FIELD*/
////////////////////// 
        if(e.getSource()==vista.txtAño){ //mo tiene funcionalidad
         textoAño= vista.txtAño.getText();
            System.out.println("Año Ingresado " + textoAño);
            mostrarInfoDocentesEnTabla(grado, textoAño);
            cargarHorarioAbtn();
        }

    }//OVERRIDE
    
    private void cargarNombresGrados(){
        ArrayList<String> nombresGrados=daoHora.obtenerNombreGrados();
        vista.cbxGrado.removeAllItems(); //limpiar items actuales
        for (String nombreGrado : nombresGrados){
            vista.cbxGrado.addItem(nombreGrado);
        }
        
    }
    
    private void cargarNombresAreas(){
        ArrayList<String> nombresAreasI=daoHora.obtenerNombreAreasI();
        ArrayList<String> nombresAreasP=daoHora.obtenerNombreAreasP();
        ArrayList<String> nombresAreasS=daoHora.obtenerNombreAreasS();
        
        vista.cbxArea.removeAllItems(); //limpiar items actuales
        if(null != grado) //filtrar nivel para mostrar cursos correspondientes
        switch (grado) {
            case "3 añitos", "4 añitos", "5 añitos" -> {
                for(String nomArea : nombresAreasI){
                    vista.cbxArea.addItem(nomArea);
                }
            }
            case "1er Grado", "2do Grado", "3er Grado", "4to Grado", "5to Grado", "6to Grado" -> {
                for(String nomArea : nombresAreasP){
                    vista.cbxArea.addItem(nomArea);
                }
            }
            case "1er Año", "2do Año", "3er Año", "4to Año", "5to Año" -> {
                for(String nomArea : nombresAreasS){
                    vista.cbxArea.addItem(nomArea);
                }
            }
            default -> {
            }
        }
    }
    
    public void cargarHorarioAbtn(){
        ArrayList<String> traerHora=daoHora.obtnerHorarioHora(grado, textoAño);
        ArrayList<String> traerDia=daoHora.obtnerHorarioDia(grado, textoAño);
        ArrayList<String> traerColor=daoHora.obtnerHorarioColor(grado, textoAño);
        ArrayList<String> traerArea=daoHora.obtnerHorarioArea(grado, textoAño);
        
        ArrayList<Horario> horariosInfo = new ArrayList<>();
        
         // Llenar la lista con los datos obtenidos
        for (int i = 0; i < traerHora.size(); i++) {
            Horario horarioInfo = new Horario(Dia, Hora, Hora, area);
            horarioInfo.setHora(traerHora.get(i));
            horarioInfo.setDia(traerDia.get(i));
            horarioInfo.setColor(traerColor.get(i));
            horarioInfo.setArea(traerArea.get(i));

            horariosInfo.add(horarioInfo);
        }

        // Ahora puedes trabajar con la lista de objetos HorarioInfo antes de asignar los valores a los botones
        for (Horario info : horariosInfo) {
            System.out.println("horario: " + info.getHora());
            System.out.println("dias: " + info.getDia());
            System.out.println("color: " + info.getColor());
            System.out.println("area: " + info.getArea());
            colorString=info.getColor();
            String[] partes=colorString.split(", ");
            int red=Integer.parseInt(partes[0]);
            int green = Integer.parseInt(partes[1]);
            int blue = Integer.parseInt(partes[2]);
            
            System.out.println("color red: "+red);
            System.out.println("color green: "+green);
            System.out.println("color blue: "+blue);
            //vista.btnejem.setBackground(new Color(153, 51, 0));
            //vista.btnejem.setText("Hola");
            if(info.getHora().equals("8:00-8:45")){
                System.out.println("entre en el if1");
                if(info.getDia().equals("Lunes")){
                    System.out.println("entre en el if2");
                    vista.btnL1.setBackground(new Color(red,green,blue));
                    vista.btnL1.setText(info.getArea());
                }else if(info.getDia().equals("Martes")){
                    vista.btnM1.setBackground(new Color(red,green,blue));
                    vista.btnM1.setText(info.getArea());
                }else if(info.getDia().equals("Miercoles")){
                    vista.btnMI1.setBackground(new Color(red,green,blue));
                    vista.btnMI1.setText(info.getArea());
                }else if(info.getDia().equals("Jueves")){
                    vista.btnJ1.setBackground(new Color(red,green,blue));
                    vista.btnJ1.setText(info.getArea());
                }else if(info.getDia().equals("Viernes")){
                    vista.btnV1.setBackground(new Color(red,green,blue));
                    vista.btnV1.setText(info.getArea());
                }
            }
            if(info.getHora().equals("8:45-9:30")){
                if(info.getDia().equals("Lunes")){
                    vista.btnL2.setBackground(new Color(red,green,blue));
                    vista.btnL2.setText(info.getArea());
                }else if(info.getDia().equals("Martes")){
                    vista.btnM2.setBackground(new Color(red,green,blue));
                    vista.btnM2.setText(info.getArea());
                }else if(info.getDia().equals("Miercoles")){
                    vista.btnMI2.setBackground(new Color(red,green,blue));
                    vista.btnMI2.setText(info.getArea());
                }else if(info.getDia().equals("Jueves")){
                    vista.btnJ2.setBackground(new Color(red,green,blue));
                    vista.btnJ2.setText(info.getArea());
                }else if(info.getDia().equals("Viernes")){
                    vista.btnV2.setBackground(new Color(red,green,blue));
                    vista.btnV2.setText(info.getArea());
                }
            }
            if(info.getHora().equals("9:30-10:15")){
                if(info.getDia().equals("Lunes")){
                    vista.btnL3.setBackground(new Color(red,green,blue));
                    vista.btnL3.setText(info.getArea());
                }else if(info.getDia().equals("Martes")){
                    vista.btnM3.setBackground(new Color(red,green,blue));
                    vista.btnM3.setText(info.getArea());
                }else if(info.getDia().equals("Miercoles")){
                    vista.btnMI3.setBackground(new Color(red,green,blue));
                    vista.btnMI3.setText(info.getArea());
                }else if(info.getDia().equals("Jueves")){
                    vista.btnJ3.setBackground(new Color(red,green,blue));
                    vista.btnJ3.setText(info.getArea());
                }else if(info.getDia().equals("Viernes")){
                    vista.btnV3.setBackground(new Color(red,green,blue));
                    vista.btnV3.setText(info.getArea());
                }
            }
            if(info.getHora().equals("10:30-11:15")){
                if(info.getDia().equals("Lunes")){
                    vista.btnL4.setBackground(new Color(red,green,blue));
                    vista.btnL4.setText(info.getArea());
                }else if(info.getDia().equals("Martes")){
                    vista.btnM4.setBackground(new Color(red,green,blue));
                    vista.btnM4.setText(info.getArea());
                }else if(info.getDia().equals("Miercoles")){
                    vista.btnMI4.setBackground(new Color(red,green,blue));
                    vista.btnMI4.setText(info.getArea());
                }else if(info.getDia().equals("Jueves")){
                    vista.btnJ4.setBackground(new Color(red,green,blue));
                    vista.btnJ4.setText(info.getArea());
                }else if(info.getDia().equals("Viernes")){
                    vista.btnV4.setBackground(new Color(red,green,blue));
                    vista.btnV4.setText(info.getArea());
                }
            }
            if(info.getHora().equals("11:15-12:00")){
                if(info.getDia().equals("Lunes")){
                    vista.btnL5.setBackground(new Color(red,green,blue));
                    vista.btnL5.setText(info.getArea());
                }else if(info.getDia().equals("Martes")){
                    vista.btnM5.setBackground(new Color(red,green,blue));
                    vista.btnM5.setText(info.getArea());
                }else if(info.getDia().equals("Miercoles")){
                    vista.btnMI5.setBackground(new Color(red,green,blue));
                    vista.btnMI5.setText(info.getArea());
                }else if(info.getDia().equals("Jueves")){
                    vista.btnJ5.setBackground(new Color(red,green,blue));
                    vista.btnJ5.setText(info.getArea());
                }else if(info.getDia().equals("Viernes")){
                    vista.btnV5.setBackground(new Color(red,green,blue));
                    vista.btnV5.setText(info.getArea());
                }
            }
            if(info.getHora().equals("12:00-12:45")){
                if(info.getDia().equals("Lunes")){
                    vista.btnL6.setBackground(new Color(red,green,blue));
                    vista.btnL6.setText(info.getArea());
                }else if(info.getDia().equals("Martes")){
                    vista.btnM6.setBackground(new Color(red,green,blue));
                    vista.btnM6.setText(info.getArea());
                }else if(info.getDia().equals("Miercoles")){
                    vista.btnMI6.setBackground(new Color(red,green,blue));
                    vista.btnMI6.setText(info.getArea());
                }else if(info.getDia().equals("Jueves")){
                    vista.btnJ6.setBackground(new Color(red,green,blue));
                    vista.btnJ6.setText(info.getArea());
                }else if(info.getDia().equals("Viernes")){
                    vista.btnV6.setBackground(new Color(red,green,blue));
                    vista.btnV6.setText(info.getArea());
                }
            }
            if(info.getHora().equals("12:45-13:30")){
                if(info.getDia().equals("Lunes")){
                    vista.btnL7.setBackground(new Color(red,green,blue));
                    vista.btnL7.setText(info.getArea());
                }else if(info.getDia().equals("Martes")){
                    vista.btnM7.setBackground(new Color(red,green,blue));
                    vista.btnM7.setText(info.getArea());
                }else if(info.getDia().equals("Miercoles")){
                    vista.btnMI7.setBackground(new Color(red,green,blue));
                    vista.btnMI7.setText(info.getArea());
                }else if(info.getDia().equals("Jueves")){
                    vista.btnJ7.setBackground(new Color(red,green,blue));
                    vista.btnJ7.setText(info.getArea());
                }else if(info.getDia().equals("Viernes")){
                    vista.btnV7.setBackground(new Color(red,green,blue));
                    vista.btnV7.setText(info.getArea());
                }
            }
            // Aquí puedes aplicar tus condicionales y ajustar los botones según sea necesario
            // ...
        }
        System.out.println("horarios: ");
        traerHora.forEach(System.out::println);
        System.out.println("dias: ");
        traerDia.forEach(System.out::println);
        System.out.println("colores: ");
        traerColor.forEach(System.out::println);
        System.out.println("area: ");
        traerArea.forEach(System.out::println);
    }
    
    public void mostrarInfoDocentesEnTabla(String grado, String año) {
        // Obtén la referencia a la tabla desde tu vista
        JTable tblAreas = vista.tblAreas;
        // Llama al método del DAO para obtener la información de los docentes
        ArrayList<ArrayList<Object>> infoDocentes = daoHora.obtenerInfoDocentes(año, grado);
        System.out.println("Número de filas obtenidas del DAO: " + infoDocentes.size());
        // Crea un modelo de tabla
        DefaultTableModel modeloTabla = new DefaultTableModel();
        // Agrega las columnas al modelo de tabla
        modeloTabla.addColumn("Grado");
        modeloTabla.addColumn("Año");
        modeloTabla.addColumn("Area");
        modeloTabla.addColumn("Nombres");
        modeloTabla.addColumn("Apellido_P");
        modeloTabla.addColumn("Apellido_M");
        // Agrega las filas al modelo de tabla
        // Agrega las filas al modelo de tabla
        for (ArrayList<Object> fila : infoDocentes) {
            System.out.println("Fila del DAO: " + fila.toString());
            modeloTabla.addRow(fila.toArray());
        }
/*        for (ArrayList<Object> fila : infoDocentes) {
            if (fila.get(0).equals(grado) && fila.get(1).equals(año)) {
                modeloTabla.addRow(fila.toArray());
            }
        }*/
        // Configura la tabla con el modelo
        tblAreas.setModel(modeloTabla);
    }
  
    public String getColorString(Color colorcito){
        return "[ " + "r=" + color.getRed() + ", g=" + color.getGreen() + ", b=" +color.getBlue() + " ]";
    }
    
    public String getColorStringAlmacenar(Color colorcito){
        return color.getRed()+", "+color.getGreen()+", "+color.getBlue();
    }
    
     public void setBordeNegro(JButton boton) {
        // Crea un borde negro y lo establece en el botón
        Border bordeNegro = BorderFactory.createLineBorder(Color.BLACK, 2);
        boton.setBorder(bordeNegro);
    }
     
    private void setBordeBlancoEnTodosLosBotones() {//buscar optimizar estas lineas
        vista.btnL1.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        vista.btnL2.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        vista.btnL3.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        vista.btnL4.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        vista.btnL5.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        vista.btnL6.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        vista.btnL7.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        
        vista.btnM1.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        vista.btnM2.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        vista.btnM3.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        vista.btnM4.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        vista.btnM5.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        vista.btnM6.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        vista.btnM7.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        
        vista.btnMI1.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        vista.btnMI2.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        vista.btnMI3.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        vista.btnMI4.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        vista.btnMI5.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        vista.btnMI6.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        vista.btnMI7.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        
        vista.btnJ1.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        vista.btnJ2.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        vista.btnJ3.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        vista.btnJ4.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        vista.btnJ5.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        vista.btnJ6.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        vista.btnJ7.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        
        vista.btnV1.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        vista.btnV2.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        vista.btnV3.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        vista.btnV4.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        vista.btnV5.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        vista.btnV6.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        vista.btnV7.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
    }
    
    private void imprimirInfoHorario(JButton boton) {
        String nombreBoton = boton.getText(); // Obtén el texto del botón
        System.out.println("Nombre boton seleccionado: "+nombreBoton); 
    }
   
}


/*
comentarios


            for (Horario botonInfo : botonesSelecionados) {
                //String dia = botonInfo.getDia();
                //String hora = botonInfo.getHora();
                String color = botonInfo.getColor();
                //String area = botonInfo.getArea();
                // Verifica si ya existe un registro con la misma combinación de día y hora en la BD
                if (!daoHora.existeHorario(codigoHorario, Dia, Hora, codigoDocenteArea,color, area)) {
                    // Si no existe, realiza la inserción en la base de datos
                    daoHora.insertarHorario(codigoHorario, Dia, Hora, codigoDocenteArea, colorAlmacenar, area);

                    // Deshabilita el botón correspondiente según el día y la hora
                    //deshabilitarBotonSegunDiaHora(dia, hora);
                } else {
                    // Si ya existe, muestra un mensaje o realiza alguna acción
                    System.out.println("Ya existe un registro para el día " + Dia + " y la hora " + Hora);
                }
                //daoHora.insertarHorario(codigoHorario, dia, hora, codigoDocenteArea, color);

            }


//daoHora.insertarHorario(codigoHorario, Dia, Hora, codigoDocenteArea, colorString);




            //a partir de aqui no va... pero lo dejare por mientras no lo borren 
           ArrayList<Integer> codHora=daoHora.leerCodHorario();
            //imprimir en consola los codigos obtenidos
            System.out.println("Códigos de horario para el día Lunes:");
            for(int codHorario : daoHora.leerCodHorario()){
                System.out.print(codHorario + " ");
                System.out.println("pipipi");
            }
            System.out.println(); //salto de linea
            System.out.println("final");     





    public void mostrarInfoHorario(String grado, String año){ //no salio este metodo probare otro :')
        //llamamos al metodo dao para obtener toda la info necesaria para el horario
        ArrayList<ArrayList<Object>> infoHorario=daoHora.obtenerHorarioPorGradoYAño(grado, año);
        for(ArrayList<Object> fila : infoHorario){
            // Verifica las condiciones para imprimir la fila
            if (fila.get(0).equals(grado) && fila.get(1).equals(año)) {
                // Imprime cada elemento de la fila en la consola
                System.out.println("Grado: " + fila.get(0));
                System.out.println("Año: " + fila.get(1));
                System.out.println("Area: " + fila.get(2));
                System.out.println("Nombres: " + fila.get(3));
                System.out.println("Apellido_P: " + fila.get(4));
                System.out.println("Apellido_M: " + fila.get(5));
                System.out.println("-----------------------------");
            }
        }
    }
*/