package Controle;

import Modelo.MTransacoes;
import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
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

        if (!"T".equals(transac.getTipo()) && transac.getDescricao().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe a Descrição para continuar!");
            return false;
        }
        if (!"T".equals(transac.getTipo()) && transac.getConta().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe uma Conta para continuar!");
            return false;
        }

        if ("T".equals(transac.getTipo()) && transac.getConta().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe uma Conta de Origem para continuar!");
            return false;
        }

        if ("T".equals(transac.getTipo()) && transac.getConta().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe uma Conta de Destino para continuar!");
            return false;
        }

        if (!"T".equals(transac.getTipo()) && transac.getCateg().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe uma Categoria para continuar!");
            return false;
        }

        return true;
    }

    public void Salvar(MTransacoes transac) {
        Calendar lembrete = new GregorianCalendar();
        int codCat;
        int codCon;
        int codConDest;

        java.sql.Date dataSql = new java.sql.Date(transac.getData().getTime()); // É necessário converter util.Date para sql.Date
        lembrete.setTime(dataSql);
        lembrete.add(Calendar.DATE, transac.getLembrete());
        java.sql.Date dataLembrete = new java.sql.Date(lembrete.getTime().getTime());
        codCon = buscaCodConta(transac.getConta());

        conexao.conecta();
        try {
            if (!"T".equals(transac.getTipo())) {
                codCat = buscaCodCategoria(transac.getCateg());
                PreparedStatement pst = conexao.conexao.prepareStatement("insert into TRANSACAO (DESCRTRA, DATA, PAGO, LEMBRETE, NOTA, VALOR, TIPO, CODCAT, CODCON, CODUSU) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
                pst.setString(1, transac.getDescricao());
                pst.setDate(2, dataSql);
                pst.setInt(3, transac.getPago());
                pst.setDate(4, dataLembrete);
                pst.setString(5, transac.getNota().isEmpty() ? null : transac.getNota());
                pst.setFloat(6, transac.getValor());
                pst.setString(7, transac.getTipo());
                pst.setInt(8, codCat);
                pst.setInt(9, codCon);
                pst.setString(10, transac.getUsuario());
                pst.execute();
            } else {
                codConDest = buscaCodConta(transac.getContaDest());
                CallableStatement cst = conexao.conexao.prepareCall("{call I_TRANSFERENCIA (?, ?, ?, ?, ?, ?, ?, ?)}");
                cst.setDate(1, dataSql);
                cst.setInt(2, transac.getPago());
                cst.setDate(3, dataLembrete);
                cst.setString(4, transac.getNota().isEmpty() ? null : transac.getNota());
                cst.setFloat(5, transac.getValor());
                cst.setInt(6, codCon);
                cst.setInt(7, codConDest);
                cst.setString(8, transac.getUsuario());
                cst.execute();
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir Transação:\nErro:" + ex);
        }
        conexao.desconecta();
    }

    public void Editar(MTransacoes transac) {
        Calendar lembrete = new GregorianCalendar();
        int codCat;
        int codCon;
        int codConDest;

        java.sql.Date dataSql = new java.sql.Date(transac.getData().getTime()); // É necessário converter util.Date para sql.Date
        lembrete.setTime(dataSql);
        lembrete.add(Calendar.DATE, transac.getLembrete());
        java.sql.Date dataLembrete = new java.sql.Date(lembrete.getTime().getTime());
        codCon = buscaCodConta(transac.getConta());
        conexao.conecta();
        try {
            if (!"T".equals(transac.getTipo())) {
                codCat = buscaCodCategoria(transac.getCateg());
                PreparedStatement pst = conexao.conexao.prepareStatement("Update TRANSACAO set DESCRTRA = ?, DATA = ?, PAGO = ?, LEMBRETE = ?, NOTA = ?, VALOR = ?, TIPO = ?, CODCAT = ?, CODCON = ? where CODUSU = ? and CODTRA = ?");
                pst.setString(1, transac.getDescricao());
                pst.setDate(2, dataSql);
                pst.setInt(3, transac.getPago());
                pst.setDate(4, dataLembrete);
                pst.setString(5, transac.getNota());
                pst.setFloat(6, transac.getValor());
                pst.setString(7, transac.getTipo());
                pst.setInt(8, codCat);
                pst.setInt(9, codCon);
                pst.setString(10, transac.getUsuario());
                pst.setInt(11, transac.getCodtra());
                pst.execute();
            } else {
                codConDest = buscaCodConta(transac.getContaDest());
                CallableStatement cst = conexao.conexao.prepareCall("{call U_TRANSFERENCIA (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}");
                cst.setDate(1, dataSql);
                cst.setInt(2, transac.getPago());
                cst.setDate(3, dataLembrete);
                cst.setString(4, transac.getNota().isEmpty() ? null : transac.getNota());
                cst.setFloat(5, transac.getValor());
                cst.setInt(6, codCon);
                cst.setInt(7, codConDest);
                cst.setInt(8, transac.getCodtra());
                cst.setInt(9, transac.getCodtraDest());
                cst.setString(10, transac.getUsuario());
                cst.execute();

            }
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
        conexao.conecta();
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
        conexao.conecta();
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

    public ArrayList buscaTransacDestino(Integer codtra, String usuario) {
        ArrayList dados = new ArrayList();
        conexao.conecta();
        conexao.executaSql("select coalesce(CODTRA, 0) CODTRA, CODCON  \n"
                + "from TRANSACAO \n"
                + "where (CODTRATRANSF =  " + codtra + " OR CODTRA =  " + codtra + ") AND \n"
                + "       CODUSU = '" + usuario + "' AND \n"
                + "       TIPO = \"D\"\n"
                + "UNION ALL\n"
                + "select coalesce(CODTRA, 0) CODTRA, CODCON \n"
                + "from TRANSACAO \n"
                + "where (CODTRATRANSF =  " + codtra + " OR CODTRA =  " + codtra + ") AND \n"
                + "       CODUSU = '" + usuario + "' AND \n"
                + "       TIPO = \"R\";");
        try {
            conexao.rs.beforeFirst();
            while (conexao.rs.next()) {
                dados.add(conexao.rs.getInt("CODTRA"));
                dados.add(conexao.rs.getInt("CODCON"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CTransacoes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dados;
    }
}
