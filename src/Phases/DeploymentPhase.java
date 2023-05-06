package Phases;

import UI.otherScreens.InformationGiver;
import domain.AllPlayers;
import domain.ArmyCardDeck;
import domain.ArmyPiece;
import domain.Dice;
import domain.Player;
import domain.TerritoryCardDeck;
import domain.ChanceCards.ChanceCardDeck;

public class DeploymentPhase {
	public ArmyCardDeck army_deck;
	public TerritoryCardDeck territory_deck;
	public AllPlayers other_players; //current player is included in this object
	public Player current_player;
	public ArmyPiece the_army_information;
	
	public DeploymentPhase(ArmyCardDeck army_deck,TerritoryCardDeck territory_deck, AllPlayers all_players, Player current_player, ArmyPiece the_army_information) {
		this.other_players=all_players;
		this.army_deck=army_deck;
		this.current_player=current_player;
		this.territory_deck=territory_deck;
		this.the_army_information=the_army_information;
		
		
		
	}
	

	
	public void run() throws InterruptedException {
		// first ask the player if s/he wishes to trade in his/her cards:
		//kart değişim ekranı oluşturman lazım:
		InformationGiver.run("Deployment Phase for the player "+current_player.Player_Name+" has started",1);
		
		int turnly_total_number_of_infantry=0;
		int turnly_total_number_of_cavalyr=0;
		int turnly_total_number_of_artiellry=0;
		
		boolean condition1=false;
		boolean condition2=false;
		boolean condition3=false;
		boolean condition4=false;
		boolean condition5=false;
		
		if (current_player.getArmy_deck().get_number_of_infantry_cards()>=3) {
			condition1=true;
		}
		if (current_player.getArmy_deck().get_number_of_infantry_cards()>=2 && current_player.getArmy_deck().get_number_of_cavalyr_cards()>=1 ) {
			condition2=true;
		}
		if (current_player.getArmy_deck().get_number_of_infantry_cards()>=2 && current_player.getArmy_deck().get_number_of_artillery_cards()>=1) {
			condition3=true;
		}
		if (current_player.getArmy_deck().get_number_of_infantry_cards()>1 && current_player.getArmy_deck().get_number_of_cavalyr_cards()>=2 ) {
			condition4=true;
		}
		if (current_player.getArmy_deck().get_number_of_artillery_cards()>=1 && current_player.getArmy_deck().get_number_of_cavalyr_cards()>=2 ) {
			condition5=true;
		}

		
		if (condition1||condition2||condition3||condition4||condition5 ) {
			int which_one=card_choice_condtion_screen.run(condition1, condition2, condition3, condition4, condition5); // open the selection screen and make player choose
			
			if (which_one==1) {
				turnly_total_number_of_cavalyr=1;
				
			}
			else if (which_one==2) {
				turnly_total_number_of_cavalyr=2;
				
			} 
            else if (which_one==3) {
            	turnly_total_number_of_artiellry=2;
				
			}
            else if (which_one==4) {
            	turnly_total_number_of_cavalyr=1;
            	turnly_total_number_of_artiellry=1;
	
            }
            else if (which_one==5) {
            	turnly_total_number_of_artiellry=3;
            	
            }
			
			
		}
		else {
			InformationGiver.run("cannot trade in army cards this turn due to their unavalibality",2);
			
		}
		
		
		// now deal with territory cards
		int y=this.current_player.getTerritory_deck().get_number_of_territory_cards();
		
		Co
	
		
		
		
		
		
		
		
		
		
		
		
	 
		
		
		
	}

}
