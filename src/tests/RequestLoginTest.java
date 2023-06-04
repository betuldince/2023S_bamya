package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import domain.userOperations.CurrentLogins;
import domain.userOperations.UserOperationHandler;
import domain.userOperations.ValidationEnum;


class RequestLoginTest {

	@Test
	void validLogin() {
		assertEquals(true, repOk(), "Representation Invariant should be preserved");
		UserOperationHandler handler = new UserOperationHandler();
		ValidationEnum result = handler.requestLogin("admin", "admin");
		ValidationEnum expectedResult = ValidationEnum.VALID_LOGIN;
		assertEquals(expectedResult, result, "admin nickname with admin password should be a valid login");
		assertEquals(true, repOk(), "Representation Invariant should be preserved");
	}
	
	/* 
	 * Requesting a login with admin nickname and admin password should give 
	 * already logged in warning after the test above. This is because CurrentLogins 
	 * would be modified to contain admin login by the requestLogin. This behavior
	 * was described in the requestLogin specifications in the MODIFIES section.
	 */
	
	@Test
	void invalidInput() {
		assertEquals(true, repOk(), "Representation Invariant should be preserved");
		UserOperationHandler handler = new UserOperationHandler();
		ValidationEnum result = handler.requestLogin("admin", "admi?n");
		ValidationEnum expectedResult = ValidationEnum.INVALID_INPUT;
		assertEquals(expectedResult, result, "admi?n password should be an invalid input");
		assertEquals(true, repOk(), "Representation Invariant should be preserved");
	}
	
	@Test
	void alreadyLoggedIn() {
		assertEquals(true, repOk(), "Representation Invariant should be preserved");
		UserOperationHandler handler = new UserOperationHandler();
		ValidationEnum firstLogin = handler.requestLogin("ahmet", "ahmet");
		ValidationEnum firstExpectedResult = ValidationEnum.VALID_LOGIN;
		ValidationEnum result = handler.requestLogin("ahmet", "ahmet");
		ValidationEnum expectedResult = ValidationEnum.ALREADY_LOGGED_IN;
		assertEquals(firstExpectedResult, firstLogin, "ahmet nickname with ahmet password should be a valid login");
		assertEquals(expectedResult, result, "ahmet nickname with ahmet password should return \"already logged in\" since the same input was used for another login before");
		assertEquals(true, repOk(), "Representation Invariant should be preserved");
	}
	
	@Test
	void incorrectPassword() {
		assertEquals(true, repOk(), "Representation Invariant should be preserved");
		UserOperationHandler handler = new UserOperationHandler();
		ValidationEnum result = handler.requestLogin("ege", "notegespass");
		ValidationEnum expectedResult = ValidationEnum.INCORRECT_PASSWORD;
		assertEquals(expectedResult, result, "notegespass password should be incorrect password for ege nickname");
		assertEquals(true, repOk(), "Representation Invariant should be preserved");
	}
	
	
	@Test
	void nicknameNotFound() {
		assertEquals(true, repOk(), "Representation Invariant should be preserved");
		UserOperationHandler handler = new UserOperationHandler();
		ValidationEnum result = handler.requestLogin("attilagursoy", "123456");
		ValidationEnum expectedResult = ValidationEnum.NICKNAME_NOT_FOUND;
		assertEquals(expectedResult, result, "attilagursoy nickname should be not found");
		assertEquals(true, repOk(), "Representation Invariant should be preserved");
	}
	
	// OVERVIEW: CurrentLogins are unbounded, mutable sets of strings.
	
	////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////         Abstraction Function          ///////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////
	/* typical CurrentLogins is {x1, ..., xn} xi: String, representing nicknames of logged in
	 * players for all i. There are no duplicates in CurrentLogins.
	 * 
	 * The abstraction function is
	 * AF(CurrentLogins) = {CurrentLogins.currentLogins[i].StringValue | 0 <= i < CurrentLogins.currentLogins.size } 
	 * This text can also be found in CurrentLogins.
	 */
	
	
	////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////       Representation Invariant        ///////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////
	/* The rep invariant is:
	 * for all integers i. CurrentLogins.currentLogins[i] is a String &&
	 * for all integers i, j . (0 <= i < j < CurrentLogins.currentLogins.size ==>
	 * CurrentLogins.currentLogins[i].StringValue != CurrentLogins.currentLogins[j].StringValue )
	 * 
	 * Informal:
	 * All elements of CurrentLogins.currentLogins are Strings &&
	 * there are no duplicates in CurrentLogins.currentLogins
	 * This text can also be found in CurrentLogins.
	 */
	
	// for CurrentLogins:
	// real repOK function used in the implementation is in CurrentLogins, named loginSessionIsInProgress.
	public boolean repOk() {
		CurrentLogins currentLogin = CurrentLogins.getCurrentLogins();
		for (int i = 0; i < currentLogin.size(); i++) {
			Object x = currentLogin.get(i);
			if (!(x instanceof String)) return false;
			for (int j = i + 1; j < currentLogin.size(); j++)
				if (x.equals(currentLogin.get(j)))
					return false;
			}
	return true;
	}
	
	@Test
	void repOKtest() {
		assertEquals(true, repOk(), "Representation Invariant should be preserved");
	}
	
}
