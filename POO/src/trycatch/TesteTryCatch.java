package trycatch;
public class TesteTryCatch {
    public static void main(String[] args) {
    try {
        int resultado = 10/1;
        System.out.printf("Dividiu a primeira");
        int result2 = 10/0;
        System.out.printf("\nDividiu a segunda", result2);
    } catch (NullPointerException ex){
        System.out.printf("Objeto não instanciado " + ex.getMessage());
    } catch (Exception ex){
        System.out.println("Erro: "+ ex.getMessage());
    }
    }
    
}
