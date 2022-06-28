package trabalho_final_poo;
public class SemCartaoException extends Exception{
    public SemCartaoException(String message){
        super(message);
    }
    public SemCartaoException(Throwable t){
        super(t);
    }
}
