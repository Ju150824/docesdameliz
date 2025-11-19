package projeto;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Estoque estoque = Estoque.getInstance();
        estoque.adicionarObservador(new AlertaEstoque());

        Scanner sc = new Scanner(System.in);
        int op;

        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1 - Cadastrar produto");
            System.out.println("2 - Adicionar estoque");
            System.out.println("3 - Registrar venda");
            System.out.println("4 - Listar estoque");
            System.out.println("5 - Sair");
            System.out.print("Opção: ");

            op = sc.nextInt();
            sc.nextLine();

            switch (op) {

                case 1:
                    System.out.print("Tipo (trufa/pudim/empada): ");
                    String tipo = sc.nextLine();

                    System.out.print("Nome: ");
                    String nome = sc.nextLine();

                    System.out.print("Preço: ");
                    double preco = sc.nextDouble();

                    System.out.print("Quantidade: ");
                    int qtd = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Detalhe (EXATAMENTE como enum): ");
                    String det = sc.nextLine();

                    ProdutoAbstrato p = ProdutoFactory.criarProduto(
                            tipo, nome, preco, qtd, det
                    );

                    if (p != null) estoque.adicionarProduto(p);
                    break;

                case 2:
                    System.out.print("Nome do produto: ");
                    String prodAdd = sc.nextLine();

                    System.out.print("Quantidade: ");
                    int add = sc.nextInt();

                    estoque.adicionarEstoque(prodAdd, add);
                    break;

                case 3:
                    System.out.print("Nome do produto: ");
                    String prodV = sc.nextLine();

                    System.out.print("Quantidade vendida: ");
                    int vend = sc.nextInt();

                    estoque.removerEstoque(prodV, vend);
                    break;

                case 4:
                    estoque.listarProdutos();
                    break;

                case 5:
                    System.out.println("Encerrando...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } while (op != 5);

        sc.close();
    }
}
