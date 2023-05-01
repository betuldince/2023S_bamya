package domain.userOperations;

import java.util.EventListener;

public interface LoginListener extends EventListener {
	public void loginEventOccured(LoginEvent loginEvent);

}
