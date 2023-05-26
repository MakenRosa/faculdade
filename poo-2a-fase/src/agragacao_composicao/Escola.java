package agragacao_composicao;

import java.util.ArrayList;
import java.util.List;

public class Escola {
    private String nome;
    private int id;
    private final List<Departamento> departamentos;
    
    public Escola(){
        this.departamentos = new ArrayList();
    }

    public List<Departamento> getDepartamentos() {
        return departamentos;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
    
}
