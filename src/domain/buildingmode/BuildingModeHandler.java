package domain.buildingmode;

import UI.gamemap.*;
import domain.gamemap.*;

public class BuildingModeHandler {

	public static Map map;
	public int playerCount;
	public int compPlayerCount;
	
	public BuildingModeHandler(Map map) {
		this.map = map;
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
