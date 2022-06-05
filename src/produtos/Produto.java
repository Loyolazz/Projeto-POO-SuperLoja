package produtos;

import java.text.DecimalFormat;

public abstract class Produto {

    static int codigo;
    private String nome;
    private Double preco;
    private Double imposto;
    private String descricao;
    public static double totalImpostoValor;
    public static double totalValor;

    public Produto(int codigo, String nome) {
        Produto.codigo = codigo;
        this.nome = nome;
    }

    static DecimalFormat deci = new DecimalFormat("0.00");

    public abstract void setCusto(int custo);

    public abstract double calcImposto(double precoFinal);

    public void exibe() {
        System.out.println(codigo + " | " + nome + " | " + descricao + " | " + deci.format(preco) + " | " + deci.format(imposto));
        Produto.setTotalImpostoValor(imposto);
        Produto.setTotalValor(preco);
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Double getImposto() {
        return imposto;
    }

    public void setImposto(double imposto) {
        this.imposto = imposto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public static void setTotalImpostoValor(double totalImpostoValor) {
        Produto.totalImpostoValor += totalImpostoValor;
    }

    public static void setTotalValor(double totalValor) {
        Produto.totalValor += totalValor;
    }

    public static String getTotalImpostoPorcentagem() {
        return deci.format((Produto.totalImpostoValor * 100) / Produto.totalValor);
    }

    public static String getTotalImpostoValor() {
        return deci.format(Produto.totalImpostoValor);
    }

    public static String getTotalValor() {
        return deci.format(Produto.totalValor);
    }
}
