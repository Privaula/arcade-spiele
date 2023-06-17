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
		
		public static void memory() {
			
			JFrame jf = new JFrame();
			jf.setTitle("Arcade Spiele - Memory");
			jf.setSize(1280, 720);
			jf.setLocationRelativeTo(null);
			jf.setVisible(true);
			System.out.println("ja von memory");
		
			
			
			JButton endeButton = new JButton("Ende");
			endeButton.setBounds(30, 40, 100, 70);
			endeButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					System.exit(0);	
				}
			});


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



			//ICON
			java.net.URL taskbarIconURL = Main.class.getResource("pictures\\taskbarIcon.png");
			ImageIcon taskbarIcon = new ImageIcon(taskbarIconURL);
			jf.setIconImage(taskbarIcon.getImage());
			
			
			GroupLayout gl = new GroupLayout(jf);
			jf.setLayout(null);
			
			
			//add to jf
			jf.add(endeButton);
			jf.add(zurückButton);
		}
}
