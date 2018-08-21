import java.util.ArrayList;

public class Automata {
	public ArrayList<String> estados;
	public ArrayList<Character> alfabetoE;
	public ArrayList<Character> alfabetoP;
	public ArrayList<Regla> reglas;
	public String estadoi;
	public ArrayList<String> estadosf;
	
	public Automata() {
		estados = new ArrayList<String>();
		alfabetoE = new ArrayList<Character>();
		alfabetoP = new ArrayList<Character>();
		reglas = new ArrayList<Regla>();
		estadoi = "";
		estadosf = new ArrayList<String>();
	}
	
	public Automata(ArrayList<String> est, ArrayList<Character> ae, ArrayList<Character> af, ArrayList<Regla> reg, String ei, ArrayList<String> ef) {
		estados = est;
		alfabetoE = ae;
		alfabetoP = af;
		reglas = reg;
		estadoi = ei;
		estadosf = ef;
	}
	
}
