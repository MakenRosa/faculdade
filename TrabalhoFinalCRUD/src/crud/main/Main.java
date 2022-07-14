package crud.main;

import crud.dao.EnderecoDAO;
import crud.dao.PacienteDAO;
import crud.dao.impl.EnderecoDAOImpl;
import crud.dao.impl.PacienteDAOImpl;
import crud.entidades.Endereco;
import crud.entidades.Paciente;
import java.time.LocalDate;
import java.time.Month;

public class Main {
    public static void main(String[] args) {
        PacienteDAO daoP = new PacienteDAOImpl();
        EnderecoDAO daoE = new EnderecoDAOImpl();
        Paciente maken = new Paciente("Maken da Rosa", "84756374858", LocalDate.of(2002, Month.AUGUST, 07));
        Paciente enzolas = new Paciente("Enzo Moura", "12323123123", LocalDate.of(2003, Month.DECEMBER, 10));
        Endereco endMaken = new Endereco("88111671", "Rua João Paulo Gaspar", 8343);
        Endereco endEnzo = new Endereco("23211345", "Rua dos macacos", 3244);
        try {
            daoE.criar(endMaken, 5);
            daoE.criar(endEnzo, 6);
        } catch (Exception ex) {
            System.err.println("Erro!");
        }
        
        
        
        
    }
}
