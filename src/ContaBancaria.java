public abstract class ContaBancaria implements Imprimivel{

    private final int numero;
    private double saldo = 0;

    public ContaBancaria(int numero){
        this.numero = numero;
    }

    public abstract boolean sacar(double valor);
    public abstract boolean depositar(double valor);

    public boolean trasferir(double valor, ContaBancaria conta){
        return valor > 0 && conta != this && this.sacar(valor) && conta.depositar(valor);
    }

    public double getSaldo() {
        return saldo;
    }

    public int getNumero() {
        return numero;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
