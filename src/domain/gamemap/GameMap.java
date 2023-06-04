package domain.gamemap;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

import domain.ArmyPiece;
import domain.Dice;
import domain.Player;
import domain.buildingmode.*;
import domain.gamemap.*;


public class GameMap {

	private static int MAXCONTINENT = 6;
	public static ArrayList<Continent> initiatedContinents =  new ArrayList<Continent>(); //arraylist
	//	private static HashSet<Territory> adjacencySet = new HashSet<Territory>();


	//temporary will be deleted when armyPiece is implemented using inheritance, this is used in getting army weights
	ArmyPiece armyPiece= ArmyPiece.ArmyPiece_initiation();


	public static Continent continent1;
	public static Continent continent2;
	public static Continent continent3;
	public static Continent continent4;
	public static Continent continent5;
	public static Continent continent6;
	private static GameMap single_map_instance=null;

	public static Territory territory1_1;
	public static Territory territory1_2;
	public static Territory territory1_3;
	public static Territory territory1_4;
	public static Territory territory1_5;
	public static Territory territory1_6;
	public static Territory territory1_7;
	
	public static Territory territory2_1;
	public static Territory territory2_2;
	public static Territory territory2_3;
	public static Territory territory2_4;
	public static Territory territory2_5;
	public static Territory territory2_6;
	public static Territory territory2_7;
	
	public static Territory territory3_1;
	public static Territory territory3_2;
	public static Territory territory3_3;
	public static Territory territory3_4;
	public static Territory territory3_5;
	public static Territory territory3_6;
	public static Territory territory3_7;
	
	public static Territory territory4_1;
	public static Territory territory4_2;
	public static Territory territory4_3;
	public static Territory territory4_4;
	public static Territory territory4_5;
	public static Territory territory4_6;
	public static Territory territory4_7;
	
	public static Territory territory5_1;
	public static Territory territory5_2;
	public static Territory territory5_3;
	public static Territory territory5_4;
	public static Territory territory5_5;
	public static Territory territory5_6;
	public static Territory territory5_7;
	
	public static Territory territory6_1;
	public static Territory territory6_2;
	public static Territory territory6_3;
	public static Territory territory6_4;
	public static Territory territory6_5;
	public static Territory territory6_6;
	public static Territory territory6_7;
	
	/*private void initContinent(Continent c) {

		continentCount++;
	}*/

	private GameMap() {
		continent1 = Continent.CONTINENT1;
		continent2 = Continent.CONTINENT2;
		continent3 = Continent.CONTINENT3;
		continent4 = Continent.CONTINENT4;
		continent5 = Continent.CONTINENT5;
		continent6 = Continent.CONTINENT6;
		
		territory1_1 = Territory.TERRITORY1_1;
		territory1_2 = Territory.TERRITORY1_2;
		territory1_3 = Territory.TERRITORY1_3;
		territory1_4 = Territory.TERRITORY1_4;
		territory1_5 = Territory.TERRITORY1_5;
		territory1_6 = Territory.TERRITORY1_6;
		territory1_7 = Territory.TERRITORY1_7;
		
		territory2_1 = Territory.TERRITORY2_1;
		territory2_2 = Territory.TERRITORY2_2;
		territory2_3 = Territory.TERRITORY2_3;
		territory2_4 = Territory.TERRITORY2_4;
		territory2_5 = Territory.TERRITORY2_5;
		territory2_6 = Territory.TERRITORY2_6;
		territory2_7 = Territory.TERRITORY2_7;
		
		
		territory3_1 = Territory.TERRITORY3_1;
		territory3_2 = Territory.TERRITORY3_2;
		territory3_3 = Territory.TERRITORY3_3;
		territory3_4 = Territory.TERRITORY3_4;
		territory3_5 = Territory.TERRITORY3_5;
		territory3_6 = Territory.TERRITORY3_6;
		territory3_7 = Territory.TERRITORY3_7;
		
		territory4_1 = Territory.TERRITORY4_1;
		territory4_2 = Territory.TERRITORY4_2;
		territory4_3 = Territory.TERRITORY4_3;
		territory4_4 = Territory.TERRITORY4_4;
		territory4_5 = Territory.TERRITORY4_5;
		territory4_6 = Territory.TERRITORY4_6;
		territory4_7 = Territory.TERRITORY4_7;
	
		territory5_1 = Territory.TERRITORY5_1;
		territory5_2 = Territory.TERRITORY5_2;
		territory5_3 = Territory.TERRITORY5_3;
		territory5_4 = Territory.TERRITORY5_4;
		territory5_5 = Territory.TERRITORY5_5;
		territory5_6 = Territory.TERRITORY5_6;
		territory5_7 = Territory.TERRITORY5_7;
		
		territory6_1 = Territory.TERRITORY6_1;
		territory6_2 = Territory.TERRITORY6_2;
		territory6_3 = Territory.TERRITORY6_3;
		territory6_4 = Territory.TERRITORY6_4;
		territory6_5 = Territory.TERRITORY6_5;
		territory6_6 = Territory.TERRITORY6_6;
		territory6_7 = Territory.TERRITORY6_7;
		
		
		
		
	}
	
	public static GameMap Map_initiation() {
		if (single_map_instance == null) {
			single_map_instance = new GameMap();
		}
		return single_map_instance;
	}

	public void specifyContinent(Continent c) {
		GameMap.initiatedContinents.add(c);
		System.out.println("Continent: " + c.contName + " is added");
	}

