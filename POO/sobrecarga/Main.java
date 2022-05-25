package sobrecarga;
public class Main {
    public static void main(String[] args) {
        /*Gerente gerente = new Gerente();
        gerente.setNome("Minato");
        gerente.setSalario(1000);
        gerente.aumentaSalario();
        System.out.println(gerente.getSalario());
        gerente.aumentaSalario(50);
        System.out.println(gerente.getSalario());*/
        Produto sabao = new Produto();
        sabao.valoresIniciais("sabao", "OMO", 10);
        sabao.imprimir();
        sabao.aumentarPreco(500);
        sabao.imprimir();
        sabao.aumentarPreco();
        sabao.imprimir();
    }
}
