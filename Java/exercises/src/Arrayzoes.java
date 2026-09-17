import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class Arrayzoes {

    static void main(String[] args) {

        int[] numbers = new int[5];
        numbers[0] = 5;
        numbers[1] = 42;
        numbers[2] = 9;
        numbers[3] = 12;
        numbers[4] = 3;

        int[] numbersDouble = new int[5];
        numbersDouble[0] = numbers[0]*2;
        numbersDouble[1] = numbers[1]*2;
        numbersDouble[2] = numbers[2]*2;
        numbersDouble[3] = numbers[3]*2;
        numbersDouble[4] = numbers[4]*2;


        for (int i = 0; i < numbers.length; i++) {
            System.out.println("Número: "  + numbers[i] + " Dobro: " + numbersDouble[i]);
        }

        /*ArrayList<String> cars = new ArrayList<String>();
        cars.add("Volvo");
        cars.add("BMW");
        cars.add("Mercedez");
        cars.add("Mazda");
        cars.add("Ford");
        System.out.println(cars.size());

        for (String i : cars) {
            System.out.println(i);
        }

        cars.clear();

        cars.add("Citroen");
        System.out.println(cars.getFirst());*/

        Stack<String> cards = new Stack<>();
        cards.add("King of Spades");
        cards.add("Queen of Diamonds");
        cards.add("Three of Clubs");

        System.out.println(cards.pop());

        System.out.println(cards);

        System.out.println(cards.peek()+"\n");

        Queue<String> registerQueue = new ArrayDeque<>();
        registerQueue.add("didito");
        registerQueue.add("eskimo");
        registerQueue.add("cereaw");
        registerQueue.add("grifo");

        System.out.println(registerQueue.poll());

        System.out.println(registerQueue);

        System.out.println(registerQueue.peek());
    }
}
