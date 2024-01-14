package Task1;
import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		Random random = new Random ();
		int lowerbound = 1 ;
		int upperbound = 100 ;
		int maxAttempt = 5 ;
		int rounds = 0 ;
		int score = 0 ;
		
		System.out.println("...! Welcome to Number Guessing game !...");
		
		while(true) {
			int targetNumber = random.nextInt(upperbound - lowerbound + 1) +lowerbound ;
			int attempts = 0 ;
			
			System.out.println("Round " + (rounds + 1) + ":");
			System.out.println("You have chosen a number between " + lowerbound +" and " + upperbound +" . Try to guess it !");
			
			while(attempts < maxAttempt) {
				System.out.println("Enter your guess :");
				int userGuess = s.nextInt();
				attempts++;
				
				if(userGuess == targetNumber) {
					System.out.println("Congraculations ! You guessed the correct number in " + attempts + "attempts.");
					score++;
					break ;
				}else if(userGuess < targetNumber) {
					System.out.println("Your guess is too low . Try again");
				}else {
					System.out.println("Your guess is too high . Try again.");
				}
				if (attempts == maxAttempt) {
					System.out.println("Sorry , you are reached the maximum number of attempt . The correct number was : "+ targetNumber);
				}
				
			}
		
			System.out.println("DO you want to play another round ? (Yes/No) :");
			String playAgain = s.next();
		    
			if(!playAgain.equalsIgnoreCase("Yes")) {
				System.out.println("Thanks for playing ! Your total score is : " + score + " out of " +(rounds + 1));
				break ;
			}
			rounds++;
			
		}
		s.close();		
	}

}
