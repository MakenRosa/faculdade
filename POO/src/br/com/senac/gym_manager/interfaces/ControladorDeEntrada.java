package br.com.senac.gym_manager.interfaces;

import br.com.senac.gym_manager.entidades.CartaoPasseCliente;

public  interface ControladorDeEntrada {
    public void adicionarCartao(CartaoPasseCliente cartao);
    public void excluirCartao(String CodigoDoCartao);
}
