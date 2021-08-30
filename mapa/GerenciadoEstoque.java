package mapa;

import java.util.ArrayList;
import java.util.Scanner;

public class GerenciadoEstoque {
    
    private Produto produtoList[] = new Produto[100];
    private int posicaoAtual = 0;

    public static void main(String[] args) {

        GerenciadoEstoque app = new GerenciadoEstoque();
        app.cabecalho();
        app.menuPrincipal();    

        // Produto produtosList[] = new Produto[5];
        // private int posicaoAtual = 0;

        // GerenciadoEstoque app = new GerenciadoEstoque();
        // app.tituloMenu();
        // app.telaPrincipal();

        // Produto p1 = new Produto("Martelo", 10.0, "unidade", 5.00);
        // System.out.println("Produto: " + p1.getNome() + " \n" +
        //                     "Preço Unitário: " + p1.getPrecoUnitario() + " \n" +
        //                     "Unidade: " + p1.getUnidade() + " \n" +
        //                     "Quantidade em estoque: " + p1.getQuantidadeEstoque() + " \n"
        //                     );
        // produtosList[0] = p1;

        // System.out.println(produtosList[0].getNome());
        // produtosList[0].setAumentarEstoque(17.0);
        // produtosList[0].setDiminuirEstoque(10.);
        // System.out.println(produtosList[0].getQuantidadeEstoque());
    }

    private void menuPrincipal() {
        int opcao = 0;
        do {
            opcao = opcaoMenuPadrao();
            switch(opcao) {
                case 1:
                    menuCadastroProduto();
                    break;
                case 2:
                    menuMovimentacao();
                    break;
                case 3:
                    menuReajustarPreco();
                    break;
                case 4:
                    menuRelatorios();
                case 0:
                    System.out.println("Saindo do sistema");
                    break;
                default:
                    opcaoInvalida();
                    break;
            }
        } while (opcao != 0);
    }

    private int opcaoMenuPadrao() {
        int opcao;
        cabecalho();
        System.out.println("1 - Cadastro de Produtos \n"+
                            "2 - Movimentação \n" + 
                            "3 - Reajustar Preços \n" + 
                            "4 - Relatórios \n" + 
                            "0 - Finalizar \n" +
                            "Opção: _\n");
        opcao = getEscolhaMenu();
        return opcao;
    }

    private int getEscolhaMenu() {
        Scanner scanner = new Scanner(System.in);
        return Integer.parseInt(scanner.next());
    }

    private void menuRelatorios(){
        this.cabecalho();
        System.out.println("RELATÓRIO");
        for (int i = 0; i < posicaoAtual; i++) {
            System.out.println("\n");
            System.out.println("Produtos: \n" +
                    "CÓDIGO:     " + i + "\n" +
                    produtoList[i]);

        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n\n\n");
        System.out.println("APERTE QUALQUER LETRA + ENTER PARA CONTINUAR");
        scanner.next();
    }

    private void menuReajustarPreco(){
        String escolha;
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Reajustar Preço de Produto");
            System.out.println("Nome do Produto");
            String nomeProduto = scanner.nextLine();
            Produto protudoMovimentacao;
            boolean controle=true;
            for (int i = 0; i < posicaoAtual; i++) {
                if (nomeProduto.equalsIgnoreCase(produtoList[i].getNome())) {
                    controle=false;
                    protudoMovimentacao = produtoList[i];
                    System.out.println("PREÇO ATUAL : " + protudoMovimentacao.getPrecoUnitario());
                    System.out.println("NOVO PREÇO : ");
                    int novoPreco = scanner.nextInt();
                    System.out.println("PREÇO ATUALIZADO : " + (novoPreco));
                    escolha = confirmaOperacao();
                    if (escolha.equalsIgnoreCase("S")) {
                        protudoMovimentacao.setPrecoUnitario(novoPreco);
                        produtoList[i] = protudoMovimentacao;
                    }
                    break;
                }
            }
            mensagemProdutoNaoLocalizado(controle);

            escolha = getRepetirOperacao();

        } while (escolha.equalsIgnoreCase("S"));
    }

