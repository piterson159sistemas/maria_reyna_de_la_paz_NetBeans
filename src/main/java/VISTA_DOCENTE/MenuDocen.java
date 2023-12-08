/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package VISTA_DOCENTE;


import VISTA_DIRECTIVO.*;
//import static VISTA_DOCENTE.MenuDocen.DISPOSE_ON_CLOSE;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author SARA
 */
public class MenuDocen extends javax.swing.JFrame {
    private void Cerrar(){//METODO PARA QUE PREGUNTE AL INTENTAR CERRAR LA APLICACION
         String botones[]= {"Cerrar","Cancelar"};
         int eleccion = JOptionPane.showOptionDialog(this,"¿Desea cerrar la aplicacion?","Titulo",0,0,null,botones,this);
         if(eleccion==JOptionPane.YES_OPTION){
             System.exit(0);
             setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         }else if(eleccion==JOptionPane.NO_OPTION){
             System.out.println("Se cancelo el cierre");
             setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // Evita que la ventana se cierre automáticamente
         }
         
     }
    /**
     * Creates new form MenuDirec
     */
    public MenuDocen() {
        initComponents();
        //this.pnlSlider.setPanelNormal(this.bienvenida);
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
        lblCodUsuario = new javax.swing.JLabel();
        imagenPerfil = new RSMaterialComponent.RSPanelBorderImage();
        lblNombreUsuario = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        btnRegistrar = new rsbuttom.RSButtonMetro();
        btnTutor = new rsbuttom.RSButtonMetro();
        Principal = new RSMaterialComponent.RSPanelMaterial();
        rSLabelTextIcon1 = new RSMaterialComponent.RSLabelTextIcon();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

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

        lblCodUsuario.setBackground(new java.awt.Color(102, 102, 102));
        lblCodUsuario.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblCodUsuario.setForeground(new java.awt.Color(102, 102, 102));
        lblCodUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCodUsuario.setText("Cod.USUARIO");

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

        lblNombreUsuario.setBackground(new java.awt.Color(102, 102, 102));
        lblNombreUsuario.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblNombreUsuario.setForeground(new java.awt.Color(102, 102, 102));
        lblNombreUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNombreUsuario.setText("Cod.USUARIO");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblCodUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(imagenPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 101, Short.MAX_VALUE))
                    .addComponent(lblNombreUsuario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(imagenPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCodUsuario)
                .addGap(18, 18, 18)
                .addComponent(lblNombreUsuario)
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));

        btnRegistrar.setBackground(new java.awt.Color(153, 153, 153));
        btnRegistrar.setText("REGISTRAR");
        btnRegistrar.setColorHover(new java.awt.Color(51, 102, 255));
        btnRegistrar.setColorNormal(new java.awt.Color(153, 153, 153));
        btnRegistrar.setColorPressed(new java.awt.Color(0, 102, 204));
        btnRegistrar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnRegistrar.setIconTextGap(10);
        btnRegistrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnRegistrarMousePressed(evt);
            }
        });
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnTutor.setBackground(new java.awt.Color(153, 153, 153));
        btnTutor.setText("TUTOR");
        btnTutor.setColorHover(new java.awt.Color(51, 102, 255));
        btnTutor.setColorNormal(new java.awt.Color(153, 153, 153));
        btnTutor.setColorPressed(new java.awt.Color(0, 102, 204));
        btnTutor.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnTutor.setIconTextGap(10);
        btnTutor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnTutorMousePressed(evt);
            }
        });
        btnTutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTutorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnRegistrar, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
            .addComponent(btnTutor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTutor, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(311, Short.MAX_VALUE))
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
                .addGap(142, 142, 142))
        );

        Principal.setBackground(new java.awt.Color(255, 255, 255));
        Principal.setIntensity(5);
        Principal.setRound(15);

        rSLabelTextIcon1.setForeground(new java.awt.Color(102, 102, 255));
        rSLabelTextIcon1.setText("Bienvenido/a");
        rSLabelTextIcon1.setFont(new java.awt.Font("Roboto Bold", 1, 48)); // NOI18N
        rSLabelTextIcon1.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.BUSINESS_CENTER);
        rSLabelTextIcon1.setSizeIcon(60.0F);

        javax.swing.GroupLayout PrincipalLayout = new javax.swing.GroupLayout(Principal);
        Principal.setLayout(PrincipalLayout);
        PrincipalLayout.setHorizontalGroup(
            PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1231, Short.MAX_VALUE)
            .addGroup(PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PrincipalLayout.createSequentialGroup()
                    .addGap(0, 21, Short.MAX_VALUE)
                    .addComponent(rSLabelTextIcon1, javax.swing.GroupLayout.PREFERRED_SIZE, 1190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 20, Short.MAX_VALUE)))
        );
        PrincipalLayout.setVerticalGroup(
            PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 682, Short.MAX_VALUE)
            .addGroup(PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PrincipalLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(rSLabelTextIcon1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(pnlMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Principal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Principal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addComponent(pnlMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(8, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        //System.out.println("administrar vista");
        /*Administrar adm=new Administrar(); //aqui instanciamos la vista
        //en esta linea instanciar su controlador
        
        Principal.removeAll();
        Principal.setLayout(new BorderLayout());
        Principal.add(adm.getContentPane(),BorderLayout.CENTER);
        Principal.revalidate();
        Principal.repaint();*/
        
        if(this.btnRegistrar.isSelected()){
            this.btnRegistrar.setSelected(true);
            this.btnTutor.setSelected(false);
            
            
            //this.pnlSlider.setPanelNormal(this.pnlAdministrar);
        }
        
        if(this.btnRegistrar.isSelected()){
            this.btnRegistrar.setColorNormal(new Color(0,102,204));
            this.btnRegistrar.setColorHover(new Color(0,102,204));
            this.btnRegistrar.setColorPressed(new Color(0,102,204));
            
            
            this.btnTutor.setColorNormal(new Color(153,153,153));
            this.btnTutor.setColorHover(new Color(0,102,204));
            this.btnTutor.setColorPressed(new Color(153,153,153));
            
           
        }else{
            this.btnRegistrar.setColorNormal(new Color(153,153,153));
            this.btnRegistrar.setColorHover(new Color(0,102,204));
            this.btnRegistrar.setColorPressed(new Color(153,153,153));
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnTutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTutorActionPerformed
        /*Docente doc=new Docente();
        //en esta linea llamar a su controlador
        Principal.removeAll();
        Principal.setLayout(new BorderLayout());
        Principal.add(doc.getContentPane(),BorderLayout.CENTER);
        Principal.revalidate();
        Principal.repaint();*/
        
        if(this.btnTutor.isSelected()){
            this.btnRegistrar.setSelected(false);
            this.btnTutor.setSelected(true);
            
            
            //this.pnlSlider.setPanelNormal(this.pnlCrearCuentaDocente);
        }
        
        if(this.btnTutor.isSelected()){
            this.btnTutor.setColorNormal(new Color(0,102,204));
            this.btnTutor.setColorHover(new Color(0,102,204));
            this.btnTutor.setColorPressed(new Color(0,102,204));
            
            this.btnRegistrar.setColorNormal(new Color(153,153,153));
            this.btnRegistrar.setColorHover(new Color(0,102,204));
            this.btnRegistrar.setColorPressed(new Color(153,153,153));
            
          
        }else{
            this.btnTutor.setColorNormal(new Color(153,153,153));
            this.btnTutor.setColorHover(new Color(0,102,204));
            this.btnTutor.setColorPressed(new Color(153,153,153));
        }
    }//GEN-LAST:event_btnTutorActionPerformed

    
    
    
    
    private void btnRegistrarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrarMousePressed
        this.btnTutor.setSelected(false);
        this.btnRegistrar.setSelected(true);
        
    }//GEN-LAST:event_btnRegistrarMousePressed

    private void btnTutorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTutorMousePressed
        this.btnTutor.setSelected(true);
        this.btnRegistrar.setSelected(false);
        
    }//GEN-LAST:event_btnTutorMousePressed

    
    
    
    
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        Cerrar();
    }//GEN-LAST:event_formWindowClosing

    
    
    
    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public RSMaterialComponent.RSPanelMaterial Principal;
    public rsbuttom.RSButtonMetro btnRegistrar;
    public rsbuttom.RSButtonMetro btnTutor;
    public RSMaterialComponent.RSPanelBorderImage imagenPerfil;
    public javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public javax.swing.JPanel jPanel4;
    public javax.swing.JPanel jPanel5;
    public javax.swing.JLabel lblCodUsuario;
    public javax.swing.JLabel lblNombreUsuario;
    public javax.swing.JPanel pnlMenu;
    private RSMaterialComponent.RSLabelTextIcon rSLabelTextIcon1;
    // End of variables declaration//GEN-END:variables
}