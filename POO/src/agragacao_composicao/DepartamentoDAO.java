package agragacao_composicao;
public class DepartamentoDAO {
    private static int id;
    
    public static void salvar(Departamento departamento){
        System.out.println("Departamento salvo no banco de dados");
        departamento.setId(id);
        id++;
    }
    public static void remover(Escola escola){
        System.out.println("Escola removida!");
    }
}
