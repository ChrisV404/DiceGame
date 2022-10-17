
public class Matador {
	
	private int score;
	private Die first;
	private Die second;
	private int chosenNum;
	
	public Matador() {
		score = 0;
		first = new Die();
		second = new Die();
	}
	
	public int getScore() {
		return score;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	public int getChosenNum() {
		return score;
	}
	
	public void setChosenNum(int chosenNum) {
		this.chosenNum = chosenNum;
	}
	
	public Die getFirst() {
		return first;
	}
	
	public void setFirst(Die first) {
		this.first = first;
	}
	
	public Die getSecond() {
		return second;
	}
	
	public void setSecond(Die second) {
		this.second = second;
	}
	
	public String chooseNumber() {
		return "Choose a number from 2 through 6";
	}
	
	public String scoreResetMessage() {
		return "Both die show 1 on each. Score reset to 0";
	}
	
	public String zeroAddedToScoreMessage() {
		return "Nothing added to score. One die had a value of 1";
	}
	
	public String addScoreMessage() {
		return "Your new score is: " + String.valueOf(score);
	}
	
	public void rollDice() {
		first.assignValue();
		second.assignValue();
	}
	
	public boolean scoreReset() {
		if(first.getValue() == 1 && second.getValue() == 1) {
			score = 0;
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean zeroAddedToScore() {
		if(first.getValue() == 1 || second.getValue() == 1) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void addScore() {
		score += first.getValue() + second.getValue();
	}
	
}

