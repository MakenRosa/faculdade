package gerador;
public class Gerador {

    public static String gerarNumero(int qtd){
        String numero = "";
        for (int i = 0; i < qtd; i++){
            numero += (int) (Math.random() * 10);
        }
        return numero;
    }
    public static String gerarTelefoneFixo(){
        String tel = "(48)3" + gerarNumero(3) + "-" + gerarNumero(4);
        return tel;
    }
    public static String gerarTelefoneCelular(){
        String cel = "(48)9" + gerarNumero(4) + "-" + gerarNumero(4);
        return cel;
    }
    public static String gerarCPF(){
        String cpf = gerarNumero(3) + "." + gerarNumero(3) + "." + gerarNumero(3) + "-" + gerarNumero(2);
        return cpf;
    }
    public static void main(String [] args){
        System.out.println(gerarTelefoneCelular());
    }
    
}