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

import Phases.AttackPhase;
import Phases.RunningMode;
import UI.otherScreens.pause.PauseButton;
import UI.validation.*;
import domain.AllPlayers;
import domain.AllTerritories;
import domain.ArmyPiece;
import domain.Player;
import domain.StartingHandler;
import domain.boolean_singleton;
import domain.gamemap.Continent;
import domain.gamemap.Territory;
import domain.saveLoad.SaveLoadHandler;
import domain.userOperations.CurrentLogins;

public class Main {
	    
	

	
		
		public static void main(String[] args) throws InterruptedException {
			
		
			decideLoadNewGame(); // Via JOptionPane
			
			boolean_singleton our_bool=boolean_singleton.initiate_bool();
			
			while(our_bool.our_boolean) {
				System.out.println("olmadı");
				
			}
			System.out.println("oldu");
			

			
			AllPlayers allPlayers= AllPlayers.createAllPlayers();
			AllTerritories allterr= new AllTerritories();
			
			allterr.add_a_new_territory(Territory.TERRITORY1_1);
			allterr.add_a_new_territory(Territory.TERRITORY1_2);
			allterr.add_a_new_territory(Territory.TERRITORY1_3);
			allterr.add_a_new_territory(Territory.TERRITORY1_4);
			allterr.add_a_new_territory(Territory.TERRITORY1_5);
			allterr.add_a_new_territory(Territory.TERRITORY1_6);
			
			allterr.add_a_new_territory(Territory.TERRITORY2_1);
			allterr.add_a_new_territory(Territory.TERRITORY2_2);
			allterr.add_a_new_territory(Territory.TERRITORY2_3);
			allterr.add_a_new_territory(Territory.TERRITORY2_4);
			allterr.add_a_new_territory(Territory.TERRITORY2_5);
			allterr.add_a_new_territory(Territory.TERRITORY2_6);
			
			allterr.add_a_new_territory(Territory.TERRITORY3_1);
			allterr.add_a_new_territory(Territory.TERRITORY3_2);
			allterr.add_a_new_territory(Territory.TERRITORY3_3);
			allterr.add_a_new_territory(Territory.TERRITORY3_4);
			allterr.add_a_new_territory(Territory.TERRITORY3_5);
			allterr.add_a_new_territory(Territory.TERRITORY3_6);
			
			allterr.add_a_new_territory(Territory.TERRITORY4_1);
			allterr.add_a_new_territory(Territory.TERRITORY4_2);
			allterr.add_a_new_territory(Territory.TERRITORY4_3);
			allterr.add_a_new_territory(Territory.TERRITORY4_4);
			allterr.add_a_new_territory(Territory.TERRITORY4_5);
			allterr.add_a_new_territory(Territory.TERRITORY4_6);
			
			allterr.add_a_new_territory(Territory.TERRITORY5_1);
			allterr.add_a_new_territory(Territory.TERRITORY5_2);
			allterr.add_a_new_territory(Territory.TERRITORY5_3);
			allterr.add_a_new_territory(Territory.TERRITORY5_4);
			allterr.add_a_new_territory(Territory.TERRITORY5_5);
			allterr.add_a_new_territory(Territory.TERRITORY5_6);
			
			allterr.add_a_new_territory(Territory.TERRITORY6_1);
			allterr.add_a_new_territory(Territory.TERRITORY6_2);
			allterr.add_a_new_territory(Territory.TERRITORY6_3);
			allterr.add_a_new_territory(Territory.TERRITORY6_4);
			allterr.add_a_new_territory(Territory.TERRITORY6_5);
			allterr.add_a_new_territory(Territory.TERRITORY6_6);
			
			for (int q=0; q<6; q++) {
				for (int e=0; e<6; e++) {
					if (q==0) {
						allterr.get_the_nth_territory(q*6+e).which_continent=Continent.CONTINENT1;
						
					}
					if (q==1) {
						allterr.get_the_nth_territory(q*6+e).which_continent=Continent.CONTINENT2;
						
					}
					if (q==2) {
						allterr.get_the_nth_territory(q*6+e).which_continent=Continent.CONTINENT3;
						
					}
					if (q==3) {
						allterr.get_the_nth_territory(q*6+e).which_continent=Continent.CONTINENT4;
						
					}
					if (q==4) {
						allterr.get_the_nth_territory(q*6+e).which_continent=Continent.CONTINENT5;
						
					}
					if (q==5) {
						allterr.get_the_nth_territory(q*6+e).which_continent=Continent.CONTINENT6;
						
					}
					
					
				}
			}
			for (int y=0; y<allterr.return_number_of_territories(); y++) {
				
				for (int p=0; p<allPlayers.get_the_number_of_players(); p++) {
					for (int f=0; f<allPlayers.get_the_nth_player(p).get_the_territories_in_control_of_the_player().size(); f++) {
						if (allPlayers.get_the_nth_player(p).get_the_territories_in_control_of_the_player().get(f).name().equals(allterr.get_the_nth_territory(y))) {
							allterr.get_the_nth_territory(y).setTerritoryOwner(allPlayers.get_the_nth_player(p));
							
						}
					}
				}
			}
			ArmyPiece armyPiece=ArmyPiece.ArmyPiece_initiation();
			RunningMode running_mode= new RunningMode(allPlayers,allterr,armyPiece);
		
			try {
				running_mode.run();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			RunningMode runmode=new RunningMode(allPlayers,allterr,  armyPiece );
			runmode.run();
		}
		
		
		
		private static void decideLoadNewGame() {
			SaveLoadHandler handler = SaveLoadHandler.getHandler();
	        // Display the option dialog
	        String[] options = {"Load Last Game", "Start New Game"};
	        int choice = JOptionPane.showOptionDialog(null, "Choose an option:", "ConKUeror",
	                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
	        
	        boolean success = false;
	        // Process the user's choice
	        if (choice == 0) {
	            // User chose to load an existing game
	            success = handler.loadGame();
	        } else if (!success || choice==1) {
	            // User chose to start a new game
	            startNewGame();
	        }
	        

			
		}


		private static void startNewGame() {
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
