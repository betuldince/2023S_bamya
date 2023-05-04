package domain.ChanceCards;

import java.util.Random;

import domain.AllPlayers;
import domain.Dice;
import domain.Player;

public class Reinforcements_Chance_Card extends ChanceCard {
	public Reinforcements_Chance_Card() {
		super("Reinforcements");
		this.further_action_is_required=true;
		
	}
	
	public void run(AllPlayers other_players, Player current_player, Dice our_dice) {
		
        int n=current_player.Territories_possesed.size();
        Random rn = new Random();
        
		// roll the dice
		int number_of_soldiers_to_be_added=our_dice.roll_one_dice();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
		
	}

}
