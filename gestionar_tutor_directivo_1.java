/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package interfaces;

/**
 *
 * @author jheremyPonte
 */
public class gestionar_tutor_directivo_1 extends javax.swing.JInternalFrame {

    /**
     * Creates new form prueba
     */
    public gestionar_tutor_directivo_1() {
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

        txt_GestionarTutor_grado_1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btn_GestionarTutor_borrar_1 = new javax.swing.JButton();
        btn_GestionarTutor_actualizar_1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_AsignarTutor_registro_1 = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_GestionarTutor_grado_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_GestionarTutor_grado_1ActionPerformed(evt);
            }
        });
        getContentPane().add(txt_GestionarTutor_grado_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 115, -1));

        jLabel1.setText("Grado:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 49, -1));

        btn_GestionarTutor_borrar_1.setText("Borrar");
        getContentPane().add(btn_GestionarTutor_borrar_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 220, 100, 38));

        btn_GestionarTutor_actualizar_1.setText("Actualizar");
        getContentPane().add(btn_GestionarTutor_actualizar_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 220, 100, 38));

        tbl_AsignarTutor_registro_1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, "", "", null, "", null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Apellido Paterno", "Apellido Materno", "Año", "Codigo", "Grado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbl_AsignarTutor_registro_1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 7, 640, 190));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_GestionarTutor_grado_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_GestionarTutor_grado_1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_GestionarTutor_grado_1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_GestionarTutor_actualizar_1;
    private javax.swing.JButton btn_GestionarTutor_borrar_1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_AsignarTutor_registro_1;
    private javax.swing.JTextField txt_GestionarTutor_grado_1;
    // End of variables declaration//GEN-END:variables
}
