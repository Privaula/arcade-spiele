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
		
		//ICON
		java.net.URL taskbarIconURL = Main.class.getResource("pictures\\taskbarIcon.png");
		ImageIcon taskbarIcon = new ImageIcon(taskbarIconURL);
		jf.setIconImage(taskbarIcon.getImage());

		//Zurück Button
		java.net.URL backButtonIconURL = Main.class.getResource("pictures\\backButton.png");
		ImageIcon backButtonIcon = new ImageIcon(backButtonIconURL);
		JButton zurückButton = new JButton(backButtonIcon);
		zurückButton.setBounds(5, 5, buttonBreite, buttonHöhe);
		zurückButton.setBorder(null);
		zurückButton.setContentAreaFilled(false);
		zurückButton.setBackground(new Color(0,0,0,0));
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
		Font schrift = new Font ("Public Pixel", Font.PLAIN , 25);
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
		java.net.URL steinURL = Main.class.getResource("pictures\\stein.png");
		ImageIcon steinIcon = new ImageIcon(steinURL);
		JButton rockButton = new JButton(steinIcon);
		rockButton.setBounds(120, 170, 300, 200);
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
		java.net.URL papierURL = Main.class.getResource("pictures\\papier.png");
		ImageIcon papierIcon = new ImageIcon(papierURL);
		JButton paperButton = new JButton(papierIcon);
		paperButton.setBounds(450, 170, 300, 200);
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
		java.net.URL schereURL = Main.class.getResource("pictures\\schere.png");
		ImageIcon schereIcon = new ImageIcon(schereURL);
		JButton scissorsButton = new JButton(schereIcon);
		scissorsButton.setBounds(780, 170, 300, 200);
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
