import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
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


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class customButtonttt extends JButton{
	String buttonName;
	customButtonttt buttonnn;
	int i;

	public customButtonttt(int locX, int locY, ticTacToe ttt, String name)
	{
		//Schriftarten
		Font schrift = new Font ("Rockwell", Font.PLAIN , 50);
		Font eingabeSchrift = new Font("Rockwell", Font.BOLD, 120);
		
		//buttonEinstellungen
		this.setName(name);
		this.setText(" ");
		this.setForeground(Color.CYAN);
		this.setBackground(Color.BLACK);
		this.setOpaque(true);
		this.setSize(150,150);
		this.setLocation(locX,locY);
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
		
		
		this.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				
				if(ttt.fieldArray[i] == 0)
				{
					if(ttt.einzelspielerbool)
					{
					}
					else if(ttt.einzelspielerbool == false)
					{
						ttt.gameRunning = true;
						if(ttt.player1)
						{
							ttt.pressedButton(i, buttonnn);
						}
						else if(!ttt.player1)
						{
							ttt.pressedButton(i, buttonnn);
						}
					}
				}				
				
				
			}
		});
	}
	
	}
}
