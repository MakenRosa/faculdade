package heranca;
public class ContaPoupanca extends Conta{
    private String dataAniversario;

    public ContaPoupanca(String dataAniversario, double saldo, Cliente titular, Agencia agencia, String numero) {
        super(saldo, titular, agencia, numero);
        this.dataAniversario = dataAniversario;
    }

    public String getDataAniversario() {
        return dataAniversario;
    }

    public void setDataAniversario(String dataAniversario) {
        this.dataAniversario = dataAniversario;
    }
    @Override
    public void imprimeDados(){
        super.imprimeDados();
        System.out.println("Data de aniversário: " + this.getDataAniversario());
    }
}
