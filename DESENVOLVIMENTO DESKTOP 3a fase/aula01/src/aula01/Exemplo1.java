package aula01;

import aula01_service.Calculadora;

public class Exemplo1 {
    public static void main(String[] args) {
        int valor1 = 10;
        int valor2 = 7;
        int valor3 = 12;
        String frase = "Simples como amar";
        Calculadora calculadora = new Calculadora();
        System.out.println(calculadora.somar(valor1, valor2, valor3));
        System.out.println(calculadora.contaFrase(frase));
        
    }
}
