public class Main {
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE E-COMMERCE (ESTRUTURAL) ===\n");

        // ------------------------------------------------------------------------
        // LABORATÓRIO 1: O Problema do Adapter
        // Queremos usar a FreteFacilAPI, mas o nosso sistema espera um ServicoFrete.
        // ------------------------------------------------------------------------
        System.out.println("--- 1. Calculando Frete ---");
        ServicoFrete servico = new CorreiosLegado(); // Como trocar para FreteFacilAPI sem quebrar tudo?
        double valorFrete = servico.calcularFrete(5.0);
        System.out.println("Valor do Frete: R$ " + valorFrete);
        System.out.println();


        // ------------------------------------------------------------------------
        // LABORATÓRIO 2: O Problema do Facade
        // O Main (Cliente) precisa saber orquestrar todo o processo de venda.
        // Se a ordem mudar, o programador quebra o sistema.
        // ------------------------------------------------------------------------
        System.out.println("--- 2. Finalizando Compra ---");
        String itemComprado = "Notebook Dell";
        double valorCompra = 5500.0;
        String cliente = "João Silva";

        // Alto acoplamento com 4 classes diferentes!
        Estoque estoque = new Estoque();
        Pagamento pagamento = new Pagamento();
        Logistica logistica = new Logistica();
        Email email = new Email();

        estoque.baixarEstoque(itemComprado);
        pagamento.cobrar(valorCompra);
        logistica.solicitarColeta(itemComprado);
        email.enviarRecibo(cliente);
        System.out.println();


        // ------------------------------------------------------------------------
        // LABORATÓRIO 3: O Problema do Composite
        // O pesadelo dos 'instanceof'. Calcular o preço de caixas aninhadas.
        // ------------------------------------------------------------------------
        System.out.println("--- 3. Despachando Encomenda ---");
        Produto p1 = new Produto("Mouse", 100.0);
        Produto p2 = new Produto("Teclado", 200.0);

        Caixa caixaPequena = new Caixa();
        caixaPequena.adicionar(p1);
        caixaPequena.adicionar(p2);

        Produto p3 = new Produto("Monitor", 1000.0);

        Caixa caixaPrincipal = new Caixa();
        caixaPrincipal.adicionar(caixaPequena);
        caixaPrincipal.adicionar(p3);

        // Lógica horrível para calcular o preço:
        double totalCaixa = 0;
        for (Object obj : caixaPrincipal.getItens()) {
            if (obj instanceof Produto) {
                totalCaixa += ((Produto) obj).getPreco();
            } else if (obj instanceof Caixa) {
                // Teria que fazer outro laço for aqui dentro para ler a caixa pequena!
                // Código quebrado por natureza.
                System.out.println("Achei uma caixa pequena, não sei calcular o que tem dentro!");
            }
        }
        System.out.println("Total calculado errado: R$ " + totalCaixa);
    }
}