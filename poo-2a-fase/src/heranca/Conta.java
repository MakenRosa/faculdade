package heranca;
public class Conta {
    protected double saldo;
    private final String numero;
    private static final double taxaIFN = 0.038;

    public Conta(double saldo, Cliente titular, Agencia agencia, String numero) {
        this.saldo = saldo;
        this.numero = numero;
    }
    
    public void saque(double valor){
        if (valor < this.saldo){
            this.saldo -= valor;
        } else{
            System.err.println("Saldo insuficiente!");
        }
    }
    public void imprimeDados(){
        System.out.println("Número da conta: "+ this.numero +"\nSaldo: "+ this.saldo + "\nTaxa IFN: "+ taxaIFN);
    }
    public double getSaldo(){
        return this.saldo;
    }
    protected void acumularIFN(double valorSaque){
        System.out.println(taxaIFN); //Não sei pra que serve
    }
}
