package controller;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Model;
import view.View;

public class Controller {
    public static void start() {
        Model model = new Model();
        int opcao = View.start();
        while (opcao != 0){
            if (model.opcaoIsValida(opcao)){
                List values = View.getNumeros();
                int n1 = (int)values.get(0);
                int n2 = (int)values.get(1);
                if (opcao == 1){
                    int resultado = model.somar(n1, n2);
                    view.View.showResult(resultado);
                } else if(opcao == 2){
                    int resultado = model.subtrair(n1, n2);
                    view.View.showResult(resultado);
                } else if(opcao == 3){
                    int resultado = model.multiplicar(n1, n2);
                    view.View.showResult(resultado);
                } else if(opcao == 4){
                    double resultado = model.dividir(n1, n2);
                    view.View.showResult(resultado);
                }
            } else{
                System.err.println("Valor inválido, tente novamente!");
            }try {
                Thread.sleep(2000l);
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } catch (Exception ex) { 
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            opcao = view.View.menu();
        }
    }
}
