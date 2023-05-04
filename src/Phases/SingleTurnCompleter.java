package Phases;

import domain.AllPlayers;
import domain.AllTerritories;
import domain.ArmyCardDeck;
import domain.Player;
import domain.TerritoryCardDeck;
import domain.ChanceCards.ChanceCardDeck;

public class SingleTurnCompleter {
	
	public boolean run(AllPlayers all_players, ChanceCardDeck our_chance_card_deck, AllTerritories our_all_territories, TerritoryCardDeck our_territory_card_deck, ArmyCardDeck our_army_card_deck) {
		boolean condition=true;  // make the condition false if one of the players wins in this turn
		
		int number_of_players=all_players.get_the_number_of_players();
		for (int a=0; a<number_of_players; a++) {
			Player current_player=all_players.get_the_nth_player(a);
			
			
			
			
		}
		
	
		
	
		
		
		
		return condition;
	}

}








