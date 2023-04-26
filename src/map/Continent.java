package map;

public class Continent {

	int territoryCount;
	boolean cEnabled = false;
	
	private void createContinent(Continent c) {
		
		this.cEnabled = true;
	}
	
	private void specifyTerritory(Territory t) {
		
		territoryCount++;
	}
	
	private boolean checkNumTerritory() {
		if(3 <= territoryCount || territoryCount <= 7) {
			return true;
		} else {
			return false;
		}
	}
	
	private void checkTerritories() {
		
	}
}
