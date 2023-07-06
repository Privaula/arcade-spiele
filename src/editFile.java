import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;



public class editFile {
	static int sff;
	static int mff;
	static int hff;
	public static void createFile()
	{
		
		String str = System.getenv("APPDATA");
		File gamedata = new File(str + "/arcade-spiele/gamedata");
		System.out.println(str);
		if(!gamedata.exists())
		{
			gamedata.mkdirs();
			File playTime = new File(str + "/arcade-spiele/gamedata/playtime.txt");
			try {
				playTime.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("fortnite2");
		}
	}
	public static void editFile(int s, int m, int h)
	{
		String str = System.getenv("APPDATA");
		FileWriter myWriter;
		try {
			myWriter = new FileWriter(str + "/arcade-spiele/gamedata/playtime.txt");
			myWriter.write(s + "\n" + m + "\n" + h);
			
			
//			System.out.println("File: " + str + "/arcade-spiele/gamedata/playtime.txt");
//			System.out.println(myWriter);
//			myWriter.write("Files in Java might be tricky, but it is fun enough!4");
		    myWriter.close();
		} catch (IOException e) {
			System.out.println("An Error is occurred while trying to edit the file");
		}
	}
	public static void readFile()
	{
		String str = System.getenv("APPDATA");
		File gamedata = new File(str + "/arcade-spiele/gamedata/playtime.txt");
		//System.out.println(str);
		try {
			Scanner scanner = new Scanner(gamedata);
			String string = "42";
			int inte = Integer.parseInt(string);
		
			String sStr = scanner.nextLine();
			
			Integer inte2 = Integer.parseInt(str);
//			System.out.println(inte2);
			
//			sff = Integer.parseInt(sStr);
//			String mStr = scanner.nextLine();
//			mff = Integer.parseInt(mStr);
//			String hStr = scanner.nextLine();
//			hff = Integer.parseInt(hStr);
//			System.out.println("werte gespeichert");
//			System.out.println(sStr);
//			System.out.println(mStr);
//			System.out.println(hStr);
			scanner.close();
		} catch (FileNotFoundException e) {
			System.out.println("konnte nicht ausgelesen werden");
		}
	}
	
}

