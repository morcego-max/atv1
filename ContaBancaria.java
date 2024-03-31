import java.util.Scanner;

public class ContaBancaria {

    int numeroConta;
    String nomeTitular;
    double saldo;

    public ContaBancaria(int numeroConta, String nomeTitular, double saldoInicial) {
        this.numeroConta = numeroConta;
        this.nomeTitular = nomeTitular;
        this.saldo = saldoInicial;
    }

    public void depositar(double valor) {
        saldo += valor;
        System.out.println("Depósito de R$" + valor + " realizado com sucesso.");
    }

    public void sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
            System.out.println("Saque de R$" + valor + " realizado com sucesso.");
        } else {
            System.out.println("Saldo insuficiente para realizar o saque.");
        }
    }
    public double consultarSaldo() {
        return saldo;
    }

    public static void main(String[] args) {
        double deposit, saque;
        int escolha = 0;
        Scanner scan = new Scanner(System.in);
        ContaBancaria minhaConta = new ContaBancaria(123456, "João Silva", 0);

        while (escolha !=3) {
        System.out.println("o que deseja fazer?");
        System.out.println("[1] depositar\n[2] sacar\n[3] sair");
        escolha = scan.nextInt();
        switch (escolha) {
            case 1:
             System.out.println("qual valor deseja depositar?");
             deposit = scan.nextDouble();
             minhaConta.depositar(deposit);

             break;
             case 2:
             System.out.println("qual valor deseja sacar?");
             saque = scan.nextDouble();
             minhaConta.sacar(saque);
            break;
        }
        }
        double saldoAtual = minhaConta.consultarSaldo();
        System.out.println("Saldo atual: R$" + saldoAtual);
    }
}
