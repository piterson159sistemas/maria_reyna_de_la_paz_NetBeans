/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package VISTA_DIRECTIVO;

import java.awt.BorderLayout;
import Controlador.*;
import java.awt.event.ActionListener;

/**
 *
 * @author SARA
 */
public class Administrar extends javax.swing.JFrame {

    /**
     * Creates new form frameejemplo
     */
    public Administrar() {
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
        jPanel1 = new javax.swing.JPanel();
        rSLabelTextIcon1 = new RSMaterialComponent.RSLabelTextIcon();
        tab1 = new newscomponents.RSButtonIcon_new();
        tab2 = new newscomponents.RSButtonIcon_new();
        Principal = new javax.swing.JPanel();
        rSLabelTextIcon2 = new RSMaterialComponent.RSLabelTextIcon();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        rSPanelMaterial1.setBackground(new java.awt.Color(255, 255, 255));
        rSPanelMaterial1.setBgShade(new java.awt.Color(255, 255, 255));
        rSPanelMaterial1.setRound(30);
        rSPanelMaterial1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 4, 0, new java.awt.Color(153, 153, 153)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rSLabelTextIcon1.setForeground(new java.awt.Color(102, 102, 255));
        rSLabelTextIcon1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        rSLabelTextIcon1.setText("Administrar Cuentas");
        rSLabelTextIcon1.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.FOLDER);
        jPanel1.add(rSLabelTextIcon1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 1194, -1));

        tab1.setBackground(new java.awt.Color(187, 187, 187));
        tab1.setText("Docente");
        tab1.setBackgroundHover(new java.awt.Color(102, 102, 255));
        tab1.setForegroundHover(new java.awt.Color(204, 204, 255));
        tab1.setForegroundIcon(new java.awt.Color(102, 102, 102));
        tab1.setForegroundIconHover(new java.awt.Color(204, 204, 255));
        tab1.setForegroundText(new java.awt.Color(102, 102, 102));
        tab1.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.ACCOUNT_BOX);
        tab1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tab1ActionPerformed(evt);
            }
        });
        jPanel1.add(tab1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 52, 139, -1));

        tab2.setBackground(new java.awt.Color(187, 187, 187));
        tab2.setText("Tutor");
        tab2.setBackgroundHover(new java.awt.Color(102, 102, 255));
        tab2.setForegroundHover(new java.awt.Color(204, 204, 255));
        tab2.setForegroundIcon(new java.awt.Color(102, 102, 102));
        tab2.setForegroundIconHover(new java.awt.Color(204, 204, 255));
        tab2.setForegroundText(new java.awt.Color(102, 102, 102));
        tab2.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.FOLDER_SHARED);
        tab2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tab2ActionPerformed(evt);
            }
        });
        jPanel1.add(tab2, new org.netbeans.lib.awtextra.AbsoluteConstraints(145, 52, 139, -1));

        rSPanelMaterial1.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1200, 100));

        Principal.setBackground(new java.awt.Color(255, 255, 255));

        rSLabelTextIcon2.setForeground(new java.awt.Color(102, 102, 255));
        rSLabelTextIcon2.setText("Administrar Cuentas");
        rSLabelTextIcon2.setFont(new java.awt.Font("Roboto Bold", 1, 48)); // NOI18N
        rSLabelTextIcon2.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.FOLDER);
        rSLabelTextIcon2.setSizeIcon(60.0F);

        javax.swing.GroupLayout PrincipalLayout = new javax.swing.GroupLayout(Principal);
        Principal.setLayout(PrincipalLayout);
        PrincipalLayout.setHorizontalGroup(
            PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rSLabelTextIcon2, javax.swing.GroupLayout.DEFAULT_SIZE, 1194, Short.MAX_VALUE))
        );
        PrincipalLayout.setVerticalGroup(
            PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rSLabelTextIcon2, javax.swing.GroupLayout.DEFAULT_SIZE, 548, Short.MAX_VALUE)
                .addContainerGap())
        );

        rSPanelMaterial1.add(Principal, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 1200, 560));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rSPanelMaterial1, javax.swing.GroupLayout.DEFAULT_SIZE, 1226, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rSPanelMaterial1, javax.swing.GroupLayout.DEFAULT_SIZE, 681, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tab1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tab1ActionPerformed
        Administrar_Docente1 admDOC=new Administrar_Docente1(); 
        CGestionarD contolador=new CGestionarD(admDOC);
        //instanciar controlador de administrar docente        
        Principal.removeAll();
        Principal.setLayout(new BorderLayout());
        Principal.add(admDOC.getContentPane(),BorderLayout.CENTER);
        Principal.revalidate();
        Principal.repaint();
        //System.out.println("hola yo soy la vista1");
        if(this.tab1.isSelected()){
            this.tab1.setSelected(true);
            this.tab2.setSelected(false);
        }
    }//GEN-LAST:event_tab1ActionPerformed

    private void tab2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tab2ActionPerformed
        Administrar_Tutor1 admTUT=new Administrar_Tutor1();
        //instanciar controlador de administrar docente
        Principal.removeAll();
        Principal.setLayout(new BorderLayout());
        Principal.add(admTUT.getContentPane(),BorderLayout.CENTER);
        Principal.revalidate();
        Principal.repaint();
      
        if(this.tab2.isSelected()){
            this.tab2.setSelected(true);
            this.tab1.setSelected(false);

        }
    }//GEN-LAST:event_tab2ActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JPanel Principal;
    private javax.swing.JPanel jPanel1;
    private RSMaterialComponent.RSLabelTextIcon rSLabelTextIcon1;
    private RSMaterialComponent.RSLabelTextIcon rSLabelTextIcon2;
    private RSMaterialComponent.RSPanelMaterial rSPanelMaterial1;
    public newscomponents.RSButtonIcon_new tab1;
    public newscomponents.RSButtonIcon_new tab2;
    // End of variables declaration//GEN-END:variables
}
