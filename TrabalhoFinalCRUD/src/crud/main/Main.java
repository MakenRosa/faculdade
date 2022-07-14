package crud.main;

import crud.dao.EnderecoDAO;
import crud.dao.PacienteDAO;
import crud.dao.impl.EnderecoDAOImpl;
import crud.dao.impl.PacienteDAOImpl;
import crud.entidades.Endereco;
import crud.entidades.Paciente;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // instaciando as DAO's
        PacienteDAO daoP = new PacienteDAOImpl();
        EnderecoDAO daoE = new EnderecoDAOImpl();

        // criando lista de pacientes
        List<Paciente> pacientes = new ArrayList();

        // instanciando pacientes
        Paciente maken = new Paciente("Maken da Rosa", "84756374858", LocalDate.of(2002, Month.AUGUST, 07));
        Paciente enzolas = new Paciente("Enzo Moura", "12323123123", LocalDate.of(2003, Month.DECEMBER, 10));
        Endereco endMaken = new Endereco("88111671", "Rua João Paulo Gaspar", 8343);
        Endereco endEnzo = new Endereco("23211345", "Rua Principal", 3244);
        Endereco endMaken1 = new Endereco("314445213", "Recanto alalala", 9342);

        // adicionando pacientes a lista de pacientes
        pacientes.add(maken);
        pacientes.add(enzolas);

        // adicionando os enderecos aos pacientes
        maken.getEnderecos().add(endMaken);
        maken.getEnderecos().add(endMaken1);
        enzolas.getEnderecos().add(endEnzo);

        try {

            for (Paciente paciente : pacientes) {
                // criando pacientes no banco de dados
                daoP.criar(paciente);

                for (Endereco endereco : paciente.getEnderecos()) {
                    // criando enderecos dos pacientes no banco de dados
                    daoE.criar(endereco, paciente.getId());
                }
                System.out.println(daoE.pesquisarTodosPaciente(paciente.getId()));
            }
            maken.setNome("Maken Cristhian");
            daoP.alterar(maken);
            daoP.excluir(2);
        } catch (Exception ex) {
            System.err.println("Erro! " + ex.getMessage());
        }
    }
}
