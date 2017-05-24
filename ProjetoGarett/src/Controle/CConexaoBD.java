package Controle;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class CConexaoBD {

    public static String status = "Não conectou...";
    public Statement stm;
    public ResultSet rs;
    public Connection conexao;
    private String driver = "com.mysql.jdbc.Driver";
    private String caminho = "jdbc:mysql://localhost/garett";
    private String usuario = "root";
    private String senha = "";

    public void conecta() {
        try {
            try {
                Class.forName(driver);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(CConexaoBD.class.getName()).log(Level.SEVERE, null, ex);
            }
            conexao = DriverManager.getConnection(caminho, usuario, senha);

            if (conexao != null) {
                status = ("STATUS--->Conectado com sucesso!");
            } else {
                status = ("STATUS--->Não foi possivel realizar conexão");
            }

            System.setProperty("jdbc.Driver", driver);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao se conectar com o banco de dados:\n" + ex.getMessage());
        }
    }

    public void desconecta() {
        try {
            conexao.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Desconectat BD:\n" + ex.getMessage());
        }
    }

    public static String statusConection() {
        return status;
    }

    public java.sql.Connection reiniciaConexao() {
        desconecta();
        conecta();
        return conexao;
    }

    public void executaSql(String sql) {
        try {
            stm = conexao.createStatement(rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
            rs = stm.executeQuery(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Executar SQL.\nErro:" + ex.getMessage());
        }
    }
}
