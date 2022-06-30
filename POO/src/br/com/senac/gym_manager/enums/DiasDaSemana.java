package br.com.senac.gym_manager.enums;
public enum DiasDaSemana {
    SEGUNDA_FEIRA("Segunda Feira"),
    TERCA_FEIRA("Terça Feira"),
    QUARTA_FEIRA("Quarta Feira"),
    QUINTA_FEIRA("Quinta Feira"),
    SEXTA_FEIRA("Sexta Feira");
    
    private final String dia;
    
    DiasDaSemana(String dia){
        this.dia = dia;
    }

    public String getDia() {
        return this.dia;
    }
    
}
