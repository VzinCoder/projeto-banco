package entidade;

public class Cliente {
    private int cod;
    private String nome;
    private int idade;
    private  boolean maiorIdade;

    public Cliente(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
        this.maiorIdade = idade>= 18? true:false;
    }
   
    public Cliente(int cod, String nome, int idade) {
        this.cod = cod;
        this.nome = nome;
        this.idade = idade;
        this.maiorIdade = idade>= 18? true:false;
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

    @Override
    public String toString() {
        return "Cliente [cod=" + cod + ", nome=" + nome + ", idade=" + idade + ", maiorIdade=" + maiorIdade + "]";
    }

    

    
}
