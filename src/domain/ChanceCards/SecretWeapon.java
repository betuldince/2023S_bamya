package domain.ChanceCards;
import java.util.Random;

import UI.otherScreens.InformationGiver;
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
	
	
	public void run(AllPlayers other_players, Player current_player, Dice our_dice) throws InterruptedException {
		

		


		// take the user input for the name of the territory	
        Player player_to_be_seen=null;
        
        int n=other_players.get_the_number_of_players();
        n--;
        
        Random rn = new Random();
        int answer = rn.nextInt(n);
        
        if (other_players.get_the_nth_player(answer)!=current_player) {
        	player_to_be_seen=other_players.get_the_nth_player(answer);
        	
        }
        else {
        	player_to_be_seen=other_players.get_the_nth_player(answer+1);
        	
        }
        InformationGiver.run("Opponent chosen is "+player_to_be_seen.Player_Name,1);
        
        for (int u=0; u<player_to_be_seen.getArmy_deck().get_number_of_army_cards(); u++) {
        	InformationGiver.run("the player has the army card "+player_to_be_seen.getArmy_deck().get_nth_card(u).get_card_type(),1);
        	
        }
        
        
        
   
        
        
		
		
	}

}
