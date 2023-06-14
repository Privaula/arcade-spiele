import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;




public class zahlenguesser extends JFrame {
	
	
	


	
	public static void lul() {
		// TODO Auto-generated method stub
		
		int random = (int)(Math.random() * 100);
		System.out.println(random);
		
		
		JFrame jf = new JFrame();
		System.out.println("siuus");
		jf.setTitle("Tolle GUI");
		jf.setSize(1280, 720);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(EXIT_ON_CLOSE);
		jf.setVisible(true);
		
		//Background
		ImageIcon bg = new ImageIcon("C:\\Users\\Julian\\Downloads\\coin-4180241_1280.jpg");
		JLabel myLabel = new JLabel(bg);
		myLabel.setSize(1280, 720);
		
		//random number anzeigen
		JLabel randomNumber = new JLabel("random " + random);
		randomNumber.setSize(500, 70);
		randomNumber.setLocation(50, 50);
		Font schrift = new Font ("Serif", Font.BOLD, 80);
		randomNumber.setFont(schrift);

		//Frage
		String guess = JOptionPane.showInputDialog("Bitte wählen sie eine Zahl von 1 bis 100 aus.");
		System.out.println(guess);
		int newGuess = Integer.parseInt(guess);
		jf.add(randomNumber);
		jf.add(myLabel);

		//Überprüfung
		if (random == newGuess) {
			System.out.println("richtig");
			

		}else if(newGuess < random){
			System.out.println("Die Zahl ist größer.");
			guess = JOptionPane.showInputDialog("Bitte wählen sie eine Zahl von 1 bis 100 aus.");
		}else if(newGuess > random){
			System.out.println("Die Zahl ist kleiner.");
			guess = JOptionPane.showInputDialog("Bitte wählen sie eine Zahl von 1 bis 100 aus.");
		}
	
	}
		
		
		
	
	

}
