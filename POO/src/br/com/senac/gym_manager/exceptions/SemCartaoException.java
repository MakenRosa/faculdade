package br.com.senac.gym_manager.exceptions;
public class SemCartaoException extends Exception{
    public SemCartaoException(String message){
        super(message);
    }
    public SemCartaoException(Throwable t){
        super(t);
    }
}
