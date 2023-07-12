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
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class random extends JFrame {
	
	//Variablen
	static int buttonBreite = Main.buttonBreite;
	static int buttonHöhe = Main.buttonHöhe;
    static String munzenWurf;
    static int munze;
	
	public static void random() {
		
		
		//JFrame erstellen
		JFrame jf = new JFrame();
		jf.setTitle("Arcade Spiele - Münzwurf");
		jf.setSize(1280, 720);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(EXIT_ON_CLOSE);
		jf.setVisible(true);
		
		//Schriftarten
				Font schrift = new Font ("Public Pixel", Font.PLAIN , 50);
				Font hilfeLabelschrift = new Font ("Public Pixel", Font.PLAIN , 30);
				
		
		//Zurück Button
		java.net.URL backButtonIconURL = Main.class.getResource("pictures\\backButton.png");
		ImageIcon backButtonIcon = new ImageIcon(backButtonIconURL);
		JButton zurückButton = new JButton(backButtonIcon);
		zurückButton.setBounds(5, 5, buttonBreite, buttonHöhe);
		zurückButton.setBorder(null);
		zurückButton.setContentAreaFilled(false);
		zurückButton.setBackground(new Color(0,0,0,0));
		zurückButton.addActionListener(new ActionListener() {
					@Override
			public void actionPerformed(ActionEvent e) {
					Main.main(null);
					jf.setVisible(false);
					}
		});
		
		
		//Background
		
		java.net.URL backgroundURL = Main.class.getResource("pictures\\background.jpg");
		ImageIcon background = new ImageIcon(backgroundURL);
		JLabel myLabel = new JLabel(background);
		myLabel.setSize(1280, 720);
		
		//ICON
		java.net.URL taskbarIconURL = Main.class.getResource("pictures\\taskbarIcon.png");
		ImageIcon taskbarIcon = new ImageIcon(taskbarIconURL);
		jf.setIconImage(taskbarIcon.getImage());
		

        JTextArea munzenArea = new JTextArea(" Münzwurf");
        munzenArea.setBounds(400, 100, 500, 70);
		munzenArea.setFont(schrift);
		munzenArea.setEditable(false);
		munzenArea.setForeground(Color.BLACK);
		munzenArea.setBackground(Color.YELLOW);

        java.net.URL munzeZahlIconURL = Main.class.getResource("pictures\\munzeZahl.png");
		ImageIcon munzeZahlIcon = new ImageIcon(munzeZahlIconURL);
        java.net.URL munzeKopfIconURL = Main.class.getResource("pictures\\munzeKopf.png");
		ImageIcon munzeKopfIcon = new ImageIcon(munzeKopfIconURL);

        java.net.URL munzeIconURL = Main.class.getResource("pictures\\munze.png");
		ImageIcon munzeIcon = new ImageIcon(munzeIconURL);
        JButton munzenButton = new JButton(munzeIcon);
        munzenButton.setBounds(500, 200, 300, 300);
        munzenButton.setFont(hilfeLabelschrift);
        munzenButton.setForeground(Color.RED);
		munzenButton.setBackground(Color.BLUE);
        munzenButton.addActionListener(new ActionListener() {
            @Override
             public void actionPerformed(ActionEvent e) {
                munzenButton.setText(random.munzenWurf);
            }
});



        //nochmal Button
		java.net.URL retryButtonIconURL = Main.class.getResource("pictures\\retryButton.png");
		ImageIcon retryButtonIcon = new ImageIcon(retryButtonIconURL);
		JButton nochmalButton = new JButton("PRESS");
        nochmalButton.setFont(hilfeLabelschrift);
		nochmalButton.setBounds(230, 300, 190, 80);
		nochmalButton.setContentAreaFilled(true);
		nochmalButton.setBackground(Color.YELLOW);
        nochmalButton.setForeground(Color.BLACK);
		nochmalButton.setVisible(true);
		nochmalButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//Münze
                int munze = (int)(Math.random() * 2);
                System.out.println(munze);
        
                if (munze == 0){
                    munzenButton.setIcon(munzeKopfIcon);
        }
                if (munze == 1){
                    munzenButton.setIcon(munzeZahlIcon);
        }
             

			}
		});

		//add to jf
        jf.add(nochmalButton);
        jf.add(munzenButton);
        jf.add(munzenArea);
		jf.add(zurückButton);
		jf.add(myLabel);
		
		
		
		
		
		
	}
	

}
