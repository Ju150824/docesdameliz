package projeto;

import java.util.ArrayList;
import java.util.List;

public class Estoque {
    private static Estoque instancia;
    private List<ProdutoAbstrato> produtos;
    private List<ObservadorInterface> observadores;

    private Estoque() {
        produtos = new ArrayList<>();
        observadores = new ArrayList<>();
    }

    public static Estoque getInstance() {
        if (instancia == null) {
            instancia = new Estoque();
        }
        return instancia;
    }

    public void adicionarProduto(ProdutoAbstrato p) {
        produtos.add(p);
        System.out.println(" Produto adicionado: " + p.getNome());
    }

    public void adicionarEstoque(String nome, int quantidade) {
        for (ProdutoAbstrato p : produtos) {
            if (p.getNome().equalsIgnoreCase(nome)) {
                p.adicionarEstoque(quantidade);
                System.out.println("Adicionado " + quantidade + " ao estoque de " + nome);
                notificarObservadores(p);
                return;
            }
        }
        System.out.println(" Produto não encontrado no estoque.");
    }

    public void removerEstoque(String nome, int quantidade) {
        for (ProdutoAbstrato p : produtos) {
            if (p.getNome().equalsIgnoreCase(nome)) {
                p.tirarEstoque(quantidade);
                System.out.println(" Venda registrada de " + quantidade + "x " + nome);
                notificarObservadores(p);
                return;
            }
        }
        System.out.println(" Produto não encontrado no estoque.");
    }

    public void listarProdutos() {
        System.out.println("\nEstoque Atual");
        for (ProdutoAbstrato p : produtos) {
            System.out.println(p);
        }
        System.out.println("\n");
    }

    public void adicionarObservador(ObservadorInterface o) {
        observadores.add(o);
    }

    private void notificarObservadores(ProdutoAbstrato p) {
        for (ObservadorInterface o : observadores) {
            o.atualizar(p);
        }
    }
}
