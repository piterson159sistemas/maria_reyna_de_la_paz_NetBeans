/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Vista;

/**
 *
 * @author jheremyPonte
 */
public class gestionar_cuenta_docente_directivo_1 extends javax.swing.JInternalFrame {

    /**
     * Creates new form gestionar_cuenta_docente_directivo_1
     */
    public gestionar_cuenta_docente_directivo_1() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_GD = new javax.swing.JTable();
        jbtnBorrarGD = new javax.swing.JButton();
        JbtnListarDocentes = new javax.swing.JButton();
        jbtnActualizarD = new javax.swing.JButton();
        jbtnEditar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jtxtPregunta1 = new javax.swing.JTextField();
        jtxtContrass = new javax.swing.JTextField();
        jtxtAM = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jtxtNombre = new javax.swing.JTextField();
        jtxtNDocumento = new javax.swing.JTextField();
        jtxtPregunta2 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jtxtAP = new javax.swing.JTextField();
        jtxtCod = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jtxtRespuesta1 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jtxtRespuesta2 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jtxtRespuesta3 = new javax.swing.JTextField();
        jtxtPregunta3 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setAutoscrolls(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_GD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Apellido Paterno", "Apellido Materno", "Codigo", "N° Documento", "Contraseña", "Pregunta1", "Respuesta1", "Pregunta2", "Respuesta2", "Pregunta3", "Respuesta3"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbl_GD);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1040, 200));

        jbtnBorrarGD.setText("Borrar");
        getContentPane().add(jbtnBorrarGD, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 260, 150, 40));

        JbtnListarDocentes.setText("Listar");
        JbtnListarDocentes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbtnListarDocentesActionPerformed(evt);
            }
        });
        getContentPane().add(JbtnListarDocentes, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 310, 150, 40));

        jbtnActualizarD.setText("Actualizar");
        getContentPane().add(jbtnActualizarD, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 210, 150, 40));

        jbtnEditar.setText("Editar");
        getContentPane().add(jbtnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 360, 150, 40));

        jLabel1.setText("N° de Documento:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, -1));

        jLabel3.setText("Nombre:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 210, -1, -1));

        jLabel7.setText("Pregunta 1");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, -1, -1));
        getContentPane().add(jtxtPregunta1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 120, 30));
        getContentPane().add(jtxtContrass, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 240, 120, 30));
        getContentPane().add(jtxtAM, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 240, 120, 30));

        jLabel4.setText("Apellido Paterno:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 210, -1, -1));

        jLabel8.setText("Pregunta 2");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 290, -1, -1));
        getContentPane().add(jtxtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 240, 120, 30));
        getContentPane().add(jtxtNDocumento, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 120, 30));
        getContentPane().add(jtxtPregunta2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 320, 120, 30));

        jLabel6.setText("Contraseña:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 210, -1, -1));

        jLabel5.setText("Apellido Materno:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 210, -1, -1));

        jLabel9.setText("Pregunta 3");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 290, -1, -1));
        getContentPane().add(jtxtAP, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 240, 120, 30));

        jtxtCod.setEditable(false);
        getContentPane().add(jtxtCod, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 320, 120, 30));

        jLabel12.setText("Respuesta 1");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, -1, -1));
        getContentPane().add(jtxtRespuesta1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, 120, 30));

        jLabel14.setText("Respuesta 2");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 360, -1, -1));
        getContentPane().add(jtxtRespuesta2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 390, 120, 30));

        jLabel16.setText("Respuesta 3");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 360, -1, -1));
        getContentPane().add(jtxtRespuesta3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 390, 120, 30));
        getContentPane().add(jtxtPregunta3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 320, 120, 30));

        jLabel2.setText("Codigo");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 290, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JbtnListarDocentesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbtnListarDocentesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JbtnListarDocentesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton JbtnListarDocentes;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel12;
    public javax.swing.JLabel jLabel14;
    public javax.swing.JLabel jLabel16;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel3;
    public javax.swing.JLabel jLabel4;
    public javax.swing.JLabel jLabel5;
    public javax.swing.JLabel jLabel6;
    public javax.swing.JLabel jLabel7;
    public javax.swing.JLabel jLabel8;
    public javax.swing.JLabel jLabel9;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JButton jbtnActualizarD;
    public javax.swing.JButton jbtnBorrarGD;
    public javax.swing.JButton jbtnEditar;
    public javax.swing.JTextField jtxtAM;
    public javax.swing.JTextField jtxtAP;
    public javax.swing.JTextField jtxtCod;
    public javax.swing.JTextField jtxtContrass;
    public javax.swing.JTextField jtxtNDocumento;
    public javax.swing.JTextField jtxtNombre;
    public javax.swing.JTextField jtxtPregunta1;
    public javax.swing.JTextField jtxtPregunta2;
    public javax.swing.JTextField jtxtPregunta3;
    public javax.swing.JTextField jtxtRespuesta1;
    public javax.swing.JTextField jtxtRespuesta2;
    public javax.swing.JTextField jtxtRespuesta3;
    public javax.swing.JTable tbl_GD;
    // End of variables declaration//GEN-END:variables
}
