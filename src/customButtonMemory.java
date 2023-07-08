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

public class customButtonMemory extends JButton{

	public customButtonMemory(int locX, int locY, memory m, String name)
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
    }
}

