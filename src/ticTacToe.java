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

public class ticTacToe extends JFrame{

	
	static int buttonBreite = Main.buttonBreite;
	static int buttonHöhe = Main.buttonHöhe;
	public static void ticTacToe() 
	{
		
		//JFrame erstellen
		JFrame jf = new JFrame();
		jf.setTitle("Arcade Spiele - TicTacToe");
		jf.setSize(1280, 720);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(EXIT_ON_CLOSE);
		jf.setVisible(true);
				
		//Schriftarten
		Font schrift = new Font ("Rockwell", Font.PLAIN , 50);
		Font eingabeSchrift = new Font("Rockwell", Font.BOLD, 120);
				
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
		
		//Background
		java.net.URL backgroundURL = Main.class.getResource("pictures\\tictactoeBackground.png");
		ImageIcon background = new ImageIcon(backgroundURL);
		JLabel myLabel = new JLabel(background);
		myLabel.setSize(1280, 720);
		
		
		
		//ICON
		java.net.URL taskbarIconURL = Main.class.getResource("pictures\\taskbarIcon.png");
		ImageIcon taskbarIcon = new ImageIcon(taskbarIconURL);
		jf.setIconImage(taskbarIcon.getImage());
		
		//Felder erstellen
		customButton[] felderArray = new customButton[9];
		
		for(int i = 0; i < 9; i++)
		{
			//var felderArray[1] = new customButton();
			
			//customButton[] felderArray = new customButton[4];
		
		}
		
		
		
		
		jf.add(zurückButton);
		jf.add(myLabel);
		
		
		
	}
	
}
