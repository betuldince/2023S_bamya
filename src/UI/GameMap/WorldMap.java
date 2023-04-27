package UI.GameMap;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.JCheckBox;

public class WorldMap {

	public static void main(String[] args) {
	      createMap();
	   }

	   private static void createMap() {    
	      JFrame frame = new JFrame("GameMap");
	      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      InitiateMapUI(frame);
	      frame.setSize(500, 500);      
	      frame.setVisible(true);
	      
	   }

	   private static void InitiateMapUI(JFrame frame){
	      //Create a border
	      Border blackline = BorderFactory.createLineBorder(Color.black);
	      JPanel panel = new JPanel();
	      LayoutManager layoutCont = new GridLayout(3,2);  
	      panel.setLayout(layoutCont);       
	      
	      //Creating Continents (as panels)
	      JPanel panel1 = new JPanel();
	      JPanel panel2 = new JPanel();
	      JPanel panel3 = new JPanel();
	      JPanel panel4 = new JPanel();
	      JPanel panel5 = new JPanel();
	      JPanel panel6 = new JPanel();
	      String spaces = "                   ";
	      
	      LayoutManager layoutTer = new GridLayout(2,3);
	      
	      //Continent 1
	      panel1.add(new JLabel(spaces + "Continent1" + spaces));  
	      panel1.setBorder(blackline);
	      panel1.setBackground(Color.red);
	      panel1.setLayout(layoutTer);

	      	//Each checkbox is a Territory
			JCheckBox checkbox1_1 = new JCheckBox("Territory 1.1");
			JCheckBox checkbox1_2 = new JCheckBox("Territory 1.2");
			JCheckBox checkbox1_3 = new JCheckBox("Territory 1.3");
			JCheckBox checkbox1_4 = new JCheckBox("Territory 1.4");
			JCheckBox checkbox1_5 = new JCheckBox("Territory 1.5");
			JCheckBox checkbox1_6 = new JCheckBox("Territory 1.6");
			JCheckBox checkbox1_7 = new JCheckBox("Territory 1.7");
			
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
			
			panel1.add(checkbox1_1);
			panel1.add(checkbox1_2);
			panel1.add(checkbox1_3);
			panel1.add(checkbox1_4);
			panel1.add(checkbox1_5);
			panel1.add(checkbox1_6);
			panel1.add(checkbox1_7);
			

	      
	      //Continent 2
	      panel2.add(new JLabel(spaces + "Continent2" + spaces));  
	      panel2.setBorder(blackline);
	      panel2.setBackground(Color.green);
	      panel2.setLayout(layoutTer);

	        //Each checkbox is a Territory
			JCheckBox checkbox2_1 = new JCheckBox("Territory 2.1");
			JCheckBox checkbox2_2 = new JCheckBox("Territory 2.2");
			JCheckBox checkbox2_3 = new JCheckBox("Territory 2.3");
			JCheckBox checkbox2_4 = new JCheckBox("Territory 2.4");
			JCheckBox checkbox2_5 = new JCheckBox("Territory 2.5");
			JCheckBox checkbox2_6 = new JCheckBox("Territory 2.6");
			JCheckBox checkbox2_7 = new JCheckBox("Territory 2.7");
			
			checkbox2_1.setBackground(Color.green);
			checkbox2_2.setBackground(Color.green);
			checkbox2_3.setBackground(Color.green);
			checkbox2_4.setBackground(Color.green);
			checkbox2_5.setBackground(Color.green);
			checkbox2_6.setBackground(Color.green);
			checkbox2_7.setBackground(Color.green);
			
			panel2.add(checkbox2_1);
			panel2.add(checkbox2_2);
			panel2.add(checkbox2_3);
			panel2.add(checkbox2_4);
			panel2.add(checkbox2_5);
			panel2.add(checkbox2_6);
			panel2.add(checkbox2_7);
	      
			
		  //Continent 3
	      panel3.add(new JLabel(spaces + "Continent3" + spaces));  
	      panel3.setBorder(blackline);
	      panel3.setBackground(Color.blue);
	      panel3.setLayout(layoutTer);

			JCheckBox checkbox3_1 = new JCheckBox("Territory 3.1");
			JCheckBox checkbox3_2 = new JCheckBox("Territory 3.2");
			JCheckBox checkbox3_3 = new JCheckBox("Territory 3.3");
			JCheckBox checkbox3_4 = new JCheckBox("Territory 3.4");
			JCheckBox checkbox3_5 = new JCheckBox("Territory 3.5");
			JCheckBox checkbox3_6 = new JCheckBox("Territory 3.6");
			JCheckBox checkbox3_7 = new JCheckBox("Territory 3.7");
			
			checkbox3_1.setBackground(Color.blue);
			checkbox3_2.setBackground(Color.blue);
			checkbox3_3.setBackground(Color.blue);
			checkbox3_4.setBackground(Color.blue);
			checkbox3_5.setBackground(Color.blue);
			checkbox3_6.setBackground(Color.blue);
			checkbox3_7.setBackground(Color.blue);
			
			panel3.add(checkbox3_1);
			panel3.add(checkbox3_2);
			panel3.add(checkbox3_3);
			panel3.add(checkbox3_4);
			panel3.add(checkbox3_5);
			panel3.add(checkbox3_6);
			panel3.add(checkbox3_7);
	      
			
		  //Continent 4
	      panel4.add(new JLabel(spaces + "Continent4" + spaces));  
	      panel4.setBorder(blackline);
	      panel4.setBackground(Color.magenta);
	      panel4.setLayout(layoutTer);

			JCheckBox checkbox4_1 = new JCheckBox("Territory 4.1");
			JCheckBox checkbox4_2 = new JCheckBox("Territory 4.2");
			JCheckBox checkbox4_3 = new JCheckBox("Territory 4.3");
			JCheckBox checkbox4_4 = new JCheckBox("Territory 4.4");
			JCheckBox checkbox4_5 = new JCheckBox("Territory 4.5");
			JCheckBox checkbox4_6 = new JCheckBox("Territory 4.6");
			JCheckBox checkbox4_7 = new JCheckBox("Territory 4.7");
			
			checkbox4_1.setBackground(Color.magenta);
			checkbox4_2.setBackground(Color.magenta);
			checkbox4_3.setBackground(Color.magenta);
			checkbox4_4.setBackground(Color.magenta);
			checkbox4_5.setBackground(Color.magenta);
			checkbox4_6.setBackground(Color.magenta);
			checkbox4_7.setBackground(Color.magenta);
			
			panel4.add(checkbox4_1);
			panel4.add(checkbox4_2);
			panel4.add(checkbox4_3);
			panel4.add(checkbox4_4);
			panel4.add(checkbox4_5);
			panel4.add(checkbox4_6);
			panel4.add(checkbox4_7);
	      
			
		  //Continent 5
	      panel5.add(new JLabel(spaces + "Continent5" + spaces));  
	      panel5.setBorder(blackline);
	      panel5.setBackground(Color.yellow);
	      panel5.setLayout(layoutTer);

			JCheckBox checkbox5_1 = new JCheckBox("Territory 5.1");
			JCheckBox checkbox5_2 = new JCheckBox("Territory 5.2");
			JCheckBox checkbox5_3 = new JCheckBox("Territory 5.3");
			JCheckBox checkbox5_4 = new JCheckBox("Territory 5.4");
			JCheckBox checkbox5_5 = new JCheckBox("Territory 5.5");
			JCheckBox checkbox5_6 = new JCheckBox("Territory 5.6");
			JCheckBox checkbox5_7 = new JCheckBox("Territory 5.7");
			
			checkbox5_1.setBackground(Color.yellow);
			checkbox5_2.setBackground(Color.yellow);
			checkbox5_3.setBackground(Color.yellow);
			checkbox5_4.setBackground(Color.yellow);
			checkbox5_5.setBackground(Color.yellow);
			checkbox5_6.setBackground(Color.yellow);
			checkbox5_7.setBackground(Color.yellow);
			
			panel5.add(checkbox5_1);
			panel5.add(checkbox5_2);
			panel5.add(checkbox5_3);
			panel5.add(checkbox5_4);
			panel5.add(checkbox5_5);
			panel5.add(checkbox5_6);
			panel5.add(checkbox5_7);
			
			
	      //Continent 6
	      panel6.add(new JLabel(spaces + "Continent6" + spaces));  
	      panel6.setBorder(blackline);
	      panel6.setBackground(Color.gray);
	      panel6.setLayout(layoutTer);

			JCheckBox checkbox6_1 = new JCheckBox("Territory 6.1");
			JCheckBox checkbox6_2 = new JCheckBox("Territory 6.2");
			JCheckBox checkbox6_3 = new JCheckBox("Territory 6.3");
			JCheckBox checkbox6_4 = new JCheckBox("Territory 6.4");
			JCheckBox checkbox6_5 = new JCheckBox("Territory 6.5");
			JCheckBox checkbox6_6 = new JCheckBox("Territory 6.6");
			JCheckBox checkbox6_7 = new JCheckBox("Territory 6.7");
			
			checkbox6_1.setBackground(Color.gray);
			checkbox6_2.setBackground(Color.gray);
			checkbox6_3.setBackground(Color.gray);
			checkbox6_4.setBackground(Color.gray);
			checkbox6_5.setBackground(Color.gray);
			checkbox6_6.setBackground(Color.gray);
			checkbox6_7.setBackground(Color.gray);
			
			panel6.add(checkbox6_1);
			panel6.add(checkbox6_2);
			panel6.add(checkbox6_3);
			panel6.add(checkbox6_4);
			panel6.add(checkbox6_5);
			panel6.add(checkbox6_6);
			panel6.add(checkbox6_7);
	      
	      
		  panel.add(panel1);
	      panel.add(panel2);
	      panel.add(panel3);
	      panel.add(panel4);
	      panel.add(panel5);
	      panel.add(panel6);
	      
	      frame.getContentPane().add(panel, BorderLayout.CENTER);
	      
	   }

}
