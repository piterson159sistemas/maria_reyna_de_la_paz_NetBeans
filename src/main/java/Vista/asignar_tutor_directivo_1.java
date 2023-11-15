
package Vista;

public class asignar_tutor_directivo_1 extends javax.swing.JInternalFrame {

 
    public asignar_tutor_directivo_1() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelInicial = new javax.swing.JPanel();
        Ini3 = new javax.swing.JCheckBox();
        Ini4 = new javax.swing.JCheckBox();
        Ini5 = new javax.swing.JCheckBox();
        panelPrimaria = new javax.swing.JPanel();
        Pri1 = new javax.swing.JCheckBox();
        Pri2 = new javax.swing.JCheckBox();
        Pri3 = new javax.swing.JCheckBox();
        Pri4 = new javax.swing.JCheckBox();
        Pri5 = new javax.swing.JCheckBox();
        Pri6 = new javax.swing.JCheckBox();
        panelSecundaria = new javax.swing.JPanel();
        Sec1 = new javax.swing.JCheckBox();
        Sec2 = new javax.swing.JCheckBox();
        Sec3 = new javax.swing.JCheckBox();
        Sec4 = new javax.swing.JCheckBox();
        Sec5 = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProfes = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtAnio = new javax.swing.JTextField();
        btnBorrar = new javax.swing.JButton();
        cbxTutor = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        btnActualizar = new javax.swing.JButton();
        btnCrear = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblGrados = new javax.swing.JTable();
        btnLimpiar = new javax.swing.JButton();

