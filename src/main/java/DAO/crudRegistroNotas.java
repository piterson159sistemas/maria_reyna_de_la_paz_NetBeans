
package DAO;

import java.util.ArrayList;

public class crudRegistroNotas {

    public ArrayList<String> listarNiveles(){
        return null;
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
