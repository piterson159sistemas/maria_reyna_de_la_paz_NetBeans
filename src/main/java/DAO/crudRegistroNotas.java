
package DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class crudRegistroNotas {

    Conexion con= new Conexion();
    
    public ArrayList<Integer> listarAnios(String codUsuario){
        ArrayList<Integer> anios = new ArrayList<>();
        String sqlST="select distinct Año from Docente_grado" 
                +" where Codigo_Docente_Area IN" 
                +" (select Codigo_Docente_Area from Docente_Area "
                + " where Codigo_Usuario like '"+codUsuario+"')";

        try (Connection cn = con.conectar()) {
            con.st = cn.createStatement();
            con.rs = con.st.executeQuery(sqlST);
            while(con.rs.next()){
                anios.add(con.rs.getInt(1));
            }
            cn.close();
        } catch (SQLException e) { 
           Procesos.ProcesosAlumnos.msjDialog("ERROR al obtener los años "+e);
        }
        return anios;
    }
    
    public ArrayList<String> listarNiveles(String codUsuario,int anio){
        ArrayList<String> niveles = new ArrayList<>();
        String sqlST="select distinct g.Nivel from" +
            " Docente_grado dg inner join grado g on" +
            " (dg.Codigo_Grado=g.Codigo_Grado)" +
            " where Codigo_Docente_Area IN" +
            " (select Codigo_Docente_Area from Docente_Area where"+
            " Codigo_Usuario like '"+codUsuario+"') and dg.Año="+anio+";";

        try (Connection cn = con.conectar()) {
            con.st = cn.createStatement();
            con.rs = con.st.executeQuery(sqlST);
            while(con.rs.next()){
                niveles.add(con.rs.getString(1));
            }
            cn.close();
        } catch (SQLException e) { 
           Procesos.ProcesosAlumnos.msjDialog("ERROR al obtener los niveles "+e);
        }
        return niveles;
    }
    
    public ArrayList<String> listarGrados(String codUsuario,int anio,String nivel){
        ArrayList<String> grados = new ArrayList<>();
        String sqlST="select distinct g.grado from" +
            " Docente_grado dg inner join grado g on" +
            " (dg.Codigo_Grado=g.Codigo_Grado)" +
            " where Codigo_Docente_Area IN" +
            " (select Codigo_Docente_Area from Docente_Area where "+
            " Codigo_Usuario like '"+codUsuario+"')" +
            " and g.Nivel='"+nivel+"' and dg.Año="+anio+";";

        try (Connection cn = con.conectar()) {
            con.st = cn.createStatement();
            con.rs = con.st.executeQuery(sqlST);
            while(con.rs.next()){
                grados.add(con.rs.getString(1));
            }
            cn.close();
        } catch (SQLException e) { 
            Procesos.ProcesosAlumnos.msjDialog("ERROR al obtener los grados "+e);
        }
        return grados;
    }
    
    public ArrayList<String> listarAreas(String codUsuario,int anio,int codGrado){
        ArrayList<String> areas = new ArrayList<>();
        String sqlST="select a.Area from" +
            " Docente_grado dg inner join Docente_area da"+
            " on (da.Codigo_Docente_Area = dg.Codigo_Docente_Area)" +
            " inner join area a on (a.Codigo_Area = da.Codigo_Area)" +
            " where dg.Codigo_Docente_Area IN" +
            " (select Codigo_Docente_Area from Docente_Area"+
            " where Codigo_Usuario like '"+codUsuario+"')" +
            "and dg.Codigo_Grado="+codGrado+" and dg.Año="+anio+";";

        try (Connection cn = con.conectar()) {
            con.st = cn.createStatement();
            con.rs = con.st.executeQuery(sqlST);
            while(con.rs.next()){
                areas.add(con.rs.getString(1));
            }
            cn.close();
        } catch (SQLException e) { 
           Procesos.ProcesosAlumnos.msjDialog("ERROR al obtener las areas "+e);
        }
        return areas;
    }

    public ArrayList<String> listarComp(int codArea,String nivel){
        ArrayList<String> competencias = new ArrayList<>();
        String dato;
        String sqlST="select ac.Codigo_Competencia, c.competencia from" +
                " areacompetencia ac inner join competencias c" +
                " on (ac.Codigo_Competencia = c.Codigo_Competencia)" +
                " where ac.Codigo_Area="+codArea+" and ac.Nivel like '"+nivel+"';";
                            //ac.Nivel puede ser =   'I':Inicial 
                                                 //  'P':Primaria
                                                 //  'S':Secundaria
        
        try (Connection cn = con.conectar()) {
            con.st = cn.createStatement();
            con.rs = con.st.executeQuery(sqlST);
            while(con.rs.next()){
                dato= String.valueOf(con.rs.getInt(1))+":"+con.rs.getString(2); 
                competencias.add(dato);
            }
            cn.close();
        } catch (SQLException e) { 
            Procesos.ProcesosAlumnos.msjDialog("ERROR al obtener las competencias "+e);
        }
        return competencias;
    }
    
    public ArrayList<String> listarPeriodos(){
        ArrayList<String> periodos = new ArrayList<>();
        String sqlST="select Periodo from periodo;";

        try(Connection cn = con.conectar()){
            con.st = cn.createStatement();
            con.rs = con.st.executeQuery(sqlST);
            while(con.rs.next()){
                periodos.add(con.rs.getString(1));
            }
            cn.close();
        } catch (SQLException e) {
            Procesos.ProcesosAlumnos.msjDialog("ERROR al obtener los periodos "+e);
        }
       return periodos;        
    }
    
    public int getCodPeriodo(String periodo){
        int codPeriodo=0;
        String sqlST="select Codigo_Periodo from periodo where Periodo like '"+periodo+"' ;";

        try(Connection cn = con.conectar()){
            con.st = cn.createStatement();
            con.rs = con.st.executeQuery(sqlST);
            if(con.rs.next()){
                codPeriodo=con.rs.getInt(1);
            }
            cn.close();
        } catch (SQLException e) {
            Procesos.ProcesosAlumnos.msjDialog("ERROR al obtener codigo Periodo "+e);
        }
       return codPeriodo;        
    }
    
    public int getCodDocenteGrado(int codDocenteArea, int codGrado, int anio){
        int codDocenteGrado=0;
        String sqlST="select Codigo_docente_grado  from docente_grado"
                + " where Codigo_Docente_Area="+codDocenteArea
                + " and Codigo_Grado="+codGrado
                + " and Año="+anio+";";

        try(Connection cn = con.conectar()){
            con.st = cn.createStatement();
            con.rs = con.st.executeQuery(sqlST);
            if(con.rs.next()){
                codDocenteGrado=con.rs.getInt(1);
            }
            cn.close();
        } catch (SQLException e) {
            Procesos.ProcesosAlumnos.msjDialog("ERROR al obtener codigo Docente_Grado "+e);
        }
       return codDocenteGrado;        
    }
    
    

    public ArrayList<String> listarAlumnos(int codGrado,int anio){
        ArrayList<String> alumnos = new ArrayList<>();
        String sqlST="select CONCAT(a.Nombres,' ', a.Apellido_P,' ', a.Apellido_M)"+
                " as nombre from alumno a inner join grado_alumno ga" +
                " on (ga.CodigoA = a.N_DocumentoA) where ga.Codigo_EstadoGA=2" +
                " and Codigo_Grado = "+codGrado+" and ga.Año="+anio+";";

        try (Connection cn = con.conectar()) {
            con.st = cn.createStatement();
            con.rs = con.st.executeQuery(sqlST);
            while(con.rs.next()){
                alumnos.add(con.rs.getString(1));
            }
        cn.close();
        } catch (SQLException e) { 
           Procesos.ProcesosAlumnos.msjDialog("ERROR al obtener los alumnos "+e);
       }
        return alumnos;
    }
    
    public ArrayList<Integer> listarCodAlumnos(int codGrado,int anio){
        ArrayList<Integer> codAlumnos = new ArrayList<>();
        String sqlST="select CodigoA from grado_alumno" +
                " where Codigo_EstadoGA=2" +
                " and Codigo_Grado=" +codGrado+
                " and Año="+anio+";";

        try (Connection cn = con.conectar()) {
            con.st = cn.createStatement();
            con.rs = con.st.executeQuery(sqlST);
            while(con.rs.next()){
                codAlumnos.add(con.rs.getInt(1));
            }
        cn.close();
        } catch (SQLException e) { 
           Procesos.ProcesosAlumnos.msjDialog("ERROR al obtener los Codigos de alumnos "+e);
       }
        return codAlumnos;
    }
    
    public ArrayList<String> listarDataAlumnos(int codGrado,int anio){
        ArrayList<String> dataAlumno = new ArrayList<>();
        String dato;
       String sqlST="select a.N_DocumentoA ,CONCAT(a.Nombres,' ', a.Apellido_P,"
                + " ' ', a.Apellido_M) as nombre from" 
                + " alumno a inner join grado_alumno ga"
                + " on (ga.CodigoA = a.N_DocumentoA)"
                + " where ga.Codigo_EstadoGA=2" //codgioEstado=2 : En curso
                + " and Codigo_Grado="+codGrado
                + " and ga.año="+anio+";";

        try (Connection cn = con.conectar()) {
            con.st = cn.createStatement();
            con.rs = con.st.executeQuery(sqlST);
            while(con.rs.next()){
                dato= String.valueOf(con.rs.getInt(1))+","+con.rs.getString(2);
                dataAlumno.add(dato);
            }
        cn.close();
        } catch (SQLException e) { 
           Procesos.ProcesosAlumnos.msjDialog("ERROR al obtener los Codigos de alumnos "+e);
       }
        return dataAlumno;
    }
    
    
    
    
    public ArrayList<Integer> buscarNotas(int codAlumno,int codPeriodo,
           int codDocenteGrado, int codComp){
        ArrayList<Integer> notas = new ArrayList<>();
        String sqlST="select Nota1,Nota2,Nota3,Nota4,Nota5,Nota6,Nota7,Nota8"
                + " from calificaciones where Codigo_A="+codAlumno
                + " and Codigo_Periodo="+codPeriodo
                + " and Codigo_docente_grado="+codDocenteGrado
                + " and Codigo_Competencia="+codComp+";";

        try (Connection cn = con.conectar()) {
            con.st = cn.createStatement();
            con.rs = con.st.executeQuery(sqlST);
            while(con.rs.next()){
                for (int i = 0; i < 8; i++) {
                    notas.add(con.rs.getInt(i+1));
                }
            }
            cn.close();
        } catch (SQLException e) { 
           Procesos.ProcesosAlumnos.msjDialog("ERROR al obtener los alumnos "+e);
       }
        return notas;
    }

    
    
    
    
    
    
    
    /*
    
    ************************************************************************
            CONSULTAS A IMPLEMENTAR EN EL CRUD Y LA LOGICA DEL PROGRAMA 
    ************************************************************************
    
-- selecionnar todos los años en los que el profesor tiene asignados un grado y curso
select distinct Año from Docente_grado  
where Codigo_Docente_Area IN
(select Codigo_Docente_Area from Docente_Area where Codigo_Usuario='P0101232');


-- seleccionar niveles en los que enseña el profesor
select distinct g.Nivel from 
Docente_grado dg inner join grado g on
(dg.Codigo_Grado=g.Codigo_Grado)
where Codigo_Docente_Area IN
(select Codigo_Docente_Area from Docente_Area where Codigo_Usuario='P0101232') and dg.Año=2023;

-- seleccionar grados del nivel en los que enseña el profesor
select distinct g.grado from 
Docente_grado dg inner join grado g on
(dg.Codigo_Grado=g.Codigo_Grado)
where Codigo_Docente_Area IN
(select Codigo_Docente_Area from Docente_Area where Codigo_Usuario='P0101232') 
and g.Nivel='Primaria' and dg.Año=2024;

-- seleccionar las areas que el docente enseña en un determinado grado y año 
select a.Area from
Docente_grado dg 
inner join Docente_area da on (da.Codigo_Docente_Area = dg.Codigo_Docente_Area)
inner join area a on (a.Codigo_Area = da.Codigo_Area)
where dg.Codigo_Docente_Area IN
(select Codigo_Docente_Area from Docente_Area where Codigo_Usuario='P0101232') 
and dg.Codigo_Grado='...' and dg.Año=2023;

-- seleccionar los NOMBRES DE COMPETENCIAS de la area seleccionada segun el nivel
select c.competencia from 
areacompetencia ac inner join competencias c 
on (ac.Codigo_Competencia = c.Codigo_Competencia)
where ac.Codigo_Area=1 and ac.Nivel='P';

-- seleccionar la CANTIDAD DE COMPETENCIAS de la area seleccionada segun el nivel
select count(*) from 
areacompetencia ac inner join competencias c 
on (ac.Codigo_Competencia = c.Codigo_Competencia)
where ac.Codigo_Area=1 and ac.Nivel='P';


-- mostrar alumnos de un determinado grado
select CONCAT(a.Nombres, ' ', a.Apellido_P, ' ', a.Apellido_M) as nombre from
alumno a inner join grado_alumno ga 
on (ga.CodigoA = a.N_DocumentoA)
 where ga.Codigo_EstadoGA=2  -- ( en curso, si es el año actual)
-- where ga.Codigo_EstadoGA=1 or ga.Codigo_EstadoGA=3 -- (aprobado y desaprobados, si es un año pasado)
and Codigo_Grado=2 
and ga.año=2023;
    
-- mostrar CODIGO de los alumnos de un determinado grado
select CodigoA from grado_alumno
 where Codigo_EstadoGA=2  -- ( en curso, si es el año actual)
-- where Codigo_EstadoGA=1 or Codigo_EstadoGA=3 -- (aprobado y desaprobados, si es un año pasado)
and Codigo_Grado=2 
and Año=2023;    
    
-- mostrar CODIGO y NOMBRE COMPLETO de los alumnos de un determinado grado
select a.N_DocumentoA ,CONCAT(a.Nombres, ' ', a.Apellido_P, ' ', a.Apellido_M) as nombre from
alumno a inner join grado_alumno ga 
on (ga.CodigoA = a.N_DocumentoA)
 where ga.Codigo_EstadoGA=2  -- ( en curso, si es el año actual)
-- where ga.Codigo_EstadoGA=1 or ga.Codigo_EstadoGA=3 -- (aprobado y desaprobados, si es un año pasado)
and Codigo_Grado=2 
and ga.año=2023;     

    

-- ******************************
-- Manejo de Notas
-- ******************************

-- ************ PARA LECTURA *********
-- Mostrar las 8 notas de un alumno
-- , en un determinado bimestre
-- ,con un determinado docente y area,  
-- pertenenciente a un determinado nivel y grado
-- cursando en un determinado año
-- calificado en una determinada competencia

select Nota1,Nota2,Nota3,Nota4,Nota5,Nota6,Nota7,Nota8 from calificaciones
where Codigo_A=22 and Codigo_Periodo=3 and Codigo_docente_grado=2 and Codigo_Competencia=1;
-- Aclaración: 
--   --> si el resltado del select NO muestra un registro es porque el alumno AUN NO ESTÁ REGISTRADO
--   --> si el resltado del select SI muestra un registro es porque el alumno YA ESTÁ REGISTRADO 
--   => El sistema marcará al alumno segun si está o no registrado, para saber si hacer una inserción o actualizacion  

-- ************ PARA REGISTRO *********
-- si es un alumno YA REGISTRADO en la tabla:calificaciones (UPDATE)
select * from calificaciones;
UPDATE calificaciones set Nota1=20 ,Nota2=20 ,Nota3=20 ,Nota4=20 ,Nota5=20 ,Nota6=20 ,Nota7=20 ,Nota8=20 ,promedio=20
WHERE Codigo_A=22 and Codigo_Periodo=3 and Codigo_docente_grado=2 and Codigo_Competencia=1;

-- Si es un alumno AUN NO REGISTRADO en la tabla:calificaciones (INSERT INTO)
INSERT INTO calificaciones(Nota1,Nota2,Nota3,Nota4,Nota5,Nota6,Nota7,Nota8,promedio,
						   Codigo_A,Codigo_Periodo,Codigo_Docente_Grado,Codigo_Competencia)
values 
(20,20,20,20,20,20,20,20,20,
1,2,3,4);
    
    */
    
}
