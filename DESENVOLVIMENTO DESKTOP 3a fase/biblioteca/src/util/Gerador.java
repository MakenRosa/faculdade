package util;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Gerador {
    
    public static String gerarNumero(int quantidade){
        String numero = "";
        for (int i = 0; i < quantidade; i++){
            numero += (int) (Math.random() * 10);
        }
        return numero;
    }
    public static String gerarTelefoneFixo(){
        return "(48)3" + gerarNumero(3) + "-" + gerarNumero(4);
    }
    public static String gerarTelefoneCelular(){
        return "(48)9" + gerarNumero(4) + "-" + gerarNumero(4);
    }
    public static String gerarCPF(){
        return gerarNumero(3) + "." + gerarNumero(3) + "." + gerarNumero(3) + "-" + gerarNumero(2);
    }
    public static String gerarSenha(int quantidade){
         String[] caracteres ={"0","1","2","3","4","5","6","7","8","9","a","b",
             "c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r",
             "s","t","u","v","w","x","y","z","A","B","C","D","E","F","G","H",
             "I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X",
             "Y","Z"};
        String senha = "";
        for (int i = 0; i < quantidade; i++) {
            senha += caracteres[(int) (Math.random() * caracteres.length)];
        }
        return senha;
    }
    private static String gerarLogin(){
        return "@" + gerarNome().toLowerCase().replace(' ', '_');
    }
    public static String gerarNome(){
        List<String> nomes = Arrays.asList("Maken", "Silvio", "Junior", "Elizangela", "Ana",
            "Eva", "Carla", "Luan", "Lucas", "Lizandra", "Ruan", "Carlos",
            "Renaldo", "Tiago", "Leonardo", "Perla", "Pedro", "João", "Carlos",
            "Ricardo");
        Collections.shuffle(nomes);
        return nomes.get(0) + " " + gerarSobrenome();
    }
    private static String gerarSobrenome(){
        List<String> nomes = Arrays.asList("da Rosa", "Faria", "Silva", "Abreu",
                "Paulo", "Costa", "Neto", "Xavier", "Mattes", "Henrique",
                "Vieira", "Rodrigues", "Freitas", "Schmitz", "Holanda", "Rolva",
                "Rinchens", "Machado", "Medeiros");
        Collections.shuffle(nomes);
        return nomes.get(0);
    }
}