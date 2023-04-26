package application.validation;

import javax.swing.Icon;

import domain.validation.Login;
import domain.validation.Signup;
import domain.validation.Validation;
import domain.validation.ValidationEnum;

public class ValidationHandler {

	public ValidationHandler() {
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
