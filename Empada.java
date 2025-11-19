public class Empada extends Produto {
    private String tipo;
    public Empada (String nome, double preco, int quantidade, String tipo) {
        super(nome, preco, quantidade);
        this.tipo = tipo;
    }
    @Override
    public String getDescricao() {
        return "Empada " + tipo + " - " + getQuantidade() + " unidades.";
    }
}

