import java.util.Random;

public class Die {
	
	// Instance Variable
	private int value;
	
	// Constructor
	public Die() {
		assignValue();
	}

	// Method to roll die and assign a value to it
	public void assignValue() {
		Random rand = new Random();
		int randomNum = rand.nextInt(6) + 1;
		value = randomNum;
	}
	
	// Method that returns a die's value
	public int getValue() {
		return value;
	}
	
}
