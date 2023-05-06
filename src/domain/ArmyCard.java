package domain;

import domain.gamemap.Territory;

public class ArmyCard {
	
	String card_type;

	boolean is_it_on_the_deck;
	Player which_player_owns_it=null;
	
	public ArmyCard(String card_type) {
		this.is_it_on_the_deck=true;
		this.which_player_owns_it=null;		
		this.card_type=card_type;
		
	}

	public void change(Player which_player_owns_it) {
        this.which_player_owns_it=which_player_owns_it;
	}
	public boolean is_it_owned_by_a_player() {
		if (this.which_player_owns_it==null) {
			return false;
		}
		return true;
	}
	public String get_card_type() {
		return this.card_type;
	}
	

}
