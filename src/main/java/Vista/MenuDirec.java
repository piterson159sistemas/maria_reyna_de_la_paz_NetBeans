
package Vista;

import static Vista.MenuDocente.jDesktopPane_menuD;
import java.awt.Dimension;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MenuDirec extends javax.swing.JFrame {

     private void Cerrar(){//METODO PARA QUE PREGUNTE AL INTENTAR CERRAR LA APLICACION
         String botones[]= {"Cerrar","Cancelar"};
         int eleccion = JOptionPane.showOptionDialog(this,"¿Desea cerrar la aplicacion?","Titulo",0,0,null,botones,this);
         if(eleccion==JOptionPane.YES_OPTION){
             System.exit(0);
         }else if(eleccion==JOptionPane.NO_OPTION){
             System.out.println("Se cancelo el cierre");
         }
         
     }
    public MenuDirec() {
        initComponents();
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jmAC = new javax.swing.JMenu();
        jMIDocente = new javax.swing.JMenuItem();
        jMIATutor = new javax.swing.JMenuItem();
        jMCCD = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMReg = new javax.swing.JMenu();
        jMINotas = new javax.swing.JMenuItem();
        jMIAsistencia = new javax.swing.JMenuItem();
        jmiListaAlumnos = new javax.swing.JMenuItem();
        jMAsig = new javax.swing.JMenu();
        jMIArea = new javax.swing.JMenuItem();
        jmiTutoria = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jmAC.setText("Administrar cuentas");
        jmAC.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jmAC.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jmAC.setPreferredSize(new java.awt.Dimension(200, 50));

        jMIDocente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jMIDocente.setText("Docente");
        jMIDocente.setPreferredSize(new java.awt.Dimension(180, 30));
        jMIDocente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIDocenteActionPerformed(evt);
            }
        });
        jmAC.add(jMIDocente);

        jMIATutor.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jMIATutor.setText("Tutor");
        jMIATutor.setPreferredSize(new java.awt.Dimension(180, 30));
        jMIATutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIATutorActionPerformed(evt);
            }
        });
        jmAC.add(jMIATutor);

        jMenuBar1.add(jmAC);

        jMCCD.setText("Docente");
        jMCCD.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jMCCD.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jMCCD.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jMCCD.setPreferredSize(new java.awt.Dimension(130, 50));

        jMenuItem1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jMenuItem1.setText("Crear Cuenta");
        jMenuItem1.setPreferredSize(new java.awt.Dimension(140, 30));
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMCCD.add(jMenuItem1);

        jMenuBar1.add(jMCCD);

        jMReg.setText("Estudiantes");
        jMReg.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jMReg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jMReg.setPreferredSize(new java.awt.Dimension(150, 50));

        jMINotas.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jMINotas.setText("Registro de notas");
        jMINotas.setPreferredSize(new java.awt.Dimension(180, 30));
        jMINotas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMINotasActionPerformed(evt);
            }
        });
        jMReg.add(jMINotas);

        jMIAsistencia.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jMIAsistencia.setText("Registro de Asistencia");
        jMIAsistencia.setPreferredSize(new java.awt.Dimension(180, 30));
        jMIAsistencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIAsistenciaActionPerformed(evt);
            }
        });
        jMReg.add(jMIAsistencia);

        jmiListaAlumnos.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jmiListaAlumnos.setText("Lista ");
        jmiListaAlumnos.setPreferredSize(new java.awt.Dimension(180, 30));
        jMReg.add(jmiListaAlumnos);

        jMenuBar1.add(jMReg);

        jMAsig.setText("Asignar");
        jMAsig.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jMAsig.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jMAsig.setPreferredSize(new java.awt.Dimension(150, 50));

        jMIArea.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jMIArea.setText("Area");
        jMIArea.setPreferredSize(new java.awt.Dimension(180, 30));
        jMIArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIAreaActionPerformed(evt);
            }
        });
        jMAsig.add(jMIArea);

        jmiTutoria.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jmiTutoria.setText("Tutor");
        jmiTutoria.setPreferredSize(new java.awt.Dimension(180, 30));
        jMAsig.add(jmiTutoria);

        jMenuBar1.add(jMAsig);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel, javax.swing.GroupLayout.DEFAULT_SIZE, 1254, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Panel, javax.swing.GroupLayout.PREFERRED_SIZE, 692, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
    Cerrar();
    }//GEN-LAST:event_formWindowClosing

    private void jMIAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIAreaActionPerformed
        asignar_area_directivo_1 AsignarArea= new asignar_area_directivo_1();
        Panel.add(AsignarArea);
        AsignarArea.setVisible(true);
    }//GEN-LAST:event_jMIAreaActionPerformed

    private void jMIAsistenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIAsistenciaActionPerformed
        //REGISTRO ASSITENCIA
        Registrar_Asistencia RegiAsis = new Registrar_Asistencia();
        Panel.add(RegiAsis);
        RegiAsis.setVisible(true);
    }//GEN-LAST:event_jMIAsistenciaActionPerformed

    private void jMINotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMINotasActionPerformed
        ///REGISTRO NOTAS
        Registrar_Notas RegiNota = new Registrar_Notas();
        Panel.add(RegiNota);
        RegiNota.setVisible(true);
    }//GEN-LAST:event_jMINotasActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        crear_cuenta_docentes_directivo_1 CcuentDocente = new crear_cuenta_docentes_directivo_1();
        Panel.add(CcuentDocente);
        CcuentDocente.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMIATutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIATutorActionPerformed
        gestionar_tutor_directivo_1 gesTutor = new gestionar_tutor_directivo_1();//iniciar interfaz
        Panel.add(gesTutor);//Poner dentro del espacio dado
        gesTutor.setVisible(true);//para que la interfaz sea visible
    }//GEN-LAST:event_jMIATutorActionPerformed

    private void jMIDocenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIDocenteActionPerformed
        gestionar_cuenta_docente_directivo_1 GesDoce = new gestionar_cuenta_docente_directivo_1();
        Panel.add(GesDoce);
        GesDoce.setVisible(true);
    }//GEN-LAST:event_jMIDocenteActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JDesktopPane Panel;
    public javax.swing.JMenu jMAsig;
    private javax.swing.JMenu jMCCD;
    private javax.swing.JMenuItem jMIATutor;
    private javax.swing.JMenuItem jMIArea;
    private javax.swing.JMenuItem jMIAsistencia;
    private javax.swing.JMenuItem jMIDocente;
    private javax.swing.JMenuItem jMINotas;
    private javax.swing.JMenu jMReg;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenu jmAC;
    public javax.swing.JMenuItem jmiListaAlumnos;
    public javax.swing.JMenuItem jmiTutoria;
    // End of variables declaration//GEN-END:variables
}
