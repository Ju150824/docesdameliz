package projeto;
public class Trufa extends ProdutoAbstrato {

    public enum SaborTrufa { morango, chocolate, limão, ninho}
    private SaborTrufa sabor;


    public Trufa(String nome, double preco, int quantidade, SaborTrufa sabor) {
        super(nome, preco, quantidade);
        this.sabor = sabor;
    }
    public SaborTrufa getSabor() {
        return sabor;
    }
    @Override
    public String getDescricao() {
        return "Trufa sabor:" + sabor + " = " + getQuantidade() + " unidades.";
    }
}