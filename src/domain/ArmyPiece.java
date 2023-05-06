package domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domain.gamemap.Territory;

public class ArmyPiece {

	//singleton pattern
	private Map<Territory, HashMap<String, Integer>> territoryArmyPieceMap= new HashMap<Territory, HashMap<String, Integer>>();
	private Map<Player, HashMap<String, Integer>> playerArmyPieceMap= new HashMap<Player, HashMap<String, Integer>>();
	private static ArmyPiece single_army_piece_instance=null;
	private static HashMap<String, Integer> armyUnitWeights= new HashMap<String,Integer>();
	
	private ArmyPiece() {
		armyUnitWeights.put("infantry", 1);
		armyUnitWeights.put("cavaltry", 5);
		armyUnitWeights.put("artillery", 10);

	}
	public static ArmyPiece ArmyPiece_initiation() {
		if (single_army_piece_instance == null) {
			single_army_piece_instance = new ArmyPiece();
		}
		return single_army_piece_instance;
	}

	public HashMap<String, Integer> getArmyNumber(Territory territory) {	

		return territoryArmyPieceMap.get(territory); 
	}
	public HashMap<String, Integer> getArmyNumber(Player player) {	

		return playerArmyPieceMap.get(player); 
	}
	public void addNewPlayerArmy(Player player, String unitType, int unitQuantity) {
		
		if (playerArmyPieceMap.containsKey(player)) {
			HashMap<String, Integer> playerArmyQuantityMap= playerArmyPieceMap.get(player);
			playerArmyQuantityMap.put(unitType, unitQuantity);
		}
		else {
			HashMap<String, Integer> playerArmyQuantityMap=new HashMap<String,Integer>();
			playerArmyQuantityMap.put(unitType, unitQuantity);
			playerArmyPieceMap.put(player, playerArmyQuantityMap);
			
		}
	}
	public void addNewTerritoryArmy(Territory territory, String unitType, int unitQuantity) {
		
		if (territoryArmyPieceMap.containsKey(territory)) {
			HashMap<String, Integer> territoryArmyQuantityMap= territoryArmyPieceMap.get(territory);
			territoryArmyQuantityMap.put(unitType, unitQuantity);
		}
		else {
			HashMap<String, Integer> territoryArmyQuantityMap=new HashMap<String,Integer>();
			territoryArmyQuantityMap.put(unitType, unitQuantity);
			territoryArmyPieceMap.put(territory, territoryArmyQuantityMap);
			
		}
	}
	
	public void updateArmyNumber(Territory territory, int updateQuantity, String unitType ) {
		HashMap<String, Integer> armyMap=territoryArmyPieceMap.get(territory);
		armyMap.put(unitType,armyMap.get(unitType)+updateQuantity);
	}
	public void updateArmyNumber(Player player, int updateQuantity, String unitType ) {
		HashMap<String, Integer> armyMap=playerArmyPieceMap.get(player);
		armyMap.put(unitType,armyMap.get(unitType)+updateQuantity);
	}
	public int getArmyUnitWeights(String armyType){
		return armyUnitWeights.get(armyType);
		
	}
	
	
}
