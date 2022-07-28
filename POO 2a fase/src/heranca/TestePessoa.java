package heranca;
public class TestePessoa {
    public static void main(String[] args) {
        Funcionario maken = new Funcionario("Maken", "9584.545", new Endereco("Principal", 4512));
        maken.setDataAdmissao("23/04/2022");
        maken.setSalario(1300);
        maken.setCarteiraProfissional(54231254);
        maken.imprime();
        
    }
}
