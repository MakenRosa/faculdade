package exs_associacao01;
import java.util.ArrayList;
import java.util.List;
public class Cliente {
    private String nome;
    private long cpf;
    private byte[] senha;
    private Carrinho carrinho;

    public Cliente(String nome, long cpf, byte[] senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
    }
    public Cliente(String nome, long cpf, byte[] senha, Carrinho carrinho) {
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
        this.carrinho = carrinho;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public long getCpf() {
        return cpf;
    }
    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public void setSenha(byte[] senha) {
        this.senha = senha;
    }
    public Carrinho getCarrinho() {
        return carrinho;
    }
    public void setCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
    }
}
