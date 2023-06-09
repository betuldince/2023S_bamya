package domain.saveLoad;

interface ISaveDatabaseAdapter {
	boolean save(GameState gameState);
	String getStatus(String statusKey);
}
