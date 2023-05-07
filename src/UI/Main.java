package UI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Phases.AttackPhase;
import UI.otherScreens.pause.PauseButton;
import UI.validation.*;
import domain.StartingHandler;
import domain.userOperations.CurrentLogins;

public class Main {

	
		
		public static void main(String[] args) {
			//to test attackphase related methods

		//	AttackPhase attack= new AttackPhase();
		//	attack.run();
			

			int playerCount = getNumberOfPlayers(); // Via JOptionPane
			int computerCount = getNumberOfComputers(playerCount); // Via JOptionPane
			openStartScreen(playerCount, computerCount);

		}
		
		
		private static void openStartScreen(int playerCount, int computerCount) {
			JFrame startScreen = new JFrame();
			startScreen.setLayout(new BorderLayout());
			startScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			JPanel loginPanel = new JPanel();
			loginPanel.setLayout(new FlowLayout());
			
			for (int i = 0; i < playerCount; i++) {
				loginPanel.add(new PlayerLabel());
			}
			
			startScreen.add(loginPanel, BorderLayout.CENTER);
			
			JPanel startPanel = new JPanel();
			startPanel.setLayout(new FlowLayout());
			startPanel.add(new JLabel("Computer Players: " + computerCount));
			JButton startButton =new JButton("Start");
			startButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					ArrayList<String> currentLogins = CurrentLogins.getCurrentLogins();
					if (currentLogins.size() != playerCount) {
						JOptionPane.showMessageDialog(null, "All the players must login.", "Some players haven't logged in.", JOptionPane.ERROR_MESSAGE);
					}
					else {
						startScreen.dispose();
						StartingHandler handler = StartingHandler.getHandler();
						handler.startGame(computerCount);
					}
				}
				
			});;
			
			startPanel.add(startButton);
			startScreen.add(startPanel, BorderLayout.SOUTH);
			startScreen.setSize(450, 250);
			startScreen.setVisible(true);

		}
		
		
	    public static int getNumberOfPlayers() {
	    	
	        StartingHandler handler = StartingHandler.getHandler();
	        boolean isValidInput = false;
	        String input = "";
	        // Keep asking for player count until valid input is given
	        while (!isValidInput) {
	        	isValidInput = false;
	            input = JOptionPane.showInputDialog(null, "Enter number of players (0-5):");
	            
	            isValidInput = handler.validatePlayerInput(input);
           
	            // Check if player count is within the valid range
	            if (!isValidInput) {
	                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a number between 0 and 5.");
	            }
	        }
	        
	        int playerCount = handler.getPlayerCount(input);
	        JOptionPane.showMessageDialog(null, "You entered " + playerCount + " players.");
	        
	        return playerCount;
	    }
	    
	    
	    public static int getNumberOfComputers(int playerCount) {
	    	
	        StartingHandler handler = StartingHandler.getHandler();
	        boolean isValidInput = false;
	        String input = "";

	        String range = "(" + handler.getMinComputerPlayers(playerCount) + "-" +  handler.getMaxComputerPlayers(playerCount) + ")";
	        
	        // Keep asking for player count until valid input is given
	        while (!isValidInput) {
	        	isValidInput = false;
	        	
	            input = JOptionPane.showInputDialog(null, "Enter number of computer players " + range + ":");
	            
	            isValidInput = handler.validateComputerInput(input, playerCount);

	            // Check if computer player count is within the valid range
	            if (!isValidInput) {

	                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a number between " + range + ".");
	            }
	        }
	        
	        int computerCount = handler.getComputerCount(input, playerCount);
	        JOptionPane.showMessageDialog(null, "You entered " + computerCount + " computer players.");
	        
	        return computerCount;
	    }	    		
}
