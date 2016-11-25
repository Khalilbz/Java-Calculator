import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JTextField;


public class Form extends JFrame implements ActionListener{
	
	JTextField input = new JTextField("0"); //INPUT
	
	JButton ac = new JButton("AC");
	JButton plusmoins = new JButton("±");
	JButton percent = new JButton("%");
	
	JButton division = new JButton("÷");
	JButton mult = new JButton("X");
	JButton soust = new JButton("-");
	JButton plus = new JButton("+");
	JButton equal = new JButton("=");
	JButton verg = new JButton(",");
	
	JButton b7 = new JButton("7");JButton b8 = new JButton("8");JButton b9 = new JButton("9");
	JButton b4 = new JButton("4");;JButton b5 = new JButton("5");JButton b6 = new JButton("6");
	JButton b1 = new JButton("1");JButton b2 = new JButton("2");JButton b3 = new JButton("3");
	JButton b0 = new JButton("0");
	
	//Internal Variables
	float var1 = 0;
	float var2 = 0;
	boolean startvar2 = false;
	String op = "";
	boolean done = true;
	
	public Form(){
		//JFrame conf
		setTitle("Khalil ben zineb L2DSI Calculator");
		//setSize(250, 300);
		//setExtendedState( getExtendedState()|JFrame.MAXIMIZED_BOTH );
		setVisible(true);
		this.setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//setLocation(0, 0);

		Container c = this.getContentPane();
		setLayout(new GridBagLayout());
		GridBagConstraints cst = new GridBagConstraints();
		 
        // Special Buttons
        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.ipadx = 30;cst.ipady = 30;
        cst.gridwidth=4;
        cst.gridx = 0;cst.gridy = 0;add(input,cst);
        	input.setBackground(Color.GRAY);
        	input.setHorizontalAlignment(JTextField.RIGHT);
        	Font font = new Font("Arial", Font.BOLD,30);
        	input.setFont(font);
        	input.setEditable(false);
        cst.gridwidth=1;
        cst.gridx = 0;cst.gridy = 1;add(ac,cst);ac.setBackground(Color.LIGHT_GRAY);ac.addActionListener(this);
        cst.gridx = 1;cst.gridy = 1;add(plusmoins,cst);plusmoins.setBackground(Color.LIGHT_GRAY);plusmoins.addActionListener(this);
        cst.gridx = 2;cst.gridy = 1;add(percent,cst);percent.setBackground(Color.LIGHT_GRAY);percent.addActionListener(this);
        
        //Add Operations
        cst.gridx = 3;cst.gridy = 1;add(division,cst);division.setBackground(Color.orange);division.addActionListener(this);
        cst.gridx = 3;cst.gridy = 2;add(mult,cst);mult.setBackground(Color.orange);mult.addActionListener(this);
        cst.gridx = 3;cst.gridy = 3;add(soust,cst);soust.setBackground(Color.orange);soust.addActionListener(this);
        cst.gridx = 3;cst.gridy = 4;add(plus,cst);plus.setBackground(Color.orange);plus.addActionListener(this);
        cst.gridx = 3;cst.gridy = 5;add(equal,cst);equal.setBackground(Color.orange);equal.addActionListener(this);

        //Numbers
        cst.gridx = 0;cst.gridy = 2;add(b7,cst);b7.setBackground(Color.LIGHT_GRAY);b7.addActionListener(this);
        cst.gridx = 1;cst.gridy = 2;add(b8,cst);b8.setBackground(Color.LIGHT_GRAY);b8.addActionListener(this);
        cst.gridx = 2;cst.gridy = 2;add(b9,cst);b9.setBackground(Color.LIGHT_GRAY);b9.addActionListener(this);
        
        cst.gridx = 0;cst.gridy = 3;add(b4,cst);b4.setBackground(Color.LIGHT_GRAY);b4.addActionListener(this);
        cst.gridx = 1;cst.gridy = 3;add(b5,cst);b5.setBackground(Color.LIGHT_GRAY);b5.addActionListener(this);
        cst.gridx = 2;cst.gridy = 3;add(b6,cst);b6.setBackground(Color.LIGHT_GRAY);b6.addActionListener(this);

        cst.gridx = 0;cst.gridy = 4;add(b1,cst);b1.setBackground(Color.LIGHT_GRAY);b1.addActionListener(this);
        cst.gridx = 1;cst.gridy = 4;add(b2,cst);b2.setBackground(Color.LIGHT_GRAY);b2.addActionListener(this);
        cst.gridx = 2;cst.gridy = 4;add(b3,cst);b3.setBackground(Color.LIGHT_GRAY);b3.addActionListener(this);
        
        
        
        cst.gridwidth=2;
        cst.gridx = 0;cst.gridy = 5;add(b0,cst);b0.setBackground(Color.LIGHT_GRAY);b0.addActionListener(this);
        cst.gridwidth=1;
        cst.gridx = 2;cst.gridy = 5;add(verg,cst);verg.setBackground(Color.LIGHT_GRAY);verg.addActionListener(this);
		pack();
		validate();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String caption = ((JButton) e.getSource()).getActionCommand();
		if( Arrays.asList("0","1","2","3","4","5","6","7","8","9",",").contains(caption) ){
			if(startvar2){
				var1 = Float.parseFloat(input.getText().replace("," ,"."));
				input.setText("");
				startvar2=false;
				}
			if(done){input.setText(""); done = false;}
			input.setText(input.getText()+caption);
		}
		
		if(Arrays.asList("+","-","X","÷").contains(caption)){
			op = caption;
			startvar2 = true;
		}
		
		if(Arrays.asList("AC").contains(caption)){
			input.setText("0");
			done = true;
		}
		
		if(Arrays.asList("%").contains(caption)){
			var1 = Float.parseFloat(input.getText());
			op = "÷";
			input.setText("100");
			equal.doClick();
		}
		
		if(Arrays.asList("±").contains(caption)){
			float tmp = Float.parseFloat(input.getText());
			tmp = tmp*(-1);
			input.setText(Float.toString(tmp));
		}
		
		if(Arrays.asList("=").contains(caption)){
			var2 = Float.parseFloat(input.getText());
			
			float res = 0;
			switch(op){
			case "+" :
				res = var1 + var2;
				break;
			case "-" :
				res = var1 - var2;
				break;
			case "X" :
				res = var1 * var2;
				break;
			case "÷" :
				res = var1 / var2;
				break;
			}
			var1 = res;
			startvar2 = true;
			input.setText(Float.toString(res));
			done = true;
		}
		
	}
}
