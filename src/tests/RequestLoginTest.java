package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import domain.userOperations.UserOperationHandler;
import domain.userOperations.ValidationEnum;


class RequestLoginTest {

	@Test
	void validLogin() {
		UserOperationHandler handler = new UserOperationHandler();
		ValidationEnum result = handler.requestLogin("admin", "admin");
		ValidationEnum expectedResult = ValidationEnum.VALID_LOGIN;
		assertEquals(expectedResult, result, "admin nickname with admin password should be a valid login");
	}
	
	@Test
	void invalidInput() {
		UserOperationHandler handler = new UserOperationHandler();
		ValidationEnum result = handler.requestLogin("admin", "admi?n");
		ValidationEnum expectedResult = ValidationEnum.INVALID_INPUT;
		assertEquals(expectedResult, result, "admi?n password should be an invalid input");
	}
	
	@Test
	void alreadyLoggedIn() {
		UserOperationHandler handler = new UserOperationHandler();
		ValidationEnum firstLogin = handler.requestLogin("ahmet", "ahmet");
		ValidationEnum firstExpectedResult = ValidationEnum.VALID_LOGIN;
		ValidationEnum result = handler.requestLogin("ahmet", "ahmet");
		ValidationEnum expectedResult = ValidationEnum.ALREADY_LOGGED_IN;
		assertEquals(firstExpectedResult, firstLogin, "ahmet nickname with ahmet password should be a valid login");
		assertEquals(expectedResult, result, "ahmet nickname with ahmet password should return \"already logged in\" since the same input was used for another login before");
	}
	
	@Test
	void incorrectPassword() {
		UserOperationHandler handler = new UserOperationHandler();
		ValidationEnum result = handler.requestLogin("ege", "notegespass");
		ValidationEnum expectedResult = ValidationEnum.INCORRECT_PASSWORD;
		assertEquals(expectedResult, result, "notegespass password should be incorrect password for ege nickname");
	}
	
	
	@Test
	void nicknameNotFound() {
		UserOperationHandler handler = new UserOperationHandler();
		ValidationEnum result = handler.requestLogin("attilagursoy", "123456");
		ValidationEnum expectedResult = ValidationEnum.NICKNAME_NOT_FOUND;
		assertEquals(expectedResult, result, "attilagursoy nickname should be not found");
	}
	
}
