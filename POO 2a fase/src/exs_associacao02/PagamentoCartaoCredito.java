package exs_associacao02;
public class PagamentoCartaoCredito extends FormaPagamento{
    private String nomeTipoDePagamento;
    private CartaoFidelidade cartao;

    public PagamentoCartaoCredito(String nomeTipoDePagamento, CartaoFidelidade cartao) {
        this.nomeTipoDePagamento = nomeTipoDePagamento;
        this.cartao = cartao;
    }

    public String getNomeTipoDePagamento() {
        return nomeTipoDePagamento;
    }

    public void setNomeTipoDePagamento(String nomeTipoDePagamento) {
        this.nomeTipoDePagamento = nomeTipoDePagamento;
    }

    public CartaoFidelidade getCartao() {
        return cartao;
    }

    public void setCartao(CartaoFidelidade cartao) {
        this.cartao = cartao;
    }
    
}
