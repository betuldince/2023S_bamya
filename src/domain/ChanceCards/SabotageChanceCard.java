package domain.ChanceCards;

import UI.user_input_taker.UserInputTaker;
import domain.AllPlayers;
import domain.Dice;
import domain.Player;
import domain.gamemap.Territory;

public class SabotageChanceCard extends ChanceCard {
	
	
	public SabotageChanceCard() {
		super("Alliance");
		this.further_action_is_required=true;
		
	}
	public void run(AllPlayers other_players, Player current_player, Dice our_dice) {
		Player player_to_get_sabotaged=null;
		while (player_to_get_sabotaged==null) {
			
			UserInputTaker input_screen=new UserInputTaker();
    		input_screen.run("Enter the name of the player of whom territory you want to sabotage");
    		String the_input=input_screen.get_input();
    		player_to_get_sabotaged=other_players.return_the_player_with_name(the_input);
    		
    		input_screen.run("the name of territories of chosen player are as follows");
    		String uu="";
    		for (int h=0; h<player_to_get_sabotaged.get_the_territories_in_control_of_the_player().size();h++) {
    			uu.concat(player_to_get_sabotaged.get_the_territories_in_control_of_the_player().get(h).get_territory_name());
    			uu.concat(" ");
    			
    		}
    		input_screen.run(uu);
 
    		
    	
		}
        Territory to_be_sabatoged=null;
        
        while (to_be_sabatoged==null) {
        	UserInputTaker input_screen=new UserInputTaker();
    		input_screen.run("Enter the name of the territory you want to sabotage");
    		String the_input=input_screen.get_input();
    		to_be_sabatoged=current_player.get_the_territory_with_the_name(the_input);
        	
        }
		
		// roll the dice
	    int number_of_soldiers_to_be_reduced=our_dice.roll_one_dice();
	    
	    if (number_of_soldiers_to_be_reduced>=to_be_sabatoged.getNumberOfUnits()) {
	    	to_be_sabatoged.updateNumberofUnits(1);
	    }
	    else {
	    	to_be_sabatoged.addNumberofUnits(-number_of_soldiers_to_be_reduced);
	    }
	    

	
		
	}

}
