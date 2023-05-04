package domain.ChanceCards;

import UI.user_input_taker.UserInputTaker;
import domain.AllPlayers;
import domain.Player;

public class AllianceChanceCard extends ChanceCard {

	public AllianceChanceCard() {
		super("Alliance");
		this.further_action_is_required=true;
		
	}
	public void run(AllPlayers other_players, Player current_player) {
		Player alliancer=null;
		while (alliancer==null) {
			UserInputTaker input_screen=new UserInputTaker();
    		input_screen.run("Enter the name of the player you want to make an alliance with");
    		String the_input=input_screen.get_input();
    		if (the_input.compareTo(current_player.Player_Name)!=0) {
    			alliancer=other_players.return_the_player_with_name(the_input);
    			
    		}
    		
    	
		}
		current_player.setWith_whom_we_have_an_alliance(alliancer);
		// this alliance needs to be dealth with in the attacj turn
		
		
		
	
		
	}

}
