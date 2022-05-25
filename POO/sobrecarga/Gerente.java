package sobrecarga;
public class Gerente {
    private String nome;
    private double salario;

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public double getSalario() {
        return salario;
    }
    public void setSalario(double salario) {
        this.salario = salario;
    }
    public void aumentaSalario(double taxa){
        this.salario += (getSalario()*taxa);
    }
    public void aumentaSalario(){
        this.aumentaSalario(0.1);
    }
}
 