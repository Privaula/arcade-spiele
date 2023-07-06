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

public class ticTacToe extends JFrame //implements ActionListener
{

	
	static int buttonBreite = Main.buttonBreite;import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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
	static  public boolean player1;
	boolean einzelspielerbool = true;
	boolean gameRunning = false;
	
 	public void ticTacToe() 
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

		//empty boarder
		Border emptyBorder = BorderFactory.createEmptyBorder();
		
		
		
		//einzelspieler mehrspieler buttons
		var einzelspieler = new JButton("einzelspieler");
		var mehrspieler = new JButton("mehrspieler");
		einzelspieler.setBounds(800,20,120,40);
		einzelspieler.setText("Einzelspieler");
		einzelspieler.setBackground(Color.decode("#1A5276"));
		einzelspieler.setForeground(Color.white);
		mehrspieler.setBounds(920,20,120,40);
		mehrspieler.setText("Mehrspieler");
		mehrspieler.setBackground(Color.decode("#1F618D"));
		mehrspieler.setForeground(Color.white);
		einzelspieler.setFocusable(false);
		mehrspieler.setFocusable(false);
		einzelspieler.setBorder(null);
		mehrspieler.setBorder(null);
		
		
			
		
		
		
		//Felder erstellen
		
		customButtonttt button1 = new customButtonttt(150, 80, this, "button1");
		//button1.addActionListener(this);
		customButtonttt button2 = new customButtonttt(350, 80,this, "button2");
		customButtonttt button3 = new customButtonttt(550, 80,this, "button3");
		customButtonttt button4 = new customButtonttt(150, 280,this, "button4");
		customButtonttt button5 = new customButtonttt(350, 280,this, "button5");
		customButtonttt button6 = new customButtonttt(550, 280,this, "button6");
		customButtonttt button7 = new customButtonttt(150, 480,this, "button7");
		customButtonttt button8 = new customButtonttt(350, 480,this, "button8");
		customButtonttt button9 = new customButtonttt(550, 480,this, "button9");

		einzelspieler.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
					
				if(gameRunning)
				{
					gameRunning = false;
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
					gameRunning = false;
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
		
		jf.add(myLabel);
		
		
		
		
		
		
		
	}
 	
 	
 	
 	
 	
 	public void pressedButton(int i , customButtonttt button)
 	{
 		
 		if(player1)
 		{
 			button.setText("x");
 			fieldArray[i] = 1;
 			player1 = false;
 		}
 		else if(!player1)
 		{
 			button.setText("o");
 			fieldArray[i] = 2;
 			player1 = true;
 		}
 	}
}
		

	static int buttonHöhe = Main.buttonHöhe;
	static public int[] fieldArray = new int[9];
	static  public boolean player1;
	
 	public  void ticTacToe() 
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
		
		customButtonttt button1 = new customButtonttt(150, 80, this, "button1");
		//button1.addActionListener(this);
		customButtonttt button2 = new customButtonttt(350, 80,this, "button2");
		customButtonttt button3 = new customButtonttt(550, 80,this, "button3");
		customButtonttt button4 = new customButtonttt(150, 280,this, "button4");
		customButtonttt button5 = new customButtonttt(350, 280,this, "button5");
		customButtonttt button6 = new customButtonttt(550, 280,this, "button6");
		customButtonttt button7 = new customButtonttt(150, 480,this, "button7");
		customButtonttt button8 = new customButtonttt(350, 480,this, "button8");
		customButtonttt button9 = new customButtonttt(550, 480,this, "button9");

	
		
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

		jf.add(myLabel);
		
		
		
		
		
		
		
	}
 	
 	
 	
 	
 	
 	public void pressedButton(int i , customButtonttt button)
 	{
 		if(player1)
 		{
 			button.setText("x");
 			fieldArray[i] = 1;
 			player1 = false;
 		}
 		else if(!player1)
 		{
 			button.setText("o");
 			fieldArray[i] = 2;
 			player1 = true;
 		}
 	}

//
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		// TODO Auto-generated method stub
//		
//	}
}
//		
