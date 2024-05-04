import entidade.BancoAbstrato;
import entidade.BancoBradesco;
import entidade.Cliente;
import entidade.TipoConta;

public class App {
    public static void main(String[] args) throws Exception {
        BancoAbstrato bb = new BancoBradesco("vinicius", "123");
        Cliente cliente = new Cliente(1, "vinicius", 18);
        bb.criarConta(cliente, TipoConta.Corrente, 1);
        bb.criarConta(cliente, TipoConta.Poupanca, 1);

        

        bb.buscarConta(1,TipoConta.Corrente);
    }
}
