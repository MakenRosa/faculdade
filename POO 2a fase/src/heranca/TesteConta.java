package heranca;
public class TesteConta {
    public static void main(String[] args) {
        ContaEspecial contaEspecial = new ContaEspecial(2850, 200, new Cliente("Maken"), new Agencia(0001), "01");
        contaEspecial.saque(130);
        contaEspecial.imprimeDados();
    }
}
