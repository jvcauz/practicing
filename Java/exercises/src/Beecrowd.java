import java.io.IOException;
import java.util.Scanner;
import java.util.Locale;

/**
 * IMPORTANT:
 *      O nome da classe deve ser "Main" para que a sua solução execute
 *      Class name must be "Main" for your solution to execute
 *      El nombre de la clase debe ser "Main" para que su solución ejecutar
 */
public class Beecrowd {

    public static void main(String[] args) throws IOException {

        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        double A = scanner.nextDouble();
        double B = scanner.nextDouble();

        double MEDIA = (A * 3.5 + B * 7.5) / 11.0;

        System.out.printf("MEDIA = %.5f\n", MEDIA);

        scanner.close();

    }
}