package entidade;

import exception.ValorInvalidoDepositoException;
import exception.ValorInvalidoSaqueException;

public abstract class ContaAbstrata {
    protected int numero;
    protected double saldo;
    protected Cliente cliente;

    public ContaAbstrata(int numero, Cliente cliente) {
        this.numero = numero;
        this.cliente = cliente;
        this.saldo = 0;
    }

    public ContaAbstrata(int numero, double saldo, Cliente cliente) {
        this.numero = numero;
        this.cliente = cliente;
        this.saldo = saldo;
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

    public void sacar(double valor) throws ValorInvalidoSaqueException {
        if (valor <= 0 || valor > this.saldo) {
            throw new ValorInvalidoSaqueException("Valor invalido para Saque!");
        }

        this.saldo -= valor;
    }

    public void depositar(double valor) throws ValorInvalidoDepositoException {
        if (valor <= 0 ) {
            throw new ValorInvalidoDepositoException("Valor invalido para Deposito!");
        }

        this.saldo += valor;
    }

}
