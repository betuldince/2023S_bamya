package domain.buildingmode;

import javax.swing.JFrame;

import UI.gamemap.WorldMap;
import domain.buildingmode.BuildingModeHandler;
import domain.gamemap.Map;

public class BuildingModeStarter {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Map map = new Map();
		BuildingModeHandler buildHandler = new BuildingModeHandler(map);
		WorldMap.InitiateContinentsUI(map, buildHandler);
		
		
		
		

	}
}
