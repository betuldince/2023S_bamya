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
	private ArmyPiece() {

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
	public void updateArmyNumber(Territory territory, int updateQuantity, String unitType ) {

	}
}
