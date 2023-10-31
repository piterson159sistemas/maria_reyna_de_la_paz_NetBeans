
package Vista;


public class lista_estudiantes_directivo_1 extends javax.swing.JInternalFrame {

    public lista_estudiantes_directivo_1() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cbxFiltrarGrado = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        List = new javax.swing.JList<>();
        jPanel1 = new javax.swing.JPanel();
        lblNombres = new javax.swing.JLabel();
        txtNombres = new javax.swing.JTextField();
        lblApellidoP = new javax.swing.JLabel();
        txtApellidoP = new javax.swing.JTextField();
        lblApellidoM = new javax.swing.JLabel();
        txtApellidoM = new javax.swing.JTextField();
        lblTipoDoc = new javax.swing.JLabel();
        lblNivel = new javax.swing.JLabel();
        txtNumDoc = new javax.swing.JTextField();
        btnInsertar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        cbxTipoDoc = new javax.swing.JComboBox<>();
        cbxGrado = new javax.swing.JComboBox<>();
        cbxEstadoGrado = new javax.swing.JComboBox<>();
        cbxNivel = new javax.swing.JComboBox<>();
        lblNumDoc = new javax.swing.JLabel();
        lblGradro = new javax.swing.JLabel();
        lblEstado = new javax.swing.JLabel();
        Fondo = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblListaAlumnos = new javax.swing.JTable();
        btnBuscar = new javax.swing.JButton();
        txtBuscar = new javax.swing.JTextField();
        cbxFiltrarNivel = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jLabel19 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel20 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        List1 = new javax.swing.JList<>();
        jPanel3 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        txtNombres1 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        txtApellidoP1 = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        txtApellidoM1 = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        txtNumDoc1 = new javax.swing.JTextField();
        btnInsertar1 = new javax.swing.JButton();
        btnBorrar1 = new javax.swing.JButton();
        btnActualizar1 = new javax.swing.JButton();
        cbxTipoDoc5 = new javax.swing.JComboBox<>();
        cbxTipoDoc6 = new javax.swing.JComboBox<>();
        cbxTipoDoc7 = new javax.swing.JComboBox<>();
        cbxTipoDoc8 = new javax.swing.JComboBox<>();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        Fondo1 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        btnBuscar1 = new javax.swing.JButton();
        txtSearch1 = new javax.swing.JTextField();
        cbxTipoDoc9 = new javax.swing.JComboBox<>();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        btnFiltrar = new javax.swing.JButton();

