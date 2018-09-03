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
	public boolean verificar(String ent, String pila, String esta) {
		if (ent.length() == 0) {
			if(pila.charAt(pila.length()-1) == 'Z' || automata.estadosf.contains(esta))
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
						if (verificar(newent, doaction(pila, accion,automata.reglas.get(i),ent), estadof))return true;
					}
				}
			}
		}
		return false;
	}

	public String doaction(String pila, String accion, Regla rule,String falta) {
		if (accion.equals("-")) {
			pila = pila.substring(0, pila.length()-1);
		} else if (accion.length() >= 1) {
			for (int i = 0; i < accion.length() - 1; i++) {
				pila = pila + accion.charAt(accion.length() - 2 - i);
			}
		}
		Step aux = new Step();
		aux.cinta="cinta: " +cadena;
		if(falta.length() >1)aux.cintaFL="falta leer: "+ falta.substring(1);
		else aux.cintaFL =("falta leer: ");
		aux.cintaL=("ya leido: " + cadena.substring(0, cadena.length()-falta.length()+1));
		aux.regla=("regla usada: "+ rule.toString());
		aux.estado=("estado actual: "+rule.estadof);
		aux.pila = pila;
		steps.add(aux);
		return pila;
	}

}
