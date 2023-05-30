package UI.deployment;

import domain.Player;
import domain.buildingmode.BuildingModeHandler;
import domain.gamemap.GameMap;

public class deployment_UI {
	public static void run(Player player) {
		GameMap map = GameMap.Map_initiation();
		DeploymentPhaseModeHandler Handler = DeploymentPhaseModeHandler.createHandler(map, player);
		
		
	}

}
