/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vista.AdministrarCuenta;

/**
 *
 * @author SARA
 */
public class tabContent1 extends javax.swing.JPanel {

    /**
     * Creates new form tabContent
     */
    public tabContent1() {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_AsignarArea_registro = new RSMaterialComponent.RSTableMetroCustom();
        rSLabelTextIcon1 = new RSMaterialComponent.RSLabelTextIcon();
        rSTextFieldMaterialIcon1 = new RSMaterialComponent.RSTextFieldMaterialIcon();
        rSTextFieldTwo1 = new RSMaterialComponent.RSTextFieldTwo();
        rSTextFieldTwo2 = new RSMaterialComponent.RSTextFieldTwo();
        rSTextFieldTwo5 = new RSMaterialComponent.RSTextFieldTwo();
        rSTextFieldTwo3 = new RSMaterialComponent.RSTextFieldTwo();
        rSTextFieldTwo7 = new RSMaterialComponent.RSTextFieldTwo();
        rSTextFieldTwo4 = new RSMaterialComponent.RSTextFieldTwo();
        rSTextFieldTwo8 = new RSMaterialComponent.RSTextFieldTwo();
        rSTextFieldTwo6 = new RSMaterialComponent.RSTextFieldTwo();
        rSButtonIconShadow3 = new RSMaterialComponent.RSButtonIconShadow();
        rSButtonIconShadow2 = new RSMaterialComponent.RSButtonIconShadow();
        rSButtonIconShadow1 = new RSMaterialComponent.RSButtonIconShadow();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        tbl_AsignarArea_registro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Código", "Nombre", "Apellido P", " Apellido M", "Nº Documento", "Acceso"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, true, true, true, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_AsignarArea_registro.setBackgoundHead(new java.awt.Color(102, 102, 255));
        tbl_AsignarArea_registro.setBackgoundHover(new java.awt.Color(153, 153, 255));
        jScrollPane1.setViewportView(tbl_AsignarArea_registro);
        if (tbl_AsignarArea_registro.getColumnModel().getColumnCount() > 0) {
            tbl_AsignarArea_registro.getColumnModel().getColumn(5).setMinWidth(0);
            tbl_AsignarArea_registro.getColumnModel().getColumn(5).setPreferredWidth(0);
            tbl_AsignarArea_registro.getColumnModel().getColumn(5).setMaxWidth(0);
        }

        rSLabelTextIcon1.setForeground(new java.awt.Color(102, 102, 255));
        rSLabelTextIcon1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        rSLabelTextIcon1.setText("Docente");

        rSTextFieldMaterialIcon1.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        rSTextFieldMaterialIcon1.setForeground(new java.awt.Color(153, 153, 153));
        rSTextFieldMaterialIcon1.setColorIcon(new java.awt.Color(51, 51, 51));
        rSTextFieldMaterialIcon1.setColorMaterial(new java.awt.Color(153, 153, 153));
        rSTextFieldMaterialIcon1.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.SEARCH);
        rSTextFieldMaterialIcon1.setPlaceholder("Buscar");

