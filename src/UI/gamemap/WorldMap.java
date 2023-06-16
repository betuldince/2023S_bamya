package UI.gamemap;

import java.awt.BorderLayout;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import Phases.AttackPhase;
import Phases.DeploymentPhaseHandler;
import Phases.FortificationPhase;
import UI.user_input_taker.UserInputTaker;

import javax.swing.JCheckBox;

import domain.gamemap.*;
import domain.initArmyTerritory.InitArmyTerritoryHandler;
import domain.initArmyTerritory.InitArmyTerritoryStarter;
import domain.Player;
import domain.singleton_boolean;
import domain.buildingmode.*;



public class WorldMap {

	private static GameMap gameMap;
	private static BuildingModeHandler buildHandler;
	public static JFrame frame;


	//Creating Continents (as panels)
	private static JPanel panel1 = new JPanel();
	private static JPanel panel2 = new JPanel();
	private static JPanel panel3 = new JPanel();
	private static JPanel panel4 = new JPanel();
	private static JPanel panel5 = new JPanel();
	private static JPanel panel6 = new JPanel();

	private static JCheckBox continentBox1 = new JCheckBox("Continent 1");
	private static JCheckBox continentBox2 = new JCheckBox("Continent 2");
	private static JCheckBox continentBox3 = new JCheckBox("Continent 3");
	private static JCheckBox continentBox4 = new JCheckBox("Continent 4");
	private static JCheckBox continentBox5 = new JCheckBox("Continent 5");
	private static JCheckBox continentBox6 = new JCheckBox("Continent 6");

	//Each checkbox is a Territory
	public static JCheckBox checkbox1_1 = new JCheckBox("Territory 1.1");
	public static JCheckBox checkbox1_2 = new JCheckBox("Territory 1.2");
	public static JCheckBox checkbox1_3 = new JCheckBox("Territory 1.3");
	public static JCheckBox checkbox1_4 = new JCheckBox("Territory 1.4");
	public static JCheckBox checkbox1_5 = new JCheckBox("Territory 1.5");
	public static JCheckBox checkbox1_6 = new JCheckBox("Territory 1.6");
	public static JCheckBox checkbox1_7 = new JCheckBox("Territory 1.7");

	//Each checkbox is a Territory
	public static JCheckBox checkbox2_1 = new JCheckBox("Territory 2.1");
	public static JCheckBox checkbox2_2 = new JCheckBox("Territory 2.2");
	public static JCheckBox checkbox2_3 = new JCheckBox("Territory 2.3");
	public static JCheckBox checkbox2_4 = new JCheckBox("Territory 2.4");
	public static JCheckBox checkbox2_5 = new JCheckBox("Territory 2.5");
	public static JCheckBox checkbox2_6 = new JCheckBox("Territory 2.6");
	public static JCheckBox checkbox2_7 = new JCheckBox("Territory 2.7");

	public static JCheckBox checkbox3_1 = new JCheckBox("Territory 3.1");
	public static JCheckBox checkbox3_2 = new JCheckBox("Territory 3.2");
	public static JCheckBox checkbox3_3 = new JCheckBox("Territory 3.3");
	public static JCheckBox checkbox3_4 = new JCheckBox("Territory 3.4");
	public static JCheckBox checkbox3_5 = new JCheckBox("Territory 3.5");
	public static JCheckBox checkbox3_6 = new JCheckBox("Territory 3.6");
	public static JCheckBox checkbox3_7 = new JCheckBox("Territory 3.7");

	public static JCheckBox checkbox4_1 = new JCheckBox("Territory 4.1");
	public static JCheckBox checkbox4_2 = new JCheckBox("Territory 4.2");
	public static JCheckBox checkbox4_3 = new JCheckBox("Territory 4.3");
	public static JCheckBox checkbox4_4 = new JCheckBox("Territory 4.4");
	public static JCheckBox checkbox4_5 = new JCheckBox("Territory 4.5");
	public static JCheckBox checkbox4_6 = new JCheckBox("Territory 4.6");
	public static JCheckBox checkbox4_7 = new JCheckBox("Territory 4.7");

	public static JCheckBox checkbox5_1 = new JCheckBox("Territory 5.1");
	public static JCheckBox checkbox5_2 = new JCheckBox("Territory 5.2");
	public static JCheckBox checkbox5_3 = new JCheckBox("Territory 5.3");
	public static JCheckBox checkbox5_4 = new JCheckBox("Territory 5.4");
	public static JCheckBox checkbox5_5 = new JCheckBox("Territory 5.5");
	public static JCheckBox checkbox5_6 = new JCheckBox("Territory 5.6");
	public static JCheckBox checkbox5_7 = new JCheckBox("Territory 5.7");

	public static JCheckBox checkbox6_1 = new JCheckBox("Territory 6.1");
	public static JCheckBox checkbox6_2 = new JCheckBox("Territory 6.2");
	public static JCheckBox checkbox6_3 = new JCheckBox("Territory 6.3");
	public static JCheckBox checkbox6_4 = new JCheckBox("Territory 6.4");
	public static JCheckBox checkbox6_5 = new JCheckBox("Territory 6.5");
	public static JCheckBox checkbox6_6 = new JCheckBox("Territory 6.6");
	public static JCheckBox checkbox6_7 = new JCheckBox("Territory 6.7");

	// each territory has a corresponding panel for entering unit numbers
	public static JPanel panel1_1 = new JPanel();
	public static JPanel panel1_2 = new JPanel();
	public static JPanel panel1_3 = new JPanel();
	public static JPanel panel1_4 = new JPanel();
	public static JPanel panel1_5 = new JPanel();
	public static JPanel panel1_6 = new JPanel();
	public static JPanel panel1_7 = new JPanel();

	public static JPanel panel2_1 = new JPanel();
	public static JPanel panel2_2 = new JPanel();
	public static JPanel panel2_3 = new JPanel();
	public static JPanel panel2_4 = new JPanel();
	public static JPanel panel2_5 = new JPanel();
	public static JPanel panel2_6 = new JPanel();
	public static JPanel panel2_7 = new JPanel();

	public static JPanel panel3_1 = new JPanel();
	public static JPanel panel3_2 = new JPanel();
	public static JPanel panel3_3 = new JPanel();
	public static JPanel panel3_4 = new JPanel();
	public static JPanel panel3_5 = new JPanel();
	public static JPanel panel3_6 = new JPanel();
	public static JPanel panel3_7 = new JPanel();

