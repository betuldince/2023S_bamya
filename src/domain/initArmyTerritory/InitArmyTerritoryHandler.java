package domain.initArmyTerritory;

import java.util.ArrayList;
import java.util.HashMap;

import UI.gamemap.WorldMap;
import domain.AllPlayers;
import domain.ArmyPiece;
import domain.Player;
import domain.gamemap.GameMap;
import domain.gamemap.GameMapListener;

public class InitArmyTerritoryHandler implements GameMapListener{
	public static GameMap gameMap;

	private static int totalPlayerCount;
	
	ArmyPiece armyPiece = ArmyPiece.ArmyPiece_initiation();
	
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
			case 2: return 40; 
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
	public void nextPhase() {
		// TODO Auto-generated method stub
		ArrayList<Player> ordered_players = AllPlayers.ordered_all_players;
		int lastPlayerIndex = ordered_players.size() -1;
		Player lastPlayer = ordered_players.get(lastPlayerIndex);
		HashMap<String, Integer> map = armyPiece.getArmyNumber(lastPlayer);
		int lastPlayerInfantryCount = map.get("infantry");
		System.out.println("last player infantry count: " + lastPlayerInfantryCount);
		
		if(lastPlayerInfantryCount != 0) { //this phase goes on until the last player has 0 army piece
			WorldMap.InitiateArmyTerritoryMap(gameMap, this);
		}
		
	}
	
	
	
	
	
	
	
	
	
	

}
