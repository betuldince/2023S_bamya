package domain.validation;

public class Login extends Validation {

	public Login(String nickname, String password) {
		super(nickname, password);
	}

	@Override
	protected ValidationEnum checkDatabase(String nickname, String password) {
		return null;
	}

}
