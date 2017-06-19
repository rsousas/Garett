package Modelo;

import java.util.Date;

public class MTransacoes {

    private Integer Codtra;
    private String Descricao;
    private Date Data;
    private boolean Pago;
    private Integer Lembrete;
    private String Nota;
    private Float Valor;
    private String Tipo;
    private String Categ;
    private String Conta;
    private Integer CodTransf;
    private String usuario;

    public Integer getCodtra() {
        return Codtra;
    }

    public void setCodtra(Integer Codtra) {
        this.Codtra = Codtra;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    public Date getData() {
        return Data;
    }

    public void setData(Date Data) {
        this.Data = Data;
    }

    public Integer getPago() {
        if (Pago) {
            return 1;
        } else {
            return 0;
        }
    }

    public void setPago(boolean Pago) {
        this.Pago = Pago;
    }

    public Integer getLembrete() {
        return Lembrete;
    }

    public void setLembrete(Integer Lembrete) {
        this.Lembrete = Lembrete;
    }

    public String getNota() {
        return Nota;
    }

    public void setNota(String Nota) {
        this.Nota = Nota;
    }

    public Float getValor() {
        return Valor;
    }

    public void setValor(String Valor) {
        this.Valor = Float.parseFloat(Valor);
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public String getCateg() {
        return Categ;
    }

    public void setCateg(String Categ) {
        this.Categ = Categ;
    }

    public String getConta() {
        return Conta;
    }

    public void setConta(String Conta) {
        this.Conta = Conta;
    }

    public Integer getCodTransf() {
        return CodTransf;
    }

    public void setCodTransf(Integer CodTransf) {
        this.CodTransf = CodTransf;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

}
