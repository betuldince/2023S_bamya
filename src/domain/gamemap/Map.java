package domain.gamemap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import domain.Dice;
import domain.Player;
import domain.buildingmode.*;
import domain.gamemap.*;


public class Map {
	
	private static int MAXCONTINENT = 6;
	public static ArrayList<Continent> continents =  new ArrayList<Continent>(); //arraylist
	private static HashSet<Territory> adjacencySet = new HashSet<Territory>();

	
	public static Continent continent1;
	public static Continent continent2;
	public static Continent continent3;
	public static Continent continent4;
	public static Continent continent5;
	public static Continent continent6;
	private static Map single_map_instance=null;
	
	/*private void initContinent(Continent c) {
		
		continentCount++;
	}*/
	
	private Map() {
		continent1 = Continent.CONTINENT1;
		continent2 = Continent.CONTINENT2;
		continent3 = Continent.CONTINENT3;
		continent4 = Continent.CONTINENT4;
		continent5 = Continent.CONTINENT5;
		continent6 = Continent.CONTINENT6;
	}
	public static Map Map_initiation() {
		if (single_map_instance == null) {
			single_map_instance = new Map();
		}
		return single_map_instance;
	}
	
	public void specifyContinent(Continent c) {
		this.continents.add(c);
		System.out.println("Continent: " + c.contName + " is added");
	}

	private boolean checkNumContinent(BuildingModeHandler buildHandle) {
		int total_player= buildHandle.compPlayerCount + buildHandle.playerCount;
		
		if(continents.size() <= MAXCONTINENT && continents.size() >= total_player) {
			return true;
		} else {
			return false;
		}
	}
	
	private void specifyTerritory(Territory t) {
		
	}
	
	private void checkMap() {
		
	}
	public boolean checkTerritoryAttackValidity(Territory attackTerritory,Territory targetTerritory) {
		if(isNeighbouring(attackTerritory, targetTerritory)) {
			return true;
		}
		else {
			return false;
		}


	}
	private boolean isNeighbouring(Territory territory, Territory territoryQuiry) {
		HashSet<Territory> territoryAdjancencySet= territory.getAdjacencySet();
		if(territoryAdjancencySet.contains(territoryQuiry)) {
			return true;}
		else {
			return false;
		}
	}
	public void updateMapBattle(Territory attackerTerritory, Territory defenderTerritory, Player winner) {
		if(attackerTerritory.getTerritoryOwner().equals(winner)) {
			defenderTerritory.updateTerritory(-1, "infantry");
			HashMap<String, Integer> territoryArmyNumbers= defenderTerritory.getTerritoryArmyNumber();
			if(territoryArmyNumbers.get("infantry")==0) {
				
			}
		}
		else {
			attackerTerritory.updateTerritory(-2, "infantry");
		}		
		
	}

}
