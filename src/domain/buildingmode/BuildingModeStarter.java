package domain.buildingmode;

import javax.swing.JFrame;


import UI.gamemap.WorldMap;
import domain.buildingmode.BuildingModeHandler;
import domain.gamemap.Map;
import domain.initArmyTerritory.*;

public class BuildingModeStarter {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int playerCount = 0;
		int compPlayerCount = 0;
		Map map = Map.Map_initiation();
		BuildingModeHandler buildHandler = BuildingModeHandler.createBuildHandler(map,playerCount,compPlayerCount);
		
		WorldMap.InitiateContinentsUI(map, buildHandler);
		initArmyTerritoryStarter.main(args); //probably a bug here
		
		
		
		
		

	}
}
