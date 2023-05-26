package interfaces;
public class GalaoDeCombustivel implements Inflamavel{
    private String nomeCombustivel;
    private double densidade;
    private int temperaturaTransporte;

    public GalaoDeCombustivel(String nomeCombustivel, double densidade, int temperaturaTransporte) {
        this.nomeCombustivel = nomeCombustivel;
        this.densidade = densidade;
        this.temperaturaTransporte = temperaturaTransporte;
    }
    @Override
    public int getTemperaturaMaxima(){
        return (int) (this.temperaturaTransporte *1.4);
    }
    
    public String getNomeCombustivel() {
        return nomeCombustivel;
    }

    public void setNomeCombustivel(String nomeCombustivel) {
        this.nomeCombustivel = nomeCombustivel;
    }

    public double getDensidade() {
        return densidade;
    }

    public void setDensidade(double densidade) {
        this.densidade = densidade;
    }

    public int getTemperaturaTransporte() {
        return temperaturaTransporte;
    }

    public void setTemperaturaTransporte(int temperaturaTransporte) {
        this.temperaturaTransporte = temperaturaTransporte;
    }
    public double getVolume(){
        return 0;
    }
    public double getPeso(){
        return 0;
    }
    public int getEmpilhamentoMaximo(){
        return 0;
    }
}
