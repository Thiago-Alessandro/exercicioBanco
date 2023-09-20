import java.util.ArrayList;

public class Banco implements Imprimivel{

    private final ArrayList<ContaBancaria> contas = new ArrayList<>();

    public boolean inserirConta(ContaBancaria conta){
        for(ContaBancaria contaFor : contas){
            if (contaFor.getNumero() == conta.getNumero()){
                return false;
            }
        }
        return contas.add(conta);
    }

    public boolean removerConta(ContaBancaria conta){
        return contas.remove(conta);
    }

    public ContaBancaria procurarConta(int numeroConta){
        for (ContaBancaria conta : contas){
            if(conta.getNumero() == numeroConta){
                return conta;
            }
        }
        return null;
    }

    @Override
    public String mostrarDados() {
        String dados = "";
        Relatorio relatorio = new Relatorio();
        for (ContaBancaria contaBancaria : contas){
            dados += relatorio.gerarRelatorio(contaBancaria);
        }
        return dados;
    }
}
