package entidade;

import exception.ContaNaoEncontradaException;
import exception.NumeroContaException;
import exception.ValorInvalidoException;

public class BancoBrasil extends BancoAbstrato {
    public BancoBrasil() {
        super();
    }


    @Override
    public void transferir(ContaAbstrata origem,ContaAbstrata destino,double valor)throws ValorInvalidoException,NumeroContaException,ContaNaoEncontradaException{
         if(valor < 100){
            throw new ValorInvalidoException("Não é possivel tranferir menos de 100 reais!");
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
            destino.depositar(valor - (valor*0.02));
        }else{
            origem.sacar(valor);
            destino.depositar(valor - (valor*0.05));
        }

    }
}
