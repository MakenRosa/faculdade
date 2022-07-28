package recursividade;
public class Fatorial {
    public static int fatorial(int num){
            if (num != 1){
                int soma = num * fatorial(num-1);
                return soma;
            }
            return 1;
    }
    public static void main(String[] args) {
        System.out.println(fatorial(5));
        
    }
}
