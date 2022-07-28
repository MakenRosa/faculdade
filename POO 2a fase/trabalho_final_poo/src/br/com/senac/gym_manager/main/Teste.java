package br.com.senac.gym_manager.main;

import br.com.senac.gym_manager.enums.DiasDaSemana;
import br.com.senac.gym_manager.enums.StatusPagamento;
import br.com.senac.gym_manager.entidades.Cliente;
import br.com.senac.gym_manager.entidades.ClienteExperimental;
import br.com.senac.gym_manager.entidades.CartaoPasseCliente;
import br.com.senac.gym_manager.entidades.CatracaAcademia;
import br.com.senac.gym_manager.entidades.Exercicio;
import br.com.senac.gym_manager.entidades.Mensalidade;
import br.com.senac.gym_manager.entidades.Treinamento;
import java.util.ArrayList;
import java.util.List;

public class Teste {

    public static List<Exercicio> criarExercicios() {
        List<Exercicio> exercicios = new ArrayList();
        exercicios.add(new Exercicio("Supino declinado", 10, 3, "Halteres"));
        exercicios.add(new Exercicio("Flexão centrada", 12, 3));
        exercicios.add(new Exercicio("One Arm Row", 8, 3, "Halteres"));
        exercicios.add(new Exercicio("Bent Over Row", 8, 3, "Barra"));
        exercicios.add(new Exercicio("Bícep Curl", 10, 3, "Barra W"));
        exercicios.add(new Exercicio("Bícep Curl", 8, 3, "Halteres"));
        exercicios.add(new Exercicio("Trícep Extension", 8, 2, "Barra"));
        exercicios.add(new Exercicio("Trícep Deep", 8, 3, "Banco"));
        exercicios.add(new Exercicio("Reverse Fly (deitado)", 8, 3, "Halteres"));
        exercicios.add(new Exercicio("Lateral Raise", 8, 3, "Polia"));
        exercicios.add(new Exercicio("Agachamento", 8, 3, "Barra"));
        exercicios.add(new Exercicio("Abdominal (Oblíquo)", 12, 3));
        exercicios.add(new Exercicio("Abdominal (Reto)", 12, 3));
        return exercicios;
    }

    public static List<Exercicio> listarExercicios(List<Exercicio> lista,
            int indEx1, int indEx2, int indEx3, int indEx4) throws Exception, IndexOutOfBoundsException {
        if (lista.size() < 4) {
            throw new IndexOutOfBoundsException("Lista deve conter pelo menos 4 itens! ");
        }
        List<Exercicio> exercicios = new ArrayList();
        exercicios.add(lista.get(indEx1));
        exercicios.add(lista.get(indEx2));
        exercicios.add(lista.get(indEx3));
        exercicios.add(lista.get(indEx4));
        return exercicios;
    }

    public static List<Exercicio> listarExercicios(List<Exercicio> lista,
            int indEx1, int indEx2, int indEx3, int indEx4, int indEx5) throws Exception, IndexOutOfBoundsException {
        if (lista.size() < 5) {
            throw new IndexOutOfBoundsException("Lista deve conter pelo menos 5 itens! ");
        }
        List<Exercicio> exercicios = new ArrayList();
        exercicios.add(lista.get(indEx1));
        exercicios.add(lista.get(indEx2));
        exercicios.add(lista.get(indEx3));
        exercicios.add(lista.get(indEx4));
        exercicios.add(lista.get(indEx5));
        return exercicios;
    }
    public static void createSetTreinamento(String nomeTreinamento, List<Exercicio>
            exercicios, DiasDaSemana diaDoTreino, Cliente cliente){
        Treinamento treino = new Treinamento(nomeTreinamento, exercicios, diaDoTreino);
        cliente.adicionarTreinamento(treino);
    }
    public static void linha(){
        System.out.println("======================================================");
    }

    public static void main(String[] args) {
        // Instanciando a catraca da academia
        CatracaAcademia catraca = new CatracaAcademia();
        linha();

        // Instanciando a mensalidade do cliente
        Mensalidade julho = new Mensalidade("Julho", 125.00, StatusPagamento.PAGAMENTO_EM_ESPERA);
        linha();

        // Instanciando pessoas
        Cliente maken = new Cliente(02101, "Maken da Rosa", "78969647990", 19, julho);

        ClienteExperimental leonardo = new ClienteExperimental("Leonardo Fulano",
                                                            "78933245888", 17);
        leonardo.setDataAulaExperimental("07/07/2022");
        linha();
        
        // Instanciando Exercicios
        List<Exercicio> exercicios = criarExercicios();
        linha();
        linha();
        // Criando listas de exercícios separadas
        try {
            List<Exercicio> listTreino1 = listarExercicios(exercicios, 1, 0, 4, 5);
            List<Exercicio> listTreino2 = listarExercicios(exercicios, 10, 8, 9, 12);
            List<Exercicio> listTreino3 = listarExercicios(exercicios, 11, 7, 6, 3, 2);
            List<Exercicio> listTreino4 = listarExercicios(exercicios, 7, 4, 12, 6);
            // Criando treinamentos e associando-os aos clientes
            createSetTreinamento("Peitoral e bíceps",
                    listTreino1, DiasDaSemana.SEGUNDA_FEIRA, maken);
            createSetTreinamento("Deltoide, quadriceps e abdomen",
                    listTreino2, DiasDaSemana.QUARTA_FEIRA, maken);
            createSetTreinamento("Abdomen, triceps e dorsal",
                    listTreino3, DiasDaSemana.SEXTA_FEIRA, maken);
            linha();
            Treinamento experimental = new Treinamento("Triceps, biceps e abdomen",
                    listTreino4);
            leonardo.setTreinamento(experimental);

        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Índices inválidos! " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("Não foi possível criar/associar os treinamentos! " + ex.getMessage());
        }
        linha();
        // Instanciando e Adicionando Cartao na catraca
        CartaoPasseCliente cartaoMaken = new CartaoPasseCliente("451A32X5", catraca);
        catraca.adicionarCartao(cartaoMaken);
        linha();
        // Associando cartão ao cliente
        maken.setCartao(cartaoMaken);
        linha();
        // Utilizando o sistema
        maken.pagarMensalidade();
        maken.entrarNaAcademia();
    }
}
