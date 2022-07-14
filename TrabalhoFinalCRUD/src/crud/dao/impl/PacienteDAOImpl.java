package crud.dao.impl;

import crud.dao.ConnectionManager;
import crud.dao.EnderecoDAO;
import crud.dao.PacienteDAO;
import crud.entidades.Endereco;
import crud.entidades.Paciente;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PacienteDAOImpl implements PacienteDAO{
    
    @Override
    public Paciente criar(Paciente paciente) throws Exception{
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultado = null;
        String sql = "INSERT INTO paciente (nome, cpf, nascimento) values(?, ?, ?)";
        try {
            connection = ConnectionManager.openConnection();
            statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, paciente.getNome());
            statement.setString(2, paciente.getCpf());
            statement.setDate(3, Date.valueOf(paciente.getNascimento()));
            statement.executeUpdate();
            resultado = statement.getGeneratedKeys();
            if (resultado.next()){
                paciente.setId(resultado.getLong(1));
            }
        } catch (SQLException ex){
            System.err.println("Erro ao criar paciente! " + ex.getMessage());
        } finally {
            crud.dao.ConnectionManager.closeConnection(connection, statement, resultado);
        }
        return paciente;
    }

    @Override
    public Paciente alterar(Paciente paciente) throws Exception {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultado = null;
        try {
            connection = ConnectionManager.openConnection();
            String sql = "UPDATE paciente SET nome = ?, cpf = ?, nascimento = ? WHERE id = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, paciente.getNome());
            statement.setString(2, paciente.getCpf());
            statement.setDate(3, Date.valueOf(paciente.getNascimento()));
            statement.setLong(4, paciente.getId());
            statement.executeUpdate();
        } catch (SQLException ex){
            System.err.println("Erro ao alterar paciente: "+ ex.getMessage());
        } finally{
            ConnectionManager.closeConnection(connection, statement, resultado);
        }
        return paciente;
    }

    @Override // FALTA ADICIONAR ENDERECOS AO PACIENTE USANDO METODO DE ENDERECODAOIMPL
    public Paciente pesquisarPorId(long id) throws Exception{
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultado = null;
        Paciente paciente = null;
        try {
            connection = ConnectionManager.openConnection();
            String sql = "SELECT * FROM paciente WHERE id = ?";
            statement = connection.prepareStatement(sql);
            statement.setLong(1, id);
            resultado = statement.executeQuery();
            if (resultado.next()){
                paciente = new Paciente();
                paciente.setId(id);
                paciente.setNome(resultado.getString("nome"));
                paciente.setCpf(resultado.getString("cpf"));
                paciente.setNascimento(resultado.getDate("nascimento").toLocalDate());
            }
        } catch (SQLException ex){
            System.err.println("Erro ao pesquisar pelo id: "+ ex.getMessage());
        } finally{
            ConnectionManager.closeConnection(connection, statement, resultado);
        }
        return paciente;
    }

    @Override
    public List<Paciente> pesquisarTodos() throws Exception {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultado = null;
        List<Paciente> pacientes = new ArrayList();
        EnderecoDAO daoEndereco = new EnderecoDAOImpl();
        try {
            connection = ConnectionManager.openConnection();
            String sql = "SELECT * FROM paciente ORDER BY nome ASC";
            statement = connection.prepareStatement(sql);
            resultado = statement.executeQuery();
            while (resultado.next()){
                Paciente paciente = new Paciente();
                paciente.setId(resultado.getLong("id"));
                paciente.setNome(resultado.getString("nome"));
                paciente.setCpf(resultado.getString("cpf"));
                paciente.setNascimento(resultado.getDate("nascimento").toLocalDate());
                paciente.setEnderecos(daoEndereco.pesquisarTodosPaciente(paciente.getId()));
                pacientes.add(paciente);
            }
        } catch (SQLException ex){
            System.err.println("Erro ao buscar pacientes: "+ ex.getMessage());
            throw new Exception(ex);
        } finally{
            ConnectionManager.closeConnection(connection, statement, resultado);
        }
        return pacientes;
    }

    @Override  // FALTA DELETAR OS ENDERECOS DOS PACIENTES (DELETAR ENDERECOS ANTES DE DELETAR PACIENTE)
    public void excluir(long id) throws Exception {
        Connection connection = null;
        PreparedStatement statementPaciente = null;
        ResultSet resultado = null;
        EnderecoDAO daoEndereco = new EnderecoDAOImpl();
        try {
            connection = ConnectionManager.openConnection();
            List<Endereco> enderecos = daoEndereco.pesquisarTodosPaciente(id);
            for (Endereco endereco : enderecos){
                daoEndereco.excluir(endereco.getId());
            }
            
            String sqlPaciente = "DELETE from paciente WHERE id = ?";
            statementPaciente = connection.prepareStatement(sqlPaciente);
            statementPaciente.setLong(1, id);
            statementPaciente.executeUpdate();
        } catch (SQLException ex){
            System.err.println("Erro ao deletar paciente: "+ ex.getMessage());
        } finally{
            ConnectionManager.closeConnection(connection, statementPaciente, resultado);
        }
    }
}
