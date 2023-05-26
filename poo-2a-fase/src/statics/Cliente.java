package statics;
public class Cliente {
    private String nome;
    private TipoPessoa tipoCliente;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoPessoa getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(TipoPessoa tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public Cliente(String nome, TipoPessoa tipoCliente) {
        this.nome = nome;
        this.tipoCliente = tipoCliente;
    }
    
}
