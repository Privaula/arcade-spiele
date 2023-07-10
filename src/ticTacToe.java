import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class ticTacToe extends JFrame 
{

	
	static int buttonBreite = Main.buttonBreite;
	static int buttonHöhe = Main.buttonHöhe;
	static public int[] fieldArray = new int[9];
	static public boolean mehrspieler_Player1 = true;
	static public boolean einzelspieler_spielerTurn;
	boolean einzelspielerbool = true;
	boolean gameRunning = true;
	Random rd = new Random();
	private customButtonttt button1;
	private customButtonttt button2;
	private customButtonttt button3;
	private customButtonttt button4;
	private customButtonttt button5;
	private customButtonttt button6;
	private customButtonttt button7;
	private customButtonttt button8;
	private customButtonttt button9;
	private JButton nochmalButton;
	
	private java.net.URL taskbarIconURL = Main.class.getResource("pictures\\taskbarIcon.png");
	
	
 	public void ticTacToe() 
	{
 		//random SpielerTurn
 		einzelspieler_spielerTurn = rd.nextBoolean();
 		
 		
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
		java.net.URL backButtonIconURL = Main.class.getResource("pictures\\backButton.png");
		ImageIcon backButtonIcon = new ImageIcon(backButtonIconURL);
		JButton zurückButton = new JButton(backButtonIcon);
		zurückButton.setBounds(20, 20, buttonBreite, buttonHöhe);
//		zurückButton.setAction(backButtonIconURL)
		zurückButton.setBorder(null);
		zurückButton.setContentAreaFilled(false);
		zurückButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Main.main(null);
				jf.setVisible(false);
			}
		});
		//Neues SpielButton
		java.net.URL retryButtonIconURL = Main.class.getResource("pictures\\retryButton.png");
		ImageIcon retryButtonIcon = new ImageIcon(retryButtonIconURL);
		nochmalButton = new JButton(retryButtonIcon);
		nochmalButton.setBounds(900, 550, 180, 80);
		nochmalButton.setBorder(null);
		nochmalButton.setContentAreaFilled(false);
		nochmalButton.setBackground(new Color(0,0,0,0));
		nochmalButton.setVisible(false);
		nochmalButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//		 		System.out.println("actionlistener gestarted");
				tttReset();
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

		//einzelspieler button
		var einzelspieler = new JButton("einzelspieler");
		einzelspieler.setBounds(900,20,120,40);
		einzelspieler.setText("Einzelspieler");
		einzelspieler.setBackground(Color.decode("#1A5276"));
		einzelspieler.setForeground(Color.white);
		einzelspieler.setFocusable(false);
		einzelspieler.setBorder(null);
		
		//mahrspieler Button
		var mehrspieler = new JButton("mehrspieler");
		mehrspieler.setBounds(1020,20,120,40);
		mehrspieler.setText("Mehrspieler");
		mehrspieler.setBackground(Color.decode("#1F618D"));
		mehrspieler.setForeground(Color.white);
		mehrspieler.setFocusable(false);
		mehrspieler.setBorder(null);
		

		button1 = new customButtonttt(250, 80, this, "button1");
		button2 = new customButtonttt( 450, 80,this, "button2");
		button3 = new customButtonttt( 650, 80,this, "button3");
		button4 = new customButtonttt(250, 280,this, "button4");
		button5 = new customButtonttt(450, 280,this, "button5");
		button6 = new customButtonttt(650, 280,this, "button6");
		button7 = new customButtonttt(250, 480,this, "button7");
		button8 = new customButtonttt(450, 480,this, "button8");
		button9 = new customButtonttt(650, 480,this, "button9");

		//einzelspieler mehrspieler Actionlistener
		einzelspieler.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
					
				if(gameRunning)
				{
					button1.setText(" ");
					button2.setText(" ");
					button3.setText(" ");
					button4.setText(" ");
					button5.setText(" ");
					button6.setText(" ");
					button7.setText(" ");
					button9.setText(" ");
					button8.setText(" ");
					for(int i = 0; i < fieldArray.length; i++)
					{
						fieldArray[i] = 0;
					}
					
				}
				einzelspieler.setBackground(Color.decode("#1A5276"));
				mehrspieler.setBackground(Color.decode("#1F618D"));
				einzelspielerbool = true;
			}
		});
		mehrspieler.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
					
				if(gameRunning)
				{
					button1.setText(" ");
					button2.setText(" ");
					button3.setText(" ");
					button4.setText(" ");
					button5.setText(" ");
					button6.setText(" ");
					button7.setText(" ");
					button9.setText(" ");
					button8.setText(" ");
					for(int i = 0; i < fieldArray.length; i++)
					{
						fieldArray[i] = 0;
					}
				}
					mehrspieler.setBackground(Color.decode("#1A5276"));
					einzelspieler.setBackground(Color.decode("#1F618D"));
					einzelspielerbool = false;
			}
		});
				
		
		//add to jf
		jf.add(zurückButton);
		jf.add(button1);
		jf.add(button2);
		jf.add(button3);
		jf.add(button4);
		jf.add(button5);
		jf.add(button6);
		jf.add(button7);
		jf.add(button8);
		jf.add(button9);
		jf.add(einzelspieler);
		jf.add(mehrspieler);
		jf.add(nochmalButton);
		jf.add(myLabel);
			
	}
 	
 	public void pressedButton(int i , customButtonttt button)
 	{
 		
 		if(mehrspieler_Player1)
 		{
 			button.setText("x");
 			fieldArray[i] = 1;
 			mehrspieler_Player1 = false;
 		}
 		else if(!mehrspieler_Player1)
 		{
 			button.setText("o");
 			fieldArray[i] = 2;
 			mehrspieler_Player1 = true;
 		}
 		testGameOver();
 	}
 	public void testGameOver()
 	
 	{
		if(fieldArray[0] == fieldArray[1] && fieldArray[0] == fieldArray[2] && fieldArray[0] != 0)
		{
			if(fieldArray[0] == 1)
			{
				System.out.println("Spieler1 gewinnt");
				gameRunning = false;
				//button1.setIcon();
			}
			else if(fieldArray[0] == 2)
			{
				System.out.println("Spieler2 gewinnt");
				gameRunning = false;
			}
		}
		else if(fieldArray[3] == fieldArray[4] && fieldArray[3] == fieldArray[5] && fieldArray[3] != 0)
		{
			if(fieldArray[3] == 1)
			{
				System.out.println("Spieler1 gewinnt");
				gameRunning = false;
			}
			else if(fieldArray[3] == 2)
			{
				System.out.println("Spieler2 gewinnt");
				gameRunning = false;
			}
		}
		else if(fieldArray[6] == fieldArray[7] && fieldArray[6] == fieldArray[8] && fieldArray[6] != 0)
		{
			if(fieldArray[6] == 1)
			{
				System.out.println("Spieler1 gewinnt");
				gameRunning = false;
			}
			else if(fieldArray[6] == 2)
			{
				System.out.println("Spieler2 gewinnt");
				gameRunning = false;
			}
		}
		else if(fieldArray[0] == fieldArray[4] && fieldArray[0] == fieldArray[8] && fieldArray[0] != 0)
		{
			if(fieldArray[0] == 1)
			{
				System.out.println("Spieler1 gewinnt");
				gameRunning = false;
			}
			else if(fieldArray[0] == 2)
			{
				System.out.println("Spieler2 gewinnt");
				gameRunning = false;
			}
		}
		else if(fieldArray[2] == fieldArray[4] && fieldArray[2] == fieldArray[6] && fieldArray[2] != 0)
		{
			if(fieldArray[2] == 1)
			{
				System.out.println("Spieler1 gewinnt");
				gameRunning = false;
			}
			else if(fieldArray[2] == 2)
			{
				System.out.println("Spieler2 gewinnt");
				gameRunning = false;
			}
		}
		else if(fieldArray[0] != 0 && fieldArray[1] != 0 && fieldArray[2] != 0 && fieldArray[3] != 0 && fieldArray[4] != 0 && fieldArray[5] != 0 && fieldArray[6] != 0 && fieldArray[7] != 0 && fieldArray[8] != 0)
		{
			System.out.println("Unentscheiden");
			gameRunning = false;
		}
 	}
 	public void tttReset()
 	{

 		button1.setIcon(null);
 		button1.setText(" ");
 		button2.setIcon(null);
 		button2.setText(" ");
 		button3.setIcon(null);
 		button3.setText(" ");
 		button4.setIcon(null);
 		button4.setText(" ");
 		button5.setIcon(null);
 		button5.setText(" ");
 		button6.setIcon(null);
 		button6.setText(" ");
 		button7.setIcon(null);
 		button7.setText(" ");
 		button8.setIcon(null);
 		button8.setText(" ");
 		button9.setIcon(null);
 		button9.setText(" ");
 		for(int i = 0; i < 9; i++)
 		{
 			fieldArray[i] = 0;
 		}
 		mehrspieler_Player1 = true;
 		nochmalButton.setVisible(false);
 		gameRunning = true;
 	}
 	public void nochmalButtonVisible()
 	{
 		nochmalButton.setVisible(true);
 	}
 	
}		
