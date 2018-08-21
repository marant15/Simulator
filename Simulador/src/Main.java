import java.util.ArrayList;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Automata auto = new Automata();
		ArrayList<Regla> reglas = new ArrayList<Regla>();
		/*reglas.add(new Regla("leer",'a','Z',"leer","AZ"));
		reglas.add(new Regla("leer",'a','A',"leer","AA"));
		reglas.add(new Regla("leer",'b','A',"comp","-"));
		reglas.add(new Regla("comp",'b','A',"comp","-"));*/
		reglas.add(new Regla("leer",'a','Z',"leer","AAZ"));
		reglas.add(new Regla("leer",'a','Z',"leer","AZ"));
		reglas.add(new Regla("leer",'a','A',"leer","AAA"));
		reglas.add(new Regla("leer",'a','A',"leer","AA"));
		reglas.add(new Regla("leer",'b','A',"leerb","-"));
		reglas.add(new Regla("leerb",'b','A',"leerb","-"));
		auto.reglas = reglas;
		Simulator sim = new Simulator(auto);
		String pila = "Z";
		System.out.println(sim.verificar("",pila,"leer"));
		
	}

}