        setClosable(true);
        setMaximizable(true);
        setAutoscrolls(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cbxFiltrarGrado.setBackground(new java.awt.Color(204, 204, 204));
        cbxFiltrarGrado.setForeground(new java.awt.Color(0, 0, 0));
        cbxFiltrarGrado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "3 Añitos", "4 Añitos", "5 Añitos", "1° Prim.", "2° Prim.", "3° Prim.", "4° Prim.", "5° Prim.", "6° Prim.", "1° Sec.", "2° Sec.", "3° Sec.", "4° Sec.", "5° Sec." }));
        getContentPane().add(cbxFiltrarGrado, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 100, 30));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Listado de estudiantes:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, -1, -1));

        List.setBackground(new java.awt.Color(204, 204, 204));
        List.setForeground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(List);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 90, 110));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblNombres.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblNombres.setForeground(new java.awt.Color(255, 255, 255));
        lblNombres.setText("Nombres");
        jPanel1.add(lblNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 67, -1));

        txtNombres.setBackground(new java.awt.Color(204, 204, 204));
        txtNombres.setForeground(new java.awt.Color(0, 0, 0));
        txtNombres.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel1.add(txtNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 28, 160, 40));

        lblApellidoP.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblApellidoP.setForeground(new java.awt.Color(255, 255, 255));
        lblApellidoP.setText("Apellido Paterno");
        jPanel1.add(lblApellidoP, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, 104, -1));

        txtApellidoP.setBackground(new java.awt.Color(204, 204, 204));
        txtApellidoP.setForeground(new java.awt.Color(0, 0, 0));
        txtApellidoP.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel1.add(txtApellidoP, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, 140, 40));

        lblApellidoM.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblApellidoM.setForeground(new java.awt.Color(255, 255, 255));
        lblApellidoM.setText("Apellido Materno");
        jPanel1.add(lblApellidoM, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, 107, -1));

        txtApellidoM.setBackground(new java.awt.Color(204, 204, 204));
        txtApellidoM.setForeground(new java.awt.Color(0, 0, 0));
        txtApellidoM.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel1.add(txtApellidoM, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 30, 150, 40));

        lblTipoDoc.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTipoDoc.setForeground(new java.awt.Color(255, 255, 255));
        lblTipoDoc.setText("Tipo de documento");
        jPanel1.add(lblTipoDoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 147, -1));

        lblNivel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblNivel.setForeground(new java.awt.Color(255, 255, 255));
        lblNivel.setText("Nivel");
        jPanel1.add(lblNivel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 50, -1));

        txtNumDoc.setBackground(new java.awt.Color(204, 204, 204));
        txtNumDoc.setForeground(new java.awt.Color(0, 0, 0));
        txtNumDoc.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel1.add(txtNumDoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 110, 150, 40));

        btnInsertar.setBackground(new java.awt.Color(133, 164, 199));
        btnInsertar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnInsertar.setForeground(new java.awt.Color(0, 0, 0));
        btnInsertar.setIcon(new javax.swing.ImageIcon("D:\\Raul\\UTP\\Proyecto AED\\maria_reyna_de_la_paz_NetBeans\\src\\main\\resources\\img\\add-student.png")); // NOI18N
        btnInsertar.setText(" Agregar");
        jPanel1.add(btnInsertar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 260, 120, 40));

        btnBorrar.setBackground(new java.awt.Color(133, 164, 199));
        btnBorrar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnBorrar.setForeground(new java.awt.Color(0, 0, 0));
        btnBorrar.setIcon(new javax.swing.ImageIcon("D:\\Raul\\UTP\\Proyecto AED\\maria_reyna_de_la_paz_NetBeans\\src\\main\\resources\\img\\delete-student.png")); // NOI18N
        btnBorrar.setText("Retirar");
        jPanel1.add(btnBorrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 260, 116, 40));

        btnActualizar.setBackground(new java.awt.Color(133, 164, 199));
        btnActualizar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnActualizar.setForeground(new java.awt.Color(0, 0, 0));
        btnActualizar.setIcon(new javax.swing.ImageIcon("D:\\Raul\\UTP\\Proyecto AED\\maria_reyna_de_la_paz_NetBeans\\src\\main\\resources\\img\\update-student.png")); // NOI18N
        btnActualizar.setText("Actualizar");
        jPanel1.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 130, 40));

        cbxTipoDoc.setBackground(new java.awt.Color(204, 204, 204));
        cbxTipoDoc.setForeground(new java.awt.Color(0, 0, 0));
        cbxTipoDoc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DNI", "Carnet de extranjeria", "Pasaporte" }));
        cbxTipoDoc.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel1.add(cbxTipoDoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 150, 40));

        cbxGrado.setBackground(new java.awt.Color(204, 204, 204));
        cbxGrado.setForeground(new java.awt.Color(0, 0, 0));
        cbxGrado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "GRADOS" }));
        cbxGrado.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel1.add(cbxGrado, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 190, 120, 40));

        cbxEstadoGrado.setBackground(new java.awt.Color(204, 204, 204));
        cbxEstadoGrado.setForeground(new java.awt.Color(0, 0, 0));
        cbxEstadoGrado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "APROBADO", "EN CURSO", "DESAPROBADO" }));
        cbxEstadoGrado.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel1.add(cbxEstadoGrado, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 190, 100, 40));

        cbxNivel.setBackground(new java.awt.Color(204, 204, 204));
        cbxNivel.setForeground(new java.awt.Color(0, 0, 0));
        cbxNivel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "INCIAL", "PRIMARIA", "SECUNDARIA" }));
        cbxNivel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel1.add(cbxNivel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 130, 40));

        lblNumDoc.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblNumDoc.setForeground(new java.awt.Color(255, 255, 255));
        lblNumDoc.setText("Número de Documento");
        jPanel1.add(lblNumDoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 90, 138, -1));

        lblGradro.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblGradro.setForeground(new java.awt.Color(255, 255, 255));
        lblGradro.setText("Grado");
        jPanel1.add(lblGradro, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 170, 50, -1));

        lblEstado.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblEstado.setForeground(new java.awt.Color(255, 255, 255));
        lblEstado.setText("Estado");
        jPanel1.add(lblEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 170, 50, -1));

        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondooooooo.jpg"))); // NOI18N
        jPanel1.add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 340));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, -1, 340));

        tblListaAlumnos.setBackground(new java.awt.Color(204, 204, 204));
        tblListaAlumnos.setForeground(new java.awt.Color(0, 0, 0));
        tblListaAlumnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, "Alumno1", "E"},
                {null, "Alumno1", "E"},
                {null, "drr", "D"},
                {null, "SADF", "D"},
                {null, null, "E"},
                {null, "asasas", "D"}
            },
            new String [] {
                "Cod", "Alumno", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblListaAlumnos.setGridColor(new java.awt.Color(0, 0, 0));
        tblListaAlumnos.setShowGrid(true);
        jScrollPane2.setViewportView(tblListaAlumnos);
        if (tblListaAlumnos.getColumnModel().getColumnCount() > 0) {
            tblListaAlumnos.getColumnModel().getColumn(0).setMinWidth(0);
            tblListaAlumnos.getColumnModel().getColumn(0).setPreferredWidth(0);
            tblListaAlumnos.getColumnModel().getColumn(0).setMaxWidth(0);
            tblListaAlumnos.getColumnModel().getColumn(1).setMinWidth(150);
            tblListaAlumnos.getColumnModel().getColumn(1).setPreferredWidth(150);
            tblListaAlumnos.getColumnModel().getColumn(1).setMaxWidth(160);
            tblListaAlumnos.getColumnModel().getColumn(2).setMinWidth(50);
            tblListaAlumnos.getColumnModel().getColumn(2).setPreferredWidth(50);
            tblListaAlumnos.getColumnModel().getColumn(2).setMaxWidth(60);
        }

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 230, 120));

        btnBuscar.setBackground(new java.awt.Color(133, 164, 199));
        btnBuscar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(0, 0, 0));
        btnBuscar.setIcon(new javax.swing.ImageIcon("D:\\Raul\\UTP\\Proyecto AED\\maria_reyna_de_la_paz_NetBeans\\src\\main\\resources\\img\\search-student.png")); // NOI18N
        getContentPane().add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, 40, 30));

        txtBuscar.setBackground(new java.awt.Color(204, 204, 204));
        txtBuscar.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, 130, 30));

        cbxFiltrarNivel.setBackground(new java.awt.Color(204, 204, 204));
        cbxFiltrarNivel.setForeground(new java.awt.Color(0, 0, 0));
        cbxFiltrarNivel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "INCIAL", "PRIMARIA", "SECUNDARIA" }));
        cbxFiltrarNivel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        getContentPane().add(cbxFiltrarNivel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 90, 30));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("GRADO");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("NIVEL");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Leyenda", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(0, 0, 0))); // NOI18N
        jPanel2.setForeground(new java.awt.Color(0, 0, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Aprobado");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, 30));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 153, 0));
        jLabel13.setText("0  ");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 20, 30));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(102, 102, 102));
        jLabel15.setText("0  ");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 20, 30));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("En Curso");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, 30));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setText("Pendiente");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, -1, 30));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 51, 255));
        jLabel18.setText("0  ");
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 20, 30));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, 200, 120));

        jInternalFrame1.setClosable(true);
        jInternalFrame1.setMaximizable(true);
        jInternalFrame1.setAutoscrolls(true);
        jInternalFrame1.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setText("Elija un grado:");
        jInternalFrame1.getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jComboBox2.setBackground(new java.awt.Color(204, 204, 204));
        jComboBox2.setForeground(new java.awt.Color(0, 0, 0));
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "3 Añitos", "4 Añitos", "5 Añitos", "1° Prim.", "2° Prim.", "3° Prim.", "4° Prim.", "5° Prim.", "6° Prim.", "1° Sec.", "2° Sec.", "3° Sec.", "4° Sec.", "5° Sec." }));
        jInternalFrame1.getContentPane().add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 100, 30));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel20.setText("Listado de estudiantes:");
        jInternalFrame1.getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, -1, -1));

        List1.setBackground(new java.awt.Color(204, 204, 204));
        List1.setForeground(new java.awt.Color(0, 0, 0));
        jScrollPane3.setViewportView(List1);

        jInternalFrame1.getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 90, 110));

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Nombres");
        jPanel3.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 67, -1));

        txtNombres1.setBackground(new java.awt.Color(204, 204, 204));
        txtNombres1.setForeground(new java.awt.Color(0, 0, 0));
        txtNombres1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel3.add(txtNombres1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 28, 160, 40));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Apellido Paterno");
        jPanel3.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, 104, -1));

        txtApellidoP1.setBackground(new java.awt.Color(204, 204, 204));
        txtApellidoP1.setForeground(new java.awt.Color(0, 0, 0));
        txtApellidoP1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel3.add(txtApellidoP1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, 140, 40));

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Apellido Materno");
        jPanel3.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, 107, -1));

        txtApellidoM1.setBackground(new java.awt.Color(204, 204, 204));
        txtApellidoM1.setForeground(new java.awt.Color(0, 0, 0));
        txtApellidoM1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel3.add(txtApellidoM1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 30, 150, 40));

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Tipo de documento");
        jPanel3.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 147, -1));

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Nivel");
        jPanel3.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 50, -1));

        txtNumDoc1.setBackground(new java.awt.Color(204, 204, 204));
        txtNumDoc1.setForeground(new java.awt.Color(0, 0, 0));
        txtNumDoc1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel3.add(txtNumDoc1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 110, 150, 40));

        btnInsertar1.setBackground(new java.awt.Color(133, 164, 199));
        btnInsertar1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnInsertar1.setForeground(new java.awt.Color(0, 0, 0));
        btnInsertar1.setIcon(new javax.swing.ImageIcon("D:\\Raul\\UTP\\Proyecto AED\\maria_reyna_de_la_paz_NetBeans\\src\\main\\resources\\img\\add-student.png")); // NOI18N
        btnInsertar1.setText(" Agregar");
        jPanel3.add(btnInsertar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 260, 120, 40));

        btnBorrar1.setBackground(new java.awt.Color(133, 164, 199));
        btnBorrar1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnBorrar1.setForeground(new java.awt.Color(0, 0, 0));
        btnBorrar1.setIcon(new javax.swing.ImageIcon("D:\\Raul\\UTP\\Proyecto AED\\maria_reyna_de_la_paz_NetBeans\\src\\main\\resources\\img\\delete-student.png")); // NOI18N
        btnBorrar1.setText("Eliminar");
        jPanel3.add(btnBorrar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 260, 116, 40));

        btnActualizar1.setBackground(new java.awt.Color(133, 164, 199));
        btnActualizar1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnActualizar1.setForeground(new java.awt.Color(0, 0, 0));
        btnActualizar1.setIcon(new javax.swing.ImageIcon("D:\\Raul\\UTP\\Proyecto AED\\maria_reyna_de_la_paz_NetBeans\\src\\main\\resources\\img\\update-student.png")); // NOI18N
        btnActualizar1.setText("Actualizar");
        jPanel3.add(btnActualizar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 130, 40));

        cbxTipoDoc5.setBackground(new java.awt.Color(204, 204, 204));
        cbxTipoDoc5.setForeground(new java.awt.Color(0, 0, 0));
        cbxTipoDoc5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DNI", "Carnet de extranjeria", "Pasaporte" }));
        cbxTipoDoc5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel3.add(cbxTipoDoc5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 150, 40));

        cbxTipoDoc6.setBackground(new java.awt.Color(204, 204, 204));
        cbxTipoDoc6.setForeground(new java.awt.Color(0, 0, 0));
        cbxTipoDoc6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "GRADOS" }));
        cbxTipoDoc6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel3.add(cbxTipoDoc6, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 190, 120, 40));

        cbxTipoDoc7.setBackground(new java.awt.Color(204, 204, 204));
        cbxTipoDoc7.setForeground(new java.awt.Color(0, 0, 0));
        cbxTipoDoc7.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "APROBADO", "EN CURSO", "PENDIENTE" }));
        cbxTipoDoc7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel3.add(cbxTipoDoc7, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 190, 100, 40));

        cbxTipoDoc8.setBackground(new java.awt.Color(204, 204, 204));
        cbxTipoDoc8.setForeground(new java.awt.Color(0, 0, 0));
        cbxTipoDoc8.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "INCIAL", "PRIMARIA", "SECUNDARIA" }));
        cbxTipoDoc8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel3.add(cbxTipoDoc8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 130, 40));

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Número de Documento");
        jPanel3.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 90, 138, -1));

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Grado");
        jPanel3.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 170, 50, -1));

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Estado");
        jPanel3.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 170, 50, -1));

        Fondo1.setIcon(new javax.swing.ImageIcon("D:\\Raul\\UTP\\Proyecto AED\\maria_reyna_de_la_paz_NetBeans\\src\\main\\java\\img\\fondooooooo.jpg")); // NOI18N
        jPanel3.add(Fondo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 340));

        jInternalFrame1.getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 20, -1, 340));

        jTable2.setBackground(new java.awt.Color(204, 204, 204));
        jTable2.setForeground(new java.awt.Color(0, 0, 0));
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Alumno1", "E"},
                {"Alumno1", "E"},
                {"drr", "D"},
                {"SADF", "D"},
                {null, "E"},
                {"asasas", "D"}
            },
            new String [] {
                "Alumno", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setGridColor(new java.awt.Color(0, 0, 0));
        jTable2.setShowGrid(true);
        jScrollPane4.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setMinWidth(140);
            jTable2.getColumnModel().getColumn(0).setPreferredWidth(150);
            jTable2.getColumnModel().getColumn(0).setMaxWidth(150);
            jTable2.getColumnModel().getColumn(1).setMinWidth(50);
            jTable2.getColumnModel().getColumn(1).setPreferredWidth(50);
            jTable2.getColumnModel().getColumn(1).setMaxWidth(60);
        }

        jInternalFrame1.getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 200, 120));

        btnBuscar1.setBackground(new java.awt.Color(133, 164, 199));
        btnBuscar1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnBuscar1.setForeground(new java.awt.Color(0, 0, 0));
        btnBuscar1.setIcon(new javax.swing.ImageIcon("D:\\Raul\\UTP\\Proyecto AED\\maria_reyna_de_la_paz_NetBeans\\src\\main\\resources\\img\\search-student.png")); // NOI18N
        jInternalFrame1.getContentPane().add(btnBuscar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 40, 30));

        txtSearch1.setBackground(new java.awt.Color(204, 204, 204));
        txtSearch1.setForeground(new java.awt.Color(0, 0, 0));
        jInternalFrame1.getContentPane().add(txtSearch1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, 130, 30));

        cbxTipoDoc9.setBackground(new java.awt.Color(204, 204, 204));
        cbxTipoDoc9.setForeground(new java.awt.Color(0, 0, 0));
        cbxTipoDoc9.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "INCIAL", "PRIMARIA", "SECUNDARIA" }));
        cbxTipoDoc9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jInternalFrame1.getContentPane().add(cbxTipoDoc9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 90, 30));

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(0, 0, 0));
        jLabel29.setText("GRADO");
        jInternalFrame1.getContentPane().add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        jLabel30.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(0, 0, 0));
        jLabel30.setText("NIVEL");
        jInternalFrame1.getContentPane().add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Leyenda", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(0, 0, 0))); // NOI18N
        jPanel4.setForeground(new java.awt.Color(0, 0, 0));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel31.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(0, 0, 0));
        jLabel31.setText("Aprobado");
        jPanel4.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, 30));

        jLabel32.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(0, 153, 0));
        jLabel32.setText("0  ");
        jPanel4.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 20, 30));

        jLabel33.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(102, 102, 102));
        jLabel33.setText("0  ");
        jPanel4.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 20, 30));

        jLabel34.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(0, 0, 0));
        jLabel34.setText("En Curso");
        jPanel4.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, 30));

        jLabel35.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(0, 0, 0));
        jLabel35.setText("Pendiente");
        jPanel4.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, -1, 30));

        jLabel36.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(0, 51, 255));
        jLabel36.setText("0  ");
        jPanel4.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 20, 30));

        jInternalFrame1.getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 240, 200, 120));

        getContentPane().add(jInternalFrame1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        btnFiltrar.setBackground(new java.awt.Color(133, 164, 199));
        btnFiltrar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnFiltrar.setForeground(new java.awt.Color(0, 0, 0));
        btnFiltrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Filtrar.png"))); // NOI18N
        btnFiltrar.setText("Filtrar");
        getContentPane().add(btnFiltrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Fondo;
    private javax.swing.JLabel Fondo1;
    public javax.swing.JList<String> List;
    public javax.swing.JList<String> List1;
    public javax.swing.JButton btnActualizar;
    public javax.swing.JButton btnActualizar1;
    public javax.swing.JButton btnBorrar;
    public javax.swing.JButton btnBorrar1;
    public javax.swing.JButton btnBuscar;
    public javax.swing.JButton btnBuscar1;
    public javax.swing.JButton btnFiltrar;
    public javax.swing.JButton btnInsertar;
    public javax.swing.JButton btnInsertar1;
    public javax.swing.JComboBox<String> cbxEstadoGrado;
    public javax.swing.JComboBox<String> cbxFiltrarGrado;
    public javax.swing.JComboBox<String> cbxFiltrarNivel;
    public javax.swing.JComboBox<String> cbxGrado;
    public javax.swing.JComboBox<String> cbxNivel;
    public javax.swing.JComboBox<String> cbxTipoDoc;
    public javax.swing.JComboBox<String> cbxTipoDoc5;
    public javax.swing.JComboBox<String> cbxTipoDoc6;
    public javax.swing.JComboBox<String> cbxTipoDoc7;
    public javax.swing.JComboBox<String> cbxTipoDoc8;
    public javax.swing.JComboBox<String> cbxTipoDoc9;
    public javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel lblApellidoM;
    private javax.swing.JLabel lblApellidoP;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblGradro;
    private javax.swing.JLabel lblNivel;
    private javax.swing.JLabel lblNombres;
    private javax.swing.JLabel lblNumDoc;
    private javax.swing.JLabel lblTipoDoc;
    public javax.swing.JTable tblListaAlumnos;
    public javax.swing.JTextField txtApellidoM;
    public javax.swing.JTextField txtApellidoM1;
    public javax.swing.JTextField txtApellidoP;
    public javax.swing.JTextField txtApellidoP1;
    public javax.swing.JTextField txtBuscar;
    public javax.swing.JTextField txtNombres;
    public javax.swing.JTextField txtNombres1;
    public javax.swing.JTextField txtNumDoc;
    public javax.swing.JTextField txtNumDoc1;
    public javax.swing.JTextField txtSearch1;
    // End of variables declaration//GEN-END:variables
}
