import java.util.Random;
import java.util.Scanner;

public class PlayDiceGame {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Welcome, let's play a dice game called Guess!");
		System.out.println("Please enter the number of turns you would like:");
		int chances = input.nextInt();
		
		// Create Guess Game object
		Guess guess = new Guess(chances);
		
		// Set up the guess
		System.out.println(guess.welcomeMessage());
		System.out.println(guess.guessMessage());
		guess.setGuess(input.nextInt());
		
		// Gameplay
		do {
			guess.dieRolling();
			int temp = guess.getTurns();
			temp--;
			guess.setTurns(temp);
			if (guess.isWinner()) {
				System.out.println(guess.winnerMessage());
				guess.setTurns(-1);
			}
			else if (guess.getTurns() > 0) {
				System.out.println(guess.nextTurnMessage());
			}
			else {
				System.out.println(guess.endRolling());
				System.out.println(guess.computerWinMessage());
			}	
		} while (guess.getTurns() > 0);
		
		/* Matador Game begins here */
		
		Matador player = new Matador();
		Matador computer = new Matador();
		Random rand = new Random();
		int toggle = 0;
		
		System.out.println(player.chooseNumber());
		player.setChosenNum(input.nextInt());
		
		System.out.println(computer.chooseNumber());
		computer.setChosenNum(rand.nextInt(5) + 2);
		
		while(player.getScore() < 121 && computer.getScore() < 121) {
			
			if(toggle == 0) {
				player.rollDice();
				if(player.scoreReset()) {
					System.out.println(player.scoreResetMessage());
					toggle = 1;
				}
				else if(player.zeroAddedToScore()) {
					System.out.println(player.zeroAddedToScoreMessage());
					toggle = 1;
				}
				else {
					player.addScore();
					System.out.println(player.addScoreMessage());
					if(player.getChosenNum() == player.getFirst().getValue() && player.getChosenNum() == player.getFirst().getValue()) {
						System.out.println("Player wins! Got Chosen number on both dice");
						player.setScore(121);
					}
					else if(player.getChosenNum() == player.getFirst().getValue() && player.getChosenNum() == player.getFirst().getValue()) {
						System.out.println("Player chosen value is on one die. Player rolls again");
						toggle = 0;
					}
					else {
						System.out.println("It is now the computer's turn");
						toggle = 1;
					}
				}
			}
			
			if(toggle == 1) {
				computer.rollDice();
				if(computer.scoreReset()) {
					System.out.println(computer.scoreResetMessage());
					toggle = 0;
				}
				else if(computer.zeroAddedToScore()) {
					System.out.println(computer.zeroAddedToScoreMessage());
					toggle = 0;
				}
				else {
					computer.addScore();
					System.out.println(computer.addScoreMessage());
					if(computer.getChosenNum() == computer.getFirst().getValue() && computer.getChosenNum() == computer.getFirst().getValue()) {
						System.out.println("Computer wins! Got chosen number on both dice");
						computer.setScore(121);
					}
					else if (computer.getChosenNum() == computer.getFirst().getValue() && computer.getChosenNum() == computer.getFirst().getValue()) {
						System.out.println("Computer chosen value is on one die. Computer rolls again");
						toggle = 1;
					}
					else {
						System.out.println("It is now the Player's turn");
						toggle = 0;
					}
				}
			}	
		}
		
		if(player.getScore() >= 121) {
			System.out.println("The Player won with a score of: " + player.getScore());
		}
		else {
			System.out.println("The Computer won with a score of: " + computer.getScore());
		}
		input.close();
	}
}
