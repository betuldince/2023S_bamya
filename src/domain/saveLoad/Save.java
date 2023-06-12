package domain.saveLoad;

import domain.AllPlayers;
import domain.exceptions.AdapterException;

public class Save {
	boolean successful = false;
	
	private GameState gameState;
	private final static SaveDatabaseFactory fac = SaveDatabaseFactory.getInstance(); 
	private final static String database = "txt";
	
	protected Save() {
		gameState = new GameState();		
		getGameState();
	}

	private void getGameState() {
		gameState.put("allPlayers", AllPlayers.createAllPlayers().getStatus("allPlayers"));
		gameState.put("allPlayers", AllPlayers.createAllPlayers().getStatus("playerOrder"));
		gameState.put("allPlayers", AllPlayers.createAllPlayers().getStatus("currentPlayer"));
		gameState.put("allPlayers", SomeClassInstance.getStatus("someStatusKey"));
	}
	
	protected void save() {
		try {
			ISaveDatabaseAdapter adapter = fac.getDatabaseAdapter(database);
			successful = adapter.save(gameState);
		} catch (AdapterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			successful = false;
		}	
	}

	public boolean isSuccessful() {
		return successful;
	}
	
}
