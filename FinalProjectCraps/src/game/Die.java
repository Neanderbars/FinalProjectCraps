
/** Author: Kory Krattiger
 * This class represents a dice object, which can be rolled and the 
 * value retrieved. The value is a random number between 1 and 6.
 * To be used in the craps game.
 */
package game;
import java.lang.Math; // Used for the random number

// One dice object
public class Die {
	
	// value represents the face value of the die
	private int value;
	
	public Die() {
		
		this.value = 1; // the default face value is set to 1
	}
	
	// A random number between 1 and 6 is generated
	public void roll() {
		
		value = (int)(Math.random() * 6) + 1;
	}
	
	// The value of the die is retrieved
	public int getRoll() {
		
		return value;
	}
	
	// The toString method of the die value
	@Override
	public String toString() {
		
		String stringValue = Integer.toString(value);
		return stringValue;
	}
	
}
