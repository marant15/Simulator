import java.util.Stack;

public class Simulator {
	public Automata automata;

	public Simulator(Automata a) {
		automata = a;
	}

	public boolean verificar(String ent, String pila, String esta) {
		if (ent.length() == 0) {
			if(pila.charAt(pila.length()-1) == 'Z')
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
			char tope = automata.reglas.get(i).tope;
			String accion = automata.reglas.get(i).accion;
			if (esta.equals(estadoi)) {
				if (entrada == '-') {
					a = '-';
					newent = ent;
				} else {
					a = ent.charAt(0);
					newent = ent.substring(1);
				}
				if (entrada == a) {
					if (tope == pila.charAt(pila.length()-1)) {
						if (verificar(newent, doaction(pila, accion), estadof))return true;
					}
				}
			}
		}
		return false;
	}

	public String doaction(String pila, String accion) {
		if (accion.equals("-")) {
			pila = pila.substring(0, pila.length()-1);
		} else if (accion.length() >= 1) {
			for (int i = 0; i < accion.length() - 1; i++) {
				pila = pila + accion.charAt(accion.length() - 2 - i);
			}
		}
		return pila;
	}

}
