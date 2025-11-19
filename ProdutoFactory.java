package projeto;
public class ProdutoFactory {

//Criação dos produtos ocorre aqui
    public static ProdutoAbstrato criarProduto (String tipo, String nome, double preco, int quantidade, Enum<?> detalhe) {
        switch (tipo.toLowerCase()) {
            case "trufa":
                return new Trufa(nome, preco, quantidade, (Trufa.SaborTrufa) detalhe);

            case "pudim":
                return new Pudim(nome, preco, quantidade, (Pudim.TamanhoPudim) detalhe);

            case "empada":
                return new Empada(nome, preco, quantidade, (Empada.TipoEmpada) detalhe);

            default:
                System.out.println("Tipo de produto desconhecido: " + tipo);
                return null;
        }
    }
}
