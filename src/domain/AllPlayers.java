package domain;

import java.util.ArrayList;

public class AllPlayers {
	
public ArrayList<Player> all_players;
	
	public AllPlayers() {
		all_players=new ArrayList<Player>();	
		
	}
	public void add_new_chance_card(Player newPlayer) {
		all_players.add(newPlayer);
		
	}
	public Player return_the_player_with_name(String name) {
		Player to_be_returned=null;
		int n=all_players.size();
		for (int a=0; a<n; a++) {
			
			
			if (this.all_players.get(a).Player_Name.compareTo(name)==0) {
				to_be_returned=this.all_players.get(a);
				break;
				
				
			}
		}
		return to_be_returned;
	}

}
