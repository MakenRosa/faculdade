package trabalho_final_poo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

class Mensalidade {
    private String mes;
    private double valor;
    private StatusPagamento status;
    private LocalDate dataDoPagamento;

    public Mensalidade(String mes, double valor, StatusPagamento status) {
        this.mes = mes;
        this.valor = valor;
        this.status = status;
    }
    
    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getStatus() {
        return status.getStatus();
    }

    public void setStatus(StatusPagamento status) {
        this.status = status;
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
