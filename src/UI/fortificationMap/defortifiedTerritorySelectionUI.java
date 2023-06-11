package UI.fortificationMap;

import java.util.ArrayList;

import domain.Player;
import domain.gamemap.GameMap;
import domain.gamemap.Territory;

public class defortifiedTerritorySelectionUI {
	GameMap gameMap = GameMap.Map_initiation();
	ArrayList<Territory> territoryList;
	Player player;
	public defortifiedTerritorySelectionUI(ArrayList<Territory> territoryList,Player player) {
		this.territoryList = territoryList;
		this.player=player;
	}
	

}
