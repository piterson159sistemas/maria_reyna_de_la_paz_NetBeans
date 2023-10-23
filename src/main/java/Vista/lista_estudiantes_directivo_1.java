
package Vista;


public class lista_estudiantes_directivo_1 extends javax.swing.JInternalFrame {

    public lista_estudiantes_directivo_1() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        List = new javax.swing.JList<>();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtNombres = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtApellidoP = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtApellidoM = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtNumDoc = new javax.swing.JTextField();
        cbxTipoDoc = new javax.swing.JComboBox<>();
        btnBuscar = new javax.swing.JButton();
        btnInsertar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

        setClosable(true);
        setMaximizable(true);
        setAutoscrolls(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Elija un grado:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jComboBox1.setBackground(new java.awt.Color(204, 204, 204));
        jComboBox1.setForeground(new java.awt.Color(0, 0, 0));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "3 Añitos", "4 Añitos", "5 Añitos", "1° Prim.", "2° Prim.", "3° Prim.", "4° Prim.", "5° Prim.", "6° Prim.", "1° Sec.", "2° Sec.", "3° Sec.", "4° Sec.", "5° Sec." }));
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 100, 30));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Listado de estudiantes:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, -1, -1));

        List.setBackground(new java.awt.Color(204, 204, 204));
        List.setForeground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(List);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 210, 300));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nombres");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 67, -1));

        txtNombres.setBackground(new java.awt.Color(204, 204, 204));
        txtNombres.setForeground(new java.awt.Color(0, 0, 0));
        txtNombres.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel1.add(txtNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 28, 160, 40));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Apellido Paterno");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, 104, -1));

        txtApellidoP.setBackground(new java.awt.Color(204, 204, 204));
        txtApellidoP.setForeground(new java.awt.Color(0, 0, 0));
        txtApellidoP.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel1.add(txtApellidoP, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, 140, 40));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Apellido Materno");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, 107, -1));

        txtApellidoM.setBackground(new java.awt.Color(204, 204, 204));
        txtApellidoM.setForeground(new java.awt.Color(0, 0, 0));
        txtApellidoM.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel1.add(txtApellidoM, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 30, 130, 40));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Tipo de documento");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 147, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Número de Documento");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 90, 138, -1));

        txtNumDoc.setBackground(new java.awt.Color(204, 204, 204));
        txtNumDoc.setForeground(new java.awt.Color(0, 0, 0));
        txtNumDoc.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel1.add(txtNumDoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 110, 150, 40));

        cbxTipoDoc.setBackground(new java.awt.Color(204, 204, 204));
        cbxTipoDoc.setForeground(new java.awt.Color(0, 0, 0));
        cbxTipoDoc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DNI", "Carnet de extranjeria", "Pasaporte" }));
        cbxTipoDoc.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel1.add(cbxTipoDoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 150, 40));

        btnBuscar.setBackground(new java.awt.Color(133, 164, 199));
        btnBuscar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(0, 0, 0));
        btnBuscar.setIcon(new javax.swing.ImageIcon("D:\\Raul\\UTP\\Proyecto AED\\maria_reyna_de_la_paz_NetBeans\\src\\main\\resources\\img\\search-student.png")); // NOI18N
        jPanel1.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, 40, 30));

        btnInsertar.setBackground(new java.awt.Color(133, 164, 199));
        btnInsertar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnInsertar.setForeground(new java.awt.Color(0, 0, 0));
        btnInsertar.setIcon(new javax.swing.ImageIcon("D:\\Raul\\UTP\\Proyecto AED\\maria_reyna_de_la_paz_NetBeans\\src\\main\\resources\\img\\add-student.png")); // NOI18N
        btnInsertar.setText(" Agregar");
        jPanel1.add(btnInsertar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 210, 120, 36));

        btnBorrar.setBackground(new java.awt.Color(133, 164, 199));
        btnBorrar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnBorrar.setForeground(new java.awt.Color(0, 0, 0));
        btnBorrar.setIcon(new javax.swing.ImageIcon("D:\\Raul\\UTP\\Proyecto AED\\maria_reyna_de_la_paz_NetBeans\\src\\main\\resources\\img\\delete-student.png")); // NOI18N
        btnBorrar.setText("Eliminar");
        jPanel1.add(btnBorrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 210, 116, 40));

        btnActualizar.setBackground(new java.awt.Color(133, 164, 199));
        btnActualizar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnActualizar.setForeground(new java.awt.Color(0, 0, 0));
        btnActualizar.setIcon(new javax.swing.ImageIcon("D:\\Raul\\UTP\\Proyecto AED\\maria_reyna_de_la_paz_NetBeans\\src\\main\\resources\\img\\update-student.png")); // NOI18N
        btnActualizar.setText("Actualizar");
        jPanel1.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 130, 40));

        txtSearch.setBackground(new java.awt.Color(204, 204, 204));
        txtSearch.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 260, 130, 30));

        jLabel9.setIcon(new javax.swing.ImageIcon("D:\\Raul\\UTP\\Proyecto AED\\maria_reyna_de_la_paz_NetBeans\\src\\main\\java\\img\\fondooooooo.jpg")); // NOI18N
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, 320));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 20, 480, 320));

        jLabel8.setIcon(new javax.swing.ImageIcon("D:\\Raul\\UTP\\Proyecto AED\\maria_reyna_de_la_paz_NetBeans\\src\\main\\java\\img\\logo.jpeg")); // NOI18N
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, 120));

        jLabel11.setFont(new java.awt.Font("Algerian", 1, 13)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("MARIA REYNA");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 100, -1));

        jLabel12.setFont(new java.awt.Font("Algerian", 1, 13)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("DE LA PAZ");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 80, -1));

        jLabel13.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("I.E.P");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, -1, 20));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JList<String> List;
    public javax.swing.JButton btnActualizar;
    public javax.swing.JButton btnBorrar;
    public javax.swing.JButton btnBuscar;
    public javax.swing.JButton btnInsertar;
    public javax.swing.JComboBox<String> cbxTipoDoc;
    public javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTextField txtApellidoM;
    public javax.swing.JTextField txtApellidoP;
    public javax.swing.JTextField txtNombres;
    public javax.swing.JTextField txtNumDoc;
    public javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
