package domain.userOperations;

import java.util.ArrayList;

public class CurrentLogins extends ArrayList<String> {

	private static final long serialVersionUID = 5238412815884844650L;
	private static CurrentLogins currentLogins;
	

	private CurrentLogins() {
	}
	
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
	public boolean loginSessionIsInProgress(String nickname) {
		return currentLogins.contains(nickname);
	}

}
