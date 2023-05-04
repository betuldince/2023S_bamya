package domain;

import java.util.ArrayList;

import domain.gamemap.Territory;

public class AllTerritories {
	public ArrayList<Territory> all_territories;
	
	public AllTerritories() {
		this.all_territories=new ArrayList<Territory>();
	}
	
	public void add_a_new_territory(Territory new_territory) {
		this.all_territories.add(new_territory);
	}

}

