package br.com.senac.gym_manager.entidades;

public class ClienteExperimental extends Pessoa{
    private String dataAulaExperimental;
    private Treinamento treinamento;

    public ClienteExperimental(String nome, String cpf, int idade, String dataAulaExperimental,
            Treinamento treinamento) {
        super(nome, cpf, idade);
        this.dataAulaExperimental = dataAulaExperimental;
        this.treinamento = treinamento;
        System.out.println("Cliente Experimental criado!");
    }

    public ClienteExperimental(String nome, String cpf, int idade, String dataAulaExperimental) {
        super(nome, cpf, idade);
        this.dataAulaExperimental = dataAulaExperimental;
        System.out.println("Cliente Experimental criado!");
}

    public ClienteExperimental(String nome, String cpf, int idade) {
        super(nome, cpf, idade);
        System.out.println("Cliente Experimental criado!");
}
    
    public String getDataAulaExperimental() {
        return dataAulaExperimental;
    }

    public Treinamento getTreinamento() {
        return treinamento;
    }

    public void setDataAulaExperimental(String dataAulaExperimental) {
        this.dataAulaExperimental = dataAulaExperimental;
        System.out.println("Data da aula experimental definida!");
    }

    public void setTreinamento(Treinamento treinamento) {
        this.treinamento = treinamento;
        System.out.println("Treinamento setado (experimental)");
    }
    
}
