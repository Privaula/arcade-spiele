import java.lang.reflect.InvocationTargetException;
import java.rmi.server.RemoteObjectInvocationHandler;
import java.text.SimpleDateFormat;
import java.util.Date;

public class timeThread extends Thread{

	public static SimpleDateFormat date1 = new SimpleDateFormat("HH:mm");
	SimpleDateFormat date2 = new SimpleDateFormat("HH:mm");
	private Main _mainInstanz;
	
	
	
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
			try
			{
				updateUhrzeitLabel();			
				Thread.sleep(500);
			}
			catch (InvocationTargetException | InterruptedException e)
			{
				running = false;
			}
			
		}
		
	}
	
	private void updateUhrzeitLabel() throws InvocationTargetException, InterruptedException
	{
		javax.swing.SwingUtilities.invokeAndWait(new Runnable() {
			
			@Override
			public void run() {
				
				_mainInstanz.updateTimeLabel();
				_mainInstanz.updateDateLabel();
				
			}
		});
	}
}
