package entidade;

public class Cliente {
    private int cod;
    private String nome;
    private int idade;
    private  boolean maiorIdade;

    public Cliente(String nome, int idade, boolean maiorIdade) {
        this.nome = nome;
        this.idade = idade;
        this.maiorIdade = maiorIdade;
    }

   
    public Cliente(int cod, String nome, int idade, boolean maiorIdade) {
        this.cod = cod;
        this.nome = nome;
        this.idade = idade;
        this.maiorIdade = maiorIdade;
    }

    public int getCod() {
        return cod;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public boolean isMaiorIdade() {
        return maiorIdade;
    }

    
}
