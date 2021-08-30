package Projeto_conta;

abstract class Conta {
    private int numero;
    private int agencia;
    private Cliente cliente;
    private double saldo=0.0;

    public Conta(int numero, int agencia, Cliente cliente) {
        this.setNumero(numero);
        this.setAgencia(agencia);
        this.setCliente(cliente);
    }

    public int getNumero() {
        return this.numero;
    }

    public int getAgencia() {
        return this.agencia;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public void setNumero(int numero){
        this.numero = numero;
    }

    public void setAgencia(int agencia){
        this.agencia = agencia;
    }

    public void setCliente(Cliente cliente){
        this.cliente = cliente;
    }

    public abstract void setSacar(double valor);

    public void setReduzirSaldo(double valor) {
        this.saldo -= valor;
    }

    public void setDepositar(double valor) {
        this.saldo += valor;
        System.out.println("Valor depositado: " + valor + "\n" + "Saldo :" + this.saldo);
    }

    public String getInformacoes() {
        return "Nº Conta: " + numero + "\nAgencia: " + agencia + "\nCliente: " + cliente.getInformacoes() + "\nSaldo: " + saldo;
    }
}
