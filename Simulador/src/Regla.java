import java.util.ArrayList;

public class Regla {
	public String estadoi;
	public char entrada;
	public String estadof;
	public ArrayList<Character> tope;
	public ArrayList<String> accion;
	
	public Regla(String i, char e, ArrayList<Character> t, String f, ArrayList<String> a) {
		estadoi = i;
		entrada = e;
		estadof = f;
		tope = t;
		accion = a;
	}
	
	public String toString() {
		return "<"+estadoi+", "+entrada+", "+estadof+", "+tope+", "+accion+">";
	}
}
