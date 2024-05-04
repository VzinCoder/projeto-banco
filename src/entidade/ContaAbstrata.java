package entidade;

import exception.ValorInvalidoException;

public abstract class ContaAbstrata {
    protected int numero;
    protected double saldo;
    protected Cliente cliente;

    public ContaAbstrata(int numero, Cliente cliente) {
        this.numero = numero;
        this.cliente = cliente;
        this.saldo = 0;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

     void sacar(double valor) throws ValorInvalidoException {
        if (valor <= 0 || valor > this.saldo) {
            throw new ValorInvalidoException("Valor invalido para Saque!");
        }

        this.saldo -= valor;
    }

     void depositar(double valor) throws ValorInvalidoException {
        if (valor <= 0 ) {
            throw new ValorInvalidoException("Valor invalido para Deposito!");
        }

        this.saldo += valor;
    }

    @Override
    public String toString() {
        return "ContaAbstrata [numero=" + numero + ", saldo=" + saldo + ", cliente=" + cliente + "]";
    }

    

}
