package exs_associacao01;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {
    private Cliente cliente;
    private List<ItemDeCompra> itens;

    public Carrinho(){
        itens = new ArrayList<>();
    }
    public Carrinho(Cliente cliente){
        itens = new ArrayList<>();
        this.cliente = cliente;
    }
    public void adicionar(Produto prod, int qtd){
        ItemDeCompra itemDeCompra = new ItemDeCompra(prod, qtd);
        itens.add(itemDeCompra);
    }
    public void remover(Produto prod, int qtd){
        for (ItemDeCompra itemDeCompra : itens) {
            if (itemDeCompra.getProduto().equals(prod)){
                itemDeCompra.setQuantidade(itemDeCompra.getQuantidade() - qtd);
            }
        }
    }
    public void eliminar(Produto prod){
        for (ItemDeCompra itemDeCompra : itens){
            if (itemDeCompra.getProduto().equals(prod)){
                itens.remove(itemDeCompra);
                break;
            }
        }
    }
    public double calcularTotal(){
        double valorTotal = 0.00;
        for (ItemDeCompra item : itens) {
            valorTotal += (item.getProduto().getPreco() * item.getQuantidade());
        }
        return valorTotal;
    }
    public ItemDeCompra buscaItem(Produto prod) throws RuntimeException{
        for (ItemDeCompra item : itens) {
            if (item.getProduto().equals(prod)){
                return item;
            }
        }
        return null;
    }

    public List<ItemDeCompra> getItens(){
        return this.itens;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setItens(List<ItemDeCompra> itens) {
        this.itens = itens;
    }
}
