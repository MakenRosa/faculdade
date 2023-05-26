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
@Table(name = "cliente")
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String cpf;

    @Column(nullable = false)
    private String rg;

    @Column(nullable = false)
    private double salario;

    @ManyToOne
    @JoinColumn(name = "id_profissao")
    private Profissao profissao;

    public Cliente() {
    }

    public Cliente(String nome, String cpf, String rg,
            double salario) {
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.salario = salario;
    }
}