	private boolean checkNumContinent(BuildingModeHandler buildHandle) {
		int total_player= buildHandle.compPlayerCount + buildHandle.playerCount;

		if(initiatedContinents.size() <= MAXCONTINENT && initiatedContinents.size() >= total_player) {
			return true;
		} else {
			return false;
		}
	}

	public void specifyTerritory(Continent c, Territory t) {
		c.initiatedTerritories.add(t);
		System.out.println("Territory" + t + " added to " + c);
	}

	private void checkMap() {

	}
	
	//consider moving this method to territory?
	public boolean checkTerritoryAttackValidity(Territory attackTerritory,Territory targetTerritory) {
		if(isNeighbouring(attackTerritory, targetTerritory) && attackTerritory.checkAttackValidity()) {
			return true;
		}
		else {
			return false;
		}
	}
	//implement breadth first search to connect indirectly neighbouring territories
	public boolean checkTerritoryFortificationValidity(Territory defortifiedTerritory, Territory fortifiedTerritory,String unitType,int unitQuantity) {
		if((isConnected(defortifiedTerritory, fortifiedTerritory)) && (unitQuantity<=defortifiedTerritory.getTerritoryArmyNumber().get(unitType)) &&
				(((defortifiedTerritory.getTotalNumberOfArmyUnits()-unitQuantity*armyPiece.getArmyUnitWeights(unitType)))>=2)) {
			return true;
		}
		else {
			return false;
		}

	}
	public void fortifyTerritory(Territory defortifiedTerritory, Territory fortifiedTerritory,String unitType,int unitQuantity) {
		if(checkTerritoryFortificationValidity(defortifiedTerritory,fortifiedTerritory,unitType,unitQuantity)){
			fortifyMap(defortifiedTerritory,fortifiedTerritory,unitType,unitQuantity);
		}
	}
	public void fortifyMap(Territory defortifiedTerritory, Territory fortifiedTerritory,String unitType,int unitQuantity) {
		if(unitType.equals("infantry")) {
			defortifiedTerritory.updateInfantryUnitNumbers(-1*unitQuantity);
			fortifiedTerritory.updateInfantryUnitNumbers(unitQuantity);

		}
		else if (unitType.equals("cavalry")) {
			defortifiedTerritory.updateCavalryUnitNumbers(-1*unitQuantity);
			defortifiedTerritory.updateCavalryUnitNumbers(unitQuantity);
		}
		else {
			defortifiedTerritory.updateArtilleryUnitNumbers(-1*unitQuantity);
			defortifiedTerritory.updateArtilleryUnitNumbers(unitQuantity);
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
			if(defenderTerritory.getInfantryUnitNumbers()>=1) {
				defenderTerritory.updateInfantryUnitNumbers(-1);
			}
			else if(defenderTerritory.getCavalryUnitNumber()>0) {
				defenderTerritory.updateCavalryUnitNumbers(-1);
				defenderTerritory.updateInfantryUnitNumbers(4);
			}
			else {
				defenderTerritory.updateArtilleryUnitNumbers(-1);
				defenderTerritory.updateCavalryUnitNumbers(1);
				defenderTerritory.updateInfantryUnitNumbers(4);
			}
			//case defeated defender territory
			if(defenderTerritory.getTotalNumberOfArmyUnits()==0) {
				defenderTerritory.setTerritoryOwner(winner);

			}
		}
		else {
			if(attackerTerritory.getInfantryUnitNumbers()>=2) {
				attackerTerritory.updateInfantryUnitNumbers(-2);
			}
			else if(attackerTerritory.getCavalryUnitNumber()>0){
				attackerTerritory.updateCavalryUnitNumbers(-1);
				attackerTerritory.updateArtilleryUnitNumbers(3);
			}
			else {
				attackerTerritory.updateArtilleryUnitNumbers(-1);
				attackerTerritory.updateCavalryUnitNumbers(1);
				attackerTerritory.updateInfantryUnitNumbers(3);	
			}				
			//case defeated attacker territory
			if(attackerTerritory.getTotalNumberOfArmyUnits()==0) {
				defenderTerritory.setTerritoryOwner(winner);
			}

		}		

	}
	public boolean isConnected(Territory territory, Territory territoryQuery) {
		HashSet<Territory> isVisited= new HashSet<Territory>();
		Iterator<Territory> adjacentTerritories= territory.getAdjacencySet().iterator();
		Queue<Territory> queueTerritory=new ArrayDeque<Territory>();
		queueTerritory.add(territory);
		isVisited.add(territory);

		return isConnectedHelper(territoryQuery,queueTerritory,isVisited,adjacentTerritories);
	}
	private boolean isConnectedHelper(Territory territoryQuery,
			Queue<Territory> queueTerritory,HashSet<Territory> isVisited, Iterator<Territory> adjacentTerritories) {
		if(queueTerritory.isEmpty()) {
			return false;
		}
		else if (queueTerritory.peek().equals(territoryQuery)) {
			return true;
		}
		while(adjacentTerritories.hasNext()) {
			Territory currTerritory=adjacentTerritories.next();
			System.out.println(currTerritory.get_territory_name());
			if(!isVisited.contains(currTerritory)) {
				isVisited.add(currTerritory);
				queueTerritory.add(currTerritory);
			}	
		}

		queueTerritory.poll();
		if(!queueTerritory.isEmpty()) {
			adjacentTerritories=queueTerritory.peek().getAdjacencySet().iterator();	
		}

		return isConnectedHelper(territoryQuery,queueTerritory,isVisited,adjacentTerritories);

	}


}
