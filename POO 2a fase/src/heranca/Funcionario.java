package heranca;
public class Funcionario extends Pessoa {
    private long carteiraProfissional;
    private double salario;
    private String dataAdmissao;

    public Funcionario(String nome, String rg, Endereco endereco) {
        super(nome, rg, endereco);
    }

    public long getCarteiraProfissional() {
        return carteiraProfissional;
    }

    public void setCarteiraProfissional(long carteiraProfissional) {
        this.carteiraProfissional = carteiraProfissional;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(String dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }
    
    public void impressaoRecibo(int dia, int mes, int ano){
        System.out.println("Eu, "+ super.nome + ", portador do RG: "+ super.rg + ",\nEndereço: "+
                super.endereco.getRua()+ ", " + super.endereco.getNumero()+
                "\nDeclaro que recebi R$"+this.salario + " no dia "+ dia +"/"+mes+"/"+ano);
    }
    @Override
    public void imprime(){
        System.out.println("Nome: "+ nome + "\nRG: " + rg + "\nEndereço: "+ endereco.getRua()+ ", "
        + endereco.getNumero()+"\nCarteira: "+ carteiraProfissional + "\nSalário: R$"+ salario +
                "\nData de admissão: "+dataAdmissao);
    }
}
