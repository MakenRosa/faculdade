package br.com.senac.gym_manager.controle_entrada;
public  interface ControladorDeEntrada {
    public void adicionarCartao(CartaoPasseCliente cartao);
    public void excluirCartao(String CodigoDoCartao);
}
