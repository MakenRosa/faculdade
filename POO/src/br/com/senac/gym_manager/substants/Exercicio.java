package br.com.senac.gym_manager.substants;
public class Exercicio {
     private String nome;
     private int repeticoes;
     private int series;
     private String equipamento;

    public Exercicio(String nome, int repeticoes, int series) {
        this.nome = nome;
        this.repeticoes = repeticoes;
        this.series = series;
        System.out.println("Exercício criado!");
    }

    public Exercicio(String nome, int repeticoes, int series, String equipamento) {
        this.nome = nome;
        this.repeticoes = repeticoes;
        this.series = series;
        this.equipamento = equipamento;
        System.out.println("Exercício criado!");
    }
     
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
        System.out.println("Nome do exercício trocado!");
    }

    public int getRepeticoes() {
        return repeticoes;
    }

    public void setRepeticoes(int repeticoes) {
        this.repeticoes = repeticoes;
        System.out.println("Número de repetições do exercícios foi mudada!");
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
        System.out.println("Número de séries do exercício foi trocada!");
    }

    public String getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(String equipamento) {
        this.equipamento = equipamento;
        System.out.println("Equipamento do exercício atribuído ou trocado!");
    }
     
}
