package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import domain.buildingmode.BuildingModeHandler;
import domain.userOperations.CurrentLogins;

public class AllPlayers {
	
public static ArrayList<Player> all_players;
public static ArrayList<Player> ordered_all_players; //ordered by makeTurn method
	
	
	public void add_new_player(Player newPlayer) {
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
	
	public int get_the_number_of_players() {
		return this.all_players.size();
	}
	public Player get_the_nth_player(int n) {
		return this.all_players.get(n);
	}
	
	//singleton pattern
	private static AllPlayers allPlayer = null;
	private AllPlayers() {
		all_players=new ArrayList<Player>();	
		ordered_all_players=new ArrayList<Player>();
		
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



	public void createGamePlayers(int computerCount) {
		createPlayers();
		createComputerPlayers(computerCount);
	}
	
    private void createPlayers() {
    	ArrayList<String> currentLogins = CurrentLogins.getCurrentLogins();
    	Iterator<String> nicknames = currentLogins.iterator();
    	while (nicknames.hasNext()) {
    		add_new_player(new Player(nicknames.next()));
    	}
    }
    
    public void createComputerPlayers(int computerCount) {
    	for (int i=0; i < computerCount; i++) {
    		add_new_player(new Player("Computer"+i));
    	}
    }
	
public static ArrayList<Player> makeTurn(ArrayList<Player> playersList) {
		
		
		Map<Player, Integer> diceDict = new HashMap<Player, Integer>();
		
		for (Player p: playersList) {
			diceDict.put(p, p.playerRollsDice());
		}
		
		while (!diceDict.isEmpty()) {
			int max = 0;
			Player tempPlayer = null;
			for (Player p: diceDict.keySet()) {
				if (diceDict.get(p) >= max) {
					max = diceDict.get(p);
					tempPlayer = p;
				}
			}
			ordered_all_players.add(tempPlayer);
			System.out.println(tempPlayer + "added to turn list");
			diceDict.remove(tempPlayer);
			System.out.println(tempPlayer + "is removed from dice dictionary");
		}
		
		return ordered_all_players;
		
	}

}
