package Phases;

import java.util.ArrayList;
import java.util.Random;

import domain.AllPlayers;
import domain.ChanceCard;
import domain.ChanceCardDeck;
import domain.Player;

public class ChanceCardPhase {
	public ChanceCardDeck chance_card_deck;
	public AllPlayers other_players; //current player is included in this object
	public Player current_player;
	
	public ChanceCardPhase(ChanceCardDeck chance_card_deck, AllPlayers all_players, Player current_player) {
		this.other_players=all_players;
		this.chance_card_deck=chance_card_deck;
		this.current_player=current_player;
		
		
		
	}
	public int run() {
		int n=this.chance_card_deck.get_number_of_chance_cards();
		
		Random rn = new Random();
		
		int random=rn.nextInt(n);
		ChanceCard our_chance_card=this.chance_card_deck.get_nth_card(random);
		
		boolean alfa=our_chance_card.isFurther_action_is_required();
		
		if (alfa) {
			// now take the user input
			
		}
		else {
			// no need for user input
			
		}
		
		
		
		
		
		return 1; // 1 means phase is complete with SUCCESS code.
		
	}
	

}
