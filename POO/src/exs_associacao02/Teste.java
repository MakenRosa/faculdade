package exs_associacao02;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Teste {
    public static void main(String[] args) throws ParseException {
        //Criando cidades
        Cidade sjsc = new Cidade(-0300, "São José", 0301, "Brasil");
        Cidade palhoca = new Cidade(-0300, "Palhoça", 0511, "Brasil");
        Cidade riobranco = new Cidade(-0500, "Rio Branco", 6666, "Brasil");
        
        //Criando categorias
        Categoria classeEconomica = new Categoria("Classe Econômica", 100);
        Categoria classeExecutiva = new Categoria("Classe Executiva", 130);
        
        //Criando assentos
        Assento a_01 = new Assento("A01", classeEconomica);
        Assento a_02 = new Assento("A02", classeEconomica);
        Assento a_03 = new Assento("A03", classeEconomica);
        Assento e_01 = new Assento("E01", classeExecutiva);
        Assento e_02 = new Assento("E02", classeExecutiva);
        List<Assento> assentosA320 = new ArrayList();
        assentosA320.add(a_01);
        assentosA320.add(a_02);
        assentosA320.add(a_03);
        assentosA320.add(e_01);
        assentosA320.add(e_02);
        
        //Criando aeronave
        Aeronave latamBrasil = new Aeronave(5, "A320", 45121, "Airbus", assentosA320);
        
        //Criando voo
        String dataStr = "20062022";
        SimpleDateFormat formatStrToDate = new SimpleDateFormat("ddMMyyyy");
        Date data = formatStrToDate.parse(dataStr);
        Voo latamBrasil12 = new Voo(13, 8, data, 1200.00, 20, latamBrasil, sjsc, riobranco);
        
        //Criando cartao
        CartaoFidelidade nuBank = new CartaoFidelidade("4512421533", 50, CategoriaCartao.SILVER);
        
        //Criando passageiro
        Passageiro maken = new Passageiro("Maken", "da Rosa", false, nuBank);
        
        //Criando forma de pagamento
        PagamentoCartaoCredito pagamentoMaken = new PagamentoCartaoCredito("Cartão de crédito 12x sem juros", nuBank); 
        
        //Criando reserva
        Reserva makenReserva = new Reserva(121, 17082022, 15082022, StatusReserva.CONFIRMADA, latamBrasil12, maken, pagamentoMaken);
        maken.setReservas(makenReserva);
        
        //Criando bilhete
        Bilhete makenBilhete = new Bilhete(e_02, makenReserva);
        
        SimpleDateFormat formatBr = new SimpleDateFormat("d/MM/yyyy");
        
        String diaVooDate = Integer.toString(makenBilhete.getReserva().getData());
        Date date = formatStrToDate.parse(diaVooDate);
        String diaVooStr = formatBr.format(date);
        
        
        System.out.println("O passageiro " + makenBilhete.getPassageiro().getNome() +
                "\nPegará o voo de número:" + makenBilhete.getVoo().getNumero()+ 
                "\nQue sairá de " + makenBilhete.getVoo().getOrigem().getNome() +"\nNo dia: " 
                + diaVooStr
                + "\nCom destino para " + makenBilhete.getVoo().getDestino().getNome() + 
                "\nCom a duração de "+ makenBilhete.getVoo().getDuracao()+ " horas\n ");
        
    }
}
