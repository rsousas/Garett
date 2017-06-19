package Controle;

import Modelo.MTransacoes;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class CTransacoes {

    CConexaoBD conexao = new CConexaoBD();

    public boolean validaCampos(MTransacoes transac) {

        if (transac.getValor().isNaN()) {
            JOptionPane.showMessageDialog(null, "Informe um Valor para continuar!");
            return false;
        }

        if (transac.getDescricao().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe a Descrição para continuar!");
            return false;
        }
        if (transac.getConta().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe uma Conta para continuar!");
            return false;
        }
        if (transac.getCateg().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe uma Categoria para continuar!");
            return false;
        }

        if (transac.getTipo().equals("T")) {
            JOptionPane.showMessageDialog(null, "Operação de transação ainda não implementada!");
            return false;
        }
        return true;
    }

    public void Salvar(MTransacoes transac) {
        int codCat;
        int codCon;
        java.sql.Date dataSql = new java.sql.Date(transac.getData().getTime()); // É necessário converter util.Date para sql.Date
        codCat = buscaCodCategoria(transac.getCateg());
        codCon = buscaCodConta(transac.getConta());
        conexao.conecta();
        try {
            PreparedStatement pst = conexao.conexao.prepareStatement("insert into TRANSACAO (DESCRTRA, DATA, PAGO, LEMBRETE, NOTA, VALOR, TIPO, CODCAT, CODCON, CODUSU) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            pst.setString(1, transac.getDescricao());
            pst.setDate(2, dataSql);
            pst.setInt(3, transac.getPago());
            pst.setInt(4, transac.getLembrete());
            pst.setString(5, transac.getNota());
            pst.setFloat(6, transac.getValor());
            pst.setString(7, transac.getTipo());
            pst.setInt(8, codCat);
            pst.setInt(9, codCon);
            pst.setString(10, transac.getUsuario());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir Transação:\nErro:" + ex);
        }
        conexao.desconecta();
    }

    public void Editar(MTransacoes transac) {
        int codCat;
        int codCon;
        java.sql.Date dataSql = new java.sql.Date(transac.getData().getTime()); // É necessário converter util.Date para sql.Date
        codCat = buscaCodCategoria(transac.getCateg());
        codCon = buscaCodConta(transac.getConta());
        conexao.conecta();
        try {
            PreparedStatement pst = conexao.conexao.prepareStatement("Update TRANSACAO set DESCRTRA = ?, DATA = ?, PAGO = ?, LEMBRETE = ?, NOTA = ?, VALOR = ?, TIPO = ?, CODCAT = ?, CODCON = ? where CODUSU = ? and CODTRA = ?");
            pst.setString(1, transac.getDescricao());
            pst.setDate(2, dataSql);
            pst.setInt(3, transac.getPago());
            pst.setInt(4, transac.getLembrete());
            pst.setString(5, transac.getNota());
            pst.setFloat(6, transac.getValor());
            pst.setString(7, transac.getTipo());
            pst.setInt(8, codCat);
            pst.setInt(9, codCon);
            pst.setString(10, transac.getUsuario());
            pst.setInt(11, transac.getCodtra());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Editar Transação:\nErro:" + ex);
        }
        conexao.desconecta();
    }

    public void Excluir(MTransacoes transac) {
        conexao.conecta();
        try {
            PreparedStatement pst = conexao.conexao.prepareStatement("delete from TRANSACAO where CODUSU = ? and CODTRA = ?");
            pst.setString(1, transac.getUsuario());
            pst.setString(2, Integer.toString(transac.getCodtra()));
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Excluir Transacao:\nErro:" + ex);
        }
        conexao.desconecta();
    }

    public boolean verificaSeNumerico(String valor) {
        try {
            Float.parseFloat(valor);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    private Integer buscaCodCategoria(String categoria) {
        conexao.executaSql("select CODCAT from CATEGORIA where DESCRCAT = '" + categoria + "'");
        try {
            conexao.rs.first();
            return conexao.rs.getInt("CODCAT");
        } catch (SQLException ex) {
            Logger.getLogger(CTransacoes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private Integer buscaCodConta(String conta) {
        conexao.executaSql("select CODCON from CONTA where DESCRCON = '" + conta + "'");
        try {
            conexao.rs.first();
            return conexao.rs.getInt("CODCON");
        } catch (SQLException ex) {
            Logger.getLogger(CTransacoes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList buscaCategorias(String usuario) {
        ArrayList dados = new ArrayList();
        conexao.conecta();
        conexao.executaSql("select DESCRCAT from CATEGORIA  natural join USUARIO where CODUSU = " + usuario + " order by CODCAT");
        try {
            conexao.rs.beforeFirst();
            while (conexao.rs.next()) {
                dados.add(conexao.rs.getString("DESCRCAT"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CTransacoes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dados;
    }

    public ArrayList buscaContas(String usuario) {
        ArrayList dados = new ArrayList();
        conexao.conecta();
        conexao.executaSql("select * from CONTA  natural join USUARIO where CODUSU = " + usuario + " order by CODCON");
        try {
            conexao.rs.beforeFirst();
            while (conexao.rs.next()) {
                dados.add(conexao.rs.getString("DESCRCON"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CTransacoes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dados;
    }
}
