import java.util.Scanner;

public class Calculate {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int operation = 0;

        while(operation < 5){
            System.out.println("--- CALCULE DOIS NUMEROS INTEIROS ---");

            System.out.println();

            System.out.println("Escolha a operação: ");
            System.out.println("[1] Somar");
            System.out.println("[2] Subtrair");
            System.out.println("[3] Multiplicar");
            System.out.println("[4] Dividir");
            System.out.println("[5] Encerrar programa");

            operation = scanner.nextInt();

            if(operation == 1){

                System.out.println("Escolha o primeiro número:");

                int x = scanner.nextInt();

                System.out.println("Escolha o segundo número:");

                int y = scanner.nextInt();

                sum(x, y);
            } else if (operation == 2) {

                System.out.println("Escolha o primeiro número:");

                int x = scanner.nextInt();

                System.out.println("Escolha o segundo número:");

                int y = scanner.nextInt();

                minus(x, y);
            } else if (operation == 3) {

                System.out.println("Escolha o primeiro número:");

                int x = scanner.nextInt();

                System.out.println("Escolha o segundo número:");

                int y = scanner.nextInt();

                multiply(x, y);
            } else if (operation == 4){

                System.out.println("Escolha o primeiro número:");

                int x = scanner.nextInt();

                System.out.println("Escolha o segundo número:");

                int y = scanner.nextInt();

                divide(x, y);
            } else if (operation == 5){
                System.out.println("Encerrando...");
            } else {
                System.out.println("Opcao invalida!");
            }
        }
    }

    static void sum(int x, int y){
        System.out.print("Seu resultado é ");
        System.out.println(x + y);
        System.out.println();
    }

    static void minus(int x, int y){
        System.out.print("Seu resultado é ");
        System.out.println(x - y);
        System.out.println();
    }

    static void multiply(int x, int y){
        System.out.print("Seu resultado é ");
        System.out.println(x * y);
        System.out.println();
    }

    static void divide(int x, int y){

        if(x % y == 0){
            System.out.print("Seu resultado é ");
            System.out.println(x / y);
            System.out.println();
        } else {
            System.out.print("Seu resultado é ");
            System.out.println(x / y);
            System.out.print("com resto ");
            System.out.println(x % y);
            System.out.println();
        }
    }
}
