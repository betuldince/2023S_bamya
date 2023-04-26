package BuildingMode;

import map.*;

public class BuildingMode<Handler> {

	int playerCount;
	int compPlayerCount;
	
	public static GameMap initMap() {
		GameMap map;
		return map;
	}
	
	private void specifyPlayerNum(int p) {
		this.playerCount = p;
	}

	private void specifyCompPlayerNum(int cp) {
		this.compPlayerCount = cp;
	}
	
	private void specifyContinent(Continent c) {
		
	}
	
	private void specifyTerritory(Territory t) {
		
	}
	
}
