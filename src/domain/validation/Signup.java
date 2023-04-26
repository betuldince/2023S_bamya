package domain.validation;

public class Signup extends Validation {

	public Signup(String nickname, String password) {
		super(nickname, password);
	}

	@Override
	protected ValidationEnum checkDatabase(String nickname, String password) {
		// TODO Auto-generated method stub
		return null;
	}

}
