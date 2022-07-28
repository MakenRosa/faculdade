package polimorfismo;
public class TestaPessoa {
    public static void main(String[] args) {
        Pessoa pessoa = new Cliente("462.444.111-52", "Maken", 8754141);
        Cliente clienteMaken = (Cliente)pessoa;
        System.out.println(clienteMaken.getCpf());
    }
}
        
               
     