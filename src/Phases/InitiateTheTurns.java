package Phases;

import domain.AllPlayers;
import domain.AllTerritories;
import domain.ArmyCardDeck;
import domain.Dice;
import domain.Player;
import domain.TerritoryCard;
import domain.TerritoryCardDeck;
import domain.ChanceCards.AllianceChanceCard;
import domain.ChanceCards.ChanceCardDeck;
import domain.ChanceCards.ReinforcementsChanceCard;
import domain.ChanceCards.SabotageChanceCard;

// this class should come after the build mode is done. 
public class InitiateTheTurns {
	AllPlayers all_players=null;
	Dice our_dice=null;
	
	public InitiateTheTurns(AllPlayers all_players) {
		our_dice=Dice.Dice_initiation(6);
		this.all_players=all_players;
		
		
		
	}
	
	
	
	
	
	public void run() {
		// iniate the chance card deck, add the new chance cards below,
		ChanceCardDeck our_chance_card_deck=new ChanceCardDeck();
		our_chance_card_deck.add_new_chance_card(new AllianceChanceCard());
		our_chance_card_deck.add_new_chance_card(new ReinforcementsChanceCard());
		our_chance_card_deck.add_new_chance_card(new SabotageChanceCard());
		//...
		
		
		// now initiate all territories
	    AllTerritories our_all_territories=new AllTerritories();
	    //...
		
		
		// now initiate the territory card deck
		TerritoryCardDeck our_territory_card_deck=new TerritoryCardDeck();
		int a=our_all_territories.return_number_of_territories();
		for (int i=0; i<a; i++) {
			our_territory_card_deck.add_new_territory_card(new TerritoryCard(our_all_territories.get_the_nth_territory(i)));
			
		}
		
		
		// now initiate the army card deck
		ArmyCardDeck our_army_card_deck=new ArmyCardDeck();
		//...
		
		
		
		
		
		
		Player the_winner=null;
		
		while (the_winner==null) {
			// the turn ordering of players is determined by the ordering of players in the class AllPlayers
			SingleTurnCompleter a_new_turn= new SingleTurnCompleter();
			the_winner=a_new_turn.run(this.all_players, our_chance_card_deck, our_all_territories, our_territory_card_deck, our_army_card_deck);
		}
		// when the while loop becomes completed the_winner will point to the player who won

		
		
		
		
		
		
		
		
		
		
		
	}

}
