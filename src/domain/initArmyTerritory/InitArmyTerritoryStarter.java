package domain.initArmyTerritory;

import domain.buildingmode.*;
import domain.gamemap.GameMap;
import java.util.ArrayList;
import domain.Player;
import domain.AllPlayers;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;

import UI.gamemap.WorldMap;

import java.util.Hashtable;
import java.util.List;


public class InitArmyTerritoryStarter {
	
	public static ArrayList<Player> turnList;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GameMap gameMap = GameMap.Map_initiation();
		BuildingModeHandler buildHandler = BuildingModeHandler.createBuildHandler(gameMap);
		//AllPlayers allPlayers = AllPlayers.createAllPlayers();
		System.out.println("InitArmyTerStarter called");
		
		InitArmyTerritoryHandler IATHandler = InitArmyTerritoryHandler.createArmyTerHandler(gameMap);
		turnList = AllPlayers.makeTurn(AllPlayers.all_players);
		IATHandler.distributeInitialArmy(turnList);
		WorldMap.InitiateArmyTerritoryMap(gameMap, IATHandler);
		
		
		
		
		

	}
	
	public static void start() {
		main(null);
	}

	public static void startInitiatingArmyTerritory() {
		// TODO Auto-generated method stub
		main(null);
		
	}
	
	

}


