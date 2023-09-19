import java.util.ArrayList;

public class Banco implements Imprimivel{

    ArrayList<ContaBancaria> contas = new ArrayList<>();

    public boolean inserirConta(ContaBancaria conta){
        for(ContaBancaria contaFor : contas){
            if (contaFor.getNumero() == conta.getNumero()){
                return false;
            }
        }
        if(contas.add(conta)){
            return true;
        }
        return false;
    }

    public boolean removerConta(ContaBancaria conta){
        for (ContaBancaria contaFor : contas){
            if(conta == contaFor){
                if(contas.remove(conta)){
                    return true;
                }
            }
        }
        return false;
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
        for (ContaBancaria contaBancaria : contas){
            dados += contaBancaria.mostrarDados();
        }
        return dados;
    }
}
