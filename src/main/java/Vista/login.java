/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;



import DAO.QueryLogin;
import javax.swing.JOptionPane;


public class login extends javax.swing.JFrame {

    public login() {
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

        rSAnimation1 = new rojeru_san.complementos.RSAnimation();
        rSPanelMaterialGradient1 = new RSMaterialComponent.RSPanelMaterialGradient();
        rSPanelMaterial1 = new RSMaterialComponent.RSPanelMaterial();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCod = new RSMaterialComponent.RSTextFieldIconOne();
        txtClave = new RSMaterialComponent.RSPasswordIconOne();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnIngresar = new RSMaterialComponent.RSButtonMaterialIconShadow();
        btnCambiarClave = new RSMaterialComponent.RSButtonMaterialIconShadow();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rSPanelMaterialGradient1.setBgShade(new java.awt.Color(102, 204, 255));
        rSPanelMaterialGradient1.setColorPrimario(new java.awt.Color(102, 204, 255));
        rSPanelMaterialGradient1.setColorSecundario(new java.awt.Color(0, 102, 255));
        rSPanelMaterialGradient1.setGradiente(RSMaterialComponent.RSPanelMaterialGradient.Gradiente.HORIZONTAL);
        rSPanelMaterialGradient1.setRound(15);
        rSPanelMaterialGradient1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rSPanelMaterial1.setBackground(new java.awt.Color(255, 255, 255));
        rSPanelMaterial1.setForeground(new java.awt.Color(153, 204, 255));
        rSPanelMaterial1.setBgShade(new java.awt.Color(0, 102, 153));
        rSPanelMaterial1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Institucion Educativa Privada");
        rSPanelMaterial1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("MARIA REYNA");
        rSPanelMaterial1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 120, 20));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("DE LA PAZ");
        rSPanelMaterial1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, -1, 20));

        rSPanelMaterialGradient1.add(rSPanelMaterial1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 440, 120));

        txtCod.setForeground(new java.awt.Color(0, 61, 123));
        txtCod.setBorderColor(new java.awt.Color(0, 51, 102));
        txtCod.setColorIcon(new java.awt.Color(51, 153, 255));
        txtCod.setPhColor(new java.awt.Color(0, 0, 0));
        txtCod.setPlaceholder("Código de Usuario");
        rSPanelMaterialGradient1.add(txtCod, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, -1, -1));

        txtClave.setForeground(new java.awt.Color(0, 61, 123));
        txtClave.setBorderColor(new java.awt.Color(0, 51, 102));
        txtClave.setColorIcon(new java.awt.Color(51, 153, 255));
        txtClave.setPhColor(new java.awt.Color(0, 0, 0));
        txtClave.setPlaceholder("Contraseña");
        rSPanelMaterialGradient1.add(txtClave, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 260, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 102));
        jLabel2.setText("Código de Usuario");
        rSPanelMaterialGradient1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 51, 102));
        jLabel3.setText("Contraseña");
        rSPanelMaterialGradient1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 240, -1, -1));

        btnIngresar.setBackground(new java.awt.Color(0, 102, 204));
        btnIngresar.setText("Ingresar");
        btnIngresar.setBackgroundHover(new java.awt.Color(0, 204, 255));
        btnIngresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnIngresar.setForegroundHover(new java.awt.Color(0, 61, 123));
        btnIngresar.setForegroundIcon(new java.awt.Color(0, 61, 123));
        btnIngresar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.ARROW_FORWARD);
        rSPanelMaterialGradient1.add(btnIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 350, 140, -1));

        btnCambiarClave.setBackground(new java.awt.Color(0, 86, 172));
        btnCambiarClave.setText("Cambiar contraseña");
        btnCambiarClave.setBackgroundHover(new java.awt.Color(0, 204, 255));
        btnCambiarClave.setForegroundHover(new java.awt.Color(0, 61, 123));
        btnCambiarClave.setForegroundIcon(new java.awt.Color(0, 61, 123));
        btnCambiarClave.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnCambiarClave.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.LOCK);
        rSPanelMaterialGradient1.add(btnCambiarClave, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 490, 200, -1));

        getContentPane().add(rSPanelMaterialGradient1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 570));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public RSMaterialComponent.RSButtonMaterialIconShadow btnCambiarClave;
    public RSMaterialComponent.RSButtonMaterialIconShadow btnIngresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private rojeru_san.complementos.RSAnimation rSAnimation1;
    private RSMaterialComponent.RSPanelMaterial rSPanelMaterial1;
    private RSMaterialComponent.RSPanelMaterialGradient rSPanelMaterialGradient1;
    public RSMaterialComponent.RSPasswordIconOne txtClave;
    public RSMaterialComponent.RSTextFieldIconOne txtCod;
    // End of variables declaration//GEN-END:variables


}
