package trabalho_final_poo;

import java.util.ArrayList;
import java.util.List;

class Treinamento {
     private String nome;
     private List<Exercicio> exercicios;
     private DiasDaSemana diaDaSemana;

    public Treinamento(String nome, List<Exercicio> exercicios, DiasDaSemana diaDaSemana) {
        this.nome = nome;
        this.exercicios = exercicios;
        this.diaDaSemana = diaDaSemana;
    }
    public Treinamento(String nome, List<Exercicio> exercicios) {
        this.nome = nome;
        this.exercicios = exercicios;
    }
    
    public Treinamento(String nome, Exercicio exercicio, DiasDaSemana diaDaSemana) {
        this.nome = nome;
        this.exercicios = new ArrayList();
        this.exercicios.add(exercicio);
        this.diaDaSemana = diaDaSemana;
    }
    
    public void adicionarExercicio(Exercicio exercicio){
        this.exercicios.add(exercicio);
        System.out.println("Exercício adicionado!");
    }
    
    public void removerExercicio(String nomeExercicio){
        boolean isInLista = false;
        for (Exercicio exercicio: getExercicios()){
            if (exercicio.getNome().equalsIgnoreCase(nomeExercicio)){
                this.exercicios.remove(exercicio);
                isInLista = true;
                System.out.println("Exercício removido!");
                break;
            }
        }
        if (isInLista == false){
            System.out.println("O exercício não está na lista!");
        }
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Exercicio> getExercicios() {
        return exercicios;
    }

    public void setExercicios(List<Exercicio> exercicios) {
        this.exercicios = exercicios;
    }

    public DiasDaSemana getDiaDaSemana() {
        return diaDaSemana;
    }

    public void setDiaDaSemana(DiasDaSemana diaDaSemana) {
        this.diaDaSemana = diaDaSemana;
    }
     
     
}
