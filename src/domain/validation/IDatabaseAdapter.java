package domain.validation;

import java.util.HashMap;

public interface IDatabaseAdapter {
	boolean nicknameExists (String nickname);
	boolean passwordMatches (String nickname, String password);
	void addUser (HashMap<String, String> userAttributes);
}
