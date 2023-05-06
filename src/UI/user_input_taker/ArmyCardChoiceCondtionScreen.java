package UI.user_input_taker;

import javax.swing.JOptionPane;

public class ArmyCardChoiceCondtionScreen {
	public ArmyCardChoiceCondtionScreen() {
		
	}
	public static int run(boolean c1,boolean c2,boolean c3,boolean c4,boolean c5) {
		String input="";
		if (c1) {
			input+=" 1";
			
		}
		if (c2) {
			input+=" 2";
			
		}
		if (c3) {
			input+=" 3";
			
		}
		if (c4) {
			input+=" 4";
			
		}
		if (c5) {
			input+=" 5";
			
		}
		
		

		int ret=Integer.parseInt(JOptionPane.showInputDialog(null,"Enter which card trading you would like to proceed with :"+input));
		return ret;
		
				
				
		
	}

}
