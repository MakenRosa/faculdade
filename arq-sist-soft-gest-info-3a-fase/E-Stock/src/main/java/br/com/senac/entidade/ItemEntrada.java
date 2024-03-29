/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.senac.entidade;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.*;

/**
 *
 * @author Maken.Rosa
 */
@Table(name = "item_entrada")
@Entity
public class ItemEntrada implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_item_entrada")
    private Long idItemEntrada;
    
    @ManyToOne
    @JoinColumn(name = "entrada_id_produto", referencedColumnName = "id_produto", nullable = false)
    private Produto produto;
    
    @Column(name = "data_entrada", nullable = false)
    private LocalDate dataEntrada;
    
    @Column(name = "qtd", nullable = false)
    private Integer qtdProduto;
    
    @Column(name = "data_validade", nullable = false)
    private LocalDate dataValidade;
    
    @Column(length = 45, nullable = false, unique = true)
    private String lote;
    
    @Column(nullable = false)
    private Double preco;

    public ItemEntrada(Produto produto, LocalDate dataEntrada, Integer qtdProduto, LocalDate dataValidade, String lote, Double preco) {
        this.produto = produto;
        this.dataEntrada = dataEntrada;
        this.qtdProduto = qtdProduto;
        this.dataValidade = dataValidade;
        this.lote = lote;
        this.preco = preco;
    }

    public ItemEntrada() {
    }
    
    public Long getIdItemEntrada() {
        return idItemEntrada;
    }

    public void setIdItemEntrada(Long idItemEntrada) {
        this.idItemEntrada = idItemEntrada;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto Produto) {
        this.produto = Produto;
    }

    public LocalDate getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(LocalDate dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public Integer getQtdProduto() {
        return qtdProduto;
    }

    public void setQtdProduto(Integer qtdProduto) {
        this.qtdProduto = qtdProduto;
    }

    public LocalDate getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(LocalDate dataValidade) {
        this.dataValidade = dataValidade;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idItemEntrada != null ? idItemEntrada.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the idItemEntrada fields are not set
        if (!(object instanceof ItemEntrada)) {
            return false;
        }
        ItemEntrada other = (ItemEntrada) object;
        if ((this.idItemEntrada == null && other.idItemEntrada != null) || (this.idItemEntrada != null && !this.idItemEntrada.equals(other.idItemEntrada))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.senac.entidade.ItemEntrada[ id=" + idItemEntrada + " ]";
    }
    
}
