 import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.io.*;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Enumeration;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.*;


public class License extends JPanel{
	
	private JLabel label, licenseLabel;
	private String text;
	private static String agree ="Agree" ,disagree= "Disagree";
	private JButton nextButton;
	private JTextArea textArea;
	private ButtonGroup group;
	private JRadioButton acceptButton,rejectButton;
	private JPanel radioButtonPanel;

	public License() throws IOException
	{
		
			text="This comprehensive 21-hour online course was specifically \n designed to teach you Python by building 10 \n real world applications step by step. Learn \n how to use Python for the web, databases \n , web scraping, data science, web visualizations, image processing \n & more.If you want to make learning Python fun \n nd enjoyable this is the ultimate course for you. Traditional \n  programming boot camps can cost $700 or more \n , but since Udemy courses are online and on-demand, you’ll \n get the same world-class instruction for only $29! Plus, \n you’ll get lifetime access to your content, can  \n learn at your own pace on any device, and you’re protected \n by a 100% money-back guarantee.";
			acceptButton = new JRadioButton(agree, true);
			rejectButton = new JRadioButton(disagree);
			licenseLabel = new JLabel("I accept the terms and agreement.");
			licenseLabel.setBounds(50, 550, 300, 15);
			nextButton = new JButton("Next");
			nextButton.setBounds(450, 650, 100, 30);
			textArea = new JTextArea();
			textArea.setFont(new Font("Serif", Font.ITALIC, 16));
			textArea.setBounds(20,20,500,500);
			textArea.setText(text);
			textArea.setEditable(false);
			JScrollPane scroll = new JScrollPane(textArea);
			scroll.setBounds(50,50,500, 500);
			group = new ButtonGroup();
			group.add(acceptButton);
			group.add(rejectButton);
			radioButtonPanel = new JPanel();
			radioButtonPanel.setLayout(new GridLayout(0,1));
			radioButtonPanel.add(acceptButton);
			radioButtonPanel.add(rejectButton);
			radioButtonPanel.setBounds(50,580,200,100);
			label = new JLabel("Welcome to PDF and Doc Tool \n");
			//label.setIcon(icon);
			label.setBounds(140, 10, 300, 20);
			label.setFont(new Font("Courier New", Font.ITALIC, 18));
			label.setForeground(Color.BLACK);
			nextButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent event)
				{
					if(event.getSource()==nextButton)  
					{  
						Enumeration<AbstractButton> allRadioButton=group.getElements();  
						while(allRadioButton.hasMoreElements())  
						{  
						JRadioButton temp=(JRadioButton)allRadioButton.nextElement();  
						if(temp.isSelected())  
						{  
							if(temp.getText().equals(agree))
							{
								try{
											file_write("1");
										}
										catch(Exception e){}	
								MainClass.trial();
								// call new class object
							}
							else
							{
								JOptionPane.showMessageDialog(MainClass.frame,
										"Accept the license to proceed",
										"License Agreement",
										JOptionPane.ERROR_MESSAGE);
										try{
											file_write("0");
										}
										catch(Exception e){}
	//			            	System.exit(0);
							}
						}  
						}            
					}

				}
			});
			setLayout(null);
			add(label);
			add(scroll);
			add(licenseLabel);
			add(radioButtonPanel);
			add(nextButton);
			setBorder(BorderFactory.createEmptyBorder());
	}	

	public static void file_write(String num) throws IOException
	{
		File file = new File("config.txt");
		if(!file.exists())
		{
			file.createNewFile();
		}
		 PrintWriter out = new PrintWriter(file);
		try 
		{
			out.write(num);
		} 
		finally
		{
			out.close();	
		}
	}
	
}
