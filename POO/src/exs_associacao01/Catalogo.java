package exs_associacao01;

import java.util.ArrayList;
import java.util.List;

public class Catalogo {
    private String titulo;
    private List<Produto> produtos;


    public Catalogo(String titulo, List<Produto> produtos) {
        this.titulo = titulo;
        this.produtos = produtos;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
}
