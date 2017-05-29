package Modelo;

public class MCategoria {

    private String descricao;
    private Integer codigoPai;
    private boolean ativo;
    private String usuario;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getCodigoPai() {
        return codigoPai;
    }

    public void setCodigoPai(Integer codigoPai) {
        this.codigoPai = codigoPai;
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