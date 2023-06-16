import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class zahlenguesser extends JFrame {
	
	
	public static void zahlenguesser() {

		int random = (int)(Math.random() * 100);
		System.out.println(random);
		
		
		JFrame jf = new JFrame();
		jf.setTitle("Arcade Spiele - Zahlenguesser");
		jf.setSize(1280, 720);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(EXIT_ON_CLOSE);
		jf.setVisible(true);
		
		//Zurück Button
		JButton zurückButton = new JButton("Zurück");
		zurückButton.setBounds(140, 40, 100, 70);
		zurückButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Main.main(null);
				jf.setVisible(false);
			}
		});
		
		//Ende Button
		JButton endeButton = new JButton("Ende");
		endeButton.setBounds(30, 40, 100, 70);
		endeButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);	
			}
		});
		
		
		//Background
		
		java.net.URL backgroundURL = Main.class.getResource("pictures\\background.jpg");
		ImageIcon background = new ImageIcon(backgroundURL);
		JLabel myLabel = new JLabel(background);
		myLabel.setSize(1280, 720);
		
		//Text Anzeige
		String text = "Bitte geben Sie eine Zahl von 1-100 ein";
		JLabel numberLabel = new JLabel(text);
		numberLabel.setForeground(Color.CYAN);
		numberLabel.setBackground(Color.black);
		numberLabel.setOpaque(true);
		numberLabel.setSize(900, 70);
		numberLabel.setLocation(150, 120);
		Font schrift = new Font ("Rockwell", Font.PLAIN , 50);
		numberLabel.setFont(schrift);
		
		String hilfe ="Hier wird ein Tipp erscheinen";
		JLabel hilfeLabel = new JLabel(hilfe);
		hilfeLabel.setForeground(Color.cyan);
		hilfeLabel.setBackground(Color.black);
		hilfeLabel.setOpaque(true);
		hilfeLabel.setSize(900, 70);
		hilfeLabel.setLocation(150, 210);
		hilfeLabel.setFont(schrift);
		
		//Eingabefeld
		String guess;
		JTextField tfEingabe = new JTextField(null, random);
		tfEingabe.setBounds(400, 300, 250, 200);
		tfEingabe.setFont(schrift);
		tfEingabe.addKeyListener(new KeyAdapter() {
	         public void keyPressed(KeyEvent ke) {
	            String guess = tfEingabe.getText();
	            int l = guess.length();
	            if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') {
	               tfEingabe.setEditable(true);
	               numberLabel.setText(text);
	            } else {
	               tfEingabe.setEditable(false);
	               numberLabel.setText("Nur Zahlen einfügen(0-9)");
	            }
	         }
	      });
		
		
		//der Button
		JButton enter = new JButton("Enter!");
		enter.setBounds(700, 350, 100, 100);
		enter.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String guess = tfEingabe.getText();
				int convertGuess = Integer.parseInt(guess);
				System.out.println(convertGuess);
				
				if(convertGuess == random) {convertGuess = 0;
											tfEingabe.setText(null);
											hilfeLabel.setText("Sie haben die Zahl erraten!");}
				if(convertGuess > random && convertGuess > 0) { hilfeLabel.setText("Die Zahl ist kleiner");
											convertGuess = 0;
											tfEingabe.setText(null);}
				if(convertGuess < random && convertGuess > 0) {hilfeLabel.setText("Die Zahl ist größer");
											convertGuess = 0;
											tfEingabe.setText(null);}
				}

			
			
			
		});
		
		//add to jf
		
		jf.add(zurückButton);
		jf.add(enter);
		jf.add(tfEingabe);
		jf.add(endeButton);
		jf.add(hilfeLabel);
		jf.add(numberLabel);
		jf.add(myLabel);
		
		
		
		
		
		
	}
	

}
