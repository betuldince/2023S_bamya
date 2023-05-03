package domain;

import java.util.ArrayList;

import domain.buildingmode.BuildingModeHandler;

public class AllPlayers {
	
public static ArrayList<Player> all_players;
	
	
	public void add_new_chance_card(Player newPlayer) {
		all_players.add(newPlayer);
		
	}
	
	//singleton pattern
	private static AllPlayers allPlayer = null;
	private AllPlayers() {
		all_players=new ArrayList<Player>();	
		
	}
	public static AllPlayers createAllPlayers() {
		if (allPlayer == null) {
			allPlayer = new AllPlayers();
		}
		return allPlayer;
	}
	
	public static int playerNum() {
		return all_players.size();
	}
	

}
