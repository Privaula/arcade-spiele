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
//		System.out.println("customThread gestarted");
//		
//		do 
//		{
//			boolean b = false;
//			do
//			{		
//				try {
//					Thread.sleep(500);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}		
			/*if(date2.format(new Date()).toString() != date1.format(new Date()).toString())
			{
				System.out.println(date1.format(new Date()));
				System.out.println(date2.format(new Date()));
				date1 = new SimpleDateFormat("HH:mm");
				//System.out.println(date1.format(new Date()));
				//main.
			}	
//			*/			
//			}while(b = false);
//			
//			
//			
//			
//		}
//		while(Main.timerRunning);
		
		String a = "h" + "allo";
		String b = "hallo";
		
		a.equals(b);
		
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
				
			}
		});
	}
}
