import java.util.Scanner;
import java.util.Random;

public class rpsgame {

    public static void main(String[] args) {
        // Set up a way to read what the player types and generate random choices for the computer.
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Define the choices the player and computer can make.
        String[] choices = {"rock", "paper", "scissors"};

        // Welcome message.
        System.out.println("Welcome to Rock Paper Scissors!");

        while (true) {
            // Ask the player to make a choice or quit.
            System.out.println("Enter your choice: rock, paper, scissors, or quit");
            String playerChoice = scanner.nextLine().toLowerCase(); // Convert player input to lowercase for consistency.

            // If the player wants to quit, end the game.
            if (playerChoice.equals("quit")) {
                System.out.println("Thanks for playing!");
                break;
            }

            // Check if the player's choice is one of the valid options.
            switch (playerChoice) {
                case "rock":
                case "paper":
                case "scissors":
                    // Generate a random choice for the computer.
                    int computerChoiceIndex = random.nextInt(choices.length);
                    String computerChoice = choices[computerChoiceIndex];
                    System.out.println("Computer chose: " + computerChoice);

                    // Determine the winner of the round.
                    determineWinner(playerChoice, computerChoice);
                    break;
                default:
                    // If the player enters an invalid choice, ask them to choose again.
                    System.out.println("Invalid choice. Please choose from the available options or quit.");
                    break;
                    
            }
             scanner.close();
        }
    }

    public static void determineWinner(String playerChoice, String computerChoice) {
        // Display what the player and computer chose.
        System.out.println("You chose: " + playerChoice);

        // Check who won or if it's a tie and print the result.
        if (playerChoice.equals(computerChoice)) {
            System.out.println("It's a tie!");
        } else if (
            (playerChoice.equals("rock") && computerChoice.equals("paper")) ||
            (playerChoice.equals("paper") && computerChoice.equals("scissors")) ||
            (playerChoice.equals("scissors") && computerChoice.equals("rock"))
        ) {
            System.out.println("Computer wins!");
        } else {
            System.out.println("You win!");
        }
    }
}