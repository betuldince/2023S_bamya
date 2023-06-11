package domain.saveLoad;

public interface IInitiable {
	// initiate should initiate the related objects from the String status. e.g. for AllPlayers: all players, current player, player order should be initiated 
	boolean initiate(String key, String status);
	
	// getStatus should create a String so that the initiate() method can understand it. 
	// The string shouldn't contain the following: { } : \
	// It can contain other special characters including the following: " , ( ) / = ; _
	// Beware that if you decide to use a special character, be sure that it doesn't need an escape character. e.g. "\\{" for { 
	String getStatus(String key);
}
