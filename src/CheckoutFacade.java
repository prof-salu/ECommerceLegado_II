public class CheckoutFacade {
    private Estoque estoque;
    private Pagamento pagamento;
    private Logistica logistica;
    private Email email;

    public CheckoutFacade() {
        this.estoque = new Estoque();
        this.pagamento = new Pagamento();
        this.logistica = new Logistica();
        this.email = new Email();
    }

    // Um único método simples que orquestra todo o trabalho sujo
    public void finalizarCompra(String item, double valor, String cliente) {
        System.out.println("--- Iniciando Checkout via Facade ---");
        estoque.baixarEstoque(item);
        pagamento.cobrar(valor);
        logistica.solicitarColeta(item);
        email.enviarRecibo(cliente);
        System.out.println("--- Checkout Concluído com Sucesso ---");
    }
}