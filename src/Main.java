public class Main {
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE E-COMMERCE (REFATORADO) ===\n");

        System.out.println("--- 1. Testando o Adapter ---");
        // O Main usa a API nova sem perceber a diferença!
        FreteFacilAPI apiNova = new FreteFacilAPI();
        ServicoFrete servicoAdapter = new FreteFacilAdapter(apiNova);
        System.out.println("Valor do Frete (Nova API via Adapter): R$ " + servicoAdapter.calcularFrete(5.0));
        System.out.println();


        System.out.println("--- 2. Testando o Facade ---");
        // O Main não sabe o que é Estoque ou Logística. Apenas aperta 1 botão.
        CheckoutFacade fachada = new CheckoutFacade();
        fachada.finalizarCompra("Notebook Dell", 5500.0, "João Silva");
        System.out.println();


        System.out.println("--- 3. Testando o Composite ---");
        Produto p1 = new Produto("Mouse", 100.0);
        Produto p2 = new Produto("Teclado", 200.0);

        Caixa caixaPequena = new Caixa();
        caixaPequena.adicionar(p1);
        caixaPequena.adicionar(p2);

        Produto p3 = new Produto("Monitor", 1000.0);

        Caixa caixaPrincipal = new Caixa();
        caixaPrincipal.adicionar(caixaPequena); // Caixa dentro de Caixa!
        caixaPrincipal.adicionar(p3); // Produto junto com Caixa!

        // Mágica do Composite: Uma única chamada resolve toda a árvore recursivamente
        System.out.println("Total exato da encomenda: R$ " + caixaPrincipal.calcularPreco());
    }
}