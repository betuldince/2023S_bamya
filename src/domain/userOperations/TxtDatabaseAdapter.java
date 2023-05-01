package domain.userOperations;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;

public class TxtDatabaseAdapter implements IDatabaseAdapter {
	
	Path databasePath = Paths.get("src", "databases", "txt", "users.txt");  

	@Override
	public boolean nicknameExists(String nickname) {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(databasePath.toFile()));
			
			String userInfo;
			while ((userInfo = reader.readLine()) != null) {
				if ((userInfo.split("{")[0]).equals(nickname)) {
			        reader.close();
					return true;
				}
			}
	        reader.close();
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return false;
    }

	@Override
	public boolean passwordMatches(String nickname, String password) {
		return retrieveKeyValue(nickname, "password").equals(password);
    }

	@Override
	public void addUser(UserAttributesHashMap userAttributes) {
		
        String userEntry = userAttributes.get("nickname") + "{";
        userAttributes.remove("nickname");
		Iterator<String> userInfoKeys = userAttributes.keySet().iterator();
		String key;
		while (userInfoKeys.hasNext()) {
			key = userInfoKeys.next();
			userEntry += key + ":" + userAttributes.get(key) + ",";
		}
		userEntry = removeLastChar(userEntry);
        userEntry += "}\n";
        
        try {

            BufferedWriter writer = new BufferedWriter(new FileWriter(databasePath.toFile(), true));  
            writer.write(userEntry);
            writer.close();
            
            System.out.println(userAttributes.get("nickname") + "is added to users.txt");
        }
        catch (IOException e) {
            System.err.println("Error appending the us to users.txt: " + e.getMessage());
        }
    }
	
	private static String removeLastChar(String s) {
	    return (s == null || s.length() == 0)
	      ? null 
	      : (s.substring(0, s.length() - 1));
	}
	
	
	// Created in case new keys are added.
	public String retrieveKeyValue(String nickname, String key) {

		try {
			BufferedReader reader = new BufferedReader(new FileReader(databasePath.toFile()));
			
			String userInfo;
			while ((userInfo = reader.readLine()) != null) {
				String userNickname = userInfo.split("{")[0];
				if (!(userNickname.equals(nickname))) {
					continue;
				}
				else {
					String[] userAttributes = removeLastChar(userInfo.split("{")[1]).split(",");
					if (userAttributes == null) {
						reader.close();
						return null;
					}
					for (String attribute: userAttributes) {
						if (!((attribute.split(":")[0]).equals(key))) {
							continue;
						}
						else {
							reader.close();
							return (attribute.split(":")[1]);
						}
					}
				}
			}
			reader.close();
			return null;
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
