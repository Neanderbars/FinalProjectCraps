/**
 * Author: Kory Krattiger
 * This class sets up the rules for the game of craps. In craps,
 * two dice are rolled, and on the initial roll, you win the game if
 * a 7 or 11 is rolled, and you lose if a 2, 3, or 12 is rolled. Any
 * other values and you keep rolling. After the inital roll, if a
 * 7 is rolled, you lose! If you roll the initial value rolled in
 * the first round, you win the game!
 */
package game;

public class Craps {
	
	// The player object, as well as an initial roll value,
	// and three boolean values - start, winner, and loser - 
	// are set up. Start is only true at the beginning round,
	// while winner and loser are only true if the player wins
	// or loses. Ints and Doubles for wins, losses, rolls for each
	// and average rolls for wins and losses are also declared
	private Player player;
	private boolean start;
	private boolean winner;
	private boolean loser;
	private int initial_roll;
	private int wins;
	private int losses;
	private double win_rolls;
	private double loss_rolls;
	private double ave_win;
	private double ave_loss;
	
	// Only start is set to true initially
	public Craps() {
		
		this.player = new Player();
		this.start = true;
		this.winner = false;
		this.loser = false;
		this.wins = 0;
		this.losses = 0;
	}
	// Returns the number of wins
	public int getWins() {
		
		return wins;
	}
	// Returns the number of losses
	public int getLosses() {
		
		return losses;
	}
	// Returns the average number of rolls per win
	public double getWinRolls() {
		
		return win_rolls;
	}
	// Returns the average number of rolls per loss
	public double getLossRolls() {
		
		return loss_rolls;
	}
	
	// The first round has different rules than subsequent rounds
	public void firstRound() {
		
		player.rollDice(); // Dice are rolled and values retrieved
		initial_roll = player.getDiceRolls();
		// If a 2, 3, or 12 is rolled you lose, adds to loss count, adds to loss roll count
		// and updates roll average for losses
		if (initial_roll == 2 || initial_roll == 3 || 
				initial_roll == 12) {
				
			loser = true;
			losses ++;
			loss_rolls += player.getRollCount();
			this.rollAverageLoss();
			System.out.println("You lost on the first "
					+ "roll! Bad luck!");
				
		}
		// If a 7 or 11 is rolled you win, adds to win count, adds to win roll count
		// and updates roll average for wins
		else if (initial_roll == 7 || initial_roll == 11){
				
			winner = true;
			wins ++;
			win_rolls += player.getRollCount();
			this.rollAverageWin();
			System.out.println("You won on the first "
					+ "roll! Congrats!");
		}
		// If a value other than 2, 3, 7, 11, or 12 is rolled,
		// more rounds are played, and start is set to false.
		else {
			
			start = false;
		}
		
	}
	
	// A regular round has the following rules: If a 7 is rolled,
	// you lose the game. If you roll the inital roll from the
	// first round you win
	public void round() {
		
		player.rollDice();
		int round_roll = player.getDiceRolls();
		// Tests for the initial roll value, adds to win count, adds to win roll count
		// and updates roll average for wins
		if (round_roll == initial_roll) {
			
			winner = true;
			wins ++;
			win_rolls += player.getRollCount();
			this.rollAverageWin();

		}
		// Tests for a 7, adds to losses count, adds to loss roll count
		// and updates roll average for losses
		else if(round_roll == 7) {
			
			loser = true;
			losses ++;
			loss_rolls += player.getRollCount();
			this.rollAverageLoss();

		}
		
	}
	
	// Tests for the start round
	public boolean isStart() {
		
		return start;
	}
	
	// Tests to see if you've won
	public boolean isWinner() {
		
		return winner;
	}
	
	// Tests to see if you've lost
	public boolean isLoser() {
		
		return loser;
	}
	
	// Restarts game values
	public void restart() {
		
		start = true;
		winner = false;
		loser = false;
		player.reset();
	}
	
	// This method plays the game until you win or lose,
	// testing for wins or losses. The round results are printed
	// each round.
	public void game() {
		
		// Plays first round first
		if (this.isStart() == true) {
			
			this.firstRound();
			System.out.println(this.toString());
		}
		
		// Keeps playing as long as you have not lost
		// or won
		while (this.isLoser() == false && 
				this.isWinner() == false) {
			
				this.round();
				System.out.println(this.toString());
				
				if (this.isLoser() == true) {
					
					System.out.println("You lost!"
							+ " Better luck next time.");
				}
				
				else if (this.isWinner() == true) {
					
					System.out.println("You won! Congrats!");
				}
		}
	}
	
	// Updates the roll count average for wins
	public void rollAverageWin() {
		
		ave_win = win_rolls/wins;
	}
	
	// Updates the loss count average for losses
	public void rollAverageLoss() {
		
		ave_loss = loss_rolls/losses;
		
	}
	
	// String method simply prints results of a round
	@Override
	public String toString() {
		
		return "\nDice have been rolled!"
				+ player.toString();
	}
	
	// String method for printing statistics of all games played
	public String statistics() {
		
		return "\nGames Played: " + Integer.toString(wins + losses) + 
				"\nGames Won: " + Integer.toString(wins) +
				"\nGames Lost: " + Integer.toString(losses) +
				"\nAverage rolls per win: " + Double.toString(ave_win) +
				"\nAverage rolls per loss: " + Double.toString(ave_loss);
	}
	
}
