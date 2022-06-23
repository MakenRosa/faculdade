package trabalho_final_poo;

import java.time.LocalDate;

class Mensalidade {
    private String mes;
    private double valor;
    private String status;
    private LocalDate dataDoPagamento;

    public Mensalidade(String mes, double valor, String status) {
        this.mes = mes;
        this.valor = valor;
        this.status = status;
    }
    
    public void pagar(){
        setStatus("pago");
        LocalDate dataPagamento= LocalDate.now();
        setDataDoPagamento(dataPagamento);
        System.out.println("Pagou!");
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
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getDataDoPagamento() {
        return dataDoPagamento;
    }

    public void setDataDoPagamento(LocalDate dataDoPagamento) {
        this.dataDoPagamento = dataDoPagamento;
    }
    
}
