/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.entidade;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;

/**
 *
 * @author Maken.Rosa
 */
@Data
@Entity  //anotações do JPA
@Table(name = "usuario")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, length = 100, unique = true)
    private String login;

    @Column(nullable = false, length = 100)
    private String senha;

    @Temporal(TemporalType.DATE)
    @Column(name = "ultimo_acesso")
    private Date ultimoAcesso;

    @ManyToOne
    @JoinColumn(name = "id_perfil")
    private Perfil perfil;

    public Usuario() {
    }

    public Usuario(String nome, String login, String senha) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }

}