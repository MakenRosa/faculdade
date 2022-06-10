package polimorfismo;
public class Funcionario extends Pessoa{
    private final String carteiraProfissional;
    private final double salario;

    public Funcionario(String carteiraProfissional, double salario, String nome, long rg) {
        super(nome, rg);
        this.carteiraProfissional = carteiraProfissional;
        this.salario = salario;
    }

    public String getCarteiraProfissional() {
        return carteiraProfissional;
    }

    public double getSalario() {
        return salario;
    }
    
}
