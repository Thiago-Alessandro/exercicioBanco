public class ExecutavelTeste {

    public static void main(String[] args) {

        ContaCorrente contaCorrente = new ContaCorrente(999);
        ContaPoupanca contaPoupanca = new ContaPoupanca(777);

        Relatorio relatorio = new Relatorio();

        contaPoupanca.depositar(200);
        contaCorrente.depositar(200);

        contaCorrente.sacar(150);
        contaPoupanca.sacar(250);

        System.out.println(relatorio.gerarRelatorio(contaCorrente));
        System.out.println(relatorio.gerarRelatorio(contaPoupanca));

    }

}
