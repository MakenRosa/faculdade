package br.com.senac.gym_manager.exceptions;
public class ExcedeuLimiteDeEntradaException extends Exception {
    public  ExcedeuLimiteDeEntradaException(String message){
        super(message);
    }
    public ExcedeuLimiteDeEntradaException(Throwable t){
        super(t);
    }

}
