/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.entidade;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

/**
 *
 * @author maken.rosa
 */
@Data
@Entity
@Table(name = "profissao")
public class Profissao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id_profissao")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String nome;

    @Lob
    private String descricao;

    public Profissao() {
    }

    public Profissao(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }
}
