package UI.user_input_taker;

import javax.swing.JOptionPane;

public class UserInputTaker {
	
	String user_input;
	
	public UserInputTaker() {
		
					
	}
	
	public void run(String question_to_be_asked) {
		this.user_input=JOptionPane.showInputDialog(null, question_to_be_asked);
		
	}
	public String get_input() {
		return this.user_input;
	}
	

}
