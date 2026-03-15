// O Adapter IMPLEMENTA a interface que o nosso sistema entende
public class FreteFacilAdapter implements ServicoFrete {

    // E ESCONDE a classe incompatível internamente
    private FreteFacilAPI apiIncompativel;

    public FreteFacilAdapter(FreteFacilAPI apiIncompativel) {
        this.apiIncompativel = apiIncompativel;
    }

    @Override
    public double calcularFrete(double peso) {
        // Traduz a chamada do nosso sistema (calcularFrete) para a API (calculateShipping)
        // Fornecendo os parâmetros extras que a API antiga não exigia
        return apiIncompativel.calculateShipping(peso, "SÃO PAULO - SP", "RIO DE JANEIRO - RJ");
    }
}