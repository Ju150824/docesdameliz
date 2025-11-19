public abstract class ProdutoAbstrato {
    private String nome;
    private double preco;
    private int quantidade;

    public Produto (String nome, double preco, int quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }
    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

//add e tirar de quantidade
    public void adicionarEstoque(int quant) {
        this.quantidade += quant;
    }
    public void tirarEstoque(int quant) {
        if (this.quantidade >= quant) {
            this.quantidade -= quant;
        }
        else {
            System.out.println("quantidade insuficiente do produto:" +nome);
        }
    }
// metodo abstrato de add descricao

    public abstract String getDescricao();
    @Override
    public String toString() {
        return "Nome: " + nome + ", Preço: R$" + preco + ", Quantidade: " + quantidade;

}