package associacoes;

import java.util.ArrayList;
import java.util.List;

public class Pessoa {
    private String nome;
    private List<Endereco> enderecos;
    
    public Pessoa(){
        this.enderecos = new ArrayList();
    }
    
    public void adicionarEndereco(Endereco endereco) throws NullPointerException{
        if (endereco == null ||
            endereco.getRua() == null ||
            "".equals(endereco.getRua().trim())){
            throw new NullPointerException("Endereço inválido!");
        }
        this.enderecos.add(endereco);
    }
    
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public List<Endereco> getEnderecos() {
        return this.enderecos;
    }
    
    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

}
    

