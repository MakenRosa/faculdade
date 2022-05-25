package statics;
public enum Periodo {
    DIURNO_INTEGRAL("Seg a Sex", 10, 18),
    DIURNO_MATUTINO("Seg a Sex", 8, 12),
    NOTURNO("Seg a Sex", 18, 22);
    private String dias;
    private int horasInicio;
    private int horasTermino;
    
    private Periodo(String dias, int horasInicio, int horasTermino) {
        this.dias = dias;
        this.horasInicio = horasInicio;
        this.horasTermino = horasTermino;
    }
    public String getDias() {
        return dias;
    }
    public int getHorasInicio() {
        return horasInicio;
    }
    public int getHorasTermino() {
        return horasTermino;
    }
    public int getTotalPeriodo(){
        return getHorasTermino() - getHorasInicio();
    }

    
    
}
