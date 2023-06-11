package Phases;

import java.util.ArrayList;
import java.util.HashMap;


import UI.gamemap.WorldMap;
import UI.otherScreens.InformationGiver;
import UI.user_input_taker.ArmyCardChoiceCondtionScreen;
import UI.user_input_taker.TerritoryCardSelectionScreen;
import domain.AllPlayers;
import domain.AllTerritories;
import domain.ArmyCard;
import domain.ArmyCardDeck;
import domain.ArmyPiece;
import domain.Dice;
import domain.Player;
import domain.TerritoryCard;
import domain.TerritoryCardDeck;
import domain.ChanceCards.ChanceCardDeck;
import domain.gamemap.Continent;
import domain.gamemap.GameMap;
import domain.gamemap.Territory;

public class DeploymentPhase {
	public ArmyCardDeck army_deck;
	public TerritoryCardDeck territory_deck;
	public AllPlayers other_players; //current player is included in this object
	public Player current_player;
	public ArmyPiece the_army_information;
	public AllTerritories allterritories;
	
	public DeploymentPhase(ArmyCardDeck army_deck,TerritoryCardDeck territory_deck, AllPlayers all_players, Player current_player, ArmyPiece the_army_information, AllTerritories allterritories) {
		this.other_players=all_players;
		this.army_deck=army_deck;
		this.current_player=current_player;
		this.territory_deck=territory_deck;
		this.the_army_information=the_army_information;
		this.allterritories=allterritories;
		
		
		
		
	}
	

	
	public void run(Boolean next_hase) throws InterruptedException {
		// first ask the player if s/he wishes to trade in his/her cards:
		//kart değişim ekranı oluşturman lazım:
		InformationGiver.run("Deployment Phase for the player "+current_player.Player_Name+" has started",1);
		
		int turnly_total_number_of_infantry=0;
		int turnly_total_number_of_cavalyr=0;
		int turnly_total_number_of_artiellry=0;
		
		boolean condition1=false;
		boolean condition2=false;
		boolean condition3=false;
		boolean condition4=false;
		boolean condition5=false;
		
		if (current_player.getArmy_deck().get_number_of_infantry_cards()>=3) {
			condition1=true;
		}
		if (current_player.getArmy_deck().get_number_of_infantry_cards()>=2 && current_player.getArmy_deck().get_number_of_cavalyr_cards()>=1 ) {
			condition2=true;
		}
		if (current_player.getArmy_deck().get_number_of_infantry_cards()>=2 && current_player.getArmy_deck().get_number_of_artillery_cards()>=1) {
			condition3=true;
		}
		if (current_player.getArmy_deck().get_number_of_infantry_cards()>1 && current_player.getArmy_deck().get_number_of_cavalyr_cards()>=2 ) {
			condition4=true;
		}
		if (current_player.getArmy_deck().get_number_of_artillery_cards()>=1 && current_player.getArmy_deck().get_number_of_cavalyr_cards()>=2 ) {
			condition5=true;
		}

		
		if (condition1||condition2||condition3||condition4||condition5 ) {
			// open the selection screen and make player choose which card combination s/he wants to proceed with
			int which_one=ArmyCardChoiceCondtionScreen.run(condition1, condition2, condition3, condition4, condition5); 
			
			if (which_one==1) {
				turnly_total_number_of_cavalyr=1;
				ArmyCard a1=current_player.getArmy_deck().delete_an_infantry_card();
				a1.change(null);
				this.army_deck.add_new_army_card(a1);
				
				ArmyCard a2=current_player.getArmy_deck().delete_an_infantry_card();
				a2.change(null);
				this.army_deck.add_new_army_card(a2);
				
				ArmyCard a3=current_player.getArmy_deck().delete_an_infantry_card();
				a3.change(null);
				this.army_deck.add_new_army_card(a3);


			
				
				
			}
			else if (which_one==2) {
				turnly_total_number_of_cavalyr=2;
				
				ArmyCard a1=current_player.getArmy_deck().delete_an_infantry_card();
				a1.change(null);
				this.army_deck.add_new_army_card(a1);
				
				ArmyCard a2=current_player.getArmy_deck().delete_an_infantry_card();
				a2.change(null);
				this.army_deck.add_new_army_card(a2);
				
				ArmyCard a3=current_player.getArmy_deck().delete_an_cavalyr_card();
				a3.change(null);
				this.army_deck.add_new_army_card(a3);
				
			} 
            else if (which_one==3) {
            	turnly_total_number_of_artiellry=2;
            	
            	ArmyCard a1=current_player.getArmy_deck().delete_an_infantry_card();
				a1.change(null);
				this.army_deck.add_new_army_card(a1);
				
				ArmyCard a2=current_player.getArmy_deck().delete_an_infantry_card();
				a2.change(null);
				this.army_deck.add_new_army_card(a2);
				
				ArmyCard a3=current_player.getArmy_deck().delete_an_artiellry_card();
				a3.change(null);
				this.army_deck.add_new_army_card(a3);
				
			}
            else if (which_one==4) {
            	turnly_total_number_of_cavalyr=1;
            	turnly_total_number_of_artiellry=1;
            	
            	ArmyCard a1=current_player.getArmy_deck().delete_an_infantry_card();
				a1.change(null);
				this.army_deck.add_new_army_card(a1);
				
				ArmyCard a2=current_player.getArmy_deck().delete_an_cavalyr_card();
				a2.change(null);
				this.army_deck.add_new_army_card(a2);
				
				ArmyCard a3=current_player.getArmy_deck().delete_an_cavalyr_card();
				a3.change(null);
				this.army_deck.add_new_army_card(a3);
	
            }
            else if (which_one==5) {
            	turnly_total_number_of_artiellry=3;
            	
            	ArmyCard a1=current_player.getArmy_deck().delete_an_artiellry_card();
				a1.change(null);
				this.army_deck.add_new_army_card(a1);
				
				ArmyCard a2=current_player.getArmy_deck().delete_an_cavalyr_card();
				a2.change(null);
				this.army_deck.add_new_army_card(a2);
				
				ArmyCard a3=current_player.getArmy_deck().delete_an_cavalyr_card();
				a3.change(null);
				this.army_deck.add_new_army_card(a3);
            	
            }
            else {
            	InformationGiver.run("the player does not want to trade in cards this turn",1);
            	
            }
			
			
		}
		else {
			InformationGiver.run("cannot trade in army cards this turn due to their unavalibality",2);
			
		}
		
		
		// now deal with territory cards

		
		// determine how much territories any continent has
		HashMap<Continent, Integer> continent_territory_numbers = new HashMap<Continent, Integer>();
		
		territory_counter(continent_territory_numbers);
		
		// determine how much territories in each continent the player has cards of
		HashMap<Continent, Integer> cards_continent_numbers = new HashMap<Continent, Integer>();
		for (Continent con1 : continent_territory_numbers.keySet()) {
			cards_continent_numbers.put(con1, 0);
			  
			}
		
		
		for (int j=0; j< this.current_player.getTerritory_deck().get_number_of_territory_cards(); j++) {
			cards_continent_numbers.put(this.current_player.getTerritory_deck().get_nth_card(j).which_territory().get_continent(),cards_continent_numbers.get(this.current_player.getTerritory_deck().get_nth_card(j).which_territory().get_continent())+1 );
			
		}
		

		for (Continent con2 : continent_territory_numbers.keySet() ) {
			if (cards_continent_numbers.get(con2)==continent_territory_numbers.get(con2)) {
				boolean condition_territory_cards=false;
				condition_territory_cards=TerritoryCardSelectionScreen.run(con2); // territory cards'ını bozdurup bozdurmayacağını belirtiyor
				if (condition_territory_cards) {
					for (int r=0; r<this.current_player.getTerritory_deck().get_number_of_territory_cards(); r++) {
						TerritoryCard terc=this.current_player.getTerritory_deck().delete_a_card_of_a_specific_continent(con2);
						if (terc!=null) {
							terc.assign_owner(null);
							this.territory_deck.add_new_territory_card(terc);
							
						}
					}
					
					for (int h=0; h<this.other_players.get_the_number_of_players(); h++) {
						if (this.other_players.get_the_nth_player(h)!=this.current_player) {
							int indices_to_be_deleted[]=new int[this.other_players.get_the_nth_player(h).get_the_territories_in_control_of_the_player().size()];
							int indices_to_be_deleted_size=0;
							
							
							
							for (int u=0; u<this.other_players.get_the_nth_player(h).get_the_territories_in_control_of_the_player().size(); u++) {
								if (this.other_players.get_the_nth_player(h).get_the_territories_in_control_of_the_player().get(u).get_continent()==con2) {
									indices_to_be_deleted[indices_to_be_deleted_size]=u;
									indices_to_be_deleted_size++;
											
								}
								
							}
							Territory territories_to_be_deleted[]=new Territory[indices_to_be_deleted_size];
							
							for (int u1=0; u1<indices_to_be_deleted_size; u1++) {
								Territory subject=this.other_players.get_the_nth_player(h).get_the_territories_in_control_of_the_player().get(indices_to_be_deleted[u1]);
								territories_to_be_deleted[u1]=subject;
								this.current_player.get_the_territories_in_control_of_the_player().add(subject);
								this.other_players.get_the_nth_player(h).get_the_territories_in_control_of_the_player().remove(subject);
								
								// update the army information
								
								this.the_army_information.updateArmyNumber(this.other_players.get_the_nth_player(h), -this.the_army_information.getArmyNumber(subject).get("Infantry")+this.the_army_information.getArmyNumber(this.other_players.get_the_nth_player(h)).get("Infantry"),  "Infantry");
								this.the_army_information.updateArmyNumber(this.other_players.get_the_nth_player(h), -this.the_army_information.getArmyNumber(subject).get("Cavalyr")+this.the_army_information.getArmyNumber(this.other_players.get_the_nth_player(h)).get("Cavalyr"),  "Cavalyr");
								this.the_army_information.updateArmyNumber(this.other_players.get_the_nth_player(h), -this.the_army_information.getArmyNumber(subject).get("Artillery")+this.the_army_information.getArmyNumber(this.other_players.get_the_nth_player(h)).get("Artillery"),  "Artillery");
								
								
								
								this.the_army_information.updateArmyNumber(subject, 1, "Infantry");
								this.the_army_information.updateArmyNumber(subject, 0, "Cavalyr");
								this.the_army_information.updateArmyNumber(subject, 0, "Artillery");
								
								this.the_army_information.updateArmyNumber(current_player, this.the_army_information.getArmyNumber(current_player).get("Infantry")+1 , "Infantry");
								
								
								
							}

								
							
							// territory değişimleri ve tekabül eden asker sayıları başarıyla tamamlandı ve güncellendi
							
							
							
							
						}
							
						}
					
				}
				
				
				
			}
		}
		
		// now do the actual deployment:
		int territory_number=this.current_player.get_the_territories_in_control_of_the_player().size();
		if (territory_number/3>=3) {
			turnly_total_number_of_infantry+=territory_number/3;
			
		}
		else {
			turnly_total_number_of_infantry+=3;
		}
		
		// now do the unit distribution among the territories: 
		
		GameMap map = GameMap.Map_initiation();
		DeploymentPhaseHandler Handler = new DeploymentPhaseHandler( this.current_player, map,turnly_total_number_of_infantry,turnly_total_number_of_cavalyr,turnly_total_number_of_artiellry,  next_hase);
		WorldMap.InitiatePlayerTerritoryMapforDeploymentPhase(map, this.current_player, Handler,next_hase);
		
		

		
		
	}
	/**
	 * territory_counter:
	 * computes the number of territories each continent has
	 * <p>
	 * REQUIRES: DeploymentPhase should already have been initiated, HashMap<Continent, Integer>
	 * MODIFIES: HashMap<Continent, Integer> that is given as an input
	 * EFFECTS: for all continents the game currently has, it gives the number of territories corresponding to each specific continent
	 * 
	 * @param HashMap<Continent, Integer>
	 * 
	 */
	public void territory_counter(HashMap<Continent, Integer> continent_territory_numbers) {
		for (int j=0; j<allterritories.return_number_of_territories(); j++) {
			boolean our_condition=false;
			Continent a_new_one=this.allterritories.get_the_nth_territory(j).get_continent();
			for (Continent con : continent_territory_numbers.keySet()) {
				  if (a_new_one==con) {
					  our_condition=true;
					  break;
					  
				  }
				}
			if (our_condition) {
				continent_territory_numbers.put(a_new_one, continent_territory_numbers.get(a_new_one) + 1);
				
			}
			else {
				continent_territory_numbers.put(a_new_one, 1);
				
				
			}
		
			
		}
		
	}

}

