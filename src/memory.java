import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

import javax.swing.AbstractButton;
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
	static String randomStringName;
	static String computerMessage;
	
	public static void Main(String[]args) {
		
	}
	
	public static void rps() {
		
		
		int random = (int)(Math.random() * 3 +1);
		
		//JFrame erstellen
		JFrame jf = new JFrame();
		jf.setTitle("Arcade Spiele - Schere Stein Papier");
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
		
		//nochmal Button
		JButton nochmalButton = new JButton("Nochmal spielen!");
		nochmalButton.setBounds(170, 480, 140, buttonHöhe);
		nochmalButton.setVisible(false);
		nochmalButton.addActionListener(new ActionListener() {
					
					@Override
			public void actionPerformed(ActionEvent e) {
				jf.setVisible(false);
				rps.rps();
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
		
		
		//PC Button
		//"Der Computer hat "+ randomStringName + " gewählt." + computerMessage
		JButton computerButton = new JButton("Wähle eine der drei Optionen aus.");
		computerButton.setBounds(360, 420, 400, 200);
		computerButton.addActionListener(new ActionListener() {
							@Override
				public void actionPerformed(ActionEvent e) {
							
						}
		});
		
		
		//Rock Button
		JButton rockButton = new JButton("Stein");
		rockButton.setBounds(200, 170, 200, 200);
		rockButton.addActionListener(new ActionListener() {
			@Override
			
			public void actionPerformed(ActionEvent e) {
				//System.out.println("Stein");
				rps.eingabe = "r";
				proof();
				computerButton.setText("Der Computer hat "+ randomStringName + " gewählt." + " Sie haben "+ computerMessage + ".");
				nochmalButton.setVisible(true);
			}
		});
		
	
		
		//Paper Button
		JButton paperButton = new JButton("Papier");
		paperButton.setBounds(460, 170, 200, 200);
		paperButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//System.out.println("Papier");
				rps.eingabe = "p";
				proof();
				computerButton.setText("Der Computer hat "+ randomStringName + " gewählt." + " Sie haben "+ computerMessage + ".");
				nochmalButton.setVisible(true);
			}
		});
		
		// Scissors Button
		JButton scissorsButton = new JButton("Schere");
		scissorsButton.setBounds(720, 170, 200, 200);
		scissorsButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//System.out.println("Schere");
				rps.eingabe = "s";
				proof();
				computerButton.setText("Der Computer hat "+ randomStringName + " gewählt." + " Sie haben "+ computerMessage + ".");
				nochmalButton.setVisible(true);
			}
		});
		
		
				
		
		
		
		switch(random) {
		case 1:
			System.out.println("PC hat Stein");
			randomString = "r";
			randomStringName = "Stein";
			break;
		
		case 2:
			System.out.println("PC hat Papier");
			randomString = "p";
			randomStringName = "Papier";
			break;
		
		case 3:
			System.out.println("PC hat Schere");
			randomString = "s";
			randomStringName = "Schere";
			break;
		}
		System.out.println();
		
		
		
		
		//add to jf
		jf.add(nochmalButton);
		jf.add(computerButton);
		jf.add(zurückButton);
		jf.add(scissorsButton);
		jf.add(paperButton);
		jf.add(rockButton);
		jf.add(rpsLabel);
		jf.add(myLabel);
	
		
		
	}
	static void proof() {
		//Ergebnisüberprüfung Rock
		if(eingabe == "r" && randomString == "r") {
			System.out.println("unentschieden");
			rps.computerMessage = "unentschieden";
			
		}
		if(eingabe == "r" && randomString == "p") {
			System.out.println("verloren");
			rps.computerMessage = "verloren";
		}
		if(eingabe == "r" && randomString == "s") {
			System.out.println("gewonnen");
			rps.computerMessage = "gewonnen";
		}
		//Ergebnisüberprüfung Paper
		if(eingabe == "p" && randomString == "r") {
			System.out.println("gewonnen");
			rps.computerMessage = "gewonnen";
		}
		if(eingabe == "p" && randomString == "p") {
			System.out.println("unentschieden");
			rps.computerMessage = "unentschieden";
		}
		if(eingabe == "p" && randomString == "s") {
			System.out.println("verloren");
			rps.computerMessage = "verloren";
		}
		//Ergebnisüberprüfung Scissors
		if(eingabe == "s" && randomString == "r") {
			System.out.println("verloren");
			rps.computerMessage = "verloren";
		}
		if(eingabe == "s" && randomString == "p") {
			System.out.println("gewonnen");
			rps.computerMessage = "gewonnen";
		}
		if(eingabe == "s" && randomString == "s") {
			System.out.println("unentschieden");
			rps.computerMessage = "unentschieden";
		}
	}
	
}
