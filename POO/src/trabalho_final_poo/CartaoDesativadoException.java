
package trabalho_final_poo;

public class CartaoDesativadoException extends Exception {
    public CartaoDesativadoException(String message){
        super(message);
    }
    public CartaoDesativadoException(Throwable t){
        super(t);
    }

}
