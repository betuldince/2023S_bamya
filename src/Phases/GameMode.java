package Phases;

import UI.otherScreens.InformationGiver;
import domain.AllPlayers;
import domain.AllTerritories;
import domain.ArmyCard;
import domain.ArmyCardDeck;
import domain.ArmyPiece;
import domain.Dice;
import domain.Player;
import domain.TerritoryCard;
import domain.TerritoryCardDeck;
import domain.ChanceCards.AllianceChanceCard;
import domain.ChanceCards.ChanceCardDeck;
import domain.ChanceCards.ReinforcementsChanceCard;
import domain.ChanceCards.SabotageChanceCard;

// this class should come after the build mode is done. 
public class GameMode {
	AllPlayers all_players=null;
	Dice our_dice=null;
	AllTerritories all_territories=null;
	ArmyPiece army_information=null;
	
	public GameMode(AllPlayers all_players,AllTerritories all_territories, ArmyPiece army_information ) {
		our_dice=Dice.Dice_initiation(6,1);
		this.all_players=all_players;
		this.all_territories=all_territories;
		this.army_information=army_information;
		
		
		
	}
	
	
	
	
	
	public void run() throws InterruptedException {
		// iniate the chance card deck, add the new chance cards below,
		ChanceCardDeck our_chance_card_deck=new ChanceCardDeck();
		our_chance_card_deck.add_new_chance_card(new AllianceChanceCard());
		our_chance_card_deck.add_new_chance_card(new ReinforcementsChanceCard());
		our_chance_card_deck.add_new_chance_card(new SabotageChanceCard());
		//...
		
		
		// now initiate all territories
	    AllTerritories our_all_territories=all_territories;
	    //
		
		
		// now initiate the territory card deck
		TerritoryCardDeck our_territory_card_deck=new TerritoryCardDeck();
		int a=our_all_territories.return_number_of_territories();
		for (int i=0; i<a; i++) {
			our_territory_card_deck.add_new_territory_card(new TerritoryCard(our_all_territories.get_the_nth_territory(i)));
			
		}
		
		
		// now initiate the army card deck
		ArmyCardDeck our_army_card_deck=new ArmyCardDeck();
		int number_of_players=this.all_players.get_the_number_of_players();
		for (int i1=0; i1<number_of_players; i1++) {
			our_army_card_deck.add_new_army_card(new ArmyCard("Artillery"));
		}
		for (int i2=0; i2<2*number_of_players; i2++) {
			our_army_card_deck.add_new_army_card(new ArmyCard("Cavalry"));
		}
		for (int i3=0; i3<3*number_of_players; i3++) {
			our_army_card_deck.add_new_army_card(new ArmyCard("Infantry"));
		}
		
		
		
		
		
		
		Player the_winner=null;
		
		while (the_winner==null) {
			// the turn ordering of players is determined by the ordering of players in the class AllPlayers
			SingleTurnCompleter a_new_turn= new SingleTurnCompleter();
			the_winner=SingleTurnCompleter.run(this.all_players, our_chance_card_deck, our_all_territories, our_territory_card_deck, our_army_card_deck,army_information);
		}
		// when the while loop becomes completed the_winner will point to the player who won
		InformationGiver.run("The games is won by "+the_winner.Player_Name,3);

		
		
		
		
		
		
		
		
		
		
		
	}

}
