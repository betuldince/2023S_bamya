package UI.attackMap;

import UI.gamemap.WorldMap;
import domain.Player;
import domain.gamemap.GameMap;
import domain.gamemap.Territory;

import java.util.ArrayList;

import UI.gamemap.*;

public class AttackMap {
	GameMap gameMap = GameMap.Map_initiation();
	ArrayList<Territory> territoryList;
	Player player;
	public AttackMap(ArrayList<Territory> territoryList,Player player) {
		this.territoryList = territoryList;
		this.player=player;
	}
	
	public void DrawAttackMap() {
		WorldMap.SelectTargetTerritoryAttackPhaseMap(gameMap, player, territoryList);
	}
}
