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

    }
    public void remover(Produto prod, int qtd){

    }
    public void eliminar(Produto prod){

    }
    public double calcularTotal()
    {
        return 0;
    }
    public ItemDeCompra buscaItem(Produto prod){
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
