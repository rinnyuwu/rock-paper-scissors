package game;

import java.util.Random;
import java.util.Scanner;

public class Game {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] options = {"Rock", "Scissors", "Paper"};

        Random random = new Random(System.currentTimeMillis());

        printHeader();

        while (true) {
            System.out.print("\nChoose your weapon (Rock, Scissors, Paper) or type 'exit' to quit: ");
            String userChoice = scanner.nextLine().trim();

            if (userChoice.equalsIgnoreCase("exit")) {
                System.out.println("\nThanks for playing! Goodbye");
                break;
            }

            if (!isValidChoice(userChoice)) {
                System.out.println("\n[ERROR] Invalid choice! Please choose Rock, Scissors, or Paper");
                continue;
            }

            String enemyChoice = options[random.nextInt(options.length)];

            printChoices(userChoice, enemyChoice);

            determineWinner(userChoice, enemyChoice);

            printSeparator();
        }
    }

    private static void printHeader() {
        System.out.println("==============================================");
        System.out.println("        Welcome to Rock, Paper, Scissors      ");
        System.out.println("==============================================");
        System.out.println("To start playing, choose your weapon");
        System.out.println("Type 'exit' anytime to quit the game");
        printSeparator();
    }

    private static void printChoices(String userChoice, String enemyChoice) {
        System.out.println("\nYour Choice:   " + formatChoice(userChoice));
        System.out.println("Enemy's Choice: " + formatChoice(enemyChoice));
    }

    private static String formatChoice(String choice) {
        return choice.substring(0, 1).toUpperCase() + choice.substring(1).toLowerCase();
    }

    private static boolean isValidChoice(String choice) {
        return choice.equalsIgnoreCase("Rock") || choice.equalsIgnoreCase("Scissors") || choice.equalsIgnoreCase("Paper");
    }

    private static void determineWinner(String userChoice, String enemyChoice) {
        if (userChoice.equalsIgnoreCase(enemyChoice)) {
            System.out.println("\nIt's a tie");
        } else if (
                (userChoice.equalsIgnoreCase("Rock") && enemyChoice.equalsIgnoreCase("Scissors")) ||
                        (userChoice.equalsIgnoreCase("Scissors") && enemyChoice.equalsIgnoreCase("Paper")) ||
                        (userChoice.equalsIgnoreCase("Paper") && enemyChoice.equalsIgnoreCase("Rock"))
        ) {
            System.out.println("\nYou won!");
        } else {
            System.out.println("\nThe enemy won");
        }
    }

    private static void printSeparator() {
        System.out.println("==============================================");
    }
}
