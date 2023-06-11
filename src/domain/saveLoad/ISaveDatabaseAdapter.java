package domain.saveLoad;

interface ISaveDatabaseAdapter {
	boolean save(GameState gameState);
	GameState load();
}
