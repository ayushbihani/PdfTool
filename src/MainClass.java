import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

public class MainClass {
	
	static JFrame frame;
	
	public void trial()
	{
		Home home = new Home();
		//frame.setVisible(false);
		frame.setContentPane(home);
		//frame.setSize(600, 700);
		frame.setVisible(true);
	}

	public static void main(String[] args)
	{
		License license =new License();
		int status = 0;
		frame = new JFrame("PDF ToolBox");
		frame.setContentPane(license);
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
