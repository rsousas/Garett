/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visão;

import Controle.CConexaoBD;
import Controle.CUsuario;
import Modelo.MUsuario;
import javax.swing.JOptionPane;

/**
 *
 * @author Gabriela Filete
 */
public class TelaLogin extends javax.swing.JFrame {
    
    MUsuario modUsuario = new MUsuario();
    CUsuario usuario = new CUsuario();
    private static String CodUsu;
    /**
     * Creates new form Login
     */
    public TelaLogin() {
        initComponents();
        txtUsuario.requestFocus();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PainelQ = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        pswSenha = new javax.swing.JPasswordField();
        jSeparator3 = new javax.swing.JSeparator();
        lbSenha = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btAcessar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        btSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PainelQ.setBackground(new java.awt.Color(0, 0, 0));
        PainelQ.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/workstation.png"))); // NOI18N
        PainelQ.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(-140, -320, 670, 1130));

        getContentPane().add(PainelQ, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 530, 490));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setToolTipText("");
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(53, 111, 181));
        jLabel1.setText("E-mail");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, -1, -1));

        txtUsuario.setForeground(new java.awt.Color(32, 33, 36));
        txtUsuario.setBorder(null);
        txtUsuario.setCaretColor(new java.awt.Color(32, 33, 36));
        jPanel2.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, 310, 30));
        jPanel2.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 310, 320, -1));

        pswSenha.setForeground(new java.awt.Color(32, 33, 36));
        pswSenha.setToolTipText("");
        pswSenha.setBorder(null);
        pswSenha.setCaretColor(new java.awt.Color(32, 33, 36));
        jPanel2.add(pswSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 280, 320, 30));
        jPanel2.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 230, 320, -1));

        lbSenha.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbSenha.setForeground(new java.awt.Color(53, 111, 181));
        lbSenha.setText("Senha");
        jPanel2.add(lbSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, -1, -1));

        jButton1.setForeground(new java.awt.Color(153, 153, 153));
        jButton1.setText("Não possuo uma conta. Cadastrar-me.");
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 470, -1, -1));

        btAcessar.setBackground(new java.awt.Color(225, 91, 78));
        btAcessar.setForeground(new java.awt.Color(32, 33, 36));
        btAcessar.setText("Entrar");
        btAcessar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(225, 91, 78), 2));
        btAcessar.setContentAreaFilled(false);
        btAcessar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAcessarActionPerformed(evt);
            }
        });
        jPanel2.add(btAcessar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 350, 320, 30));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/onlinelogomaker-061817-1509-5100.png"))); // NOI18N
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, -1, -1));

        btSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/ic_clear_black_24dp_1x.png"))); // NOI18N
        btSair.setBorder(null);
        btSair.setBorderPainted(false);
        btSair.setContentAreaFilled(false);
        btSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSairActionPerformed(evt);
            }
        });
        jPanel2.add(btSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 5, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 0, 430, 490));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
                              
    public static synchronized String getUsuario() {
        return CodUsu;
    }

    public void setUsuario(String CodUsu) {
        this.CodUsu = CodUsu;
    }

    private void btAcessarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAcessarActionPerformed
        modUsuario.setUsuario(txtUsuario.getText());
        modUsuario.setSenha(pswSenha.getText());

       if (usuario.validaLogin(modUsuario)) {
            setUsuario(usuario.buscaCodigoUsu(modUsuario));
            Principal telaPrincipal = Principal.getInstance();
           // telaPrincipal.setExtendedState(6);
            telaPrincipal.setVisible(true);
            dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Dados Incorretos!");
            txtUsuario.requestFocus();
        }// TODO add your handling code here:
    }//GEN-LAST:event_btAcessarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        IUsuario telaCadUsuario = new IUsuario();
        telaCadUsuario.setVisible(true);
        dispose();// TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairActionPerformed
         System.exit(0); // TODO add your handling code here:
    }//GEN-LAST:event_btSairActionPerformed

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
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PainelQ;
    private javax.swing.JButton btAcessar;
    private javax.swing.JButton btSair;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lbSenha;
    private javax.swing.JPasswordField pswSenha;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
