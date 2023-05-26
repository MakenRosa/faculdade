package expoo;

import java.util.ArrayList;
import java.util.List;

public class Departamento {
    private String nome;
    private List<Pessoa> pessoas;
    
    public Departamento(){
        pessoas = new ArrayList();
    }
    public void adicionarPessoa(Pessoa pessoa){
        pessoas.add(pessoa);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }
}
