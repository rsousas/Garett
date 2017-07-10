package Visão;

import Controle.CConexaoBD;
import Controle.CTransacoes;
import Modelo.MTabela;
import Modelo.MTransacoes;
import Modelo.MUsuario;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

public class Transacoes extends javax.swing.JFrame {

    CConexaoBD conexao = new CConexaoBD();
    String usuario = TelaLogin.getUsuario();
    MTransacoes modTransacoes = new MTransacoes();
    CTransacoes Transac = new CTransacoes();
    CTransacoes conta = new CTransacoes();
    private static Transacoes instancia;

    public Transacoes() {
        initComponents();
        preencheTabela("select * from TRANSACAO T left join CATEGORIA USING(CODCAT) left join CONTA using (CODCON) join USUARIO U on U.CODUSU = T.CODUSU where T.CODUSU = " + usuario + " order by CODTRA, DATA");
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableTransac = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btTransferencia = new javax.swing.JButton();
        btReceitas = new javax.swing.JButton();
        btDespesas = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Transações");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
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

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(null);

        jTableTransac.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTableTransac.setForeground(new java.awt.Color(102, 102, 102));
        jTableTransac.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"", "", "", null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTableTransac.setGridColor(new java.awt.Color(255, 255, 255));
        jTableTransac.setRowHeight(26);
        jTableTransac.setSelectionBackground(new java.awt.Color(50, 74, 94));
        jTableTransac.setShowHorizontalLines(false);
        jTableTransac.setShowVerticalLines(false);
        jScrollPane1.setViewportView(jTableTransac);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btTransferencia.setText("Transferências");
        btTransferencia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 168, 52), 2));
        btTransferencia.setContentAreaFilled(false);
        btTransferencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTransferenciaActionPerformed(evt);
            }
        });
        jPanel2.add(btTransferencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 1, 80, -1));

        btReceitas.setText("Receitas");
        btReceitas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(144, 223, 170), 2));
        btReceitas.setContentAreaFilled(false);
        btReceitas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btReceitasActionPerformed(evt);
            }
        });
        jPanel2.add(btReceitas, new org.netbeans.lib.awtextra.AbsoluteConstraints(795, 1, 80, -1));

        btDespesas.setText("Despesas");
        btDespesas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 112, 88), 2));
        btDespesas.setContentAreaFilled(false);
        btDespesas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDespesasActionPerformed(evt);
            }
        });
        jPanel2.add(btDespesas, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 1, 80, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Filtrar por:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 1, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );

        setSize(new java.awt.Dimension(986, 587));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairActionPerformed
        Principal telaPrincipal = Principal.getInstance();
        this.dispose();
        telaPrincipal.setVisible(true);
        instancia = null;
    }//GEN-LAST:event_btSairActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        int resposta;
        resposta = JOptionPane.showConfirmDialog(rootPane, "Deseja realmente excluir?", "Excluir", JOptionPane.YES_NO_OPTION);
        if (resposta == JOptionPane.YES_OPTION) {
            modTransacoes.setCodtra((Integer) jTableTransac.getValueAt(jTableTransac.getSelectedRow(), 5));
            modTransacoes.setUsuario(usuario);
            conta.Excluir(modTransacoes);
            preencheTabela("select * from TRANSACAO T natural join CATEGORIA natural join CONTA join USUARIO U on U.CODUSU = T.CODUSU where T.CODUSU = " + usuario + " order by DATA");
        }
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarActionPerformed
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date data = new java.util.Date();
        Date dataLembrete = new java.util.Date();
        Long lembrete;
        ArrayList dadosTransferencia;
        dadosTransferencia = Transac.buscaTransacDestino((Integer) jTableTransac.getValueAt(jTableTransac.getSelectedRow(), 5), usuario);
        if (jTableTransac.getValueAt(jTableTransac.getSelectedRow(), 10).equals(0)) {
            modTransacoes.setCodtra((Integer) jTableTransac.getValueAt(jTableTransac.getSelectedRow(), 5));
            modTransacoes.setConta((String) jTableTransac.getValueAt(jTableTransac.getSelectedRow(), 2));
        } else {
            modTransacoes.setCodtra((Integer) dadosTransferencia.get(0));
            modTransacoes.setConta(dadosTransferencia.get(1).toString());
            modTransacoes.setCodtraDest((Integer) dadosTransferencia.get(2));
            modTransacoes.setContaDest(dadosTransferencia.get(3).toString());
        }

        try {
            data = formato.parse((String) jTableTransac.getValueAt(jTableTransac.getSelectedRow(), 1));
            dataLembrete = formato.parse((String) jTableTransac.getValueAt(jTableTransac.getSelectedRow(), 7));
        } catch (ParseException ex) {
            Logger.getLogger(Transacoes.class.getName()).log(Level.SEVERE, null, ex);
        }
        lembrete = dataLembrete.getTime() - data.getTime();
        modTransacoes.setDescricao((String) jTableTransac.getValueAt(jTableTransac.getSelectedRow(), 0));
        modTransacoes.setData(data);
        modTransacoes.setCateg((String) jTableTransac.getValueAt(jTableTransac.getSelectedRow(), 3));
        modTransacoes.setValor(Float.toString((Float) jTableTransac.getValueAt(jTableTransac.getSelectedRow(), 4)));
        modTransacoes.setPago(((boolean) "Sim".equals(jTableTransac.getValueAt(jTableTransac.getSelectedRow(), 6))));
        modTransacoes.setLembrete(Integer.valueOf(lembrete.toString()));
        modTransacoes.setNota((String) jTableTransac.getValueAt(jTableTransac.getSelectedRow(), 8));
        modTransacoes.setTipo(jTableTransac.getValueAt(jTableTransac.getSelectedRow(), 10).equals(0) ? (String) jTableTransac.getValueAt(jTableTransac.getSelectedRow(), 9) : "T");
        modTransacoes.setUsuario(usuario);
        ITransacao telaTransacao = new ITransacao(modTransacoes);
        telaTransacao.setVisible(true);
    }//GEN-LAST:event_btEditarActionPerformed

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        ITransacao telaTransacao = new ITransacao();
        telaTransacao.setVisible(true);
    }//GEN-LAST:event_btNovoActionPerformed

    private void btDespesasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDespesasActionPerformed
        limpaTabela();
        preencheTabela("select * from TRANSACAO T left join CATEGORIA USING(CODCAT) left join CONTA using (CODCON) join USUARIO U on U.CODUSU = T.CODUSU where T.TIPO = 'D' and T.CODTRATRANSF is null and T.CODUSU = " + usuario + " order by CODTRA, DATA");
    }//GEN-LAST:event_btDespesasActionPerformed

    private void btReceitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btReceitasActionPerformed
        limpaTabela();
        preencheTabela("select * from TRANSACAO T left join CATEGORIA USING(CODCAT) left join CONTA using (CODCON) join USUARIO U on U.CODUSU = T.CODUSU where T.TIPO = 'R' and T.CODTRATRANSF is null and T.CODUSU = " + usuario + " order by CODTRA, DATA");
    }//GEN-LAST:event_btReceitasActionPerformed

    private void btTransferenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTransferenciaActionPerformed
        limpaTabela();
        preencheTabela("select * from TRANSACAO T left join CATEGORIA USING(CODCAT) left join CONTA using (CODCON) join USUARIO U on U.CODUSU = T.CODUSU where T.CODTRATRANSF is not null and T.CODUSU = " + usuario + " order by CODTRA, DATA");
    }//GEN-LAST:event_btTransferenciaActionPerformed

    public void preencheTabela(String Sql) {
        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"Descricao", "Data", "Conta", "Categoria", "Valor", "Codigo", "Consolidada", "Lembrete", "Nota", "Tipo", ""};
        String formato = "dd/MM/yyyy";
        SimpleDateFormat dataFormatada = new SimpleDateFormat(formato);

        conexao.conecta();
        conexao.executaSql(Sql);

        try {
            conexao.rs.beforeFirst();

            while (conexao.rs.next()) {
                dados.add(new Object[]{conexao.rs.getString("DESCRTRA"), dataFormatada.format(conexao.rs.getDate("DATA")), conexao.rs.getString("DESCRCON"), conexao.rs.getString("DESCRCAT"), conexao.rs.getFloat("VALOR"), conexao.rs.getInt("CODTRA"), conexao.rs.getInt("PAGO") == 1 ? "Sim" : "Não", dataFormatada.format(conexao.rs.getDate("LEMBRETE")), conexao.rs.getString("NOTA"), "D".equals(conexao.rs.getString("TIPO")) ? "Despesa" : "Receita", conexao.rs.getInt("CODTRATRANSF")});
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao preencher Tabela!" + ex);
        }
        if (dados.isEmpty()) {
            dados.add(new Object[]{' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '});
        }

        MTabela tabela = new MTabela(dados, colunas);

        jTableTransac.setModel(tabela);

        jTableTransac.getColumnModel().getColumn(0).setPreferredWidth(200);
        jTableTransac.getColumnModel().getColumn(1).setPreferredWidth(90);
        jTableTransac.getColumnModel().getColumn(1).setResizable(false);
        jTableTransac.getColumnModel().getColumn(2).setPreferredWidth(200);
        jTableTransac.getColumnModel().getColumn(2).setResizable(false);
        jTableTransac.getColumnModel().getColumn(3).setPreferredWidth(200);
        jTableTransac.getColumnModel().getColumn(3).setResizable(false);
        jTableTransac.getColumnModel().getColumn(4).setPreferredWidth(200);
        jTableTransac.getColumnModel().getColumn(4).setResizable(false);
        jTableTransac.getColumnModel().getColumn(5).setPreferredWidth(90);
        jTableTransac.getColumnModel().getColumn(5).setResizable(false);
        jTableTransac.getColumnModel().getColumn(6).setPreferredWidth(100);
        jTableTransac.getColumnModel().getColumn(6).setResizable(false);
        jTableTransac.getColumnModel().getColumn(7).setPreferredWidth(90);
        jTableTransac.getColumnModel().getColumn(7).setResizable(false);
        jTableTransac.getColumnModel().getColumn(8).setPreferredWidth(500);
        jTableTransac.getColumnModel().getColumn(9).setPreferredWidth(90);
        jTableTransac.getColumnModel().getColumn(9).setResizable(false);
        jTableTransac.getColumnModel().getColumn(10).setPreferredWidth(0);
        jTableTransac.getColumnModel().getColumn(10).setResizable(false);
        jTableTransac.getTableHeader().setReorderingAllowed(false);
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
    private javax.swing.JButton btDespesas;
    private javax.swing.JButton btEditar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btReceitas;
    private javax.swing.JButton btSair;
    private javax.swing.JButton btTransferencia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableTransac;
    // End of variables declaration//GEN-END:variables
}
