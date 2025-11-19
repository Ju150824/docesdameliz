public class AlertaEstoque implements Observador{
    @Override
    public void atualizar(Produto p) {
        if (p.getQuantidade() < 5) {
            System.out.println("Estoque baixo de " + p.getNome() + ": " + p.getQuantidade() + " unidades restantes!");
        }
    }
}