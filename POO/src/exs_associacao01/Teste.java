package exs_associacao01;

public class Teste {
    public static void main(String[] args) {
        //Criando Produto(s)
        Produto produto1 = new Produto("Coca-cola", "Refrigerante 2L...", 8.50, );
        //Criando Catalogo
        Catalogo catalogo = new Catalogo("Mercado Ipiranga");
        catalogo.
        //Criando/testando o Cliente
        Cliente cliente = new Cliente("Maken", 44521047856L, new byte[]{123, 122, 14, 120, 76});
        System.out.println(cliente.getCpf());
        cliente.setNome("Maken da Rosa");
        System.out.println(cliente.getNome());
    }
}
