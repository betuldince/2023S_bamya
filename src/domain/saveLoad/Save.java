package domain.saveLoad;

public class Save {
	boolean success = false;
	
	private String allPlayers;
	private String playerOrder;
	private String currentPlayer;
	private String territories;
	private String continents;
	private String armyCards;
	private String territoryCards;
	private String chanceCards;
	private String armies;
	private String currentPhase;
	
	protected Save() {
		armyCards = getArmyCards();
	}
}
