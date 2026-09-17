import java.util.Scanner;

public class MineGame {

    static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int mineScore = 0;
        int rounds = startGame(scanner);

        for (int i = 0; i < rounds; i++) {
            int randomBlock = getRandomBlock(1, 3);
            String tool = chooseTool(scanner);
            mineScore = getMineScore(randomBlock, tool, mineScore);
        }

        endGame(mineScore);

        scanner.close();
    }

    public static int startGame(Scanner scanner) {
        System.out.println("Welcome to Mine Game!\n");
        System.out.println("How many blocks do you want to mine?");
        System.out.print("> ");
        return scanner.nextInt();
    }

    public static int getRandomBlock(int min, int max) {
        int randomBlock;
        randomBlock = (int) (Math.random() * (max - min + 1)) + min;

        switch (randomBlock) {
            case 1:
                System.out.println("You find a Clay Block!");
                break;
            case 2:
                System.out.println("You find a Stone Block!");
                break;
            case 3:
                System.out.println("You find a Cobweb Block!");
                break;
        }
        return randomBlock;
    }

    public static String chooseTool(Scanner scanner) {
        String tool;
        System.out.println("What tool you should use to mine this block?");
        System.out.println();

        System.out.println("Sword, shovel or pickaxe?");
        System.out.print("> ");
        tool = scanner.next().toLowerCase();
        System.out.println();
        return tool;
    }

    public static int getMineScore(int randomBlock, String tool, int mineScore) {
        if ((randomBlock == 1) && (tool.equals("shovel"))) {
            mineScore++;
            System.out.println("Nice! You've scored "+ mineScore +" time(s)!\n");
        } else if ((randomBlock == 2) && (tool.equals("pickaxe"))) {
            mineScore++;
            System.out.println("Nice! You've scored "+ mineScore +" time(s)!\n");
        } else if ((randomBlock == 3) && (tool.equals("sword"))) {
            mineScore++;
            System.out.println("Nice! You've scored "+ mineScore +" time(s)!\n");
        } else {
            System.out.println("Oh no! That sounds wrong.\n");
        }
        return mineScore;
    }

    public static void endGame(int mineScore) {
        System.out.println("GAME OVER!");

        if (mineScore > 0) {
            System.out.println("Very good! You have scored "+ mineScore + " points!");
        } else if (mineScore == 0) {
            System.out.println("Unfortunately you haven't scored...");
        }

        System.out.println("\nThank you for playing!");
    }
}
