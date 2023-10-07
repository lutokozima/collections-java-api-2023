package DesafioPoo;
import java.text.DecimalFormat;
import java.util.Scanner;

public class DesafioHeranca {

    public static void main(String[] args) {

        //System.out.println("Inicio");
        // Lendo os dados de Entrada:

    Scanner scanner = new Scanner(System.in);
    //scanner.nextLine(); // Consome a quebra de linha após a entrada do número da conta
    String titular = scanner.next();
        //System.out.println(titular);
    int numeroConta = scanner.nextInt();
       // System.out.println(numeroConta);
    double saldo = scanner.nextDouble();
        //System.out.println(saldo);
    double taxaJuros = scanner.nextDouble();
        //System.out.println(taxaJuros);

        //ContaBancaria conta = new ContaBancaria(numeroConta,titular,saldo);
        //conta.exibirInformacoes();

        ContaPoupanca contaPoupanca = new ContaPoupanca(numeroConta, titular, saldo, taxaJuros);


       //, titular, saldo, taxaJuros);
       System.out.println("Conta Poupanca:");
       contaPoupanca.exibirInformacoes();

        // scanner.close();
    }
}

class ContaBancaria {
    protected int numero;
    protected String titular;
    protected double saldo;

    public ContaBancaria(int numero, String titular, double saldo) {
        this.numero = numero;
        this.titular = titular;
        this.saldo = saldo;
    }

    public void exibirInformacoes() {
        DecimalFormat decimalFormat = new DecimalFormat("#.0");
        System.out.println(titular);
        System.out.println(numero);
        System.out.println("Saldo: R$ " + decimalFormat.format(saldo));
    }
}

class ContaPoupanca extends ContaBancaria {
    private double taxaJuros;

    public ContaPoupanca(int numero, String titular, double saldo, double taxaJuros) {
        //TODO: Implementar adequadamente esta sobrecarga de construtores.
        super(numero, titular, saldo);
        this.taxaJuros = taxaJuros;
    }

    public double getTaxaJuros() {
        return taxaJuros;
    }

    public void setTaxaJuros(double taxaJuros) {
        this.taxaJuros = taxaJuros;
    }



    public void exibirInformacoes() {
        //super.exibirInformacoes();
        //TODO: Complementar as informações com a taxa de juros.

        super.exibirInformacoes();
        System.out.println("Taxa de juros: "+ taxaJuros + "%");
    }


}