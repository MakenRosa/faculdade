package exs_associacao01;

import java.util.ArrayList;
import java.util.List;

public class Teste {
    public static void main(String[] args) {
        // instanciando/testando o Produto ====================================
        Produto arroz = new Produto("Arroz", "Arroz 1kg Tio João",
                6.00, new byte[]{84, 34, 55, 75}, "AS452D1FC");
        Produto feijao = new Produto("Feijão", "Feijão 1kg Camil",
                10.00, new byte[]{77, 22, 15, 18}, "FD854X2VZ");
        Produto suco = new Produto("Suco", "Suco Tang 25g Abacaxi",
                2, new byte[]{13, 45, 88, 120}, "FD544CZ6FG");
        System.out.println("Nome: "+ arroz.getNome()+"\n"
                + "Descrição: "+ arroz.getDescricao()+"\n"
                        + "Preço: "+arroz.getPreco()+"\n"
                                + "Código: "+arroz.getCodigo()+"\n");
        
        // instanciando/testando o Catalogo ===================================
        List itemsCatalogo = new ArrayList();
        itemsCatalogo.add(suco);
        itemsCatalogo.add(feijao);
        itemsCatalogo.add(arroz);
        Catalogo mercado = new Catalogo("Mercado Ipiranga", itemsCatalogo);
        for (Produto produto : mercado.getProdutos()) {
            System.out.println(produto.getDescricao());
        }System.out.println("");
        
        // instanciando/testando o Carrinho/ItemDeCompra ======================
        Carrinho carrinho = new Carrinho();
        carrinho.adicionar(arroz, 3);
        carrinho.adicionar(feijao, 3);
        carrinho.adicionar(suco, 10);
        carrinho.remover(arroz, 1);
        carrinho.remover(feijao, 2);
        carrinho.eliminar(suco);
        List<ItemDeCompra> itensCarrinho = carrinho.getItens();
        System.out.println("Itens no carrinho: ");
        for (ItemDeCompra item : itensCarrinho) {
            System.out.println(item.getProduto().getDescricao() +
                    " - " + item.getQuantidade()+ " Unidade(s)");
        }
        System.out.println("Valor total de compra: R$"+ carrinho.calcularTotal()
                    + "\n");
        
        // instanciando/testando o Cliente ====================================
        Cliente cliente = new Cliente("Maken", 44521047856L,
                new byte[]{123, 122, 14, 120, 76});
        cliente.setNome("Maken da Rosa");
        System.out.println("Nome: "+ cliente.getNome()+"\n"
                + "CPF: "+ cliente.getCpf());
    
    }
}
