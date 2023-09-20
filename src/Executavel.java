import java.util.Scanner;

public class Executavel {

    private static final Scanner sc = new Scanner(System.in);
    private static final Banco banco = new Banco();
    private static final Relatorio relatorio = new Relatorio();

    public static void main(String[] args) {

        do {
            switch (menu()) {
                case 1 -> criarConta();
                case 2 -> menuConta(selecionarConta());
                case 3 -> removerConta();
                case 4 -> System.out.println(relatorio.gerarRelatorio(banco));
                case 0 -> System.exit(0);
                default -> System.out.println("Escolha uma opcao valida");
            }
        }while(true);
    }

    private static void criarConta(){
        System.out.println("""
                    CRIAR CONTA
                1 - Corrente
                2 - Poupança
                """);
        int opcao = sc.nextInt();
        if(opcao == 1 || opcao == 2){
            System.out.println("Insira o numero da sua conta: ");
            int numero = sc.nextInt();

            ContaBancaria contaNova;

            if(opcao == 1){
                contaNova = new ContaCorrente(numero);
            } else {
                contaNova = new ContaPoupanca(numero);
            }

            if(banco.inserirConta(contaNova)){
                System.out.println("Conta cadastrada com sucesso!");
                return;
            }
            System.out.println("O numero da conta ja existe!");
            return;
        }
        System.out.println("Opcao invalida!");
    }

    private static ContaBancaria selecionarConta(){
        System.out.println("Insira o numero da conta: ");
        ContaBancaria conta = banco.procurarConta(sc.nextInt());
        if(conta != null){
            return conta;
        }
        System.out.println("Conta inexistente!");
        return  null;
    }

    private static void removerConta(){
        if(banco.removerConta(selecionarConta())){
            System.out.println("Conta removida com sucesso!");
        }
    }

    private static int menu(){
        System.out.println("""
                    
                    MENU
                1 - Criar conta
                2 - Selecionar conta
                3 - Remover conta
                4 - Gerar relatorio
                0 - Finalizar
                
                """);
        return sc.nextInt();
    }

    private static void menuConta(ContaBancaria conta) {
        if (conta != null) {
            int opcao;
            do {
                System.out.println("""
                            
                            MENU CONTA
                        1 - Depositar
                        2 - Sacar
                        3 - Transferir
                        4 - Gerar Relatorio
                        0 - voltar
                        
                        """);
                opcao = sc.nextInt();
                switch (opcao) {
                    case 1 -> depositar(conta);
                    case 2 -> sacar(conta);
                    case 3 -> transferir(conta);
                    case 4 -> System.out.println(relatorio.gerarRelatorio(conta));
                    //podia so usar o mostrar dados mas o relatorio ta ai p ser usado em alguma coisa eu acho (a atividade fala p criar uma classe relatorio)
                    case 0 -> {}
                    default -> System.out.println("Escolha uma opcao valida");
                }
            }while(opcao != 0);
        }
    }

    private static void depositar(ContaBancaria conta){
        System.out.println("Insira o valor a ser depositado: ");
        double valor = sc.nextDouble();
        if(conta.depositar(valor)){
            System.out.println("Valor depositado com sucesso!");
        } else {
            System.out.println("Falha ao depositar o valor!");
        }
    }

    private static void sacar(ContaBancaria conta){
        System.out.println("Insira o valor a sacar: ");
        double valor = sc.nextDouble();
        if(conta.sacar(valor)){
            System.out.println("Valor sacado com sucesso!");
            return;
        }
        System.out.println("Falha ao sacar valor!");
    }

    private static void transferir(ContaBancaria conta){
        System.out.println("Insira o numero da conta para qual deseja trasnferir: ");
        int numero = sc.nextInt();
        ContaBancaria contaTransferencia = banco.procurarConta(numero);
        if(contaTransferencia != null){
            System.out.println("Insira o valor que deseja transferir: ");
            double valor = sc.nextDouble();
            if(conta.trasferir(valor, contaTransferencia)){
                System.out.println("Transferencia realizada com sucesso!");
                return;
            }
            System.out.println("Falha ao realizar transferencia!");
            return;
        }
        System.out.println("Conta inexistente!");
    }
}
