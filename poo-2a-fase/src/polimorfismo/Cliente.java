package polimorfismo;
public class Cliente extends Pessoa{
    private String cpf;

    public Cliente(String cpf,String nome, long rg) {
        super(nome, rg);
        this.cpf = cpf;
    }

    public Cliente() {
    }
    
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
}
