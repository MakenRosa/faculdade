package exs_associacao02;
public class Reserva {
    private int codigo;
    private int data;
    private int dataLimite;
    private StatusReserva status;
    private Voo voo;
    private Passageiro passageiro;
    private FormaPagamento formaDePagamento;

    public Reserva(int codigo, int data, int dataLimite, StatusReserva status,
            Voo voo, Passageiro passageiro, FormaPagamento pagamento) {
        this.codigo = codigo;
        this.data = data;
        this.dataLimite = dataLimite;
        this.status = status;
        this.voo = voo;
        this.passageiro = passageiro;
        this.formaDePagamento = pagamento;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public int getDataLimite() {
        return dataLimite;
    }

    public void setDataLimite(int dataLimite) {
        this.dataLimite = dataLimite;
    }

    public StatusReserva getStatus() {
        return status;
    }

    public void setStatus(StatusReserva status) {
        this.status = status;
    }

    public Voo getVoo() {
        return voo;
    }

    public void setVoo(Voo voo) {
        this.voo = voo;
    }

    public Passageiro getPassageiro() {
        return passageiro;
    }

    public void setPassageiro(Passageiro passageiro) {
        this.passageiro = passageiro;
    }

    public FormaPagamento getFormaDePagamento() {
        return formaDePagamento;
    }

    public void setFormaDePagamento(FormaPagamento formaDePagamento) {
        this.formaDePagamento = formaDePagamento;
    }
    
}
