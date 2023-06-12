package domain.ChanceCards;

import java.util.ArrayList;

import domain.AllPlayers;
import domain.Dice;
import domain.Player;

public class ChanceCard {
	private String card_name;  
	protected boolean further_action_is_required;

	public boolean isFurther_action_is_required() {
		return further_action_is_required;
	}

	public void setFurther_action_is_required(boolean further_action_is_required) {
		this.further_action_is_required = further_action_is_required;
	}
	
	public ChanceCard(String card_name) {
		this.card_name=card_name;
			
		
	}
    public void run(AllPlayers other_players, Player current_player, Dice our_dice) throws InterruptedException {
		
		
	}
    public String get_the_name() {
    	return this.card_name;
    }

}
