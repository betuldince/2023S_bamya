package domain.userOperations;

import java.util.regex.Pattern;

public abstract class Validation extends UserOperation{
	
	private final ValidationEnum result;

	public Validation(String nickname, String password) {
		super(nickname);
		boolean inputIsValid = validateInput(nickname, password);
		
		if (databaseAdapter == null || (!inputIsValid)) {
			result = ValidationEnum.INVALID_INPUT;
		}
		// Valid input and adapter
		else {
			result = checkDatabase(nickname, password);
		}
		
	}
	
	protected abstract ValidationEnum checkDatabase(String nickname, String password);

	private static final boolean validateInput(String nickname, String password) {
		boolean nicknameLengthIsValid = (nickname.length() <= 20) && (nickname.length() >= 3);
		boolean passwordLengthIsValid = (password.length() <= 20) && (password.length() >= 3);
		boolean lengthsAreValid = nicknameLengthIsValid && passwordLengthIsValid;
		if (!lengthsAreValid) {
			return false;
		}

		Pattern pattern = Pattern.compile("^[a-zA-Z0-9_]*$");

		boolean nicknameIsValid = pattern.matcher(nickname).matches();
		boolean passwordIsValid = pattern.matcher(password).matches();

		boolean inputIsValid = nicknameIsValid && passwordIsValid && lengthsAreValid;
		return inputIsValid;
	}
	
	public ValidationEnum getResult() {
		return result;
	}

}
