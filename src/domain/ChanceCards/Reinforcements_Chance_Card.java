package domain.ChanceCards;
import UI.user_input_taker.UserInputTaker;
import domain.AllPlayers;
import domain.Dice;
import domain.Player;

public class Reinforcements_Chance_Card extends ChanceCard {
	public Reinforcements_Chance_Card() {
		super("Reinforcements");
		this.further_action_is_required=true;
		
	}
	
	
	
	public void run(AllPlayers other_players, Player current_player, Dice our_dice) {
		
       
		// roll the dice
		int number_of_soldiers_to_be_added=our_dice.roll_one_dice();
		
	
		
		UserInputTaker input_screen=new UserInputTaker();
		input_screen.run("Enter the name of the territory you want to reinforce troops with");
		String the_input=input_screen.get_input();
		


		int n=current_player.Territories_possesed.size();
		for (int i=0; i<n; i++) {
			if (current_player.Territories_possesed.get(i).territoryName.equals(the_input)) {
				current_player.Territories_possesed.get(i).addNumberofUnits(number_of_soldiers_to_be_added);
				break;
				
				
			}
		}
		
		
	}

}
