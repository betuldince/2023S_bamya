package Phases;


import domain.ArmyPiece;
import domain.Player;
import domain.gamemap.Continent;
import domain.gamemap.GameMap;
import domain.gamemap.Territory;
import UI.gamemap.WorldMap;

public class DeploymentPhaseHandler {
	Player player;
	GameMap map;
	public int unit1=0;
	public int unit2=0;
	public int unit3=0;
	boolean next_phase1;
	
	public DeploymentPhaseHandler(Player player, GameMap map, int unit1, int unit2, int unit3, boolean next_phase) {
		this.player=player;
		this.map=map;
		this.unit1=unit1;
		this.unit2=unit2;
		this.unit3=unit3;
		this.next_phase1=next_phase;
	}
	
	public void specifyContinent(Continent c) {
		map.specifyContinent(c); 
	}
	
	public void specifyTerritory(Continent c, Territory t) {
		map.specifyTerritory(c, t);
	}
	public void distributeUnits(GameMap gameMap, Player p, DeploymentPhaseHandler handler, boolean next_phase) {
		ArmyPiece army=ArmyPiece.ArmyPiece_initiation();
		int a=this.player.get_the_territories_in_control_of_the_player().size();
		
		int total_unit_1=0;
		int total_unit_2=0;
		int total_unit_3=0;
		
		for (int h=0; h<a; h++) {
			Territory t=this.player.get_the_territories_in_control_of_the_player().get(h);
			try {
				int number1=Integer.parseInt((t.unit1.getText()));
				if (number1>=0) {
					total_unit_1+=number1;
					
				}

				
			}
			catch(Exception e){
		        System.out.println(e.getMessage());
		     }
			
			
			try {
				int number2=Integer.parseInt((t.unit2.getText()));
				if (number2>=0) {
					total_unit_2+=number2;
					
				}
				
			}
			catch(Exception e){
		        System.out.println(e.getMessage());
		     }
			
			
			try {
				int number3=Integer.parseInt((t.unit3.getText()));
				if (number3>=0) {
					total_unit_3+=number3;
					
				}
				
			}
			catch(Exception e){
		        System.out.println(e.getMessage());
		     }
			
			
	
			
			
					
					
		}
		if (total_unit_1<=this.unit1 &&  total_unit_2<=this.unit2 && total_unit_3<=this.unit3) {
			for (int h=0; h<a; h++) {
				Territory t=this.player.get_the_territories_in_control_of_the_player().get(h);
				try {
					int number1=Integer.parseInt((t.unit1.getText()));
					if (number1>=0) {
						this.unit1-=number1;
						army.updateArmyNumber(this.player, number1, "Infantry");
						army.updateArmyNumber(t, number1, "Infantry");
						
					}

					
				}
				catch(Exception e){
			        System.out.println(e.getMessage());
			     }
				
				
				try {
					int number2=Integer.parseInt((t.unit2.getText()));
					if (number2>=0) {
						this.unit2-=number2;
						army.updateArmyNumber(this.player, number2, "Cavalyr");
						army.updateArmyNumber(t, number2, "Cavalyr");
						
					}
					
				}
				catch(Exception e){
			        System.out.println(e.getMessage());
			     }
				
				
				try {
					int number3=Integer.parseInt((t.unit3.getText()));
					if (number3>=0) {
						this.unit3-=number3;
						army.updateArmyNumber(this.player, number3, "Artillery");
						army.updateArmyNumber(t, number3, "Artillery");
						
					}
					
				}
				catch(Exception e){
			        System.out.println(e.getMessage());
			     }
				
			
						
			}
			if (this.unit1==0 && this.unit2==0 && this.unit3==0) {
				// finish the deployment phase and proceed with the next phase
				System.out.println("tamamlandı");
				next_phase1=false;
				
				//
				
			}
			else { // deployment devam ediyor
				System.out.println("sisteme işlendi devam ediyor**************");
				//GameMap map = GameMap.Map_initiation();
				//DeploymentPhaseHandler Handler = new DeploymentPhaseHandler( this.player, map,this.unit1,this.unit2,this.unit3,  this.next_phase1);
				//WorldMap.InitiatePlayerTerritoryMapforDeploymentPhase(map, p, Handler, next_phase1);
				
				
				
			}
			
			
		}
		else {
			// wrong unit numbers tekrardan
			System.out.println("olmadı yeniden");
			//GameMap map = GameMap.Map_initiation();
			//DeploymentPhaseHandler Handler = new DeploymentPhaseHandler( this.player, map,this.unit1,this.unit2,this.unit3,  this.next_phase1);
			//WorldMap.InitiatePlayerTerritoryMapforDeploymentPhase(map, p, Handler, next_phase1);
			
		}
		
		
		
	
	}

}


