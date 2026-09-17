import java.util.Scanner;

public class CalculatorIf {

    static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int a = 0;
        int b = 0;
        int add, sub, multiply;
        float divide;

        System.out.println("--- EASY CALCULATOR (2 numbers) ---");
        System.out.println();
        System.out.println("[1] Add");
        System.out.println("[2] Subtract");
        System.out.println("[3] Multiply");
        System.out.println("[4] Divide");
        System.out.println();
        System.out.println("Select: ");

        int option = scanner.nextInt();

        System.out.println("First number: ");
        a = scanner.nextInt();
        System.out.println("Second number: ");
        b = scanner.nextInt();

        switch (option) {
            case 1:
                add = a + b;
                System.out.println("Your result is "+ add);
            break;
            case 2:
                sub = a - b;
                System.out.println("Your result is "+ sub);
            break;
            case 3:
                multiply = a * b;
                System.out.println("Your result is "+ multiply);
            break;
            case 4:
                divide = (float) a / b;
                System.out.println("Your result is "+ divide);
            break;
            default:
                System.out.println("ERROR: System Shutting Down...");
        }
    }
}
