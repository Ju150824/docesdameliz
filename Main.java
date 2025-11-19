public class Main {

    public static void main(String[] args) {
        Estoque estoque = Estoque.getInstance();
        estoque.adicionarObservador(new AlertaEstoque());
        ProdutoAbstrato empada = ProdutoFactory.criarProduto("empada","empada de frango", 3, 20, "salgada");
        estoque.adicionarProduto(empada);
        estoque.removerEstoque("empada de frango", 18);
        estoque.listarProdutos();
    }
}