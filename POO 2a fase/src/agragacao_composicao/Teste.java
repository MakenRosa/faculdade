package agragacao_composicao;

public class Teste {
    public static void main(String[] args) {
        Escola senac = new Escola();
        EscolaDAO.salvar(senac);
        
        Departamento secretaria = new Departamento("Secretaria");
        Departamento biblioteca = new Departamento("Biblioteca");
        senac.getDepartamentos().add(secretaria);
        senac.getDepartamentos().add(biblioteca);
        for (Departamento dp : senac.getDepartamentos()) {
            DepartamentoDAO.salvar(dp);
            System.out.println("Nome departamento: " + dp.getNome());
            System.out.println("ID: " + dp.getId());
            System.out.println("===============");
        }
    }
}
