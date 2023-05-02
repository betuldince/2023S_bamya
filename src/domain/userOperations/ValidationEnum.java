package domain.userOperations;

public enum ValidationEnum {
	// Success
	////////////////////////
	// Login
	VALID_LOGIN,
	// Signup
	VALID_SIGNUP,
/*-----------------------------*/	
	// Fail
	////////////////////////
	// Login and Signup
	INVALID_INPUT,
	// Login
	NICKNAME_NOT_FOUND,
	INCORRECT_PASSWORD,
	ALREADY_LOGGED_IN,
	// Signup
	NICKNAME_ALREADY_EXISTS

}
