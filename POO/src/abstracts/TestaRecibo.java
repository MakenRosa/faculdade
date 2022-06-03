package abstracts;
public class TestaRecibo{
    public static void main(String[] args) {
        FormatadorModeloA recibo = new FormatadorModeloA();
        recibo.setNomeEmpresa("Arquivo");
        System.out.println(recibo.gerarRecibo("Maken", 1000, "25/06/2022", "multa por ser bot"));
    }
}
