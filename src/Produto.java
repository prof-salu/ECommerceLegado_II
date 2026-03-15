public class Produto implements ComponenteLogistica{
    private String nome;
    private double preco;

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    @Override
    public double calcularPreco() {
        return preco; // A folha apenas retorna o seu valor
    }
}