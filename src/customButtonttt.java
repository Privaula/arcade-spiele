import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class customButtonttt extends JButton{
	String buttonName;
	customButtonttt buttonnn;
	int i;
	Font font = new Font("Public Pixel", Font.PLAIN , 50);
	
	customButtonttt(int locX, int locY, ticTacToe ttt, String name)
	{
		
		addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
				//mehrspieler
				if(!ttt.einzelspielerbool && ttt.gameRunning == true)
				{
					if(ttt.fieldArray[i] == 0)
					{
						ttt.nochmalButtonVisible();
						ttt.pressedButtonMehrspieler(i, buttonnn);
					}
				}				
				
				//einzelspieler
				if(ttt.einzelspielerbool && ttt.gameRunning == true)
				{
					if(ttt.einzelspieler_player1)
					{
						if(ttt.fieldArray[i] == 0)
						{
							ttt.nochmalButtonVisible();
							ttt.pressedButtonEinzelspieler(i, buttonnn);
						}
					}
					else if(!ttt.einzelspieler_player1)
					{
						if(ttt.fieldArray[i] == 0)
						{
							ttt.nochmalButtonVisible();
							ttt.pressedButtonEinzelspieler(i, buttonnn);
							//ttt.chooseField();
						}
					}
				}
				super.mouseReleased(e);
			}
		});
		
		//Schriftarten
		Font schrift = new Font ("Rockwell", Font.PLAIN , 50);
		
		//buttonEinstellungen
		this.setName(name);
		this.setForeground(Color.CYAN);
		this.setBackground(Color.BLACK);
		this.setSize(150,150);
		this.setLocation(locX,locY);
		setMargin(new Insets(0, 0, 0, 0));
		setContentAreaFilled(false);
		
		this.setFont(schrift);
		this.setFocusable(false);
		this.setBorder(null);

		
		buttonName = this.getName();
		buttonnn = this;
		switch(buttonName)
		{
		case "button1": i = 0;
						break;
		case "button2": i = 1;
						break;
		case "button3": i = 2;
						break;
		case "button4": i = 3;
						break;
		case "button5": i = 4;
						break;
		case "button6": i = 5;
						break;
		case "button7": i = 6;
						break;
		case "button8": i = 7;
						break;
		case "button9": i = 8;
						break;
		}
		
		
//		this.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) 
//			{
//				
//				//mehrspieler
//				if(!ttt.einzelspielerbool && ttt.gameRunning == true)
//				{
//					if(ttt.fieldArray[i] == 0)
//					{
//						ttt.nochmalButtonVisible();
//						ttt.pressedButtonMehrspieler(i, buttonnn);
//					}
//				}				
//				
//				//einzelspieler
//				if(ttt.einzelspielerbool && ttt.gameRunning == true)
//				{
//					if(ttt.einzelspieler_player1)
//					{
//						if(ttt.fieldArray[i] == 0)
//						{
//							ttt.nochmalButtonVisible();
//							ttt.pressedButtonEinzelspieler(i, buttonnn);
//						}
//					}
//					else if(!ttt.einzelspieler_player1)
//					{
//						if(ttt.fieldArray[i] == 0)
//						{
//							ttt.nochmalButtonVisible();
//							ttt.pressedButtonEinzelspieler(i, buttonnn);
//							//ttt.chooseField();
//						}
//					}
//				}
//
//			}
//		});
	}
}
