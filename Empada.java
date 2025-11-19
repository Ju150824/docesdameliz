package projeto;
public class Empada extends ProdutoAbstrato  {

    public enum TipoEmpada { Doce, Salgada }
    private TipoEmpada tipo;
    public Empada (String nome, double preco, int quantidade, TipoEmpada tipo) {
        super(nome, preco, quantidade);
        this.tipo = tipo;
    }
    @Override
    public String getDescricao() {
        return "Empada " + tipo + " - " + getQuantidade() + " unidades.";
    }
}

