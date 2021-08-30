package mapa;

public class Produto {
    private String nome;
    private int precoUnitario;
    private String unidade;
    private int quantidadeEstoque;

    public Produto(){}

    public Produto(String nome, int precoUnitario, String unidade, int quantidadeEstoque) {
        this.nome = nome;
        this.precoUnitario = precoUnitario;
        this.unidade = unidade;
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public String getNome(){
        return this.nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public int getPrecoUnitario(){
        return this.precoUnitario;
    }

    public void setPrecoUnitario(int precoUnitario){
        if (precoUnitario < 0){
            System.out.println("Valor menor que 0 (Zero).");
        }
        this.precoUnitario = precoUnitario;
    }
    
    public String getUnidade(){
        return this.unidade;
    }

    public void setUnidade(String unidade){
        this.unidade = unidade;
    }

    public int getQuantidadeEstoque(){
        return this.quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque){
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public void setAumentarEstoque(int quantidade){
        this.quantidadeEstoque += quantidade;
    }

    public void setDiminuirEstoque(int quantidade){
        if (quantidade > this.quantidadeEstoque){
            System.out.println("Quantidade maior que estoque atual.");
        }
        this.quantidadeEstoque -= quantidade;        
    }

    @Override
    public String toString() {
        return "NOME:       " + nome + "\n" +
                "PREÇO:      " + precoUnitario + "\n" +
                "UNIDADE:    " + unidade + "\n" +
                "QUANTIDADE: " + quantidadeEstoque;
    }
}
