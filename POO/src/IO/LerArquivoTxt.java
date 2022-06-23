package IO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class LerArquivoTxt {
    private static String HOME_DIR = System.getProperty("user.home");
    private static Path diretorio = Paths.get(HOME_DIR, "emails.txt");
    public static void lerTxt(){
        try (BufferedReader reader = new BufferedReader(new FileReader(diretorio.toString()));) {
            String leia = null;
            while((leia = reader.readLine()) != null){
                System.out.println(leia);
            }
        } catch (IOException ex){
                System.err.println("Erro! " + ex);
        }
    }
}
