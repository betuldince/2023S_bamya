package domain.userOperations;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class UserAttributes extends UserOperation {
	
	private UserAttributesHashMap userAttributesHashMap;

	public UserAttributes(String nickname) {
		super(nickname);
		userAttributesHashMap = new UserAttributesHashMap();
		setUserAttributes(nickname);
	}
	
	private void setUserAttributes(String nickname) {
		boolean nicknameIsCorrect = databaseAdapter.nicknameExists(nickname);
		if (!nicknameIsCorrect) {
			return;
		}
		
		Iterator<String> userInfoKeys = userAttributesHashMap.keySet().iterator();
		String key;
		while (userInfoKeys.hasNext()) {
			key = userInfoKeys.next();
			String value = databaseAdapter.retrieveKeyValue(nickname, key);
			userAttributesHashMap.put(key, value);
		}
	}
	
	public String getUserAttribute(String key) {
		return userAttributesHashMap.get(key);
	}
	
	public Icon getUserIcon() {
		String iconName = this.getUserAttribute("icon");
		Path iconPath = Paths.get("src", "UI", "icons", iconName + ".png");
		ImageIcon icon = new ImageIcon(iconPath.toString(), iconName);
		return icon;
	}

}
