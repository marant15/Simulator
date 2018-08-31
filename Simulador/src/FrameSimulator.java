import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;  

public class FrameSimulator {
	JFrame frame;
	JLabel response;
	JLabel labelWord;
	JButton start;
	TextField tfWord;
	Simulator sim;
	
	public FrameSimulator() {
		frame=new JFrame();
		
		tfWord = new TextField();
		
		response = new JLabel("");
		labelWord = new JLabel("Write Word");
		
		start = new JButton("Start");
		
		tfWord.setBounds(110, 10, 150, 20);
		
		labelWord.setBounds(10,10,100,20);
		response.setBounds(10,200,180, 40);
		start.setBounds(270,10,100, 20);
		
		frame.add(tfWord);
		frame.add(labelWord);
		frame.add(response);
		frame.add(start);
		frame.setSize(400,500);  
		frame.setLayout(null);  
		frame.setVisible(false);
	}
	
	public void simulation(ArrayList<Regla> reglas,Automata auto, String estadoI, String pila) {
		start.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){
				String palabra = tfWord.getText();
				auto.reglas = reglas;
				sim = new Simulator(auto);
				
				boolean estado = sim.verificar(palabra,pila,estadoI);
				if(estado) {
					response.setText("Palabra Aceptada");
				}else {
					response.setText("Palabra no Aceptada");
				}
	        }  
	    });
	}
	
	public void setvisible() {
		frame.setVisible(true);
	}
}
