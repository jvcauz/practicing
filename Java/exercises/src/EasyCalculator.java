import java.util.Scanner;

public class EasyCalculator {

    static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String i = "y";

        while(i.equals("y")){

            System.out.println("Type in the operation (plus or +, minus or -, multiply or *, divide or /)");
            String operation = scanner.next();

            System.out.println("First number: ");
            int x = scanner.nextInt();

            System.out.println("Second number: ");
            int y = scanner.nextInt();

            operationLogic(operation, x, y);

            System.out.println("Continue? y/n");
            i = scanner.next();
        }
    }

    private static void operationLogic(String operation, int x, int y) {
        switch (operation) {
            case "plus", "+":
                System.out.println("Result: "+ x + " + " + y + " = " + sum(x, y));
                break;
            case "minus", "-":
                System.out.println("Result: "+ x + " - " + y + " = " + minus(x, y));
                break;
            case "multiply", "*":
                System.out.println("Result: "+ x + " * " + y + " = " + multiply(x, y));
                break;
            case "divide", "/":
                System.out.println("Result: "+ x + " / " + y + " = " + divide(x, y));
                break;
        }
    }

    public static int sum(int x, int y) {
        return x + y;
    }

    public static int minus(int x, int y) {
        return x - y;
    }

    public static int multiply(int x, int y) {
        return x * y;
    }

    public static float divide(float x, float y) {
        return x / y;
    }

}
