import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Main extends JFrame{
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable()  {
			
			@Override
			public void run() {
				Main m = new Main();
				m.setVisible(true);
			}
		});
		}

		public Main()
		{
			setTitle("Tolle GUI");
			setSize(1280, 720);
			setLocationRelativeTo(null);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
	
			//Titel Arcade Spiele
			ImageIcon titlePicture = new ImageIcon("C:\\Users\\Julian\\eclipse-workspace\\arcade-spiele\\src\\Title.png");
			JLabel title = new JLabel(titlePicture);
			JPanel titlePanel = new JPanel();
			titlePanel.add(title);
			titlePanel.setBounds(300, 20, 600, 100);
			
			//Aman Jonas Button
			JButton memoryButton = new JButton("aman jonas memory");
			memoryButton.setBounds(400, 200, 150, 150);
			memoryButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					memory.memory();
				}
			});
			
			//Zahlenguesser Button
			ImageIcon x = new ImageIcon("C:\\Users\\Julian\\Downloads\\istockphoto-1056840214-612x612.jpg");
			ImageIcon y = new ImageIcon("H:\\Bilder\\Fußball\\Download.png");
			JButton imageButton = new JButton("Schere Stein Papier (Bild kann nicht geladen werden)", x);
			imageButton.setRolloverIcon(y);
			
			imageButton.setBounds(150, 200, 150, 150);
			JLabel myLabel;
			ImageIcon bg = new ImageIcon("C:\\Users\\Julian\\Downloads\\coin-4180241_1280.jpg");
			myLabel = new JLabel(bg);
			myLabel.setSize(1280, 720);
			
			//Endebutton
			JButton button = new JButton("Ende");
			button.setBounds(30, 40, 70, 50);
			button.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
					
				}
			});
			
			imageButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					System.out.println("ja");
					zahlenguesser.zahlenguesser();
					
					JFrame jf = new zahlenguesser();
					
				}
			});

			
			//Layout
			Container pane = getContentPane();
			GroupLayout gl = new GroupLayout(pane);
			pane.setLayout(null);
			pane.add(memoryButton);
			pane.add(titlePanel);
			pane.add(button);
			pane.add(imageButton);
			pane.add(myLabel);
			
			
			gl.setVerticalGroup(gl.createSequentialGroup().addComponent(button));
			gl.setHorizontalGroup(gl.createSequentialGroup().addComponent(button));
			
			gl.setAutoCreateContainerGaps(true);
		}

		
		
	}

