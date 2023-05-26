package exs_associacao02;
public class CalculadoraMilhagem {
    public static long calculaCustoEmMilhas(Voo trecho){
        return trecho.getMilhas()*2;
    }
    public static long calculaMilhasGanhas(Voo trecho){
        return trecho.getMilhas()-(trecho.getDuracao()*2);
    }
}
