package domain.userOperations;

import java.util.Iterator;

public class UserAttributes extends UserOperation {
	
	private UserAttributesHashMap userAttributes;

	public UserAttributes(String nickname) {
		super(nickname);
		setUserAttributes(nickname);
	}
	
	private void setUserAttributes(String nickname) {
		boolean nicknameIsCorrect = databaseAdapter.nicknameExists(nickname);
		if (!nicknameIsCorrect) {
			return;
		}
		
		Iterator<String> userInfoKeys = userAttributes.keySet().iterator();
		String key;
		while (userInfoKeys.hasNext()) {
			key = userInfoKeys.next();
			String value = databaseAdapter.retrieveKeyValue(nickname, key);
			userAttributes.put(key, value);
		}
	}
	
	public String getUserAttribute(String key) {
		return userAttributes.get(key);
	}

}
