package trabalho_final_poo;
class CartaoPasseCliente {
    private String codCartao;
    private int entradasHoje = 0;
    private boolean ativo;
    private CatracaAcademia catraca;

    public CartaoPasseCliente(String codCartao) {
        this.codCartao = codCartao;
        System.out.println("Cartão criado!");
    }

    public CartaoPasseCliente(String codCartao, CatracaAcademia catraca) {
        this.codCartao = codCartao;
        this.catraca = catraca;
        System.out.println("Cartão criado!");
    }
    
    public void registrarEntrada(){
        setEntradasHoje(getEntradasHoje()+1);
    }
    
    public String getCodCartao() {
        return codCartao;
    }

    public void setCodCartao(String codCartao) {
        this.codCartao = codCartao;
        System.out.println("Código do cartão atribuído ao cartão!");
    }

    public int getEntradasHoje() {
        return entradasHoje;
    }

    public void setEntradasHoje(int entradasHoje) {
        this.entradasHoje = entradasHoje;
    }

    public CatracaAcademia getCatraca(){
        return catraca;
    }

    public void setCatraca(CatracaAcademia catraca) {
        this.catraca = catraca;
        System.out.println("Cartão atribuído a catraca!");
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
    
}
