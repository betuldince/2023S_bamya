package UI.fortificationMap;

import java.util.ArrayList;

import UI.gamemap.WorldMap;
import domain.Player;
import domain.gamemap.GameMap;
import domain.gamemap.Territory;

public class FortifiedTerritorySelectionUI {
	GameMap gameMap = GameMap.Map_initiation();
	ArrayList<Territory> territoryList;
	Player player;
	public FortifiedTerritorySelectionUI(ArrayList<Territory> territoryList,Player player) {
		this.territoryList = territoryList;
		this.player=player;
	}
	public void DrawSelectFortificationMap() {
		WorldMap.selectFortifiedTerritoryFortificationPhaseMap(gameMap, player, territoryList);
	}
	
}
