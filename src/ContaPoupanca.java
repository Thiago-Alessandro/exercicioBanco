public class ContaPoupanca extends ContaBancaria{

    private double limite = 100;

    @Override
    public boolean sacar(double valor) {
        if(this.getSaldo() + limite - valor > 0){
            this.setSaldo(this.getSaldo() - valor);
            return true;
        }
        return false;
    }

    @Override
    public boolean depositar(double valor) {
        this.setSaldo(this.getSaldo() + valor);
        return true;
    }

    @Override
    public String mostrarDados() {
        return  "\n    CONTA POUPANCA" +
                "\nNúmero: " + getNumero() +
                "\nSaldo: " + getSaldo() +
                "\nLimite: " + limite;
    }
}
