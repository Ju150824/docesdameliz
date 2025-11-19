public class Alerta implements Observador{

    @Override
    public void atualizar(ProdutoAbstrato p) {
        public static final int min = 5;

        if (p.getQuantidade() < min) {
            System.out.println("Estoque baixo de " + p.getNome() + ": " + p.getQuantidade() + " unidades restantes!");
        }
    }
}