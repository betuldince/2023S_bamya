package domain.userOperations;

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
		
		UserAttributesHashMap userAttributes = new UserAttributesHashMap();
		userAttributes.put("nickname", nickname);
		userAttributes.put("password", password);
		// The rest of the attributes are set to be default such as icon: crown
		databaseAdapter.addUser(userAttributes);
		
		return ValidationEnum.VALID_SIGNUP;
	}

}
