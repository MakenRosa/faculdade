package statics;
public class Carro {
    private String fabricante;
    private String placa;
    private int velocidade;
    public static int velocidadeMaximaPermitida = 60;
    public Carro(String fabricante, String placa, int velocidade){
        this.fabricante = fabricante;
        this.placa = placa;
        this.velocidade = velocidade;
    }
    public void acelerar(int valor){
        this.velocidade += valor;
    }
    public boolean ultrapassouLimite(){
        return this.velocidade > Carro.velocidadeMaximaPermitida;
    }
    public String getFabricante() {
        return fabricante;
    }
    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }
    public String getPlaca() {
        return placa;
    }
    public void setPlaca(String placa) {
        this.placa = placa;
    }
    public int getVelocidade() {
        return velocidade;
    }
    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }
    public static int getVelocidadeMaximaPermitida() {
        return velocidadeMaximaPermitida;
    }
    public static void setVelocidadeMaximaPermitida(int velocidadeMaximaPermitida) {
        Carro.velocidadeMaximaPermitida = velocidadeMaximaPermitida;
    }
}
