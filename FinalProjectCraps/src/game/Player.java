/** Author: Kory Krattiger
 * This class represents a player, who has two dice, and can roll
 * the dice and add to a count total of die rolls. The dice 
 * count can be reset if a new game is opted to be played.
 */
package game;

// The player object represents a player
public class Player {
	
	// The class variables, two die, the combined value of
	// the dice after roll, and a total roll count
	private Die die1;
	private Die die2;
	private int dice_value;
	private int roll_count;
	
	// The player starts with two dice, and the roll count is
	// set to 0
	public Player() {
		
		this.die1 = new Die();
		this.die2 = new Die();
		this.roll_count = 0;
		
		
	}
	
	// The rollDice method rolls the dice of the player, and
	// adds to the roll count.
	public void rollDice() {
		
		die1.roll();
		die2.roll();
		roll_count ++;
		
	}
	
	// This method returns the roll count of the player
	public int getRollCount() {
		
		return roll_count;
		
	}
	
	// The two die values are retrieved and added together to 
	// get the score of the first roll. The score is then returned
	public int getDiceRolls() {
		
		int v1 = die1.getRoll();
		int v2 = die2.getRoll();
		dice_value = v1 + v2;
		return dice_value;
		
	}
	
	// If a new game is chosen to be played, the roll count will
	// be reset to 0
	public void reset() {
		
		roll_count = 0;
		
	}
	
	// This method returns the previous roll and the
	// current roll count.
	@Override
	public String toString() {
		
		String dice_string = Integer.toString(dice_value);
		String roll_string = Integer.toString(roll_count);
		return "\nYou rolled: " + dice_string + 
				"\nRoll Count: " + roll_string;
		
	}
}