    private void menuMovimentacao(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Movimentação dos Produtos");
        System.out.println("1 - ENTRADA\n" +
                            "2 - SAÍDA\n" +
                            "0 - RETORNAR\n" +
                             "OPÇÃO  : \n");
        int opcaoMovimentacao = scanner.nextInt();
        switch (opcaoMovimentacao) {
            case 1:
                entradaProduto();
                break;
            case 2:
                saidaProduto();
                break;
            case 0:
                System.out.println("Retornando para o menu");
                break;
            default:
                opcaoInvalida();
                break;
        }
    }

    private void saidaProduto() {
        String escolha;
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Saida de Produto");
            System.out.println("Nome do Produto");
            String nomeProduto = scanner.nextLine();

            boolean controle = true;
            for (int i = 0; i < posicaoAtual; i++) {
                if (nomeProduto.equalsIgnoreCase(produtoList[i].getNome())) {
                    controle=false;
                    Produto produtoMovimentacao = produtoList[i];
                    System.out.println("QTDE INICIAL : " + produtoMovimentacao.getQuantidadeEstoque());
                    System.out.println("QTDE SAÍDA : ");
                    int quantidadeSaida = scanner.nextInt();
                    System.out.println("QTDE FINAL : " + (produtoMovimentacao.getQuantidadeEstoque() - quantidadeSaida));
                    if (produtoMovimentacao.getQuantidadeEstoque() < quantidadeSaida) {
                        System.out.println("Quantidade maior que no estoque, saída não é possível");
                        break;
                    }
                    escolha = confirmaOperacao();
                    if (escolha.equalsIgnoreCase("S")) {
                        produtoMovimentacao.setDiminuirEstoque(quantidadeSaida);
                        produtoList[i] = produtoMovimentacao;
                    }
                    break;
                }
            }
            mensagemProdutoNaoLocalizado(controle);
            escolha = getRepetirOperacao();

        } while (escolha.equalsIgnoreCase("S"));
    }

    private void entradaProduto() {
        String escolha;
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Compra de Produto");
            System.out.println("Nome do Produto");
            String nomeProduto = scanner.nextLine();
            Produto protudoMovimentacao;
            boolean controle=true;
            for (int i = 0; i < posicaoAtual; i++) {
                if (nomeProduto.equalsIgnoreCase(produtoList[i].getNome())) {
                    controle=false;
                    protudoMovimentacao = produtoList[i];
                    System.out.println("QTDE ATUAL : " + protudoMovimentacao.getQuantidadeEstoque());
                    System.out.println("QTDE ENTRADA : ");
                    int quantidadeEntrada = scanner.nextInt();
                    System.out.println("QTDE FINAL : " + (protudoMovimentacao.getQuantidadeEstoque() + quantidadeEntrada));
                    escolha = confirmaOperacao();
                    if (escolha.equalsIgnoreCase("S")) {
                        protudoMovimentacao.setAumentarEstoque(quantidadeEntrada);
                        produtoList[i] = protudoMovimentacao;
                    }
                    break;
                }
            }
            mensagemProdutoNaoLocalizado(controle);

            escolha = getRepetirOperacao();

        } while (escolha.equalsIgnoreCase("S"));
    }

    private void menuCadastroProduto() {
        int opcao;
        cabecalho();
        System.out.println("1 - Incluir\n" +
                        "2 - Alteracao\n" +
                        "3 - Consultar\n" +
                        "4 - Excluir\n" + 
                        "0 - Retornar\n");
        opcao = getEscolhaMenu();
        switch (opcao) {
            case 1:
                incluirProdutos();
                break;
            case 2:
                alterarProduto();
                break;
            case 3:
                consultarProduto();
                break;
            case 4:
                excluirProduto();
                break;
            default:
                opcaoInvalida();
                break;
        }
    }

    private void opcaoInvalida() {
        System.out.println("Opção inválida");
    }

    private void excluirProduto() {
        String escolha;
        do {
            Scanner scanner = new Scanner(System.in);
            this.cabecalho();
            System.out.println("Excluir Produto");
            System.out.println("Informe o nome do produto a ser excluido");
            String nomeConsulta = scanner.nextLine();
            boolean controle = true;
            ArrayList<Produto> arrayList = new ArrayList();
            arrayList.add(new Produto());
            for (int i = 0; i < posicaoAtual; i++) {
                scanner = new Scanner(System.in);
                Produto produto = arrayList.get(i);
                if (nomeConsulta.equalsIgnoreCase(produtoList[i].getNome())) {
                    controle=false;
                    System.out.println(produtoList[i]);
                    System.out.println("Confirmar Exclusão ( S/N ) ?");
                    escolha = scanner.next();
                    if (escolha.equalsIgnoreCase("S")) {
                        for (int j = i; j < posicaoAtual - 1; j++) {
                            produtoList[j] = produtoList[produtoList.length + 1];
                            posicaoAtual--;
                        }
                    }
                    break;
                }
            }
            mensagemProdutoNaoLocalizado(controle);
            escolha = getRepetirOperacao();

        } while (escolha.equalsIgnoreCase("S"));
    }

    private void consultarProduto() {
        String escolha;
        do {
            Scanner scanner = new Scanner(System.in);
            this.cabecalho();
            System.out.println("Consultar Produto");
            System.out.println("Informe o nome do produto a ser consultado");
            String nomeConsulta = scanner.nextLine();
            boolean controle=true;
            for (int i = 0; i < posicaoAtual; i++) {
                if (nomeConsulta.equalsIgnoreCase(produtoList[i].getNome())) {
                    controle=false;
                    System.out.println(produtoList[i]);
                    break;
                }
            }
            mensagemProdutoNaoLocalizado(controle);
            escolha = getRepetirOperacao();

        } while (escolha.equalsIgnoreCase("S"));
    }

    private void alterarProduto() {
        String escolha;
        do {
            Scanner scanner = new Scanner(System.in);
            this.cabecalho();
            System.out.println("Alteração de Produto");
            System.out.println("Informe o nome do Produto a ser alterado");
            String nomeConsutla = scanner.nextLine();
            boolean controle = true;
            for (int i = 0; i < posicaoAtual; i++){
                if (nomeConsutla.equalsIgnoreCase(produtoList[i].getNome())) {
                    controle = false;
                    System.out.println("Produto encontrado!!!\n");
                    Produto produto = setDadosProdutos();
                    escolha = confirmaOperacao();
                    if (escolha.equalsIgnoreCase("S")) {
                        produtoList[i] = produto;
                    }
                    break;
                }
            }
            mensagemProdutoNaoLocalizado(controle);
            escolha = getRepetirOperacao();
        } while (escolha.equalsIgnoreCase("S"));
    }

    private void mensagemProdutoNaoLocalizado(boolean controle) {
        if (controle) {
            System.out.println("Produto não encontrado");
        }
    }

    private void incluirProdutos() {
        String escolha;
        do {
            this.cabecalho();
            System.out.println("Cadastro de Produtos");
            Produto produto = setDadosProdutos();
            escolha = confirmaOperacao();
            if (escolha.equalsIgnoreCase("S")) {
                produtoList[posicaoAtual] = produto;
                posicaoAtual++;
            }
            escolha = getRepetirOperacao();
        } while (escolha.equalsIgnoreCase("S"));
    }

    private Produto setDadosProdutos(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe o nome do Produto");
        String nome = scanner.nextLine();
        System.out.println("Informe o preço unitário do Produto");
        scanner = new Scanner(System.in);
        int precoUnitario = scanner.nextInt();
        System.out.println("Informe a unidade de medida");
        scanner = new Scanner(System.in);
        String unidade = scanner.nextLine();
        System.out.println("Informe a quantidade");
        int quantidade = scanner.nextInt();

        Produto produto = new Produto();
        produto.setNome(nome);
        produto.setPrecoUnitario(precoUnitario);
        produto.setUnidade(unidade);
        produto.setQuantidadeEstoque(quantidade);
        return produto;
    }

    private String confirmaOperacao() {
        Scanner scanner = new Scanner(System.in);
        String escolha;
        System.out.println("Confirmar Operação ( S/N ) ?");
        escolha = scanner.nextLine();
        return escolha;
    }

    private String getRepetirOperacao() {
        Scanner scanner = new Scanner(System.in);
        String escolha;
        System.out.println("Repetir Operação ( S/N ) ? ");
        escolha = scanner.next();
        return escolha;
    }

    private void cabecalho() {
        System.out.println("EMPRESA DE IMPORTAÇÃO DE PRODUTOS LTDA \n" +
                            "SISTEMA DE CONTROLE DE ESTOQUE \n");
    }
}
