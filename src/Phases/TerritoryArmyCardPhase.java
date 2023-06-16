package Phases;

import java.util.Random;

import UI.otherScreens.InformationGiver;
import domain.AllPlayers;
import domain.ArmyCard;
import domain.ArmyCardDeck;
import domain.Player;
import domain.TerritoryCard;
import domain.TerritoryCardDeck;
import domain.ChanceCards.ChanceCard;
import domain.ChanceCards.ChanceCardDeck;

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
	public int run() throws InterruptedException {
		InformationGiver.run("Territory/Army Card Phase for the player "+current_player.Player_Name+" has started",1);
		int number_of_army_cards_left=this.army_deck.get_number_of_army_cards();
		int number_of_territory_cards_left=this.territory_deck.get_number_of_territory_cards();
		
		int total_number=number_of_army_cards_left+number_of_territory_cards_left;
		
		if (total_number==0) { // there are not adequate cards left: All cards from the players must be collected into their respective decks
			int player_number=other_players.get_the_number_of_players();
			for (int j=0; j<player_number; j++) {
				int number_of_army_cards=other_players.get_the_nth_player(j).getArmy_deck().get_number_of_army_cards();
				for (int u1=0; u1<number_of_army_cards; u1++) {
					this.army_deck.add_new_army_card(this.other_players.get_the_nth_player(j).getArmy_deck().delete_last_card());    
					
					
				
				}
				int number_of_territory_cards=other_players.get_the_nth_player(j).getTerritory_deck().get_number_of_territory_cards();
				for (int u2=0; u2<number_of_territory_cards; u2++) {
					this.territory_deck.add_new_territory_card(this.other_players.get_the_nth_player(j).getTerritory_deck().delete_last_card());  
					
				}
			}

		}
		// continue the normal procedures
        Random rn = new Random();
        
        for (int j=0; j<5; j++) {
        	int random=rn.nextInt(total_number);
    		

    		
    		if (random<=number_of_army_cards_left-1) {
    			 ArmyCard the_card_chosen1= (ArmyCard) this.army_deck.delete_nth_card(random);
    			 the_card_chosen1.change(this.current_player);
    			 this.current_player.getArmy_deck().add_new_army_card(the_card_chosen1);
    			 InformationGiver.run("Army Card assigned is "+the_card_chosen1.get_card_type(),1);
    		
    			 
    			
    		}
    		else {
    			TerritoryCard the_card_chosen2= this.territory_deck.delete_nth_card(random-number_of_territory_cards_left);
    			the_card_chosen2.assign_owner(this.current_player);
    			InformationGiver.run("Territory Card assigned is"+ the_card_chosen2.which_territory.get_territory_name() ,1);
    			this.current_player.getTerritory_deck().add_new_territory_card(the_card_chosen2);
    			
    		}
        	
        }
		
		
		// successfully added the card now do other reamaning things if there are any
		

			
	
		
		
		
		
		
		
		
		return 1; // 1 means phase is complete with SUCCESS code.
		
	}

}
