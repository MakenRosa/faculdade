package atividade;

public final class Carro {
    private String fabricante;
    private String placa;
    private String modelo;
    private Cor cor;
    private double preco;
    
    public Carro(String fabricante, String placa, String modelo, Cor cor, double preco){
        this.fabricante = fabricante;
        try {
            this.setPlaca(placa);
        } catch (CarroException ex) {
            System.err.println(ex.getMessage());
        }
        this.modelo = modelo;
        this.cor = cor;
        this.preco = preco;
    }
    
    public void imprimeDados(){
        System.out.println("Fabricante: " + this.fabricante +
                "\nModelo: " + this.modelo +
                "\nPlaca: " + this.placa +
                "\nCor: " + this.cor +
                "\nPreço: " + this.preco);
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

    public void setPlaca(String placa) throws CarroException{
        if (placa.length() > 6 && placa.length() < 9){
        this.placa = placa;
        } else{
            throw new CarroException("A placa " + placa +" é inválida!");
        }
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Cor getCor() {
        return cor;
    }

    public void setCor(Cor cor) {
        this.cor = cor;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
    
}
