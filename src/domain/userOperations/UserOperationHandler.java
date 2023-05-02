package domain.userOperations;

import javax.swing.Icon;

public class UserOperationHandler {

	public UserOperationHandler() {
	}
	
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
