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
			saveEntry += "//{" + key + ":" + gameState.get(key) + "//}";
		}
		saveEntry = removeLastChar(saveEntry);
        
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
	public GameState load() {
		GameState gameState = new GameState();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(databasePath.toFile()));			
			String state = reader.readLine();
			String[] statusKeysValues =  state.split("\\{");
			for (String statusKeyValue: statusKeysValues) {
				statusKeyValue = removeLastChar(statusKeyValue);
				String key = statusKeyValue.split(":")[0];
				String value = statusKeyValue.split(":")[1];
				gameState.put(key, value);
			}

			reader.close();
			return gameState;
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
