package Visão;

import Controle.CCategoria;
import Modelo.MCategoria;
import Modelo.MUsuario;

public class ICategoria extends javax.swing.JFrame {

    MCategoria modCategoria = new MCategoria();
    CCategoria categoria = new CCategoria();
    String usuario = TelaLogin.getUsuario();
    private boolean isEdit;
    private Integer codCat;

    public ICategoria() {
        initComponents();
        cxbAtiva.setEnabled(false);
        txtDescricao.requestFocus();
    }

    public ICategoria(MCategoria categ) {
        initComponents();
        txtDescricao.setText(categ.getDescricao());
        cxbAtiva.setSelected(categ.getAtivo() == 1);
        codCat = categ.getCodcat();
        isEdit = true;
        txtDescricao.requestFocus();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbDescricao = new javax.swing.JLabel();
        txtDescricao = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        cxbAtiva = new javax.swing.JCheckBox();
        btSalvar = new javax.swing.JButton();
        btSair = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Categoria");
        setPreferredSize(new java.awt.Dimension(310, 310));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(310, 285));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbDescricao.setText("*Descrição:");
        jPanel1.add(lbDescricao, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 122, 79, -1));

        txtDescricao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtDescricao.setBorder(null);
        jPanel1.add(txtDescricao, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 280, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 168, 285, 10));

        cxbAtiva.setBackground(new java.awt.Color(255, 255, 255));
        cxbAtiva.setSelected(true);
        cxbAtiva.setText("Ativa");
        jPanel1.add(cxbAtiva, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 65, -1));

        btSalvar.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        btSalvar.setText("SALVAR");
        btSalvar.setAutoscrolls(true);
        btSalvar.setBorder(null);
        btSalvar.setContentAreaFilled(false);
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });
        jPanel1.add(btSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 240, 80, 30));

        btSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/ic_clear_black_24dp_1x.png"))); // NOI18N
        btSair.setAutoscrolls(true);
        btSair.setContentAreaFilled(false);
        btSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSairActionPerformed(evt);
            }
        });
        jPanel1.add(btSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 240, 30, 30));

        jPanel2.setBackground(new java.awt.Color(255, 168, 52));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icon#2.png"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, 110, 120));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 310, 100));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        setSize(new java.awt.Dimension(310, 310));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        modCategoria.setDescricao(txtDescricao.getText());
        modCategoria.setAtivo(cxbAtiva.isSelected());
        modCategoria.setUsuario(usuario);
        if (categoria.validaCampos(modCategoria, isEdit)) {
            if (!isEdit) {
                categoria.Salvar(modCategoria);
            } else {
                modCategoria.setCodcat(codCat);
                categoria.Editar(modCategoria);
            }
            Categoria telaCategoria = Categoria.getInstance();
            telaCategoria.limpaTabela();
            telaCategoria.preencheTabela("select * from CATEGORIA  natural join USUARIO where CODUSU = " + usuario + " order by CODCAT");
            telaCategoria.setVisible(true);
            dispose();
        } else {
            txtDescricao.requestFocus();
        }
    }//GEN-LAST:event_btSalvarActionPerformed

    private void btSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairActionPerformed
        Categoria telaCategoria = Categoria.getInstance();
        telaCategoria.setEnabled(true);
        setVisible(false);
    }//GEN-LAST:event_btSairActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        Categoria telaCategoria = Categoria.getInstance();
        telaCategoria.setEnabled(true);
        telaCategoria.toFront();
        setVisible(false);
    }//GEN-LAST:event_formWindowClosed

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
            java.util.logging.Logger.getLogger(ICategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ICategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ICategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ICategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ICategoria().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btSair;
    private javax.swing.JButton btSalvar;
    private javax.swing.JCheckBox cxbAtiva;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbDescricao;
    private javax.swing.JTextField txtDescricao;
    // End of variables declaration//GEN-END:variables
}
