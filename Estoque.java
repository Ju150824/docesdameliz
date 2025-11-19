import java.util.ArrayList;
import java.util.List;

public class Estoque {

    public static final int ESTOQUE_MINIMO = 5;

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

    public void adicionarObservador(ObservadorInterface o) {
        observadores.add(o);
    }

    private void notificar(ProdutoAbstrato p) {
        for (ObservadorInterface o : observadores) {
            o.atualizar(p);
        }
    }

    public void adicionarProduto(ProdutoAbstrato p) {
        produtos.add(p);
        notificar(p);
    }

    public void adicionarEstoque(String nome, int qtd) {
        for (ProdutoAbstrato p : produtos) {
            if (p.getNome().equalsIgnoreCase(nome)) {
                p.adicionarEstoque(qtd);
                notificar(p);
                return;
            }
        }
        System.out.println("Produto não encontrado.");
    }

    public void removerEstoque(String nome, int qtd) {
        for (ProdutoAbstrato p : produtos) {
            if (p.getNome().equalsIgnoreCase(nome)) {
                p.tirarEstoque(qtd);
                notificar(p);
                return;
            }
        }
        System.out.println("Produto não encontrado.");
    }

    public void listarProdutos() {
        System.out.println("\n--- Estoque Atual ---");
        for (ProdutoAbstrato p : produtos) {
            System.out.println(p);
        }
        System.out.println("----------------------\n");
    }
}
