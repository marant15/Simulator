import java.util.ArrayList;

//import java.util.Stack;

public class Simulator {
	public Automata automata;
	public String cadena;
	public Container frame;
	public ArrayList<Step> steps;

	public Simulator(Automata a, Container f) {
		automata = a;
		cadena = "";
		frame = f;
		steps = new ArrayList<Step>();
	}

	public boolean verificar(String ent, ArrayList<String> pilas, String esta) {
		if (ent.length() == 0) {
			if (verificarpilas(pilas) || automata.estadosf.contains(esta))
				return true;
			else
				return false;
		}
		char a;
		String newent;
		for (int i = 0; i < automata.reglas.size(); i++) {
			String estadoi = automata.reglas.get(i).estadoi;
			char entrada = automata.reglas.get(i).entrada;
			String estadof = automata.reglas.get(i).estadof;
			if (esta.equals(estadoi)) {
				if (entrada == '-') {
					a = '-';
					newent = ent;
				} else {
					a = ent.charAt(0);
					newent = ent.substring(1);
				}
				if (entrada == a) {
					if (verificartopes(pilas, i)) {
						if (verificar(newent,doaction((ArrayList<String>)pilas.clone(), automata.reglas.get(i).accion, automata.reglas.get(i), ent), estadof))
							return true;
					}
				}
			}
		}
		return false;
	}

	public boolean verificartopes(ArrayList<String> pilas, int regla) {
		boolean ver = true;
		for (int i = 0; i < pilas.size(); i++) {
			ver = automata.reglas.get(regla).tope.get(i) == pilas.get(i).charAt(pilas.get(i).length() - 1);
			if (!ver)
				return false;
		}
		return ver;
	}

	public boolean verificarpilas(ArrayList<String> pilas) {
		boolean ver = true;
		for (int i = 0; i < pilas.size(); i++) {
			ver = pilas.get(i).charAt(pilas.get(i).length() - 1) == automata.initialstack;
			if (!ver)
				return false;
		}
		return ver;
	}

	public ArrayList<String> doaction(ArrayList<String> pila, ArrayList<String> accion, Regla rule, String falta) {
		for (int i = 0; i < pila.size(); i++) {
			if (accion.get(i).equals("-")) {
				pila.set(i, pila.get(i).substring(0, pila.get(i).length() - 1));
			} else if (accion.get(i).length() >= 1) {
				for (int j = 0; j < accion.get(i).length() - 1; j++) {
					pila.set(i, pila.get(i) + accion.get(i).charAt(accion.get(i).length() - 2 - j));
				}
			}
		}
		Step aux = new Step();
		aux.cinta = "cinta: " + cadena;
		if (falta.length() > 1)
			aux.cintaFL = "falta leer: " + falta.substring(1);
		else
			aux.cintaFL = ("falta leer: ");
		aux.cintaL = ("ya leido: " + cadena.substring(0, cadena.length() - falta.length() + 1));
		aux.regla = ("regla usada: " + rule.toString());
		aux.estado = ("estado actual: " + rule.estadof);
		aux.pila = pila;
		steps.add(aux);
		return pila;
	}

}
