package domain.ChanceCards;
import java.util.Random;

import UI.user_input_taker.UserInputTaker;
import domain.AllPlayers;
import domain.Dice;
import domain.Player;
import domain.gamemap.Territory;

public class SecretWeapon extends ChanceCard {
	public SecretWeapon() {
		super("SecretWeapon");
		this.further_action_is_required=true;
		
	}
	
	
	public void run(AllPlayers other_players, Player current_player, Dice our_dice) {
		
       
		// roll the dice
		int number_of_soldiers_to_be_added=our_dice.roll_one_dice();
		


		// take the user input for the name of the territory	
        Player player_to_be_seen=null;
        
        int n=other_players.get_the_number_of_players();
        n--;
        
        Random rn = new Random();
        int answer = rn.nextInt(10) 
        
        
       
        	UserInputTaker input_screen=new UserInputTaker();
    		input_screen.run("Enter the name of the territory you want to reinforce troops with");
    		String the_input=input_screen.get_input();
        	to_be_reinforced_with=current_player.get_the_territory_with_the_name(the_input);
        	
        
        to_be_reinforced_with.addNumberofUnits(number_of_soldiers_to_be_added);
        
        
		
		
	}

}
