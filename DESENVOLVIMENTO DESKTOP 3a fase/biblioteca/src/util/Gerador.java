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
    public static String gerarCep(){
        return "(" + gerarNumero(5) + "-" + gerarNumero(3) + ")";
    }
    public static String gerarCidade(){
        List<String> cidades = Arrays.asList("São José", "Biguaçu", "Palhoça",
                "São Paulo", "Rio de Janeiro", "Belo Horizonte", "Fortaleza",
                "Manaus", "Floranópolis", "Salvador", "Brasília", "Berezino",
                "Espera Feliz", "Joinville", "Sorocaba", "Araranguá", 
                "Jaraguá do Sul", "Chapecó", "Juiz de Fora", "Uberlândia",
                "Betim", "Alagoinhas", "Araci");
        Collections.shuffle(cidades);
        return cidades.get(0);
    }
    public static String gerarBairro(){
        List<String> bairros = Arrays.asList("Bela Vista", "Ipiranga",
                "Barreiros", "Centro", "Cacupé", "Coqueiros", "Itacorubi", 
                "João Paulo", "Jurerê Internacional", "Savassi", "Lourdes", 
                "Anchieta", "Belvedere", "Pampulha", "Cidade Nova", 
                "Barra Velha", "Batel", "Água Verde", "Juvevê");
        Collections.shuffle(bairros);
        return bairros.get(0);
    }
    public static String gerarUf(){
        List<String> ufs = Arrays.asList("Acre(AC)", "Alagoas(AL)", "Amapá(AP)",
                "Amazonas(AM)", "Bahia(BA)", "Ceará(CE)", "Distrito Federal(DF)",
                "Espírito Santo(ES)", "Goiás(GO)", "Maranhão(MA)",
                "Mato Grosso(MT)", "Mato Grosso do Sul(MS)", "Minas Gerais(MG)",
                "Pará(PA)", "Paraíba(PB)", "Paraná(PR)", "Santa Catarina(SC)");
        Collections.shuffle(ufs);
        return ufs.get(0);
    }
    
    public static String gerarCpf(){
        return gerarNumero(3) + "." + gerarNumero(3) + "." + gerarNumero(3) + "-" + gerarNumero(2);
    }
    public static String gerarCnpj(){
        return gerarNumero(2) + "." + gerarNumero(3) + "." + gerarNumero(3) + "/" + gerarNumero(4) + "-" + gerarNumero(2);
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
    public static String gerarLogin(){
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