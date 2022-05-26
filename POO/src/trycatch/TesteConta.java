package trycatch;
public class TesteConta {
    public static void main(String[] args) {
        Conta conta = new Conta(0001, 600);
        try{
            conta.depositar(2000);
            conta.sacar(600);
        }catch (ContaException e){
            System.out.println(e);
        }
        }
    }
    
