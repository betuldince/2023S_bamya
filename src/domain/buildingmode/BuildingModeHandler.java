package domain.buildingmode;

import UI.gamemap.*;
import domain.gamemap.*;
import domain.initArmyTerritory.*;


public class BuildingModeHandler implements GameMapListener {

	public static GameMap gameMap;
	public int playerCount;
	public int compPlayerCount;
	
	//singleton pattern
	private static BuildingModeHandler buildHandle=null;
	private BuildingModeHandler(GameMap gameMap) {
		this.gameMap = gameMap;
		this.playerCount = playerCount;
		this.compPlayerCount = compPlayerCount;
	}
	public static BuildingModeHandler createBuildHandler(GameMap gameMap) {
		if (buildHandle == null) {
			buildHandle = new BuildingModeHandler(gameMap);
		}
		return buildHandle;
	}
	
	public void specifyContinent(Continent c) {
		gameMap.specifyContinent(c); 
	}
	
	public void specifyTerritory(Continent c, Territory t) {
		gameMap.specifyTerritory(c, t);
	}
	
	public void initTerritoryButtonPressed() {
		
	}
	
	public void selectTerritories() {
		// TODO Auto-generated method stub
		WorldMap.frame.dispose();
		System.out.println("selectedContinents() works");
		WorldMap.InitiateTerritoriesUI(gameMap, buildHandle);
	}
	@Override
	public void nextPhase() {
		// TODO Auto-generated method stub
		WorldMap.frame.dispose();
		System.out.println("nextPhase() works");
		
		
	}
	
}
