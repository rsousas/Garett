package Visão;

import Controle.CCategoria;
import Controle.CConexaoBD;
import Modelo.MCategoria;
import Modelo.MTabela;
import Modelo.MUsuario;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

public class Categoria extends javax.swing.JFrame {

    CConexaoBD conexao = new CConexaoBD();
    String usuario = TelaLogin.getUsuario();
    MCategoria modCategoria = new MCategoria();
    CCategoria categoria = new CCategoria();
    private static Categoria instancia;

    public Categoria() {
        initComponents();
        preencheTabela("select * from CATEGORIA  natural join USUARIO where CODUSU = " + usuario + " order by CODCAT");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btNovo = new javax.swing.JButton();
        btEditar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        btSair = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableCateg = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/file.png"))); // NOI18N
        btNovo.setBorder(null);
        btNovo.setContentAreaFilled(false);
        btNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoActionPerformed(evt);
            }
        });
        jPanel1.add(btNovo, new org.netbeans.lib.awtextra.AbsoluteConstraints(9, 9, -1, -1));

        btEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/contract.png"))); // NOI18N
        btEditar.setBorder(null);
        btEditar.setContentAreaFilled(false);
        btEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditarActionPerformed(evt);
            }
        });
        jPanel1.add(btEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(109, 9, -1, -1));

        btExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/trash.png"))); // NOI18N
        btExcluir.setBorder(null);
        btExcluir.setContentAreaFilled(false);
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });
        jPanel1.add(btExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(209, 9, -1, -1));

        btSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/open-door.png"))); // NOI18N
        btSair.setBorder(null);
        btSair.setContentAreaFilled(false);
        btSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSairActionPerformed(evt);
            }
        });
        jPanel1.add(btSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(309, 9, -1, -1));

        jLabel2.setText("+ Nova Conta");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 107, -1, -1));

        jLabel3.setText("Editar");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(143, 107, -1, -1));

        jLabel1.setText("Excluir");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(243, 107, -1, -1));

        jLabel4.setText("Sair");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 107, -1, -1));

        jTableCateg.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTableCateg.setForeground(new java.awt.Color(102, 102, 102));
        jTableCateg.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableCateg.setGridColor(new java.awt.Color(255, 255, 255));
        jTableCateg.setRowHeight(26);
        jTableCateg.setSelectionBackground(new java.awt.Color(50, 74, 94));
        jTableCateg.setShowHorizontalLines(false);
        jTableCateg.setShowVerticalLines(false);
        jScrollPane1.setViewportView(jTableCateg);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 970, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(986, 596));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        ICategoria telaCategoria = new ICategoria();
        telaCategoria.setVisible(true);
    }//GEN-LAST:event_btNovoActionPerformed

    private void btEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarActionPerformed
        modCategoria.setDescricao((String) jTableCateg.getValueAt(jTableCateg.getSelectedRow(), 1));
        modCategoria.setAtivo(((Integer) jTableCateg.getValueAt(jTableCateg.getSelectedRow(), 2)) == 1);
        modCategoria.setUsuario(usuario);
        modCategoria.setCodcat((Integer) jTableCateg.getValueAt(jTableCateg.getSelectedRow(), 0));
        ICategoria telaCategoria = new ICategoria(modCategoria);
        telaCategoria.setVisible(true);
    }//GEN-LAST:event_btEditarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        int resposta;
        resposta = JOptionPane.showConfirmDialog(rootPane, "Deseja realmente excluir?", "Excluir", JOptionPane.YES_NO_OPTION);
        if (resposta == JOptionPane.YES_OPTION) {
            modCategoria.setCodcat((Integer) jTableCateg.getValueAt(jTableCateg.getSelectedRow(), 0));
            modCategoria.setUsuario(usuario);
            categoria.Excluir(modCategoria);
            preencheTabela("select * from CATEGORIA  natural join USUARIO where CODUSU = " + usuario + " order by CODCAT");
        }
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairActionPerformed
        Principal telaPrincipal = Principal.getInstance();
        this.dispose();
        telaPrincipal.setVisible(true);
        instancia = null;
    }//GEN-LAST:event_btSairActionPerformed

    public void preencheTabela(String Sql) {
        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"Codigo", "Descrição", "Ativo"};
        conexao.conecta();
        conexao.executaSql(Sql);

        try {
            conexao.rs.beforeFirst();

            while (conexao.rs.next()) {
                dados.add(new Object[]{conexao.rs.getInt("CODCAT"), conexao.rs.getString("DESCRCAT"), conexao.rs.getInt("ATIVOCAT") == 1 ? "Sim" : "Não"});
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao preencher Tabela!" + ex);
        }

        if (dados.isEmpty()) {
            dados.add(new Object[]{' ', ' ', ' '});
        }

        MTabela tabela = new MTabela(dados, colunas);

        jTableCateg.setModel(tabela);
        jTableCateg.getColumnModel().getColumn(0).setPreferredWidth(100);
        jTableCateg.getColumnModel().getColumn(0).setResizable(false);
        jTableCateg.getColumnModel().getColumn(1).setPreferredWidth(750);
        jTableCateg.getColumnModel().getColumn(1).setResizable(false);
        jTableCateg.getColumnModel().getColumn(2).setPreferredWidth(120);
        jTableCateg.getColumnModel().getColumn(2).setResizable(false);
        jTableCateg.getTableHeader().setReorderingAllowed(false);
        jTableCateg.setAutoResizeMode(jTableCateg.AUTO_RESIZE_OFF);

        jTableCateg.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        conexao.desconecta();
        jTableCateg.setColumnSelectionInterval(0, 0);
        jTableCateg.setRowSelectionInterval(0, 0);
    }

    public void limpaTabela() {
        ArrayList dados = new ArrayList();
        String[] colunas = new String[0];
        MTabela tabela = new MTabela(dados, colunas);
        jTableCateg.setModel(tabela);
    }

    public static Categoria getInstance() { // MÉTODO QUE VERIFICA SE A INSTANCIA JÁ ESTÁ CRIADA (SINGLETON)
        if (instancia == null) {
            instancia = new Categoria();
        }
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
            java.util.logging.Logger.getLogger(Categoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Categoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Categoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Categoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new Categoria().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btEditar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableCateg;
    // End of variables declaration//GEN-END:variables
}
