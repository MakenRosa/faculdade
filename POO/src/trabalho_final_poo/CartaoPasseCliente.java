package trabalho_final_poo;
class CartaoPasseCliente {
    private String codCartao;
    private int entradasHoje;
    private boolean ativo;
    private CatracaAcademia catraca;

    public CartaoPasseCliente(String codCartao) {
        this.codCartao = codCartao;
        setAtivo(true);
    }

    public CartaoPasseCliente(String codCartao, CatracaAcademia catraca) {
        this.codCartao = codCartao;
        this.ativo = true;
        this.catraca = catraca;
    }
    
    public void registrarEntrada(){
        setEntradasHoje(getEntradasHoje()+1);
    }
    
    public String getCodCartao() {
        return codCartao;
    }

    public void setCodCartao(String codCartao) {
        this.codCartao = codCartao;
    }

    public int getEntradasHoje() {
        return entradasHoje;
    }

    public void setEntradasHoje(int entradasHoje) {
        this.entradasHoje = entradasHoje;
    }

    public CatracaAcademia getCatraca() {
        return catraca;
    }

    public void setCatraca(CatracaAcademia catraca) {
        this.catraca = catraca;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
    
}
