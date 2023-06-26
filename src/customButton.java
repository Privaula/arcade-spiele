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

public class customButton extends JButton{

	public customButton(String name,int locX, int locY)
	{
		//Schriftarten
		Font schrift = new Font ("Rockwell", Font.PLAIN , 50);
		Font eingabeSchrift = new Font("Rockwell", Font.BOLD, 120);
		
		this.setText(" ");
		this.setForeground(Color.CYAN);
		this.setBackground(Color.BLACK);
		this.setOpaque(true);
		this.setSize(130,130);
		this.setLocation(locX,locY);
		this.setFont(schrift);
		
	}
}
