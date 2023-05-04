package UI.gamemap;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.JCheckBox;

import domain.gamemap.*;
import domain.buildingmode.*;



public class WorldMap {
	
	private static Map map;
	private static BuildingModeHandler buildHandler;


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
    private static JCheckBox checkbox1_1 = new JCheckBox("Territory 1.1");
    private static JCheckBox checkbox1_2 = new JCheckBox("Territory 1.2");
    private static JCheckBox checkbox1_3 = new JCheckBox("Territory 1.3");
    private static JCheckBox checkbox1_4 = new JCheckBox("Territory 1.4");
    private static JCheckBox checkbox1_5 = new JCheckBox("Territory 1.5");
    private static JCheckBox checkbox1_6 = new JCheckBox("Territory 1.6");
    private static JCheckBox checkbox1_7 = new JCheckBox("Territory 1.7");
    
  //Each checkbox is a Territory
    private static JCheckBox checkbox2_1 = new JCheckBox("Territory 2.1");
    private static JCheckBox checkbox2_2 = new JCheckBox("Territory 2.2");
    private static JCheckBox checkbox2_3 = new JCheckBox("Territory 2.3");
    private static JCheckBox checkbox2_4 = new JCheckBox("Territory 2.4");
    private static JCheckBox checkbox2_5 = new JCheckBox("Territory 2.5");
    private static JCheckBox checkbox2_6 = new JCheckBox("Territory 2.6");
    private static JCheckBox checkbox2_7 = new JCheckBox("Territory 2.7");
    
    private static JCheckBox checkbox3_1 = new JCheckBox("Territory 3.1");
    private static JCheckBox checkbox3_2 = new JCheckBox("Territory 3.2");
    private static JCheckBox checkbox3_3 = new JCheckBox("Territory 3.3");
    private static JCheckBox checkbox3_4 = new JCheckBox("Territory 3.4");
    private static JCheckBox checkbox3_5 = new JCheckBox("Territory 3.5");
    private static JCheckBox checkbox3_6 = new JCheckBox("Territory 3.6");
    private static JCheckBox checkbox3_7 = new JCheckBox("Territory 3.7");
	
    private static JCheckBox checkbox4_1 = new JCheckBox("Territory 4.1");
    private static JCheckBox checkbox4_2 = new JCheckBox("Territory 4.2");
    private static JCheckBox checkbox4_3 = new JCheckBox("Territory 4.3");
    private static JCheckBox checkbox4_4 = new JCheckBox("Territory 4.4");
    private static JCheckBox checkbox4_5 = new JCheckBox("Territory 4.5");
    private static JCheckBox checkbox4_6 = new JCheckBox("Territory 4.6");
    private static JCheckBox checkbox4_7 = new JCheckBox("Territory 4.7");
	
    private static JCheckBox checkbox5_1 = new JCheckBox("Territory 5.1");
    private static JCheckBox checkbox5_2 = new JCheckBox("Territory 5.2");
    private static JCheckBox checkbox5_3 = new JCheckBox("Territory 5.3");
    private static JCheckBox checkbox5_4 = new JCheckBox("Territory 5.4");
    private static JCheckBox checkbox5_5 = new JCheckBox("Territory 5.5");
    private static JCheckBox checkbox5_6 = new JCheckBox("Territory 5.6");
    private static JCheckBox checkbox5_7 = new JCheckBox("Territory 5.7");
	
    private static JCheckBox checkbox6_1 = new JCheckBox("Territory 6.1");
    private static JCheckBox checkbox6_2 = new JCheckBox("Territory 6.2");
    private static JCheckBox checkbox6_3 = new JCheckBox("Territory 6.3");
    private static JCheckBox checkbox6_4 = new JCheckBox("Territory 6.4");
    private static JCheckBox checkbox6_5 = new JCheckBox("Territory 6.5");
    private static JCheckBox checkbox6_6 = new JCheckBox("Territory 6.6");
    private static JCheckBox checkbox6_7 = new JCheckBox("Territory 6.7");
	

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
	
    
    
    
    
	
	

	/*public static void main(String[] args) {
	      createMap();
	   }*/

	   public static void createContinentsMap(Map map, BuildingModeHandler buildHandle) {    
	      //JFrame frame = new JFrame("GameMapContinents");
	      //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      //InitiateContinentsUI(buildHandle);
	      //frame.setSize(500, 500);      
	      //frame.setVisible(true);
	   }
	   
	   public static void createTerritoriesMap(Map map, BuildingModeHandler buildHandle) {    
	      //JFrame frame = new JFrame("GameMapTerritories");
	      //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      //InitiateTerritoriesUI(frame, buildHandle,map);
	      //frame.setSize(500, 500);      
	      //frame.setVisible(true);
	   }
	   
	   
	   
	   
	   public static void InitiateContinentsUI(Map map, BuildingModeHandler buildHandle) {
		   JFrame frame = new JFrame("GameMapContinents");
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
				
				if(continentBox1.isSelected()) buildHandle.specifyContinent(map.continent1);
				if(continentBox2.isSelected()) buildHandle.specifyContinent(map.continent2);
				if(continentBox3.isSelected()) buildHandle.specifyContinent(map.continent3);
				if(continentBox4.isSelected()) buildHandle.specifyContinent(map.continent4);
				if(continentBox5.isSelected()) buildHandle.specifyContinent(map.continent5);
				if(continentBox6.isSelected()) buildHandle.specifyContinent(map.continent6);
				
				frame.dispose();
				
				InitiateTerritoriesUI(map, buildHandler);
				
				
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

	   public static void InitiateTerritoriesUI( Map map, BuildingModeHandler buildHandle){
	      //Create a border
		   JFrame frame = new JFrame("GameMapTerritories");
		   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      
		  Border blackline = BorderFactory.createLineBorder(Color.black);
	      JPanel panel = new JPanel();
	      LayoutManager layoutCont = new GridLayout(3,2);  
	      panel.setLayout(layoutCont);       
	      
	      panel1 = new JPanel();
	      panel2 = new JPanel();
	      panel3 = new JPanel();
	      panel4 = new JPanel();
	      panel5 = new JPanel();
	      panel6 = new JPanel();
	      
	     
	      String spaces = "                   ";
	      
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
			
		
			
	      for(Continent c: buildHandle.map.continents) {
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
	      
	   }
	   
	   
	   

}
