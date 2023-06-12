package domain.saveLoad;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;    

public class JsonSaveDatabaseAdapter implements ISaveDatabaseAdapter {
	
	Path databasePath = Paths.get("src", "databases", "json", "save.json"); 
	
	@Override
	public boolean save(GameState gameState) {
	      JSONObject jsonObject = new JSONObject(gameState);

	      try {
	         FileWriter file = new FileWriter(databasePath.toFile(), false);
	         file.write(jsonObject.toJSONString());
	         file.close();
		     System.out.println("JSON file created: "+jsonObject);
	         return true;
	      } catch (IOException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	         return false;
	      }
	}

	@Override
	public GameState load() {
		
		String[] keys = GameState.getKeyList();
		GameState gameState = new GameState();
		
		JSONParser parser = new JSONParser();
		JSONObject state;
		try {
			state = (JSONObject) parser.parse(new FileReader(databasePath.toFile()));
			for (String key : keys){
				String value = (String) state.get(key);
			    gameState.put(key, value);
			    System.out.println(value);
			}
			return gameState;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return null;
	}

}
