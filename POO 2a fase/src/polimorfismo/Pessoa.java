package polimorfismo;
public class Pessoa{
    private String nome;
    private long rg;

    public Pessoa(String nome, long rg) {
        this.nome = nome;
        this.rg = rg;
    }

    public Pessoa() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getRg() {
        return rg;
    }

    public void setRg(long rg) {
        this.rg = rg;
    }
    
}
