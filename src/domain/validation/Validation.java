package domain.validation;

import java.util.regex.Pattern;

import domain.exceptions.AdapterException;

public abstract class Validation {
	
	private static final DatabaseFactory databaseFactory = DatabaseFactory.getInstance();
	protected IDatabaseAdapter databaseAdapter;
	private String nickname;
	private final ValidationEnum result;
	private final String database = "txt"; // change this line for other databases

	public Validation(String nickname, String password) {
		boolean inputIsValid = validateInput(nickname, password);
		
		if (inputIsValid) {
			this.nickname = nickname;
			
			try {
				databaseAdapter = databaseFactory.getDatabaseAdapter(database);
			}
			catch (AdapterException ae) {
				databaseAdapter = null;
			}
		}
		
		else {
			databaseAdapter = null;
		}
		
		//Either input is not valid or adapter doesn't exist
		if (databaseAdapter == null) {
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
	
	public String getNickname () {
		return nickname;
	}

}
