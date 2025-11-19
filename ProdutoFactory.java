
public class ProdutoFactory {

    public static ProdutoAbstrato criarProduto(String tipo, String nome, double preco, int quantidade, String detalhe) {
        switch (tipo.toLowerCase()) {
            case "trufa":
                return new Trufa(nome, preco, quantidade, detalhe);
                case "pudim":
                    return new Pudim(nome, preco, quantidade, detalhe);
                case "empada":
                    return new Empada(nome, preco, quantidade, detalhe);
                default:
                    System.out.println(" Tipo de produto desconhecido: " + tipo);
                    return null;

            }

        }

    }


}
