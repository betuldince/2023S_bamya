package UI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import UI.validation.*;

public class Main {

	
		
		public static void main(String[] args) {
		
			openLoginPage(); //Move another class
			//Helloooo ++
			new LoginScreen();
		}
		
		static void openLoginPage() {
			
	    JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		frame.setSize(400,400);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.add(panel);
		panel.setLayout(null);
		frame.setVisible(true);
			
		}
		
		
}
