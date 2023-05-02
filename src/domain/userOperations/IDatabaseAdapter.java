package domain.userOperations;

interface IDatabaseAdapter {
	boolean nicknameExists (String nickname);
	boolean passwordMatches (String nickname, String password);
	void addUser (UserAttributesHashMap userAttributes);
	String retrieveKeyValue(String nickname, String key);
}
