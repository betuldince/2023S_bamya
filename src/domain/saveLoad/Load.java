package domain.saveLoad;

import domain.AllPlayers;
import domain.exceptions.AdapterException;

public class Load {
	
	private boolean successful = false;
	
	private GameState gameState;
	private final static String[] stateKeys = GameState.getKeyList();
	private final static SaveDatabaseFactory fac = SaveDatabaseFactory.getInstance(); 
	private final static String database = "txt";
	
	protected Load() {		
		getGameState();
	}
	
	private void getGameState() {
		try {
			ISaveDatabaseAdapter adapter = fac.getDatabaseAdapter(database);
			gameState = adapter.load();
		} catch (AdapterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			successful = false;
		}	
		
	}

	protected void load() {
		successful = true;
		successful = successful && AllPlayers.createAllPlayers().initiate("allPlayers", "stringRepresentingAllPlayers");
		successful = successful && AllPlayers.createAllPlayers().initiate("currentPlayer", "stringRepresentingCurrentPlayer");
		successful = successful && AllPlayers.createAllPlayers().initiate("playerOrder", "stringRepresentingPlayerOrder");
		successful = successful && SomeClassInstance.initiate("someStatus", "stringRepresentingSomeStatus");
	}

	public boolean isSuccessful() {
		return successful;
	}
}
