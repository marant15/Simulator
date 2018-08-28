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
}
