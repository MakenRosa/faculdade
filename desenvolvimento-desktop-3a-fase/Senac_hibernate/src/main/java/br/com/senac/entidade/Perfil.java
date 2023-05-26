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
 * @author Maken.Rosa
 */
@Data
@Entity
@Table(name = "perfil")
public class Perfil implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, length = 255, nullable = false)
    private String nome;

    @Lob @Column
    private String descricao;
    
    @Column(nullable = false, columnDefinition = "boolean default true")
    private boolean ativo;

    public Perfil() {
    }

    public Perfil(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

}
