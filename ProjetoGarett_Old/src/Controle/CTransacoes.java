package Controle;

import Modelo.MTransacoes;
import javax.swing.JOptionPane;

public class CTransacoes {

    public boolean validaCampos(MTransacoes transac) {

        if (transac.getValor().isNaN()) {
            JOptionPane.showMessageDialog(null, "Informe um Valor para continuar!");
            return false;
        }

        if (transac.getData().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe a Data para continuar!");
            return false;
        }

        if (transac.getDescricao().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe a Descrição para continuar!");
            return false;
        }
        if (transac.getCodCon().equals(0)) {
            JOptionPane.showMessageDialog(null, "Informe uma Conta para continuar!");
            return false;
        }
        if (transac.getCodCat().equals(0)) {
            JOptionPane.showMessageDialog(null, "Informe uma Categoria para continuar!");
            return false;
        }
        return true;
    }
    
        public void Salvar(MTransacoes transac) {
        conexao.conecta();
        try {
            PreparedStatement pst = conexao.conexao.prepareStatement("insert into TRANSACAO (CODTRA, DESCRTRA, DATA, PAGO, LEMBRETE, NOTA, VALOR, TIPO, CODCAT, CODCON, CODUSU, CODTRATRANSF) values(?,?,?,?,?,?,?,?,?,?,?,?,)");
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

    public boolean verificaSeNumerico(String valor) {
        try {
            Integer.parseInt(valor);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
}
