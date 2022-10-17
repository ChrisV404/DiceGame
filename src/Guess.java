
public class Guess {

	private Die one;
	private Die two;
	private int guess;
	private int turns;
	
	public Guess (int turns) {
		one = new Die();
		two = new Die();
		this.turns = turns;
	}
	
	public String nextTurnMessage() {
		return "Let's try another turn!";
	}
	
	public String welcomeMessage() {
		return "Welcome to the Guessing Game!";
	}
	
	public String rollMessage() {
		return "Let's roll that dice!";
	}
	
	public void dieRolling() {
		one.assignValue();
		two.assignValue();
	}
	
	public String endRolling() {
		return "Sorry, you are out of rolls.";
	}
	
	public String guessMessage() {
		return "Please enter your guess (2-12)";
	}
	
	public void setGuess(int guess) {
		this.guess = guess;
	}
	
	public int getGuess() {
		return guess;
	}
	
	public String winnerMessage() {
		return "You won!";
	}
	
	public String computerWinMessage() {
		return "The computer won";
	}
	
	public boolean isWinner() {
		int guessValue = one.getValue() + two.getValue();
		
		if (guessValue == guess) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void setTurns(int turns) {
		this.turns = turns;
	}
	
	public int getTurns() {
		return turns;
	}
}
