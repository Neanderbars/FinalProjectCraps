package display;
import game.*;
//import java.awt.GraphicsConfiguration;
import java.awt.BorderLayout;
//import java.awt.GridBagLayout;
//import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintStream;
import java.awt.Dimension;
import java.awt.event.*;
//import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
//import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

/**
 * Author: Kory Krattiger
 * This class sets up the GUI window for playing the game craps. It is
 * set with a border layout, and options include starting a new game, 
 * rolling the dice to play until you win or lose, clearing the custom
 * stream output console (the text area), and showing the statistics of 
 * a set number of games to be played, to see how the outcomes and
 * probabilities of playing many games of craps.
 */
public class GameGUI {

	// Class variables include the craps game, the JFrame
	// window, the panel, a text box, and a scroll for the text
	private Craps game;
	private JFrame frame;
	private JPanel panel;
	private JTextArea textbox;
	private JScrollPane scroll;
	
	// The 4 buttons for playing the game
	private JButton new_game;
	private JButton roll_dice;
	private JButton clear;
	private JButton stats;
	
	// Initializing this class sets the variables, as well as the
	// button events linked with the buttons
	public GameGUI() {
		
		// Sets the variables
		this.game = new Craps();
		this.frame = new JFrame();
		this.panel = new JPanel();
		this.textbox = new JTextArea(50,10);
		this.new_game = new JButton("New Game");
		this.roll_dice = new JButton("Roll Dice");
		this.clear = new JButton("Clear Console");
		this.stats = new JButton("Statistics");
		
		// The new_game button starts a new game, then the dice are ready to roll!
		new_game.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            	game.restart();
            	System.out.println("\nA new game has started, roll the dice!\n");
            }
        });
		
		// The roll_dice button plays the game until a win or loss occurs
		roll_dice.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            	game.game();
            }
        });
		
		// The clear button clears the console, if the 
		// text is getting too crowded
		clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            	textbox.setText("Console Cleared");
            }
        });
		
		stats.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            	System.out.println(game.statistics());
            }
        });
	}
	
	// makeFrame method creates the JFrame, its characteristics,
	// and its dimensions, as well as making it visible, while
	// adding the panel
	public void makeFrame() {
		
		frame.setTitle("Craps");
		frame.setSize(600, 400);
		frame.setLocation(200, 200);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.add(panel);
	}
	
	// makePanel creates the panel, setting a border layout. The buttons
	// are added to the panel, as well as the text box for console output
	public void makePanel(){
		
        panel.setLayout(new BorderLayout());
        panel.add(new_game, BorderLayout.LINE_START);
        panel.add(roll_dice, BorderLayout.CENTER);
        panel.add(clear, BorderLayout.LINE_END);
        panel.add(stats, BorderLayout.PAGE_START);
        panel.add(scroll, BorderLayout.PAGE_END);
        
	}
	
	// makeTextScroll creates a scroll bar that is added to the text box,
	// and sets the text box as the new custom output and error stream
	public void makeTextScroll() {
		
		scroll = new JScrollPane(textbox);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.
        		VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setPreferredSize(new Dimension(15, 200));
        PrintStream printStream = new PrintStream(new CustomOutputStream(textbox));
        System.setOut(printStream);
        System.setErr(printStream);
        
	}
	
	// showGUI simply runs other methods to create the window in full;
	// including makeFrame, makePanel and makeTextScroll
	public void showGUI() {
		
		this.makeTextScroll();
		this.makePanel();
		this.makeFrame();
	}
	
	// Main method, creates the window and shows the window to play
	public static void main(String []args) {
		
		GameGUI window1 = new GameGUI();
		window1.showGUI();
	}
}
