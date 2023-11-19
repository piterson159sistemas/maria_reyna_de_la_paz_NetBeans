
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
        panelAlumno = new javax.swing.JPanel();
        lblNombres = new javax.swing.JLabel();
        txtNombres = new javax.swing.JTextField();
        lblApellidoP = new javax.swing.JLabel();
        txtApellidoP = new javax.swing.JTextField();
        lblApellidoM = new javax.swing.JLabel();
        txtApellidoM = new javax.swing.JTextField();
        lblTipoDoc = new javax.swing.JLabel();
        txtNumDoc = new javax.swing.JTextField();
        btnLimpiar = new javax.swing.JButton();
        cbxTipoDoc = new javax.swing.JComboBox<>();
        lblNumDoc = new javax.swing.JLabel();
        btnCrearAlumno = new javax.swing.JButton();
        btnModificarAlumno = new javax.swing.JButton();
        titulo = new javax.swing.JLabel();
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
        lblAprobado = new javax.swing.JLabel();
        lblEnCurso = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        lblDesaprobado = new javax.swing.JLabel();
        lblDesaprobado1 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        btnFiltrar = new javax.swing.JButton();
        lblNumAlumnos = new javax.swing.JLabel();
        cbxFiltrarEstadoGrado = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        txtFiltrarAnio = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cbxNivel = new javax.swing.JComboBox<>();
        cbxGrado = new javax.swing.JComboBox<>();
        cbxEstadoGrado = new javax.swing.JComboBox<>();
        lblNivel = new javax.swing.JLabel();
        lblGradro = new javax.swing.JLabel();
        lblEstado = new javax.swing.JLabel();
        btnInsertar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        lblAnio = new javax.swing.JLabel();
        txtAnio = new javax.swing.JTextField();
        Fondo1 = new javax.swing.JLabel();

        setClosable(true);
        setMaximizable(true);
        setAutoscrolls(true);
        addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                formAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cbxFiltrarGrado.setBackground(new java.awt.Color(204, 204, 204));
        cbxFiltrarGrado.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(cbxFiltrarGrado, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 120, 30));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Listado de estudiantes:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, -1, -1));

        panelAlumno.setBackground(new java.awt.Color(204, 204, 204));
        panelAlumno.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblNombres.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblNombres.setForeground(new java.awt.Color(255, 255, 255));
        lblNombres.setText("Nombres");
        panelAlumno.add(lblNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 67, -1));

        txtNombres.setBackground(new java.awt.Color(204, 204, 204));
        txtNombres.setForeground(new java.awt.Color(0, 0, 0));
        txtNombres.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        panelAlumno.add(txtNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 160, 40));

        lblApellidoP.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblApellidoP.setForeground(new java.awt.Color(255, 255, 255));
        lblApellidoP.setText("Apellido Paterno");
        panelAlumno.add(lblApellidoP, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 50, 104, -1));

        txtApellidoP.setBackground(new java.awt.Color(204, 204, 204));
        txtApellidoP.setForeground(new java.awt.Color(0, 0, 0));
        txtApellidoP.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        panelAlumno.add(txtApellidoP, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 70, 140, 40));

        lblApellidoM.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblApellidoM.setForeground(new java.awt.Color(255, 255, 255));
        lblApellidoM.setText("Apellido Materno");
        panelAlumno.add(lblApellidoM, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 50, 107, -1));

        txtApellidoM.setBackground(new java.awt.Color(204, 204, 204));
        txtApellidoM.setForeground(new java.awt.Color(0, 0, 0));
        txtApellidoM.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        panelAlumno.add(txtApellidoM, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 70, 150, 40));

        lblTipoDoc.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTipoDoc.setForeground(new java.awt.Color(255, 255, 255));
        lblTipoDoc.setText("Tipo de documento");
        panelAlumno.add(lblTipoDoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 147, -1));

        txtNumDoc.setBackground(new java.awt.Color(204, 204, 204));
        txtNumDoc.setForeground(new java.awt.Color(0, 0, 0));
        txtNumDoc.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        panelAlumno.add(txtNumDoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, 150, 40));

        btnLimpiar.setBackground(new java.awt.Color(133, 164, 199));
        btnLimpiar.setForeground(new java.awt.Color(0, 0, 0));
        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Limpiar.png"))); // NOI18N
        panelAlumno.add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 220, 50, 40));

        cbxTipoDoc.setBackground(new java.awt.Color(204, 204, 204));
        cbxTipoDoc.setForeground(new java.awt.Color(0, 0, 0));
        cbxTipoDoc.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        panelAlumno.add(cbxTipoDoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 150, 40));

        lblNumDoc.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblNumDoc.setForeground(new java.awt.Color(255, 255, 255));
        lblNumDoc.setText("Número de Documento");
        panelAlumno.add(lblNumDoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 130, 138, -1));

        btnCrearAlumno.setBackground(new java.awt.Color(133, 164, 199));
        btnCrearAlumno.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCrearAlumno.setForeground(new java.awt.Color(0, 0, 0));
        btnCrearAlumno.setText("Crear Alumno");
        panelAlumno.add(btnCrearAlumno, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 220, 130, 40));

        btnModificarAlumno.setBackground(new java.awt.Color(133, 164, 199));
        btnModificarAlumno.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnModificarAlumno.setForeground(new java.awt.Color(0, 0, 0));
        btnModificarAlumno.setText("Modificar Alumno");
        panelAlumno.add(btnModificarAlumno, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 220, 160, 40));

        titulo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        titulo.setForeground(new java.awt.Color(255, 255, 255));
        titulo.setText(" - - - - - - - - - - - INFORMACION DE ALUMNO - - - - - - - - - - -");
        panelAlumno.add(titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, -1, -1));

        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondooooooo.jpg"))); // NOI18N
        panelAlumno.add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 590, 280));

        getContentPane().add(panelAlumno, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 20, 590, 280));

        tblListaAlumnos.setBackground(new java.awt.Color(204, 204, 204));
        tblListaAlumnos.setForeground(new java.awt.Color(0, 0, 0));
        tblListaAlumnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblListaAlumnos.setGridColor(new java.awt.Color(0, 0, 0));
        tblListaAlumnos.setShowGrid(true);
        jScrollPane2.setViewportView(tblListaAlumnos);
        if (tblListaAlumnos.getColumnModel().getColumnCount() > 0) {
            tblListaAlumnos.getColumnModel().getColumn(0).setMinWidth(10);
            tblListaAlumnos.getColumnModel().getColumn(0).setPreferredWidth(10);
            tblListaAlumnos.getColumnModel().getColumn(0).setMaxWidth(10);
            tblListaAlumnos.getColumnModel().getColumn(1).setMinWidth(150);
            tblListaAlumnos.getColumnModel().getColumn(1).setPreferredWidth(150);
            tblListaAlumnos.getColumnModel().getColumn(1).setMaxWidth(160);
            tblListaAlumnos.getColumnModel().getColumn(2).setMinWidth(50);
            tblListaAlumnos.getColumnModel().getColumn(2).setPreferredWidth(50);
            tblListaAlumnos.getColumnModel().getColumn(2).setMaxWidth(60);
        }

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, 240, 120));

        btnBuscar.setBackground(new java.awt.Color(133, 164, 199));
        btnBuscar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(0, 0, 0));
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search-student.png"))); // NOI18N
        getContentPane().add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, 40, 30));

        txtBuscar.setBackground(new java.awt.Color(204, 204, 204));
        txtBuscar.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 30, 190, 30));

        cbxFiltrarNivel.setBackground(new java.awt.Color(204, 204, 204));
        cbxFiltrarNivel.setForeground(new java.awt.Color(0, 0, 0));
        cbxFiltrarNivel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        getContentPane().add(cbxFiltrarNivel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 120, 30));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("AÑO");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, -1, -1));

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

        lblAprobado.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblAprobado.setForeground(new java.awt.Color(0, 153, 0));
        lblAprobado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Aprobado.png"))); // NOI18N
        jPanel2.add(lblAprobado, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 20, 30));

        lblEnCurso.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblEnCurso.setForeground(new java.awt.Color(102, 102, 102));
        lblEnCurso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/EnCurso.png"))); // NOI18N
        jPanel2.add(lblEnCurso, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 20, 30));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("En Curso");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, 30));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setText("Desaprobado");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, -1, 30));

        lblDesaprobado.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblDesaprobado.setForeground(new java.awt.Color(0, 51, 255));
        lblDesaprobado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Desaprobado.png"))); // NOI18N
        jPanel2.add(lblDesaprobado, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 20, 30));

        lblDesaprobado1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblDesaprobado1.setForeground(new java.awt.Color(0, 51, 255));
        lblDesaprobado1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Retirado.png"))); // NOI18N
        jPanel2.add(lblDesaprobado1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 20, 30));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 0, 0));
        jLabel18.setText("Retirado");
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, -1, 30));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 230, 200, 150));

        btnFiltrar.setBackground(new java.awt.Color(133, 164, 199));
        btnFiltrar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnFiltrar.setForeground(new java.awt.Color(0, 0, 0));
        btnFiltrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Filtrar.png"))); // NOI18N
        btnFiltrar.setText("Filtrar");
        getContentPane().add(btnFiltrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        lblNumAlumnos.setText("NumAlumnos");
        getContentPane().add(lblNumAlumnos, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 70, 90, 20));

        cbxFiltrarEstadoGrado.setBackground(new java.awt.Color(204, 204, 204));
        cbxFiltrarEstadoGrado.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(cbxFiltrarEstadoGrado, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 120, 30));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("GRADO");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        txtFiltrarAnio.setBackground(new java.awt.Color(204, 204, 204));
        txtFiltrarAnio.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(txtFiltrarAnio, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 110, 30));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("ESTADO");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, -1));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "INFORMACION DE GRADO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText(" - - - - - - - - - - - INFORMACION DE GRADO - - - - - - - - - - -");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, -1, -1));

        cbxNivel.setBackground(new java.awt.Color(204, 204, 204));
        cbxNivel.setForeground(new java.awt.Color(0, 0, 0));
        cbxNivel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel1.add(cbxNivel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 130, 40));

        cbxGrado.setBackground(new java.awt.Color(204, 204, 204));
        cbxGrado.setForeground(new java.awt.Color(0, 0, 0));
        cbxGrado.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel1.add(cbxGrado, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 50, 120, 40));

        cbxEstadoGrado.setBackground(new java.awt.Color(204, 204, 204));
        cbxEstadoGrado.setForeground(new java.awt.Color(0, 0, 0));
        cbxEstadoGrado.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel1.add(cbxEstadoGrado, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 50, 100, 40));

        lblNivel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblNivel.setForeground(new java.awt.Color(255, 255, 255));
        lblNivel.setText("Nivel");
        jPanel1.add(lblNivel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 50, -1));

        lblGradro.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblGradro.setForeground(new java.awt.Color(255, 255, 255));
        lblGradro.setText("Grado");
        jPanel1.add(lblGradro, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, 50, -1));

        lblEstado.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblEstado.setForeground(new java.awt.Color(255, 255, 255));
        lblEstado.setText("Estado");
        jPanel1.add(lblEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 30, 50, 20));

        btnInsertar.setBackground(new java.awt.Color(133, 164, 199));
        btnInsertar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnInsertar.setForeground(new java.awt.Color(0, 0, 0));
        btnInsertar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add-student.png"))); // NOI18N
        btnInsertar.setText(" Agregar");
        jPanel1.add(btnInsertar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 130, 140, 40));

        btnModificar.setBackground(new java.awt.Color(133, 164, 199));
        btnModificar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnModificar.setForeground(new java.awt.Color(0, 0, 0));
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/update-student.png"))); // NOI18N
        btnModificar.setText("Modificar");
        jPanel1.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 140, 40));

        btnBorrar.setBackground(new java.awt.Color(133, 164, 199));
        btnBorrar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnBorrar.setForeground(new java.awt.Color(0, 0, 0));
        btnBorrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete-student.png"))); // NOI18N
        btnBorrar.setText("Borrar");
        jPanel1.add(btnBorrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 130, 110, 40));

        lblAnio.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblAnio.setForeground(new java.awt.Color(255, 255, 255));
        lblAnio.setText("Año");
        jPanel1.add(lblAnio, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 30, 30, -1));

        txtAnio.setBackground(new java.awt.Color(204, 204, 204));
        txtAnio.setForeground(new java.awt.Color(0, 0, 0));
        txtAnio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel1.add(txtAnio, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 50, 100, 40));

        Fondo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondooooooo.jpg"))); // NOI18N
        jPanel1.add(Fondo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 190));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 330, 580, 190));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_formAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_formAncestorAdded


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Fondo;
    private javax.swing.JLabel Fondo1;
    public javax.swing.JButton btnBorrar;
    public javax.swing.JButton btnBuscar;
    public javax.swing.JButton btnCrearAlumno;
    public javax.swing.JButton btnFiltrar;
    public javax.swing.JButton btnInsertar;
    public javax.swing.JButton btnLimpiar;
    public javax.swing.JButton btnModificar;
    public javax.swing.JButton btnModificarAlumno;
    public javax.swing.JComboBox<String> cbxEstadoGrado;
    public javax.swing.JComboBox<String> cbxFiltrarEstadoGrado;
    public javax.swing.JComboBox<String> cbxFiltrarGrado;
    public javax.swing.JComboBox<String> cbxFiltrarNivel;
    public javax.swing.JComboBox<String> cbxGrado;
    public javax.swing.JComboBox<String> cbxNivel;
    public javax.swing.JComboBox<String> cbxTipoDoc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAnio;
    private javax.swing.JLabel lblApellidoM;
    private javax.swing.JLabel lblApellidoP;
    private javax.swing.JLabel lblAprobado;
    private javax.swing.JLabel lblDesaprobado;
    private javax.swing.JLabel lblDesaprobado1;
    private javax.swing.JLabel lblEnCurso;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblGradro;
    private javax.swing.JLabel lblNivel;
    private javax.swing.JLabel lblNombres;
    public javax.swing.JLabel lblNumAlumnos;
    private javax.swing.JLabel lblNumDoc;
    private javax.swing.JLabel lblTipoDoc;
    private javax.swing.JPanel panelAlumno;
    public javax.swing.JTable tblListaAlumnos;
    private javax.swing.JLabel titulo;
    public javax.swing.JTextField txtAnio;
    public javax.swing.JTextField txtApellidoM;
    public javax.swing.JTextField txtApellidoP;
    public javax.swing.JTextField txtBuscar;
    public javax.swing.JTextField txtFiltrarAnio;
    public javax.swing.JTextField txtNombres;
    public javax.swing.JTextField txtNumDoc;
    // End of variables declaration//GEN-END:variables
}
