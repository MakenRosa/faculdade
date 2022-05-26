package expoo;
public class Escritorio {
    private String cnpj;
    private Endereco endereco;

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    
    public void setEndereco(Endereco endereco){
        this.endereco = endereco;
    }

    public Endereco getEndereco() {
        return endereco;
    }
}
