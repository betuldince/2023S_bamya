package UI.attackMap;

import java.util.ArrayList;

import UI.gamemap.WorldMap;
import domain.Player;
import domain.gamemap.GameMap;
import domain.gamemap.Territory;

public class InitiateAttackUI {
	ArrayList<Territory> territoryList;
	Player player;
	GameMap gameMap = GameMap.Map_initiation();

	public InitiateAttackUI(ArrayList<Territory> territoryList,Player player) {
		this.territoryList = territoryList;
		this.player=player;
	}
	
	public void DrawInitiateAttackMap() {
		WorldMap.SelectAttackTerritoryAttackPhaseMap(gameMap, player, territoryList);
	}
	

}
