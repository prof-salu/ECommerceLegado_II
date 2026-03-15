import java.util.ArrayList;
import java.util.List;

public class Caixa implements ComponenteLogistica {
    // Agora a caixa guarda Componentes, que podem ser tanto Produtos quanto outras Caixas!
    private List<ComponenteLogistica> itens = new ArrayList<>();

    public void adicionar(ComponenteLogistica item) {
        itens.add(item);
    }

    @Override
    public double calcularPreco() {
        double total = 0;
        // Recursão elegante: delega o cálculo para os filhos
        for (ComponenteLogistica item : itens) {
            total += item.calcularPreco();
        }
        return total;
    }
}