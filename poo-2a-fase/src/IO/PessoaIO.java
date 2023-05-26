package IO;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class PessoaIO {
    public static void criarArquivoPessoa(Path diretorio, List<Pessoa> pessoas, String nomeArquivo){
        Path caminho = Paths.get(diretorio.toString(), nomeArquivo);
        
        try {
            Files.createDirectories(diretorio);
        } catch (IOException ex) {
            System.err.println("Deu ruim! " + ex);
        }
       
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminho.toString()))){
            for (Pessoa pessoa: pessoas){
                writer.append(pessoa.getNome()).append(";").append(pessoa.getEmail());
                writer.newLine();
            }
        } catch (IOException ex) {
            System.err.println("Deu ruim! " + ex);
        }
    }
}
