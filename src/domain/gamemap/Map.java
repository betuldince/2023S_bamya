package domain.gamemap;

import java.util.ArrayList;
import domain.buildingmode.*;
import domain.gamemap.*;


public class Map {
	
	private static int MAXCONTINENT = 6;
	public static ArrayList<Continent> continents =  new ArrayList<Continent>(); //arraylist
	
	
	public static Continent continent1;
	public static Continent continent2;
	public static Continent continent3;
	public static Continent continent4;
	public static Continent continent5;
	public static Continent continent6;
	
	/*private void initContinent(Continent c) {
		
		continentCount++;
	}*/
	
	public Map() {
		continent1 = Continent.CONTINENT1;
		continent2 = Continent.CONTINENT2;
		continent3 = Continent.CONTINENT3;
		continent4 = Continent.CONTINENT4;
		continent5 = Continent.CONTINENT5;
		continent6 = Continent.CONTINENT6;
	}
	
	public void specifyContinent(Continent c) {
		this.continents.add(c);
		System.out.println("Continent: " + c.contName + " is added");
	}

	private boolean checkNumContinent(BuildingModeHandler buildHandle) {
		int total_player= buildHandle.compPlayerCount + buildHandle.playerCount;
		
		if(continents.size() <= MAXCONTINENT && continents.size() >= total_player) {
			return true;
		} else {
			return false;
		}
	}
	
	private void specifyTerritory(Territory t) {
		
	}
	
	private void checkMap() {
		
	}

}
