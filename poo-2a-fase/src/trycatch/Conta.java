package trycatch;
public class Conta {
    private int numero;
    private double saldo;
    
    public Conta(int numero, double saldo) {
        this.numero = numero;
        this.saldo = saldo;
    }
    public void depositar(double valor) throws ContaException{
        if (valor > 1000){
            throw new ContaException("Valor de depósito muito alto! R$" + valor);
        }
        this.saldo += valor;
    }
    public void sacar(double valor) throws ContaException{
        if (valor>500.0 || this.saldo - valor < 0){
            throw new ContaException("Valor de saque muito alto! R$"+ valor);
        }
        this.saldo -= valor;
    }

    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public double getSaldo() {
        return saldo;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
