import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

public class ticTacToe extends JFrame 
{

	
	static int buttonBreite = Main.buttonBreite;
	static int buttonHöhe = Main.buttonHöhe;
	static public int[] fieldArray = new int[9];
	static public boolean mehrspieler_player1 = true;
	static public boolean einzelspieler_player1;
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
	JTextArea winnerField;
	JTextArea loserField;
	JTextArea unendschiedenField;
	JLabel myLabel;
	Font font = new Font("Public Pixel", Font.PLAIN , 40);
	Font unentschiedenFont = new Font("Public Pixel", Font.PLAIN , 30);
	boolean runnableRunning = false;
	
	
	private java.net.URL ticTacToe_o_green 	= 	Main.class.getResource("pictures\\ticTacToe_o_green.png");
	private java.net.URL ticTacToe_o 		=	Main.class.getResource("pictures\\ticTacToe_o.png");
	private java.net.URL ticTacToe_x_green 	= 	Main.class.getResource("pictures\\ticTacToe_x_green.png");
	private java.net.URL ticTacToe_x	 	= 	Main.class.getResource("pictures\\ticTacToe_x.png");
	
	Icon _xButtonIcon;
	Icon _oButtonIcon;
	Icon _xGreenButtonIcon;
	Icon _oGreenButtonIcon;
	Icon _mButtonIcon;
	Icon _sButtonIcon;
	private JFrame jf;
	
