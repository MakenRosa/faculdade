package interfaces;
public class Alimento extends AlimentoBase implements Transportavel, Perecivel{
    private int empilhamentoMaximo;
    private int diasDeValidade;

    public Alimento(int empilhamentoMaximo, int diasDeValidade, String nome, int temperatura, int gramas, double cm3) {
        super(nome, temperatura, gramas, cm3);
        this.empilhamentoMaximo = empilhamentoMaximo;
        this.diasDeValidade = diasDeValidade;
    }
    @Override
    public double getVolume(){
        return super.getVolumeCm3();
    }
    @Override
    public double getPeso(){
        return super.getPesoGramas()/1000;
        
    }
    @Override
    public int getEmpilhamentoMaximo(){
        return this.empilhamentoMaximo;
        
    }
    @Override
    public int getTemperaturaDeConservacao(){
        return super.getTemperatura();
        
    }
    @Override
    public int getDiasDeValidacao(){
        return this.diasDeValidade;
        
    }

    public int getDiasDeValidade() {
        return diasDeValidade;
    }

    public void setDiasDeValidade(int diasDeValidade) {
        this.diasDeValidade = diasDeValidade;
    }
    
}