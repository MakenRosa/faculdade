package sobrecarga;
public class Produto {
    private String nome;
    private String marca;
    private double preco;

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }
    public void valoresIniciais(String nome, double preco){
        this.setNome(nome);
        this.setPreco(preco);
    }
    public void valoresIniciais(String nome, String marca, double preco){
        this.valoresIniciais(nome, preco);
        this.setMarca(marca);
    }
    public void aumentarPreco(double valor){
        this.setPreco(this.getPreco()+(this.getPreco()*(valor/100)));
    }
    public void aumentarPreco(){
        this.aumentarPreco(8);
    }
    public void imprimir(){
        System.out.printf("Nome: %s\nMarca: %s\nPreço: %.2f\n", this.nome, this.marca, this.preco);
    }
}
