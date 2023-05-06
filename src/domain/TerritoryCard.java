package domain;

import domain.gamemap.Territory;

public class TerritoryCard {
	public Territory which_territory;
	public boolean is_it_on_the_deck;
	public Player which_player_owns_it;
	
	public TerritoryCard() {
		this.is_it_on_the_deck=true;
		this.which_player_owns_it=null;		
		
	}
	public TerritoryCard(Territory which_territory ) {
		this.is_it_on_the_deck=true;
		this.which_player_owns_it=null;		
		this.which_territory=which_territory;
		
	}
	public void assign_owner(Player which_player_owns_it) {
		if (this.which_player_owns_it==null) {
			this.which_player_owns_it=which_player_owns_it;
		}
	}
	public boolean is_it_owned_by_a_player() {
		if (this.which_player_owns_it==null) {
			return false;
		}
		return true;
	}
	public Territory which_territory() {
		return this.which_territory;
				
	}
	

}
