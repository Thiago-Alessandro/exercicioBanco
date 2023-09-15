public abstract class ContaBancaria implements Imprimivel{

    private int numero;
    private double saldo = 0;

    public abstract boolean sacar(double valor);
    public abstract boolean depositar(double valor);

    public double getSaldo() {
        return saldo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
