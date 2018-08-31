import javax.swing.*;

import java.awt.TextField;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;  
public class FrameMenu extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Automata auto;
	ArrayList<Regla> reglas;
	ArrayList<String> finalStates;
	ArrayList<String> states;
	ArrayList<Character> alphabetIN;
	ArrayList<Character> alphabetStack;
	String initialState;
	String initialStack;
	

	FrameSimulator simulator;

	JFrame frame;
	JOptionPane editPane;

	TextField tfStates;
	TextField tfAlphabetIN;
	TextField tfAlphabetStack;
	TextField tfstackAction;
	TextField tfInitialStack;
	TextField editOP;

	JComboBox cbInitialState;
	JComboBox cbFinalState;
	JComboBox cbTopStack;

	JComboBox cbStates;
	JComboBox cbAlphabetIN;
	JComboBox cbAlphabetStack;
	JComboBox cbNextState;

	JButton buttonStates;
	JButton buttonAlphabetIN;
	JButton buttonAlphabetStack;
	JButton buttonInitialState;
	JButton buttonFinalState;
	JButton buttonInitialStack;
	JButton buttonSimulador;
	JButton buttonRules;
	
	JButton buttonEStates;
	JButton buttonEAlphabetIN;
	JButton buttonEAlphabetStack;
	JButton buttonEInitialState;
	JButton buttonEInitialStack;
	JButton buttonERules;
	
	JButton buttonDStates;
	JButton buttonDAlphabetIN;
	JButton buttonDAlphabetStack;
	JButton buttonDFinalState;
	JButton buttonDRules;

	JLabel labelWarnings;
	JLabel labelStates;
	JLabel labelAlphabetIn;
	JLabel labelAlphabetStack;
	JLabel labelInitialState;
	JLabel labelFinalState;
	JLabel labelInitialStack;
	JLabel labelRules;
	JLabel showStates;
	JLabel showAlphabetIn;
	JLabel showAlphabetStack;
	JLabel showInitialState;
	JLabel showFinalStates;
	JLabel showInitialStack;
	JLabel showRules;


	@SuppressWarnings("unchecked")
	public FrameMenu(FrameSimulator simul) {
		initialState = "";
		simulator = simul;
		auto = new Automata();
		reglas = new ArrayList<Regla>();
		finalStates =new ArrayList<String>();
		states=new ArrayList<String>();
		alphabetIN = new ArrayList<Character>();;
		alphabetStack =  new ArrayList<Character>();

		frame=new JFrame();
		editPane = new JOptionPane();

		tfStates = new TextField(); 
		tfAlphabetIN = new TextField();
		tfAlphabetStack = new TextField();
		tfstackAction = new TextField();
		tfInitialStack = new TextField();
		editOP = new TextField();
		
		cbInitialState = new JComboBox();
		cbFinalState = new JComboBox();

		cbStates = new JComboBox();
		cbAlphabetIN = new JComboBox();
		cbAlphabetStack = new JComboBox();
		cbNextState = new JComboBox();

		buttonStates = new JButton("Add");
		buttonAlphabetIN = new JButton("Add");
		buttonAlphabetStack = new JButton("Add");
		buttonInitialState = new JButton("Add");
		buttonFinalState = new JButton("Add");
		buttonInitialStack = new JButton("Add");
		buttonSimulador=new JButton("Simulate");
		buttonRules = new JButton("Add Rule");
		
		buttonEStates = new JButton("Edit");
		buttonEAlphabetIN = new JButton("Edit");
		buttonEAlphabetStack = new JButton("Edit");
		buttonEInitialState = new JButton("Edit");
		buttonEInitialStack = new JButton("Edit");;
		buttonERules = new JButton("Edit Rule");
		
		buttonDStates = new JButton("Delete");
		buttonDAlphabetIN = new JButton("Delete");
		buttonDAlphabetStack = new JButton("Delete");
		buttonDFinalState = new JButton("Delete");
		buttonDRules = new JButton("Delete Rule");
		
		labelWarnings = new JLabel("Warnings");
		labelStates = new JLabel("States");
		labelAlphabetIn = new JLabel("Alphabet In");
		labelAlphabetStack = new JLabel("Alphabet Stack");
		labelInitialState = new JLabel("Initial State");
		labelFinalState = new JLabel("Final State");
		labelInitialStack = new JLabel("Initial Element");
		labelRules = new JLabel("Rules");
		showStates = new JLabel();
		showAlphabetIn = new JLabel();
		showAlphabetStack = new JLabel();
		showInitialState = new JLabel();
		showFinalStates = new JLabel();
		showInitialStack = new JLabel();
		showRules = new JLabel();
		

		tfStates.setBounds(110, 10, 70, 20);
		tfAlphabetIN.setBounds(110, 40, 20, 20);
		tfAlphabetStack.setBounds(110, 70, 20, 20);
		tfInitialStack.setBounds(110, 160, 50, 20);
		editOP.setBounds(10, 10, 100, 20);

		cbInitialState.setBounds(110,100,70,20);
		cbFinalState.setBounds(110, 130, 70, 20);

		cbStates.setBounds(110,190,80,20);
		cbAlphabetIN.setBounds(200, 190, 60, 20);
		cbAlphabetStack.setBounds(270, 190, 60, 20);
		cbNextState.setBounds(340,190,70,20);
		tfstackAction.setBounds(420, 190, 60, 20);
		
		buttonStates.setBounds(200, 10, 60, 20);
		buttonAlphabetIN.setBounds(200, 40, 60, 20);
		buttonAlphabetStack.setBounds(200, 70, 60, 20);
		buttonInitialState.setBounds(200, 100, 60, 20);
		buttonFinalState.setBounds(200, 130, 60, 20);
		buttonInitialStack.setBounds(200,160,60,20);
		buttonRules.setBounds(110,220,100,20);
		buttonSimulador.setBounds(10,260,100,20);
		
		buttonEStates.setBounds(260, 10, 60, 20);
		buttonEAlphabetIN.setBounds(260, 40, 60, 20);
		buttonEAlphabetStack.setBounds(260, 70, 60, 20);
		buttonEInitialState.setBounds(260, 100, 60, 20);
		buttonEInitialStack.setBounds(260,160,60,20);
		buttonERules.setBounds(220,220,100,20);
		
		buttonDStates.setBounds(320, 10, 70, 20);
		buttonDAlphabetIN.setBounds(320, 40, 70, 20);
		buttonDAlphabetStack.setBounds(320, 70, 70, 20);
		buttonDFinalState.setBounds(320, 130, 70, 20);
		buttonDRules.setBounds(330,220,100,20);
		
		labelWarnings.setBounds(210, 260, 150, 20);
		labelStates.setBounds(10,10,100,20);
		labelAlphabetIn.setBounds(10,40,100,20);
		labelAlphabetStack.setBounds(10, 70, 100, 20);
		labelInitialState.setBounds(10,100,100,20);
		labelFinalState.setBounds(10,130,100,20);
		labelInitialStack.setBounds(10,160,150,20);
		labelRules.setBounds(10,190,100,20);
		
		showStates.setBounds(400,10,200,20);
		showAlphabetIn.setBounds(400, 40, 200, 20);
		showAlphabetStack.setBounds(400, 70, 200, 20);
		showInitialState.setBounds(400, 100, 40, 20);
		showFinalStates.setBounds(400, 130, 200, 20);
		showInitialStack.setBounds(400, 160, 40, 20);
		showRules.setBounds(10,290,250,310);
		

		frame.add(tfStates);
		frame.add(tfAlphabetIN);
		frame.add(tfAlphabetStack);
		frame.add(tfInitialStack);
		
		frame.add(cbInitialState);
		frame.add(cbFinalState);
		
		frame.add(cbStates);
		frame.add(cbAlphabetIN);
		frame.add(cbAlphabetStack);
		frame.add(cbNextState);
		frame.add(tfstackAction);
		
		frame.add(buttonStates);
		frame.add(buttonAlphabetIN);
		frame.add(buttonAlphabetStack);
		frame.add(buttonInitialState);
		frame.add(buttonFinalState);
		frame.add(buttonInitialStack);
		frame.add(buttonRules);
		frame.add(buttonSimulador);
		
		frame.add(buttonEStates);
		frame.add(buttonEAlphabetIN);
		frame.add(buttonEAlphabetStack);
		frame.add(buttonEInitialState);
		frame.add(buttonEInitialStack);
		frame.add(buttonERules);
		
		frame.add(buttonDStates);
		frame.add(buttonDAlphabetIN);
		frame.add(buttonDAlphabetStack);
		frame.add(buttonDFinalState);
		frame.add(buttonDRules);
		
		
		frame.add(labelWarnings);
		frame.add(labelStates);
		frame.add(labelStates);
		frame.add(labelAlphabetIn);
		frame.add(labelAlphabetStack);
		frame.add(labelInitialState);
		frame.add(labelFinalState);
		frame.add(labelInitialStack);
		frame.add(labelRules);
		frame.add(showStates);
		frame.add(showAlphabetIn);
		frame.add(showAlphabetStack);
		frame.add(showInitialState);
		frame.add(showFinalStates);
		frame.add(showInitialStack);
		frame.add(showRules);
		frame.setSize(800,600);  
		frame.setLayout(null);  
		frame.setVisible(true);
		
		editPane.add(editOP);
		editPane.setSize(200,200);
		editPane.setVisible(false);
		
	}

	public List<String> getTokens(String str) {
		List<String> tokens = new ArrayList<>();
		StringTokenizer tokenizer = new StringTokenizer(str, ",");
		while (tokenizer.hasMoreElements()) {
			tokens.add(tokenizer.nextToken());
		}
		return tokens;
	}

	public void start() {

		buttonStates.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){
				boolean isNot=true;
				if(states.size()<1) {
					states.add(tfStates.getText());
					cbInitialState.addItem(tfStates.getText());
					cbFinalState.addItem(tfStates.getText());
					cbStates.addItem(tfStates.getText());
					cbNextState.addItem(tfStates.getText());
					showStates.setText(print(states));
				}else {
					for (int i = 0; i < states.size(); i++) {
						if(states.get(i).equals(tfStates.getText())) {
							JOptionPane.showMessageDialog(null, "ESTADO EXISTENTE!");
							isNot = false;
							break;
						}
					}
					if(isNot) {
						states.add(tfStates.getText());
						cbInitialState.addItem(tfStates.getText());
						cbFinalState.addItem(tfStates.getText());
						cbStates.addItem(tfStates.getText());
						cbNextState.addItem(tfStates.getText());
						labelWarnings.setText("");
						showStates.setText(print(states));
					}
				}					
			}  
		});

		buttonAlphabetIN.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){
				boolean isNot=true;
				if(alphabetIN.size()<1) {
					alphabetIN.add(tfAlphabetIN.getText().charAt(0));
					cbAlphabetIN.addItem(tfAlphabetIN.getText().charAt(0));
					showAlphabetIn.setText(print(alphabetIN));
				}else {
					for (int i = 0; i < alphabetIN.size(); i++) {
						if(alphabetIN.get(i).toString().equals(tfAlphabetIN.getText())) {
							JOptionPane.showMessageDialog(null, "YA ES PARTE DEL ALFABETO DE ENTRADA!");
							isNot = false;
							break;
						}
					}
					
					if(isNot) {
						alphabetIN.add(tfAlphabetIN.getText().charAt(0));
						cbAlphabetIN.addItem(tfAlphabetIN.getText().charAt(0));
						showAlphabetIn.setText(print(alphabetIN));
					}
				}
			}  
		});

		buttonAlphabetStack.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){
				boolean isNot=true;
				if(alphabetStack.size()==0) {
					alphabetStack.add(tfAlphabetStack.getText().charAt(0));
					cbAlphabetStack.addItem(tfAlphabetStack.getText().charAt(0));
					showAlphabetStack.setText(print(alphabetStack));
				}else {
					for (int i = 0; i < alphabetStack.size(); i++) {
						if(alphabetStack.get(i).toString().equals(tfAlphabetStack.getText())) {
							JOptionPane.showMessageDialog(null, "YA ES PARTE DEL ALFABETO DE LA PILA!");
							isNot = false;
							break;
						}
					}
					
					if(isNot) {
						alphabetStack.add(tfAlphabetStack.getText().charAt(0));
						cbAlphabetStack.addItem(tfAlphabetStack.getText().charAt(0));
						showAlphabetStack.setText(print(alphabetStack));
					}
				}
			}  
		});

		buttonInitialState.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){
				initialState = (String) cbInitialState.getSelectedItem();
				showInitialState.setText(initialState);
				buttonInitialState.setEnabled(false);
			}  
		});

		buttonFinalState.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){
				boolean isNot=true;
				if(finalStates.size()<1) {
					finalStates.add((String) cbFinalState.getSelectedItem());
					showFinalStates.setText(print(finalStates));
				}else {
					for (int i = 0; i < finalStates.size(); i++) {
						if(finalStates.get(i).equals((String) cbFinalState.getSelectedItem())) {
							JOptionPane.showMessageDialog(null, "YA ES UN ESTADO FINAL!");
							isNot = false;
							break;
						}
					}
					
					if(isNot) {
						finalStates.add(tfStates.getText());
						labelWarnings.setText("");
						showFinalStates.setText(print(finalStates));
					}
				}		
			}  
		});
		
		buttonInitialStack.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){
				initialStack = tfInitialStack.getText();
				cbAlphabetStack.addItem(tfInitialStack.getText().charAt(0));
				buttonInitialStack.setEnabled(false);
				showInitialStack.setText(""+initialStack);
			}  
		});

		buttonRules.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){ 
				String iState = (String) cbStates.getSelectedItem();
				Character alpha = (Character) cbAlphabetIN.getSelectedItem();
				Character stackTop =(Character) cbAlphabetStack.getSelectedItem();
				String fState = (String) cbNextState.getSelectedItem();
				String action = tfstackAction.getText();
				reglas.add(new Regla(iState,alpha,stackTop,fState,action));
				String text = "<html>"+ printRules() +"</html>";
				showRules.setText(text);
			}  
		});

		buttonSimulador.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){
				simulator.setvisible();
				simulator.simulation(reglas, auto, initialState, ""+initialStack);
				
			}  
		});
		
		buttonEStates.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){
				if(tfStates.getText().equals(null)) {
					JOptionPane.showMessageDialog(null, "NO PUSISTE QUE EDITAR!");
				}else 
				if(states.size()<1)
				{
					JOptionPane.showMessageDialog(null, "TODAVIA NO HAY ESTADOS!");
				}else{
					String change= "";
					change = editPane.showInputDialog("Cambiar el nombre del estado "+tfStates.getText()+" al siguiente:");					
					for (int i = 0; i < states.size(); i++) {
						if(tfStates.getText().equals(states.get(i)) && !(change.equals((null)))) {
							states.set(i, change);
							cbInitialState.removeItem(tfStates.getText());
							cbInitialState.addItem(change);
							if(initialState.equals(tfStates.getText())) {
								initialState = change;
								showInitialState.setText(initialState);
							}
							
							cbFinalState.removeItem(tfStates.getText());
							cbFinalState.addItem(change);
							cbStates.removeItem(tfStates.getText());
							cbStates.addItem(change);
							cbNextState.removeItem(tfStates.getText());
							cbNextState.addItem(change);
							break;
						}
						showStates.setText(print(states));
					}
					
					for (int i = 0; i < finalStates.size(); i++) {
						if(finalStates.get(i).equals(tfStates.getText())) {
							finalStates.set(i, change);
							break;
						}
					}
					showInitialState.setText(print(finalStates));
					
					for (int i = 0; i < reglas.size(); i++) {
						if(reglas.get(i).estadoi.equals(tfStates.getText())) {
							Regla regla = reglas.get(i);
							regla.estadoi = change;
							reglas.set(i, regla);
						}
						
						if(reglas.get(i).estadof.equals(tfStates.getText())) {
							Regla regla = reglas.get(i);
							regla.estadof = change;
							reglas.set(i, regla);
						}
					}
					String text = "<html>"+ printRules() +"</html>";
					showRules.setText(text);
				}
			}  
		});
		
		buttonEAlphabetIN.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){
				if(tfAlphabetIN.getText().equals(null)) {
					JOptionPane.showMessageDialog(null, "NO PUSISTE QUE EDITAR!");
				}else 
				if(alphabetIN.size()<1){
					JOptionPane.showMessageDialog(null, "TODAVIA NO HAY ALFABETO!");
				}else{
					String change= "";
					change = editPane.showInputDialog("Cambiar letra del alfabeto ("+tfAlphabetIN.getText()+") al siguiente:");
					for (int i = 0; i < alphabetIN.size(); i++) {
						if((alphabetIN.get(i) == tfAlphabetIN.getText().charAt(0))&& !(change.equals((null)))) {
							alphabetIN.set(i, change.charAt(0));						
							cbAlphabetIN.removeItem(tfAlphabetIN.getText().charAt(0));
							cbAlphabetIN.addItem(change.charAt(0));
							break;
						}
					}
					showAlphabetIn.setText(print(alphabetIN));
					for (int i = 0; i < reglas.size(); i++) {
						if(reglas.get(i).entrada == tfAlphabetIN.getText().charAt(0)) {
							Regla regla = reglas.get(i);
							regla.entrada = change.charAt(0);
							reglas.set(i, regla);
						}
					}
					String text = "<html>"+ printRules() +"</html>";
					showRules.setText(text);
				}
			}  
		});
		
		buttonEAlphabetStack.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){
				if(tfAlphabetStack.getText().equals(null)) {
					JOptionPane.showMessageDialog(null, "NO PUSISTE QUE EDITAR!");
				}else 
				if(alphabetStack.size()<1){
					JOptionPane.showMessageDialog(null, "TODAVIA NO HAY ALFABETO!");
				}else{
					String change= "";
					change = editPane.showInputDialog("Cambiar letra del alfabeto ("+tfAlphabetStack.getText()+") al siguiente:");
					for (int i = 0; i < alphabetStack.size(); i++) {
						if((alphabetStack.get(i) == tfAlphabetStack.getText().charAt(0))&& !(change.equals((null)))) {
							alphabetStack.set(i, change.charAt(0));						
							cbAlphabetStack.removeItem(tfAlphabetStack.getText().charAt(0));
							cbAlphabetStack.addItem(change.charAt(0));
							break;
						}
					}
					showAlphabetStack.setText(print(alphabetStack));
					for (int i = 0; i < reglas.size(); i++) {
						if(reglas.get(i).tope == tfAlphabetStack.getText().charAt(0)) {
							Regla regla = reglas.get(i);
							regla.tope = change.charAt(0);
							reglas.set(i, regla);
						}
						char[] array = reglas.get(i).accion.toCharArray();
						for (int j = 0; j < array.length; j++) {
							if(array[j]==tfAlphabetStack.getText().charAt(0)) {
								array[j]=change.charAt(0);
							}
						}
						
						Regla regla = reglas.get(i);
						regla.accion = conect(array);
						reglas.set(i, regla);
					}
					String text = "<html>"+ printRules() +"</html>";
					showRules.setText(text);
				}
			}    
		});
		
		buttonEInitialState.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){
				initialState = (String) cbInitialState.getSelectedItem();
				showInitialState.setText(initialState);
			}  
		});
		
		buttonEInitialStack.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){
				for (int i = 0; i < reglas.size(); i++) {
					if(reglas.get(i).tope == initialStack.charAt(0)) {
						Regla regla = reglas.get(i);
						regla.tope = tfInitialStack.getText().charAt(0);
						reglas.set(i, regla);
					}
					char[] array = reglas.get(i).accion.toCharArray();
					for (int j = 0; j < array.length; j++) {
						if(array[j]==initialStack.charAt(0)) {
							array[j]=tfInitialStack.getText().charAt(0);
						}
					}
					Regla regla = reglas.get(i);
					regla.accion = conect(array);
					reglas.set(i, regla);
				}
				cbAlphabetStack.removeItem(initialStack);
				cbAlphabetStack.addItem(tfAlphabetStack.getText().charAt(0));
				initialStack = tfInitialStack.getText();
				String text = "<html>"+ printRules() +"</html>";
				showRules.setText(text);
				showInitialStack.setText(""+initialStack);
			}  
		});
		
		buttonERules.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){
			}  
		});
		
		buttonDStates.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){
			}  
		});
		buttonDAlphabetIN.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){
			}  
		});
		buttonDAlphabetStack.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){
			}  
		});
		buttonDFinalState.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){
			}  
		});
		buttonDRules.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){
			}  
		});
	}
	
	public String printRules() {
		String aux="";
		for (int i = 0; i < reglas.size(); i++) {
			Regla regla = reglas.get(i);
			aux = aux + regla.estadoi+","+regla.entrada+","+regla.tope+","+regla.estadof+","+regla.accion+"<br>";
		}
		return aux;
	}
	
	public String print(ArrayList array) {
		String aux="";
		for (int i = 0; i < array.size(); i++) {
			aux = aux+array.get(i)+",";
		}
		return aux;
	}
	
	public String conect (char[] cadena) {
		String conection="";
		for (int i = 0; i < cadena.length; i++) {
			conection+=cadena[i];
		}
		return conection;
	}
}
