package projeto;
public class Pudim extends ProdutoAbstrato {
    public enum TamanhoPudim { tradicional, grande}

    private TamanhoPudim tamanho;

    public Pudim(String nome, double preco, int quantidade, TamanhoPudim tamanho) {
        super(nome, preco, quantidade);
        this.tamanho = tamanho;
    }

    @Override
    public String getDescricao() {
        return "Pudim " + tamanho + " - " + getQuantidade() + " unidades.";
    }
}
