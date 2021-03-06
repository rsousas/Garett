package Controle;

import Modelo.MUsuario;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class CUsuario {

    CConexaoBD conexao = new CConexaoBD();

    public boolean validaCampos(MUsuario usuario) {

        if (usuario.getNome().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe um Nome para continuar!");
            return false;
        }

        conexao.conecta();
        try {
            conexao.executaSql("SELECT IDUSU FROM usuario WHERE CODUSU = '" + usuario.getUsuario() + "'");
            conexao.rs.beforeFirst();
            if (conexao.rs.next()) {
                JOptionPane.showMessageDialog(null, "Já existe este usuário!\nTente outro Usuário para Continuar.");
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CUsuario.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

        if (usuario.getUsuario().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe um Usuário para continuar!");
            return false;
        }
        if (usuario.getSenha().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe a Senha para continuar!");
            return false;
        }
        return true;
    }

    public void Salvar(MUsuario usuario) {
        conexao.conecta();
        try {
            PreparedStatement pst = conexao.conexao.prepareStatement("INSERT INTO usuario (IDUSU, NOMEUSU, SENHAUSU) VALUES(?, ?, ?)");
            pst.setString(1, usuario.getUsuario());
            pst.setString(2, usuario.getNome());
            pst.setString(3, usuario.getSenha());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir Usuário:\nErro:" + ex);
        }
        conexao.desconecta();
    }

    public boolean validaLogin(MUsuario usuario) {
        conexao.conecta();
        try {
            conexao.executaSql("SELECT SENHAUSU FROM usuario WHERE IDUSU = '" + usuario.getUsuario() + "'");
            conexao.rs.first();
            if (conexao.rs.getString("SENHAUSU").equals(usuario.getSenha())) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CUsuario.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public String buscaCodigoUsu(MUsuario usuario) {
        conexao.conecta();
        try {
            conexao.executaSql("SELECT CODUSU FROM usuario WHERE IDUSU = '" + usuario.getUsuario() + "'");
            conexao.rs.first();
            return conexao.rs.getString("CODUSU");

        } catch (SQLException ex) {
            Logger.getLogger(CUsuario.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
