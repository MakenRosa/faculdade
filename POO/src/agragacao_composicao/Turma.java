package agragacao_composicao;

import java.util.ArrayList;
import java.util.List;

public class Turma {
    private String numero;
    private List<Estudante> estudantes;
    private Instrutor instrutor;
    
    public Turma(){
        this.estudantes = new ArrayList();
    }
    
    public void adicionarEstudante(Estudante estudante){
        if (estudante.isMatriculaAtiva()){
            this.estudantes.add(estudante);
        }   
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public List<Estudante> getEstudantes() {
        return estudantes;
    }

    public void setEstudantes(List<Estudante> estudantes) {
        this.estudantes = estudantes;
    }

    public Instrutor getInstrutor() {
        return instrutor;
    }

    public void setInstrutor(Instrutor instrutor) {
        this.instrutor = instrutor;
    }
    
}
