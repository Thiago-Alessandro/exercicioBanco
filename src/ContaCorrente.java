public class ContaCorrente extends ContaBancaria{

    private double taxaDeOperacao = 0.1;
    
    @Override
    public boolean sacar(double valor) {
        if(this.getSaldo() - valor > 0){
            this.setSaldo(this.getSaldo() - (valor  + valor * taxaDeOperacao) );
            return false;
        } else {
            return false;
        }
    }

    @Override
    public boolean depositar(double valor) {
        this.setSaldo(this.getSaldo() + (valor - (valor * taxaDeOperacao)));
        return true;
    }

    @Override
    public String mostrarDados() {
        return  "\n    CONTA CORRENTE" +
                "\nNumero: " + getNumero() +
                "\nSaldo: " + getSaldo() +
                "\ntaxa de operação: " + taxaDeOperacao;
    }
}
