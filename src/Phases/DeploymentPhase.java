package Phases;

import domain.AllPlayers;
import domain.Dice;
import domain.Player;
import domain.ChanceCards.ChanceCardDeck;

public class DeploymentPhase {
	public ChanceCardDeck chance_card_deck;
	public AllPlayers other_players; //current player is included in this object
	public Player current_player;
	public Dice our_dice;
	
	public DeploymentPhase(ChanceCardDeck chance_card_deck, AllPlayers all_players, Player current_player) {
		this.other_players=all_players;
		this.chance_card_deck=chance_card_deck;
		this.current_player=current_player;
		
		
		
	}
	

	
	public void run() {
		// first ask the player if s/he wishes to trade in his/her cards:
		//kart değişim ekranı oluşturman lazım:
		
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
		
	 
		
		
		
	}

}
