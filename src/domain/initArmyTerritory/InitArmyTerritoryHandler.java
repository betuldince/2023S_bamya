package domain.initArmyTerritory;

import domain.AllPlayers;
import domain.gamemap.GameMap;

public class InitArmyTerritoryHandler {
	public static GameMap map;
	public int playerCount;
	public int compPlayerCount;
	private int totalPlayerCount = AllPlayers.playerNum();
	
	//singleton pattern
	private static InitArmyTerritoryHandler ArmyTerHandler=null;
	private InitArmyTerritoryHandler(GameMap map, int playerCount, int compPlayerCount) {
		this.map = map;
		this.playerCount = playerCount;
		this.compPlayerCount = compPlayerCount;
	}
	public static InitArmyTerritoryHandler createArmyTerHandler(GameMap map, int playerCount, int compPlayerCount) {
		if (ArmyTerHandler == null) {
			ArmyTerHandler = new InitArmyTerritoryHandler(map, playerCount, compPlayerCount);
		}
		return ArmyTerHandler;
	}
	
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
	public void distributeInitialArmy() {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	
	

}
