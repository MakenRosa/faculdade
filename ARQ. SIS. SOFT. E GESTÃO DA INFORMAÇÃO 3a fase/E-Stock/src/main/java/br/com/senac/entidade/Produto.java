/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.senac.entidade;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Truen
 */
@Table(name = "produto")
@Entity
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_produto")
    private Long idProduto;
    
    @Column(length = 255, nullable = false)
    private String nome;
    
    @Column(unique = true, length = 255, nullable = false)
    private String descricao;
    
    @OneToMany(mappedBy = "idProduto")
    private List<ItemEntrada> itensEntrada;
    
    @OneToMany(mappedBy = "idProduto")
    private List<ItemSaida> itensSaida;

    public Produto(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public Produto() {
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<ItemEntrada> getItensEntrada() {
        return itensEntrada;
    }

    public void setItensEntrada(List<ItemEntrada> itensEntrada) {
        this.itensEntrada = itensEntrada;
    }

    public List<ItemSaida> getItensSaida() {
        return itensSaida;
    }

    public void setItensSaida(List<ItemSaida> itensSaida) {
        this.itensSaida = itensSaida;
    }
    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProduto != null ? idProduto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the idProduto fields are not set
        if (!(object instanceof Produto)) {
            return false;
        }
        Produto other = (Produto) object;
        if ((this.idProduto == null && other.idProduto != null) || (this.idProduto != null && !this.idProduto.equals(other.idProduto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.senac.entidade.Produto[ id=" + idProduto + " ]";
    }
    
}
