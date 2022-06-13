package exs_associacao02;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Teste {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("John", "Jack", "Hamilton", "George");
        List<String> resultados = names.stream().filter(name -> name.startsWith("J")).collect(Collectors.toList());
        resultados.forEach(element -> System.out.println(element));
    }
}
