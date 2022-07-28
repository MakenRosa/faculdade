package recursividade;
public class Fibonacci {  
    public static int fibonacci(int num){
        int atual = 1;
        atual += fibonacci(num-1);
        System.out.println(atual);
        if (atual > 30){
            return atual;
        }
        return 0;
        
    }
    public static void main(String[] args) {
        fibonacci(2);
        
    }
    
}

