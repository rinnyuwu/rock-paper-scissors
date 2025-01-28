package game;

import java.util.Random;
import java.util.Scanner;

public class Game {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] options = {"Rock", "Scissors", "Paper"};

        Random random = new Random(System.currentTimeMillis());

        System.out.println("Welcome to Rock, Paper, Scissors!");
        System.out.print("Choose (Rock, Scissors, Paper): ");
        String userChoice = scanner.nextLine().trim();

        if (!isValidChoice(userChoice)) {
            System.out.println("That's not a valid choice. Try again.");
            return;
        }

        String enemyChoice = options[random.nextInt(options.length)];
        System.out.println("You chose: " + userChoice);
        System.out.println("The enemy picked: " + enemyChoice);

        determineWinner(userChoice, enemyChoice);
    }

    private static boolean isValidChoice(String choice) {
        return choice.equalsIgnoreCase("Rock") || choice.equalsIgnoreCase("Scissors") || choice.equalsIgnoreCase("Paper");
    }

    private static void determineWinner(String userChoice, String enemyChoice) {
        if (userChoice.equalsIgnoreCase(enemyChoice)) {
            System.out.println("It's a tie!");
        } else if (
                (userChoice.equalsIgnoreCase("Rock") && enemyChoice.equalsIgnoreCase("Scissors")) ||
                        (userChoice.equalsIgnoreCase("Scissors") && enemyChoice.equalsIgnoreCase("Paper")) ||
                        (userChoice.equalsIgnoreCase("Paper") && enemyChoice.equalsIgnoreCase("Rock"))
        ) {
            System.out.println("You won!");
        } else {
            System.out.println("The enemy won!");
        }
    }
}