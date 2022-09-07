/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.senac.entidade;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author Truen
 */
@Table(name = "item_saida")
@Entity
public class ItemSaida implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id_item_saida")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idItemSaida;
    
    @ManyToOne
    @JoinColumn(name = "saida_id_produto", referencedColumnName = "id_produto", nullable = false)
    private Produto idProduto;
    
    @ManyToOne
    @JoinColumn(name = "saida_id_cliente", referencedColumnName = "id_cliente", nullable = false)
    private Cliente idCliente;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "data_saida", nullable = false)
    private Date dataSaida;
    
    @Column(nullable = false, name = "qtd")
    private Integer qtdProduto;
    
    @Column(nullable = false, length = 45)
    private String lote;
    
    @Column(nullable = false)
    private Double preco;

    public ItemSaida() {
    }

    public ItemSaida(Produto idProduto, Cliente idCliente, Date dataSaida, Integer qtdProduto, String lote, Double preco) {
        this.idProduto = idProduto;
        this.idCliente = idCliente;
        this.dataSaida = dataSaida;
        this.qtdProduto = qtdProduto;
        this.lote = lote;
        this.preco = preco;
    }
    
    public Long getIdItemSaida() {
        return idItemSaida;
    }

    public void setIdItemSaida(Long idItemSaida) {
        this.idItemSaida = idItemSaida;
    }

    public Produto getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Produto idProduto) {
        this.idProduto = idProduto;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    public Date getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(Date dataSaida) {
        this.dataSaida = dataSaida;
    }

    public Integer getQtdProduto() {
        return qtdProduto;
    }

    public void setQtdProduto(Integer qtdProduto) {
        this.qtdProduto = qtdProduto;
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
        hash += (idItemSaida != null ? idItemSaida.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the idItemSaida fields are not set
        if (!(object instanceof ItemSaida)) {
            return false;
        }
        ItemSaida other = (ItemSaida) object;
        if ((this.idItemSaida == null && other.idItemSaida != null) || (this.idItemSaida != null && !this.idItemSaida.equals(other.idItemSaida))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.senac.entidade.ItemSaida[ id=" + idItemSaida + " ]";
    }
    
}
