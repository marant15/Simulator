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

	TextField tfStates;
	TextField tfAlphabetIN;
	TextField tfAlphabetStack;
	TextField tfstackAction;
	TextField tfInitialStack;

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

	JLabel labelWarnings;
	JLabel labelStates;
	JLabel labelAlphabetIn;
	JLabel labelAlphabetStack;
	JLabel labelInitialState;
	JLabel labelFinalState;
	JLabel labelInitialStack;
	JLabel labelRules;
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

		tfStates = new TextField(); 
		tfAlphabetIN = new TextField();
		tfAlphabetStack = new TextField();
		tfstackAction = new TextField();
		tfInitialStack = new TextField();
		
		cbInitialState = new JComboBox();
		cbFinalState = new JComboBox();

		cbStates = new JComboBox();
		cbAlphabetIN = new JComboBox();
		cbAlphabetStack = new JComboBox();
		cbNextState = new JComboBox();

		buttonStates = new JButton("Insert");
		buttonAlphabetIN = new JButton("Insert");
		buttonAlphabetStack = new JButton("Insert");
		buttonInitialState = new JButton("Insert");
		buttonFinalState = new JButton("Insert");
		buttonInitialStack = new JButton("Insert");
		buttonSimulador=new JButton("Simulate");
		buttonRules = new JButton("Add Rule");
		
		labelWarnings = new JLabel("Warnings");
		labelStates = new JLabel("States");
		labelAlphabetIn = new JLabel("Alphabet In");
		labelAlphabetStack = new JLabel("Alphabet Stack");
		labelInitialState = new JLabel("Initial State");
		labelFinalState = new JLabel("Final State");
		labelInitialStack = new JLabel("Initial Element");
		labelRules = new JLabel("Rules");
		showRules = new JLabel();
		

		tfStates.setBounds(110, 10, 70, 20);
		tfAlphabetIN.setBounds(110, 40, 20, 20);
		tfAlphabetStack.setBounds(110, 70, 20, 20);
		tfInitialStack.setBounds(110, 160, 50, 20);

		cbInitialState.setBounds(110,100,70,20);
		cbFinalState.setBounds(110, 130, 70, 20);

		cbStates.setBounds(110,190,80,20);
		cbAlphabetIN.setBounds(200, 190, 60, 20);
		cbAlphabetStack.setBounds(270, 190, 60, 20);
		cbNextState.setBounds(340,190,70,20);
		tfstackAction.setBounds(420, 190, 60, 20);
		
		buttonStates.setBounds(280, 10, 80, 20);
		buttonAlphabetIN.setBounds(280, 40, 80, 20);
		buttonAlphabetStack.setBounds(280, 70, 80, 20);
		buttonInitialState.setBounds(280, 100, 80, 20);
		buttonFinalState.setBounds(280, 130, 80, 20);
		buttonInitialStack.setBounds(280,160,80,20);
		buttonRules.setBounds(110,220,100,20);
		buttonSimulador.setBounds(10,260,100,20);
		
		labelWarnings.setBounds(210, 260, 150, 20);
		labelStates.setBounds(10,10,100,20);
		labelAlphabetIn.setBounds(10,40,100,20);
		labelAlphabetStack.setBounds(10, 70, 100, 20);
		labelInitialState.setBounds(10,100,100,20);
		labelFinalState.setBounds(10,130,100,20);
		labelInitialStack.setBounds(10,160,150,20);
		labelRules.setBounds(10,190,100,20);
		showRules.setBounds(10,290,250,500);
		

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
		frame.add(labelWarnings);
		frame.add(labelStates);
		frame.add(labelStates);
		frame.add(labelAlphabetIn);
		frame.add(labelAlphabetStack);
		frame.add(labelInitialState);
		frame.add(labelFinalState);
		frame.add(labelInitialStack);
		frame.add(labelRules);
		frame.add(showRules);
		frame.setSize(800,800);  
		frame.setLayout(null);  
		frame.setVisible(true);
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
				}else {
					for (int i = 0; i < states.size(); i++) {
						if(states.get(i).equals(tfStates.getText())) {
							labelWarnings.setText("ESTADO EXISTENTE!");
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
				}else {
					for (int i = 0; i < alphabetIN.size(); i++) {
						if(alphabetIN.get(i).toString().equals(tfAlphabetIN.getText())) {
							labelWarnings.setText("YA ES PARTE DEL ALFABETO DE ENTRADA!");
							isNot = false;
							break;
						}
					}
					
					if(isNot) {
						alphabetIN.add(tfAlphabetIN.getText().charAt(0));
						cbAlphabetIN.addItem(tfAlphabetIN.getText().charAt(0));
						labelWarnings.setText("");
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
				}else {
					for (int i = 0; i < alphabetStack.size(); i++) {
						if(alphabetStack.get(i).toString().equals(tfAlphabetStack.getText())) {
							labelWarnings.setText("YA ES PARTE DEL ALFABETO DE PILA!");
							isNot = false;
							break;
						}
					}
					
					if(isNot) {
						alphabetStack.add(tfAlphabetStack.getText().charAt(0));
						cbAlphabetStack.addItem(tfAlphabetStack.getText().charAt(0));
						labelWarnings.setText("");
					}
				}
			}  
		});

		buttonInitialState.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){
				initialState = (String) cbInitialState.getSelectedItem();
			}  
		});

		buttonFinalState.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){
				boolean isNot=true;
				if(finalStates.size()<1) {
					finalStates.add((String) cbFinalState.getSelectedItem());
				}else {
					for (int i = 0; i < finalStates.size(); i++) {
						if(finalStates.get(i).equals((String) cbFinalState.getSelectedItem())) {
							labelWarnings.setText("YA ES UN ESTADO FINAL");
							isNot = false;
							break;
						}
					}
					
					if(isNot) {
						finalStates.add(tfStates.getText());
						labelWarnings.setText("");
					}
				}		
			}  
		});
		
		buttonInitialStack.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){
				initialStack = tfInitialStack.getText();
				
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
				String text = showRules.getText();
				if(text.length()>13) {text=text.substring(6, (text.length()-7));}
				text = "<html>"+text+"<br>"+iState+","+alpha+","+stackTop+","+fState+","+action+"</html>";
				showRules.setText(text);
			}  
		});

		buttonSimulador.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){
				simulator.setvisible();
				simulator.simulation(reglas, auto, initialState, initialStack);
				
			}  
		});
	}


}
