/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visão;

import Controle.CConexaoBD;
import Controle.CUsuario;
import Modelo.MUsuario;

/**
 *
 * @author renat
 */
public class IUsuario extends javax.swing.JFrame {

    MUsuario modUsuario = new MUsuario();
    CUsuario usuario = new CUsuario();
    CConexaoBD conexao = new CConexaoBD();

    public IUsuario() {
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

        lbNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        lbUsuario = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        lbSenha = new javax.swing.JLabel();
        pswSenha = new javax.swing.JPasswordField();
        lbConfirmaSenha = new javax.swing.JLabel();
        pswConfirmaSenha = new javax.swing.JPasswordField();
        btSalvar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastro de Usuário");
        setResizable(false);
        getContentPane().setLayout(null);

        lbNome.setText("*Nome:");
        getContentPane().add(lbNome);
        lbNome.setBounds(38, 26, 50, 14);
        getContentPane().add(txtNome);
        txtNome.setBounds(43, 46, 299, 30);

        lbUsuario.setText("*Usuário:");
        getContentPane().add(lbUsuario);
        lbUsuario.setBounds(38, 84, 59, 14);
        getContentPane().add(txtUsuario);
        txtUsuario.setBounds(43, 103, 299, 30);

        lbSenha.setText("*Senha:");
        getContentPane().add(lbSenha);
        lbSenha.setBounds(43, 141, 52, 14);
        getContentPane().add(pswSenha);
        pswSenha.setBounds(43, 161, 140, 30);

        lbConfirmaSenha.setText("*Confirmar Senha:");
        getContentPane().add(lbConfirmaSenha);
        lbConfirmaSenha.setBounds(201, 141, 130, 14);
        getContentPane().add(pswConfirmaSenha);
        pswConfirmaSenha.setBounds(201, 161, 141, 30);

        btSalvar.setText("Salvar");
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });
        getContentPane().add(btSalvar);
        btSalvar.setBounds(40, 210, 80, 30);

        btCancelar.setText("Sair");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btCancelar);
        btCancelar.setBounds(130, 210, 80, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/fundotelaLogin.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 390, 260);

        setSize(new java.awt.Dimension(390, 290));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        modUsuario.setNome(txtNome.getText());
        modUsuario.setUsuario(txtUsuario.getText());
        modUsuario.setSenha(pswSenha.getText());
        modUsuario.setSenhaConfirma(pswConfirmaSenha.getText());
        if (usuario.validaCampos(modUsuario)) {
            usuario.Salvar(modUsuario);
            TelaLogin telaLogin = new TelaLogin();
            telaLogin.setVisible(true);
            dispose();
        } else {
            txtNome.requestFocus();
        }
    }//GEN-LAST:event_btSalvarActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        TelaLogin telaLogin = new TelaLogin();
        telaLogin.setVisible(true);
        dispose();
    }//GEN-LAST:event_btCancelarActionPerformed

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
            java.util.logging.Logger.getLogger(IUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbConfirmaSenha;
    private javax.swing.JLabel lbNome;
    private javax.swing.JLabel lbSenha;
    private javax.swing.JLabel lbUsuario;
    private javax.swing.JPasswordField pswConfirmaSenha;
    private javax.swing.JPasswordField pswSenha;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
