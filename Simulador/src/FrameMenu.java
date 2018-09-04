import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.TextField;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class FrameMenu extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int npila;

	AutomataC auto;
	ArrayList<Regla> reglas;
	ArrayList<String> finalStates;
	ArrayList<String> states;
	ArrayList<Character> alphabetIN;
	ArrayList<Character> alphabetStack;
	String initialState;
	String initialStack;

	FrameSimulator simulator;

	ArrayList<JComboBox> cbAlphabetStack;
	ArrayList<TextField> tfstackAction;

	JFrame frame;
	JOptionPane editPane;

	TextField tfStates;
	TextField tfAlphabetIN;
	TextField tfAlphabetStack;
	TextField tfInitialStack;
	TextField editOP;
	TextField tfnpila;

	JComboBox cbInitialState;
	JComboBox cbFinalState;

	JComboBox cbStates;
	JComboBox cbAlphabetIN;
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

	JButton buttonnpila;
	JButton buttonDStates;
	JButton buttonDAlphabetIN;
	JButton buttonDAlphabetStack;
	JButton buttonDFinalState;
	JButton buttonDRules;
	JButton save;
	JButton charge;

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
	JLabel labelnpila;

	@SuppressWarnings("unchecked")
	public FrameMenu(FrameSimulator simul) {
		npila = 1;

		initialState = "";
		simulator = simul;
		auto = new AutomataC();
		reglas = new ArrayList<Regla>();
		finalStates = new ArrayList<String>();
		states = new ArrayList<String>();
		alphabetIN = new ArrayList<Character>();
		cbAlphabetStack = new ArrayList<JComboBox>();
		alphabetStack = new ArrayList<Character>();
		tfstackAction = new ArrayList<TextField>();

		editPane = new JOptionPane();

		tfStates = new TextField();
		tfAlphabetIN = new TextField();
		tfAlphabetStack = new TextField();
		for (int i = 0; i < tfstackAction.size(); i++) {
			tfstackAction.set(i, new TextField());
		}
		tfInitialStack = new TextField();
		editOP = new TextField();
		tfnpila = new TextField();

		cbInitialState = new JComboBox();
		cbFinalState = new JComboBox();
		cbStates = new JComboBox();
		cbAlphabetIN = new JComboBox();
		for (int i = 0; i < cbAlphabetStack.size(); i++) {
			cbAlphabetStack.set(i, new JComboBox());
		}
		cbNextState = new JComboBox();

		buttonnpila = new JButton("Start");
		buttonStates = new JButton("Add");
		buttonAlphabetIN = new JButton("Add");
		buttonAlphabetStack = new JButton("Add");
		buttonInitialState = new JButton("Add");
		buttonFinalState = new JButton("Add");
		buttonInitialStack = new JButton("Add");
		buttonSimulador = new JButton("Simulate");
		buttonRules = new JButton("Add Rule");

		buttonEStates = new JButton("Edit");
		buttonEAlphabetIN = new JButton("Edit");
		buttonEAlphabetStack = new JButton("Edit");
		buttonEInitialState = new JButton("Edit");
		buttonEInitialStack = new JButton("Edit");
		buttonERules = new JButton("Edit Rule");

		buttonDStates = new JButton("Delete");
		buttonDAlphabetIN = new JButton("Delete");
		buttonDAlphabetStack = new JButton("Delete");
		buttonDFinalState = new JButton("Delete");
		buttonDRules = new JButton("Delete Rule");

		save = new JButton("Save");
		charge = new JButton("Charge");

		labelWarnings = new JLabel("Warnings");
		labelnpila = new JLabel("N pilas");
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

		tfnpila.setBounds(110, 10, 70, 20);
		tfStates.setBounds(110, 40, 70, 20);
		tfAlphabetIN.setBounds(110, 70, 20, 20);
		tfAlphabetStack.setBounds(110, 100, 20, 20);
		tfInitialStack.setBounds(110, 190, 50, 20);
		editOP.setBounds(10, 40, 100, 20);

		cbInitialState.setBounds(110, 130, 70, 20);
		cbFinalState.setBounds(110, 160, 70, 20);

		cbStates.setBounds(110, 220, 80, 20);
		cbAlphabetIN.setBounds(200, 220, 60, 20);

		buttonnpila.setBounds(200, 10, 60, 20);
		buttonStates.setBounds(200, 40, 60, 20);
		buttonAlphabetIN.setBounds(200, 70, 60, 20);
		buttonAlphabetStack.setBounds(200, 100, 60, 20);
		buttonInitialState.setBounds(200, 130, 60, 20);
		buttonFinalState.setBounds(200, 160, 60, 20);
		buttonInitialStack.setBounds(200, 190, 60, 20);
		buttonRules.setBounds(110, 250, 100, 20);
		buttonSimulador.setBounds(10, 290, 100, 20);

		buttonEStates.setBounds(260, 40, 60, 20);
		buttonEAlphabetIN.setBounds(260, 70, 60, 20);
		buttonEAlphabetStack.setBounds(260, 100, 60, 20);
		buttonEInitialState.setBounds(260, 130, 60, 20);
		buttonEInitialStack.setBounds(260, 190, 60, 20);
		buttonERules.setBounds(220, 250, 100, 20);

		buttonDStates.setBounds(320, 40, 70, 20);
		buttonDAlphabetIN.setBounds(320, 70, 70, 20);
		buttonDAlphabetStack.setBounds(320, 100, 70, 20);
		buttonDFinalState.setBounds(320, 160, 70, 20);
		buttonDRules.setBounds(330, 250, 100, 20);

		save.setBounds(10, 330, 100, 20);
		charge.setBounds(10, 360, 100, 20);

		labelWarnings.setBounds(210, 290, 150, 20);
		labelnpila.setBounds(10, 10, 100, 20);
		labelStates.setBounds(10, 40, 100, 20);
		labelAlphabetIn.setBounds(10, 70, 100, 20);
		labelAlphabetStack.setBounds(10, 100, 100, 20);
		labelInitialState.setBounds(10, 130, 100, 20);
		labelFinalState.setBounds(10, 160, 100, 20);
		labelInitialStack.setBounds(10, 190, 150, 20);
		labelRules.setBounds(10, 220, 100, 20);

		showStates.setBounds(400, 40, 200, 20);
		showAlphabetIn.setBounds(400, 70, 200, 20);
		showAlphabetStack.setBounds(400, 100, 200, 20);
		showInitialState.setBounds(400, 130, 40, 20);
		showFinalStates.setBounds(400, 160, 200, 20);
		showInitialStack.setBounds(400, 190, 40, 20);
		showRules.setBounds(10, 320, 250, 310);

		addall();

		editPane.add(editOP);
		editPane.setSize(200, 200);
		editPane.setVisible(false);
		setComboBox();
		allfalse();

	}

	public void addall() {
		frame = new JFrame();
		frame.add(tfStates);
		frame.add(tfAlphabetIN);
		frame.add(tfAlphabetStack);
		frame.add(tfInitialStack);

		frame.add(cbInitialState);
		frame.add(cbFinalState);

		frame.add(cbStates);
		frame.add(cbAlphabetIN);
		frame.add(cbNextState);
		frame.add(tfnpila);

		frame.add(buttonnpila);
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

		frame.add(save);
		frame.add(charge);

		frame.add(labelWarnings);
		frame.add(labelnpila);
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
		frame.setSize(800, 600);
		frame.setLayout(null);
		frame.setVisible(true);
	}

	public void setComboBox() {
		cbInitialState.removeAllItems();
		cbFinalState.removeAllItems();
		cbStates.removeAllItems();
		cbAlphabetIN.removeAllItems();
		cbAlphabetIN.addItem("\u03BB");
		for (int i = 0; i < cbAlphabetStack.size(); i++) {
			cbAlphabetStack.get(i).removeAllItems();
		}
		cbNextState.removeAllItems();
		for (int i = 0; i < states.size(); i++) {
			cbInitialState.addItem(states.get(i));
			cbFinalState.addItem(states.get(i));
			cbStates.addItem(states.get(i));
			cbNextState.addItem(states.get(i));
		}
		for (int i = 0; i < alphabetIN.size(); i++) {
			cbAlphabetIN.addItem(alphabetIN.get(i));
		}
		for (int i = 0; i < cbAlphabetStack.size(); i++) {
			cbAlphabetStack.get(i).addItem(initialStack);
		}
		for (int i = 0; i < alphabetStack.size(); i++) {
			for (int j = 0; j < cbAlphabetStack.size(); j++) {
				cbAlphabetStack.get(j).addItem(alphabetStack.get(i));
			}
		}
	}

	public void setTexts() {
		showStates.setText(print(states));
		showAlphabetIn.setText(print(alphabetIN));
		showAlphabetStack.setText(print(alphabetStack));
		showInitialState.setText(initialState);
		showInitialStack.setText("" + initialStack);
		showFinalStates.setText(print(finalStates));
		String text = "<html>" + printRules() + "</html>";
		showRules.setText(text);
	}

	public void start() {
		buttonStates.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!tfStates.getText().equals("")) {
					boolean isNot = true;
					if (states.size() < 1) {
						states.add(tfStates.getText());
						cbInitialState.addItem(tfStates.getText());
						cbFinalState.addItem(tfStates.getText());
						cbStates.addItem(tfStates.getText());
						cbNextState.addItem(tfStates.getText());
						showStates.setText(print(states));
					} else {
						for (int i = 0; i < states.size(); i++) {
							if (states.get(i).equals(tfStates.getText())) {
								JOptionPane.showMessageDialog(null, "ESTADO EXISTENTE!");
								isNot = false;
								break;
							}
						}
						if (isNot) {
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
			}
		});

		buttonAlphabetIN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					boolean isNot = true;
					if (alphabetIN.size() < 1) {
						alphabetIN.add(tfAlphabetIN.getText().charAt(0));
						cbAlphabetIN.addItem(tfAlphabetIN.getText().charAt(0));
						showAlphabetIn.setText(print(alphabetIN));
					} else {
						for (int i = 0; i < alphabetIN.size(); i++) {
							if (alphabetIN.get(i).toString().equals(tfAlphabetIN.getText())) {
								JOptionPane.showMessageDialog(null, "YA ES PARTE DEL ALFABETO DE ENTRADA!");
								isNot = false;
								break;
							}
						}

						if (isNot) {
							alphabetIN.add(tfAlphabetIN.getText().charAt(0));
							cbAlphabetIN.addItem(tfAlphabetIN.getText().charAt(0));
							showAlphabetIn.setText(print(alphabetIN));
						}
					}
				} catch (Exception e1) {
				}
			}
		});

		buttonAlphabetStack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					boolean isNot = true;
					if (alphabetStack.size() == 0) {
						alphabetStack.add(tfAlphabetStack.getText().charAt(0));
						for (int i = 0; i < cbAlphabetStack.size(); i++) {
							cbAlphabetStack.get(i).addItem(tfAlphabetStack.getText().charAt(0));
						}
						showAlphabetStack.setText(print(alphabetStack));
					} else {
						for (int i = 0; i < alphabetStack.size(); i++) {
							if (alphabetStack.get(i).toString().equals(tfAlphabetStack.getText())) {
								JOptionPane.showMessageDialog(null, "YA ES PARTE DEL ALFABETO DE LA PILA!");
								isNot = false;
								break;
							}
						}

						if (isNot) {
							alphabetStack.add(tfAlphabetStack.getText().charAt(0));
							for (int i = 0; i < cbAlphabetStack.size(); i++) {
								cbAlphabetStack.get(i).addItem(tfAlphabetStack.getText().charAt(0));
							}
							showAlphabetStack.setText(print(alphabetStack));
						}
					}
				} catch (Exception e2) {
				}
			}
		});

		buttonInitialState.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				initialState = (String) cbInitialState.getSelectedItem();
				if (initialState != null) {
					showInitialState.setText(initialState);
					buttonInitialState.setEnabled(false);
				}
			}
		});

		buttonFinalState.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((String) cbFinalState.getSelectedItem() != null) {
					boolean isNot = true;
					if (finalStates.size() < 1) {
						finalStates.add((String) cbFinalState.getSelectedItem());
						showFinalStates.setText(print(finalStates));
					} else {
						for (int i = 0; i < finalStates.size(); i++) {
							if (finalStates.get(i).equals((String) cbFinalState.getSelectedItem())) {
								JOptionPane.showMessageDialog(null, "YA ES UN ESTADO FINAL!");
								isNot = false;
								break;
							}
						}

						if (isNot) {
							finalStates.add(tfStates.getText());
							labelWarnings.setText("");
							showFinalStates.setText(print(finalStates));
						}
					}
				}
			}
		});

		buttonInitialStack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				initialStack = "" + tfInitialStack.getText().charAt(0);
				for (int i = 0; i < cbAlphabetStack.size(); i++) {
					cbAlphabetStack.get(i).addItem(tfInitialStack.getText().charAt(0));
				}
				buttonInitialStack.setEnabled(false);
				showInitialStack.setText("" + initialStack);
			}
		});

		buttonRules.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String iState = (String) cbStates.getSelectedItem();
				Character alpha = (""+cbAlphabetIN.getSelectedItem()).charAt(0);
				ArrayList<Character> stackTop = new ArrayList<Character>();
				ArrayList<String> action = new ArrayList<String>();
				boolean correcto = true;
				for (int i = 0; i < cbAlphabetStack.size(); i++) {
					stackTop.add((Character) cbAlphabetStack.get(i).getSelectedItem());
					String accion = (String) tfstackAction.get(i).getText();
					if(accion.equals("")) accion = "\u03BB";
					else {
						if(accion.charAt(accion.length()-1) == stackTop.get(i)) {
							if(!verificarentrada(accion.substring(0,accion.length()-1),alphabetStack)) {
								correcto = false;
								break;
							}
						}else {
							correcto = false;
							break;
						}
					}
					action.add(accion);
				}
				String fState = (String) cbNextState.getSelectedItem();
				if(correcto) {
				reglas.add(new Regla(iState, alpha, stackTop, fState, action));
				String text = "<html>" + printRules() + "</html>";
				showRules.setText(text);
				}else {
					JOptionPane.showMessageDialog(null, "Entrada erronea");
				}
			}
		});

		buttonSimulador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				simulator = new FrameSimulator();
				simulator.setvisible();
				ArrayList<String> aux = new ArrayList<String>();
				for (int i = 0; i < npila; i++) {
					aux.add("" + initialStack);
				}
				auto.auto.estadosf = finalStates;
				auto.auto.alfabetoE = alphabetIN;
				auto.auto.alfabetoP = alphabetStack;
				simulator.simulation(reglas, auto.auto, initialState, aux);
			}
		});

		buttonEStates.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tfStates.getText().equals(null)) {
					JOptionPane.showMessageDialog(null, "NO PUSISTE QUE EDITAR!");
				} else if (states.size() < 1) {
					JOptionPane.showMessageDialog(null, "TODAVIA NO HAY ESTADOS!");
				} else {
					String change = "";
					change = editPane
							.showInputDialog("Cambiar el nombre del estado " + tfStates.getText() + " al siguiente:");
					for (int i = 0; i < states.size(); i++) {
						if (tfStates.getText().equals(states.get(i)) && !(change.equals((null)))) {
							states.set(i, change);
							cbInitialState.removeItem(tfStates.getText());
							cbInitialState.addItem(change);
							if (initialState.equals(tfStates.getText())) {
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
						if (finalStates.get(i).equals(tfStates.getText())) {
							finalStates.set(i, change);
							break;
						}
					}
					showInitialState.setText(print(finalStates));

					for (int i = 0; i < reglas.size(); i++) {
						if (reglas.get(i).estadoi.equals(tfStates.getText())) {
							Regla regla = reglas.get(i);
							regla.estadoi = change;
							reglas.set(i, regla);
						}

						if (reglas.get(i).estadof.equals(tfStates.getText())) {
							Regla regla = reglas.get(i);
							regla.estadof = change;
							reglas.set(i, regla);
						}
					}
					String text = "<html>" + printRules() + "</html>";
					showRules.setText(text);
				}
			}
		});

		buttonEAlphabetIN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tfAlphabetIN.getText().equals(null)) {
					JOptionPane.showMessageDialog(null, "NO PUSISTE QUE EDITAR!");
				} else if (alphabetIN.size() < 1) {
					JOptionPane.showMessageDialog(null, "TODAVIA NO HAY ALFABETO!");
				} else {
					String change = "";
					change = editPane.showInputDialog(
							"Cambiar letra del alfabeto (" + tfAlphabetIN.getText() + ") al siguiente:");
					for (int i = 0; i < alphabetIN.size(); i++) {
						if ((alphabetIN.get(i) == tfAlphabetIN.getText().charAt(0)) && !(change.equals((null)))) {
							alphabetIN.set(i, change.charAt(0));
							cbAlphabetIN.removeItem(tfAlphabetIN.getText().charAt(0));
							cbAlphabetIN.addItem(change.charAt(0));
							break;
						}
					}
					showAlphabetIn.setText(print(alphabetIN));
					for (int i = 0; i < reglas.size(); i++) {
						if (reglas.get(i).entrada == tfAlphabetIN.getText().charAt(0)) {
							Regla regla = reglas.get(i);
							regla.entrada = change.charAt(0);
							reglas.set(i, regla);
						}
					}
					String text = "<html>" + printRules() + "</html>";
					showRules.setText(text);
				}
			}
		});

		buttonEAlphabetStack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tfAlphabetStack.getText().equals(null)) {
					JOptionPane.showMessageDialog(null, "NO PUSISTE QUE EDITAR!");
				} else if (alphabetStack.size() < 1) {
					JOptionPane.showMessageDialog(null, "TODAVIA NO HAY ALFABETO!");
				} else {
					String change = "";
					change = editPane.showInputDialog(
							"Cambiar letra del alfabeto (" + tfAlphabetStack.getText() + ") al siguiente:");
					for (int i = 0; i < alphabetStack.size(); i++) {
						if ((alphabetStack.get(i) == tfAlphabetStack.getText().charAt(0)) && !(change.equals((null)))) {
							alphabetStack.set(i, change.charAt(0));
							for (int j = 0; j < cbAlphabetStack.size(); j++) {
								cbAlphabetStack.get(j).removeItem(tfAlphabetStack.getText().charAt(0));
								cbAlphabetStack.get(j).addItem(change.charAt(0));
							}
							break;
						}
					}
					showAlphabetStack.setText(print(alphabetStack));
					for (int i = 0; i < reglas.size(); i++) {
						for (int j = 0; j < npila; j++) {
							if (reglas.get(i).tope.get(j) == tfAlphabetStack.getText().charAt(0)) {
								Regla regla = reglas.get(i);
								regla.tope.set(j, change.charAt(0));
								reglas.set(i, regla);
							}
							char[] array = reglas.get(i).accion.get(j).toCharArray();
							for (int k = 0; k < array.length; k++) {
								if (array[k] == tfAlphabetStack.getText().charAt(0)) {
									array[k] = change.charAt(0);
								}
							}
							Regla regla = reglas.get(i);
							regla.accion.set(j, conect(array));
							reglas.set(i, regla);
						}
					}
					String text = "<html>" + printRules() + "</html>";
					showRules.setText(text);
				}
			}
		});

		buttonEInitialState.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				initialState = (String) cbInitialState.getSelectedItem();
				showInitialState.setText(initialState);
			}
		});

		buttonEInitialStack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < reglas.size(); i++) {
					for (int j = 0; j < npila; j++) {
						if (reglas.get(i).tope.get(j) == initialStack.charAt(0)) {
							Regla regla = reglas.get(i);
							regla.tope.set(j, tfInitialStack.getText().charAt(0));
							reglas.set(i, regla);
						}
						char[] array = reglas.get(i).accion.get(j).toCharArray();
						for (int k = 0; k < array.length; k++) {
							if (array[k] == initialStack.charAt(0)) {
								array[k] = tfInitialStack.getText().charAt(0);
							}
						}
						Regla regla = reglas.get(i);
						regla.accion.set(j, conect(array));
						reglas.set(i, regla);
					}
				}
				for (int i = 0; i < cbAlphabetStack.size(); i++) {
					for (int k = 0; k < cbAlphabetStack.size(); k++) {
						if((""+cbAlphabetStack.get(i).getItemAt(k)).equals(""+initialStack)) {
							cbAlphabetStack.get(i).removeItemAt(k);
							break;
						}
					}
					cbAlphabetStack.get(i).addItem(tfInitialStack.getText().charAt(0));
				}
				initialStack = tfInitialStack.getText();
				String text = "<html>" + printRules() + "</html>";
				showRules.setText(text);
				showInitialStack.setText("" + initialStack);
			}
		});

		buttonERules.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		buttonDStates.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (states.size() < 1) {
					JOptionPane.showMessageDialog(null, "TODAVIA NO HAY ESTADOS!");
				} else {
					states.remove(tfStates.getText());
					if (initialState.equals(tfStates.getText())) {
						initialState = "";
					}
					cbInitialState.removeItem(tfStates.getText());
					cbFinalState.removeItem(tfStates.getText());
					cbStates.removeItem(tfStates.getText());
					cbNextState.removeItem(tfStates.getText());
					finalStates.remove(tfStates.getText());
					showStates.setText(print(states));
					showInitialState.setText(print(finalStates));
					showFinalStates.setText(print(finalStates));

					for (int i = 0; i < reglas.size(); i++) {
						if (reglas.get(i).estadoi.equals(tfStates.getText())) {
							reglas.remove(i);
						}
					}

					for (int i = 0; i < reglas.size(); i++) {
						if (reglas.get(i).estadof.equals(tfStates.getText())) {
							reglas.remove(i);
						}
					}
					String text = "<html>" + printRules() + "</html>";
					showRules.setText(text);
				}
			}
		});
		buttonDAlphabetIN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (alphabetIN.size() < 1) {
					JOptionPane.showMessageDialog(null, "TODAVIA NO HAY ALFABETO!");
				} else {
					for (int i = 0; i < alphabetIN.size(); i++) {
						if ((alphabetIN.get(i) == tfAlphabetIN.getText().charAt(0))) {
							alphabetIN.remove(i);
							cbAlphabetIN.removeItem(tfAlphabetIN.getText().charAt(0));
							break;
						}
					}
					showAlphabetIn.setText(print(alphabetIN));
					for (int i = 0; i < reglas.size(); i++) {
						if (reglas.get(i).entrada == tfAlphabetIN.getText().charAt(0)) {
							reglas.remove(i);
						}
					}
					String text = "<html>" + printRules() + "</html>";
					showRules.setText(text);
				}
			}
		});
		buttonDAlphabetStack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (alphabetStack.size() < 1) {
					JOptionPane.showMessageDialog(null, "TODAVIA NO HAY ALFABETO!");
				} else {
					for (int i = 0; i < alphabetStack.size(); i++) {
						if ((alphabetStack.get(i) == tfAlphabetStack.getText().charAt(0))) {
							alphabetStack.remove(i);
							for (int j = 0; j < cbAlphabetStack.size(); j++) {
								cbAlphabetStack.get(i).removeItem(tfAlphabetStack.getText().charAt(0));
							}
							break;
						}
					}

					showAlphabetStack.setText(print(alphabetStack));
					for (int i = 0; i < reglas.size(); i++) {
						for (int j = 0; j < npila; j++) {
							if (reglas.get(i).tope.get(j) == tfAlphabetStack.getText().charAt(0)) {
								reglas.remove(i);
								break;
							}
						}
					}

					for (int i = 0; i < reglas.size(); i++) {
						boolean remover = false;
						for (int j = 0; j < npila; j++) {
							char[] array = reglas.get(i).accion.get(j).toCharArray();
							for (int k = 0; k < array.length; k++) {
								if (array[k] == tfAlphabetStack.getText().charAt(0)) {
									remover = true;
									break;
								}
							}
						}
						if (remover)
							reglas.remove(i);
					}
					String text = "<html>" + printRules() + "</html>";
					showRules.setText(text);
				}
			}
		});
		buttonDFinalState.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < finalStates.size(); i++) {
					if (finalStates.get(i).equals(cbFinalState.getSelectedItem())) {
						finalStates.remove(i);
					}
				}
				showFinalStates.setText(print(finalStates));
			}
		});
		buttonDRules.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				save();
			}
		});
		charge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				charge();
			}
		});
		buttonnpila.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inicializar();
			}
		});
	}

	public void inicializar() {
		if (tfnpila.getText().length() >= 1) {
			try {
				this.npila = Integer.parseInt(tfnpila.getText());
				startthings();
			} catch (Exception e) {
			}
		} else {

		}
	}

	public void startthings() {
		this.cbAlphabetStack = new ArrayList<JComboBox>();
		this.tfstackAction = new ArrayList<TextField>();
		for (int i = 0; i < npila; i++) {
			this.cbAlphabetStack.add(new JComboBox());
			this.tfstackAction.add(new TextField());
		}
		setrulesize();
		allvisible();
	}

	public void setrulesize() {
		cbNextState.setBounds(340 + (npila - 1) * 70, 220, 70, 20);
		for (int i = 0; i < cbAlphabetStack.size(); i++) {
			cbAlphabetStack.get(i).setBounds(270 + i * 70, 220, 60, 20);
			tfstackAction.get(i).setBounds(340 + (npila) * 70 + 10 + i * 70, 220, 60, 20);
			frame.add(cbAlphabetStack.get(i));
			frame.add(tfstackAction.get(i));
		}
	}

	public void allvisible() {
		tfnpila.setEnabled(false);
		buttonnpila.setEnabled(false);
		tfStates.setVisible(true);
		tfAlphabetIN.setVisible(true);
		tfAlphabetStack.setVisible(true);
		tfInitialStack.setVisible(true);
		editOP.setVisible(true);
		cbInitialState.setVisible(true);
		cbFinalState.setVisible(true);
		cbStates.setVisible(true);
		cbAlphabetIN.setVisible(true);
		for (int j = 0; j < cbAlphabetStack.size(); j++) {
			tfstackAction.get(j).setVisible(true);
			cbAlphabetStack.get(j).setVisible(true);
		}
		cbNextState.setVisible(true);
		buttonStates.setVisible(true);
		buttonAlphabetIN.setVisible(true);
		buttonAlphabetStack.setVisible(true);
		buttonInitialState.setVisible(true);
		buttonFinalState.setVisible(true);
		buttonInitialStack.setVisible(true);
		buttonSimulador.setVisible(true);
		buttonRules.setVisible(true);
		buttonEStates.setVisible(true);
		buttonEAlphabetIN.setVisible(true);
		buttonEAlphabetStack.setVisible(true);
		buttonEInitialState.setVisible(true);
		buttonEInitialStack.setVisible(true);
		buttonERules.setVisible(true);
		buttonDStates.setVisible(true);
		buttonDAlphabetIN.setVisible(true);
		buttonDAlphabetStack.setVisible(true);
		buttonDFinalState.setVisible(true);
		buttonDRules.setVisible(true);
		labelWarnings.setVisible(true);
		labelStates.setVisible(true);
		labelAlphabetIn.setVisible(true);
		labelAlphabetStack.setVisible(true);
		labelInitialState.setVisible(true);
		labelFinalState.setVisible(true);
		labelInitialStack.setVisible(true);
		labelRules.setVisible(true);
		showStates.setVisible(true);
		showAlphabetIn.setVisible(true);
		showAlphabetStack.setVisible(true);
		showInitialState.setVisible(true);
		showFinalStates.setVisible(true);
		showInitialStack.setVisible(true);
		showRules.setVisible(true);
		save.setEnabled(true);
	}

	public void allfalse() {
		tfnpila.setEnabled(true);
		buttonnpila.setEnabled(true);
		save.setEnabled(false);
		tfStates.setVisible(false);
		tfAlphabetIN.setVisible(false);
		tfAlphabetStack.setVisible(false);
		tfInitialStack.setVisible(false);
		editOP.setVisible(false);
		buttonStates.setVisible(false);
		buttonAlphabetIN.setVisible(false);
		buttonAlphabetStack.setVisible(false);
		buttonInitialState.setVisible(false);
		buttonFinalState.setVisible(false);
		buttonInitialStack.setVisible(false);
		buttonSimulador.setVisible(false);
		buttonRules.setVisible(false);
		buttonEStates.setVisible(false);
		buttonEAlphabetIN.setVisible(false);
		buttonEAlphabetStack.setVisible(false);
		buttonEInitialState.setVisible(false);
		buttonEInitialStack.setVisible(false);
		buttonERules.setVisible(false);
		buttonDStates.setVisible(false);
		buttonDAlphabetIN.setVisible(false);
		buttonDAlphabetStack.setVisible(false);
		buttonDFinalState.setVisible(false);
		buttonDRules.setVisible(false);
		labelWarnings.setVisible(false);
		labelStates.setVisible(false);
		labelAlphabetIn.setVisible(false);
		labelAlphabetStack.setVisible(false);
		labelInitialState.setVisible(false);
		labelFinalState.setVisible(false);
		labelInitialStack.setVisible(false);
		labelRules.setVisible(false);
		showStates.setVisible(false);
		showAlphabetIn.setVisible(false);
		showAlphabetStack.setVisible(false);
		showInitialState.setVisible(false);
		showFinalStates.setVisible(false);
		showInitialStack.setVisible(false);
		showRules.setVisible(false);
		cbInitialState.setVisible(false);
		cbFinalState.setVisible(false);
		cbStates.setVisible(false);
		cbAlphabetIN.setVisible(false);
		for (int j = 0; j < cbAlphabetStack.size(); j++) {
			cbAlphabetStack.get(j).setVisible(false);
			tfstackAction.get(j).setVisible(false);
		}
		cbNextState.setVisible(false);
	}

	public void save() {
		JFileChooser chooser = new JFileChooser();
		chooser.setCurrentDirectory(new File("saves/"));
		int returnVal = chooser.showSaveDialog(this);
		if (returnVal == 0) {
			System.out.println(chooser.getSelectedFile().getPath());
			Automata aux = new Automata(states, alphabetIN, alphabetStack, reglas, initialState, finalStates,
					initialStack.charAt(0));
			aux.numerop = this.npila;
			auto.auto = aux;
			String path = chooser.getSelectedFile().getPath();
			if (path.contains(".json"))
				auto.save(path);
			else
				auto.save(path + ".json");
		}
	}

	public void charge() {
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("JSON files", "json");
		chooser.setFileFilter(filter);
		chooser.setCurrentDirectory(new File("saves/"));
		int returnVal = chooser.showOpenDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			if (auto.charge(chooser.getSelectedFile().getAbsolutePath())) {
				frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
				npila = auto.auto.numerop;
				tfnpila.setText("" + npila);
				alphabetIN = auto.auto.alfabetoE;
				states = auto.auto.estados;
				alphabetStack = auto.auto.alfabetoP;
				reglas = auto.auto.reglas;
				initialState = auto.auto.estadoi;
				finalStates = auto.auto.estadosf;
				initialStack = "" + auto.auto.initialstack;
				addall();
				startthings();
				this.setComboBox();
				this.setTexts();
			}
		}
	}

	public String printRules() {
		String aux = "";
		for (int i = 0; i < reglas.size(); i++) {
			Regla regla = reglas.get(i);
			aux = aux + regla.estadoi + "," + regla.entrada;
			for (int j = 0; j < npila; j++) {
				aux = aux + "," + regla.tope.get(j);
			}
			aux = aux + "," + regla.estadof;
			for (int j = 0; j < 1; j++) {
				aux = aux + "," + regla.accion.get(j);
			}
			aux = aux + "<br>";
		}
		return aux;
	}

	public String print(ArrayList array) {
		String aux = "";
		for (int i = 0; i < array.size(); i++) {
			aux = aux + array.get(i) + ",";
		}
		return aux;
	}

	public String conect(char[] cadena) {
		String conection = "";
		for (int i = 0; i < cadena.length; i++) {
			conection += cadena[i];
		}
		return conection;
	}
	
	public boolean verificarentrada(String palabra, ArrayList<Character> alf) {
		for (int i = 0; i < palabra.length(); i++) {
			boolean encontrado = false;
			for (int j = 0; j < alf.size(); j++) {
				if(palabra.charAt(i) == alf.get(j)) {
					encontrado = true;
					break;
				}
			}
			if(!encontrado) return false;
		}
		return true;
	}
}