	public static JPanel panel4_1 = new JPanel();
	public static JPanel panel4_2 = new JPanel();
	public static JPanel panel4_3 = new JPanel();
	public static JPanel panel4_4 = new JPanel();
	public static JPanel panel4_5 = new JPanel();
	public static JPanel panel4_6 = new JPanel();
	public static JPanel panel4_7 = new JPanel();

	public static JPanel panel5_1 = new JPanel();
	public static JPanel panel5_2 = new JPanel();
	public static JPanel panel5_3 = new JPanel();
	public static JPanel panel5_4 = new JPanel();
	public static JPanel panel5_5 = new JPanel();
	public static JPanel panel5_6 = new JPanel();
	public static JPanel panel5_7 = new JPanel();

	public static JPanel panel6_1 = new JPanel();
	public static JPanel panel6_2 = new JPanel();
	public static JPanel panel6_3 = new JPanel();
	public static JPanel panel6_4 = new JPanel();
	public static JPanel panel6_5 = new JPanel();
	public static JPanel panel6_6 = new JPanel();
	public static JPanel panel6_7 = new JPanel();






	// done


	static Border blackline = BorderFactory.createLineBorder(Color.black);

	//Continent 1
	private static void initPanel1() {
		panel1.setBorder(blackline);
		panel1.setBackground(Color.red);
		panel1.add(continentBox1);
	}

	//Continent 2
	private static void initPanel2() {
		panel2.setBorder(blackline);
		panel2.setBackground(Color.green);
		panel2.add(continentBox2);
	}

	//Continent 3
	private static void initPanel3() {
		panel3.setBorder(blackline);
		panel3.setBackground(Color.blue);
		panel3.add(continentBox3);
	}

	//Continent 4
	private static void initPanel4() {
		panel4.setBorder(blackline);
		panel4.setBackground(Color.magenta);
		panel4.add(continentBox4);
	}

	//Continent 5
	private static void initPanel5() {
		panel5.setBorder(blackline);
		panel5.setBackground(Color.yellow);
		panel5.add(continentBox5);
	}

	//Continent 6
	private static void initPanel6() {
		panel6.setBorder(blackline);
		panel6.setBackground(Color.gray);
		panel6.add(continentBox6);
	}


	// ****initialize panels for the deployment phase

	private static void d_initPanel1() {
		panel1.setBorder(blackline);
		panel1.setBackground(Color.red);
		panel1.add(continentBox1);
	}

	//Continent 2
	private static void d_initPanel2() {
		panel2.setBorder(blackline);
		panel2.setBackground(Color.green);
		panel2.add(continentBox2);
	}

	//Continent 3
	private static void d_initPanel3() {
		panel3.setBorder(blackline);
		panel3.setBackground(Color.blue);
		panel3.add(continentBox3);
	}

	//Continent 4
	private static void d_initPanel4() {
		panel4.setBorder(blackline);
		panel4.setBackground(Color.magenta);
		panel4.add(continentBox4);
	}

	//Continent 5
	private static void d_initPanel5() {
		panel5.setBorder(blackline);
		panel5.setBackground(Color.yellow);
		panel5.add(continentBox5);
	}

	//Continent 6
	private static void d_initPanel6() {
		panel6.setBorder(blackline);
		panel6.setBackground(Color.gray);
		panel6.add(continentBox6);
	}
	// *****done



	// j plane text field adder method
	private static void deployment_Panel_modifier(JPanel panel, Territory t) {
		System.out.println(t.name()+"***************************************");
		JTextField  unit1= new JTextField();
		JTextField  unit2= new JTextField();
		JTextField  unit3= new JTextField();

		unit1.setPreferredSize(new Dimension(40,40));
		unit2.setPreferredSize(new Dimension(40,40));
		unit3.setPreferredSize(new Dimension(40,40));

		unit1.setText("I");
		unit2.setText("C");
		unit3.setText("A");

		panel.add(unit1);
		panel.add(unit2);
		panel.add(unit3);

		t.unit1=unit1;
		t.unit2=unit2;
		t.unit3=unit3;




	}

	private static void addTerritoriesContinent1() {
		panel1.add(checkbox1_1);
		panel1.add(checkbox1_2);
		panel1.add(checkbox1_3);
		panel1.add(checkbox1_4);
		panel1.add(checkbox1_5);
		panel1.add(checkbox1_6);
		panel1.add(checkbox1_7);
	}

	private static void addTerritoriesContinent2() {

		panel2.add(checkbox2_1);
		panel2.add(checkbox2_2);
		panel2.add(checkbox2_3);
		panel2.add(checkbox2_4);
		panel2.add(checkbox2_5);
		panel2.add(checkbox2_6);
		panel2.add(checkbox2_7);
	}

	private static void addTerritoriesContinent3() {

		panel3.add(checkbox3_1);
		panel3.add(checkbox3_2);
		panel3.add(checkbox3_3);
		panel3.add(checkbox3_4);
		panel3.add(checkbox3_5);
		panel3.add(checkbox3_6);
		panel3.add(checkbox3_7);
	}

	private static void addTerritoriesContinent4() {

		panel4.add(checkbox4_1);
		panel4.add(checkbox4_2);
		panel4.add(checkbox4_3);
		panel4.add(checkbox4_4);
		panel4.add(checkbox4_5);
		panel4.add(checkbox4_6);
		panel4.add(checkbox4_7);
	}

	private static void addTerritoriesContinent5() {

		panel5.add(checkbox5_1);
		panel5.add(checkbox5_2);
		panel5.add(checkbox5_3);
		panel5.add(checkbox5_4);
		panel5.add(checkbox5_5);
		panel5.add(checkbox5_6);
		panel5.add(checkbox5_7);
	}

	private static void addTerritoriesContinent6() {

		panel6.add(checkbox6_1);
		panel6.add(checkbox6_2);
		panel6.add(checkbox6_3);
		panel6.add(checkbox6_4);
		panel6.add(checkbox6_5);
		panel6.add(checkbox6_6);
		panel6.add(checkbox6_7);
	}