 	public void ticTacToe() 
	{
 		//
 		//buttons icons statt text(optional)
 		//
 		
 		loadImages();
 		einzelspieler_player1 = true;
 		
		jf = new JFrame();
		jf.setTitle("Arcade Spiele - TicTacToe");
		jf.setSize(1280, 720);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(EXIT_ON_CLOSE);
		jf.setVisible(true);
		jf.setResizable(false);
		
		//Grid TicTacToe erstellen
		var gridPart1 = new JLabel();
		gridPart1.setOpaque(true);
		gridPart1.setLocation(250,245);
		gridPart1.setSize(550,20);
		gridPart1.setBackground(Color.black);
		
		var gridPart2 = new JLabel();
		gridPart2.setLocation(250,445);
		gridPart2.setSize(550,20);
		gridPart2.setOpaque(true);
		gridPart2.setBackground(Color.black);
		
		var gridPart3 = new JLabel();
		gridPart3.setLocation(415,80);
		gridPart3.setSize(20,550);
		gridPart3.setOpaque(true);
		gridPart3.setBackground(Color.black);
		
		var gridPart4 = new JLabel();
		gridPart4.setLocation(615,80);
		gridPart4.setSize(20,550);
		gridPart4.setOpaque(true);
		gridPart4.setBackground(Color.black);
				
		//Schriftarten
		Font schrift = new Font ("Rockwell", Font.PLAIN , 50);
		Font eingabeSchrift = new Font("Rockwell", Font.BOLD, 120);
				
		//Gewinnernachricht Textfield
		winnerField = new JTextArea();
		winnerField.setBounds(870, 270, 370, 100);
		Font winnerFont = new Font("Impact", ABORT, 60);
		winnerField.setFont(font);
		winnerField.setEditable(false);
		winnerField.setForeground(Color.GREEN);
		winnerField.setBackground(new Color(0,0,0,0));
		winnerField.setVisible(false);
		

		//Losernachricht Textfield
		loserField = new JTextArea();
		loserField.setBounds(870, 370, 370, 100);
		loserField.setFont(font);
		loserField.setEditable(false);
		loserField.setForeground(Color.RED);
		loserField.setBackground(new Color(0,0,0,0));
		loserField.setVisible(false);
		
		//Unendschiedennachricht Textfield
		unendschiedenField = new JTextArea();
		unendschiedenField.setBounds(850, 350, 390, 100);
		unendschiedenField.setFont(unentschiedenFont);
		unendschiedenField.setEditable(false);
		unendschiedenField.setForeground(Color.YELLOW);
		unendschiedenField.setBackground(new Color(0,0,0,0));
		unendschiedenField.setVisible(false);
		
		//Zurück Button
		java.net.URL backButtonIconURL = Main.class.getResource("pictures\\backButton.png");
		ImageIcon backButtonIcon = new ImageIcon(backButtonIconURL);
		JButton zurückButton = new JButton(backButtonIcon);
		zurückButton.setBounds(20, 20, buttonBreite, buttonHöhe);
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
				tttReset();
			}
		});
		
		//Background
		java.net.URL backgroundURL = Main.class.getResource("pictures\\tictactoeBackground.png");
		ImageIcon background = new ImageIcon(backgroundURL);
		myLabel = new JLabel(background);
		myLabel.setSize(1280, 720);
		
		//ICON
		java.net.URL taskbarIconURL = Main.class.getResource("pictures\\taskbarIcon.png");
		ImageIcon taskbarIcon = new ImageIcon(taskbarIconURL);
		jf.setIconImage(taskbarIcon.getImage());

		//einzelspieler button
		java.net.URL einzelspielerButtonIconURL = Main.class.getResource("pictures\\multiplayer.png");
		ImageIcon einzelspielerButtonIcon = new ImageIcon(einzelspielerButtonIconURL);
		var einzelspieler = new JButton(einzelspielerButtonIcon);
		einzelspieler.setName("einzelspieler");
		einzelspieler.setBounds(900,20,260,80);
		//einzelspieler.setText("Einzelspieler");
		//einzelspieler.setBackground(Color.decode("#1A5276"));
		//einzelspieler.setForeground(Color.white);
		einzelspieler.setFocusable(false);
		einzelspieler.setBorder(null);
		einzelspieler.setContentAreaFilled(false);
		einzelspieler.setBackground(new Color(0,0,0,0));
		einzelspieler.setVisible(false);
		
		//mahrspieler Button
		java.net.URL mehrspielerButtonIconURL = Main.class.getResource("pictures\\singleplayer.png");
		ImageIcon mehrspielerButtonIcon = new ImageIcon(mehrspielerButtonIconURL);
		var mehrspieler = new JButton(mehrspielerButtonIcon);
		mehrspieler.setName("mehrspieler");
		mehrspieler.setBounds(900,20,275,80);
		//mehrspieler.setText("Mehrspieler");
		//mehrspieler.setBackground(Color.decode("#1F618D"));
		//mehrspieler.setForeground(Color.white);
		mehrspieler.setFocusable(false);
		mehrspieler.setBorder(null);
		mehrspieler.setContentAreaFilled(false);
		mehrspieler.setBackground(new Color(0,0,0,0));
		mehrspieler.setVisible(true);
		
	
		button1 = new customButtonttt(250,  80,this, "button1");
		button2 = new customButtonttt(450,  80,this, "button2");
		button3 = new customButtonttt(650,  80,this, "button3");
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
				tttReset();
				//einzelspieler.setBackground(Color.decode("#1A5276"));
				//mehrspieler.setBackground(Color.decode("#1F618D"));
				einzelspieler.setVisible(false);
				mehrspieler.setVisible(true);
				einzelspielerbool = true;
			}
		});
		mehrspieler.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tttReset();
				//mehrspieler.setBackground(Color.decode("#1A5276"));
				//einzelspieler.setBackground(Color.decode("#1F618D"));
				einzelspieler.setVisible(true);
				mehrspieler.setVisible(false);
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
		jf.add(gridPart1);
		jf.add(gridPart2);
		jf.add(gridPart3);
		jf.add(gridPart4);
		jf.add(winnerField);
		jf.add(loserField);
		jf.add(unendschiedenField);
		jf.add(myLabel);
			
		
	}
 	
 	private void loadImages()
 	{
 		try
 		{
			var xRes = getClass().getResource("pictures/xSchwarz.png");
			var oRes = getClass().getResource("pictures/kreisSchwarz.png");
			var xGreenRes = getClass().getResource("pictures/kreisGrun.png");
			var oGreenRes = getClass().getResource("pictures/xGrun.png");
			var xImg = ImageIO.read(xRes);
			var oImg = ImageIO.read(oRes);
			var xGreenImg = ImageIO.read(xGreenRes);
			var oGreenImg = ImageIO.read(oGreenRes);
			_xButtonIcon = new ImageIcon(xImg);
			_oButtonIcon = new ImageIcon(oImg);
			_xGreenButtonIcon = new ImageIcon(xGreenImg);
			_oGreenButtonIcon = new ImageIcon(oGreenImg);
			
			//var mRes = getClass().getResource("file");
			//var mImg = ImageIO.read(mRes);
			//_mButtonIcon = new ImageIcon(mImg);
			
			//var sRes = getClass().getResource("file");
			//var sImg = ImageIO.read(sRes);
			//_sButtonIcon = new ImageIcon(sImg);
			
 		}
 		catch (IOException e) {
			// nothing
		}
		
	}

	public void pressedButtonMehrspieler(int i , customButtonttt button)
 	{
 		
 		if(mehrspieler_player1)
 		{
 			fieldArray[i] = 1;
 			mehrspieler_player1 = false;
 			button.setText(null);
 			button.setIcon(_xButtonIcon);
 		}
 		else if(!mehrspieler_player1)
 		{
 			fieldArray[i] = 2;
 			mehrspieler_player1 = true;
 			button.setText(null);
 			button.setIcon(_oButtonIcon);
 		}
 		testGameOver();
 	}
 	public void pressedButtonEinzelspieler(int i, customButtonttt button)

 	{
 		if(einzelspieler_player1 && !runnableRunning)
 		{
 			fieldArray[i] = 1;
 			einzelspieler_player1 = false;
 			button.setText(null);
 			button.setIcon(_xButtonIcon);
 			
 			javax.swing.SwingUtilities.invokeLater(new Runnable() {
				
				@Override
				public void run() {
					runnableRunning = true;
		 			chooseField();
		 			runnableRunning = false;
				}
			});

 			
 		}
 	}
 	
 	public void testGameOver()
 	{
 		int playerWon = 0;
		if(fieldArray[0] == fieldArray[1] && fieldArray[0] == fieldArray[2] && fieldArray[0] != 0)
		{
			if(fieldArray[0] == 1)
			{
				button1.setText(null);
				button1.setIcon(_oGreenButtonIcon);
				button2.setText(null);
				button2.setIcon(_oGreenButtonIcon);
				button3.setText(null);
				button3.setIcon(_oGreenButtonIcon);
				gameRunning = false;
				playerWon= 1;
			}
			else if(fieldArray[0] == 2)
			{
				button1.setText(null);
				button1.setIcon(_xGreenButtonIcon);
				button2.setText(null);
				button2.setIcon(_xGreenButtonIcon);
				button3.setText(null);
				button3.setIcon(_xGreenButtonIcon);
				System.out.println("Spieler2 gewinnt");
				gameRunning = false;
				playerWon = 2;
			}
		}
		else if(fieldArray[3] == fieldArray[4] && fieldArray[3] == fieldArray[5] && fieldArray[3] != 0)
		{
			if(fieldArray[3] == 1)
			{
				button4.setText(null);
				button4.setIcon(_oGreenButtonIcon);
				button5.setText(null);
				button5.setIcon(_oGreenButtonIcon);
				button6.setText(null);
				button6.setIcon(_oGreenButtonIcon);
				System.out.println("Spieler1 gewinnt");
				gameRunning = false;
				playerWon= 1;
			}
			else if(fieldArray[3] == 2)
			{
				System.out.println("Spieler2 gewinnt");
				button4.setText(null);
				button4.setIcon(_xGreenButtonIcon);
				button5.setText(null);
				button5.setIcon(_xGreenButtonIcon);
				button6.setText(null);
				button6.setIcon(_xGreenButtonIcon);
				gameRunning = false;
				playerWon= 2;
			}
		}
		else if(fieldArray[6] == fieldArray[7] && fieldArray[6] == fieldArray[8] && fieldArray[6] != 0)
		{
			if(fieldArray[6] == 1)
			{
				button7.setText(null);
				button7.setIcon(_oGreenButtonIcon);
				button8.setText(null);
				button8.setIcon(_oGreenButtonIcon);
				button9.setText(null);
				button9.setIcon(_oGreenButtonIcon);
				System.out.println("Spieler1 gewinnt");
				gameRunning = false;
				playerWon= 1;
			}
			else if(fieldArray[6] == 2)
			{
				button7.setText(null);
				button7.setIcon(_xGreenButtonIcon);
				button8.setText(null);
				button8.setIcon(_xGreenButtonIcon);
				button9.setText(null);
				button9.setIcon(_xGreenButtonIcon);
				System.out.println("Spieler2 gewinnt");
				gameRunning = false;
				playerWon= 2;
			}
		}
		else if(fieldArray[0] == fieldArray[4] && fieldArray[0] == fieldArray[8] && fieldArray[0] != 0)
		{
			if(fieldArray[0] == 1)
			{
				button1.setText(null);
				button1.setIcon(_oGreenButtonIcon);
				button5.setText(null);
				button5.setIcon(_oGreenButtonIcon);
				button9.setText(null);
				button9.setIcon(_oGreenButtonIcon);
				System.out.println("Spieler1 gewinnt");
				gameRunning = false;
				playerWon= 1;
			}
			else if(fieldArray[0] == 2)
			{
				button1.setText(null);
				button1.setIcon(_xGreenButtonIcon);
				button5.setText(null);
				button5.setIcon(_xGreenButtonIcon);
				button9.setText(null);
				button9.setIcon(_xGreenButtonIcon);
				System.out.println("Spieler2 gewinnt");
				gameRunning = false;
				playerWon= 2;
			}
		}
		else if(fieldArray[2] == fieldArray[4] && fieldArray[2] == fieldArray[6] && fieldArray[2] != 0)
		{
			if(fieldArray[2] == 1)
			{
				button3.setText(null);
				button3.setIcon(_oGreenButtonIcon);
				button5.setText(null);
				button5.setIcon(_oGreenButtonIcon);
				button7.setText(null);
				button7.setIcon(_oGreenButtonIcon);
				System.out.println("Spieler1 gewinnt");
				gameRunning = false;
				playerWon= 1;
			}
			else if(fieldArray[2] == 2)
			{
				button3.setText(null);
				button3.setIcon(_xGreenButtonIcon);
				button5.setText(null);
				button5.setIcon(_xGreenButtonIcon);
				button7.setText(null);
				button7.setIcon(_xGreenButtonIcon);
				System.out.println("Spieler2 gewinnt");
				gameRunning = false;
				playerWon= 2;
			}
		}
		else if(fieldArray[0] == fieldArray[3] && fieldArray[0] == fieldArray[6] && fieldArray[0] != 0)
		{
			if(fieldArray[0] == 1)
			{
				button1.setText(null);
				button1.setIcon(_oGreenButtonIcon);
				button4.setText(null);
				button4.setIcon(_oGreenButtonIcon);
				button7.setText(null);
				button7.setIcon(_oGreenButtonIcon);
				System.out.println("Spieler1 gewinnt");
				gameRunning = false;
				playerWon= 1;
			}
			else if(fieldArray[0] == 2)
			{
				button1.setText(null);
				button1.setIcon(_xGreenButtonIcon);
				button4.setText(null);
				button4.setIcon(_xGreenButtonIcon);
				button7.setText(null);
				button7.setIcon(_xGreenButtonIcon);
				System.out.println("Spieler2 gewinnt");
				gameRunning = false;
				playerWon= 2;
			}
		}
		else if(fieldArray[1] == fieldArray[4] && fieldArray[1] == fieldArray[7] && fieldArray[1] != 0)
		{
			if(fieldArray[1] == 1)
			{
				button2.setText(null);
				button2.setIcon(_oGreenButtonIcon);
				button5.setText(null);
				button5.setIcon(_oGreenButtonIcon);
				button8.setText(null);
				button8.setIcon(_oGreenButtonIcon);
				System.out.println("Spieler1 gewinnt");
				gameRunning = false;
				playerWon= 1;
			}
			else if(fieldArray[1] == 2)
			{
				button2.setText(null);
				button2.setIcon(_xGreenButtonIcon);
				button5.setText(null);
				button5.setIcon(_xGreenButtonIcon);
				button8.setText(null);
				button8.setIcon(_xGreenButtonIcon);
				System.out.println("Spieler2 gewinnt");
				gameRunning = false;
				playerWon= 2;
			}
		}
		else if(fieldArray[2] == fieldArray[5] && fieldArray[2] == fieldArray[8] && fieldArray[2] != 0)
		{
			if(fieldArray[2] == 1)
			{
				button3.setText(null);
				button3.setIcon(_oGreenButtonIcon);
				button6.setText(null);
				button6.setIcon(_oGreenButtonIcon);
				button9.setText(null);
				button9.setIcon(_oGreenButtonIcon);
				System.out.println("Spieler1 gewinnt");
				gameRunning = false;
				playerWon= 1;
			}
			else if(fieldArray[2] == 2)
			{
				button3.setText(null);
				button3.setIcon(_xGreenButtonIcon);
				button6.setText(null);
				button6.setIcon(_xGreenButtonIcon);
				button9.setText(null);
				button9.setIcon(_xGreenButtonIcon);
				System.out.println("Spieler2 gewinnt");
				gameRunning = false;
				playerWon= 2;
			}
		}
		else if(fieldArray[0] != 0 && fieldArray[1] != 0 && fieldArray[2] != 0 && fieldArray[3] != 0 && fieldArray[4] != 0 && fieldArray[5] != 0 && fieldArray[6] != 0 && fieldArray[7] != 0 && fieldArray[8] != 0)
		{
			System.out.println("Unentscheiden");
			gameRunning = false;
			playerWon= 3;
		}
		else {return;}
		if(playerWon != 3)
		{
			if(playerWon == 1)
			{
				winnerField.setText("Winner: x ");
				loserField.setText("Looser: o ");
			}
			else 
			{
				winnerField.setText("Winner: o ");
				loserField.setText("Looser: x ");
			}
			winnerField.setVisible(true);
			loserField.setVisible(true);
			myLabel.setSize(1280, 721);
			myLabel.setSize(1280,720);
		}
		else
		{
			unendschiedenField.setText("Unentschieden");
			unendschiedenField.setVisible(true);
		}
		
 	}	
 	public void tttReset()
 	{
 		System.out.println("reset ttt");
 		button1.setIcon(null);
 		button1.setText(null);
 		button2.setIcon(null);
 		button2.setText(null);
 		button3.setIcon(null);
 		button3.setText(null);
 		button4.setIcon(null);
 		button4.setText(null);
 		button5.setIcon(null);
 		button5.setText(null);
 		button6.setIcon(null);
 		button6.setText(null);
 		button7.setIcon(null);
 		button7.setText(null);
 		button8.setIcon(null);
 		button8.setText(null);
 		button9.setIcon(null);
 		button9.setText(null);
 		for(int i = 0; i < 9; i++)
 		{
 			fieldArray[i] = 0;
 		}
 		mehrspieler_player1 = true;
 		einzelspieler_player1 = true;
 		nochmalButton.setVisible(false);
 		gameRunning = true;
 		winnerField.setVisible(false);
 		loserField.setVisible(false);
 		unendschiedenField.setVisible(false);
 	}
 	public void nochmalButtonVisible()
 	{
 		nochmalButton.setVisible(true);
 	}
 	public void chooseField()
 	{
 		int i = 0;
 		boolean b = false;
 		boolean cantWinOrLoose= false;
 		boolean f = false;
 		int n = 0;
 		
 		//versucht spiel zu gewinnen
 		if(fieldArray[0] == 2 && fieldArray[1] == 2  && fieldArray[2] == 0|| fieldArray[0] == 2 && fieldArray[2] == 2 && fieldArray[1] == 0|| fieldArray[1] == 2 && fieldArray[2] == 2 && fieldArray[0] == 0)					//horizontal erste Reihe
 		{
 			System.out.println("versuche spiel zu gewinnen funktioniert");
 			if(fieldArray[0] == 0)
 			{
 				fieldArray[0] = 2;
 				i = 0;
 			}
 			if(fieldArray[1] == 0)
 			{
 				fieldArray[1] = 2;
 				i = 1;
 			}
 			if(fieldArray[2] == 0)
 			{
 				fieldArray[2] = 2;
 				i = 2;
 			}
 			pressField(i, b);
 		}
 		else if(fieldArray[3] == 2 && fieldArray[4] == 2  && fieldArray[5] == 0|| fieldArray[3] == 2 && fieldArray[5] == 2 && fieldArray[4] == 0|| fieldArray[4] == 2 && fieldArray[5] == 2 && fieldArray[3] == 0)				//horizontal zweite Reihe
 		{
 			if(fieldArray[3] == 0)
 			{
 				fieldArray[3] = 2;
 				i = 3;
 			}
 			if(fieldArray[4] == 0)
 			{
 				fieldArray[4] = 2;
 				i = 4;
 			}
 			if(fieldArray[5] == 0)
 			{
 				fieldArray[5] = 2;
 				i = 5;
 			}
 			pressField(i, b);
 		}
 		else if(fieldArray[6] == 2 && fieldArray[7] == 2  && fieldArray[8] == 0|| fieldArray[6] == 2 && fieldArray[8] == 2 && fieldArray[7] == 0|| fieldArray[7] == 2 && fieldArray[8] == 2 && fieldArray[6] == 0)				//horizontal dritte Reihe
 		{
 			if(fieldArray[6] == 0)
 			{
 				fieldArray[6] = 2;
 				i = 6;
 			}
 			if(fieldArray[7] == 0)
 			{
 				fieldArray[7] = 2;
 				i = 7;
 			}
 			if(fieldArray[8] == 0)
 			{
 				fieldArray[8] = 2;
 				i = 8;
 			}
 			pressField(i, b);
 		}
 		else if(fieldArray[0] == 2 && fieldArray[3] == 2  && fieldArray[6] == 0|| fieldArray[0] == 2 && fieldArray[6] == 2 && fieldArray[3] == 0|| fieldArray[3] == 2 && fieldArray[6] == 2 && fieldArray[0] == 0)				//vertikal erste Reihe
 		{
 			if(fieldArray[0] == 0)
 			{
 				fieldArray[0] = 2;
 				i = 0;
 			}
 			if(fieldArray[3] == 0)
 			{
 				fieldArray[3] = 2;
 				i = 3;
 			}
 			if(fieldArray[6] == 0)
 			{
 				fieldArray[6] = 2;
 				i = 6;
 			}
 			pressField(i, b);
 		}
 		else if(fieldArray[1] == 2 && fieldArray[4] == 2  && fieldArray[7] == 0|| fieldArray[1] == 2 && fieldArray[7] == 2 && fieldArray[4] == 0|| fieldArray[4] == 2 && fieldArray[7] == 2 && fieldArray[1] == 0)				//vertikal zweite Reihe
 		{
 			if(fieldArray[1] == 0)
 			{
 				fieldArray[1] = 2;
 				i = 1;
 			}
 			if(fieldArray[4] == 0)
 			{
 				fieldArray[4] = 2;
 				i = 4;
 			}
 			if(fieldArray[7] == 0)
 			{
 				fieldArray[7] = 2;
 				i = 7;
 			}
 			pressField(i, b);
 		}
 		else if(fieldArray[2] == 2 && fieldArray[5] == 2  && fieldArray[8] == 0|| fieldArray[2] == 2 && fieldArray[8] == 2 && fieldArray[5] == 0|| fieldArray[5] == 2 && fieldArray[8] == 2 && fieldArray[2] == 0)				//vertikal dritte Reihe
 		{
 			if(fieldArray[2] == 0)
 			{
 				fieldArray[2] = 2;
 				i = 2;
 			}
 			if(fieldArray[5] == 0)
 			{
 				fieldArray[5] = 2;
 				i = 5;
 			}
 			if(fieldArray[8] == 0)
 			{
 				fieldArray[8] = 2;
 				i = 8;
 			}
 			pressField(i, b);
 		}
 		else if(fieldArray[0] == 2 && fieldArray[4] == 2  && fieldArray[8] == 0|| fieldArray[0] == 2 && fieldArray[8] == 2 && fieldArray[4] == 0|| fieldArray[4] == 2 && fieldArray[8] == 2 && fieldArray[0] == 0)				//schräg nach unten
 		{
 			if(fieldArray[0] == 0)
 			{
 				fieldArray[0] = 2;
 				i = 0;
 			}
 			if(fieldArray[4] == 0)
 			{
 				fieldArray[4] = 2;
 				i = 4;
 			}
 			if(fieldArray[8] == 0)
 			{
 				fieldArray[8] = 2;
 				i = 8;
 			}
 			pressField(i, b);
 		}
 		else if(fieldArray[2] == 2 && fieldArray[4] == 2  && fieldArray[6] == 0|| fieldArray[2] == 2 && fieldArray[6] == 2 && fieldArray[4] == 0|| fieldArray[4] == 2 && fieldArray[6] == 2 && fieldArray[2] == 0)				//schräg nach oben
 		{
 			if(fieldArray[2] == 0)
 			{
 				fieldArray[2] = 2;
 				i = 2;
 			}
 			if(fieldArray[4] == 0)
 			{
 				fieldArray[4] = 2;
 				i = 4;
 			}
 			if(fieldArray[6] == 0)
 			{
 				fieldArray[6] = 2;
 				i = 6;
 			}
 			pressField(i, b);
 		}
 		
 		
 		
 		
 		
 		//versucht zu verhindern dass gegner gewinnt
 		else if(fieldArray[0] == 1 && fieldArray[1] == 1  && fieldArray[2] == 0|| fieldArray[0] == 1 && fieldArray[2] == 1 && fieldArray[1] == 0|| fieldArray[1] == 1 && fieldArray[2] == 1 && fieldArray[0] == 0)					//horizontal erste Reihe
 		{
 			if(fieldArray[0] == 0)
 			{
 				fieldArray[0] = 2;
 				i = 0;
 			}
 			if(fieldArray[1] == 0)
 			{
 				fieldArray[1] = 2;
 				i = 1;
 			}
 			if(fieldArray[2] == 0)
 			{
 				fieldArray[2] = 2;
 				i = 2;
 			}
 			b = true;
 			pressField(i, b);
 		}
 		else if(fieldArray[3] == 1 && fieldArray[4] == 1  && fieldArray[5] == 0|| fieldArray[3] == 1 && fieldArray[5] == 1 && fieldArray[4] == 0|| fieldArray[4] == 1 && fieldArray[5] == 1 && fieldArray[3] == 0)				//horizontal zweite Reihe
 		{
 			if(fieldArray[3] == 0)
 			{
 				fieldArray[3] = 2;
 				i = 3;
 			}
 			if(fieldArray[4] == 0)
 			{
 				fieldArray[4] = 2;
 				i = 4;
 			}
 			if(fieldArray[5] == 0)
 			{
 				fieldArray[5] = 2;
 				i = 5;
 			}
 			b = true;
 			pressField(i, b);
 		}
 		else if(fieldArray[6] == 1 && fieldArray[7] == 1  && fieldArray[8] == 0|| fieldArray[6] == 1 && fieldArray[8] == 1 && fieldArray[7] == 0|| fieldArray[7] == 1 && fieldArray[8] == 1 && fieldArray[6] == 0)				//horizontal dritte Reihe
 		{
 			if(fieldArray[6] == 0)
 			{
 				fieldArray[6] = 2;
 				i = 6;
 			}
 			if(fieldArray[7] == 0)
 			{
 				fieldArray[7] = 2;
 				i = 7;
 			}
 			if(fieldArray[8] == 0)
 			{
 				fieldArray[8] = 2;
 				i = 8;
 			}	
 			b = true;
 			pressField(i, b);
 		}
 		else if(fieldArray[0] == 1 && fieldArray[3] == 1  && fieldArray[6] == 0|| fieldArray[0] == 1 && fieldArray[6] == 1 && fieldArray[3] == 0|| fieldArray[3] == 1 && fieldArray[6] == 1 && fieldArray[0] == 0)				//vertikal erste Reihe
 		{
 			if(fieldArray[0] == 0)
 			{
 				fieldArray[0] = 2;
 				i = 0;
 			}
 			if(fieldArray[3] == 0)
 			{
 				fieldArray[3] = 2;
 				i = 3;
 			}
 			if(fieldArray[6] == 0)
 			{
 				fieldArray[6] = 2;
 				i = 6;
 			}
 			b = true;
 			pressField(i, b);
 		}
 		else if(fieldArray[1] == 1 && fieldArray[4] == 1  && fieldArray[7] == 0|| fieldArray[1] == 1 && fieldArray[7] == 1 && fieldArray[4] == 0|| fieldArray[4] == 1 && fieldArray[7] == 1 && fieldArray[1] == 0)				//vertikal zweite Reihe
 		{
 			if(fieldArray[1] == 0)
 			{
 				fieldArray[1] = 2;
 				i = 1;
 			}
 			if(fieldArray[4] == 0)
 			{
 				fieldArray[4] = 2;
 				i = 4;
 			}
 			if(fieldArray[7] == 0)
 			{
 				fieldArray[7] = 2;
 				i = 7;
 			}
 			b = true;
 			pressField(i, b);
 		}
 		else if(fieldArray[2] == 1 && fieldArray[5] == 1  && fieldArray[8] == 0|| fieldArray[2] == 1 && fieldArray[8] == 1 && fieldArray[5] == 0|| fieldArray[5] == 1 && fieldArray[8] == 1 && fieldArray[2] == 0)				//vertikal dritte Reihe
 		{
 			if(fieldArray[2] == 0)
 			{
 				fieldArray[2] = 2;
 				i = 2;
 			}
 			if(fieldArray[5] == 0)
 			{
 				fieldArray[5] = 2;
 				i = 5;
 			}
 			if(fieldArray[8] == 0)
 			{
 				fieldArray[8] = 2;
 				i = 8;
 			}
 			b = true;
 			pressField(i, b);
 		}
 		else if(fieldArray[0] == 1 && fieldArray[4] == 1  && fieldArray[8] == 0|| fieldArray[0] == 1 && fieldArray[8] == 1 && fieldArray[4] == 0|| fieldArray[4] == 1 && fieldArray[8] == 1 && fieldArray[0] == 0)				//schräg nach unten
 		{
 			if(fieldArray[0] == 0)
 			{
 				fieldArray[0] = 2;
 				i = 0;
 			}
 			if(fieldArray[4] == 0)
 			{
 				fieldArray[4] = 2;
 				i = 4;
 			}
 			if(fieldArray[8] == 0)
 			{
 				fieldArray[8] = 2;
 				i = 8;
 			}
 			b = true;
 			pressField(i, b);
 		}
 		else if(fieldArray[2] == 1 && fieldArray[4] == 1  && fieldArray[6] == 0|| fieldArray[2] == 1 && fieldArray[6] == 1 && fieldArray[4] == 0|| fieldArray[4] == 1 && fieldArray[6] == 1 && fieldArray[2] == 0)				//schräg nach oben
 		{
 			if(fieldArray[2] == 0)
 			{
 				fieldArray[2] = 2;
 				i = 2;
 			}
 			if(fieldArray[4] == 0)
 			{
 				fieldArray[4] = 2;
 				i = 4;
 			}
 			if(fieldArray[6] == 0)
 			{
 				fieldArray[6] = 2;
 				i = 6;
 			}
 			b = true;
 			pressField(i, b);
 		}
 		else
 		{
 			b = false;
 			cantWinOrLoose = true;
 		}
 		
			
		 if(cantWinOrLoose)
		 {
			 testGameOver();
			 if(gameRunning== true)
			 {
				 switchAbrfage(n, i, b, cantWinOrLoose);
			 }
		 }
		 	
 		
 		
 	}
 	private void switchAbrfage(int n, int i, boolean b, boolean cantWinOrLoose)
 	{
 		
 		n = rd.nextInt(9);
 		if(fieldArray[n] == 0)
 		{
	 		switch(n)
				{
					case 0: i = n;
							fieldArray[n] = 2;
							break;
					case 1: i = n;
						fieldArray[n] = 2;
						break;
					case 2: i = n;
						fieldArray[n] = 2;
						break;
					case 3: i = n;
						fieldArray[n] = 2;
						break;
					case 4: i = n;
						fieldArray[n] = 2;
						break;
					case 5: i = n;
						fieldArray[n] = 2;
						break;
					case 6: i = n;
						fieldArray[n] = 2;
						break;
					case 7: i = n;
						fieldArray[n] = 2;
						break;
					case 8: i = n;
						fieldArray[n] = 2;
						break;
				}
			b = true;
			pressField(i, b);
			cantWinOrLoose = false;
 		}
 		else 
 		{
 			switchAbrfage(n, i, b, cantWinOrLoose);
 		}
 	} 		
 	private void pressField(int i, boolean b){
 	
 		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 			switch(i)
 	 		{
 	 		case 0: 	//button1.setIcon(_oButtonIcon);
 	 					button1.setText(null);
 	 					button1.setIcon(_oButtonIcon);
 	 					break;
 	 		case 1:		//button2.setIcon(_oButtonIcon);
 	 					button2.setText(null);
 	 					button2.setIcon(_oButtonIcon);	
 	 					break;
 	 		case 2: 	//button3.setIcon(_oButtonIcon);
 	 					button3.setText(null);
 	 					button3.setIcon(_oButtonIcon);
 	 					break;
 	 		case 3: 	//button4.setIcon(_oButtonIcon);
 	 					button4.setText(null);
 	 					button4.setIcon(_oButtonIcon);
 	 					break;
 	 		case 4:		//button5.setIcon(_oButtonIcon);
 	 					button5.setText(null);
 	 					button5.setIcon(_oButtonIcon);
 	 					break;
 	 		case 5: 	//button6.setIcon(_oButtonIcon);
 	 					button6.setText(null);
 	 					button6.setIcon(_oButtonIcon);
 	 					break;
 	 		case 6: 	//button7.setIcon(_oButtonIcon);
 	 					button7.setText(null);
 	 					button7.setIcon(_oButtonIcon);
 	 					break;
 	 		case 7: 	//button8.setIcon(_oButtonIcon);
 	 					button8.setText(null);
 	 					button8.setIcon(_oButtonIcon);		
 	 					break;
 	 		case 8: 	//button9.setIcon(_oButtonIcon);
 	 					button9.setText(null);
 	 					button9.setIcon(_oButtonIcon);
 	 					break;
 	 		}
 	 		if(b)
 	 		{
 	 			einzelspieler_player1 = true;
 	 			b = false;
 	 		}
 	 		testGameOver();
 		
 	}
}		
