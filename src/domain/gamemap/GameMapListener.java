package domain.gamemap;

public interface GameMapListener {
	public void nextPhase();

	public void nextTurn(Territory t);
}
