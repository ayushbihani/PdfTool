import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.*;
import javax.swing.JFrame;

public class MainClass {
	
	static JFrame frame;
	
	public static void trial()
	{
		System.out.println("hello");
		Home home = new Home();
		frame.setContentPane(home);
		frame.setVisible(true);
	}
	
	public static int file_read() throws IOException
	{
		String line;
		File file = new File("config.txt");
		if(!file.exists())
		{
			file.createNewFile();
		}
		 BufferedReader br = new BufferedReader(new FileReader(file));
		try 
		{
			line = br.readLine();
		} 
		finally
		{
			br.close();
		}
			return Integer.parseInt(line);
	}
	
	
	public static void main(String[] args) throws Exception
	{
		License license =new License();
		int status = 0;
		frame = new JFrame("PDF ToolBox");
		int num = file_read();
		
		if(num ==1)
		{
			System.out.print(num);
			MainClass.trial();
		}
		else{
		frame.setContentPane(license);
		
	}
		frame.setSize(600, 700);
		frame.setVisible(true);
		WindowListener listener = new WindowAdapter()
		{
			public void windowClosing(WindowEvent event)
			{
				System.exit(status);
			}
		};
		frame.addWindowListener(listener);
	
	}
}
