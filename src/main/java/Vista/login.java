/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author JESSY
 */
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

        jPanel2 = new javax.swing.JPanel();
        btnCambiarClave = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnIngresarDire = new javax.swing.JButton();
        txtClave = new javax.swing.JPasswordField();
        txtCod = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnIngresarProfe = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 204, 204));
        jPanel2.setLayout(null);

        btnCambiarClave.setText("Cambiar contraseña");
        btnCambiarClave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarClaveActionPerformed(evt);
            }
        });
        jPanel2.add(btnCambiarClave);
        btnCambiarClave.setBounds(130, 400, 160, 50);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel1.setText("LOGIN");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(140, 30, 148, 64);

        btnIngresarDire.setText("Ingresar Directivo");
        btnIngresarDire.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarDireActionPerformed(evt);
            }
        });
        jPanel2.add(btnIngresarDire);
        btnIngresarDire.setBounds(220, 280, 160, 50);

        txtClave.setEchoChar('\u25cf');
        txtClave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClaveActionPerformed(evt);
            }
        });
        jPanel2.add(txtClave);
        txtClave.setBounds(210, 210, 190, 30);
        jPanel2.add(txtCod);
        txtCod.setBounds(210, 140, 190, 30);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("¿Olvido su contraseña?");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(110, 360, 195, 25);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Ingresar Codigo:");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(10, 140, 140, 25);

        btnIngresarProfe.setText("Ingresar Profesor");
        btnIngresarProfe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarProfeActionPerformed(evt);
            }
        });
        jPanel2.add(btnIngresarProfe);
        btnIngresarProfe.setBounds(20, 280, 160, 50);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Ingresar Contraseña:");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(10, 210, 176, 25);

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 410, 470));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtClaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClaveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtClaveActionPerformed

    private void btnIngresarProfeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarProfeActionPerformed
               //Creamos variables Usuario y Contra:)
        String Usuario = "DO12345";
        String Contraseña = "123";
        //Ahora para obtener los valores de txtContrasena
        String Pass = new String(txtClave.getPassword());
        //Creamos las Validaciones
        //lo que se digite en el campo usuario  y campo contrasena es correcto iniciar ir a la siguiente interfaz
        if(txtCod.getText().equals(Usuario)&& Pass.equals(Contraseña)){

            ////Siguiente interfaz usando el boton ingresar directivo SI ES CORRECTO EL USUARIO Y CONTRA
        this.setVisible(false);
        MenuDocente menuDocente= new MenuDocente();
        menuDocente.setVisible(true);
        }else{ //y si no pues mensaje de error
            JOptionPane.showMessageDialog(this,"Usuario/Contraseña incorrecta >:)");
        }

    
    }//GEN-LAST:event_btnIngresarProfeActionPerformed

    private void btnIngresarDireActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarDireActionPerformed
        //Creamos variables Usuario y Contra:)
        String Usuario = "D72549418";
        String Contraseña = "123";
        //Ahora para obtener los valores de txtContrasena
        String Pass = new String(txtClave.getPassword());
        //Creamos las Validaciones
        //lo que se digite en el campo usuario  y campo contrasena es correcto iniciar ir a la siguiente interfaz
        if(txtCod.getText().equals(Usuario)&& Pass.equals(Contraseña)){

            ////Siguiente interfaz usando el boton ingresar directivo SI ES CORRECTO EL USUARIO Y CONTRA
            this.setVisible(false);
            MenuDirec menu = new MenuDirec();
            menu.setVisible(true);
        }else{ //y si no pues mensaje de error
            JOptionPane.showMessageDialog(this,"Usuario/Contraseña incorrecta >:)");
        }

    }//GEN-LAST:event_btnIngresarDireActionPerformed

    private void btnCambiarClaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarClaveActionPerformed
        recopilar_codigo_cambioContraseña RcopilarCodigoC = new recopilar_codigo_cambioContraseña();
        RcopilarCodigoC.setVisible(true);
    }//GEN-LAST:event_btnCambiarClaveActionPerformed

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
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
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnCambiarClave;
    public javax.swing.JButton btnIngresarDire;
    public javax.swing.JButton btnIngresarProfe;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    public javax.swing.JPasswordField txtClave;
    public javax.swing.JTextField txtCod;
    // End of variables declaration//GEN-END:variables


}