        setClosable(true);
        setMaximizable(true);
        setAutoscrolls(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelInicial.setBackground(new java.awt.Color(204, 204, 204));
        panelInicial.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Ini3.setForeground(new java.awt.Color(0, 0, 0));
        Ini3.setText("3 Añitos");
        panelInicial.add(Ini3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        Ini4.setForeground(new java.awt.Color(0, 0, 0));
        Ini4.setText("4 Añitos");
        panelInicial.add(Ini4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        Ini5.setForeground(new java.awt.Color(0, 0, 0));
        Ini5.setText("5 Añitos");
        panelInicial.add(Ini5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        getContentPane().add(panelInicial, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 100, 200));

        panelPrimaria.setBackground(new java.awt.Color(204, 204, 204));
        panelPrimaria.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Pri1.setForeground(new java.awt.Color(0, 0, 0));
        Pri1.setText("1° Prim.");
        panelPrimaria.add(Pri1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        Pri2.setForeground(new java.awt.Color(0, 0, 0));
        Pri2.setText("2° Prim.");
        panelPrimaria.add(Pri2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        Pri3.setForeground(new java.awt.Color(0, 0, 0));
        Pri3.setText("3° Prim.");
        panelPrimaria.add(Pri3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        Pri4.setForeground(new java.awt.Color(0, 0, 0));
        Pri4.setText("4° Prim.");
        panelPrimaria.add(Pri4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        Pri5.setForeground(new java.awt.Color(0, 0, 0));
        Pri5.setText("5° Prim.");
        panelPrimaria.add(Pri5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        Pri6.setForeground(new java.awt.Color(0, 0, 0));
        Pri6.setText("6° Prim.");
        panelPrimaria.add(Pri6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        getContentPane().add(panelPrimaria, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, 110, 200));

        panelSecundaria.setBackground(new java.awt.Color(204, 204, 204));
        panelSecundaria.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Sec1.setForeground(new java.awt.Color(0, 0, 0));
        Sec1.setText("1° Sec.");
        panelSecundaria.add(Sec1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        Sec2.setForeground(new java.awt.Color(0, 0, 0));
        Sec2.setText("2° Sec.");
        panelSecundaria.add(Sec2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        Sec3.setForeground(new java.awt.Color(0, 0, 0));
        Sec3.setText("3° Sec.");
        panelSecundaria.add(Sec3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        Sec4.setForeground(new java.awt.Color(0, 0, 0));
        Sec4.setText("4° Sec.");
        panelSecundaria.add(Sec4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        Sec5.setForeground(new java.awt.Color(0, 0, 0));
        Sec5.setText("5° Sec.");
        panelSecundaria.add(Sec5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        getContentPane().add(panelSecundaria, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 180, 100, 200));

        tblProfes.setBackground(new java.awt.Color(204, 204, 204));
        tblProfes.setForeground(new java.awt.Color(0, 0, 0));
        tblProfes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, "", ""},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Año", "Codigo", "Nombre Docente"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblProfes);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 40, 450, 180));

        jLabel1.setText("Año:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        txtAnio.setBackground(new java.awt.Color(204, 204, 204));
        txtAnio.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(txtAnio, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 80, 40));

        btnBorrar.setBackground(new java.awt.Color(133, 164, 199));
        btnBorrar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnBorrar.setForeground(new java.awt.Color(0, 0, 0));
        btnBorrar.setText("Borrar");
        getContentPane().add(btnBorrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 80, 30));

        cbxTutor.setBackground(new java.awt.Color(204, 204, 204));
        cbxTutor.setForeground(new java.awt.Color(0, 0, 0));
        cbxTutor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "..." }));
        getContentPane().add(cbxTutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 230, 40));

        jLabel2.setText("Tutor:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, -1, -1));

        btnActualizar.setBackground(new java.awt.Color(133, 164, 199));
        btnActualizar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnActualizar.setForeground(new java.awt.Color(0, 0, 0));
        btnActualizar.setText("Actualizar");
        getContentPane().add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, 110, 30));

        btnCrear.setBackground(new java.awt.Color(133, 164, 199));
        btnCrear.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCrear.setForeground(new java.awt.Color(0, 0, 0));
        btnCrear.setText("Crear");
        getContentPane().add(btnCrear, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 90, 90, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 255));
        jLabel4.setText("Inicial");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 50, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 102, 255));
        jLabel5.setText("Grados Asignados");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 240, 130, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 102, 255));
        jLabel6.setText("Secundaria");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 150, 80, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 102, 255));
        jLabel7.setText("Primaria");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, 60, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 102, 255));
        jLabel8.setText("Profesores encargados");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, 160, -1));

        tblGrados.setBackground(new java.awt.Color(204, 204, 204));
        tblGrados.setForeground(new java.awt.Color(0, 0, 0));
        tblGrados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Grado"
            }
        ));
        jScrollPane2.setViewportView(tblGrados);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 270, 160, 90));

        btnLimpiar.setBackground(new java.awt.Color(133, 164, 199));
        btnLimpiar.setForeground(new java.awt.Color(0, 0, 0));
        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Limpiar.png"))); // NOI18N
        getContentPane().add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 90, 40, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JCheckBox Ini3;
    public javax.swing.JCheckBox Ini4;
    public javax.swing.JCheckBox Ini5;
    public javax.swing.JCheckBox Pri1;
    public javax.swing.JCheckBox Pri2;
    public javax.swing.JCheckBox Pri3;
    public javax.swing.JCheckBox Pri4;
    public javax.swing.JCheckBox Pri5;
    public javax.swing.JCheckBox Pri6;
    public javax.swing.JCheckBox Sec1;
    public javax.swing.JCheckBox Sec2;
    public javax.swing.JCheckBox Sec3;
    public javax.swing.JCheckBox Sec4;
    public javax.swing.JCheckBox Sec5;
    public javax.swing.JButton btnActualizar;
    public javax.swing.JButton btnBorrar;
    public javax.swing.JButton btnCrear;
    public javax.swing.JButton btnLimpiar;
    public javax.swing.JComboBox<String> cbxTutor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JPanel panelInicial;
    public javax.swing.JPanel panelPrimaria;
    public javax.swing.JPanel panelSecundaria;
    public javax.swing.JTable tblGrados;
    public javax.swing.JTable tblProfes;
    public javax.swing.JTextField txtAnio;
    // End of variables declaration//GEN-END:variables
}
