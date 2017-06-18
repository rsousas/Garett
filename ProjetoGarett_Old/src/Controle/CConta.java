package Controle;

import Modelo.MConta;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class CConta {

    CConexaoBD conexao = new CConexaoBD();

    public boolean validaCampos(MConta conta) {

        if (conta.getDescricao().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe uma Descrição para continuar!");
            return false;
        }

        conexao.conecta();
        try {
            conexao.executaSql("select CODCON from CONTA where DESCRCON = '" + conta.getDescricao() + "' and CODUSU ='" + conta.getUsuario() + "'");
            conexao.rs.beforeFirst();
            if (conexao.rs.next()) {
                JOptionPane.showMessageDialog(null, "Já existe esta Conta Cadastrada com código: " + conexao.rs.getString("CODCON"));
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CConta.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

        return true;
    }

    public boolean verificaSeNumerico(String valor) {
        try {
            Float.parseFloat(valor);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    public void Salvar(MConta conta) {
        conexao.conecta();
        try {
            PreparedStatement pst = conexao.conexao.prepareStatement("insert into CONTA (DESCRCON, SALDOCON, ATIVOCON, CODUSU) values(?, ?, ?, ?)");
            pst.setString(1, conta.getDescricao());
            pst.setFloat(2, conta.getSaldo());
            pst.setString(3, Integer.toString(conta.getAtivo()));
            pst.setString(4, conta.getUsuario());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir Conta:\nErro:" + ex);
        }
        conexao.desconecta();
    }

    public void Editar(MConta conta) {
        conexao.conecta();
        try {
            PreparedStatement pst = conexao.conexao.prepareStatement("Update CONTA set DESCRCON = ?, SALDOCON = ?, ATIVOCON = ? where CODUSU = ? and CODCON = ?");
            pst.setString(1, conta.getDescricao());
            pst.setFloat(2, conta.getSaldo());
            pst.setString(3, Integer.toString(conta.getAtivo()));
            pst.setString(4, conta.getUsuario());
            pst.setString(5, Integer.toString(conta.getCodcon()));
            pst.execute();
            JOptionPane.showMessageDialog(null, "Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Editar Conta:\nErro:" + ex);
        }
        conexao.desconecta();
    }

    public void Excluir(MConta conta) {
        conexao.conecta();
        try {
            PreparedStatement pst = conexao.conexao.prepareStatement("delete from CONTA where CODUSU = ? and CODCON = ?");
            pst.setString(1, conta.getUsuario());
            pst.setString(2, Integer.toString(conta.getCodcon()));
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Excluir Conta:\nErro:" + ex);
        }
        conexao.desconecta();
    }
}
