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
	
	//Variablen
	static int buttonBreite = Main.buttonBreite;
	static int buttonHöhe = Main.buttonHöhe;
	static int versuche = 0;
	
	public static void zahlenguesser() {

		int random = (int)(Math.random() * 100);
		System.out.println(random);
		
		//JFrame erstellen
		JFrame jf = new JFrame();
		jf.setTitle("Arcade Spiele - Zahlenguesser");
		jf.setSize(1280, 720);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(EXIT_ON_CLOSE);
		jf.setVisible(true);
		
		//Schriftarten
				Font schrift = new Font ("Rockwell", Font.PLAIN , 50);
				Font eingabeSchrift = new Font("Rockwell", Font.BOLD, 120);
		
		//Zurück Button
		java.net.URL backButtonURL = Main.class.getResource("pictures\\backButton.png");
		ImageIcon backButtonIcon = new ImageIcon(backButtonURL);
		JButton zurückButton = new JButton(backButtonIcon);
		zurückButton.setBounds(20, 20, buttonBreite, buttonHöhe);
		zurückButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Main.main(null);
				jf.setVisible(false);
			}
		});
		/*
		//Ende Button
		JButton endeButton = new JButton("Ende");
		endeButton.setBounds(20, 20, 100, 70);
		endeButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);	
			}
		});
		*/
		
		//Background
		
		java.net.URL backgroundURL = Main.class.getResource("pictures\\background.jpg");
		ImageIcon background = new ImageIcon(backgroundURL);
		JLabel myLabel = new JLabel(background);
		myLabel.setSize(1280, 720);
		
		//ICON
		java.net.URL taskbarIconURL = Main.class.getResource("pictures\\taskbarIcon.png");
		ImageIcon taskbarIcon = new ImageIcon(taskbarIconURL);
		jf.setIconImage(taskbarIcon.getImage());
		
		//Text Anzeige
		String text = "Bitte geben Sie eine Zahl von 1-100 ein";
		JLabel numberLabel = new JLabel(text);
		numberLabel.setForeground(Color.CYAN);
		numberLabel.setBackground(Color.black);
		numberLabel.setOpaque(true);
		numberLabel.setSize(900, 70);
		numberLabel.setLocation(150, 130);
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
		tfEingabe.setFont(eingabeSchrift);
		tfEingabe.addKeyListener(new KeyAdapter() {
	         public void keyPressed(KeyEvent ke) {
	            String guess = tfEingabe.getText();
	            int l = guess.length();
	            char k = 0;
				if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') {
	               tfEingabe.setEditable(true);
	               numberLabel.setText(text);
	            } 
	            else {
	               tfEingabe.setEditable(false);
	               numberLabel.setText("Nur Zahlen einfÃ¼gen(0-9)");
	            }
	         }
	      });
		
		//nochmal Button
		JButton nochmalButton = new JButton("Nochmal spielen!");
		nochmalButton.setBounds(240, 360, 140, buttonHöhe);
		nochmalButton.setVisible(false);
		nochmalButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jf.setVisible(false);
				zahlenguesser.zahlenguesser();
				versuche = 0;
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
				versuche++;
				
				if(convertGuess == random) {convertGuess = 0;
											tfEingabe.setText(null);
											hilfeLabel.setText("Sie haben die Zahl mit "+  versuche +" Versuchen erraten!");
											nochmalButton.setVisible(true);
											hilfeLabel.setSize(1070,70);}
				if(convertGuess > random && convertGuess > 0) { hilfeLabel.setText("Die Zahl ist kleiner");
											convertGuess = 0;
											tfEingabe.setText(null);}
				if(convertGuess < random && convertGuess > 0) {hilfeLabel.setText("Die Zahl ist größer");
											convertGuess = 0;
											tfEingabe.setText(null);}
				}

			
			
			
		});
		
		//add to jf
		jf.add(nochmalButton);
		jf.add(zurückButton);
		jf.add(enter);
		jf.add(tfEingabe);
		jf.add(hilfeLabel);
		jf.add(numberLabel);
		jf.add(myLabel);
		
		
		
		
		
		
	}
	

}
