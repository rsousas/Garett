package Controle;

import Modelo.MCategoria;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class CCategoria {

    CConexaoBD conexao = new CConexaoBD();

    public boolean validaCampos(MCategoria categoria, boolean isEdit) {

        if (categoria.getDescricao().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe uma Descrição para continuar!");
            return false;
        }
        if (!isEdit) {
            conexao.conecta();
            try {
                conexao.executaSql("select CODCAT from CATEGORIA where DESCRCAT = '" + categoria.getDescricao() + "' and CODUSU ='" + categoria.getUsuario() + "'");
                conexao.rs.beforeFirst();
                if (conexao.rs.next()) {
                    JOptionPane.showMessageDialog(null, "Já existe esta Categoria Cadastrada com código: " + conexao.rs.getString("CODCAT"));
                    return false;
                }
            } catch (SQLException ex) {
                Logger.getLogger(CCategoria.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        }
        return true;
    }

    public void Salvar(MCategoria categoria) {
        conexao.conecta();
        try {
            PreparedStatement pst = conexao.conexao.prepareStatement("insert into CATEGORIA (DESCRCAT, CODCATPAI, ATIVOCAT, CODUSU) values(?, ?, ?, ?)");
            pst.setString(1, categoria.getDescricao());
            pst.setInt(2, categoria.getCodigoPai());
            pst.setInt(3, categoria.getAtivo());
            pst.setString(4, categoria.getUsuario());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Inserir Categoria:\nErro:" + ex);
        }
        conexao.desconecta();
    }

    public void Editar(MCategoria categoria) {
        conexao.conecta();
        try {
            PreparedStatement pst = conexao.conexao.prepareStatement("Update CATEGORIA set DESCRCAT = ?, CODCATPAI = ?, ATIVOCAT = ? where CODUSU = ? and CODCAT = ?");
            pst.setString(1, categoria.getDescricao());
            pst.setInt(2, categoria.getCodigoPai());
            pst.setInt(3, categoria.getAtivo());
            pst.setString(4, categoria.getUsuario());
            pst.setInt(5, categoria.getCodcat());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Editar Categoria:\nErro:" + ex);
        }
        conexao.desconecta();
    }

    public void Excluir(MCategoria categoria) {
        conexao.conecta();
        try {
            PreparedStatement pst = conexao.conexao.prepareStatement("delete from CATEGORIA where CODUSU = ? and CODCAT = ?");
            pst.setString(1, categoria.getUsuario());
            pst.setString(2, Integer.toString(categoria.getCodcat()));
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Excluir Categoria:\nErro:" + ex);
        }
        conexao.desconecta();
    }
}
