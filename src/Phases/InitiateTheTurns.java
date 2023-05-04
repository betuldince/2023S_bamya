package Phases;

import domain.AllPlayers;
import domain.ArmyCardDeck;
import domain.Dice;
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
		our_dice=Dice.Dice_initiation(6,6);
		this.all_players=all_players;
		
		
		
	}
	
	
	
	
	
	public void run() {
		// iniate the chance card deck, add the new chance cards below,
		ChanceCardDeck our_chance_card_deck=new ChanceCardDeck();
		our_chance_card_deck.add_new_chance_card(new AllianceChanceCard());
		our_chance_card_deck.add_new_chance_card(new ReinforcementsChanceCard());
		our_chance_card_deck.add_new_chance_card(new SabotageChanceCard());
		//...
		
		
		// now initiate the territory card deck
		TerritoryCardDeck our_territory_card_deck=new TerritoryCardDeck();
		//...
		
		
		// now initiate the army card deck
		ArmyCardDeck our_army_card_deck=new ArmyCardDeck();
		//...
		
		
		
		boolean condition=true;
		
		while (condition) {
			SingleTurnCompleter a_new_turn= new SingleTurnCompleter();
			a_new_turn.run();
			
			
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
