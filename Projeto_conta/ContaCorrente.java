package Projeto_conta;

class ContaCorrente extends Conta {
    private double taxa=0.10;
    
    public ContaCorrente(int numero, int agencia, Cliente cliente) {
        super(numero, agencia, cliente);
    }


    public double getTaxa() {
        return this.taxa;
    }
    
    public void setSacar(double valor) {
        double saldo = this.getSaldo();
        valor = valor + this.getTaxa();
        if(valor > saldo) {
            System.out.println("Saldo insuficiente");
        } else {
            this.setReduzirSaldo(valor);
        }
    }
}