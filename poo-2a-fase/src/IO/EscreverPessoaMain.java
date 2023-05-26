package IO;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class EscreverPessoaMain {
    public static void main(String[] args) {
        Pessoa maken = new Pessoa("Maken", "maken@teste.com");
        Pessoa erick = new Pessoa("Erick", "Erick@teste.com.br");
        Pessoa leo = new Pessoa("Leonardo", "Leo23@yahoo.com");
        List<Pessoa> pessoas = new ArrayList();
        pessoas.add(leo);
        pessoas.add(maken);
        pessoas.add(erick);
        String HOME_DIR = System.getProperty("user.home");
        Path diretorio = Paths.get(HOME_DIR, "Pessoas");
        PessoaIO.criarArquivoPessoa(diretorio, pessoas, "pessoas.txt");
        pessoas = LerArquivoTxt.lerTxt();
        for (Pessoa pessoa :pessoas){
            System.out.println(pessoa.getNome() + " e " + pessoa.getEmail());
        }
    }
}
