import java.util.Scanner;

public class Gerenciador {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] produtoNome = new String[4];
        int[] produtoQuant = new int[4];

        int opcao;
        int produto;

        // Cadastro inicial dos produtos
        for (int i = 0; i < 4; i++) {
            System.out.print("Digite o nome do " + (i + 1) + " produto: ");
            produtoNome[i] = scanner.nextLine();

            System.out.print("Digite a quantidade de produtos: ");
            produtoQuant[i] = scanner.nextInt();
            scanner.nextLine();
        }

        do {

            System.out.println("\n------ MENU ------");
            System.out.println("1. Exibir Estoque");
            System.out.println("2. Adicionar Itens");
            System.out.println("3. Remover Itens");
            System.out.println("4. Sair");
            System.out.print("> ");

            opcao = scanner.nextInt();

            if (opcao == 1) {

                System.out.println();

                for (int i = 0; i < 4; i++) {
                    System.out.println(
                            "Nome: " + produtoNome[i] +
                                    " | Quantidade: " + produtoQuant[i]
                    );
                }

            } else if (opcao == 2) {

                System.out.print("\nEscolha um produto de 1 a 4\n> ");
                produto = scanner.nextInt();

                System.out.println(
                        "\n" + produtoNome[produto - 1] + " selecionado!"
                );

                System.out.print("Quantas unidades deseja adicionar?\n> ");

                int add = scanner.nextInt();

                produtoQuant[produto - 1] += add;

                System.out.println(
                        "Novo estoque de " +
                                produtoNome[produto - 1] +
                                ": " +
                                produtoQuant[produto - 1]
                );

            } else if (opcao == 3) {

                System.out.print("\nEscolha um produto de 1 a 4\n> ");
                produto = scanner.nextInt();

                System.out.println(
                        "\n" + produtoNome[produto - 1] + " selecionado!"
                );

                System.out.print("Quantas unidades deseja remover?\n> ");

                int remove = scanner.nextInt();

                if (remove >= produtoQuant[produto - 1]) {

                    System.out.println(
                            "\nERRO - Quantidade insuficiente no estoque."
                    );

                } else {

                    produtoQuant[produto - 1] -= remove;

                    System.out.println(
                            "\nNovo estoque de " +
                                    produtoNome[produto - 1] +
                                    ": " +
                                    produtoQuant[produto - 1]
                    );
                }

            } else if (opcao == 4) {

                System.out.println("Saindo...");

            } else {

                System.out.println("\nOpcao invalida!");

            }

        } while (opcao != 4);

        scanner.close();
    }
}