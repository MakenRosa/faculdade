package expoo;

import java.util.List;
import java.util.Scanner;

public class TesteEmpresa {
    public static void main(String[] args) {
        Empresa minhaEmpresa = new Empresa();
        
        Departamento rh = new Departamento();
        rh.setNome("RH");
        rh.getPessoas().add(criarPessoa());
        List<Pessoa> pessoas = rh.getPessoas();
        rh.getPessoas().add(criarPessoa());
        pessoas.forEach((pessoa) -> {
            System.out.println(pessoa.getNome()+ ";");
        });
    }
    public static Pessoa criarPessoa(){
        Scanner input = new Scanner(System.in);
        Pessoa pessoa = new Pessoa();
        System.out.print("Digite o nome da pessoa: ");
        String nome = input.nextLine();
        pessoa.setNome(nome);
        System.out.print("Digite o RG: ");
        String rg = input.nextLine();
        pessoa.setRg(rg);
        pessoa.setEndereco(criarEndereco());
        return pessoa;
    }
    private static Endereco criarEndereco() {
        Scanner input = new Scanner(System.in);
        Endereco endereco = new Endereco();
        System.out.print("Digite o nome da rua: ");
        String rua = input.nextLine();
        endereco.setRua(rua);
        System.out.print("Digite o número: ");
        int numeroCasa = input.nextInt();
        input.nextLine();
        endereco.setNumero(numeroCasa);
        return endereco;
    }
}
