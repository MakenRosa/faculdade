/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.senac.dao;

import br.com.senac.entidade.Cliente;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author maken.rosa
 */
public interface ClienteDAO extends BaseDAO<Cliente, Long>{
    public List<Cliente> pesquisarPorNome(String nome, Session sessao);
}
