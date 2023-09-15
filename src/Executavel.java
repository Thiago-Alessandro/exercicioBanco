public class Executavel {

    public static void main(String[] args) {

        ContaCorrente contaCorrente = new ContaCorrente();
        ContaPoupanca contaPoupanca = new ContaPoupanca();

        Relatorio relatorio = new Relatorio();

        contaPoupanca.depositar(200);
        contaCorrente.depositar(200);

        contaCorrente.sacar(150);
        contaPoupanca.sacar(250);

        System.out.println(relatorio.gerarRelatorio(contaCorrente));
        System.out.println(relatorio.gerarRelatorio(contaPoupanca));

    }

}
