package expoo;

import java.util.ArrayList;
import java.util.List;

public class Empresa {
    private List<Departamento> departamentos;
    private List<Escritorio> escritorios;
    
    public Empresa(){
        this.departamentos = new ArrayList();
        this.escritorios = new ArrayList();
    }
    public void adicionarDepartamento(Departamento departamento){
        departamentos.add(departamento);
    }
    public void adicionarEscritorio(Escritorio escritorio){
        escritorios.add(escritorio);
    }

    public List<Departamento> getDepartamentos() {
        return departamentos;
    }

    public void setDepartamentos(List<Departamento> departamentos) {
        this.departamentos = departamentos;
    }

    public List<Escritorio> getEscritorios() {
        return escritorios;
    }

    public void setEscritorios(List<Escritorio> escritorios) {
        this.escritorios = escritorios;
    }
}
