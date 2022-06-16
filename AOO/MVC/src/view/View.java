package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class View {
    public static int start(){
        System.out.println("Seja bem vindo a Calculadora!");
        int opcao = View.menu();
       return opcao;
    }
    public static int menu(){
        System.out.println("1 - Somar\n"
                + "2 - Subtrair\n"
                + "3 - Multiplicar\n"
                + "4 - Dividir\n"
                + "0 - Sair");
        System.out.print("Digite uma opção: ");
        Scanner input = new Scanner(System.in);
        int opcao = input.nextInt();
        return opcao;
    }
    public static List getNumeros(){
        Scanner input = new Scanner(System.in);
        System.out.print("Digite o primeiro número: ");
        int num1 = input.nextInt();
        System.out.print("Digite o segundo número: ");
        int num2 = input.nextInt();
        List nums = new ArrayList();
        nums.add(num1);
        nums.add(num2);
        return nums;
    }
    public static void showResult(double resultado){
        System.out.println("O resultado é: " + resultado);
    }
}
