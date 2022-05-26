
package getset;
public class Main {
    public static void main(String[] args) {
        Produto cafe = new Produto();
        cafe.valoresIniciais(20, "em pó 200g", "melita");
        cafe.imprime();
        cafe.setDescricao("em pó 300g");
        System.out.println(cafe.getDescricao());
        cafe.setMarca("Bom Jesus");
        System.out.println(cafe.getMarca());
        cafe.alterarPreco(15);
        System.out.println(cafe.getPreco());
        cafe.aumentarPreco(10);
        System.out.println(cafe.getPreco());
        cafe.imprime();
    }
}
