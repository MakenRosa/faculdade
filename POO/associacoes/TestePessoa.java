package associacoes;
public class TestePessoa {
    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa();
        Endereco enderecoPessoa = new Endereco();
        try{
            pessoa.adicionarEndereco(enderecoPessoa);
        } catch (NullPointerException ex){
            enderecoPessoa.setRua("Padrão");
            pessoa.adicionarEndereco(enderecoPessoa);
        }
    }
        
}
