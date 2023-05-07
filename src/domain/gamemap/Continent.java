package domain.gamemap;

import java.util.ArrayList;

public enum Continent {

	
	CONTINENT1("Continent1"),
	CONTINENT2("Continent2"),
	CONTINENT3("Continent3"),
	CONTINENT4("Continent4"),
	CONTINENT5("Continent5"),
	CONTINENT6("Continent6");
	
	public final String contName;
	int territoryCount;
	public ArrayList<Territory> initiatedTerritories =  new ArrayList<Territory>();
	
	Continent(String string) {
		// TODO Auto-generated constructor stub
		this.contName = string;
	}

	public void specifyTerritory(Territory t) {
		
		territoryCount++;
		initiatedTerritories.add(t);
		
	}
	
	private boolean checkNumTerritory() {
		if(3 <= territoryCount || territoryCount <= 7) {
			return true;
		} else {
			return false;
		}
	}
	
	
}
