package entidade;

class ContaPoupanca extends ContaAbstrata{

    public ContaPoupanca(int numero, Cliente cliente) {
        super(numero, cliente);
    }
    
    public ContaPoupanca(int numero, double saldo, Cliente cliente) {
        super(numero,saldo,cliente);
    }
}
