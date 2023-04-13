package Phases;

import java.util.Random;

import domain.AllPlayers;
import domain.ArmyCard;
import domain.ArmyCardDeck;
import domain.ChanceCard;
import domain.ChanceCardDeck;
import domain.Player;
import domain.TerritoryCard;
import domain.TerritoryCardDeck;

public class TerritoryArmyCardPhase {
	public ArmyCardDeck army_deck;
	public TerritoryCardDeck territory_deck;
	public AllPlayers other_players; //current player is included in this object
	public Player current_player;
	
	public TerritoryArmyCardPhase(ArmyCardDeck army_deck,TerritoryCardDeck territory_deck, AllPlayers all_players, Player current_player) {
		this.other_players=all_players;
		this.army_deck=army_deck;
		this.current_player=current_player;
		this.territory_deck=territory_deck;
		
		
		
	}
	public int run() {
		int number_of_army_cards_left=this.army_deck.get_number_of_army_cards();
		int number_of_territory_cards_left=this.territory_deck.get_number_of_territory_cards();
		
		int total_number=number_of_army_cards_left+number_of_territory_cards_left;
		
		if (total_number==0) { // there are not adequate cards left: All cards from the players must be collected into their respective decks
			
			
			
			
			
			
			
			number_of_army_cards_left=this.army_deck.get_number_of_army_cards();
			number_of_territory_cards_left=this.territory_deck.get_number_of_territory_cards();
			
		    total_number=number_of_army_cards_left+number_of_territory_cards_left;
		}
		// continue the normal procedures
        Random rn = new Random();
		
		int random=rn.nextInt(total_number);
		

		
		if (random<=number_of_army_cards_left-1) {
			 ArmyCard the_card_chosen1= (ArmyCard) this.army_deck.get_nth_card(random);
			 this.current_player.getArmy_deck().add_new_army_card(the_card_chosen1);
			
		}
		else {
			TerritoryCard the_card_chosen2= this.territory_deck.get_nth_card(random-number_of_territory_cards_left);
			this.current_player.getTerritory_deck().add_new_territory_card(the_card_chosen2);
			
		}
		// successfully added the card now do other reamaning things

			
	
		
		
		
		
		
		
		
		return 1; // 1 means phase is complete with SUCCESS code.
		
	}

}
