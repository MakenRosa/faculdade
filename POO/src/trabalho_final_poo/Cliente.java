package trabalho_final_poo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Cliente extends Pessoa{
    private int codInscricao;
    private List<Treinamento> treinamentos;
    private Mensalidade mensalidade;
    private CartaoPasseCliente cartao;

    public Cliente(int codInscricao, String nome, String cpf, int idade, String telefone, String endereco, Mensalidade mensalidade) {
        super(nome, cpf, idade, telefone, endereco);
        this.codInscricao = codInscricao;
        this.treinamentos = new ArrayList();
        this.mensalidade = mensalidade;
    }

    public Cliente(int codInscricao, CartaoPasseCliente cartao, String nome, String cpf, int idade, String telefone, String endereco, Mensalidade mensalidade) {
        super(nome, cpf, idade, telefone, endereco);
        this.codInscricao = codInscricao;
        this.cartao = cartao;
        this.treinamentos = new ArrayList();
        this.mensalidade = mensalidade;
    }
    
    private void atualizarCartao(){
        if (mensalidade.getStatus().equals(StatusPagamento.PAGAMENTO_REALIZADO.getStatus())){
            this.cartao.setAtivo(true);
        }else{
            this.cartao.setAtivo(false);
        }
    }
    
    
    private void inserirCartao () throws NullPointerException, NaoCadastradoException, ExcedeuLimiteDeEntradaException, CartaoDesativadoException{
        System.out.println("Inseriu o cartão!");
        this.atualizarCartao();
        this.cartao.getCatraca().passarCartao(cartao.getCodCartao());
    }
    public void entrarNaAcademia(){
        try{
            this.inserirCartao();
            System.out.println("Passou na catraca!");
            this.cartao.getCatraca().fecharCatraca();
        } catch(NullPointerException ex){
            System.out.println("Catraca inválida! ");
        } catch(NaoCadastradoException | ExcedeuLimiteDeEntradaException | CartaoDesativadoException ex){
            System.out.println("Cartão inválido! " + ex.getMessage());
        }
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
            System.out.println("O treinamento não está na lista!");
        }
    }
        
    public void mostrarTreinos(){
        for (Treinamento treino : this.treinamentos){
            System.out.println(treino.getNome());
        }
    }

    public void pagarMensalidade(){
        this.getMensalidade().setStatus(StatusPagamento.PAGAMENTO_REALIZADO);
        LocalDate dataPagamento= LocalDate.now();
        this.mensalidade.setDataDoPagamento(dataPagamento);
        System.out.println("Pagou!");
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

    public CartaoPasseCliente getCartao() {
        return cartao;
    }

    public void setCartao(CartaoPasseCliente cartao) {
        this.cartao = cartao;
    }

    public Mensalidade getMensalidade() {
        return mensalidade;
    }

    public void setMensalidade(Mensalidade mensalidade) {
        this.mensalidade = mensalidade;
    }
    
    
}
