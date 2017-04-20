import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.*;
import java.util.Enumeration;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.*;


public class pdfSplitter extends JPanel{
	
	private JLabel label, licenseLabel;
	private String text;
	private static String agree ="Agree" ,disagree= "Disagree";
	
	private JButton pdfButton,convertButton;
	private JButton nextButton;
	private JTextArea textArea;
	private ButtonGroup group;
	private JRadioButton acceptButton,rejectButton;
	private JPanel radioButtonPanel;
	public pdfSplitter()
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
	/*	pdfButton = new JButton("PDF Tools");
		convertButton = new JButton("ConvertTools");
		pdfButton.setBounds(100, 100, 80, 30);
		convertButton.setBounds(300, 100, 80, 30);
		pdfButton.setBackground(Color.cyan);
		convertButton.setBackground(Color.cyan);
		pdfButton.setToolTipText("Click to merge or split PDFs");
		convertButton.setToolTipText("Click to Convert PDFS to DOC");
		pdfButton.addActionListener(new ActionListener()
		{
			 public void actionPerformed(ActionEvent ae)
			 {
				 
			 }
		});
		convertButton.addActionListener(new ActionListener()
		{
			 public void actionPerformed(ActionEvent ae)
			 {
				 
			 }
		});*/
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
			            	// call new class object
			            }
			            else
			            {
			            	System.exit(0);
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
		//add(pdfButton);
		//add(convertButton);
		setBorder(BorderFactory.createEmptyBorder());
		
	}
	
	public static void main(String[] args)
	{
		pdfSplitter pdf=new pdfSplitter();
		int status = 0;
		JFrame frame = new JFrame("PDF ToolBox");
		frame.setContentPane(pdf);
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
