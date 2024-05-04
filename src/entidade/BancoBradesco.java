package entidade;

import java.util.List;

import exception.ContaNaoEncontradaException;
import exception.NumeroContaException;
import exception.ValorInvalidoException;

public class BancoBradesco extends BancoAbstrato {

    public BancoBradesco(String nome, String agencia) {
        super(nome, agencia);
    }

    public BancoBradesco(String nome, String agencia, List<ContaAbstrata> contas) {
        super(nome, agencia, contas);
    }

    @Override
    public void transferir(ContaAbstrata origem, ContaAbstrata destino, double valor) throws ValorInvalidoException, NumeroContaException,ContaNaoEncontradaException {

        if(valor < 30){
            throw new ValorInvalidoException("Não é possivel tranferir menos de 30 reais!");
        }

        if(!super.contas.contains(origem)){
            throw new ContaNaoEncontradaException("Conta nao cadastrada nesse banco!");
        }

        if(origem == destino){
            throw new NumeroContaException("Não é possivel realizar transferencia para a mesma conta!");
        }

        if(super.contas.contains(destino)){
            origem.sacar(valor);
            destino.depositar(valor);
            return;
        }

        if(origem instanceof ContaCorrente){
            origem.sacar(valor);
            destino.depositar(valor - (valor*0.05));
        }else{
            origem.sacar(valor);
            destino.depositar(valor - (valor*0.1));
        }

    }


}
