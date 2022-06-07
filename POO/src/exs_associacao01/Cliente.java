package exs_associacao01;
import java.util.ArrayList;
import java.util.List;
public class Cliente {
    private String nome;
    private long cpf;
    private byte[] senha;

    public Cliente(String nome, long cpf, byte[] senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
    }
    public String getNome() {
        return this.nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public long getCpf() {
        return this.cpf;
    }
    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public void setSenha(byte[] senha) {
        this.senha = senha;
    }
}
