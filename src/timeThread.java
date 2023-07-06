import java.lang.reflect.InvocationTargetException;
import java.rmi.server.RemoteObjectInvocationHandler;
import java.text.SimpleDateFormat;
import java.util.Date;

public class timeThread extends Thread{

	public static SimpleDateFormat date1 = new SimpleDateFormat("HH:mm");
	SimpleDateFormat date2 = new SimpleDateFormat("HH:mm");
	private Main _mainInstanz;
	
	int s = editFile.sff;
	int m = editFile.mff;
	int h = editFile.hff;
	
	
	
	
	//erstelle neue Thread
	public timeThread(String name, Main main)
	{
		this.setName(name);
		_mainInstanz = main;
	}
	
	public void run()
	{
		
		
		
		
		boolean running = true;
		
		while(running)
		{
			s++;
			if (s == 60) {
				m++;
				s = 0;
			}
			if (m == 60) {
				h++;
				m = 0;
			}
			try
			{
				update();			
				Thread.sleep(1000);
			}
			catch (InvocationTargetException | InterruptedException e)
			{
				running = false;
			}
			
		}
		
	}
	
	private void update() throws InvocationTargetException, InterruptedException
	{
		javax.swing.SwingUtilities.invokeAndWait(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("in run angekommen");
				_mainInstanz.updateTimeLabel();
				_mainInstanz.updateDateLabel();
				_mainInstanz.updatePlaytime(h, m, s);
				editFile.editFile(s, m, h);
				editFile.readFile();
				
			}
		});
		
		
		
	}
}
