/*
 * Gregorio Olivares
 * Object Oriented Programming - cpsc24500 - Section 3
 * 2024-02-22
 * The purpose of this code is to play rock,paper,scissors with user input
*/
package m;
import java.util.*;

public class Assignment3Final {

	// Instance Variables
	int userChoice;
	String userInitial;
	int compChoice;
	String restart;
	
	public static void main(String[] args) {
		new Assignment3Final().intro();
		
	}
	
	
	// Intro banner
	public void intro() {
		System.out.println("Hello! Welcome to the game of Rock, Paper, and Scissors. \nThe game rules are as follows: ");
		System.out.println("1 = Rock , 2 = Paper , and 3 = Scissors. \nYou will enter your choice of either a 1, 2, or 3 and then will see the computers' choice.");
		System.out.println("Rock will beat Scissors, Scissors will beat Paper, Paper beats Rock, and the game will continue if there is a tie.");
		
		userInput();
	}
	
	// Asking for user input 
	public void userInput() {
		Scanner scan = new Scanner(System.in);
		System.out.println("");
		System.out.print("Please enter your choice of 1, 2, or 3 here: ");
		userInitial = scan.next();
		
		
		// Method to convert user string into possible values
		if (userInitial.contentEquals("1")) {
			userChoice = 1;
		} else {
			if (userInitial.contentEquals("2")) {
				userChoice = 2;
			} else {
				if (userInitial.contentEquals("3")) {
					userChoice = 3;
				} else {
					invalid();
				}
			}
		}



		// Decides if user enters a valid input or not 
		if (userChoice == 1 || userChoice == 2 || userChoice == 3) {
			compGuess();

		} else {
			invalid();
		}



	}
	
	// Computer choice
	public void compGuess() {
		Random rand = new Random();
		compChoice = rand.nextInt(3)+1;
		System.out.println("The computer chose: " + compChoice);
		
		winner();
	}
	
	// method to show invalid input
	public void invalid() {
		System.out.println("You have entered an invalid character, please try again.");
		userInput();
	}
	
	// Comparison and winner choice + loop if game is a tie & prompt user to try again
	public void winner() {
		// Loop to resolve ties
		while (compChoice == userChoice) {
			System.out.println("The game was a draw, try again.");
			userInput();
		}
		
		// If user picks rock
		if (userChoice == 1 && compChoice == 2) {
			System.out.println("You chose rock while the computer chose paper, you lost.");
			
			Scanner s = new Scanner(System.in);
			System.out.print("Would you like to play again? Type Y for yes or N for no:  ");
			restart = s.nextLine();
			if (restart.contentEquals("y") || restart.contentEquals("Y")) {
				userInput();
			} else {
				if (restart.contentEquals("n") || restart.contentEquals("N")){
					System.out.println("");
					System.out.println("Goodbye!");
					System.exit(0);
				} else {
					invalid();
				}
			}	
		} else {
			if (userChoice == 1 && compChoice == 3) {
			System.out.println("You chose rock while the computer chose scissors, you won!");
			
			Scanner a = new Scanner(System.in);
			System.out.print("Would you like to play again? Type Y for yes or N for no: ");
			restart = a.nextLine();
			if (restart.contentEquals("y") || restart.contentEquals("Y")) {
				userInput();
			} else {
				if (restart.contentEquals("n") || restart.contentEquals("N")){
					System.out.println("");
					System.out.println("Goodbye!");
					System.exit(0);
				} else {
					invalid();
				}
			}
			}
		}
		
		// if user picks paper
		if (userChoice == 2 && compChoice == 3) {
			System.out.println("You chose paper while the computer chose scissors, you lost.");
			
			Scanner b = new Scanner(System.in);
			System.out.print("Would you like to play again? Type Y for yes or N for no:  ");
			restart = b.nextLine();
			if (restart.contentEquals("y") || restart.contentEquals("Y")) {
				userInput();
			} else {
				if (restart.contentEquals("n") || restart.contentEquals("N")) {
					System.out.println("");
					System.out.println("Goodbye!");
					System.exit(0);
				} else {
					invalid();
				}
			}
		} else {
				if (userChoice == 2 && compChoice == 1) {
					System.out.println("You chose paper while the computer chose rock, you won!");
			
					Scanner d = new Scanner(System.in);
					System.out.print("Would you like to play again? Type Y for yes or N for no: ");
					restart = d.nextLine();
					if (restart.contentEquals("y") || restart.contentEquals("Y")) {
						userInput();
					} else {
						if (restart.contentEquals("n") || restart.contentEquals("N")) {
							System.out.println("");
							System.out.println("Goodbye!");
							System.exit(0);
						} else {
							invalid();
						}

					}
				}
		}
		
		
		// if user picks scissors
		if (userChoice == 3 && compChoice == 1) {
			System.out.println("You chose scissors while the computer chose rock, you lost.");
			
			Scanner e = new Scanner(System.in);
			System.out.print("Would you like to play again? Type Y for yes or N for no:  ");
			restart = e.nextLine();
			if (restart.contentEquals("y") || restart.contentEquals("Y")) {
				userInput();
			} else {
				if (restart.contentEquals("n") || restart.contentEquals("N")) {
					System.out.println("");
					System.out.println("Goodbye!");
					System.exit(0);
				} else {
					invalid();
				}
	
			}
		} else {
			if (userChoice == 3 && compChoice == 2) {
			System.out.println("You chose scissors while the computer chose paper, you won!");
			
			Scanner f = new Scanner(System.in);
			System.out.print("Would you like to play again? Type Y for yes or N for no: ");
			restart = f.nextLine();
			if (restart.contentEquals("y") || restart.contentEquals("Y")) {
				userInput();
			} else {
				if (restart.contentEquals("n") || restart.contentEquals("N")) {
					System.out.println("");
					System.out.println("Goodbye!");
					System.exit(0);
				} else {
					invalid();
				}
			}
			}
		}
	}
}
