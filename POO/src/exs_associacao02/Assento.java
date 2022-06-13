package exs_associacao02;

import java.util.ArrayList;
import java.util.List;

public class Assento {
    private String posicao;
    private List<Categoria> categorias;

    public Assento(String posicao, List<Categoria> categorias) {
        this.posicao = posicao;
        this.categorias = categorias;
    }

    public Assento(String posicao, Categoria categoria) {
        this.posicao = posicao;
        this.categorias = new ArrayList();
        this.categorias.add(categoria);
    }

    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categoria) {
        this.categorias = categoria;
    }
    
    
    
}
