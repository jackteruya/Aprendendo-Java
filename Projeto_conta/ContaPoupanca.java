package Projeto_conta;

class ContaPoupanca extends Conta {

    public ContaPoupanca(int numero, int agencia, Cliente cliente) {
        super(numero, agencia, cliente);
    }
    
    public void setSacar(double valor) {
        double saldo = this.getSaldo();
        if(valor > saldo) {
            System.out.println("Saldo insuficiente");
        } else {
            this.setReduzirSaldo(valor);
        }
    }
}
