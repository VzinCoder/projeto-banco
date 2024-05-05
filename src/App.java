import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import entidade.BancoAbstrato;
import entidade.BancoBradesco;
import entidade.BancoBrasil;
import entidade.Cliente;
import entidade.ContaAbstrata;
import entidade.TipoConta;
import exception.AccountAlreadyExistsException;
import exception.ClienteInvalidoException;
import exception.ContaNaoEncontradaException;
import exception.ContasEmptyException;
import exception.ValorInvalidoException;

public class App {

    static Scanner scan = new Scanner(System.in);
    static BancoAbstrato bancoBrasil = new BancoBrasil();
    static BancoAbstrato bancoBradesco = new BancoBradesco();
    static List<Cliente> clientes = new ArrayList<>();

    public static void main(String[] args) {

        int op;
        do {

            System.out.println("1 - Banco Brasil ");
            System.out.println("2 - Banco Bradesco ");
            System.out.println("0 - Sair ");
            System.out.print("Digite a op: ");
            op = scan.nextInt();
            switch (op) {
                case 1:
                    try {
                        menuBanco("brasil");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                case 2:
                    try {
                        menuBanco("bradesco");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 0:
                    System.out.println("Sistema encerrado!");
                    break;
                default:
                    System.out.println("Op invalida para realizar as operacoes!");
                    break;
            }

        } while (op != 0);
    }

    public static void menuBanco(String nomeBanco) throws Exception {

        if (!(nomeBanco.equalsIgnoreCase("brasil") || nomeBanco.equalsIgnoreCase("bradesco"))) {
            throw new Exception("Banco invalido!");
        }

        nomeBanco = nomeBanco.toUpperCase();
        int op;
        do {
            System.out.println("---- Banco do " + nomeBanco + "-------");
            System.out.println("1 - Cadastrar conta Poupanca");
            System.out.println("2 - Cadastrar conta Corrente");
            System.out.println("3 - Remover conta Poupanca");
            System.out.println("4 - Remover conta Corrente");
            System.out.println("5 - Buscar Conta Poupanca");
            System.out.println("6 - Buscar Conta Corrente");
            System.out.println("7 - Listar Contas Poupanca");
            System.out.println("8 - Listar Contas Corrente");
            System.out.println("9 - Sacar conta Poupanca");
            System.out.println("10 - Sacar conta Corrente");
            System.out.println("11 - Depositar conta Poupanca");
            System.out.println("12 - Depositar conta Corrente");
            System.out.println("13 - Tranferir para conta Poupanca Brasil");
            System.out.println("14 - Tranferir para conta Corrente Brasil");
            System.out.println("15 - Tranferir para conta Poupanca Bradesco");
            System.out.println("16 - Tranferir para conta Corrente Bradesco");
            System.out.println("0 - Voltar para o menu anterior");
            System.out.print("Digite a op: ");
            op = scan.nextInt();
            switch (op) {
                case 1:
                    try {
                        criarConta(nomeBanco, TipoConta.Poupanca);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        criarConta(nomeBanco, TipoConta.Corrente);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        removerConta(TipoConta.Poupanca, nomeBanco);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                case 4:
                    try {
                        removerConta(TipoConta.Corrente, nomeBanco);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                case 5:
                    try {
                        buscarConta(nomeBanco, TipoConta.Poupanca);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 6:
                    try {
                        buscarConta(nomeBanco, TipoConta.Corrente);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 7:
                    try {
                        listarContas(nomeBanco, TipoConta.Poupanca);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 8:
                    try {
                        listarContas(nomeBanco, TipoConta.Corrente);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 9:
                    try {
                        sacar(nomeBanco, TipoConta.Poupanca);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                case 10:
                    try {
                        sacar(nomeBanco, TipoConta.Corrente);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                case 11:
                    try {
                        depositar(nomeBanco, TipoConta.Poupanca);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                case 12:
                    try {
                        depositar(nomeBanco, TipoConta.Corrente);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                case 13:
                    try {
                        transferir(nomeBanco, "brasil", TipoConta.Poupanca);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 14:
                    try {
                        transferir(nomeBanco, "brasil", TipoConta.Corrente);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 15:
                    try {
                        transferir(nomeBanco, "bradesco", TipoConta.Poupanca);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 16:
                    try {
                        transferir(nomeBanco, "bradesco", TipoConta.Corrente);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 0:
                    System.out.println("Voltando...");
                    break;

                default:
                    System.out.println("Op invalida!");
                    break;
            }
        } while (op != 0);
    }

    public static BancoAbstrato getBanco(String nomeBanco) throws Exception {
        if (nomeBanco.equalsIgnoreCase("brasil")) {
            return bancoBrasil;
        } else if (nomeBanco.equalsIgnoreCase("bradesco")) {
            return bancoBradesco;
        } else {
            throw new Exception("Banco invalido");
        }
    }

    public static void criarConta(String nomeBanco, TipoConta tipo)
            throws ClienteInvalidoException, AccountAlreadyExistsException, Exception {
        System.out.print("Digite o codigo do cliente: ");
        int cod = scan.nextInt();

        Cliente cliente = null;
        for (Cliente c : clientes) {
            if (c.getCod() == cod) {
                cliente = c;
                break;
            }
        }

       
        if (cliente == null) {
            System.out.print("Digite o nome do cliente: ");
            String nome = scan.next();
            System.out.print("Digite a idade do cliente: ");
            int age = scan.nextInt();
            cliente = new Cliente(cod, nome, age);
            clientes.add(cliente);
        }

        System.out.print("Digite o numero da Conta: ");
        int  numero = scan.nextInt();
        getBanco(nomeBanco).criarConta(cliente, tipo, numero);
    }

    public static void removerConta(TipoConta tipo, String nomeBanco)
            throws ContaNaoEncontradaException, ContasEmptyException, Exception {
        System.out.print("Digite o numero da Conta: ");
        int numero = scan.nextInt();
        getBanco(nomeBanco).removerConta(numero, tipo);
    }

    public static void buscarConta(String nomeBanco, TipoConta tipo)
            throws ContaNaoEncontradaException, ContasEmptyException, Exception {
        System.out.print("Digite o numero da Conta: ");
        int numero = scan.nextInt();
        ContaAbstrata conta = getBanco(nomeBanco).buscarConta(numero, tipo);
        System.out.println("Conta " + tipo);
        System.out.println("Numero da conta: " + conta.getNumero());
        System.out.println("Saldo da conta " + conta.getSaldo());
        System.out.println(conta.getCliente());
    }

    public static void listarContas(String nomeBanco, TipoConta tipo) throws ContasEmptyException, Exception {
        List<ContaAbstrata> contas = getBanco(nomeBanco).retornarContas(tipo);

        contas.forEach(conta -> {
            System.out.println("-----------------------------------");
            System.out.println("Conta " + tipo);
            System.out.println("Numero da conta: " + conta.getNumero());
            System.out.println("Saldo da conta " + conta.getSaldo());
            System.out.println(conta.getCliente());
        });
    }

    public static void sacar(String nomeBanco, TipoConta tipo)
            throws ContaNaoEncontradaException, ContasEmptyException, ValorInvalidoException, Exception {
        System.out.print("Digite o numero da conta: ");
        int numero = scan.nextInt();
        System.out.print("Digite o Valor: ");
        double valor = scan.nextInt();
        getBanco(nomeBanco).sacar(numero, tipo, valor);
    }

    public static void depositar(String nomeBanco, TipoConta tipo)
            throws ContaNaoEncontradaException, ContasEmptyException, ValorInvalidoException, Exception {
        System.out.print("Digite o numero da conta: ");
        int numero = scan.nextInt();
        System.out.print("Digite o Valor: ");
        double valor = scan.nextInt();
        getBanco(nomeBanco).depositar(numero, tipo, valor);
    }

    public static void transferir(String nomeBancoOrigem, String nomeBancoDestino, TipoConta tipoDestino)
            throws ContaNaoEncontradaException, ContasEmptyException, ValorInvalidoException, Exception {

        int op;

        TipoConta tipoOrigem = null;
        do {
            System.out.println("Qual o tipo da sua Conta?");
            System.out.println("1- Conta Poupanca");
            System.out.println("2- Conta Corrente");
            System.out.println("3- Cancelar");
            op = scan.nextInt();
            switch (op) {
                case 1:
                    tipoOrigem = TipoConta.Poupanca;
                    break;
                case 2:
                    tipoOrigem = TipoConta.Corrente;
                    break;
                case 3:
                    System.out.println("Voltando...");
                    return;
                default:
                    System.out.println("op invalida!");
                    break;
            }
        } while (op != 1 && op != 2);

        System.out.print("Digite o numero da conta de origem: ");
        int numeroOrigem = scan.nextInt();
        System.out.print("Digite o numero da conta de destino: ");
        int numeroDestino = scan.nextInt();
        System.out.print("Digite o Valor: ");
        double valor = scan.nextInt();

        BancoAbstrato bancoOrigem = getBanco(nomeBancoOrigem);
        BancoAbstrato bancoDestino = getBanco(nomeBancoDestino);
        ContaAbstrata contaOrigem = bancoOrigem.buscarConta(numeroOrigem, tipoOrigem);
        ContaAbstrata contaDestino = bancoDestino.buscarConta(numeroDestino, tipoDestino);

        bancoOrigem.transferir(contaOrigem, contaDestino, valor);
    }
}
