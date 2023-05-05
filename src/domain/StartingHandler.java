package domain;

import domain.buildingmode.BuildingModeStarter;

public class StartingHandler {
	
	private static StartingHandler handler;

	private StartingHandler() {
	}
	
	public static StartingHandler getHandler() {
		
		if (handler == null) {
			handler = new StartingHandler();
		}
		
		return handler;	
	}

	public boolean validatePlayerInput(String input) {
		Start start = new Start(input);
		boolean isValidInput = start.getResult();

		return isValidInput;
	}
	
	public boolean validateComputerInput(String input, int playerCount) {
		Start start = new Start(input, playerCount);
		boolean isValidInput = start.getResult();

		return isValidInput;
	}
	

	public int getPlayerCount(String input) {
		Start start = new Start(input);
		int playerCount = start.getPlayerCount();
		return playerCount;
	}
	
	public int getComputerCount(String input, int playerCount) {
		Start start = new Start(input, playerCount);
		int computerCount = start.getComputerCount();
		return computerCount;
	}

	public int getMinComputerPlayers(int playerCount) {
		return Start.getMinComputerPlayers(playerCount);
	}
	
	public int getMaxComputerPlayers(int playerCount) {
		return Start.getMaxComputerPlayers(playerCount);
	}

	public void startGame(int computerCount) {
		AllPlayers allPlayers = AllPlayers.createAllPlayers();
		allPlayers.createGamePlayers(computerCount);
		BuildingModeStarter.main(null);		
	}	
	

}
