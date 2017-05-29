package Modelo;

public class MTransacoes {

    private String Descricao;
    private String Data;
    private boolean Pago;
    private Integer Lembrete;
    private String Nota;
    private Float Valor;
    private String Tipo;
    private String CodCat;
    private String CodCon;
    private String CodUsu;
    private String CodTransf;
    private String usuario;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    public String getData() {
        return Data;
    }

    public void setData(String Data) {
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

    public String getCodCat() {
        return CodCat;
    }

    public void setCodCat(String CodCat) {
        this.CodCat = CodCat;
    }

    public String getCodCon() {
        return CodCon;
    }

    public void setCodCon(String CodCon) {
        this.CodCon = CodCon;
    }

    public String getCodUsu() {
        return CodUsu;
    }

    public void setCodUsu(String CodUsu) {
        this.CodUsu = CodUsu;
    }

    public String getCodTransf() {
        return CodTransf;
    }

    public void setCodTransf(String CodTransf) {
        this.CodTransf = CodTransf;
    }

}
