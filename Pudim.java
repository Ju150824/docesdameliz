public class Pudim extends Produto{
    private String tamanho;
    public Pudim(String nome, double preco, int quantidade, String tamanho) {
        super(nome, preco, quantidade);
        this.tamanho = tamanho;
    }
    public Pudim(String nome, double preco, int quantidade) {
        super(nome, preco, quantidade);
        this.tamanho = "Tradicional";
    }
    @Override
    public String getDescricao() {
        return "Pudim " + tamanho + " - " + getQuantidade() + " unidades.";
    }
}
