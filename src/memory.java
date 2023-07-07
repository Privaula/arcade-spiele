import java.awt.Color;
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
import javax.swing.JTextField;

public class memory extends JFrame {
	
	
	public static void Main(String[] args) {
		
	}
		
		public  void memory(RandomNum Number) {
			
			//JFrame erstellen
			JFrame jf = new JFrame();
			jf.setTitle("Arcade Spiele - Memory");
			jf.setSize(1280, 720);
			jf.setLocationRelativeTo(null);
			jf.setVisible(true);
			System.out.println("ja von memory");
		
			
			
			//Zurück Button
			JButton zurückButton = new JButton("Zurück");
			zurückButton.setBounds(20, 20, Main.buttonBreite, Main.buttonHöhe);
			zurückButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					Main.main(null);
					jf.setVisible(false);
				}
			});
			
			//ICON
			java.net.URL taskbarIconURL = Main.class.getResource("pictures\\taskbarIcon.png");
			ImageIcon taskbarIcon = new ImageIcon(taskbarIconURL);
			jf.setIconImage(taskbarIcon.getImage());
			
			
			GroupLayout gl = new GroupLayout(jf);
			jf.setLayout(null);
			// Buttons für Gameplay

			customButtonMemory customButtonMemory1 = new customButtonMemory(150, 150, this, "customButtonMemory1");
			customButtonMemory customButtonMemory2 = new customButtonMemory(250, 250, this, "customButtonMemory2");
			customButtonMemory customButtonMemory3 = new customButtonMemory(300, 300, this, "customButtonMemory3");
			customButtonMemory customButtonMemory4 = new customButtonMemory(350, 350, this, "customButtonMemory4");
			customButtonMemory customButtonMemory5 = new customButtonMemory(400, 400, this, "customButtonMemory5");
			customButtonMemory customButtonMemory6 = new customButtonMemory(450, 450, this, "customButtonMemory6");

			//add to jf
			jf.add(zurückButton);
			jf.add(customButtonMemory1);
			jf.add(customButtonMemory2);
			jf.add(customButtonMemory3);
			jf.add(customButtonMemory4);
			jf.add(customButtonMemory5);
			jf.add(customButtonMemory6);

			// Array für 

		}	
}
