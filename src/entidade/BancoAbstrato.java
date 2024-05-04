package entidade;

import java.util.ArrayList;
import java.util.List;

import exception.AccountAlreadyExistsException;
import exception.ClienteInvalidoException;
import exception.ContaNaoEncontradaException;
import exception.ContasEmptyException;
import exception.NumeroContaException;
import exception.ValorInvalidoException;

public abstract class BancoAbstrato {
    protected List<ContaAbstrata> contas;

    public BancoAbstrato() {
        this.contas = new ArrayList<>();
    }

    public ContaAbstrata criarConta(Cliente cliente, TipoConta tipo, int numero)
            throws ClienteInvalidoException, AccountAlreadyExistsException {

        if (!cliente.isMaiorIdade()) {
            throw new ClienteInvalidoException("Cliente menor de idade!");
        }


        if(verificarClientePossuiContaTipo(cliente, tipo)){
            throw new AccountAlreadyExistsException("Usuario já possui uma conta desse tipo");
        }


        if (verificarContaExiste(numero, tipo)) {
            throw new AccountAlreadyExistsException("Uma conta com esse numero já existe");
        }

        ContaAbstrata conta = null;
        if (tipo == TipoConta.Poupanca) {
            conta = new ContaPoupanca(numero, cliente);
        } else {
            conta = new ContaCorrente(numero, cliente);
        }

        contas.add(conta);
        return conta;
    }

    private boolean verificarClientePossuiContaTipo(Cliente cliente, TipoConta tipo) {
        if (tipo == TipoConta.Poupanca) {
            return contas.stream().anyMatch(c -> c.getCliente() == cliente && c instanceof ContaPoupanca);
        }
        return contas.stream().anyMatch(c -> c.getCliente() == cliente && c instanceof ContaCorrente);
    }

    private boolean verificarContaExiste(int numero, TipoConta tipo) {
        try {
            buscarConta(numero, tipo);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void removerConta(int numero, TipoConta tipo) throws ContaNaoEncontradaException, ContasEmptyException {
        ContaAbstrata conta = buscarConta(numero, tipo);
        contas.remove(conta);
    }

    public ContaAbstrata buscarConta(int numero, TipoConta tipoConta)
            throws ContaNaoEncontradaException, ContasEmptyException {
        if (contas.isEmpty()) {
            throw new ContasEmptyException("Não tem contas cadastrads");
        }

        if (tipoConta == TipoConta.Corrente) {
            for (ContaAbstrata conta : contas) {
                if (conta.getNumero() == numero && conta instanceof ContaCorrente) {
                    return conta;
                }
            }
        } else {
            for (ContaAbstrata conta : contas) {
                if (conta.getNumero() == numero && conta instanceof ContaPoupanca) {
                    return conta;
                }
            }
        }

        throw new ContaNaoEncontradaException("Conta nao encontrada!");
    }

    public List<ContaAbstrata> retornarContas(TipoConta tipoConta) throws ContasEmptyException {
        if (contas.isEmpty()) {
            throw new ContasEmptyException("Nao tem contas cadastradas!");
        }

        List<ContaAbstrata> contasEncontradas;

        if (tipoConta == TipoConta.Poupanca) {
            contasEncontradas = contas.stream()
                    .filter(c -> c instanceof ContaPoupanca ? true : false)
                    .toList();
        } else {
            contasEncontradas = contas.stream()
                    .filter(c -> c instanceof ContaCorrente ? true : false)
                    .toList();
        }

        return contasEncontradas;
    }

    public abstract void transferir(ContaAbstrata origem, ContaAbstrata destino, double Valor)
            throws ValorInvalidoException, NumeroContaException, ContaNaoEncontradaException;

    public void sacar(int numero, TipoConta tipo, double valor)
            throws ContaNaoEncontradaException, ContasEmptyException, ValorInvalidoException {
        ContaAbstrata conta = buscarConta(numero, tipo);
        conta.sacar(valor);
    }

    public void depositar(int numero, TipoConta tipo, double valor)
            throws ContaNaoEncontradaException, ContasEmptyException, ValorInvalidoException {
        ContaAbstrata conta = buscarConta(numero, tipo);
        conta.depositar(valor);
    }

}
