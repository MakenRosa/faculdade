package IO;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        List<String> emails = GravarEmail.getPessoas();
        Path caminho = Paths.get(GravarEmail.getHOME_DIR(), GravarEmail.getFILE_NAME());
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminho.toString()))){
            for (String email : emails){
                writer.append(email);
                writer.newLine();
            }
        } catch (IOException ex) {
            System.err.println("Deu merda");
        }
    }
}
