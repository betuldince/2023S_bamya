package domain.userOperations;

import java.util.HashMap;

public class UserAttributesHashMap extends HashMap<String, String> {
	private static final long serialVersionUID = 7527978549658845578L;
	private static final String[] keyList = {"nickname", "password", "icon"};
	// Consider adding statistics e.g. win/lose count
	
	public UserAttributesHashMap() {
		
		for (String key: keyList) {
			this.put(key, null);
			this.put("icon", "crown");
		}
	}
}
