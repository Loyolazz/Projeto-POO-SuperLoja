package produtos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.*;

public class Carrinho {

    private HashMap<Integer, Produto> produtos;

    public Carrinho() {
        produtos = new HashMap<>();
    }

    public boolean incluir(Produto p) {
        if (produtos.containsKey(p.getCodigo())) {
            return false;
        }

        produtos.put(p.getCodigo(), p);
        return true;
    }

    public void remover(int id) {
        if (Produto.codigo == id) {
            produtos.remove(id);
        } else {
            System.out.println("Codigo Errado");
        }

    }

    public Produto getProduto(String id) {
        return produtos.get(id);
    }

    public void exibirRelatorioPorNome() {
        Produto.totalImpostoValor = 0;
        Produto.totalValor = 0;

        List<Produto> prods = new ArrayList<>(produtos.values());
        Collections.sort(prods, Comparator.comparing(Produto::getNome));

        System.out.println("-----------------------------------");
        System.out.println("ID | Nome | Descrição | Preço | Imposto");
        System.out.println("-----------------------------------");
        for (Produto pt : prods) {
            pt.exibe();
        }
        System.out.println("-----------------------------------");
        System.out.println("Imposto Total: " + Produto.getTotalImpostoValor() + " (" + Produto.getTotalImpostoPorcentagem() + "%)");
        System.out.println("Valor Total: " + Produto.getTotalValor());
        System.out.println("-----------------------------------");
    }

    public void exibirRelatorioPorValor() {
        Produto.totalImpostoValor = 0;
        Produto.totalValor = 0;

        List<Produto> prods = new ArrayList<>(produtos.values());
        Collections.sort(prods, Comparator.comparing(Produto::getPreco));

        Collections.sort(prods, new Comparator<Produto>() {
            @Override
            public int compare(Produto a, Produto b) {
                return b.getPreco().compareTo(a.getPreco());
            }
        });

        System.out.println("-----------------------------------");
        System.out.println("ID | Nome | Descrição | Preço | Imposto");
        System.out.println("-----------------------------------");
        for (Produto pt : prods) {
            pt.exibe();
        }
        System.out.println("-----------------------------------");
        System.out.println("Imposto Total: " + Produto.getTotalImpostoValor() + " (" + Produto.getTotalImpostoPorcentagem() + "%)");
        System.out.println("Valor Total: " + Produto.getTotalValor());
        System.out.println("-----------------------------------");
    }

    public void cancelar() {

        produtos.clear();

    }

}
