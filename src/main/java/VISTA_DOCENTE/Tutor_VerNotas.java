/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package VISTA_DOCENTE;

import VISTA_DIRECTIVO.*;

/**
 *
 * @author SARA
 */
public class Tutor_VerNotas extends javax.swing.JFrame {

    /**
     * Creates new form frameejemplo
     */
    public Tutor_VerNotas() {
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
        rSPanelMaterial2 = new RSMaterialComponent.RSPanelMaterial();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        rSLabelTextIcon1 = new RSMaterialComponent.RSLabelTextIcon();
        rSPanelMaterial3 = new RSMaterialComponent.RSPanelMaterial();
        jLabel4 = new javax.swing.JLabel();
        jComboBox6 = new RSMaterialComponent.RSComboBox();
        rSButtonIconShadow1 = new RSMaterialComponent.RSButtonIconShadow();
        rSButtonIconShadow2 = new RSMaterialComponent.RSButtonIconShadow();
        rSButtonIconShadow3 = new RSMaterialComponent.RSButtonIconShadow();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jComboBox5 = new RSMaterialComponent.RSComboBox();
        rSComboBox3 = new RSMaterialComponent.RSComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        rSTableMetroCustom1 = new RSMaterialComponent.RSTableMetroCustom();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        rSPanelMaterial1.setBackground(new java.awt.Color(255, 255, 255));
        rSPanelMaterial1.setAutoscrolls(true);
        rSPanelMaterial1.setBgShade(new java.awt.Color(255, 255, 255));
        rSPanelMaterial1.setPixels(0);
        rSPanelMaterial1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rSPanelMaterial2.setBackground(new java.awt.Color(255, 255, 255));
        rSPanelMaterial2.setBgShade(new java.awt.Color(255, 255, 255));
        rSPanelMaterial2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Institución Educativa Privada");
        rSPanelMaterial2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, 600, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("MARIA REYNA DE LA PAZ");
        rSPanelMaterial2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 40, 600, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("FILTRAR EL NOMBRE DEL CURSO Y EL BIMESTRE");
        rSPanelMaterial2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 70, 600, -1));

        rSLabelTextIcon1.setForeground(new java.awt.Color(102, 102, 255));
        rSLabelTextIcon1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        rSLabelTextIcon1.setText("Ver Registro de Notas");
        rSLabelTextIcon1.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EXTENSION);
        rSPanelMaterial2.add(rSLabelTextIcon1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jPanel2.add(rSPanelMaterial2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1160, 120));

        rSPanelMaterial3.setBackground(new java.awt.Color(255, 255, 255));
        rSPanelMaterial3.setBgShade(new java.awt.Color(255, 255, 255));
        rSPanelMaterial3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Grado");
        rSPanelMaterial3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 210, -1));

        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "  " }));
        jComboBox6.setColorArrow(new java.awt.Color(153, 153, 255));
        jComboBox6.setColorBorde(new java.awt.Color(58, 66, 225));
        jComboBox6.setColorBoton(new java.awt.Color(102, 102, 255));
        jComboBox6.setColorFondo(new java.awt.Color(102, 102, 255));
        jComboBox6.setColorListaItems(new java.awt.Color(204, 204, 204));
        jComboBox6.setColorSeleccion(new java.awt.Color(102, 102, 255));
        rSPanelMaterial3.add(jComboBox6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        rSButtonIconShadow1.setBackground(new java.awt.Color(0, 102, 204));
        rSButtonIconShadow1.setBackgroundHover(new java.awt.Color(0, 51, 102));
        rSButtonIconShadow1.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.FILTER_LIST);
        rSPanelMaterial3.add(rSButtonIconShadow1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 270, -1, -1));

        rSButtonIconShadow2.setBackground(new java.awt.Color(255, 102, 102));
        rSButtonIconShadow2.setBackgroundHover(new java.awt.Color(204, 0, 0));
        rSButtonIconShadow2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        rSButtonIconShadow2.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.RATE_REVIEW);
        rSPanelMaterial3.add(rSButtonIconShadow2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 320, -1, -1));

        rSButtonIconShadow3.setBackground(new java.awt.Color(255, 153, 51));
        rSButtonIconShadow3.setBackgroundHover(new java.awt.Color(145, 72, 0));
        rSButtonIconShadow3.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.COMMENT);
        rSPanelMaterial3.add(rSButtonIconShadow3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 370, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Bimestre");
        rSPanelMaterial3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 200, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Área");
        rSPanelMaterial3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 200, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("Exportar a PDF");
        rSPanelMaterial3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 340, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("Resumen del Bimestre");
        rSPanelMaterial3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setText("Filtro");
        rSPanelMaterial3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 290, -1, -1));

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "   " }));
        jComboBox5.setColorArrow(new java.awt.Color(153, 153, 255));
        jComboBox5.setColorBorde(new java.awt.Color(58, 66, 225));
        jComboBox5.setColorBoton(new java.awt.Color(102, 102, 255));
        jComboBox5.setColorFondo(new java.awt.Color(102, 102, 255));
        jComboBox5.setColorListaItems(new java.awt.Color(204, 204, 204));
        jComboBox5.setColorSeleccion(new java.awt.Color(102, 102, 255));
        rSPanelMaterial3.add(jComboBox5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        rSComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "  " }));
        rSComboBox3.setColorArrow(new java.awt.Color(153, 153, 255));
        rSComboBox3.setColorBorde(new java.awt.Color(58, 66, 225));
        rSComboBox3.setColorBoton(new java.awt.Color(102, 102, 255));
        rSComboBox3.setColorFondo(new java.awt.Color(102, 102, 255));
        rSComboBox3.setColorListaItems(new java.awt.Color(204, 204, 204));
        rSComboBox3.setColorSeleccion(new java.awt.Color(102, 102, 255));
        rSPanelMaterial3.add(rSComboBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, -1));

        jPanel2.add(rSPanelMaterial3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 240, 420));

        rSTableMetroCustom1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        rSTableMetroCustom1.setBackgoundHead(new java.awt.Color(102, 102, 255));
        rSTableMetroCustom1.setBackgoundHover(new java.awt.Color(153, 153, 255));
        jScrollPane1.setViewportView(rSTableMetroCustom1);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 120, 910, 410));

        rSPanelMaterial1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1200, 560));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rSPanelMaterial1, javax.swing.GroupLayout.DEFAULT_SIZE, 1226, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rSPanelMaterial1, javax.swing.GroupLayout.PREFERRED_SIZE, 592, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public RSMaterialComponent.RSComboBox jComboBox5;
    public RSMaterialComponent.RSComboBox jComboBox6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    public RSMaterialComponent.RSButtonIconShadow rSButtonIconShadow1;
    public RSMaterialComponent.RSButtonIconShadow rSButtonIconShadow2;
    public RSMaterialComponent.RSButtonIconShadow rSButtonIconShadow3;
    public RSMaterialComponent.RSComboBox rSComboBox3;
    private RSMaterialComponent.RSLabelTextIcon rSLabelTextIcon1;
    private RSMaterialComponent.RSPanelMaterial rSPanelMaterial1;
    private RSMaterialComponent.RSPanelMaterial rSPanelMaterial2;
    private RSMaterialComponent.RSPanelMaterial rSPanelMaterial3;
    public RSMaterialComponent.RSTableMetroCustom rSTableMetroCustom1;
    // End of variables declaration//GEN-END:variables
}
