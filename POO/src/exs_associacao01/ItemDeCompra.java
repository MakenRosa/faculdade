package exs_associacao01;

public class ItemDeCompra {
    private int quantidade;
    private Produto produto;

    public ItemDeCompra(Produto produto, int quantidade) {
        this.quantidade = quantidade;
        this.produto = produto;
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
