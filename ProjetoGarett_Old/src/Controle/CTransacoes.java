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
