public class CorreiosLegado implements ServicoFrete {
    @Override
    public double calcularFrete(double peso) {
        return peso * 10.0;
    }
}