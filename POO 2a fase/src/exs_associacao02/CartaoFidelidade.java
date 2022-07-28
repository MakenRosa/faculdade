package exs_associacao02;
public class CartaoFidelidade {
    private String numero;
    private long milhasAcumuladas;
    private CategoriaCartao categoria;

    public CartaoFidelidade() {
    }

    
    public CartaoFidelidade(String numero, long milhasAcumuladas, CategoriaCartao categoria) {
        this.numero = numero;
        this.milhasAcumuladas = milhasAcumuladas;
        this.categoria = categoria;
    }
    
    public String getNumero() {
        return numero;
    }

    public long getMilhasAcumuladas() {
        return milhasAcumuladas;
    }

    public CategoriaCartao getCategoria() {
        return categoria;
    }
    
}
