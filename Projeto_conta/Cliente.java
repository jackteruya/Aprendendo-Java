package Projeto_conta;

public class Cliente {
    private String nome;
    private String cpf;

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getName() {
        return this.nome;
    }

    public String getCpf() {
        return this.cpf;
    }

    public String getInformacoes() {
        return "Nome: " + this.nome + " CPF: " + this.cpf;
    }
}
