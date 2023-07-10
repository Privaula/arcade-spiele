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
import javax.swing.JTextField;
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
	
	private java.net.URL ticTacToe_o_green 	= 	Main.class.getResource("pictures\\ticTacToe_o_green.png");
	private java.net.URL ticTacToe_o 		=	Main.class.getResource("pictures\\ticTacToe_o.png");
	private java.net.URL ticTacToe_x_green 	= 	Main.class.getResource("pictures\\ticTacToe_x_green.png");
	private java.net.URL ticTacToe_x	 	= 	Main.class.getResource("pictures\\ticTacToe_x.png");
	//Icon icon = new ImageIcon(ticTacToe_o_green);
	//Icon icon2 = new ImageIcon("pictures/ticTacToe_x.png");
	Icon _xButtonIcon;
	Icon _oButtonIcon;
	Icon _xGreenButtonIcon;
	Icon _oGreenButtonIcon;
	Icon _grid;
	
 	public void ticTacToe() 
	{
 		loadImages();
 		
 		//random SpielerTurn
 		//einzelspieler_spielerTurn = rd.nextBoolean();
 		einzelspieler_player1 = true;
 		
		//JFrame erstellen
		JFrame jf = new JFrame();
		jf.setTitle("Arcade Spiele - TicTacToe");
		jf.setSize(1280, 720);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(EXIT_ON_CLOSE);
		jf.setVisible(true);
		
		
		
		//test JLabel
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
				tttReset();
				einzelspieler.setBackground(Color.decode("#1A5276"));
				mehrspieler.setBackground(Color.decode("#1F618D"));
				einzelspielerbool = true;
			}
		});
		mehrspieler.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tttReset();
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
		jf.add(gridPart1);
		jf.add(gridPart2);
		jf.add(gridPart3);
		jf.add(gridPart4);
		jf.add(myLabel);
			
		
	}
 	
 	private void loadImages()
 	{
 		try
 		{
 			var gridRes = getClass().getResource("pictures/ticTacToe_grid.png");
 			var gridImg = ImageIO.read(gridRes);
 			_grid = new ImageIcon(gridImg);
			var xRes = getClass().getResource("pictures/ticTacToe_x.png");
			var oRes = getClass().getResource("pictures/ticTacToe_o.png");
			var xGreenRes = getClass().getResource("pictures/ticTacToe_x_green.png");
			var oGreenRes = getClass().getResource("pictures/ticTacToe_o_green.png");
			var xImg = ImageIO.read(xRes);
			var oImg = ImageIO.read(oRes);
			var xGreenImg = ImageIO.read(xGreenRes);
			var oGreenImg = ImageIO.read(oGreenRes);
			_xButtonIcon = new ImageIcon(xImg);
			_oButtonIcon = new ImageIcon(oImg);
			_xGreenButtonIcon = new ImageIcon(xGreenImg);
			_oGreenButtonIcon = new ImageIcon(oGreenImg);
			
 		}
 		catch (IOException e) {
			// nothing
		}
		
	}

	public void pressedButtonMehrspieler(int i , customButtonttt button)
 	{
 		
 		if(mehrspieler_player1)
 		{
 			button.setText("x");
 			fieldArray[i] = 1;
 			mehrspieler_player1 = false;
 			//button.setIcon(_xButtonIcon);
 		}
 		else if(!mehrspieler_player1)
 		{
 			button.setText("o");
 			fieldArray[i] = 2;
 			mehrspieler_player1 = true;
 			//button.setIcon(_oButtonIcon);
 		}
 		//chooseField();
 		testGameOver();
 	}
 	
 	public void pressedButtonEinzelspieler(int i, customButtonttt button)
 	{
 		if(einzelspieler_player1)
 		{
 			button.setText("x");
 			fieldArray[i] = 1;
 			einzelspieler_player1 = false;
 			//button.setIcon(_xButtonIcon);
 			chooseField();
 			
 		}
 		else if(!einzelspieler_player1)
	 		{
	 			button.setText("o");
	 			fieldArray[i] = 2;
	 			einzelspieler_player1 = true;
	 			//button.setIcon(_oButtonIcon);
	 		}
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
		else if(fieldArray[0] == fieldArray[3] && fieldArray[0] == fieldArray[6] && fieldArray[0] != 0)
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
		else if(fieldArray[1] == fieldArray[4] && fieldArray[1] == fieldArray[7] && fieldArray[1] != 0)
		{
			if(fieldArray[1] == 1)
			{
				System.out.println("Spieler1 gewinnt");
				gameRunning = false;
			}
			else if(fieldArray[1] == 2)
			{
				System.out.println("Spieler2 gewinnt");
				gameRunning = false;
			}
		}
		else if(fieldArray[2] == fieldArray[5] && fieldArray[2] == fieldArray[8] && fieldArray[2] != 0)
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
 		System.out.println("reset ttt");
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
 		mehrspieler_player1 = true;
 		nochmalButton.setVisible(false);
 		gameRunning = true;
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
 			//kann später auch ganz ans ende der methode gesetzt werden
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
 			cantWinOrLoose = true;
 		}
 		
 		
 		
 		
 		
 		//schaut ecken
 		//if(fieldArray[2] == 1 && fieldArray[4] == 1  && fieldArray[6] == 0|| fieldArray[2] == 1 && fieldArray[6] == 1 && fieldArray[4] == 0|| fieldArray[4] == 1 && fieldArray[6] == 1 && fieldArray[2] == 0)
 		
 		
 	}
 	
 	private void pressField(int i, boolean b){
 		
 		switch(i)
 		{
 		case 0: 	//button1.setIcon(_oButtonIcon);
 					button1.setText("o");
 					break;
 		case 1:		//button2.setIcon(_oButtonIcon);
 					button2.setText("o");	
 					break;
 		case 2: 	//button3.setIcon(_oButtonIcon);
 					button3.setText("o");
 					break;
 		case 3: 	//button4.setIcon(_oButtonIcon);
 					button4.setText("o");
 					break;
 		case 4:		//button5.setIcon(_oButtonIcon);
 					button5.setText("o");
 					break;
 		case 5: 	//button6.setIcon(_oButtonIcon);
 					button6.setText("o");
 					break;
 		case 6: 	//button7.setIcon(_oButtonIcon);
 					button7.setText("o");
 					break;
 		case 7: 	//button8.setIcon(_oButtonIcon);
 					button8.setText("o");		
 					break;
 		case 8: 	//button9.setIcon(_oButtonIcon);
 					button9.setText("o");
 					break;
 		}
 		if(b)
 		{
 			einzelspieler_player1 = true;
 		}
 		testGameOver();
 	}
 	
}		
