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

}
