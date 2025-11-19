public class Trufa extends Produto{
    private String sabor;
    public Trufa(String nome, double preco, int quantidade, String sabor) {
        super(nome, preco, quantidade);
        this.sabor = sabor;
    }
    @Override
    public String getDescricao() {
        return "Trufa sabor:" + sabor + " = " + getQuantidade() + " unidades.";
    }
}