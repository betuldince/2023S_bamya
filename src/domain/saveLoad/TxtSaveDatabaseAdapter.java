package domain.saveLoad;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;

class TxtSaveDatabaseAdapter implements ISaveDatabaseAdapter {
	
	Path databasePath = Paths.get("src", "databases", "txt", "save.txt");  

	@Override
	public
	boolean save(GameState gameState) {
		
		String saveEntry = "";
		Iterator<String> gameKeys = gameState.keySet().iterator();
		String key;
		while (gameKeys.hasNext()) {
			key = gameKeys.next();
			saveEntry += key + ":" + gameState.get(key) + ",";
		}
		saveEntry = removeLastChar(saveEntry);
		saveEntry += "}\n";
        
        try {

            BufferedWriter writer = new BufferedWriter(new FileWriter(databasePath.toFile(), true));  
            writer.write(saveEntry);
            writer.close();
            
            System.out.println("Saved succesfully.");
            return true;
        }
        catch (IOException e) {
            System.err.println("Error during saving: " + e.getMessage());
            return false;
        }
    }
	
	private static String removeLastChar(String s) {
	    return (s == null || s.length() == 0)
	      ? null 
	      : (s.substring(0, s.length() - 1));
	}
	
	
	// Created in case new keys are added.
	public String getStatus(String statusKey) {

		try {
			BufferedReader reader = new BufferedReader(new FileReader(databasePath.toFile()));			
			String userInfo;
			while ((userInfo = reader.readLine()) != null) {
				String userNickname = userInfo.split("\\{")[0];
				
					String[] userAttributes = removeLastChar(userInfo.split("\\{")[1]).split(",");
					if (userAttributes == null) {
						reader.close();
						return null;
					}
					for (String attribute: userAttributes) {
						if (!((attribute.split(":")[0]).equals(statusKey))) {
							continue;
						}
						else {
							reader.close();
							return (attribute.split(":")[1]);
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
