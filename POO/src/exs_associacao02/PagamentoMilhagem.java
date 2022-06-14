package exs_associacao02;
public class PagamentoMilhagem extends FormaPagamento{
    private String nomeTipoDePagamento;
    private int milhasDisponiveis;

    public PagamentoMilhagem(String nomeTipoDePagamento, int milhasDisponiveis) {
        this.nomeTipoDePagamento = nomeTipoDePagamento;
        this.milhasDisponiveis = milhasDisponiveis;
    }

    public String getNomeTipoDePagamento() {
        return nomeTipoDePagamento;
    }

    public void setNomeTipoDePagamento(String nomeTipoDePagamento) {
        this.nomeTipoDePagamento = nomeTipoDePagamento;
    }

    public int getMilhasDisponiveis() {
        return milhasDisponiveis;
    }

    public void setMilhasDisponiveis(int milhasDisponiveis) {
        this.milhasDisponiveis = milhasDisponiveis;
    }
    
}
