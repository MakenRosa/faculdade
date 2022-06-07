package exs_associacao01;

public class ItemDeCompra {
    private int quantidade;
    private Produto produto;
    private Carrinho carrinho;

    public ItemDeCompra(int quantidade, Produto produto, Carrinho carrinho) {
        this.quantidade = quantidade;
        this.produto = produto;
        this.carrinho = carrinho;
    }
    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    public Produto getProduto() {
        return produto;
    }
    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}
