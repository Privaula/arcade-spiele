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




public class zahlenguesser extends JFrame {
	
	
	


	
	public static void lul() {
		// TODO Auto-generated method stub
		
		int random = (int)(Math.random() * 10);
		System.out.println(random);
		
		
		JFrame jf = new JFrame();
		System.out.println("siuu");
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
		JLabel randomNumber = new JLabel("random" + random);
		randomNumber.setSize(500, 70);
		randomNumber.setLocation(50, 50);
		Font schrift = new Font ("Serif", Font.BOLD, 80);
		randomNumber.setFont(schrift);
		
		jf.add(randomNumber);
		jf.add(myLabel);
		
		
		
	}
	

}
