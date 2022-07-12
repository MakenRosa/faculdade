package crud.dao;

import crud.entidades.Produto;
import java.util.List;

public interface ProdutoDAO {
    public void criarTabela() throws Exception;
    public Produto criar(Produto produto) throws Exception;
    public Produto buscarPeloId(long id);
    public List<Produto> pesquisarTodos();
    public Produto atualizar(Produto produto);
    public void remover(long id);
    public void removerRegistros();
}
