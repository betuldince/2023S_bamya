package domain.userOperations;

import javax.swing.Icon;

public class UserOperationHandler {

	public UserOperationHandler() {
	}

	/**
	 * requestLogin:
	 * Requests login to the game with the given player information.
	 * <p>
	 * REQUIRES: A user database exists.
	 * MODIFIES: Adds the login information to the singleton CurrentLogins.
	 * EFFECTS: Returns the result (which is type ValidationEnum) of the login request. 
	 * 			This means the following:
	 * 			If nickname OR password contains an invalid character or their lengths are not in valid range:
	 * 				return INVALID_INPUT
	 * 			Else if nickname doesn't exist in the user database:
	 * 				return NICKNAME_NOT_FOUND
	 * 			Else if nickname exists yet password doesn't match with nickname:
	 * 				return INCORRECT_PASSWORD
	 * 			Else if nickname is in CurrentLogins:
	 * 				return ALREADY_LOGGED_IN
	 * 			Else:
	 * 				return VALID_LOGIN
	 * 
	 * @param nickname a string representing the user nickname
	 * @param password a string representing the user's password 
	 * @return result of login request: ValidationEnum
	 */
	public ValidationEnum requestLogin(String nickname, String password) {
		Validation login = new Login(nickname, password);
		ValidationEnum result = login.getResult();
		if (result == ValidationEnum.VALID_LOGIN) {
			CurrentLogins currentLogins = CurrentLogins.getCurrentLogins();
			if (currentLogins.loginSessionIsInProgress(nickname)) {
				result = ValidationEnum.ALREADY_LOGGED_IN;
			}
			else {
				currentLogins.addLoginSession(nickname);
			}
		}
		return result;
	}
	
	public ValidationEnum requestSignup(String nickname, String password) {
		Validation signup = new Signup(nickname, password);
		ValidationEnum result = signup.getResult();
		return result;
	}

	public Icon getIcon(String nickname) {
		UserAttributes userAttributes = new UserAttributes(nickname);
		Icon icon = userAttributes.getUserIcon();		
		return icon;
	}

}
