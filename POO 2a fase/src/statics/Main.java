package statics;
public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("Maken", TipoPessoa.PESSOA_FISICA);
        System.out.print(cliente.getTipoCliente());
    }
}
