package trabalho_final_poo;

public class ClienteExperimental extends Pessoa{
    private String dataAulaExperimental;
    private Treinamento treinamento;

    public ClienteExperimental(String nome, String cpf, int idade,
            String telefone, String endereco, String dataAulaExperimental,
            Treinamento treinamento) {
        super(nome, cpf, idade, telefone, endereco);
        this.dataAulaExperimental = dataAulaExperimental;
        this.treinamento = treinamento;
    }

    public ClienteExperimental(String nome, String cpf, int idade,
            String telefone, String endereco, String dataAulaExperimental) {
        super(nome, cpf, idade, telefone, endereco);
        this.dataAulaExperimental = dataAulaExperimental;
    }

    public ClienteExperimental(String nome, String cpf, int idade,
            String telefone, String endereco) {
        super(nome, cpf, idade, telefone, endereco);
    }
    
    public String getDataAulaExperimental() {
        return dataAulaExperimental;
    }

    public Treinamento getTreinamento() {
        return treinamento;
    }

    public void setDataAulaExperimental(String dataAulaExperimental) {
        this.dataAulaExperimental = dataAulaExperimental;
    }

    public void setTreinamento(Treinamento treinamento) {
        this.treinamento = treinamento;
    }
    
}
