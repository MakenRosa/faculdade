package br.com.senac.gym_manager.enums;
public enum StatusPagamento {
    PAGAMENTO_EM_ESPERA("Em espera"),
    PAGAMENTO_REALIZADO("Realizado"),
    PAGAMENTO_VENCIDO("Vencido");
    
    private final String status;

    StatusPagamento(String status){
    this.status = status;
}
    public String getStatus(){
        return this.status;
    }
    
}
