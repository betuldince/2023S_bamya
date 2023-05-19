package domain.initArmyTerritory;

import java.util.ArrayList;

import domain.AllPlayers;
import domain.ArmyPiece;
import domain.Player;
import domain.gamemap.GameMap;

public class InitArmyTerritoryHandler {
	public static GameMap map;

	private static int totalPlayerCount;
	
	ArmyPiece armyPiece = ArmyPiece.ArmyPiece_initiation();
	
	//singleton pattern
	private static InitArmyTerritoryHandler ArmyTerHandler=null;
	private InitArmyTerritoryHandler(GameMap map) {
		InitArmyTerritoryHandler.map = map;
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
	
	
	
	
	
	
	
	
	

}
