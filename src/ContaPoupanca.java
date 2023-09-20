public class ContaPoupanca extends ContaBancaria{

    private final double limite = 100;

    public ContaPoupanca(int numero) {
        super(numero);
    }

    @Override
    public boolean sacar(double valor) {
        if(this.getSaldo() + limite - valor >= 0 && valor > 0){
            this.setSaldo(this.getSaldo() - valor);
            return true;
        }
        return false;
    }

    @Override
    public boolean depositar(double valor) {
        if(valor > 0){
            this.setSaldo(this.getSaldo() + valor);
            return true;
        }
        return false;
    }

    @Override
    public String mostrarDados() {
        return  "\n    CONTA POUPANCA" +
                "\nNúmero: " + getNumero() +
                "\nSaldo: " + getSaldo() +
                "\nLimite: " + limite + "\n";
    }
}
