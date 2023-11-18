/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

//import Animacion.Animacion;
import java.awt.Color;

/**
 *
 * @author SARA
 */
public class MenuDirec2 extends javax.swing.JFrame {

    /**
     * Creates new form MenuDirec
     */
    public MenuDirec2() {
        initComponents();
        this.pnlSlider.setPanelNormal(this.bienvenida);
        //setSize(1500,800);
        //this.setTitle("Directivo");
        //this.setLocationRelativeTo(this);
        //this.RSbtnAdministrarCuentas.setSelected(true);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        pnlMenu = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jlblUsuario = new javax.swing.JLabel();
        imagenPerfil = new RSMaterialComponent.RSPanelBorderImage();
        jPanel5 = new javax.swing.JPanel();
        btnAdministrarCuentas = new rsbuttom.RSButtonMetro();
        btnDocente = new rsbuttom.RSButtonMetro();
        btnEstudiantes = new rsbuttom.RSButtonMetro();
        btnAsignar = new rsbuttom.RSButtonMetro();
        rSPanelMaterial1 = new RSMaterialComponent.RSPanelMaterial();
        pnlSlider = new newscomponents.RSPanelEffect();
        pnlAdministrar = new Vista.AdministrarCuenta.Principal();
        pnlCrearCuentaDocente = new Vista.Docente.Principal();
        pnlAsignar = new Vista.Asignar.Principal();
        bienvenida = new Vista.Bienvenida();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(0, 102, 204));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 76, Short.MAX_VALUE)
        );

        pnlMenu.setBackground(new java.awt.Color(204, 204, 204));

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));

        jlblUsuario.setBackground(new java.awt.Color(102, 102, 102));
        jlblUsuario.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jlblUsuario.setForeground(new java.awt.Color(102, 102, 102));
        jlblUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblUsuario.setText("USUARIO");

        imagenPerfil.setShapePanel(rojeru_san.efectos.ValoresEnum.PANEL_FORMA.CIRCLE);

        javax.swing.GroupLayout imagenPerfilLayout = new javax.swing.GroupLayout(imagenPerfil);
        imagenPerfil.setLayout(imagenPerfilLayout);
        imagenPerfilLayout.setHorizontalGroup(
            imagenPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        imagenPerfilLayout.setVerticalGroup(
            imagenPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(imagenPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(78, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlblUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(imagenPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jlblUsuario)
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));

        btnAdministrarCuentas.setBackground(new java.awt.Color(153, 153, 153));
        btnAdministrarCuentas.setText("ADMINISTRAR CUENTAS");
        btnAdministrarCuentas.setColorHover(new java.awt.Color(51, 102, 255));
        btnAdministrarCuentas.setColorNormal(new java.awt.Color(153, 153, 153));
        btnAdministrarCuentas.setColorPressed(new java.awt.Color(0, 102, 204));
        btnAdministrarCuentas.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnAdministrarCuentas.setIconTextGap(10);
        btnAdministrarCuentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnAdministrarCuentasMousePressed(evt);
            }
        });
        btnAdministrarCuentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdministrarCuentasActionPerformed(evt);
            }
        });

        btnDocente.setBackground(new java.awt.Color(153, 153, 153));
        btnDocente.setText("DOCENTE");
        btnDocente.setColorHover(new java.awt.Color(51, 102, 255));
        btnDocente.setColorNormal(new java.awt.Color(153, 153, 153));
        btnDocente.setColorPressed(new java.awt.Color(0, 102, 204));
        btnDocente.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnDocente.setIconTextGap(10);
        btnDocente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnDocenteMousePressed(evt);
            }
        });
        btnDocente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDocenteActionPerformed(evt);
            }
        });

        btnEstudiantes.setBackground(new java.awt.Color(153, 153, 153));
        btnEstudiantes.setText("ESTUDIANTES");
        btnEstudiantes.setColorHover(new java.awt.Color(51, 102, 255));
        btnEstudiantes.setColorNormal(new java.awt.Color(153, 153, 153));
        btnEstudiantes.setColorPressed(new java.awt.Color(0, 102, 204));
        btnEstudiantes.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnEstudiantes.setIconTextGap(10);
        btnEstudiantes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnEstudiantesMousePressed(evt);
            }
        });
        btnEstudiantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEstudiantesActionPerformed(evt);
            }
        });

        btnAsignar.setBackground(new java.awt.Color(153, 153, 153));
        btnAsignar.setText("ASIGNAR");
        btnAsignar.setColorHover(new java.awt.Color(51, 102, 255));
        btnAsignar.setColorNormal(new java.awt.Color(153, 153, 153));
        btnAsignar.setColorPressed(new java.awt.Color(0, 102, 204));
        btnAsignar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnAsignar.setIconTextGap(10);
        btnAsignar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnAsignarMousePressed(evt);
            }
        });
        btnAsignar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsignarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnAdministrarCuentas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnDocente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnEstudiantes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnAsignar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAdministrarCuentas, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDocente, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEstudiantes, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAsignar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(315, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlMenuLayout = new javax.swing.GroupLayout(pnlMenu);
        pnlMenu.setLayout(pnlMenuLayout);
        pnlMenuLayout.setHorizontalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlMenuLayout.setVerticalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        rSPanelMaterial1.setBackground(new java.awt.Color(255, 255, 255));
        rSPanelMaterial1.setIntensity(5);
        rSPanelMaterial1.setRound(15);

        pnlSlider.setBackground(new java.awt.Color(255, 255, 255));
        pnlSlider.setName("pnlSlider"); // NOI18N

        pnlAdministrar.setName("pnlAdministrar"); // NOI18N
        pnlSlider.add(pnlAdministrar, "card2");

        pnlCrearCuentaDocente.setName("pnlCrearCuentaDocente"); // NOI18N
        pnlSlider.add(pnlCrearCuentaDocente, "card3");

        pnlAsignar.setName("pnlAsignar"); // NOI18N
        pnlSlider.add(pnlAsignar, "card4");

        bienvenida.setName("bienvenida"); // NOI18N
        pnlSlider.add(bienvenida, "card5");

        javax.swing.GroupLayout rSPanelMaterial1Layout = new javax.swing.GroupLayout(rSPanelMaterial1);
        rSPanelMaterial1.setLayout(rSPanelMaterial1Layout);
        rSPanelMaterial1Layout.setHorizontalGroup(
            rSPanelMaterial1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rSPanelMaterial1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(pnlSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 1153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
        );
        rSPanelMaterial1Layout.setVerticalGroup(
            rSPanelMaterial1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rSPanelMaterial1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(pnlSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 730, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(pnlMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rSPanelMaterial1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(rSPanelMaterial1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdministrarCuentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdministrarCuentasActionPerformed
        if(this.btnAdministrarCuentas.isSelected()){
            this.btnAdministrarCuentas.setSelected(true);
            this.btnDocente.setSelected(false);
            this.btnEstudiantes.setSelected(false);
            this.btnAsignar.setSelected(false);
            
            this.pnlSlider.setPanelNormal(this.pnlAdministrar);
        }
        
        if(this.btnAdministrarCuentas.isSelected()){
            this.btnAdministrarCuentas.setColorNormal(new Color(0,102,204));
            this.btnAdministrarCuentas.setColorHover(new Color(0,102,204));
            this.btnAdministrarCuentas.setColorPressed(new Color(0,102,204));
            
            
            this.btnDocente.setColorNormal(new Color(153,153,153));
            this.btnDocente.setColorHover(new Color(0,102,204));
            this.btnDocente.setColorPressed(new Color(153,153,153));
            
            this.btnAsignar.setColorNormal(new Color(153,153,153));
            this.btnAsignar.setColorHover(new Color(0,102,204));
            this.btnAsignar.setColorPressed(new Color(153,153,153));
            
            this.btnEstudiantes.setColorNormal(new Color(153,153,153));
            this.btnEstudiantes.setColorHover(new Color(0,102,204));
            this.btnEstudiantes.setColorPressed(new Color(153,153,153));
        }else{
            this.btnAdministrarCuentas.setColorNormal(new Color(153,153,153));
            this.btnAdministrarCuentas.setColorHover(new Color(0,102,204));
            this.btnAdministrarCuentas.setColorPressed(new Color(153,153,153));
        }
    }//GEN-LAST:event_btnAdministrarCuentasActionPerformed

    private void btnDocenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDocenteActionPerformed
        if(this.btnDocente.isSelected()){
            this.btnAdministrarCuentas.setSelected(false);
            this.btnDocente.setSelected(true);
            this.btnEstudiantes.setSelected(false);
            this.btnAsignar.setSelected(false);
            
            this.pnlSlider.setPanelNormal(this.pnlCrearCuentaDocente);
        }
        
        if(this.btnDocente.isSelected()){
            this.btnDocente.setColorNormal(new Color(0,102,204));
            this.btnDocente.setColorHover(new Color(0,102,204));
            this.btnDocente.setColorPressed(new Color(0,102,204));
            
            this.btnAdministrarCuentas.setColorNormal(new Color(153,153,153));
            this.btnAdministrarCuentas.setColorHover(new Color(0,102,204));
            this.btnAdministrarCuentas.setColorPressed(new Color(153,153,153));
            
            this.btnAsignar.setColorNormal(new Color(153,153,153));
            this.btnAsignar.setColorHover(new Color(0,102,204));
            this.btnAsignar.setColorPressed(new Color(153,153,153));
            
            this.btnEstudiantes.setColorNormal(new Color(153,153,153));
            this.btnEstudiantes.setColorHover(new Color(0,102,204));
            this.btnEstudiantes.setColorPressed(new Color(153,153,153));
        }else{
            this.btnDocente.setColorNormal(new Color(153,153,153));
            this.btnDocente.setColorHover(new Color(0,102,204));
            this.btnDocente.setColorPressed(new Color(153,153,153));
        }
    }//GEN-LAST:event_btnDocenteActionPerformed

    private void btnEstudiantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEstudiantesActionPerformed
        if(!this.btnEstudiantes.isSelected()){
            this.btnAdministrarCuentas.setSelected(false);
            this.btnDocente.setSelected(false);
            this.btnEstudiantes.setSelected(true);
            this.btnAsignar.setSelected(false);
        }
        
        if(this.btnEstudiantes.isSelected()){
            this.btnEstudiantes.setColorNormal(new Color(0,102,204));
            this.btnEstudiantes.setColorHover(new Color(0,102,204));
            this.btnEstudiantes.setColorPressed(new Color(0,102,204));
            
            this.btnAdministrarCuentas.setColorNormal(new Color(153,153,153));
            this.btnAdministrarCuentas.setColorHover(new Color(0,102,204));
            this.btnAdministrarCuentas.setColorPressed(new Color(153,153,153));
            
            this.btnAsignar.setColorNormal(new Color(153,153,153));
            this.btnAsignar.setColorHover(new Color(0,102,204));
            this.btnAsignar.setColorPressed(new Color(153,153,153));
            
            this.btnDocente.setColorNormal(new Color(153,153,153));
            this.btnDocente.setColorHover(new Color(0,102,204));
            this.btnDocente.setColorPressed(new Color(153,153,153));
        }else{
            this.btnEstudiantes.setColorNormal(new Color(153,153,153));
            this.btnEstudiantes.setColorHover(new Color(0,102,204));
            this.btnEstudiantes.setColorPressed(new Color(153,153,153));
        }
    }//GEN-LAST:event_btnEstudiantesActionPerformed

    private void btnAsignarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsignarActionPerformed
        if(this.btnAsignar.isSelected()){
            this.btnAdministrarCuentas.setSelected(false);
            this.btnDocente.setSelected(false);
            this.btnEstudiantes.setSelected(false);
            this.btnAsignar.setSelected(true);
            
            this.pnlSlider.setPanelNormal(this.pnlAsignar);
        }
        
        if(this.btnAsignar.isSelected()){
            this.btnAsignar.setColorNormal(new Color(0,102,204));
            this.btnAsignar.setColorHover(new Color(0,102,204));
            this.btnAsignar.setColorPressed(new Color(0,102,204));
            
            this.btnAdministrarCuentas.setColorNormal(new Color(153,153,153));
            this.btnAdministrarCuentas.setColorHover(new Color(0,102,204));
            this.btnAdministrarCuentas.setColorPressed(new Color(153,153,153));
            
            this.btnEstudiantes.setColorNormal(new Color(153,153,153));
            this.btnEstudiantes.setColorHover(new Color(0,102,204));
            this.btnEstudiantes.setColorPressed(new Color(153,153,153));
            
            this.btnDocente.setColorNormal(new Color(153,153,153));
            this.btnDocente.setColorHover(new Color(0,102,204));
            this.btnDocente.setColorPressed(new Color(153,153,153));
        }else{
            this.btnAsignar.setColorNormal(new Color(153,153,153));
            this.btnAsignar.setColorHover(new Color(0,102,204));
            this.btnAsignar.setColorPressed(new Color(153,153,153));
        }
    }//GEN-LAST:event_btnAsignarActionPerformed

    
    
    
    
    private void btnAdministrarCuentasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAdministrarCuentasMousePressed
        this.btnDocente.setSelected(false);
        this.btnAdministrarCuentas.setSelected(true);
        this.btnAsignar.setSelected(false);
        this.btnEstudiantes.setSelected(false);
    }//GEN-LAST:event_btnAdministrarCuentasMousePressed

    private void btnDocenteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDocenteMousePressed
        this.btnDocente.setSelected(true);
        this.btnAdministrarCuentas.setSelected(false);
        this.btnAsignar.setSelected(false);
        this.btnEstudiantes.setSelected(false);
    }//GEN-LAST:event_btnDocenteMousePressed

    private void btnEstudiantesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEstudiantesMousePressed
        this.btnDocente.setSelected(false);
        this.btnAdministrarCuentas.setSelected(false);
        this.btnAsignar.setSelected(false);
        this.btnEstudiantes.setSelected(true);
    }//GEN-LAST:event_btnEstudiantesMousePressed

    private void btnAsignarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAsignarMousePressed
        this.btnDocente.setSelected(false);
        this.btnAdministrarCuentas.setSelected(false);
        this.btnAsignar.setSelected(true);
        this.btnEstudiantes.setSelected(false);
    }//GEN-LAST:event_btnAsignarMousePressed

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
            java.util.logging.Logger.getLogger(MenuDirec2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuDirec2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuDirec2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuDirec2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuDirec2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Vista.Bienvenida bienvenida;
    public rsbuttom.RSButtonMetro btnAdministrarCuentas;
    public rsbuttom.RSButtonMetro btnAsignar;
    public rsbuttom.RSButtonMetro btnDocente;
    public rsbuttom.RSButtonMetro btnEstudiantes;
    public RSMaterialComponent.RSPanelBorderImage imagenPerfil;
    public javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public javax.swing.JPanel jPanel4;
    public javax.swing.JPanel jPanel5;
    public javax.swing.JLabel jlblUsuario;
    private Vista.AdministrarCuenta.Principal pnlAdministrar;
    private Vista.Asignar.Principal pnlAsignar;
    private Vista.Docente.Principal pnlCrearCuentaDocente;
    public javax.swing.JPanel pnlMenu;
    private newscomponents.RSPanelEffect pnlSlider;
    private RSMaterialComponent.RSPanelMaterial rSPanelMaterial1;
    // End of variables declaration//GEN-END:variables
}
