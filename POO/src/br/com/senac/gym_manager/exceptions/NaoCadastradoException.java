package br.com.senac.gym_manager.exceptions;
public class NaoCadastradoException extends Exception{
    public  NaoCadastradoException(String message){
        super(message);
    }
    public NaoCadastradoException(Throwable t){
        super(t);
    }
}
