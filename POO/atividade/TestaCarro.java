package atividade;

import java.util.ArrayList;

public class TestaCarro {
    public static void main(String[] args) throws CarroException {
        ArrayList<Carro> carros = new ArrayList();
        Carro carro1 = new Carro("Ford", "Exemplo", "Fiesta", Cor.PRETO, 25000);
        carros.add(carro1);
        Carro carro2 = new Carro("Honda", "Exemplos", "Civic", Cor.PRETO, 45100);
        carros.add(carro2);
        Carro carro3 = new Carro("Honda", "Exem", "City", Cor.BRANCO, 32000);
        carros.add(carro3);
        Carro carro4 = new Carro("Hyunday", "testes", "HB20s", Cor.CINZA, 38000);
        carros.add(carro4);
        Carro carro5 = new Carro("Renault", "testes0", "Clio", Cor.VERMELHO, 22000);
        carros.add(carro5);
        Carro carro6 = new Carro("Volkswagen", "as", "Uno", Cor.BRANCO, 19000);
        carros.add(carro6);
        carros.forEach((carro) -> {
            carro.imprimeDados();
        });
        
    }
}
    

