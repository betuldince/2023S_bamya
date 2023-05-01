package domain.userOperations;


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
		boolean nicknameLengthIsValid = (password.length() <= 20) && (password.length() >= 3);
		boolean passwordLengthIsValid = (password.length() <= 20) && (password.length() >= 3);
		boolean lengthsAreValid = nicknameLengthIsValid && passwordLengthIsValid;
		if (lengthsAreValid) {
			return false;
		}
		boolean nicknameIsValid = nickname.matches("^[a-zA-Z0-9_]*$"); 
		boolean passwordIsValid = password.matches("^[a-zA-Z0-9_]*$");
		boolean inputIsValid = nicknameIsValid && passwordIsValid;
		return inputIsValid;
	}
	
	public ValidationEnum getResult() {
		return result;
	}

}
