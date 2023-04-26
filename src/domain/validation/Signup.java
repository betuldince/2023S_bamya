package domain.validation;

import java.util.HashMap;

public class Signup extends Validation {

	public Signup(String nickname, String password) {
		super(nickname, password);
	}

	@Override
	protected ValidationEnum checkDatabase(String nickname, String password) {
		boolean nicknameAlreadyExists = databaseAdapter.nicknameExists(nickname);
		if (nicknameAlreadyExists) {
			return ValidationEnum.NICKNAME_ALREADY_EXISTS;
		}
		
		HashMap<String, String> userAttributes = new HashMap<String, String>();
		userAttributes.put("nickname", nickname);
		userAttributes.put("password", password);
		// Consider adding statistics e.g. win/lose count
		databaseAdapter.addUser(userAttributes);
		
		return ValidationEnum.VALID_SIGNUP;
	}

}
