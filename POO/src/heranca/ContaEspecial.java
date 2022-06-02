package heranca;
public class ContaEspecial extends Conta{
    private double limite;
    private double totalDescontosSaque;

    public ContaEspecial(double limite, double saldo, Cliente titular, Agencia agencia, String numero) {
        super(saldo, titular, agencia, numero);
        this.limite = limite;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }
    
    @Override
    public void imprimeDados(){
        super.imprimeDados();
        System.out.println("Limite: "+ this.limite);
    }

    public double getTotalDescontosSaque() {
        return totalDescontosSaque;
    }

    public void setTotalDescontosSaque(double totalDescontosSaque) {
        this.totalDescontosSaque = totalDescontosSaque;
    }
    
    @Override
    public void saque(double valor){
        this.totalDescontosSaque += 0.10;
        valor += 0.10;
        super.saque(valor);
    }
}
