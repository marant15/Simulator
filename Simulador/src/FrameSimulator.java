import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;  

public class FrameSimulator {
	JFrame frame;
	JLabel labelWord;
	JButton start;
	TextField tfWord;
	Simulator sim;
	Container contenedor;
	JTable pila;
	DefaultTableModel modelo;
	
	public FrameSimulator() {
		frame=new JFrame();
		
		tfWord = new TextField();
		contenedor = new Container();
		contenedor.response = new JLabel("");
		contenedor.cinta = new JLabel("");
		contenedor.cintaFL= new JLabel("");
		contenedor.cintaL= new JLabel("");
		contenedor.regla= new JLabel("");
		contenedor.estado= new JLabel("");
		labelWord = new JLabel("Write Word");
		
		modelo = new DefaultTableModel(){
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		pila = new JTable(modelo);
		modelo.setRowCount(12);
		modelo.setColumnCount(1);
		
		start = new JButton("Start");
		
		tfWord.setBounds(110, 10, 150, 20);
		
		labelWord.setBounds(10,10,100,20);
		contenedor.cinta.setBounds(10,50,300, 40);
		contenedor.cintaFL.setBounds(10,100,300, 40);
		contenedor.cintaL.setBounds(10,150,300, 40);
		contenedor.regla.setBounds(10,200,300, 40);
		contenedor.estado.setBounds(10,250,300, 40);
		contenedor.response.setBounds(10,300,300, 40);
		contenedor.response.setVisible(false);
		start.setBounds(270,10,100, 20);
		pila.setBounds(350,150, 40,190);
		
		
		frame.add(tfWord);
		frame.add(labelWord);
		frame.add(contenedor.response);
		frame.add(contenedor.cinta);
		frame.add(contenedor.cintaFL);
		frame.add(contenedor.cintaL);
		frame.add(contenedor.regla);
		frame.add(contenedor.estado);
		frame.add(start);
		frame.add(pila);
		frame.setSize(500,600);
		frame.setLayout(null);  
		frame.setVisible(false);
	}
	
	public void simulation(ArrayList<Regla> reglas,Automata auto, String estadoI, ArrayList<String> pila) {
		start.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){
				String palabra = tfWord.getText();
				auto.reglas = reglas;
				sim = new Simulator(auto,contenedor);
				sim.cadena = palabra;
				
				
				boolean estado = sim.verificar(palabra,pila,estadoI);
				if(estado) {
					contenedor.response.setText("Palabra Aceptada");
				}else {
					contenedor.response.setText("Palabra no Aceptada");
				}
				contenedor.response.setVisible(false);
				simular();
	        }  
	    });
	}
	
	public void simular() {
		Runnable caller = new Runnable() {
		    @Override
		    public void run() {
		    	showsteps();
		    }
		};
		new Thread(caller).start();
	}
	
	public void showsteps() {
		System.out.println(sim.steps.size());
		for (int i = 0; i < sim.steps.size(); i++) {
			contenedor.cinta.setText(sim.steps.get(i).cinta);
			contenedor.cintaFL.setText(sim.steps.get(i).cintaFL);
			contenedor.cintaL.setText(sim.steps.get(i).cintaL);
			contenedor.regla.setText(sim.steps.get(i).regla);
			contenedor.estado.setText(sim.steps.get(i).estado);
			for (int j = 0; j < 12; j++) {
				modelo.setValueAt("", j, 0);
			}
			int count = 1;
			if(sim.steps.get(i).pila.get(0).length() > 12) count = 12;
			else count = sim.steps.get(i).pila.get(0).length();
			for (int j = 0; j < sim.steps.get(i).pila.get(0).length() && j <12; j++) {
				modelo.setValueAt(sim.steps.get(i).pila.get(0).charAt(sim.steps.get(i).pila.get(0).length()-1-j), 12-count+j, 0);
			}
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
    	}
		contenedor.response.setVisible(true);
	}
	
	public void setvisible() {
		frame.setVisible(true);
	}
}
