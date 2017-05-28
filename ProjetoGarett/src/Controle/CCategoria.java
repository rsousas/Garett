
package Controle;

import Modelo.MCategoria;
import Modelo.MUsuario;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class CCategoria {
    CConexaoBD conexao = new CConexaoBD();
    MCategoria categoria = new MCategoria();

    public void Salvar(MCategoria descrcat) {
        conexao.conecta();
        try {
            PreparedStatement pst = conexao.conexao.prepareStatement("INSERT INTO categoria (CODCAT, DESCRCAT, ATIVOCAT, CODUSU) VALUES(?,?,?,?)");
            pst.setString(1, "1");
            pst.setString(2,categoria.getDescrcat());            
            pst.setString(3, "1");
            pst.setString(4, "1");
            pst.execute();
            JOptionPane.showMessageDialog(null, "Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir categoria:\nErro:" + ex);
        }
        conexao.desconecta();
    }

    
}
