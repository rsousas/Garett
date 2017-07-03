package Modelo;

public class MCategoria {

    private Integer codcat;
    private String descricao;
    private boolean ativo;
    private String usuario;

    public Integer getCodcat() {
        return codcat;
    }

    public void setCodcat(Integer codcat) {
        this.codcat = codcat;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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
