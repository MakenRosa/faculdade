package trabalho_final_poo;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Pessoa{
    private int codInscricao;
    private List<Treinamento> treinamentos;
    private boolean ativo;
    private List<Mensalidade> mensalidades;
    private CartaoPasseCliente cartao;

    public Cliente(int codInscricao, boolean ativo, String nome, String cpf, int idade, String telefone, String endereco) {
        super(nome, cpf, idade, telefone, endereco);
        this.codInscricao = codInscricao;
        this.ativo = ativo;
        this.treinamentos = new ArrayList();
        this.mensalidades = new ArrayList();
    }

    public Cliente(int codInscricao, boolean ativo, CartaoPasseCliente cartao, String nome, String cpf, int idade, String telefone, String endereco) {
        super(nome, cpf, idade, telefone, endereco);
        this.codInscricao = codInscricao;
        this.ativo = ativo;
        this.cartao = cartao;
        this.treinamentos = new ArrayList();
        this.mensalidades = new ArrayList();
    }
    
    public void inserirCartao(){
        this.cartao.getCatraca().passarCartao(cartao.getCodCartao());
        System.out.println("Inseriu o cartão!");
    }
    public void entrarNaAcademia(){
        System.out.println("Passou na catraca!");
        this.cartao.getCatraca().fecharCatraca();
    }
    
    public void adicionarTreinamento(Treinamento treinamento){
        this.treinamentos.add(treinamento);
        System.out.println("Treinamento adicionado!");
    }
    
    public void removerTreinamento(String nomeTreinamento){
        boolean isInLista = false;
        for (Treinamento treinamento : getTreinamentos()){
            if (treinamento.getNome().equalsIgnoreCase(nomeTreinamento)){
                this.treinamentos.remove(treinamento);
                isInLista = true;
                System.out.println("Treinamento removido!");
                break;
            }
        }
        if (isInLista == false){
            System.err.println("O treinamento não está na lista!");
        }
    }
    
    public void adicionarMensalidade(Mensalidade mensalidade){
        this.mensalidades.add(mensalidade);
        System.out.println("Mensalidade adicionada");
    }
    
    public void removerMensalidade(Mensalidade mensalidade){
        this.mensalidades.remove(mensalidade);
        System.out.println("Mensalidade removida!");
    }
    
    public int getCodInscricao() {
        return codInscricao;
    }

    public void setCodInscricao(int codInscricao) {
        this.codInscricao = codInscricao;
    }

    public List<Treinamento> getTreinamentos() {
        return treinamentos;
    }

    public void setTreinamentos(List<Treinamento> treinamentos) {
        this.treinamentos = treinamentos;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public List<Mensalidade> getMensalidades() {
        return mensalidades;
    }

    public void setMensalidades(List<Mensalidade> mensalidades) {
        this.mensalidades = mensalidades;
    }

    public CartaoPasseCliente getCartao() {
        return cartao;
    }

    public void setCartao(CartaoPasseCliente cartao) {
        this.cartao = cartao;
    }
    
    
}
