package projeto;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Estoque implements Serializable {
    private static final long serialVersionUID = 1L;

    private static Estoque instancia;

    private List<ProdutoAbstrato> produtos;
    private transient List<ObservadorInterface> observadores; // transient para não serializar

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

    // ===========================
    // Produtos
    // ===========================
    public void adicionarProduto(ProdutoAbstrato p) {
        produtos.add(p);
        System.out.println("Produto adicionado: " + p.getDescricao());
    }

    public void adicionarEstoque(String nome, int quantidade) {
        List<ProdutoAbstrato> encontrados = buscarProdutosPorNome(nome);
        if (encontrados.isEmpty()) {
            System.out.println("Produto não encontrado no estoque.");
            return;
        }
        ProdutoAbstrato p = escolherProduto(encontrados, "adicionar estoque");
        if (p != null) {
            p.adicionarEstoque(quantidade);
            System.out.println("Adicionado " + quantidade + " ao estoque de " + p.getDescricao());
            notificarObservadores(p);
        }
    }

    public void removerEstoque(String nome, int quantidade) {
        List<ProdutoAbstrato> encontrados = buscarProdutosPorNome(nome);
        if (encontrados.isEmpty()) {
            System.out.println("Produto não encontrado no estoque.");
            return;
        }
        ProdutoAbstrato p = escolherProduto(encontrados, "remover estoque");
        if (p != null) {
            p.tirarEstoque(quantidade);
            System.out.println("Venda registrada de " + quantidade + "x " + p.getDescricao());
            notificarObservadores(p);
        }
    }

    public void listarProdutos() {
        System.out.println("\n=== Estoque Atual ===");
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto no estoque.");
            return;
        }
        for (ProdutoAbstrato p : produtos) {
            System.out.println(p.getDescricao());
        }
        System.out.println();
    }

    private List<ProdutoAbstrato> buscarProdutosPorNome(String nome) {
        List<ProdutoAbstrato> encontrados = new ArrayList<>();
        for (ProdutoAbstrato p : produtos) {
            if (p.getNome().equalsIgnoreCase(nome)) {
                encontrados.add(p);
            }
        }
        return encontrados;
    }

    private ProdutoAbstrato escolherProduto(List<ProdutoAbstrato> encontrados, String acao) {
        if (encontrados.size() == 1) return encontrados.get(0);

        System.out.println("Existem múltiplos produtos com o nome '" + encontrados.get(0).getNome() + "':");
        for (int i = 0; i < encontrados.size(); i++) {
            System.out.println((i + 1) + " - " + encontrados.get(i).getDescricao());
        }
        System.out.println("Escolha o número do produto para " + acao + ":");

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int escolha = Integer.parseInt(reader.readLine()) - 1;
            if (escolha >= 0 && escolha < encontrados.size()) {
                return encontrados.get(escolha);
            } else {
                System.out.println("Escolha inválida. Operação cancelada.");
            }
        } catch (Exception e) {
            System.out.println("Erro na escolha. Operação cancelada.");
        }
        return null;
    }

    // ===========================
    // Observer
    // ===========================
    public void adicionarObservador(ObservadorInterface o) {
        if (observadores == null) observadores = new ArrayList<>();
        observadores.add(o);
    }

    private void notificarObservadores(ProdutoAbstrato p) {
        if (observadores == null) return;
        for (ObservadorInterface o : observadores) {
            o.atualizar(p);
        }
    }

    // ===========================
    // Salvar / Carregar estoque
    // ===========================
    public void salvarEstoque() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("estoque.dat"))) {
            out.writeObject(produtos);
            System.out.println("Estoque salvo com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao salvar estoque: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public void carregarEstoque() {
        File arquivo = new File("estoque.dat");
        if (arquivo.exists()) {
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(arquivo))) {
                produtos = (List<ProdutoAbstrato>) in.readObject();
                System.out.println("Estoque carregado com sucesso!");
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Erro ao carregar estoque: " + e.getMessage());
            }
        }
        if (observadores == null) observadores = new ArrayList<>();
    }
}
