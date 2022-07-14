package crud.entidades;
public class Endereco {
    private Long id;
    private String cep;
    private String Logradouro;
    private int numero;

    public Endereco(String cep, String Logradouro, int numero) {
        this.cep = cep;
        this.Logradouro = Logradouro;
        this.numero = numero;
    }

    public Endereco() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return Logradouro;
    }

    public void setLogradouro(String Logradouro) {
        this.Logradouro = Logradouro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}
