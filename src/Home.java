import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Home extends JPanel {
	
	private JButton pdfButton, convertButton, mergeButton;
	private JButton nextButton;

	public Home()
	{
		nextButton = new JButton("Next");
		nextButton.setBounds(450, 650, 100, 30);
 
		pdfButton = new JButton("PDF Tools");
		pdfButton.setBounds(100, 100, 120, 30);

		mergeButton = new JButton("Merge");
		mergeButton.setBounds(100, 300, 120, 30);
		
		convertButton = new JButton("DocToPdf");
		convertButton.setBounds(300, 100, 120, 30);

		pdfButton.setBackground(Color.cyan);
		convertButton.setBackground(Color.cyan);
		
		pdfButton.setToolTipText("Click to merge or split PDFs");
		convertButton.setToolTipText("Click to Convert PDFS to DOC");
		
		pdfButton.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				MainClass.callSplit();
				
			}
		});
		convertButton.addActionListener(new ActionListener()
		{
			 public void actionPerformed(ActionEvent ae)
			 {
				 System.out.println("action perf");
				 MainClass.callConvert();
			 }
		});

		mergeButton.addActionListener(new ActionListener()
		{
			 public void actionPerformed(ActionEvent ae)
			 {	
				 System.out.println(" merge action perf");
				 MainClass.callMerge();
				 
			 }
		});
		setLayout(null);
		add(nextButton);
		add(pdfButton);
		add(mergeButton);
		add(convertButton);
	}
}
