import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.util.ArrayList;




			public  class memory extends JFrame {
			static ArrayList<Integer> RandomButtonArrayList = new ArrayList<>();// ArrayListe für die zufällige Reihenfolge
			static ArrayList<Integer> EingabeButtonArrayList =new ArrayList<>();//ArrayListe für die Eingabe
			static boolean wahr = false;
			public static void ButtonZahl()	{
				
				
				//Überprüfen der beiden Inhalte der zwei Arrays
				
				int zahl = (int)((Math.random()) * 6 + 1);
				int i = 0;
				memory.RandomButtonArrayList.add(zahl);
				System.out.println(RandomButtonArrayList.get(i));
				i++;
			}
		 Icon gelbButtonIcon;
		 Icon dBlauButtonIcon;
		 Icon pinkButtonIcon;
		 Icon grünButtonIcon;
		 Icon rotButtonIcon;
		 Icon lBlauButtonIcon;
		 

		public void memory() {
			
			// icons
			//loadImages();
			//JFrame erstellen
			JFrame jf = new JFrame();
			jf.setTitle("Arcade Spiele - Memory");
			jf.setSize(1280, 720);
			jf.setLocationRelativeTo(null);
			jf.setVisible(true);
			System.out.println("ja von memory");
		
			memory.ButtonZahl();

			//Zurück Button
			JButton zurückButton = new JButton("Zurück");
			zurückButton.setBounds(20, 20, Main.buttonBreite, Main.buttonHöhe);
			zurückButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					Main.main(null);
					jf.setVisible(false);
				}
			});
			
			//ICON
			java.net.URL taskbarIconURL = Main.class.getResource("pictures\\taskbarIcon.png");
			ImageIcon taskbarIcon = new ImageIcon(taskbarIconURL);
			jf.setIconImage(taskbarIcon.getImage());
			
			
			new GroupLayout(jf);
			jf.setLayout(null);
			ArrayList<Integer> EingabeButtonArrayList = new ArrayList<>();// ArrayListe für Überprüfen der Eingabe des Spiels
			// Buttons für Gameplay und Icons

			customButtonMemory customButtonMemory1 = new customButtonMemory(390, 20, this,  "customButtonMemory1"); 
			customButtonMemory customButtonMemory2 = new customButtonMemory(690, 20, this,  "customButtonMemory2");
			customButtonMemory customButtonMemory3 = new customButtonMemory(910, 220, this, "customButtonMemory3");
			customButtonMemory customButtonMemory4 = new customButtonMemory(690, 435, this, "customButtonMemory4");
			customButtonMemory customButtonMemory5 = new customButtonMemory(390, 435, this, "customButtonMemory5");
		    customButtonMemory customButtonMemory6 = new customButtonMemory(205, 220, this, "customButtonMemory6");
		    
		    
		    //Icons für die Buttons
		    customButtonMemory1.setIcon(gelbButtonIcon);
		    customButtonMemory2.setIcon(lBlauButtonIcon);
		    customButtonMemory3.setIcon(rotButtonIcon);
		    customButtonMemory4.setIcon(grünButtonIcon);
		    customButtonMemory5.setIcon(pinkButtonIcon);
		    customButtonMemory6.setIcon(dBlauButtonIcon);
			//java.net.URL customButton1IconURL = getClass().getResource("pictures\\GelbMemory.png");
			//ImageIcon GelbIcon = new ImageIcon(customButton1IconURL);

			//java.net.URL GelbLeuchtIconURL = getClass().getResource("pictures\\GelbMemoryLeucht.png");
			//ImageIcon GelbLeuchtIcon = new ImageIcon(GelbLeuchtIconURL);
			//JButton memoryButton = new JButton(GelbIcon);
			//memoryButton.setRolloverIcon(GelbLeuchtIcon);
			
			
		    
		    
			//add to jf
			jf.add(zurückButton);
			jf.add(customButtonMemory1);
			jf.add(customButtonMemory2);
			jf.add(customButtonMemory3);
			jf.add(customButtonMemory4);
			jf.add(customButtonMemory5);
			jf.add(customButtonMemory6);

			// Erhöhung der Anzahl an Widerholungen		
			int x = 1;		
			if(wahr) {
			for(int i = 0;i<x;i++) 
			{
				ButtonZahl();	
				System.out.println(memory.RandomButtonArrayList);
				System.out.println(memory.EingabeButtonArrayList);
			}
			x++;
			ButtonZahl();
			System.out.println(memory.RandomButtonArrayList);
			System.out.println(memory.EingabeButtonArrayList);
			}
			else
			{
				x=1;
				ButtonZahl();
				System.out.println(memory.RandomButtonArrayList);
				System.out.println(memory.EingabeButtonArrayList); 
			}
			
			//ArrayList<Integer> RandomButtonArrayList = new ArrayList<>();// ArrayListe für die zufällige Reihenfolge
			customButtonMemory1.addActionListener( new ActionListener() 
		    {
		    	@Override 
		    	public void actionPerformed( ActionEvent e )
		    	{
		    	System.out.println(1);
		    	int b1 = 1;
		    	EingabeButtonArrayList.add(b1);
		    	System.out.println(" Arrays sind gleich ? " + RandomButtonArrayList.equals(EingabeButtonArrayList));
		    	memory.wahr = true;
		    	}
		    });
		    customButtonMemory2.addActionListener( new ActionListener() 
		    {
		    	@Override 
		    	public void actionPerformed( ActionEvent e )
		    	{
		    		System.out.println(2);
		    		int b2 = 2;
		    		EingabeButtonArrayList.add(b2);
		    		System.out.println(" Arrays sind gleich ? " + RandomButtonArrayList.equals(EingabeButtonArrayList));
		    		memory.wahr = true;
		    	}
		    });
		    customButtonMemory3.addActionListener( new ActionListener() 
		    {
		    	@Override 
		    	public void actionPerformed( ActionEvent e )
		    	{
		    		System.out.println(3);
		    		int b3 = 3;
		    		EingabeButtonArrayList.add(b3);
		    		System.out.println(" Arrays sind gleich ? " + RandomButtonArrayList.equals(EingabeButtonArrayList));
		    		memory.wahr = true;
		    	}
		    });
		    customButtonMemory4.addActionListener( new ActionListener() 
		    {
		    	@Override 
		    	public void actionPerformed( ActionEvent e )
		    	{
		    		System.out.println(4);
		    		int b4 = 4;
		    		EingabeButtonArrayList.add(b4);
		    		System.out.println(" Arrays sind gleich ? " + RandomButtonArrayList.equals(EingabeButtonArrayList));
		    		memory.wahr = true;
		    	}
		    });
		    customButtonMemory5.addActionListener( new ActionListener() 
		    {
		    	@Override 
		    	public void actionPerformed( ActionEvent e )
		    	{
		    		System.out.println(5);
		    		int b5 = 5;
		    		EingabeButtonArrayList.add(b5);
		    		System.out.println(" Arrays sind gleich ? " + RandomButtonArrayList.equals(EingabeButtonArrayList));
		    		memory.wahr = true;
		    		
		    	}
		    });
		    customButtonMemory6.addActionListener( new ActionListener() 
		    {
		    	@Override 
		    	public void actionPerformed( ActionEvent e )
		    	{
		    		System.out.println(6);
		    		int b6 = 6;
		    		EingabeButtonArrayList.add(b6);
		    		System.out.println(" Arrays sind gleich ? " + RandomButtonArrayList.equals(EingabeButtonArrayList));
		    		memory.wahr = true;
		    	}
		    	
		    });
		}

	//	private void loadImages() {
		//	try {
		//	var gelbRes = getClass().getResource("pictures/GelbMemory.png");
		//var gelbImg = ImageIO.read(gelbRes);
		//	gelbButtonIcon = new ImageIcon(gelbImg);
		//	}
		//catch (IOException e)
		//	{
		//		//nix
		//	}
		//	private void loadImages() {
		//		try {
		//		var dBlauRes = getClass().getResource("pictures/DBlauMemory.png");
		//		var dBlauImg = ImageIO.read(dBlauRes);
		//		dBlauButtonIcon = new ImageIcon(dBlauImg);
		//		}
		//		catch (IOException e)
		//		{
		//			//nix
		//		}
		//		private void loadImages() {
		//			try {
		//			var lBlauRes = getClass().getResource("pictures/LBlauMemory.png");
		//			var lBlauImg = ImageIO.read(lBlauRes);
		//			lBlauButtonIcon = new ImageIcon(lBlauImg);
		//			}
		//			catch (IOException e)
		//			{
		//				//nix
		//			}
		//			private void loadImages() {
		//				try {
		//				var pinkRes = getClass().getResource("pictures/PinkMemory.png");
		//				var pinkImg = ImageIO.read(pinkRes);
		//				pinkButtonIcon = new ImageIcon(pinkImg);
		//				}
		//				catch (IOException e)
		//				{
		//					//nix
		//				}
		//				private void loadImages() {
		//					try {
		//					var grünRes = getClass().getResource("pictures/GrünMemory.png");
		//					var grünImg = ImageIO.read(grünRes);
		//					grünButtonIcon = new ImageIcon(grünImg);
		//					}
		//					catch (IOException e)
		//					{
		//						//nix
		//					}
		//					private void loadImages() {
		//						try {
		//						var rotRes = getClass().getResource("pictures/RotMemory.png");
		//						var rotImg = ImageIO.read(rotRes);
		//						rotButtonIcon = new ImageIcon(rotImg);
		//						}
		//						catch (IOException e)
		//						{
		//							//nix
		//						}
		//}	
			}
