import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import javax.swing.JOptionPane;

import com.google.gson.*;
public class AutomataC {

	public Automata auto;
	public AutomataC() {
		auto = new Automata();
	}
	
	public void save(String path) {
		Gson gson = new Gson();
		try {
			Writer www = new FileWriter(path);
			gson.toJson(auto,www);
			www.flush();
			www.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public boolean charge(String path) {
		Gson gson = new Gson();
		try {
			auto = gson.fromJson(new FileReader(path), Automata.class);
			return true;
		} catch (JsonSyntaxException | JsonIOException | FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "archivo erroneo");
		}
		return false;
	}
}