	private static void addInitiatedTerritories(GameMap gameMap) {


		for(Continent c: gameMap.initiatedContinents) {
			System.out.println("Continent: " + c.contName);

			switch (c.contName){

			case "Continent1": 
				for (Territory t: c.initiatedTerritories) {
					t.checkbox.setSelected(false);
					panel1.add(t.checkbox);
				}
				break;

			case "Continent2": 
				for (Territory t: c.initiatedTerritories) {
					t.checkbox.setSelected(false);
					panel2.add(t.checkbox);
				}
				break;

			case "Continent3": 
				for (Territory t: c.initiatedTerritories) {
					t.checkbox.setSelected(false);
					panel3.add(t.checkbox);
				}
				break;

			case "Continent4": 
				for (Territory t: c.initiatedTerritories) {
					t.checkbox.setSelected(false);
					panel4.add(t.checkbox);
				}
				break;

			case "Continent5": 
				for (Territory t: c.initiatedTerritories) {
					t.checkbox.setSelected(false);
					panel5.add(t.checkbox);
				}
				break;

			case "Continent6": 
				for (Territory t: c.initiatedTerritories) {
					t.checkbox.setSelected(false);
					panel6.add(t.checkbox);
				}
				break;


			}
		}
	}

	private static void addPlayersTerritories(Player p) {


		for(Continent c: gameMap.initiatedContinents) {
			System.out.println("Continent: " + c.contName);

			switch (c.contName){

			case "Continent1": 
				for (Territory t: c.initiatedTerritories) {
					if(p.get_the_territories_in_control_of_the_player().contains(t)) {
						t.checkbox.setSelected(false);
					panel1.add(t.checkbox);
				} 
				}
				
				break;

			case "Continent2": 
				for (Territory t: c.initiatedTerritories) {
					if(p.get_the_territories_in_control_of_the_player().contains(t)) {
						t.checkbox.setSelected(false);
					panel2.add(t.checkbox);
				}
				}
				
				break;

			case "Continent3": 
				for (Territory t: c.initiatedTerritories) {
					if(p.get_the_territories_in_control_of_the_player().contains(t)) {
						
					
						t.checkbox.setSelected(false);
					panel3.add(t.checkbox);
				}
			}
			
				break;

			case "Continent4": 
				for (Territory t: c.initiatedTerritories) {
					if(p.get_the_territories_in_control_of_the_player().contains(t)) {
						
						t.checkbox.setSelected(false);
					panel4.add(t.checkbox);
				}
				}
				
				break;

			case "Continent5": 
				for (Territory t: c.initiatedTerritories) {
					if(p.get_the_territories_in_control_of_the_player().contains(t)) {
						t.checkbox.setSelected(false);
					panel5.add(t.checkbox);
				}
				}
				
				break;

			case "Continent6": 
				for (Territory t: c.initiatedTerritories) {
					if(p.get_the_territories_in_control_of_the_player().contains(t)) {
						
						t.checkbox.setSelected(false);
					panel6.add(t.checkbox);
				}
				}
				
				break;


			}
		}
	}

	private static void addSelectedTerritories(ArrayList<Territory> territoryList) {


		for(Continent c: gameMap.initiatedContinents) {
			System.out.println("Continent: " + c.contName);

			switch (c.contName){

			case "Continent1": 
				for (Territory t: c.initiatedTerritories) {
					if(territoryList.contains(t)) {
						t.checkbox.setSelected(false);
						panel1.add(t.checkbox);
					}
				}
				break;

			case "Continent2": 
				for (Territory t: c.initiatedTerritories) {
					if(territoryList.contains(t)) {
						t.checkbox.setSelected(false);
						panel2.add(t.checkbox);}
				}
				break;

			case "Continent3": 
				for (Territory t: c.initiatedTerritories) {
					if(territoryList.contains(t)) {
						t.checkbox.setSelected(false);
						panel3.add(t.checkbox);}
				}
				break;

			case "Continent4": 
				for (Territory t: c.initiatedTerritories) {
					if(territoryList.contains(t)) {
						t.checkbox.setSelected(false);
						panel4.add(t.checkbox);}
				}
				break;

			case "Continent5": 
				for (Territory t: c.initiatedTerritories) {
					if(territoryList.contains(t)) {
						t.checkbox.setSelected(false);
						panel5.add(t.checkbox);}
				}
				break;

			case "Continent6": 
				for (Territory t: c.initiatedTerritories) {
					if(territoryList.contains(t)) {
						t.checkbox.setSelected(false);
						panel6.add(t.checkbox);}
				}
				break;


			}
		}
	}
	private static void addPlayersTerritoriesDeploymentPhase(Player p) { // bu metod kullanılmadan önce bütün continentlar ve territorilerin initaited olmuş olması gerekioyr


		for(Continent c: gameMap.initiatedContinents) { 
			System.out.println("Continent: " + c.contName);

			switch (c.contName){

			case "Continent1": 
				for (Territory t: c.initiatedTerritories) {
					if(p.get_the_territories_in_control_of_the_player().contains(t)) {
						t.checkbox.setSelected(false);
					deployment_Panel_modifier(t.panel, t);


					panel1.add(t.panel);
				}
				}
				break;

			case "Continent2": 
				for (Territory t: c.initiatedTerritories) {
					if(p.get_the_territories_in_control_of_the_player().contains(t)) {
						t.checkbox.setSelected(false);
					deployment_Panel_modifier(t.panel,t);
					panel2.add(t.panel);
				}
				}
				break;

			case "Continent3": 
				for (Territory t: c.initiatedTerritories) {
					if(p.get_the_territories_in_control_of_the_player().contains(t)) {
						t.checkbox.setSelected(false);
					deployment_Panel_modifier(t.panel,t);
					panel3.add(t.panel);
				}
				}
				break;

			case "Continent4": 
				for (Territory t: c.initiatedTerritories) {
					if(p.get_the_territories_in_control_of_the_player().contains(t)) {
						t.checkbox.setSelected(false);
					deployment_Panel_modifier(t.panel,t);
					panel4.add(t.panel);
				}
				}
				break;

			case "Continent5": 
				for (Territory t: c.initiatedTerritories) {
					if(p.get_the_territories_in_control_of_the_player().contains(t)) {
						t.checkbox.setSelected(false);
					deployment_Panel_modifier(t.panel,t);
					panel5.add(t.panel);
				}
				}
				break;

			case "Continent6": 
				for (Territory t: c.initiatedTerritories) {
					if(p.get_the_territories_in_control_of_the_player().contains(t)) {
						t.checkbox.setSelected(false);
					deployment_Panel_modifier(t.panel,t);
					panel6.add(t.panel);
				}
				}
				break;


			}
		}
	}


	//implemented in order to make user select only 1 checkbox at a time
	private static ButtonGroup createCheckBoxGroup(GameMap gameMap) {

		ButtonGroup checkBoxGroup =  new ButtonGroup();

		for(Continent c: gameMap.initiatedContinents) {

			for (Territory t: c.initiatedTerritories) {
				checkBoxGroup.add(t.checkbox);
				System.out.println("CheckBox " + t.checkbox + " added to checkBoxGroup");
			}
		}	

		return checkBoxGroup;

	}






