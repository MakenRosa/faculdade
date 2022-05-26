package dates;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ConversaoData {

    public static void main(String[] args) {
    String dataStr = "2022-05-18 21:00:00";
    DateTimeFormatter formatador = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    LocalDateTime data = LocalDateTime.parse(dataStr, formatador);
    DateTimeFormatter formatBrasil = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    System.out.println(data.plusHours(4).format(formatBrasil));
    }
}
