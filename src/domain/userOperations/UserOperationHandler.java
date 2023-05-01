package domain.userOperations;

import javax.swing.Icon;

public class UserOperationHandler {

	public UserOperationHandler() {
	}
	
	public ValidationEnum requestLogin(String nickname, String password) {
		Validation login = new Login(nickname, password);
		ValidationEnum result = login.getResult();
		return result;
	}
	
	public ValidationEnum requestSignup(String nickname, String password) {
		Validation signup = new Signup(nickname, password);
		ValidationEnum result = signup.getResult();
		return result;
	}

	public Icon requestIcon(String nickname) {
		// TODO Auto-generated method stub
		return null;
	}

}