	/*public static void main(String[] args) {
	      createMap();
	   }*/


	private static JPanel SetUpPanel(String frameText) {
		frame = new JFrame(frameText);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Border blackline = BorderFactory.createLineBorder(Color.black);
		JPanel panel = new JPanel();
		LayoutManager layoutCont = new GridLayout(4,2);  
		panel.setLayout(layoutCont);       

		panel1 = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
		panel4 = new JPanel();
		panel5 = new JPanel();
		panel6 = new JPanel();




		LayoutManager layoutTer = new GridLayout(2,3);

		//Continent 1
		//panel1.add(new JLabel());  
		panel1.setBorder(blackline);
		panel1.setBackground(Color.red);
		panel1.setLayout(layoutTer);



		checkbox1_1.setBackground(Color.red);
		checkbox1_2.setBackground(Color.red);
		checkbox1_3.setBackground(Color.red);
		checkbox1_4.setBackground(Color.red);
		checkbox1_5.setBackground(Color.red);
		checkbox1_6.setBackground(Color.red);
		checkbox1_7.setBackground(Color.red);

		checkbox1_1.setBorder(blackline);
		checkbox1_2.setBorder(blackline);
		checkbox1_3.setBorder(blackline);
		checkbox1_4.setBorder(blackline);
		checkbox1_5.setBorder(blackline);
		checkbox1_6.setBorder(blackline);
		checkbox1_7.setBorder(blackline);






		//Continent 2
		//panel2.add(new JLabel(spaces + "Continent2" + spaces));  
		panel2.setBorder(blackline);
		panel2.setBackground(Color.green);
		panel2.setLayout(layoutTer);



		checkbox2_1.setBackground(Color.green);
		checkbox2_2.setBackground(Color.green);
		checkbox2_3.setBackground(Color.green);
		checkbox2_4.setBackground(Color.green);
		checkbox2_5.setBackground(Color.green);
		checkbox2_6.setBackground(Color.green);
		checkbox2_7.setBackground(Color.green);





		//Continent 3
		//panel3.add(new JLabel(spaces + "Continent3" + spaces));  
		panel3.setBorder(blackline);
		panel3.setBackground(Color.blue);
		panel3.setLayout(layoutTer);



		checkbox3_1.setBackground(Color.blue);
		checkbox3_2.setBackground(Color.blue);
		checkbox3_3.setBackground(Color.blue);
		checkbox3_4.setBackground(Color.blue);
		checkbox3_5.setBackground(Color.blue);
		checkbox3_6.setBackground(Color.blue);
		checkbox3_7.setBackground(Color.blue);




		//Continent 4
		//panel4.add(new JLabel(spaces + "Continent4" + spaces));  
		panel4.setBorder(blackline);
		panel4.setBackground(Color.magenta);
		panel4.setLayout(layoutTer);



		checkbox4_1.setBackground(Color.magenta);
		checkbox4_2.setBackground(Color.magenta);
		checkbox4_3.setBackground(Color.magenta);
		checkbox4_4.setBackground(Color.magenta);
		checkbox4_5.setBackground(Color.magenta);
		checkbox4_6.setBackground(Color.magenta);
		checkbox4_7.setBackground(Color.magenta);





		//Continent 5
		//panel5.add(new JLabel(spaces + "Continent5" + spaces));  
		panel5.setBorder(blackline);
		panel5.setBackground(Color.yellow);
		panel5.setLayout(layoutTer);



		checkbox5_1.setBackground(Color.yellow);
		checkbox5_2.setBackground(Color.yellow);
		checkbox5_3.setBackground(Color.yellow);
		checkbox5_4.setBackground(Color.yellow);
		checkbox5_5.setBackground(Color.yellow);
		checkbox5_6.setBackground(Color.yellow);
		checkbox5_7.setBackground(Color.yellow);




		//Continent 6
		//panel6.add(new JLabel(spaces + "Continent6" + spaces));  
		panel6.setBorder(blackline);
		panel6.setBackground(Color.gray);
		panel6.setLayout(layoutTer);



		checkbox6_1.setBackground(Color.gray);
		checkbox6_2.setBackground(Color.gray);
		checkbox6_3.setBackground(Color.gray);
		checkbox6_4.setBackground(Color.gray);
		checkbox6_5.setBackground(Color.gray);
		checkbox6_6.setBackground(Color.gray);
		checkbox6_7.setBackground(Color.gray);




		panel.add(panel1);
		panel.add(panel2);
		panel.add(panel3);
		panel.add(panel4);
		panel.add(panel5);
		panel.add(panel6);

		return panel;
	}

	public static void initiateAllContinentsforDeploymentPhase(DeploymentPhaseHandler handler) {
		handler.specifyContinent(gameMap.continent1);
		handler.specifyContinent(gameMap.continent2);
		handler.specifyContinent(gameMap.continent3);
		handler.specifyContinent(gameMap.continent4);
		handler.specifyContinent(gameMap.continent5);
		handler.specifyContinent(gameMap.continent6);

	}
	public static void initiateAllTerritoriesforDeploymentPhase(DeploymentPhaseHandler handler) {
		handler.specifyTerritory(GameMap.continent1, GameMap.territory1_1);
		handler.specifyTerritory(GameMap.continent1, GameMap.territory1_2);
		handler.specifyTerritory(GameMap.continent1, GameMap.territory1_3);
		handler.specifyTerritory(GameMap.continent1, GameMap.territory1_4);
		handler.specifyTerritory(GameMap.continent1, GameMap.territory1_5);
		handler.specifyTerritory(GameMap.continent1, GameMap.territory1_6);

		handler.specifyTerritory(GameMap.continent2, GameMap.territory2_1);
		handler.specifyTerritory(GameMap.continent2, GameMap.territory2_2);
		handler.specifyTerritory(GameMap.continent2, GameMap.territory2_3);
		handler.specifyTerritory(GameMap.continent2, GameMap.territory2_4);
		handler.specifyTerritory(GameMap.continent2, GameMap.territory2_5);
		handler.specifyTerritory(GameMap.continent2, GameMap.territory2_6);

		handler.specifyTerritory(GameMap.continent3, GameMap.territory3_1);
		handler.specifyTerritory(GameMap.continent3, GameMap.territory3_2);
		handler.specifyTerritory(GameMap.continent3, GameMap.territory3_3);
		handler.specifyTerritory(GameMap.continent3, GameMap.territory3_4);
		handler.specifyTerritory(GameMap.continent3, GameMap.territory3_5);
		handler.specifyTerritory(GameMap.continent3, GameMap.territory3_6);

		handler.specifyTerritory(GameMap.continent4, GameMap.territory4_1);
		handler.specifyTerritory(GameMap.continent4, GameMap.territory4_2);
		handler.specifyTerritory(GameMap.continent4, GameMap.territory4_3);
		handler.specifyTerritory(GameMap.continent4, GameMap.territory4_4);
		handler.specifyTerritory(GameMap.continent4, GameMap.territory4_5);
		handler.specifyTerritory(GameMap.continent4, GameMap.territory4_6);

		handler.specifyTerritory(GameMap.continent5, GameMap.territory5_1);
		handler.specifyTerritory(GameMap.continent5, GameMap.territory5_2);
		handler.specifyTerritory(GameMap.continent5, GameMap.territory5_3);
		handler.specifyTerritory(GameMap.continent5, GameMap.territory5_4);
		handler.specifyTerritory(GameMap.continent5, GameMap.territory5_5);
		handler.specifyTerritory(GameMap.continent5, GameMap.territory5_6);

		handler.specifyTerritory(GameMap.continent6, GameMap.territory6_1);
		handler.specifyTerritory(GameMap.continent6, GameMap.territory6_2);
		handler.specifyTerritory(GameMap.continent6, GameMap.territory6_3);
		handler.specifyTerritory(GameMap.continent6, GameMap.territory6_4);
		handler.specifyTerritory(GameMap.continent6, GameMap.territory6_5);
		handler.specifyTerritory(GameMap.continent6, GameMap.territory6_6);

	}





