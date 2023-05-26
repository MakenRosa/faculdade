package br.com.senac.gym_manager.entidades;

import br.com.senac.gym_manager.enums.StatusPagamento;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Mensalidade {
    private String mes;
    private double valor;
    private StatusPagamento status;
    private LocalDate dataDoPagamento;

    public Mensalidade(String mes, double valor, StatusPagamento status) {
        this.mes = mes;
        this.valor = valor;
        this.status = status;
        System.out.println("Mensalidade Criada!");
    }
    
    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
        System.out.println("Mês da mensalidade foi trocado para " + mes);
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
        System.out.println("Mudou o valor da mensalidade para " + valor);
    }

    public String getStatus() {
        return this.status.getStatus();
    }

    public void setStatus(StatusPagamento status) {
        this.status = status;
        System.out.println("Status da mensalidade mudado para: pagamento " + status.getStatus());
    }

    public String getDataDoPagamentoSTR() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return dataDoPagamento.format(formato);
    }
    
    public LocalDate getDataDoPagamento(){
        return dataDoPagamento;
    }

    public void setDataDoPagamento(LocalDate dataDoPagamento) {
        this.dataDoPagamento = dataDoPagamento;
    }
}
