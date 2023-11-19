/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vista.Docente;

import java.awt.Color;

/**
 *
 * @author SARA
 */
public class Principal extends javax.swing.JPanel {

    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
        this.pnlSlider.setPanelNormal(this.pnlCrearCuentaPortada);
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
        rSLabelTextIcon1 = new RSMaterialComponent.RSLabelTextIcon();
        tab1 = new newscomponents.RSButtonIcon_new();
        pnlSlider = new newscomponents.RSPanelEffect();
        pnlCrearDocente = new Vista.Docente.tabContent();
        pnlCrearCuentaPortada = new Vista.Docente.tabContent2();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 4, 0, new java.awt.Color(102, 102, 102)));

        rSLabelTextIcon1.setForeground(new java.awt.Color(102, 102, 255));
        rSLabelTextIcon1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        rSLabelTextIcon1.setText("Crear Cuenta Docente");
        rSLabelTextIcon1.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.ACCOUNT_BOX);

        tab1.setBackground(new java.awt.Color(187, 187, 187));
        tab1.setText("Docente");
        tab1.setBackgroundHover(new java.awt.Color(102, 102, 255));
        tab1.setForegroundHover(new java.awt.Color(204, 204, 255));
        tab1.setForegroundIcon(new java.awt.Color(102, 102, 102));
        tab1.setForegroundIconHover(new java.awt.Color(204, 204, 255));
        tab1.setForegroundText(new java.awt.Color(102, 102, 102));
        tab1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tab1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(rSLabelTextIcon1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tab1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rSLabelTextIcon1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tab1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(266, 266, 266))
        );

        rSLabelTextIcon1.getAccessibleContext().setAccessibleName("Crear Docente");

        pnlSlider.setBackground(new java.awt.Color(255, 255, 255));

        pnlCrearDocente.setName("pnlCrearDocente"); // NOI18N
        pnlSlider.add(pnlCrearDocente, "card2");
        pnlSlider.add(pnlCrearCuentaPortada, "card3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlSlider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 563, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tab1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tab1ActionPerformed
        if(this.tab1.isSelected()){
            this.tab1.setSelected(true);
            
            //colores
           /* this.tab1.setBackground(new Color(102,102,255));        //tab1
            this.tab1.setForeground(new Color(204,204,255));
            this.tab1.setForegroundIcon(new Color(204,204,255));*/
           
        }
        this.pnlSlider.setPanelNormal(this.pnlCrearDocente);
    }//GEN-LAST:event_tab1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private Vista.Docente.tabContent2 pnlCrearCuentaPortada;
    private Vista.Docente.tabContent pnlCrearDocente;
    private newscomponents.RSPanelEffect pnlSlider;
    private RSMaterialComponent.RSLabelTextIcon rSLabelTextIcon1;
    private newscomponents.RSButtonIcon_new tab1;
    // End of variables declaration//GEN-END:variables
}
