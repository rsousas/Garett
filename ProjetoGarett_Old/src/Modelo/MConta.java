package Modelo;

public class MConta {

    private String descricao;
    private Float Saldo;
    private boolean ativo;
    private String usuario;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Float getSaldo() {
        return Saldo;
    }

    public void setSaldo(String Saldo) {
        this.Saldo = Float.parseFloat(Saldo);
    }

    public Integer getAtivo() {
        if (ativo) {
            return 1;
        } else {
            return 0;
        }
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}
