package domain.initArmyTerritory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import Phases.AttackPhase;
import Phases.RunningMode;
import UI.gamemap.WorldMap;
import UI.otherScreens.NextPhasePopUpWindow;
import domain.AllPlayers;
import domain.AllTerritories;
import domain.ArmyPiece;
import domain.Player;
import domain.gamemap.GameMap;
import domain.gamemap.GameMapListener;
import domain.gamemap.Territory;

public class InitArmyTerritoryHandler implements GameMapListener{
	public static GameMap gameMap;

	private static int totalPlayerCount;
	
	ArmyPiece armyPiece = ArmyPiece.ArmyPiece_initiation();
	
	private int turnIndex = 0; //in order to keep track of turns while deploying army
	
	//InitArmyTerritoryHandler IATHandler = InitArmyTerritoryHandler.createArmyTerHandler(gameMap);
	
	//singleton pattern
	private static InitArmyTerritoryHandler ArmyTerHandler=null;
	private InitArmyTerritoryHandler(GameMap map) {
		InitArmyTerritoryHandler.gameMap = gameMap;
		InitArmyTerritoryHandler.totalPlayerCount = AllPlayers.playerNum();
	}
	public static InitArmyTerritoryHandler createArmyTerHandler(GameMap map) {
		if (ArmyTerHandler == null) {
			ArmyTerHandler = new InitArmyTerritoryHandler(map);
		}
		return ArmyTerHandler;
	}
	
	//method to calculate how many army pieces to distribute
	public int calculateInitialArmy(int totalPlayerCount) {
		
		switch (totalPlayerCount) {
			case 2: return 2; 
			case 3: return 35; 
			case 4: return 30; 
			case 5: return 25; 
			case 6: return 20; 
		}
		
		return -1;
	}
	
	
	
	public void distributeInitialArmy(ArrayList<Player> ordered_players) {
		// TODO Auto-generated method stub
		int initArmyNum = calculateInitialArmy(totalPlayerCount);
		System.out.println("Initial Army Number: " + initArmyNum);
		
		for(Player p : ordered_players) {
			
			armyPiece.addNewPlayerArmy(p, "infantry", initArmyNum);
			
			System.out.println("Player " + p.Player_Name + " gained " + armyPiece.getArmyNumber(p) + " many army" );
		}
		
	}
	
	@Override
	public void nextTurn(Territory t) {
		// TODO Auto-generated method stub
		
		WorldMap.frame.dispose(); //closing previous map
		
		ArrayList<Player> ordered_players = AllPlayers.ordered_all_players;
		int lastPlayerIndex = ordered_players.size() -1;
		Player lastPlayer = ordered_players.get(lastPlayerIndex);
		HashMap<String, Integer> map = armyPiece.getArmyNumber(lastPlayer);
		int lastPlayerInfantryCount = map.get("infantry");
		System.out.println("last player infantry count: " + lastPlayerInfantryCount);
		
		int queueSize = ordered_players.size() ; //in order to get modulus
		turnIndex = turnIndex % queueSize;
		
		//if player's turn is completed then it's next player's turn, if not same player repeats
		boolean turnCompleted = completeTurn(ordered_players.get(turnIndex), t, armyPiece);
		
		if(turnCompleted) {
			turnIndex++;
			turnIndex = turnIndex % queueSize; //just to be safe
		}
		
		
		if(lastPlayerInfantryCount != 0) { //this phase goes on until the last player has 0 army piece
			WorldMap.InitiateArmyTerritoryMap(gameMap, this, ordered_players.get(turnIndex));
		} else {
			NextPhasePopUpWindow nxtPhase = new NextPhasePopUpWindow();
			nxtPhase.createNextPhasePopUp(this);
		}
		
	}
	
	
	//method checks is if the selected territory is valid (unoccupied or occupied by user)
	// if it returns true then turn will continue from next user
	// if it returns false then user's turn will repeat until they choose valid territory
	public boolean completeTurn(Player p, Territory t, ArmyPiece ap) {
		
		boolean b;
		
		if(t.getTerritoryOwner() == p) {
			ap.updateArmyNumber(t, 1,  "infantry"); //increases number of troops in territory
			ap.updateArmyNumber(p, -1, "infantry"); //decreases number of troops in player
			
			b = true;
			System.out.println(ap.getArmyNumber(t));
			System.out.println(ap.getArmyNumber(p));
			
		} else if (t.getTerritoryOwner() == null) {
			p.add_territory(t);
			t.setTerritoryOwner(p);
			ap.updateArmyNumber(t, 1,"infantry"); //increases number of troops in territory
			ap.updateArmyNumber(p, -1, "infantry"); //decreases number of troops in player
			System.out.println(ap.getArmyNumber(t));
			System.out.println(ap.getArmyNumber(p));
			
			
			b = true; 
		} else {
			b = false;
		}
		
		return b;
	}
	
	
	@Override
	public void nextPhase() {
		// TODO Auto-generated method stub
		System.out.println("next phase btn clicked");
		AllPlayers allPlayers= AllPlayers.createAllPlayers();
		AllTerritories allterr= new AllTerritories();
		for (int i=0; i<allPlayers.get_the_number_of_players(); i++) {
			Iterator<Territory> territoryIterator= allPlayers.get_the_nth_player(i).get_the_territories_in_control_of_the_player().iterator();
			Territory currTerritory;
			while (territoryIterator.hasNext()) {
				currTerritory=territoryIterator.next();
				allterr.add_a_new_territory(currTerritory);
			}
			
		}
		ArmyPiece armyPiece=ArmyPiece.ArmyPiece_initiation();
		RunningMode running_mode= new RunningMode(allPlayers,allterr,armyPiece);
		
		try {
			running_mode.run();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	
	
	
	
	

}
