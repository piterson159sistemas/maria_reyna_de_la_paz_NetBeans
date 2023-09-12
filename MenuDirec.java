
package interfaces;

import static interfaces.MenuDocente.jDesktopPane_menuD;
import java.awt.Dimension;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;

public class MenuDirec extends javax.swing.JFrame {
///para mostrar los internalFrames que abramos
    ///con JDesktopPane podemos mantener los jframes contenidos en un espacio dado
     public static JDesktopPane jDesktopPane_menu;//declaramos
    
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
        
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);//PARA QUE NO PUEDA CERRAR LA VENTANA MENU
               
        this.setSize(new Dimension(619, 700));//TAMANO DEL FORMULARIO SUS DIMENSIONES
        this.setExtendedState(this.MAXIMIZED_BOTH);//ES PARA QUE SE ADAPTE ENTODA LA PANTALLA
        this.setLocationRelativeTo(null);//PARA CENTRAR EL FORMULARIO
        this.setTitle("MenuDirectivo");
        
        this.setLayout(null);//Control detallado
        jDesktopPane_menu= new JDesktopPane();//iniciamos 
        
        int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
        int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
        this.jDesktopPane_menu.setBounds(0,0,ancho,(alto-100));//coordenadas de las interfaces que saldran en el espacio 
        this.add(jDesktopPane_menu);

    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jmAC = new javax.swing.JMenu();
        jMIDocente = new javax.swing.JMenuItem();
        jMIATutor = new javax.swing.JMenuItem();
        jMCCD = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMReg = new javax.swing.JMenu();
        jMINotas = new javax.swing.JMenuItem();
        jMIAsistencia = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMAsig = new javax.swing.JMenu();
        jMIArea = new javax.swing.JMenuItem();
        jMITutorA = new javax.swing.JMenuItem();

        jScrollPane1.setViewportView(jEditorPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        jMenuItem2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jMenuItem2.setText("Lista ");
        jMenuItem2.setPreferredSize(new java.awt.Dimension(180, 30));
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMReg.add(jMenuItem2);

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

        jMITutorA.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jMITutorA.setText("Tutor");
        jMITutorA.setPreferredSize(new java.awt.Dimension(180, 30));
        jMITutorA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMITutorAActionPerformed(evt);
            }
        });
        jMAsig.add(jMITutorA);

        jMenuBar1.add(jMAsig);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMIAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIAreaActionPerformed
       asignar_area_directivo_1 AsignarArea= new asignar_area_directivo_1();
            jDesktopPane_menu.add(AsignarArea);
            AsignarArea.setVisible(true);
    }//GEN-LAST:event_jMIAreaActionPerformed

    private void jMIATutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIATutorActionPerformed
        gestionar_tutor_directivo_1 gesTutor = new gestionar_tutor_directivo_1();//iniciar interfaz
        jDesktopPane_menu.add(gesTutor);//Poner dentro del espacio dado
       gesTutor.setVisible(true);//para que la interfaz sea visible
        
    }//GEN-LAST:event_jMIATutorActionPerformed

    private void jMIDocenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIDocenteActionPerformed
            gestionar_cuenta_docente_directivo_1 GesDoce = new gestionar_cuenta_docente_directivo_1();
            jDesktopPane_menu.add(GesDoce);
            GesDoce.setVisible(true);


            
    }//GEN-LAST:event_jMIDocenteActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        crear_cuenta_docentes_directivo_1 CcuentDocente = new crear_cuenta_docentes_directivo_1();
        jDesktopPane_menu.add(CcuentDocente);
        CcuentDocente.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
       lista_estudiantes_directivo_1 LEstudiantes = new lista_estudiantes_directivo_1();
        jDesktopPane_menu.add(LEstudiantes);
        LEstudiantes.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMITutorAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMITutorAActionPerformed
        asignar_tutor_directivo_1 AsignarTutor = new asignar_tutor_directivo_1();
        jDesktopPane_menu.add(AsignarTutor);
        AsignarTutor.setVisible(true);
    }//GEN-LAST:event_jMITutorAActionPerformed

    private void jMINotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMINotasActionPerformed
      ///REGISTRO NOTAS
      Registrar_Notas RegiNota = new Registrar_Notas();
                jDesktopPane_menu.add(RegiNota);
                RegiNota.setVisible(true);
    }//GEN-LAST:event_jMINotasActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
    Cerrar();
    }//GEN-LAST:event_formWindowClosing

    private void jMIAsistenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIAsistenciaActionPerformed
        //REGISTRO ASSITENCIA
               Registrar_Asistencia RegiAsis = new Registrar_Asistencia();
        jDesktopPane_menu.add(RegiAsis);
                RegiAsis.setVisible(true);
                
    }//GEN-LAST:event_jMIAsistenciaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuDirec.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuDirec.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuDirec.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuDirec.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuDirec().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JMenu jMAsig;
    private javax.swing.JMenu jMCCD;
    private javax.swing.JMenuItem jMIATutor;
    private javax.swing.JMenuItem jMIArea;
    private javax.swing.JMenuItem jMIAsistencia;
    private javax.swing.JMenuItem jMIDocente;
    private javax.swing.JMenuItem jMINotas;
    private javax.swing.JMenuItem jMITutorA;
    private javax.swing.JMenu jMReg;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenu jmAC;
    // End of variables declaration//GEN-END:variables
}
