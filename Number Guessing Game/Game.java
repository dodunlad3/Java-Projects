package Game;
import java.util.Random;
import java.util.Scanner;
public class Game {

	public static void main(String[] args) {
		/**
		 * Initializing the game
		 * 	- Sets number to a random number from 1 to maximum
		 *  - Sets the number of lives
		 *  - Creates scanners for user input
		 * 
		 */
		int number, guess = 0;
		final int maximum = 10;
		int lives = 4;
		String answer = "";
		Scanner input = new Scanner(System.in);
		Scanner playAgain = new Scanner(System.in);
		Random randNum = new Random();
		number = randNum.nextInt(maximum) + 1;
		/**
		 * Asks user to pick a number from one to maximum
		 * If the guess is the same as the random number, you win and are asked if you want to play again
		 * 
		 * If the guess is greater than the random number then you lose a life and get to pick again
		 * 
		 * If the guess is lower than the random number then you lose a life and get to pick again
		 * 
		 * If you have 0 lives the game will end and ask if you want to play again
		 */
		System.out.println("Welcome to the game select a number from 1 to "+ maximum +". You have "+ lives +" lives remaining.");
		
		while(lives > 0 || guess != number) {
			// If you have 0 lives the game will end and ask if you want to play again
			if(lives == 0) {
				System.out.println("Game Over! \nWould you like to play again? Y or N");
				answer = playAgain.nextLine();
				if(answer.equalsIgnoreCase("Y")) {
					lives = 4;
					number = randNum.nextInt(maximum) + 1;
					System.out.println("Select a number from 1 to "+ maximum +". You have "+ lives +" lives remaining.");
				}
				else {
					break;
				}
			}
			guess = input.nextInt();
			// If the guess is the same as the random number, you win and are asked if you want to play again
			if(guess == number) {
				System.out.println("You guessed correctly!! \nWould you like to play again? Y or N");
				answer = playAgain.nextLine();
				if(answer.equalsIgnoreCase("Y")) {
					lives = 4;
					number = randNum.nextInt(maximum) + 1;
					System.out.println("Select a number from 1 to "+ maximum +". You have "+ lives +" lives remaining.");
				}
				else {
					break;
				}
			}
			// If the guess is greater than the random number then you lose a life and get to pick again
			else if(guess > number) {
				lives--;
				System.out.println("Sorry, the number is lower. You have "+ lives +" lives remaining.");
			}
			// If the guess is lower than the random number then you lose a life and get to pick again
			else if(guess < number) {
				lives--;
				System.out.println("Sorry, the number is higher. You have "+ lives +" lives remaining.");
			}
		}
		System.out.println("Thank You! Come back soon!!");
	}

}