        rSTextFieldTwo1.setForeground(new java.awt.Color(0, 51, 102));
        rSTextFieldTwo1.setToolTipText("");
        rSTextFieldTwo1.setBorderColor(new java.awt.Color(0, 51, 102));
        rSTextFieldTwo1.setCaretColor(new java.awt.Color(0, 51, 102));
        rSTextFieldTwo1.setPhColor(new java.awt.Color(102, 102, 102));
        rSTextFieldTwo1.setPlaceholder("Nº de Documento");
        rSTextFieldTwo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSTextFieldTwo1ActionPerformed(evt);
            }
        });

        rSTextFieldTwo2.setForeground(new java.awt.Color(0, 51, 102));
        rSTextFieldTwo2.setBorderColor(new java.awt.Color(0, 51, 102));
        rSTextFieldTwo2.setPhColor(new java.awt.Color(102, 102, 102));
        rSTextFieldTwo2.setPlaceholder("Nombre");

        rSTextFieldTwo5.setForeground(new java.awt.Color(0, 51, 102));
        rSTextFieldTwo5.setBorderColor(new java.awt.Color(0, 51, 102));
        rSTextFieldTwo5.setPhColor(new java.awt.Color(102, 102, 102));
        rSTextFieldTwo5.setPlaceholder("Pregunta 1");

        rSTextFieldTwo3.setForeground(new java.awt.Color(0, 51, 102));
        rSTextFieldTwo3.setBorderColor(new java.awt.Color(0, 51, 102));
        rSTextFieldTwo3.setPhColor(new java.awt.Color(102, 102, 102));
        rSTextFieldTwo3.setPlaceholder("Apellido Paterno");

        rSTextFieldTwo7.setForeground(new java.awt.Color(0, 51, 102));
        rSTextFieldTwo7.setBorderColor(new java.awt.Color(0, 51, 102));
        rSTextFieldTwo7.setPhColor(new java.awt.Color(102, 102, 102));
        rSTextFieldTwo7.setPlaceholder("Pregunta 2");

        rSTextFieldTwo4.setForeground(new java.awt.Color(0, 51, 102));
        rSTextFieldTwo4.setBorderColor(new java.awt.Color(0, 51, 102));
        rSTextFieldTwo4.setPhColor(new java.awt.Color(102, 102, 102));
        rSTextFieldTwo4.setPlaceholder("Apellido Materno");

        rSTextFieldTwo8.setForeground(new java.awt.Color(0, 51, 102));
        rSTextFieldTwo8.setBorderColor(new java.awt.Color(0, 51, 102));
        rSTextFieldTwo8.setPhColor(new java.awt.Color(102, 102, 102));
        rSTextFieldTwo8.setPlaceholder("Pregunta 3");

        rSTextFieldTwo6.setForeground(new java.awt.Color(0, 51, 102));
        rSTextFieldTwo6.setBorderColor(new java.awt.Color(0, 51, 102));
        rSTextFieldTwo6.setPhColor(new java.awt.Color(102, 102, 102));
        rSTextFieldTwo6.setPlaceholder("Acceso");

        rSButtonIconShadow3.setBackground(new java.awt.Color(255, 102, 102));
        rSButtonIconShadow3.setBackgroundHover(new java.awt.Color(204, 0, 0));
        rSButtonIconShadow3.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.DELETE_FOREVER);

        rSButtonIconShadow2.setBackground(new java.awt.Color(255, 204, 0));
        rSButtonIconShadow2.setBackgroundHover(new java.awt.Color(153, 102, 0));
        rSButtonIconShadow2.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.UPDATE);

        rSButtonIconShadow1.setBackground(new java.awt.Color(0, 204, 102));
        rSButtonIconShadow1.setBackgroundHover(new java.awt.Color(0, 102, 51));
        rSButtonIconShadow1.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.ADD_CIRCLE_OUTLINE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Nº de Documento");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Nombre");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Apellido Paterno");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Apellido Materno");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Pregunta 1");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Pregunta 2");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("Pregutna 3");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("Acceso");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rSTextFieldTwo1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rSTextFieldTwo2, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rSTextFieldTwo3, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel4)
                                    .addComponent(rSTextFieldTwo4, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(446, 446, 446))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rSTextFieldTwo5, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(rSTextFieldTwo7, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(rSTextFieldTwo8, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel8)
                                    .addComponent(rSTextFieldTwo6, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(rSButtonIconShadow1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rSButtonIconShadow2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rSButtonIconShadow3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rSLabelTextIcon1, javax.swing.GroupLayout.PREFERRED_SIZE, 814, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rSTextFieldMaterialIcon1, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rSLabelTextIcon1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rSTextFieldMaterialIcon1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rSTextFieldTwo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rSTextFieldTwo3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rSTextFieldTwo4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rSTextFieldTwo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(jLabel8))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(rSButtonIconShadow2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(rSButtonIconShadow3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(rSButtonIconShadow1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(rSTextFieldTwo5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(rSTextFieldTwo7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(rSTextFieldTwo8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(rSTextFieldTwo6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void rSTextFieldTwo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSTextFieldTwo1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rSTextFieldTwo1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private RSMaterialComponent.RSButtonIconShadow rSButtonIconShadow1;
    private RSMaterialComponent.RSButtonIconShadow rSButtonIconShadow2;
    private RSMaterialComponent.RSButtonIconShadow rSButtonIconShadow3;
    private RSMaterialComponent.RSLabelTextIcon rSLabelTextIcon1;
    private RSMaterialComponent.RSTextFieldMaterialIcon rSTextFieldMaterialIcon1;
    private RSMaterialComponent.RSTextFieldTwo rSTextFieldTwo1;
    private RSMaterialComponent.RSTextFieldTwo rSTextFieldTwo2;
    private RSMaterialComponent.RSTextFieldTwo rSTextFieldTwo3;
    private RSMaterialComponent.RSTextFieldTwo rSTextFieldTwo4;
    private RSMaterialComponent.RSTextFieldTwo rSTextFieldTwo5;
    private RSMaterialComponent.RSTextFieldTwo rSTextFieldTwo6;
    private RSMaterialComponent.RSTextFieldTwo rSTextFieldTwo7;
    private RSMaterialComponent.RSTextFieldTwo rSTextFieldTwo8;
    private RSMaterialComponent.RSTableMetroCustom tbl_AsignarArea_registro;
    // End of variables declaration//GEN-END:variables
}
