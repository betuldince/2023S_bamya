package domain.validation;

public class Login extends Validation {

	public Login(String nickname, String password) {
		super(nickname, password);
	}

	@Override
	protected ValidationEnum checkDatabase(String nickname, String password) {
		boolean nicknameIsCorrect = databaseAdapter.nicknameExists(nickname);
		if (!nicknameIsCorrect) {
			return ValidationEnum.NICKNAME_NOT_FOUND;
		}
		
		boolean passwordIsCorrect = databaseAdapter.passwordMatches(nickname, password);
		if (!passwordIsCorrect) {
			return ValidationEnum.INCORRECT_PASSWORD;
		}
		
		return ValidationEnum.VALID_LOGIN;
	}
}
