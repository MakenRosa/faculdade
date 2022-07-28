package exs_associacao02;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Voo {
    private int numero;
    private int duracao;
    private Date data;
    private double precoBase;
    private int milhas;
    private List<Aeronave> aeronaves;
    private Cidade origem;
    private Cidade destino;

    public Voo(int numero, int duracao, Date data, double precoBase, int milhas, List<Aeronave> aeronaves, Cidade origem, Cidade destino) {
        this.numero = numero;
        this.duracao = duracao;
        this.data = data;
        this.precoBase = precoBase;
        this.milhas = milhas;
        this.aeronaves = aeronaves;
        this.origem = origem;
        this.destino = destino;
    }

    public Voo(int numero, int duracao, Date data, double precoBase, int milhas, Aeronave aeronave, Cidade origem, Cidade destino) {
        this.numero = numero;
        this.duracao = duracao;
        this.data = data;
        this.precoBase = precoBase;
        this.milhas = milhas;
        this.origem = origem;
        this.destino = destino;
        this.aeronaves = new ArrayList();
        this.aeronaves.add(aeronave);
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public double getPrecoBase() {
        return precoBase;
    }

    public void setPrecoBase(double precoBase) {
        this.precoBase = precoBase;
    }

    public int getMilhas() {
        return milhas;
    }

    public void setMilhas(int milhas) {
        this.milhas = milhas;
    }

    public List<Aeronave> getAeronaves() {
        return aeronaves;
    }

    public void setAeronaves(List<Aeronave> aeronaves) {
        this.aeronaves = aeronaves;
    }

    public Cidade getOrigem() {
        return origem;
    }

    public void setOrigem(Cidade origem) {
        this.origem = origem;
    }

    public Cidade getDestino() {
        return destino;
    }

    public void setDestino(Cidade destino) {
        this.destino = destino;
    }
    
}
