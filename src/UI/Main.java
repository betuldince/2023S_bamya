package UI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import UI.validation.*;
import domain.AllPlayers;
import domain.Player;
import domain.buildingmode.BuildingModeStarter;
import domain.userOperations.CurrentLogins;

public class Main {

	
		
		public static void main(String[] args) {
			
			int playerCount = getNumberOfPlayers();
			int computerCount = getNumberOfComputers(playerCount);
			openStartScreen(playerCount, computerCount);

		}
		
		
		private static void openStartScreen(int playerCount, int computerCount) {
			JFrame startScreen = new JFrame();
			startScreen.setLayout(new BorderLayout());
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
						createPlayers();
						createComputerPlayers(computerCount);
						BuildingModeStarter.startBuildingMode();
						startScreen.dispose();
					}
				}
				
			});;
			
			startPanel.add(startButton);
			startScreen.add(startPanel, BorderLayout.SOUTH);
			startScreen.setSize(450, 250);
			startScreen.setVisible(true);

		}
		
		
	    public static int getNumberOfPlayers() {
	        int playerCount = -1;
	        
	        // Keep asking for player count until valid input is given
	        while (playerCount < 0 || playerCount > 5) {
	            String input = JOptionPane.showInputDialog(null, "Enter number of players (0-5):");
	            
	            // Attempt to parse input as an integer
	            try {
	                playerCount = Integer.parseInt(input);
	            } catch (NumberFormatException e) {
	                // Input was not a valid integer
	                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a number between 0 and 5.");
	                continue;
	            }
	            
	            // Check if player count is within the valid range
	            if (playerCount < 0 || playerCount > 5) {
	                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a number between 0 and 5.");
	            }
	        }
	        
	        JOptionPane.showMessageDialog(null, "You entered " + playerCount + " players.");
	        
	        return playerCount;
	    }
	    
	    
	    public static int getNumberOfComputers(int playerCount) {
	        int computerCount = -1;
	        int noPlayers = (playerCount == 0 ? 1 : 0);
	        // Keep asking for player count until valid input is given
	        while (computerCount < 1 + noPlayers || computerCount > 6-playerCount) {
	            String input = JOptionPane.showInputDialog(null, "Enter number of computer players (" + (1 + noPlayers) + "-" +  (6-playerCount) + "):");
	            
	            // Attempt to parse input as an integer
	            try {
	            	computerCount = Integer.parseInt(input);
	            } catch (NumberFormatException e) {
	                // Input was not a valid integer
	                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a number between (" + (1 + noPlayers) + "-" +  (6-playerCount) + ").");
	                continue;
	            }
	            
	            // Check if computer player count is within the valid range
	            if (computerCount < 1 + noPlayers || computerCount > 6-playerCount) {
	                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a number between (" + (1 + noPlayers) + "-" +  (6-playerCount) + ").");
	            }
	        }
	        
	        JOptionPane.showMessageDialog(null, "You entered " + computerCount + " computer players.");
	        
	        return computerCount;
	    }
	    
	    
	    public static void createPlayers() {
	    	ArrayList<String> currentLogins = CurrentLogins.getCurrentLogins();
	    	Iterator<String> nicknames = currentLogins.iterator();
    		AllPlayers allPlayers = AllPlayers.createAllPlayers();
	    	while (nicknames.hasNext()) {
	    		allPlayers.add_new_player(new Player(nicknames.next()));
	    	}
	    }
	    
	    public static void createComputerPlayers(int computerCount) {
    		AllPlayers allPlayers = AllPlayers.createAllPlayers();
	    	for (int i=0; i < computerCount; i++) {
	    		allPlayers.add_new_player(new Player("Computer"+i));
	    	}
	    }
		
}