	public static void InitiateContinentsUI(GameMap gameMap, BuildingModeHandler buildHandle) {
		frame = new JFrame("GameMapContinents");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		LayoutManager layoutCont = new GridLayout(4,2);  
		panel.setLayout(layoutCont);

		JButton contBtn = new JButton("Select Continents");
		contBtn.setBounds(150,200,100,30);
		contBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				if(continentBox1.isSelected()) buildHandle.specifyContinent(gameMap.continent1);
				if(continentBox2.isSelected()) buildHandle.specifyContinent(gameMap.continent2);
				if(continentBox3.isSelected()) buildHandle.specifyContinent(gameMap.continent3);
				if(continentBox4.isSelected()) buildHandle.specifyContinent(gameMap.continent4);
				if(continentBox5.isSelected()) buildHandle.specifyContinent(gameMap.continent5);
				if(continentBox6.isSelected()) buildHandle.specifyContinent(gameMap.continent6);

				frame.dispose();

				buildHandle.selectTerritories();


			}

		});

		initPanel1();
		initPanel2();
		initPanel3();
		initPanel4();
		initPanel5();
		initPanel6();


		panel.add(panel1);
		panel.add(panel2);
		panel.add(panel3);
		panel.add(panel4);
		panel.add(panel5);
		panel.add(panel6);
		panel.add(contBtn);

		frame.getContentPane().add(panel, BorderLayout.CENTER);

		frame.setSize(500, 500);      
		frame.setVisible(true);

	}

	public static void InitiateTerritoriesUI( GameMap gameMap, BuildingModeHandler buildHandle){
		//Create a border


		JPanel panel = SetUpPanel("GameMapTerritories");

		for(Continent c: buildHandle.gameMap.initiatedContinents) {
			System.out.println("Continent: " + c.contName);

			switch (c.contName){

			case "Continent1": addTerritoriesContinent1(); break;
			case "Continent2": addTerritoriesContinent2(); break;
			case "Continent3": addTerritoriesContinent3(); break;
			case "Continent4": addTerritoriesContinent4(); break;
			case "Continent5": addTerritoriesContinent5(); break;
			case "Continent6": addTerritoriesContinent6(); break;


			}
		}

		//Adding panels to frame
		panel.add(panel1);
		panel.add(panel2);
		panel.add(panel3);
		panel.add(panel4);
		panel.add(panel5);
		panel.add(panel6);

		frame.getContentPane().add(panel, BorderLayout.CENTER);

		frame.setSize(500, 500);      
		frame.setVisible(true);

		JButton contBtn = new JButton("Select Territories");
		contBtn.setBounds(150,200,100,30);
		panel.add(contBtn);
		contBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//Territories in continent 1
				if(checkbox1_1.isSelected()) buildHandle.specifyTerritory(GameMap.continent1, GameMap.territory1_1);
				if(checkbox1_2.isSelected()) buildHandle.specifyTerritory(GameMap.continent1, GameMap.territory1_2);
				if(checkbox1_3.isSelected()) buildHandle.specifyTerritory(GameMap.continent1, GameMap.territory1_3);
				if(checkbox1_4.isSelected()) buildHandle.specifyTerritory(GameMap.continent1, GameMap.territory1_4);
				if(checkbox1_5.isSelected()) buildHandle.specifyTerritory(GameMap.continent1, GameMap.territory1_5);
				if(checkbox1_6.isSelected()) buildHandle.specifyTerritory(GameMap.continent1, GameMap.territory1_6);
				if(checkbox1_7.isSelected()) buildHandle.specifyTerritory(GameMap.continent1, GameMap.territory1_7);

				//Territories in continent 2
				if(checkbox2_1.isSelected()) buildHandle.specifyTerritory(GameMap.continent2, GameMap.territory2_1);
				if(checkbox2_2.isSelected()) buildHandle.specifyTerritory(GameMap.continent2, GameMap.territory2_2);
				if(checkbox2_3.isSelected()) buildHandle.specifyTerritory(GameMap.continent2, GameMap.territory2_3);
				if(checkbox2_4.isSelected()) buildHandle.specifyTerritory(GameMap.continent2, GameMap.territory2_4);
				if(checkbox2_5.isSelected()) buildHandle.specifyTerritory(GameMap.continent2, GameMap.territory2_5);
				if(checkbox2_6.isSelected()) buildHandle.specifyTerritory(GameMap.continent2, GameMap.territory2_6);
				if(checkbox2_7.isSelected()) buildHandle.specifyTerritory(GameMap.continent2, GameMap.territory2_7);

				//Territories in continent 3
				if(checkbox3_1.isSelected()) buildHandle.specifyTerritory(GameMap.continent3, GameMap.territory3_1);
				if(checkbox3_2.isSelected()) buildHandle.specifyTerritory(GameMap.continent3, GameMap.territory3_2);
				if(checkbox3_3.isSelected()) buildHandle.specifyTerritory(GameMap.continent3, GameMap.territory3_3);
				if(checkbox3_4.isSelected()) buildHandle.specifyTerritory(GameMap.continent3, GameMap.territory3_4);
				if(checkbox3_5.isSelected()) buildHandle.specifyTerritory(GameMap.continent3, GameMap.territory3_5);
				if(checkbox3_6.isSelected()) buildHandle.specifyTerritory(GameMap.continent3, GameMap.territory3_6);
				if(checkbox3_7.isSelected()) buildHandle.specifyTerritory(GameMap.continent3, GameMap.territory3_7);

				//Territories in continent 4
				if(checkbox4_1.isSelected()) buildHandle.specifyTerritory(GameMap.continent4, GameMap.territory4_1);
				if(checkbox4_2.isSelected()) buildHandle.specifyTerritory(GameMap.continent4, GameMap.territory4_2);
				if(checkbox4_3.isSelected()) buildHandle.specifyTerritory(GameMap.continent4, GameMap.territory4_3);
				if(checkbox4_4.isSelected()) buildHandle.specifyTerritory(GameMap.continent4, GameMap.territory4_4);
				if(checkbox4_5.isSelected()) buildHandle.specifyTerritory(GameMap.continent4, GameMap.territory4_5);
				if(checkbox4_6.isSelected()) buildHandle.specifyTerritory(GameMap.continent4, GameMap.territory4_6);
				if(checkbox4_7.isSelected()) buildHandle.specifyTerritory(GameMap.continent4, GameMap.territory4_7);

				//Territories in continent 5
				if(checkbox5_1.isSelected()) buildHandle.specifyTerritory(GameMap.continent5, GameMap.territory5_1);
				if(checkbox5_2.isSelected()) buildHandle.specifyTerritory(GameMap.continent5, GameMap.territory5_2);
				if(checkbox5_3.isSelected()) buildHandle.specifyTerritory(GameMap.continent5, GameMap.territory5_3);
				if(checkbox5_4.isSelected()) buildHandle.specifyTerritory(GameMap.continent5, GameMap.territory5_4);
				if(checkbox5_5.isSelected()) buildHandle.specifyTerritory(GameMap.continent5, GameMap.territory5_5);
				if(checkbox5_6.isSelected()) buildHandle.specifyTerritory(GameMap.continent5, GameMap.territory5_6);
				if(checkbox5_7.isSelected()) buildHandle.specifyTerritory(GameMap.continent5, GameMap.territory5_7);

				//Territories in continent 6
				if(checkbox6_1.isSelected()) buildHandle.specifyTerritory(GameMap.continent6, GameMap.territory6_1);
				if(checkbox6_2.isSelected()) buildHandle.specifyTerritory(GameMap.continent6, GameMap.territory6_2);
				if(checkbox6_3.isSelected()) buildHandle.specifyTerritory(GameMap.continent6, GameMap.territory6_3);
				if(checkbox6_4.isSelected()) buildHandle.specifyTerritory(GameMap.continent6, GameMap.territory6_4);
				if(checkbox6_5.isSelected()) buildHandle.specifyTerritory(GameMap.continent6, GameMap.territory6_5);
				if(checkbox6_6.isSelected()) buildHandle.specifyTerritory(GameMap.continent6, GameMap.territory6_6);
				if(checkbox6_7.isSelected()) buildHandle.specifyTerritory(GameMap.continent6, GameMap.territory6_7);




				buildHandle.nextPhase();


			}

		});

	}
	public static void SelectAttackTerritoryAttackPhaseMap(GameMap gameMap, Player p, ArrayList<Territory> territoryList) {

		frame = new JFrame();
		JPanel panel = SetUpPanel("Select Attack Territory Phase: " + p.Player_Name + "'s turn");
		addSelectedTerritories(territoryList); 


		LayoutManager layoutCont = new GridLayout(4,2);  
		panel.setLayout(layoutCont);
		addSelectedTerritories(territoryList); 

		ButtonGroup checkBoxGroup = createCheckBoxGroup(gameMap);



		panel.add(panel1);
		panel.add(panel2);
		panel.add(panel3);
		panel.add(panel4);
		panel.add(panel5);
		panel.add(panel6);

		frame.getContentPane().add(panel, BorderLayout.CENTER);

		frame.setSize(500, 500);      
		frame.setVisible(true);


		JButton contBtn = new JButton("Next Turn");
		contBtn.setBounds(150,200,100,30);
		panel.add(contBtn);
		contBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				Territory t = whichTerritorySelected();
				//singleton

				AttackPhase attackPhaseHandler = AttackPhase.GetAttackPhaseHandler();
				attackPhaseHandler.setAttackTerritory(t);
				//Also check whether the attacker has valid any valid territories 
				if(gameMap.checkPlayerCanAttack(attackPhaseHandler.getAttacker())) {


					//check whether the territory is valid
					if(attackPhaseHandler.checkAttackTerritoryValidity()) {
						frame.dispose(); 
						attackPhaseHandler.selectTargetTerritory();

					}
					else {
						System.out.println("Territory isn't valid");
						frame.dispose(); 
						attackPhaseHandler.selectAttackTerritory();
					}
					//closing previous map
				}
				else {
					//signal that player can't attack 
					frame.dispose(); 
					FortificationPhase fortificationPhaseHandler = FortificationPhase.GetFortificationPhaseHandler();
					fortificationPhaseHandler.setPlayer(attackPhaseHandler.getAttacker());
					fortificationPhaseHandler.decideFortification();
				}

			}
		});
	}

	public static void SelectTargetTerritoryAttackPhaseMap(GameMap gameMap, Player p, ArrayList<Territory> territoryList) {

		frame = new JFrame();
		JPanel panel = SetUpPanel("Select Target Territory Phase: " + p.Player_Name + "'s turn");
		addSelectedTerritories(territoryList); 


		LayoutManager layoutCont = new GridLayout(4,2);  
		panel.setLayout(layoutCont);
		addSelectedTerritories(territoryList); 

		ButtonGroup checkBoxGroup = createCheckBoxGroup(gameMap);



		panel.add(panel1);
		panel.add(panel2);
		panel.add(panel3);
		panel.add(panel4);
		panel.add(panel5);
		panel.add(panel6);

		frame.getContentPane().add(panel, BorderLayout.CENTER);

		frame.setSize(500, 500);      
		frame.setVisible(true);


		JButton contBtn = new JButton("Next Turn");
		contBtn.setBounds(150,200,100,30);
		panel.add(contBtn);
		contBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				Territory t = whichTerritorySelected();
				//singleton
				AttackPhase attackPhaseHandler = AttackPhase.GetAttackPhaseHandler();
				attackPhaseHandler.setTargetTerritory(t);
				if(attackPhaseHandler.checkTargetTerritoryValidity()) {
					frame.dispose(); //closing previous map
					attackPhaseHandler.attack();
					attackPhaseHandler.decideAttackAgain();
				}
				else {
					frame.dispose(); //closing previous map
					attackPhaseHandler.selectTargetTerritory();

				}

			}

		});
	}

	public static void selectDefortifiedTerritoryFortificationPhaseMap(GameMap gameMap, Player p, ArrayList<Territory> territoryList) {

		frame = new JFrame();
		JPanel panel = SetUpPanel("Defortification Territory Selection Phase: " + p.Player_Name + "'s turn");
		addSelectedTerritories(territoryList); 


		LayoutManager layoutCont = new GridLayout(4,2);  
		panel.setLayout(layoutCont);
		addSelectedTerritories(territoryList); 

		ButtonGroup checkBoxGroup = createCheckBoxGroup(gameMap);



		panel.add(panel1);
		panel.add(panel2);
		panel.add(panel3);
		panel.add(panel4);
		panel.add(panel5);
		panel.add(panel6);

		frame.getContentPane().add(panel, BorderLayout.CENTER);

		frame.setSize(500, 500);      
		frame.setVisible(true);


		JButton contBtn = new JButton("Next Turn");
		contBtn.setBounds(150,200,100,30);
		panel.add(contBtn);
		contBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				Territory t = whichTerritorySelected();
				//singleton

				FortificationPhase fortificationPhaseHandler = FortificationPhase.GetFortificationPhaseHandler();
				fortificationPhaseHandler.setDefortifiedTerritory(t);
				//Only Defortifiable Territories are shown to the Player
				frame.dispose();
				fortificationPhaseHandler.selectFortificationTerritory();
			}



		});
	}



	public static void selectFortifiedTerritoryFortificationPhaseMap(GameMap gameMap, Player p, ArrayList<Territory> territoryList) {

		frame = new JFrame();
		JPanel panel = SetUpPanel("Select Foritified Territory Phase: " + p.Player_Name + "'s turn");
		addSelectedTerritories(territoryList); 


		LayoutManager layoutCont = new GridLayout(4,2);  
		panel.setLayout(layoutCont);
		addSelectedTerritories(territoryList); 

		ButtonGroup checkBoxGroup = createCheckBoxGroup(gameMap);



		panel.add(panel1);
		panel.add(panel2);
		panel.add(panel3);
		panel.add(panel4);
		panel.add(panel5);
		panel.add(panel6);

		frame.getContentPane().add(panel, BorderLayout.CENTER);

		frame.setSize(500, 500);      
		frame.setVisible(true);


		JButton contBtn = new JButton("Next Turn");
		contBtn.setBounds(150,200,100,30);
		panel.add(contBtn);
		contBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				Territory t = whichTerritorySelected();
				//singleton

				FortificationPhase fortificationPhaseHandler = FortificationPhase.GetFortificationPhaseHandler();
				fortificationPhaseHandler.setFortifiedTerritory(t);
				UserInputTaker askUnitType = new UserInputTaker(); 
				askUnitType.run("Enter the Unit Type");
				UserInputTaker askUnitQuantity = new UserInputTaker(); 
				askUnitQuantity.run("Enter the Unit Quantity");
				fortificationPhaseHandler.fortify(askUnitType.get_input(), Integer.parseInt(askUnitQuantity.get_input()));
				frame.dispose();
				fortificationPhaseHandler.decideFortification();
				AttackPhase attackPhaseHandler = AttackPhase.GetAttackPhaseHandler();
				attackPhaseHandler.setThread(false);
				//move to the next phase
			}
		});
	}


	public static void InitiateArmyTerritoryMap(GameMap gameMap, InitArmyTerritoryHandler IATHandler, Player p) {

		frame = new JFrame();
		JPanel panel = SetUpPanel("InitiateArmy: " + p.Player_Name + "'s turn");

		addInitiatedTerritories(gameMap); 

		LayoutManager layoutCont = new GridLayout(4,2);  
		panel.setLayout(layoutCont);
		addInitiatedTerritories(gameMap);

		ButtonGroup checkBoxGroup = createCheckBoxGroup(gameMap);



		panel.add(panel1);
		panel.add(panel2);
		panel.add(panel3);
		panel.add(panel4);
		panel.add(panel5);
		panel.add(panel6);

		frame.getContentPane().add(panel, BorderLayout.CENTER);

		frame.setSize(500, 500);      
		frame.setVisible(true);


		JButton contBtn = new JButton("Next Turn");
		contBtn.setBounds(150,200,100,30);
		panel.add(contBtn);
		contBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				Territory t = whichTerritorySelected();
				IATHandler.nextTurn(t);
			}

		});
	}
	public static void InitiatePlayerTerritoryMapforDeploymentPhase(GameMap gameMap, Player p, DeploymentPhaseHandler handler, boolean next_phase) {
		   
		   
		   frame = new JFrame();
		   JPanel panel = SetUpPanel("InitiateArmy: " + p.Player_Name + "'s turn");

		   
	

		   LayoutManager layoutCont = new GridLayout(4,2);  
		   panel.setLayout(layoutCont);
		   addPlayersTerritories(p);
		   
		  ButtonGroup checkBoxGroup = createCheckBoxGroup(gameMap);
		  
		  
		  
		  d_initPanel1();
		  d_initPanel2();
		  d_initPanel3();
		  d_initPanel4();
		  d_initPanel5();
		  d_initPanel6();
		  
		  //initiateAllContinentsforDeploymentPhase(handler);
		  //initiateAllTerritoriesforDeploymentPhase(handler);
		  addPlayersTerritoriesDeploymentPhase(p); 
		  
		  panel.add(panel1);
	      panel.add(panel2);
	      panel.add(panel3);
	      panel.add(panel4);
	      panel.add(panel5);
	      panel.add(panel6); 
	      
	      
	      frame.getContentPane().add(panel, BorderLayout.CENTER);
	      
	      frame.setSize(500, 500);      
	      frame.setVisible(true);
	      
	      
	      
	      
	      JButton contBtn = new JButton("Distribute the Units");
	      contBtn.setBounds(150,200,100,30);
	      panel.add(contBtn);
	      
	      JPanel information_panel=new JPanel();
	      
	  	  JTextField  i_unit1= new JTextField();
 	  JTextField  i_unit2= new JTextField();
 	  JTextField  i_unit3= new JTextField();
 	
 	  i_unit1.setPreferredSize(new Dimension(250,40));
 	  i_unit2.setPreferredSize(new Dimension(250,40));
 	  i_unit3.setPreferredSize(new Dimension(250,40));
 	
 	  i_unit1.setText("number of Infantry is: "+Integer.toString(handler.unit1));
 	  i_unit2.setText("number of Cavalyr is: "+Integer.toString(handler.unit2));
 	  i_unit3.setText("number of Artillery is: "+Integer.toString(handler.unit3));
 	
 	  information_panel.add(i_unit1);
 	  information_panel.add(i_unit2);
 	  information_panel.add(i_unit3);
 	  
 	  panel.add(information_panel);
 	  
 	  
 	  
 	  
	      
	      contBtn.addActionListener(new ActionListener() {
	    	  

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				//get the unit values for all the territories
				System.out.println("tuşa basıldı*******************************************");
				
			
				
				
				handler.distributeUnits(gameMap,p,handler,next_phase);
				i_unit1.setText("number of Infantry is: "+Integer.toString(handler.unit1));
		    	i_unit2.setText("number of Cavalyr is: "+Integer.toString(handler.unit2));
		    	i_unit3.setText("number of Artillery is: "+Integer.toString(handler.unit3));
		    	
		    	if (handler.unit1==0 && handler.unit2==0 && handler.unit3==0 ) {
		    		frame.setVisible(false);
					frame.getContentPane().removeAll();
					frame.repaint();
					frame.dispose();
					//next_phase=false;
					singleton_boolean param=singleton_boolean.initiate_bool();
					param.our_boolean=false;
					
		    		
		    	}
				
				
				
			}
	    	  
	      });
	   }

	public static void InitiatePlayersTerritoryMap(GameMap gameMap, Player p, InitArmyTerritoryHandler IATHandler) {


		frame = new JFrame();
		JPanel panel = SetUpPanel("InitiateArmy: " + p.Player_Name + "'s turn");

		addPlayersTerritories(p); 

		LayoutManager layoutCont = new GridLayout(4,2);  
		panel.setLayout(layoutCont);
		addPlayersTerritories(p);

		ButtonGroup checkBoxGroup = createCheckBoxGroup(gameMap);


		panel.add(panel1);
		panel.add(panel2);
		panel.add(panel3);
		panel.add(panel4);
		panel.add(panel5);
		panel.add(panel6);

		frame.getContentPane().add(panel, BorderLayout.CENTER);

		frame.setSize(500, 500);      
		frame.setVisible(true);


		JButton contBtn = new JButton("Next Turn");
		contBtn.setBounds(150,200,100,30);
		panel.add(contBtn);
		contBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				Territory t = whichTerritorySelected();
				IATHandler.nextTurn(t);
			}

		});
	}

	private static Territory whichTerritorySelected() {

		//Territories in continent 1
		if(checkbox1_1.isSelected()) return GameMap.territory1_1;
		if(checkbox1_2.isSelected()) return GameMap.territory1_2;
		if(checkbox1_3.isSelected()) return GameMap.territory1_3;
		if(checkbox1_4.isSelected()) return GameMap.territory1_4;
		if(checkbox1_5.isSelected()) return GameMap.territory1_5;
		if(checkbox1_6.isSelected()) return GameMap.territory1_6;
		if(checkbox1_7.isSelected()) return GameMap.territory1_7;

		//Territories in continent 2
		if(checkbox2_1.isSelected()) return GameMap.territory2_1;
		if(checkbox2_2.isSelected()) return GameMap.territory2_2;
		if(checkbox2_3.isSelected()) return GameMap.territory2_3;
		if(checkbox2_4.isSelected()) return GameMap.territory2_4;
		if(checkbox2_5.isSelected()) return GameMap.territory2_5;
		if(checkbox2_6.isSelected()) return GameMap.territory2_6;
		if(checkbox2_7.isSelected()) return GameMap.territory2_7;

		//Territories in continent 3
		if(checkbox3_1.isSelected()) return GameMap.territory3_1;
		if(checkbox3_2.isSelected()) return GameMap.territory3_2;
		if(checkbox3_3.isSelected()) return GameMap.territory3_3;
		if(checkbox3_4.isSelected()) return GameMap.territory3_4;
		if(checkbox3_5.isSelected()) return GameMap.territory3_5;
		if(checkbox3_6.isSelected()) return GameMap.territory3_6;
		if(checkbox3_7.isSelected()) return GameMap.territory3_7;

		//Territories in continent 4
		if(checkbox4_1.isSelected()) return GameMap.territory4_1;
		if(checkbox4_2.isSelected()) return GameMap.territory4_2;
		if(checkbox4_3.isSelected()) return GameMap.territory4_3;
		if(checkbox4_4.isSelected()) return GameMap.territory4_4;
		if(checkbox4_5.isSelected()) return GameMap.territory4_5;
		if(checkbox4_6.isSelected()) return GameMap.territory4_6;
		if(checkbox4_7.isSelected()) return GameMap.territory4_7;

		//Territories in continent 5
		if(checkbox5_1.isSelected()) return GameMap.territory5_1;
		if(checkbox5_2.isSelected()) return GameMap.territory5_2;
		if(checkbox5_3.isSelected()) return GameMap.territory5_3;
		if(checkbox5_4.isSelected()) return GameMap.territory5_4;
		if(checkbox5_5.isSelected()) return GameMap.territory5_5;
		if(checkbox5_6.isSelected()) return GameMap.territory5_6;
		if(checkbox5_7.isSelected()) return GameMap.territory5_7;

		//Territories in continent 6
		if(checkbox6_1.isSelected()) return GameMap.territory6_1;
		if(checkbox6_2.isSelected()) return GameMap.territory6_2;
		if(checkbox6_3.isSelected()) return GameMap.territory6_3;
		if(checkbox6_4.isSelected()) return GameMap.territory6_4;
		if(checkbox6_5.isSelected()) return GameMap.territory6_5;
		if(checkbox6_6.isSelected()) return GameMap.territory6_6;
		if(checkbox6_7.isSelected()) return GameMap.territory6_7;

		else {
			System.out.println("Error selecting territories");
			return null;
		}

	}


}







