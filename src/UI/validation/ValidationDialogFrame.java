package UI.validation;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import domain.validation.ValidationEnum;

public class ValidationDialogFrame extends JFrame {

	private static final long serialVersionUID = -6844593222946416936L;
	private ValidationEnum DIALOG_CODE;
	private String dialogMessage;
	private String dialogTitle;
	private int DIALOG_TYPE; 
	
	public ValidationDialogFrame(ValidationEnum DIALOG_CODE) {
		this.DIALOG_CODE = DIALOG_CODE;
		
		setDialogMessage();
		setDialogTitle();
		setDialogType();
		
		JOptionPane.showMessageDialog(this, dialogMessage, dialogTitle, DIALOG_TYPE);  
	}

	private void setDialogType() {
		// Consider changing success icons to green ticks.
		switch (DIALOG_CODE) {
			case VALID_LOGIN:
				DIALOG_TYPE = JOptionPane.DEFAULT_OPTION;
				break;
			case VALID_SIGNUP:
				DIALOG_TYPE = JOptionPane.DEFAULT_OPTION;
				break;		
			case INVALID_INPUT:
				DIALOG_TYPE = JOptionPane.ERROR_MESSAGE;
				break;
			case NICKNAME_NOT_FOUND:
				DIALOG_TYPE = JOptionPane.ERROR_MESSAGE;
				break;
			case INCORRECT_PASSWORD:
				DIALOG_TYPE = JOptionPane.ERROR_MESSAGE;
				break;
			case NICKNAME_ALREADY_EXISTS:
				DIALOG_TYPE = JOptionPane.WARNING_MESSAGE;
				break;
			default:
				DIALOG_TYPE = JOptionPane.ERROR_MESSAGE;
				break;
		}
	}

	private void setDialogTitle() {
		switch (DIALOG_CODE) {
			case VALID_LOGIN:
				dialogTitle = "Success";
				break;
			case VALID_SIGNUP:
				dialogTitle = "Success";
				break;
			case INVALID_INPUT:
				dialogTitle = "Invalid Input";
				break;
			case NICKNAME_NOT_FOUND:
				dialogTitle = "User not Found";
				break;
			case INCORRECT_PASSWORD:
				dialogTitle = "Password not Correct";
				break;
			case NICKNAME_ALREADY_EXISTS:
				dialogTitle = "Nickname Already Exists";
				break;
			default:
				dialogTitle = "Error";
				break;
		}
	}

	private void setDialogMessage() {
		switch (DIALOG_CODE) {
			case VALID_LOGIN:
				dialogMessage = "You have logged in successfully! Have fun!";
				break;
			case VALID_SIGNUP:
				dialogMessage = "You have signed up successfully! Welcome!";
				break;
			case INVALID_INPUT:
				dialogMessage = "You entered invalid input. Check help.";
				break;
			case NICKNAME_NOT_FOUND:
				dialogMessage = "No player with nickname was found.\n"
							  + "Make sure you are entering the nickname correctly.\n"
							  + "Consider sign up!";
				break;
			case INCORRECT_PASSWORD:
				dialogMessage = "Password isn't correct.";
				break;
			case NICKNAME_ALREADY_EXISTS:
				dialogMessage = "The nickname you've entered has already been taken by another player.";
				break;
			default:
				dialogMessage = "Error";
				break;
	}
}


}
