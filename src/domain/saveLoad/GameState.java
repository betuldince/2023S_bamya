package domain.saveLoad;

import java.util.HashMap;

public class GameState extends HashMap<String, String> {

	private static final long serialVersionUID = -5699061852498087644L;
	
	private static final String[] keyList = {"allPlayers", "playerOrder", "currentPlayer", "territories", "continents", "armyCards", "territoryCards", "chanceCards", "armies", "currentPhase"};
	
	public GameState() {		
		for (String key: keyList) {
			this.put(key, null);
		}
	}
	
	public static String[] getKeyList() {
		return keyList;
	}
}
