package domain.userOperations;

import java.util.ArrayList;

public class CurrentLogins extends ArrayList<String> {

	private static final long serialVersionUID = 5238412815884844650L;
	private static CurrentLogins currentLogins;
	

	private CurrentLogins() {
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
	
	public static CurrentLogins getCurrentLogins() {
		
		if (currentLogins == null) {
			currentLogins = new CurrentLogins();
		}
		
		return currentLogins;	
	}
	
	public void addLoginSession(String nickname) {
		currentLogins.add(nickname);
	}
	public void removeLoginSession(String nickname) {
		currentLogins.remove(nickname);
	}
	
	// real repOK (without checking if every element is String)
	public boolean loginSessionIsInProgress(String nickname) {
		return currentLogins.contains(nickname);
	}

}
