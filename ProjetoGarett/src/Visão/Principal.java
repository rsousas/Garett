/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visão;

/**
 *
 * @author renat
 */
public class Principal extends javax.swing.JFrame {
private static Principal instancia;

    /**
     * Creates new form Principal
     */
    public Principal() {
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

        jPanelMenuPrincipal = new javax.swing.JPanel();
        btTransacoes = new javax.swing.JButton();
        btContas = new javax.swing.JButton();
        btConfiguracoes = new javax.swing.JButton();
        btSair = new javax.swing.JButton();
        btContas1 = new javax.swing.JButton();
        jMenuBar3 = new javax.swing.JMenuBar();
        jMenu19 = new javax.swing.JMenu();
        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuItem3 = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuItem2 = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuItem4 = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuItem15 = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuItem16 = new javax.swing.JRadioButtonMenuItem();
        jMenu24 = new javax.swing.JMenu();
        jRadioButtonMenuItem5 = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuItem6 = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuItem7 = new javax.swing.JRadioButtonMenuItem();
        jMenu28 = new javax.swing.JMenu();
        jRadioButtonMenuItem8 = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuItem9 = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuItem10 = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuItem11 = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuItem12 = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuItem13 = new javax.swing.JRadioButtonMenuItem();
        jMenu35 = new javax.swing.JMenu();
        jRadioButtonMenuItem14 = new javax.swing.JRadioButtonMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanelMenuPrincipal.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        btTransacoes.setText("Transações");
        btTransacoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTransacoesActionPerformed(evt);
            }
        });

        btContas.setText("Contas");
        btContas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btContasActionPerformed(evt);
            }
        });

        btConfiguracoes.setText("Configurações");
        btConfiguracoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConfiguracoesActionPerformed(evt);
            }
        });

        btSair.setText("Sair");
        btSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSairActionPerformed(evt);
            }
        });

        btContas1.setText("Categorias");
        btContas1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btContas1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelMenuPrincipalLayout = new javax.swing.GroupLayout(jPanelMenuPrincipal);
        jPanelMenuPrincipal.setLayout(jPanelMenuPrincipalLayout);
        jPanelMenuPrincipalLayout.setHorizontalGroup(
            jPanelMenuPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMenuPrincipalLayout.createSequentialGroup()
                .addComponent(btTransacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btContas, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btContas1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btConfiguracoes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btSair, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 606, Short.MAX_VALUE))
        );
        jPanelMenuPrincipalLayout.setVerticalGroup(
            jPanelMenuPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btTransacoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanelMenuPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btContas, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                .addComponent(btContas1, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
            .addComponent(btConfiguracoes, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
            .addComponent(btSair, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        jMenu19.setText("Arquivo");

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("Usuário");
        jRadioButtonMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMenuItem1ActionPerformed(evt);
            }
        });
        jMenu19.add(jRadioButtonMenuItem1);

        jRadioButtonMenuItem3.setSelected(true);
        jRadioButtonMenuItem3.setText("Conta");
        jRadioButtonMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMenuItem3ActionPerformed(evt);
            }
        });
        jMenu19.add(jRadioButtonMenuItem3);

        jRadioButtonMenuItem2.setSelected(true);
        jRadioButtonMenuItem2.setText("Categoria");
        jRadioButtonMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMenuItem2ActionPerformed(evt);
            }
        });
        jMenu19.add(jRadioButtonMenuItem2);

        jRadioButtonMenuItem4.setSelected(true);
        jRadioButtonMenuItem4.setText("Transação");
        jRadioButtonMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMenuItem4ActionPerformed(evt);
            }
        });
        jMenu19.add(jRadioButtonMenuItem4);

        jRadioButtonMenuItem15.setSelected(true);
        jRadioButtonMenuItem15.setText("Configurações");
        jRadioButtonMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMenuItem15ActionPerformed(evt);
            }
        });
        jMenu19.add(jRadioButtonMenuItem15);

        jRadioButtonMenuItem16.setSelected(true);
        jRadioButtonMenuItem16.setText("Sair");
        jRadioButtonMenuItem16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMenuItem16ActionPerformed(evt);
            }
        });
        jMenu19.add(jRadioButtonMenuItem16);

        jMenuBar3.add(jMenu19);

        jMenu24.setText("Editar");

        jRadioButtonMenuItem5.setSelected(true);
        jRadioButtonMenuItem5.setText("Novo");
        jMenu24.add(jRadioButtonMenuItem5);

        jRadioButtonMenuItem6.setSelected(true);
        jRadioButtonMenuItem6.setText("Alterar");
        jMenu24.add(jRadioButtonMenuItem6);

        jRadioButtonMenuItem7.setSelected(true);
        jRadioButtonMenuItem7.setText("Excluir");
        jMenu24.add(jRadioButtonMenuItem7);

        jMenuBar3.add(jMenu24);

        jMenu28.setText("Relatório");

        jRadioButtonMenuItem8.setSelected(true);
        jRadioButtonMenuItem8.setText("Usuários");
        jRadioButtonMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMenuItem8ActionPerformed(evt);
            }
        });
        jMenu28.add(jRadioButtonMenuItem8);

        jRadioButtonMenuItem9.setSelected(true);
        jRadioButtonMenuItem9.setText("Categorias");
        jRadioButtonMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMenuItem9ActionPerformed(evt);
            }
        });
        jMenu28.add(jRadioButtonMenuItem9);

        jRadioButtonMenuItem10.setSelected(true);
        jRadioButtonMenuItem10.setText("Transações");
        jRadioButtonMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMenuItem10ActionPerformed(evt);
            }
        });
        jMenu28.add(jRadioButtonMenuItem10);

        jRadioButtonMenuItem11.setSelected(true);
        jRadioButtonMenuItem11.setText("Receitas");
        jRadioButtonMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMenuItem11ActionPerformed(evt);
            }
        });
        jMenu28.add(jRadioButtonMenuItem11);

        jRadioButtonMenuItem12.setSelected(true);
        jRadioButtonMenuItem12.setText("Despesas");
        jRadioButtonMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMenuItem12ActionPerformed(evt);
            }
        });
        jMenu28.add(jRadioButtonMenuItem12);

        jRadioButtonMenuItem13.setSelected(true);
        jRadioButtonMenuItem13.setText("Transferências");
        jRadioButtonMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMenuItem13ActionPerformed(evt);
            }
        });
        jMenu28.add(jRadioButtonMenuItem13);

        jMenuBar3.add(jMenu28);

        jMenu35.setText("Ajuda");

        jRadioButtonMenuItem14.setSelected(true);
        jRadioButtonMenuItem14.setText("Sobre");
        jRadioButtonMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMenuItem14ActionPerformed(evt);
            }
        });
        jMenu35.add(jRadioButtonMenuItem14);

        jMenuBar3.add(jMenu35);

        setJMenuBar(jMenuBar3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelMenuPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelMenuPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 559, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(1116, 723));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btSairActionPerformed

    private void btTransacoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTransacoesActionPerformed
        CTransacoes telaTransacoes = new CTransacoes();
        this.setEnabled(false);
        telaTransacoes.setVisible(true);
    }//GEN-LAST:event_btTransacoesActionPerformed

    private void btConfiguracoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConfiguracoesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btConfiguracoesActionPerformed

    private void btContasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btContasActionPerformed
                              
        Conta telaConta = new Conta();
        this.setEnabled(false);
        telaConta.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_btContasActionPerformed

    private void jRadioButtonMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItem1ActionPerformed
        Usuario telaUsuario = new Usuario();
        this.setEnabled(false);
        telaUsuario.setVisible(true);
    }//GEN-LAST:event_jRadioButtonMenuItem1ActionPerformed

    private void jRadioButtonMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItem3ActionPerformed
        Conta telaConta = new Conta();
        this.setEnabled(false);
        telaConta.setVisible(true);
    }//GEN-LAST:event_jRadioButtonMenuItem3ActionPerformed

    private void jRadioButtonMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItem2ActionPerformed
        Categoria telaCategoria = new Categoria();
        this.setEnabled(false);
        telaCategoria.setVisible(true);
    }//GEN-LAST:event_jRadioButtonMenuItem2ActionPerformed

    private void jRadioButtonMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItem4ActionPerformed
        ITransacao telaITransacao = new ITransacao();
        this.setEnabled(false);
        telaITransacao.setVisible(true);
    }//GEN-LAST:event_jRadioButtonMenuItem4ActionPerformed

    private void jRadioButtonMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItem15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonMenuItem15ActionPerformed

    private void jRadioButtonMenuItem16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItem16ActionPerformed
       System.exit(0);
    }//GEN-LAST:event_jRadioButtonMenuItem16ActionPerformed

    private void jRadioButtonMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItem8ActionPerformed

    }//GEN-LAST:event_jRadioButtonMenuItem8ActionPerformed

    private void jRadioButtonMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItem9ActionPerformed

    }//GEN-LAST:event_jRadioButtonMenuItem9ActionPerformed

    private void jRadioButtonMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItem10ActionPerformed

    }//GEN-LAST:event_jRadioButtonMenuItem10ActionPerformed

    private void jRadioButtonMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItem11ActionPerformed

    }//GEN-LAST:event_jRadioButtonMenuItem11ActionPerformed

    private void jRadioButtonMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItem12ActionPerformed

    }//GEN-LAST:event_jRadioButtonMenuItem12ActionPerformed

    private void jRadioButtonMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItem13ActionPerformed

    }//GEN-LAST:event_jRadioButtonMenuItem13ActionPerformed

    private void jRadioButtonMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItem14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonMenuItem14ActionPerformed

    private void btContas1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btContas1ActionPerformed
        Categoria telaCategoria = new Categoria();
        this.setEnabled(false);
        telaCategoria.setVisible(true);
    }//GEN-LAST:event_btContas1ActionPerformed

    public static Principal getInstance(){ // MÉTODO QUE VERIFICA SE A INSTANCIA JÁ ESTÁ CRIADA (SINGLETON)
        if(instancia==null)
            instancia = new Principal();        
        return instancia;
    }
            
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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btConfiguracoes;
    private javax.swing.JButton btContas;
    private javax.swing.JButton btContas1;
    private javax.swing.JButton btSair;
    private javax.swing.JButton btTransacoes;
    private javax.swing.JMenu jMenu19;
    private javax.swing.JMenu jMenu24;
    private javax.swing.JMenu jMenu28;
    private javax.swing.JMenu jMenu35;
    private javax.swing.JMenuBar jMenuBar3;
    private javax.swing.JPanel jPanelMenuPrincipal;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem10;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem11;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem12;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem13;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem14;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem15;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem16;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem2;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem3;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem4;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem5;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem6;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem7;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem8;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem9;
    // End of variables declaration//GEN-END:variables
}
