package trabalho_final_poo;
public class NaoCadastradoException extends Exception{
    public  NaoCadastradoException(String message){
        super(message);
    }
    public NaoCadastradoException(Throwable t){
        super(t);
    }
}
