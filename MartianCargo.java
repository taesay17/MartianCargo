import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class MartianCargo {
    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();
    private static ArrayList<Integer> boxLocations = new ArrayList<>();
    private static int attempts = 0; //for commit

    public static void main(String[] args) {
        initializeBoxLocations();

        while (true) {
            ArrayList<Integer> guessedLocations = getUserGuesses();
            int correctGuesses = checkGuesses(guessedLocations);

            System.out.println("Number of correctly guessed kilometer marks: " + correctGuesses);

            if (correctGuesses == 3) {
                System.out.println("Congratulations! All boxes were found.");
                break;
            }

            attempts++;

            if (attempts == 5) {
                System.out.println("The boxes have moved! Try again.");
                initializeBoxLocations();
                attempts = 0;
            }
        }

        scanner.close();
    }

    public static void initializeBoxLocations() {
        boxLocations.clear();
        for (int i = 0; i < 3; i++) {
            boxLocations.add(random.nextInt(8));
        }
    }

    public static ArrayList<Integer> getUserGuesses() {
        ArrayList<Integer> guessedLocations = new ArrayList<>();
        System.out.println("Enter 3 kilometer marks where you think the cargo is hidden:");
        for (int i = 0; i < 3; i++) {
            guessedLocations.add(scanner.nextInt());
        }
        return guessedLocations;
    }

    public static int checkGuesses(ArrayList<Integer> guessedLocations) {
        int correctGuesses = 0;
        for (int guess : guessedLocations) {
            if (boxLocations.contains(guess)) {
                correctGuesses++;
            }
        }
        return correctGuesses;
    }
}

