package Phases;

import domain.gamemap.GameMap;
import domain.gamemap.Territory;

public class FortificationPhase {
	GameMap gameMap=GameMap.Map_initiation();
	
	public FortificationPhase() {
		
	}
	public void run() {
		
		
	}
	
	public boolean checkFortificationValidity(Territory deforitifiedTerritory, Territory fortifiedTerritory,String unitType, int unitQuantity) {
		return gameMap.checkTerritoryFortificationValidity(fortifiedTerritory, fortifiedTerritory, unitType,unitQuantity );
	}

	public void fortify(Territory deforitifiedTerritory, Territory fortifiedTerritory,String unitType, int unitQuantity) {
		gameMap.fortifyMap(fortifiedTerritory, fortifiedTerritory, unitType, unitQuantity);
	}
}
