public class ContaCorrente extends ContaBancaria{

    private final double taxaDeOperacao = 0.01;

    public ContaCorrente(int numero) {
        super(numero);
    }

    @Override
    public boolean sacar(double valor) {
        if(this.getSaldo() - valor >= 0 && valor > 0){
            this.setSaldo(this.getSaldo() - (valor  + valor * taxaDeOperacao) );
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean depositar(double valor) {
        if(valor > 0){
            this.setSaldo(this.getSaldo() + (valor - (valor * taxaDeOperacao)));
            return true;
        }
        return false;
    }

    @Override
    public String mostrarDados() {
        return  "\n    CONTA CORRENTE" +
                "\nNumero: " + getNumero() +
                "\nSaldo: " + getSaldo() +
                "\ntaxa de operação: " + taxaDeOperacao + "\n";
    }
}
