package domain.buildingmode;

import javax.swing.JFrame;


import UI.gamemap.WorldMap;
import domain.buildingmode.BuildingModeHandler;
import domain.gamemap.GameMap;
import domain.initArmyTerritory.*;

public class BuildingModeStarter {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GameMap map = GameMap.GameMap_initiation();
		BuildingModeHandler buildHandler = BuildingModeHandler.createBuildHandler(map);
		
		WorldMap.InitiateContinentsUI(map, buildHandler);
		//InitArmyTerritoryStarter.startInitiatingArmyTerritory(); //probably a bug here
		
		
		
		
		

	}
	
	public static void startBuildingMode() {
		BuildingModeStarter.main(null);
	}
}
