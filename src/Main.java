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
			setTitle("Arcade Spiele - Main Menu");
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
			memoryButton.setBounds(420, 220, 200, 200);
			memoryButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					memory.memory();
				}
			});
			
			//Zahlenguesser Button
			ImageIcon zahlenguesserIcon = new ImageIcon("C:\\Users\\Julian\\eclipse-workspace\\arcade-spiele\\src\\zahlenguesser.png");
			ImageIcon zahlenguesserAltIcon = new ImageIcon("C:\\Users\\Julian\\eclipse-workspace\\arcade-spiele\\src\\zahlenguesseralt.png");
			JButton zahlenguesserButton = new JButton(zahlenguesserIcon);
			zahlenguesserButton.setRolloverIcon(zahlenguesserAltIcon);
			
			zahlenguesserButton.setBounds(170, 220, 200, 200);
			JLabel myLabel;
			ImageIcon bg = new ImageIcon("C:\\Users\\Julian\\Downloads\\coin-4180241_1280.jpg");
			myLabel = new JLabel(bg);
			myLabel.setSize(1280, 720);
			
			//Endebutton
			JButton button = new JButton("Ende");
			button.setBounds(30, 40, 100, 70);
			button.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
					
				}
			});
			
			zahlenguesserButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					
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
			pane.add(zahlenguesserButton);
			pane.add(myLabel);
			
			
			gl.setVerticalGroup(gl.createSequentialGroup().addComponent(button));
			gl.setHorizontalGroup(gl.createSequentialGroup().addComponent(button));
			
			gl.setAutoCreateContainerGaps(true);
		}

		
		
	}

