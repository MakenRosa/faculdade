package trabalho_final_poo;
class Exercicio {
     private String nome;
     private int repeticoes;
     private int series;
     private String equipamento;

    public Exercicio(String nome, int repeticoes, int series) {
        this.nome = nome;
        this.repeticoes = repeticoes;
        this.series = series;
    }

    public Exercicio(String nome, int repeticoes, int series, String equipamento) {
        this.nome = nome;
        this.repeticoes = repeticoes;
        this.series = series;
        this.equipamento = equipamento;
    }
     
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getRepeticoes() {
        return repeticoes;
    }

    public void setRepeticoes(int repeticoes) {
        this.repeticoes = repeticoes;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public String getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(String equipamento) {
        this.equipamento = equipamento;
    }
     
}
