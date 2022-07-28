package agragacao_composicao;
public class EscolaDAO {
    private static int id;
    
    public static void salvar(Escola escola){
        System.out.println("Escola salva no banco de dados!");
        escola.setId(id);
        id++;
    }
    public static void remover(Escola escola){
        System.out.println("Escola excluída!");
        
    }
}
