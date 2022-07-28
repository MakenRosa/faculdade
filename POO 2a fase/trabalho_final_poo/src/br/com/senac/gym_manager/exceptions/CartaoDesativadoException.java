
package br.com.senac.gym_manager.exceptions;

public class CartaoDesativadoException extends Exception {
    public CartaoDesativadoException(String message){
        super(message);
    }
    public CartaoDesativadoException(Throwable t){
        super(t);
    }

}
