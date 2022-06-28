package trabalho_final_poo;

import java.util.ArrayList;
import java.util.List;

public class CatracaAcademia implements ControladorDeEntrada{
    private List<CartaoPasseCliente> cartoesCadastrados;
    private boolean fechada = true;
    private static final int ENTRADAS_POR_DIA = 1;

    public CatracaAcademia(List<CartaoPasseCliente> cartoesCadastrados) {
        this.cartoesCadastrados = cartoesCadastrados;
        System.out.println("Catraca criada!");
    }

    public CatracaAcademia() {
        this.cartoesCadastrados = new ArrayList();
        System.out.println("Catraca criada!");
    }
    
    @Override
    public void adicionarCartao(CartaoPasseCliente cartao){
        this.cartoesCadastrados.add(cartao);
        System.out.println("Cartão adicionado ao cliente!");
    }
    
    @Override
    public void excluirCartao(String CodigoDoCartao){
        boolean isInLista = false;
        for (CartaoPasseCliente cartao : this.getCartoesCadastrados()){
            if (cartao.getCodCartao().equals(CodigoDoCartao)){
                this.cartoesCadastrados.remove(cartao);
                isInLista = true;
                System.out.println("Cartão excluído!");
                break;
            }
        }
        if (isInLista == false){
            System.out.println("Código errado ou cartão não está cadastrado!");
        }
    }
    
    public void resetarEntradas(){
        try {
        for (CartaoPasseCliente cartao : this.getCartoesCadastrados()){
            cartao.setEntradasHoje(0);
        }
            System.out.println("Cartões da catraca resetados!");
        } catch (Exception ex){
            System.out.println("Ocorreu um erro! " + ex.getMessage());
        }
    }

    public void passarCartao(String CodigoDoCartao) throws NaoCadastradoException, ExcedeuLimiteDeEntradaException, CartaoDesativadoException {
        boolean isInLista = false;
        for (CartaoPasseCliente cartao : this.getCartoesCadastrados()){
            if (cartao.getCodCartao().equals(CodigoDoCartao)){
                isInLista = true;
                if (cartao.getEntradasHoje() < CatracaAcademia.ENTRADAS_POR_DIA && cartao.isAtivo()){
                    this.registrarEntrada(cartao);
                    this.liberarCatraca();
                } else if (cartao.getEntradasHoje() >= CatracaAcademia.ENTRADAS_POR_DIA){
                    throw new ExcedeuLimiteDeEntradaException("Você já excedeu o limite de entrada!\nVolte amanhã!");
                } else if (cartao.isAtivo() == false){
                    throw new CartaoDesativadoException("Esse cartão está desativado!");
                } break;
            }
        }
        if (isInLista == false){
            throw new NaoCadastradoException("Não cadastrado na catraca!");
        }
    }
    
    private void registrarEntrada(CartaoPasseCliente cartao) {
        cartao.registrarEntrada();
        System.out.println("Entrada registrada");
    }

    private void liberarCatraca() {
        if (this.fechada == false){
            System.out.println("Catraca já está liberada!");
        } else{
            this.fechada = false;
            System.out.println("Catraca liberada!");    
        }
    }
    public void fecharCatraca(){
        if (this.fechada){
            System.out.println("Catraca já está fechada!");
        } else{
            this.fechada = true;
            System.out.println("Catraca fechada!");
        }
    }
    
    public List<CartaoPasseCliente> getCartoesCadastrados() {
        return cartoesCadastrados;
    }

    public void setCartoesCadastrados(List<CartaoPasseCliente> cartoesCadastrados) {
        this.cartoesCadastrados = cartoesCadastrados;
        System.out.println("Cartões cadastrados na catraca!");
    }

    public boolean isFechada() {
        return fechada;
    }

    public void setFechada(boolean fechada) {
        this.fechada = fechada;
    }

    public static int getENTRADAS_POR_DIA() {
        return ENTRADAS_POR_DIA;
    }
    
}
