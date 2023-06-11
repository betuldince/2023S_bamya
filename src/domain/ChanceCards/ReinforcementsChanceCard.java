package domain.ChanceCards;
import UI.user_input_taker.UserInputTaker;
import domain.AllPlayers;
import domain.Dice;
import domain.Player;
import domain.gamemap.Territory;

public class ReinforcementsChanceCard extends ChanceCard {
	public ReinforcementsChanceCard() {
		super("Reinforcements");
		this.further_action_is_required=true;
		
	}
	
	
	public void run(AllPlayers other_players, Player current_player, Dice our_dice) {
		
       
		// roll the dice
		int number_of_soldiers_to_be_added=our_dice.roll_one_dice();
		UserInputTaker input_screen1=new UserInputTaker();
		input_screen1.run("you will be reinforcing your chosen territory with the following number of infantry"+Integer.toString(number_of_soldiers_to_be_added) );
		


		// take the user input for the name of the territory	
        Territory to_be_reinforced_with=null;
        
        while (to_be_reinforced_with==null) {
        	UserInputTaker input_screen=new UserInputTaker();
    		input_screen.run("Enter the name of the territory you want to reinforce troops with");
    		
    		input_screen.run("the name of territories of yours are as follows");
    		String uu="";
    		for (int h=0; h<current_player.get_the_territories_in_control_of_the_player().size();h++) {
    			uu.concat(current_player.get_the_territories_in_control_of_the_player().get(h).get_territory_name());
    			uu.concat(" ");
    			
    		}
    		input_screen.run(uu);
    		String the_input=input_screen.get_input();
        	to_be_reinforced_with=current_player.get_the_territory_with_the_name(the_input);
        	
        }
        to_be_reinforced_with.addNumberofUnits(number_of_soldiers_to_be_added);
        
        
		
		
	}

}
