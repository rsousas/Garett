package Controle;

import Modelo.MCategoria;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class CCategoria {

    CConexaoBD conexao = new CConexaoBD();

    public boolean validaCampos(MCategoria categoria) {

        if (categoria.getDescricao().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe uma Descrição para continuar!");
            return false;
        }

        conexao.conecta();
        try {
            conexao.executaSql("select CODCAT from CATEGORIA where DESCRCAT = '" + categoria.getDescricao() + "' and IDUSU ='" + categoria.getUsuario() + "'");
            conexao.rs.beforeFirst();
            if (conexao.rs.next()) {
                JOptionPane.showMessageDialog(null, "Já existe esta Categoria Cadastrada com código: " + conexao.rs.getString("CODCAT"));
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CCategoria.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

        return true;
    }

    public void Salvar(MCategoria categoria) {
        conexao.conecta();
        try {
            PreparedStatement pst = conexao.conexao.prepareStatement("insert into CATEGORIA (DESCRCAT, CODCATPAI, ATIVOCAT, CODUSU) values(?, ?, ?, ?)");
            pst.setString(1, categoria.getDescricao());
            pst.setString(2, Integer.toString(categoria.getCodigoPai()));
            pst.setString(3, Integer.toString(categoria.getAtivo()));
            pst.setString(4, categoria.getUsuario());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir Categoria:\nErro:" + ex);
        }
        conexao.desconecta();
    }
    
    public void Excluir(MCategoria categoria){
        conexao.conecta();
        try { 
            PreparedStatement pst = conexao.conexao.prepareStatement("delete from CATEGORIA where CODUSU = ? AND CODCAT = ?");
            pst.setString(1, categoria.get);
        } catch (SQLException ex) {
            Logger.getLogger(CCategoria.class.getName()).log(Level.SEVERE, null, ex);
        }
        conexao.desconecta();
    }
}
