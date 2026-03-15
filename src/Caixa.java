import java.util.ArrayList;
import java.util.List;

public class Caixa {
    // ERRO: A caixa precisa saber diferenciar o que é Produto e o que é outra Caixa.
    // Isso gera um código recursivo feio e cheio de ifs.
    private List<Object> itens = new ArrayList<>();

    public void adicionar(Object item) {
        itens.add(item);
    }

    public List<Object> getItens() {
        return itens;
    }
}