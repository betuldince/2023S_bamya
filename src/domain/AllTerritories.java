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
	public int return_number_of_territories() {
		return this.all_territories.size();
	}
	public Territory get_the_nth_territory(int n) {
		return this.all_territories.get(n);
	}
	
	

}

