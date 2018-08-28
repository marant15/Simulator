
//import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		FrameSimulator simulator= new FrameSimulator();
		FrameMenu frame = new FrameMenu(simulator);
		frame.start();
	}
	/*
	 * <leer,a,Z,leer,AZ>
	 * <leer,a,A,leer,AA>
	 * <leer,b,A,comp,->
	 * <comp,b,A,comp,->
	 */
}
