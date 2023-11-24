import java.util.ArrayList;
import java.util.List;

public class Estoque {
    private List<Item> itens;

    public Estoque() {
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(Item item) {
        itens.add(item);
    }

    public void removerItem(int codigo) {
        Item itemRemover = buscarItemPorCodigo(codigo);
        if (itemRemover != null) {
            itens.remove(itemRemover);
        }
    }

    public void atualizarQuantidade(int codigo, int novaQuantidade) {
        Item item = buscarItemPorCodigo(codigo);
        if (item != null) {
            item.setQuantidade(novaQuantidade);
        }
    }

    public List<Item> listarItens() {
        return itens;
    }

    public Item buscarItemPorCodigo(int codigo) {
        for (Item item : itens) {
            if (item.getCodigo() == codigo) {
                return item;
            }
        }
        return null;
    }
}