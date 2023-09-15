public class ContaPoupanca extends ContaBancaria{

    private double limite; //pode ficar negativo no saldo

    @Override
    public boolean sacar(double valor) {
        return false;
    }

    @Override
    public boolean depositar(double valor) {
        return false;
    }

    @Override
    public String mostrarDados() {
        return  "    CONTA POUPANCA" +
                "\nNúmero: " + getNumero() +
                "\nSaldo: " + getSaldo() +
                "\nLimite: " + limite;
    }
}
