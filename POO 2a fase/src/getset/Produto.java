package getset;
public class Produto {
    private String descricao;
    private String marca;
    private double preco;
    private boolean vendido;
    public String getDescricao(){
        return this.descricao;
    }
    public String getMarca(){
        return this.marca;
    }
    public void setDescricao(String descricao){
        this.descricao = descricao.trim();
    }
    public void setMarca(String marca){
        this.marca = marca;
    }
    public void vender(){
        this.vendido = true;
    }
    public boolean isVendido(){
        return this.vendido;
    }
    public double getPreco(){
        return this.preco;
    }
    public void alterarPreco(double preco){
        this.preco = preco;
    }
    public void aumentarPreco(double porcentagem){
        this.preco += (this.preco*(porcentagem/100));
    }
    public void imprime(){
        System.out.printf("Marca: %s\nDescrição: %s\nPreço: %.2f\n", this.marca, this.descricao, this.preco);
    }
    public void valoresIniciais(double umPreco, String umaDescricao, String umaMarca){
        this.preco = umPreco;
        this.descricao = umaDescricao;
        this.marca = umaMarca;
    }
}
