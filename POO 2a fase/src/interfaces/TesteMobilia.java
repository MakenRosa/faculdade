package interfaces;
public class TesteMobilia {
    public static void main(String[] args) {
        Mobilia mobilia = new Mobilia("Mesa", "Rosa Móveis", "Vidro", 115, 70, 90, 11);
        System.out.println("Tipo: " + mobilia.getTipo() + "\n"
                + "Volume: "+ mobilia.getVolume() + "\n"
                        + "Peso: " + mobilia.getPeso()+"\n"
                                + "Empilhamento máximo: "+ mobilia.getEmpilhamentoMaximo());
    }
}
