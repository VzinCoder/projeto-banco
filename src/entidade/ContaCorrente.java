package entidade;

public class ContaCorrente extends ContaAbstrata{
    
    public ContaCorrente(int numero, Cliente cliente) {
        super(numero, cliente);
    }
    
    public ContaCorrente(int numero, double saldo, Cliente cliente) {
        super(numero,saldo,cliente);
    }
}
