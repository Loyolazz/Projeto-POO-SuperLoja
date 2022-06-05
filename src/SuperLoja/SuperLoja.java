package SuperLoja;

import java.util.Scanner;
import produtos.*;

public class SuperLoja {

    public static void main(String[] args) {
        try (Scanner s = new Scanner(System.in)) {
            int options = 0;
            Carrinho c = new Carrinho();

            do {
                System.out.println("----------------------MENU----------------");
                System.out.println("1 – Adicionar produto ao carrinho");
                System.out.println("2 – Remover produto do carrinho");
                System.out.println("3 – Visualizar carrinho de compras");
                System.out.println("4 – Finalizar a compra");
                System.out.println("5 – Cancelar compra");
                System.out.println("-------------------------------------------");

                System.out.print("Qual Sua Opção: ");
                options = s.nextInt();
                switch (options) {

                    case 1:
                        int opc = 0;

                        System.out.println("1- Cadastrar Televisão ");
                        System.out.println("2- Cadastrar Brinquedo");

                        System.out.print("Digite a opção: ");
                        opc = s.nextInt();
                        if (opc == 1) {

                            System.out.print("Nome do Telvisão: ");
                            String nome = s.next();

                            System.out.println("");

                            System.out.print("Classe 1, 2 ou 3:   ");
                            int classe = s.nextInt();

                            System.out.println("");

                            System.out.print("Preço: ");
                            int custo = s.nextInt();

                            System.out.print("Insira o Id: ");

                            int codigo = s.nextInt();

                            Televisao tv = new Televisao(codigo, nome, classe);
                            tv.setCusto(custo);
                            c.incluir(tv);
                        }
                        if (opc == 2) {

                            System.out.print("Nome do Brinquedo: ");
                            String brinquedo = s.next();

                            System.out.println("");

                            System.out.print("Insira o id: ");

                            int cod = s.nextInt();

                            System.out.print("Preço: ");
                            int preco = s.nextInt();

                            Brinquedo b = new Brinquedo(cod, brinquedo);

                            b.setCusto(preco);

                            c.incluir(b);
                        }

                        break;

                    case 2:
                        int id;

                        System.out.print("Digite o Codigo do Produto: ");
                        id = s.nextInt();

                        c.remover(id);
                        break;

                    case 3:
                        c.exibirRelatorioPorNome();
                        System.out.println("\n");
                        c.exibirRelatorioPorValor();
                        System.out.println("\n");

                        break;

                    case 4:
                        c.exibirRelatorioPorNome();
                        System.out.println("\n");
                        c.exibirRelatorioPorValor();
                        System.out.println("\n");
                        System.out.println("Compra Finalizada");
                        break;

                    case 5:
                        c.cancelar();

                        System.out.print("cancela Compra");
                        break;

                }

            } while (options != 4);
        }

    }

}
