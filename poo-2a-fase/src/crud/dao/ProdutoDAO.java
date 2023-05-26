package crud.dao;

import crud.entidades.Produto;
import java.util.List;

public interface ProdutoDAO {
    public void criarTabela() throws Exception;
    public Produto criar(Produto produto) throws Exception;
    public Produto buscarPeloId(long id) throws Exception;
    public List<Produto> pesquisarTodos() throws Exception;
    public Produto atualizar(Produto produto) throws Exception;
    public void remover(long id) throws Exception;
    public void removerRegistros() throws Exception;
}
