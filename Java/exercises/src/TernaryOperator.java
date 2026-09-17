public class TernaryOperator {

    static void main(String[] args) {

        int health = (int) (Math.random() * 5);

        String status = (health > 0) ? "Alive": "Died";

        System.out.println(health + " " + status);

    }
}
