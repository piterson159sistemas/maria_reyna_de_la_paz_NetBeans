/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package VISTA_DIRECTIVO;

/**
 *
 * @author SARA
 */
public class Docente_CrearDocent extends javax.swing.JFrame {

    /**
     * Creates new form frameejemplo
     */
    public Docente_CrearDocent() {
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

        rSPanelMaterial1 = new RSMaterialComponent.RSPanelMaterial();
        jPanel2 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        textFieldClave2 = new RSMaterialComponent.RSPasswordIconTwo();
        cb_ingles = new RSMaterialComponent.RSCheckBoxMaterial();
        cb_EduTrabajo = new RSMaterialComponent.RSCheckBoxMaterial();
        cb_CiudadaniaCivica = new RSMaterialComponent.RSCheckBoxMaterial();
        cb_computacion = new RSMaterialComponent.RSCheckBoxMaterial();
        cb_psicomotriz = new RSMaterialComponent.RSCheckBoxMaterial();
        cb_ArteCultura = new RSMaterialComponent.RSCheckBoxMaterial();
        rSLabelTextIcon2 = new RSMaterialComponent.RSLabelTextIcon();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldNumDocumento = new RSMaterialComponent.RSTextFieldTwo();
        jLabel2 = new javax.swing.JLabel();
        Jtxtnombre = new RSMaterialComponent.RSTextFieldTwo();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldApellidoP = new RSMaterialComponent.RSTextFieldTwo();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldRespuesta1 = new RSMaterialComponent.RSTextFieldTwo();
        jTextFieldApellidoM = new RSMaterialComponent.RSTextFieldTwo();
        jTextFieldRespuesta2 = new RSMaterialComponent.RSTextFieldTwo();
        jTextFieldRespuesta3 = new RSMaterialComponent.RSTextFieldTwo();
        jbtnRegistrar = new RSMaterialComponent.RSButtonIconShadow();
        jLabel6 = new javax.swing.JLabel();
        cb_PersonalSocial = new RSMaterialComponent.RSCheckBoxMaterial();
        jLabel8 = new javax.swing.JLabel();
        cb_matematica = new RSMaterialComponent.RSCheckBoxMaterial();
        jLabel9 = new javax.swing.JLabel();
        cb_religion1 = new RSMaterialComponent.RSCheckBoxMaterial();
        jLabel11 = new javax.swing.JLabel();
        cb_CienciasSociales = new RSMaterialComponent.RSCheckBoxMaterial();
        jTextFieldClave = new RSMaterialComponent.RSPasswordIconTwo();
        cb_comunicacion = new RSMaterialComponent.RSCheckBoxMaterial();
        cb_EduFisica = new RSMaterialComponent.RSCheckBoxMaterial();
        jbtnRegistrar1 = new RSMaterialComponent.RSButtonIconShadow();
        jTextFieldPregunta3 = new RSMaterialComponent.RSComboBox();
        jTextFieldPregunta1 = new RSMaterialComponent.RSComboBox();
        jTextFieldPregunta2 = new RSMaterialComponent.RSComboBox();
        cb_CienciaTecnologia1 = new RSMaterialComponent.RSCheckBoxMaterial();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        rSPanelMaterial1.setBackground(new java.awt.Color(255, 255, 255));
        rSPanelMaterial1.setAutoscrolls(true);
        rSPanelMaterial1.setBgShade(new java.awt.Color(255, 255, 255));
        rSPanelMaterial1.setPixels(0);
        rSPanelMaterial1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(102, 102, 102));
        jLabel13.setText("Crear Cuenta Docente");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 520, -1, -1));

        textFieldClave2.setForeground(new java.awt.Color(0, 51, 102));
        textFieldClave2.setToolTipText("");
        textFieldClave2.setBorderColor(new java.awt.Color(0, 51, 102));
        textFieldClave2.setColorIcon(new java.awt.Color(102, 102, 255));
        textFieldClave2.setName("jTextFieldClave2"); // NOI18N
        textFieldClave2.setPlaceholder("Contraseña");
        jPanel2.add(textFieldClave2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 500, -1, -1));

        cb_ingles.setForeground(new java.awt.Color(0, 51, 102));
        cb_ingles.setText("Inglés");
        cb_ingles.setColorCheck(new java.awt.Color(102, 102, 255));
        cb_ingles.setName("cb_ingles"); // NOI18N
        jPanel2.add(cb_ingles, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 120, -1));

        cb_EduTrabajo.setForeground(new java.awt.Color(0, 51, 102));
        cb_EduTrabajo.setText("Educación para el Trabajo");
        cb_EduTrabajo.setColorCheck(new java.awt.Color(102, 102, 255));
        cb_EduTrabajo.setName("cb_EduTrabajo"); // NOI18N
        jPanel2.add(cb_EduTrabajo, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 210, 230, -1));

        cb_CiudadaniaCivica.setForeground(new java.awt.Color(0, 51, 102));
        cb_CiudadaniaCivica.setText("Desarrollo Personal Ciudadanía y Cívica");
        cb_CiudadaniaCivica.setColorCheck(new java.awt.Color(102, 102, 255));
        cb_CiudadaniaCivica.setName("cb_CiudadaniaCivica"); // NOI18N
        jPanel2.add(cb_CiudadaniaCivica, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 150, 340, -1));

        cb_computacion.setForeground(new java.awt.Color(0, 51, 102));
        cb_computacion.setText("Computación");
        cb_computacion.setColorCheck(new java.awt.Color(102, 102, 255));
        cb_computacion.setName("cb_computacion"); // NOI18N
        jPanel2.add(cb_computacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 150, 150, -1));

        cb_psicomotriz.setForeground(new java.awt.Color(0, 51, 102));
        cb_psicomotriz.setText("Psicomotriz");
        cb_psicomotriz.setColorCheck(new java.awt.Color(102, 102, 255));
        cb_psicomotriz.setName("cb_psicomotriz"); // NOI18N
        jPanel2.add(cb_psicomotriz, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, 130, -1));

        cb_ArteCultura.setForeground(new java.awt.Color(0, 51, 102));
        cb_ArteCultura.setText("Arte y Cultura");
        cb_ArteCultura.setColorCheck(new java.awt.Color(102, 102, 255));
        cb_ArteCultura.setName("cb_ArteCultura"); // NOI18N
        jPanel2.add(cb_ArteCultura, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 180, 150, -1));

        rSLabelTextIcon2.setForeground(new java.awt.Color(102, 102, 255));
        rSLabelTextIcon2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        rSLabelTextIcon2.setText("Datos Personales del Docente");
        rSLabelTextIcon2.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.ACCOUNT_BOX);
        jPanel2.add(rSLabelTextIcon2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Nombres");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 60, -1, -1));

        jTextFieldNumDocumento.setForeground(new java.awt.Color(0, 51, 102));
        jTextFieldNumDocumento.setToolTipText("");
        jTextFieldNumDocumento.setBorderColor(new java.awt.Color(0, 51, 102));
        jTextFieldNumDocumento.setCaretColor(new java.awt.Color(0, 51, 102));
        jTextFieldNumDocumento.setName("jTextFieldNumDocumento"); // NOI18N
        jTextFieldNumDocumento.setPhColor(new java.awt.Color(102, 102, 102));
        jTextFieldNumDocumento.setPlaceholder("Nº de Documento");
        jTextFieldNumDocumento.setSelectionColor(new java.awt.Color(0, 102, 102));
        jTextFieldNumDocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNumDocumentoActionPerformed(evt);
            }
        });
        jPanel2.add(jTextFieldNumDocumento, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 210, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Apellido Paterno");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 60, -1, -1));

        Jtxtnombre.setForeground(new java.awt.Color(0, 51, 102));
        Jtxtnombre.setBorderColor(new java.awt.Color(0, 51, 102));
        Jtxtnombre.setName("Jtxtnombre"); // NOI18N
        Jtxtnombre.setPhColor(new java.awt.Color(102, 102, 102));
        Jtxtnombre.setPlaceholder("Nombre");
        jPanel2.add(Jtxtnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 80, 210, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Apellido Materno");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 60, -1, -1));

        jTextFieldApellidoP.setForeground(new java.awt.Color(0, 51, 102));
        jTextFieldApellidoP.setBorderColor(new java.awt.Color(0, 51, 102));
        jTextFieldApellidoP.setName("jTextFieldApellidoP"); // NOI18N
        jTextFieldApellidoP.setPhColor(new java.awt.Color(102, 102, 102));
        jTextFieldApellidoP.setPlaceholder("Apellido Paterno");
        jPanel2.add(jTextFieldApellidoP, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 80, 210, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Nº de Documento");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Seleccione los cursos en los que se encuentra calificado:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

        jTextFieldRespuesta1.setForeground(new java.awt.Color(0, 51, 102));
        jTextFieldRespuesta1.setBorderColor(new java.awt.Color(0, 51, 102));
        jTextFieldRespuesta1.setName("jTextFieldRespuesta1"); // NOI18N
        jTextFieldRespuesta1.setPhColor(new java.awt.Color(102, 102, 102));
        jTextFieldRespuesta1.setPlaceholder("Respuesta 1");
        jPanel2.add(jTextFieldRespuesta1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, -1, 30));

        jTextFieldApellidoM.setForeground(new java.awt.Color(0, 51, 102));
        jTextFieldApellidoM.setBorderColor(new java.awt.Color(0, 51, 102));
        jTextFieldApellidoM.setName("jTextFieldApellidoM"); // NOI18N
        jTextFieldApellidoM.setPhColor(new java.awt.Color(102, 102, 102));
        jTextFieldApellidoM.setPlaceholder("Apellido Materno");
        jPanel2.add(jTextFieldApellidoM, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 80, 210, 30));

        jTextFieldRespuesta2.setForeground(new java.awt.Color(0, 51, 102));
        jTextFieldRespuesta2.setBorderColor(new java.awt.Color(0, 51, 102));
        jTextFieldRespuesta2.setName("jTextFieldRespuesta2"); // NOI18N
        jTextFieldRespuesta2.setPhColor(new java.awt.Color(102, 102, 102));
        jTextFieldRespuesta2.setPlaceholder("Respuesta 2");
        jPanel2.add(jTextFieldRespuesta2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 330, -1, 30));

        jTextFieldRespuesta3.setForeground(new java.awt.Color(0, 51, 102));
        jTextFieldRespuesta3.setBorderColor(new java.awt.Color(0, 51, 102));
        jTextFieldRespuesta3.setName("jTextFieldRespuesta3"); // NOI18N
        jTextFieldRespuesta3.setPhColor(new java.awt.Color(102, 102, 102));
        jTextFieldRespuesta3.setPlaceholder("Respuesta 3");
        jPanel2.add(jTextFieldRespuesta3, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 330, -1, 30));

        jbtnRegistrar.setBackground(new java.awt.Color(102, 102, 255));
        jbtnRegistrar.setBackgroundHover(new java.awt.Color(51, 51, 255));
        jbtnRegistrar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.VISIBILITY);
        jbtnRegistrar.setName("jbtnRegistrar"); // NOI18N
        jPanel2.add(jbtnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 500, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Ingrese 3 preguntas para la recuperación de su contraseña en caso de olvido.");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, -1, -1));

        cb_PersonalSocial.setForeground(new java.awt.Color(0, 51, 102));
        cb_PersonalSocial.setText("Persona Social");
        cb_PersonalSocial.setToolTipText("");
        cb_PersonalSocial.setColorCheck(new java.awt.Color(102, 102, 255));
        cb_PersonalSocial.setName("cb_PersonalSocial"); // NOI18N
        cb_PersonalSocial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_PersonalSocialActionPerformed(evt);
            }
        });
        jPanel2.add(cb_PersonalSocial, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 210, 150, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("Contraseña");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, -1, -1));

        cb_matematica.setForeground(new java.awt.Color(0, 51, 102));
        cb_matematica.setColorCheck(new java.awt.Color(102, 102, 255));
        cb_matematica.setLabel("Matemáticas");
        cb_matematica.setName("cb_matematica"); // NOI18N
        jPanel2.add(cb_matematica, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 180, 130, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("La contraseña debe de contener mayúsculas, munúsculas, números y simbolos especiales.");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, -1, -1));

        cb_religion1.setForeground(new java.awt.Color(0, 51, 102));
        cb_religion1.setText("Religión");
        cb_religion1.setColorCheck(new java.awt.Color(102, 102, 255));
        cb_religion1.setName("cb_religion1"); // NOI18N
        jPanel2.add(cb_religion1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 120, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 102, 102));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel11.setText("Verifique su contraseña");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 480, -1, -1));

        cb_CienciasSociales.setForeground(new java.awt.Color(0, 51, 102));
        cb_CienciasSociales.setText("Ciencias Sociales");
        cb_CienciasSociales.setColorCheck(new java.awt.Color(102, 102, 255));
        cb_CienciasSociales.setName("cb_CienciasSociales"); // NOI18N
        jPanel2.add(cb_CienciasSociales, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 150, 160, -1));

        jTextFieldClave.setForeground(new java.awt.Color(0, 51, 102));
        jTextFieldClave.setToolTipText("");
        jTextFieldClave.setBorderColor(new java.awt.Color(0, 51, 102));
        jTextFieldClave.setColorIcon(new java.awt.Color(102, 102, 255));
        jTextFieldClave.setName("jTextFieldClave"); // NOI18N
        jTextFieldClave.setPlaceholder("Contraseña");
        jPanel2.add(jTextFieldClave, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, -1, -1));

        cb_comunicacion.setForeground(new java.awt.Color(0, 51, 102));
        cb_comunicacion.setText("Comunicación");
        cb_comunicacion.setColorCheck(new java.awt.Color(102, 102, 255));
        cb_comunicacion.setName("cb_comunicacion"); // NOI18N
        cb_comunicacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_comunicacionActionPerformed(evt);
            }
        });
        jPanel2.add(cb_comunicacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, 140, -1));

        cb_EduFisica.setForeground(new java.awt.Color(0, 51, 102));
        cb_EduFisica.setText("Edu. Física");
        cb_EduFisica.setColorCheck(new java.awt.Color(102, 102, 255));
        cb_EduFisica.setName("cb_EduFisica"); // NOI18N
        cb_EduFisica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_EduFisicaActionPerformed(evt);
            }
        });
        jPanel2.add(cb_EduFisica, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 120, -1));

        jbtnRegistrar1.setBackground(new java.awt.Color(0, 204, 102));
        jbtnRegistrar1.setBackgroundHover(new java.awt.Color(0, 102, 51));
        jbtnRegistrar1.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.ADD_CIRCLE_OUTLINE);
        jbtnRegistrar1.setName("jbtnRegistrar"); // NOI18N
        jbtnRegistrar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnRegistrar1ActionPerformed(evt);
            }
        });
        jPanel2.add(jbtnRegistrar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 500, -1, -1));

        jTextFieldPregunta3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "¿Dónde realizaste tus prácticas docentes?", "¿Cuál es tu libro favorito?", "¿En qué año comenzaste a enseñar?", "¿Quién es tu héroe?", "¿Cuál fue tu primer número de tlf?", "¿Nombre de tu primera mascota?", "¿Nombre de tu mentor/a a docente?", "¿Titulo de tu proyecto de investigación?" }));
        jTextFieldPregunta3.setColorArrow(new java.awt.Color(153, 153, 255));
        jTextFieldPregunta3.setColorBoton(new java.awt.Color(102, 102, 255));
        jTextFieldPregunta3.setColorFondo(new java.awt.Color(102, 102, 255));
        jTextFieldPregunta3.setColorListaItems(new java.awt.Color(204, 204, 204));
        jTextFieldPregunta3.setColorSeleccion(new java.awt.Color(102, 102, 255));
        jPanel2.add(jTextFieldPregunta3, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 290, 320, -1));

        jTextFieldPregunta1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "¿Dónde realizaste tus prácticas docentes?", "¿Cuál es tu libro favorito?", "¿En qué año comenzaste a enseñar?", "¿Quién es tu héroe?", "¿Cuál fue tu primer número de tlf?", "¿Nombre de tu primera mascota?", "¿Nombre de tu mentor/a a docente?", "¿Titulo de tu proyecto de investigación?" }));
        jTextFieldPregunta1.setColorArrow(new java.awt.Color(153, 153, 255));
        jTextFieldPregunta1.setColorBoton(new java.awt.Color(102, 102, 255));
        jTextFieldPregunta1.setColorFondo(new java.awt.Color(102, 102, 255));
        jTextFieldPregunta1.setColorListaItems(new java.awt.Color(204, 204, 204));
        jTextFieldPregunta1.setColorSeleccion(new java.awt.Color(102, 102, 255));
        jPanel2.add(jTextFieldPregunta1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 320, -1));

        jTextFieldPregunta2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "¿Dónde realizaste tus prácticas docentes?", "¿Cuál es tu libro favorito?", "¿En qué año comenzaste a enseñar?", "¿Quién es tu héroe?", "¿Cuál fue tu primer número de tlf?", "¿Nombre de tu primera mascota?", "¿Nombre de tu mentor/a a docente?", "¿Titulo de tu proyecto de investigación?" }));
        jTextFieldPregunta2.setColorArrow(new java.awt.Color(153, 153, 255));
        jTextFieldPregunta2.setColorBoton(new java.awt.Color(102, 102, 255));
        jTextFieldPregunta2.setColorFondo(new java.awt.Color(102, 102, 255));
        jTextFieldPregunta2.setColorListaItems(new java.awt.Color(204, 204, 204));
        jTextFieldPregunta2.setColorSeleccion(new java.awt.Color(102, 102, 255));
        jPanel2.add(jTextFieldPregunta2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 290, 320, -1));

        cb_CienciaTecnologia1.setForeground(new java.awt.Color(0, 51, 102));
        cb_CienciaTecnologia1.setText("Ciencia y Tecnología");
        cb_CienciaTecnologia1.setColorCheck(new java.awt.Color(102, 102, 255));
        cb_CienciaTecnologia1.setName("cb_CienciaTecnologia"); // NOI18N
        jPanel2.add(cb_CienciaTecnologia1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 180, 190, -1));

        rSPanelMaterial1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1200, 560));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rSPanelMaterial1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rSPanelMaterial1, javax.swing.GroupLayout.PREFERRED_SIZE, 592, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldNumDocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNumDocumentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNumDocumentoActionPerformed

    private void cb_PersonalSocialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_PersonalSocialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_PersonalSocialActionPerformed

    private void cb_EduFisicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_EduFisicaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_EduFisicaActionPerformed

    private void cb_comunicacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_comunicacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_comunicacionActionPerformed

    private void jbtnRegistrar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnRegistrar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtnRegistrar1ActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public RSMaterialComponent.RSTextFieldTwo Jtxtnombre;
    public RSMaterialComponent.RSCheckBoxMaterial cb_ArteCultura;
    public RSMaterialComponent.RSCheckBoxMaterial cb_CienciaTecnologia1;
    public RSMaterialComponent.RSCheckBoxMaterial cb_CienciasSociales;
    public RSMaterialComponent.RSCheckBoxMaterial cb_CiudadaniaCivica;
    public RSMaterialComponent.RSCheckBoxMaterial cb_EduFisica;
    public RSMaterialComponent.RSCheckBoxMaterial cb_EduTrabajo;
    public RSMaterialComponent.RSCheckBoxMaterial cb_PersonalSocial;
    public RSMaterialComponent.RSCheckBoxMaterial cb_computacion;
    public RSMaterialComponent.RSCheckBoxMaterial cb_comunicacion;
    public RSMaterialComponent.RSCheckBoxMaterial cb_ingles;
    public RSMaterialComponent.RSCheckBoxMaterial cb_matematica;
    public RSMaterialComponent.RSCheckBoxMaterial cb_psicomotriz;
    public RSMaterialComponent.RSCheckBoxMaterial cb_religion1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    public RSMaterialComponent.RSTextFieldTwo jTextFieldApellidoM;
    public RSMaterialComponent.RSTextFieldTwo jTextFieldApellidoP;
    public RSMaterialComponent.RSPasswordIconTwo jTextFieldClave;
    public RSMaterialComponent.RSTextFieldTwo jTextFieldNumDocumento;
    public RSMaterialComponent.RSComboBox jTextFieldPregunta1;
    public RSMaterialComponent.RSComboBox jTextFieldPregunta2;
    public RSMaterialComponent.RSComboBox jTextFieldPregunta3;
    public RSMaterialComponent.RSTextFieldTwo jTextFieldRespuesta1;
    public RSMaterialComponent.RSTextFieldTwo jTextFieldRespuesta2;
    public RSMaterialComponent.RSTextFieldTwo jTextFieldRespuesta3;
    public RSMaterialComponent.RSButtonIconShadow jbtnRegistrar;
    public RSMaterialComponent.RSButtonIconShadow jbtnRegistrar1;
    private RSMaterialComponent.RSLabelTextIcon rSLabelTextIcon2;
    private RSMaterialComponent.RSPanelMaterial rSPanelMaterial1;
    public RSMaterialComponent.RSPasswordIconTwo textFieldClave2;
    // End of variables declaration//GEN-END:variables
}
