package IO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class LerArquivoTxt {
    private static String HOME_DIR = System.getProperty("user.home");
    private static Path diretorio = Paths.get(HOME_DIR, "Pessoas");
    public static List<Pessoa> lerTxt(){
        List<Pessoa> pessoas = new ArrayList();
        try (BufferedReader reader = new BufferedReader(new FileReader(diretorio.toString()+"\\pessoas.txt"));) {
            String leia = null;
            while((leia = reader.readLine()) != null){
                String[] linhas = leia.split(";");
                pessoas.add(new Pessoa(linhas[0], linhas[1]));
            }
        } catch (IOException ex){
                System.err.println("Erro! " + ex);
        }
        return pessoas;
    }
}
