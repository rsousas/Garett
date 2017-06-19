package Visão;

import Controle.CConexaoBD;
import Controle.CTransacoes;
import Modelo.MTabela;
import Modelo.MTransacoes;
import Modelo.MUsuario;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

public class Transacoes extends javax.swing.JFrame {

    CConexaoBD conexao = new CConexaoBD();
    String usuario = TelaLogin.getUsuario();
    MTransacoes modTransacoes = new MTransacoes();
    CTransacoes conta = new CTransacoes();
    private static Transacoes instancia;

    public Transacoes() {
        initComponents();
        preencheTabela("select * from TRANSACAO T natural join CATEGORIA natural join CONTA join USUARIO U on U.CODUSU = T.CODUSU where T.CODUSU = " + usuario + " order by DATA");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        btNovo = new javax.swing.JButton();
        btEditar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        btSair = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableTransac = new javax.swing.JTable();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Transações");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btNovo.setText("+ Nova Transação");
        btNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoActionPerformed(evt);
            }
        });

        btEditar.setText("Editar");
        btEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditarActionPerformed(evt);
            }
        });

        btExcluir.setText("Excluir");
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        btSair.setText("Sair");
        btSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btNovo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btSair, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btNovo, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
            .addComponent(btEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btSair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTableTransac.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTableTransac);

        jMenu3.setText("File");
        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        setJMenuBar(jMenuBar2);

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
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(986, 597));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarActionPerformed
        modTransacoes.setDescricao((String) jTableTransac.getValueAt(jTableTransac.getSelectedRow(), 0));
        modTransacoes.setData((Date) jTableTransac.getValueAt(jTableTransac.getSelectedRow(), 1));
        modTransacoes.setConta((String) jTableTransac.getValueAt(jTableTransac.getSelectedRow(), 2));
        modTransacoes.setCateg((String) jTableTransac.getValueAt(jTableTransac.getSelectedRow(), 3));
        modTransacoes.setValor(Float.toString((Float) jTableTransac.getValueAt(jTableTransac.getSelectedRow(), 4)));
        modTransacoes.setCodtra((Integer) jTableTransac.getValueAt(jTableTransac.getSelectedRow(), 5));
        modTransacoes.setPago(((Integer) jTableTransac.getValueAt(jTableTransac.getSelectedRow(), 6)) == 1);
        modTransacoes.setLembrete((Integer) jTableTransac.getValueAt(jTableTransac.getSelectedRow(), 7));
        modTransacoes.setNota((String) jTableTransac.getValueAt(jTableTransac.getSelectedRow(), 8));
        modTransacoes.setTipo((String) jTableTransac.getValueAt(jTableTransac.getSelectedRow(), 9));
        modTransacoes.setUsuario(usuario);
        ITransacao telaTransacao = new ITransacao(modTransacoes);
        telaTransacao.setVisible(true);
    }//GEN-LAST:event_btEditarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        int resposta = 0;
        resposta = JOptionPane.showConfirmDialog(rootPane, "Deseja realmente excluir?");
        if (resposta == JOptionPane.YES_OPTION) {
            modTransacoes.setCodtra((Integer) jTableTransac.getValueAt(jTableTransac.getSelectedRow(), 5));
            modTransacoes.setUsuario(usuario);
            conta.Excluir(modTransacoes);
            preencheTabela("select * from TRANSACAO T natural join CATEGORIA natural join CONTA join USUARIO U on U.CODUSU = T.CODUSU where T.CODUSU = " + usuario + " order by DATA");
        }
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        ITransacao telaTransacao = new ITransacao();
        telaTransacao.setVisible(true);
    }//GEN-LAST:event_btNovoActionPerformed

    private void btSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairActionPerformed
        Principal telaPrincipal = Principal.getInstance();
        telaPrincipal.setEnabled(true);
        setVisible(false);
        instancia = null;
    }//GEN-LAST:event_btSairActionPerformed

    public void preencheTabela(String Sql) {
        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"Descricao", "Data", "Conta", "Categoria", "Valor", "Codigo", "Consolidada", "Lembrete", "Nota", "Tipo"};
        conexao.conecta();
        conexao.executaSql(Sql);

        try {
            conexao.rs.beforeFirst();

            while (conexao.rs.next()) {
                dados.add(new Object[]{conexao.rs.getString("DESCRTRA"), conexao.rs.getDate("DATA"), conexao.rs.getString("DESCRCON"), conexao.rs.getString("DESCRCAT"), conexao.rs.getFloat("VALOR"), conexao.rs.getInt("CODTRA"), conexao.rs.getInt("PAGO"), conexao.rs.getInt("LEMBRETE"), conexao.rs.getString("NOTA"), conexao.rs.getString("TIPO")});
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao preencher Tabela!" + ex);
        }
        MTabela tabela = new MTabela(dados, colunas);

        jTableTransac.setModel(tabela);

        jTableTransac.getColumnModel()
                .getColumn(0).setPreferredWidth(200);
        jTableTransac.getColumnModel()
                .getColumn(0).setResizable(false);
        jTableTransac.getColumnModel()
                .getColumn(1).setPreferredWidth(160);
        jTableTransac.getColumnModel()
                .getColumn(1);
        setResizable(
                false);
        jTableTransac.getColumnModel()
                .getColumn(2).setPreferredWidth(200);
        jTableTransac.getColumnModel()
                .getColumn(2).setResizable(false);
        jTableTransac.getColumnModel()
                .getColumn(3).setPreferredWidth(200);
        jTableTransac.getColumnModel()
                .getColumn(3);
        setResizable(
                false);
        jTableTransac.getColumnModel()
                .getColumn(4).setPreferredWidth(200);
        jTableTransac.getColumnModel()
                .getColumn(4).setResizable(false);
        jTableTransac.getTableHeader()
                .setReorderingAllowed(false);
        jTableTransac.getColumnModel()
                .getColumn(5).setPreferredWidth(30);
        jTableTransac.getColumnModel()
                .getColumn(5).setResizable(false);
        jTableTransac.getColumnModel()
                .getColumn(6).setPreferredWidth(5);
        jTableTransac.getColumnModel()
                .getColumn(6).setResizable(false);
        jTableTransac.getColumnModel()
                .getColumn(7).setPreferredWidth(10);
        jTableTransac.getColumnModel()
                .getColumn(7).setResizable(false);
        jTableTransac.getColumnModel()
                .getColumn(8).setPreferredWidth(500);
        jTableTransac.getColumnModel()
                .getColumn(8).setResizable(false);
        jTableTransac.getColumnModel()
                .getColumn(9).setPreferredWidth(5);
        jTableTransac.getColumnModel()
                .getColumn(9).setResizable(false);
        jTableTransac.setAutoResizeMode(jTableTransac.AUTO_RESIZE_OFF);

        jTableTransac.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        conexao.desconecta();
        jTableTransac.setColumnSelectionInterval(0, 0);
        jTableTransac.setRowSelectionInterval(0, 0);
    }

    public void limpaTabela() {
        ArrayList dados = new ArrayList();
        String[] colunas = new String[0];
        MTabela tabela = new MTabela(dados, colunas);
        jTableTransac.setModel(tabela);
    }

    public static Transacoes getInstance() { // MÉTODO QUE VERIFICA SE A INSTANCIA JÁ ESTÁ CRIADA (SINGLETON)
        if (instancia == null) {
            instancia = new Transacoes();
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
            java.util.logging.Logger.getLogger(Transacoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Transacoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Transacoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Transacoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Transacoes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btEditar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btSair;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableTransac;
    // End of variables declaration//GEN-END:variables
}
