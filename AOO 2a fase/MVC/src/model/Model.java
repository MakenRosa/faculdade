package model;
public class Model {
    public int somar(int n1, int n2){
        return n1+n2;
    }
    public int subtrair(int n1, int n2){
        return n1-n2;
    }
    public int multiplicar(int n1, int n2){
        return n1*n2;
    }
    public double dividir(int n1, int n2){
        return n1/n2;
    }
    public boolean opcaoIsValida(int opcao){
        return opcao >= 0 && opcao <=4;
    }
}
