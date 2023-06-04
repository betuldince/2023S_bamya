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
import Phases.RunningMode;
import UI.otherScreens.pause.PauseButton;
import UI.validation.*;
import domain.AllPlayers;
import domain.AllTerritories;
import domain.ArmyPiece;
import domain.Player;
import domain.StartingHandler;
import domain.gamemap.GameMap;
import domain.userOperations.CurrentLogins;

public class Main {

	
		
		public static void main(String[] args) throws InterruptedException {
			//to test attackphase related methods
			AllPlayers ordered_all_players=AllPlayers.createAllPlayers();
			AllTerritories AllTerritories= new AllTerritories();
			
			Player player1= new Player("melih");
			Player player2= new Player("begüm");
			
			ordered_all_players.add_new_player(player1);
			ordered_all_players.add_new_player(player2);
			
			GameMap map=GameMap.Map_initiation();
			AllTerritories.add_a_new_territory(GameMap.territory1_1);
			AllTerritories.add_a_new_territory(GameMap.territory1_2);
			AllTerritories.add_a_new_territory(GameMap.territory1_3);
			AllTerritories.add_a_new_territory(GameMap.territory1_4);
			AllTerritories.add_a_new_territory(GameMap.territory1_5);
			AllTerritories.add_a_new_territory(GameMap.territory1_6);
			
			AllTerritories.add_a_new_territory(GameMap.territory2_1);
			AllTerritories.add_a_new_territory(GameMap.territory2_2);
			AllTerritories.add_a_new_territory(GameMap.territory2_3);
			AllTerritories.add_a_new_territory(GameMap.territory2_4);
			AllTerritories.add_a_new_territory(GameMap.territory2_5);
			AllTerritories.add_a_new_territory(GameMap.territory2_6);
			
			AllTerritories.add_a_new_territory(GameMap.territory3_1);
			AllTerritories.add_a_new_territory(GameMap.territory3_2);
			AllTerritories.add_a_new_territory(GameMap.territory3_3);
			AllTerritories.add_a_new_territory(GameMap.territory3_4);
			AllTerritories.add_a_new_territory(GameMap.territory3_5);
			AllTerritories.add_a_new_territory(GameMap.territory3_6);
			
			AllTerritories.add_a_new_territory(GameMap.territory4_1);
			AllTerritories.add_a_new_territory(GameMap.territory4_2);
			AllTerritories.add_a_new_territory(GameMap.territory4_3);
			AllTerritories.add_a_new_territory(GameMap.territory4_4);
			AllTerritories.add_a_new_territory(GameMap.territory4_5);
			AllTerritories.add_a_new_territory(GameMap.territory4_6);
			
			AllTerritories.add_a_new_territory(GameMap.territory5_1);
			AllTerritories.add_a_new_territory(GameMap.territory5_2);
			AllTerritories.add_a_new_territory(GameMap.territory5_3);
			AllTerritories.add_a_new_territory(GameMap.territory5_4);
			AllTerritories.add_a_new_territory(GameMap.territory5_5);
			AllTerritories.add_a_new_territory(GameMap.territory5_6);
			
			AllTerritories.add_a_new_territory(GameMap.territory6_1);
			AllTerritories.add_a_new_territory(GameMap.territory6_2);
			AllTerritories.add_a_new_territory(GameMap.territory6_3);
			AllTerritories.add_a_new_territory(GameMap.territory6_4);
			AllTerritories.add_a_new_territory(GameMap.territory6_5);
			AllTerritories.add_a_new_territory(GameMap.territory6_6);
			
			ArmyPiece army=ArmyPiece.ArmyPiece_initiation();
			
			for (int a=0; a<18; a++) {
				player1.add_territory(AllTerritories.get_the_nth_territory(a));
				army.addNewTerritoryArmy(AllTerritories.get_the_nth_territory(a), "Infantry", 1);
				army.addNewPlayerArmy(player1, "Infantry", 1);
				
			}
			for (int a=0; a<18; a++) {
				player2.add_territory(AllTerritories.get_the_nth_territory(a+18));
				army.addNewTerritoryArmy(AllTerritories.get_the_nth_territory(a+18), "Infantry", 1);
				army.addNewPlayerArmy(player2, "Infantry", 1);
				
			}
			
			RunningMode game=new RunningMode(ordered_all_players, AllTerritories);
			game.run();
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			

			AttackPhase attack= new AttackPhase();
			attack.run();
			

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
