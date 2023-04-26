package application.validation;

import domain.validation.Login;
import domain.validation.Signup;
import domain.validation.Validation;
import domain.validation.ValidationEnum;

public class ValidationHandler {

	public ValidationHandler() {
	}
	
	public ValidationEnum requestLogin(String nickname, String password) {
		Validation login = new Login(nickname, password);
		return login.getResult();
	}
	
	public ValidationEnum requestSignup(String nickname, String password) {
		Validation signup = new Signup(nickname, password);
		return signup.getResult();
	}

}
