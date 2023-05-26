package exs_associacao02;
public class PagamentoDescontoCarteira extends FormaPagamento{
    private String nomeTipoDePagamento;
    private double valorDisponivelCarteira;

    public PagamentoDescontoCarteira(String nomeTipoDePagamento, double valorDisponivelCarteira) {
        this.nomeTipoDePagamento = nomeTipoDePagamento;
        this.valorDisponivelCarteira = valorDisponivelCarteira;
    }

    public String getNomeTipoDePagamento() {
        return nomeTipoDePagamento;
    }

    public void setNomeTipoDePagamento(String nomeTipoDePagamento) {
        this.nomeTipoDePagamento = nomeTipoDePagamento;
    }

    public double getValorDisponivelCarteira() {
        return valorDisponivelCarteira;
    }

    public void setValorDisponivelCarteira(double valorDisponivelCarteira) {
        this.valorDisponivelCarteira = valorDisponivelCarteira;
    }
    
}
