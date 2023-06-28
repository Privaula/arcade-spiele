import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.Clip;
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
	
		//Variablen
		public static int buttonBreite = 110;
		public static int buttonHöhe = 85;
		
		public Main()
		{
			//JFrame erstellen
			setTitle("Arcade Spiele - Main Menu");
			setSize(1280, 720);
			setLocationRelativeTo(null);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
	
			//Titel Arcade Spiele
			java.net.URL titlePictureURL = getClass().getResource("pictures\\Title.png");

			
			
			ImageIcon titlePicture = new ImageIcon(titlePictureURL);
			JLabel title = new JLabel(titlePicture);
			JPanel titlePanel = new JPanel();
			titlePanel.add(title);
			titlePanel.setBounds(300, 20, 600, 100);
			
			//Uhrzeit
			SimpleDateFormat date = new SimpleDateFormat("HH:mm");
			String date1 = date.format(new Date());
			System.out.println(date1);
			JLabel uhrzeitLabel = new JLabel(date.format(new Date()));
			Font uhrzeitFont =new Font("Rockwell", Font.PLAIN , 50);
			uhrzeitLabel.setForeground(Color.white);
			uhrzeitLabel.setFont(uhrzeitFont);
			uhrzeitLabel.setBounds(20, 550, 250, 150);
			
			
			
			
			
			
			
			
			
			
			//Aman Jonas Button
			JButton memoryButton = new JButton("aman jonas memory");
			memoryButton.setBounds(420, 420, 200, 200);
			memoryButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					memory.memory();
				}
			});
			
			//Zahlenguesser Button
			java.net.URL zahlenguesserIconURL = getClass().getResource("pictures\\zahlenguesser.png");
			ImageIcon zahlenguesserIcon = new ImageIcon(zahlenguesserIconURL);
			
			java.net.URL zahlenguesserAltIconURL = getClass().getResource("pictures\\zahlenguesseralt.png");
			ImageIcon zahlenguesserAltIcon = new ImageIcon(zahlenguesserAltIconURL);
			JButton zahlenguesserButton = new JButton(zahlenguesserIcon);
			zahlenguesserButton.setRolloverIcon(zahlenguesserAltIcon);
			zahlenguesserButton.setBounds(170, 420, 200, 200);
			zahlenguesserButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					zahlenguesser.zahlenguesser();
					JFrame jf = new zahlenguesser();	
				}
			});
			
			
			
			
			
			
			
			
			//Rock Paper Scissors Button
			java.net.URL rpsIconURL = getClass().getResource("pictures\\rps.png");
			System.out.println(rpsIconURL.toExternalForm());
			
			ImageIcon rpsIcon = new ImageIcon(rpsIconURL);
			JButton rpsButton = new JButton(rpsIcon);
			rpsButton.setBounds(670, 420, 200, 200);
			rpsButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					rps.rps();
				}
			});
			
			
			
			//TicTacToe Button
			java.net.URL ticTacToeIconURL = getClass().getResource("pictures\\zahlenguesser.png");
			ImageIcon ticTacToeIcon = new ImageIcon(ticTacToeIconURL);
			
			//java.net.URL zahlenguesserAltIconURL = getClass().getResource("pictures\\zahlenguesseralt.png");
			//ImageIcon zahlenguesserAltIcon = new ImageIcon(zahlenguesserAltIconURL);
			JButton ticTacToeButton = new JButton(ticTacToeIcon);
			//zahlenguesserButton.setRolloverIcon(zahlenguesserAltIcon);
			ticTacToeButton.setBounds(930, 420, 200, 200);
			ticTacToeButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					ticTacToe.ticTacToe();
					JFrame jf = new ticTacToe();	
				}
			});
			
			
			
			
			
			
			
			
			//Background
			JLabel myLabel;
			java.net.URL backgroundURL = getClass().getResource("pictures\\backgroundNew.png");
			ImageIcon background = new ImageIcon(backgroundURL);
			myLabel = new JLabel(background);
			myLabel.setSize(1280, 720);
			
			//ICON
			java.net.URL taskbarIconURL = Main.class.getResource("pictures\\taskbarIcon.png");
			ImageIcon taskbarIcon = new ImageIcon(taskbarIconURL);
			setIconImage(taskbarIcon.getImage());
			
			//Endebutton
			JButton button = new JButton("Ende");
			button.setBounds(20, 20, buttonBreite, buttonHöhe);
			button.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
					
				}
			});
			
			
			
			
			
			
			
			//Layout
			Container pane = getContentPane();
			GroupLayout gl = new GroupLayout(pane);
			pane.setLayout(null);
			pane.add(rpsButton);
			pane.add(memoryButton);
			//pane.add(titlePanel);
			pane.add(uhrzeitLabel);
			pane.add(button);
			pane.add(zahlenguesserButton);
			pane.add(ticTacToeButton);
			pane.add(myLabel);
			
			
			gl.setVerticalGroup(gl.createSequentialGroup().addComponent(button));
			gl.setHorizontalGroup(gl.createSequentialGroup().addComponent(button));
			
			gl.setAutoCreateContainerGaps(true);
		}

		
		
	}


