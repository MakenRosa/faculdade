package trabalho_final_poo;
public class ExcedeuLimiteDeEntradaException extends Exception {
    public  ExcedeuLimiteDeEntradaException(String message){
        super(message);
    }
    public ExcedeuLimiteDeEntradaException(Throwable t){
        super(t);
    }

}
