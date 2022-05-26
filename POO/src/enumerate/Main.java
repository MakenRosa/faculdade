
package enumerate;
public class Main {
    public static void main(String[] args) {
        Mes mes = Mes.findByMes(2);
        int dias = Mes.diasMes(mes);
        System.out.println(Mes.valueOf("JANEIRO"));
    }
    
}
