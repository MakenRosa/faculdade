/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.dao;

import br.com.senac.entidade.Cliente;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author maken.rosa
 */
public interface ClienteDAO {
    void salvar(Cliente cliente) throws SQLException;
    void alterar(Cliente cliente) throws SQLException;
    void excluir(Integer id) throws SQLException;
    Cliente pesquisarPorId(Integer id) throws SQLException;
    List<Cliente> pesquisarTodos() throws SQLException;
    List<Cliente> PesquisarPorNome(String nome) throws SQLException;
}
