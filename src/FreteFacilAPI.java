public class FreteFacilAPI {
    // ERRO: O método está em inglês, recebe parâmetros diferentes e não implementa ServicoFrete!
    public double calculateShipping(double weight, String origin, String destination) {
        System.out.println("[FreteFacil API] Calculando rota de " + origin + " para " + destination);
        return weight * 5.0; // É mais barato, mas difícil de plugar no sistema antigo
    }
}