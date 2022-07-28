package trycatch;

import java.io.IOException;

public class TesteArquivo {
    public static void main(String[] args) {
        CriadorArquivo criador = new CriadorArquivo();
        try{
            criador.criarArquivo("aaaa");
        } catch(RuntimeException | IOException e){
            System.out.println("Não foi possível criar o arquivo!\n"
                    + "Error: "+ e);
        }
    }
}
