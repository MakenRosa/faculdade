package exs_associacao02;
public class Bilhete {
    private Passageiro passageiro;
    private Assento assento;
    private Reserva reserva;
    private Voo voo;

    public Bilhete(Assento assento, Reserva reserva) {
        this.assento = assento;
        this.reserva = reserva;
        this.passageiro = reserva.getPassageiro();
        this.voo = reserva.getVoo();
    }

    public Passageiro getPassageiro() {
        return passageiro;
    }

    public void setPassageiro(Passageiro passageiro) {
        this.passageiro = passageiro;
    }

    public Assento getAssento() {
        return assento;
    }

    public void setAssento(Assento assento) {
        this.assento = assento;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public Voo getVoo() {
        return voo;
    }

    public void setVoo(Voo voo) {
        this.voo = voo;
    }
    
}
