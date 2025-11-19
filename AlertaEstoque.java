package projeto;

public class AlertaEstoque implements ObservadorInterface {

    public static final int ESTOQUE_MINIMO = 5;

    @Override
    public void atualizar(ProdutoAbstrato p) {
        if (p.getQuantidade() < ESTOQUE_MINIMO) {
            System.out.println(
                    "⚠ Estoque baixo de " + p.getNome() +
                            ": " + p.getQuantidade() + " unidades."
            );
        }
    }
}
