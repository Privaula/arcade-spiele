import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class rps {

	//Variablen
	static int buttonBreite = Main.buttonBreite;
	static int buttonHöhe = Main.buttonHöhe;
	static String eingabe;
	static String randomString;
	
	public static void Main(String[]args) {
		
	}
	
	public static void rps() {
		
		
		int random = (int)(Math.random() * 3 +1);
		System.out.println(random);
		
		
		//JFrame erstellen
		JFrame jf = new JFrame();
		jf.setTitle("Arcade Spiele - Memory");
		jf.setSize(1280, 720);
		jf.setLocationRelativeTo(null);
		jf.setVisible(true);
		
		
		//Background
		JLabel myLabel;
		java.net.URL backgroundURL = Main.class.getResource("pictures\\background.jpg");
		ImageIcon background = new ImageIcon(backgroundURL);
		myLabel = new JLabel(background);
		myLabel.setSize(1280, 720);
		
		//Zurück Button
		JButton zurückButton = new JButton("Zurück");
		zurückButton.setBounds(20, 20, buttonBreite, buttonHöhe);
		zurückButton.addActionListener(new ActionListener() {
					@Override
			public void actionPerformed(ActionEvent e) {
					Main.main(null);
					jf.setVisible(false);
					}
		});
		

		
		//Text Anzeige
		String text = "  Willkommen zu Schere Stein Papier";
		JLabel rpsLabel = new JLabel(text);
		rpsLabel.setForeground(Color.CYAN);
		rpsLabel.setBackground(Color.black);
		rpsLabel.setOpaque(true);
		rpsLabel.setSize(900, 70);
		rpsLabel.setLocation(150, 70);
		Font schrift = new Font ("Rockwell", Font.PLAIN , 50);
		rpsLabel.setFont(schrift);
		
		
		//Rock Button
		JButton rockButton = new JButton("Rock");
		rockButton.setBounds(200, 170, 200, 200);
		rockButton.addActionListener(new ActionListener() {
			@Override
			
			public void actionPerformed(ActionEvent e) {
				//System.out.println("Stein");
				rps.eingabe = "r";
				System.out.println(eingabe);
				proof();
			}
		});
		
	
		
		//Paper Button
		JButton paperButton = new JButton("Paper");
		paperButton.setBounds(460, 170, 200, 200);
		paperButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//System.out.println("Papier");
				rps.eingabe = "p";
				System.out.println(eingabe);
				proof();
			}
		});
		
		// Scissors Button
		JButton scissorsButton = new JButton("Scissors");
		scissorsButton.setBounds(720, 170, 200, 200);
		scissorsButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//System.out.println("Schere");
				rps.eingabe = "s";
				System.out.println(eingabe);
				proof();
			}
		});
		
		switch(random) {
		case 1:
			System.out.println("Stein");
			randomString = "r";
			break;
		
		case 2:
			System.out.println("Papier");
			randomString = "p";
			break;
		
		case 3:
			System.out.println("Schere");
			randomString = "s";
			break;
		}
		System.out.println();
		
		
		
		
		
		
		
		
		
		//add to jf
		jf.add(zurückButton);
		jf.add(scissorsButton);
		jf.add(paperButton);
		jf.add(rockButton);
		jf.add(rpsLabel);
		jf.add(myLabel);
	
		
	}
	static void proof() {
		//Ergebnisüberprüfung
		if(eingabe == "r" && randomString == "r") {
			System.out.println("Unentschieden");
		}
		if(eingabe == "r" && randomString == "p") {
			System.out.println("Verloren");
		}
		if(eingabe == "r" && randomString == "s") {
			System.out.println("Gewonnen");
		}
	}
	
}
