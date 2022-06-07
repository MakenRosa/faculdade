package exs_associacao01;

public class Teste {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("Maken", 44521047856L, new byte[]{123, 122, 14, 120, 76});
        System.out.println(cliente.getCpf());
    }
}
