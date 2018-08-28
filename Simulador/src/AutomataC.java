import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import com.google.gson.*;
public class AutomataC {

	public Automata auto;
	public AutomataC() {
		auto = new Automata();
	}
	
	public void save() {
		Gson gson = new Gson();
		try {
			Writer www = new FileWriter("saves/"+auto.nombre+".json");
			gson.toJson(auto,www);
			www.flush();
			www.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void charge(String path) {
		Gson gson = new Gson();
		try {
			auto = gson.fromJson(new FileReader(path), Automata.class);
		} catch (JsonSyntaxException | JsonIOException | FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
