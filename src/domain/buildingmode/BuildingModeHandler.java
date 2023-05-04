package domain.buildingmode;

import UI.gamemap.*;
import domain.gamemap.*;
import domain.initArmyTerritory.*;

public class BuildingModeHandler {

	public static Map map;
	public int playerCount;
	public int compPlayerCount;
	
	//singleton pattern
	private static BuildingModeHandler buildHandle=null;
	private BuildingModeHandler(Map map, int playerCount, int compPlayerCount) {
		this.map = map;
		this.playerCount = playerCount;
		this.compPlayerCount = compPlayerCount;
	}
	public static BuildingModeHandler createBuildHandler(Map map, int playerCount, int compPlayerCount) {
		if (buildHandle == null) {
			buildHandle = new BuildingModeHandler(map, playerCount, compPlayerCount);
		}
		return buildHandle;
	}
	
	
	
	private void specifyPlayerNum(int p) {
		this.playerCount = p;
	}

	private void specifyCompPlayerNum(int cp) {
		this.compPlayerCount = cp;
	}
	
	public void specifyContinent(Continent c) {
		map.specifyContinent(c); 
	}
	
	private void specifyTerritory(Territory t) {
		
	}
	
}
