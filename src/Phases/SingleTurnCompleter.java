package Phases;

import UI.otherScreens.InformationGiver;
import domain.AllPlayers;
import domain.AllTerritories;
import domain.ArmyCardDeck;
import domain.ArmyPiece;
import domain.Player;
import domain.TerritoryCardDeck;
import domain.ChanceCards.ChanceCardDeck;

public class SingleTurnCompleter {
	
	
	public static Player run(AllPlayers all_players, ChanceCardDeck our_chance_card_deck, AllTerritories our_all_territories, TerritoryCardDeck our_territory_card_deck, ArmyCardDeck our_army_card_deck, ArmyPiece army_information) throws InterruptedException {
		Player condition=null;  //if the condition is still null this means no player has won the game yet
		
		int number_of_players=all_players.get_the_number_of_players();
		for (int a=0; a<number_of_players; a++) {
			
			Player current_player=all_players.get_the_nth_player(a);

			// dice null o hatayı düzelt
			ChanceCardPhase our_chance_card_phase=new ChanceCardPhase(our_chance_card_deck,all_players, current_player);
			//our_chance_card_phase.run();
			
			System.out.println("geldik buraya**************************2");
			boolean next_phase=true;
			DeploymentPhase our_deployment_phase=new DeploymentPhase(our_army_card_deck, our_territory_card_deck, all_players, current_player, army_information,our_all_territories );
			our_deployment_phase.run(next_phase);
			
			while (next_phase) {
				
			}
			    
				AttackPhase attackPhaseHandler =AttackPhase.GetAttackPhaseHandler();
				attackPhaseHandler.setThread(true);
				attackPhaseHandler.setAttacker(current_player);
				attackPhaseHandler.decideAttackAgain();
				while (attackPhaseHandler.getThread()) {
					
				}
			
				
				// now we will check the winning condition: i.e. if the territories this player has corresponds to all territories we game is won by this player
				int number_of_all_territories=our_all_territories.return_number_of_territories();
				int number_of_territories_in_control_of_the_player=current_player.get_the_territories_in_control_of_the_player().size();
				if (number_of_all_territories==number_of_territories_in_control_of_the_player) {
					return current_player; // return the winner
				}
				
				
				
				
				TerritoryArmyCardPhase our_territory_army_card_phase=new TerritoryArmyCardPhase(our_army_card_deck, our_territory_card_deck, all_players, current_player);
				our_territory_army_card_phase.run();
				
			
			
			
			
	
			
		}
		return condition;
	}

}








