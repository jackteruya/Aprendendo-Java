package Projeto_conta;



public class Principal {
    
    public static void main(String args[]) {

        // Cliente 01 usando conta poupança
        Cliente clinete01 = new Cliente("Joao Campos", "016.231.555-17");

        System.out.println(clinete01.getInformacoes());

        System.out.println("###################\n");

        Conta poup01 = new ContaPoupanca(123, 0001, clinete01);

        poup01.setDepositar(500.25);
        System.out.println(poup01.getSaldo());
        poup01.setSacar(500.26);
        System.out.println(poup01.getSaldo());
        poup01.setSacar(200.20);

        System.out.println("###################");
        System.out.println("###################\n\n");

        // Cliente 02 usando conta corrente
        Cliente clinete02 = new Cliente("Pedro Alvares", "017.231.777-10");

        System.out.println(clinete02.getInformacoes());

        Conta corrente01 = new ContaCorrente(064132, 0051, clinete02);

        corrente01.setDepositar(900.25);
        System.out.println("\n");
        System.out.println(corrente01.getSaldo());
        System.out.println("\n");
        corrente01.setSacar(900.16);
        System.out.println(corrente01.getSaldo());
        corrente01.setSacar(900.15);
        System.out.println(corrente01.getSaldo());
        corrente01.setDepositar(500.00);
        System.out.println(corrente01.getInformacoes());

        System.out.println("###################");
        System.out.println("###################\n\n");

        System.out.println(poup01.getInformacoes());
        System.out.println("###################");
        System.out.println(corrente01.getInformacoes());

    }
}
