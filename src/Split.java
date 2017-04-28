import javax.swing.*;
import java.io.*;
import java.util.*;
import java.util.List;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.*;
import java.io.FileInputStream;

public class Split extends JPanel{
	
	JLabel background, label1, label2, label3;
	JTextField pdfTextField, startPageTextField, lastPageTextField;
	JButton splitButton, browseButton;
	public Split()
	{
		
	background=new JLabel(new ImageIcon("/home/6a/Downloads/11.jpg"));
	label1 = new JLabel("Enter pdf:");
	label1.setBounds(100,100,150,40);
	pdfTextField = new JTextField(10);
	pdfTextField.setBounds(220, 105, 150, 30);
	label2 = new JLabel("Enter start page: ");
	label2.setBounds(100, 200, 200, 40);
	startPageTextField = new JTextField(3);
	startPageTextField.setBounds(250,200,50,30);
	label3 = new JLabel("Enter final page: ");
	label3.setBounds(100,300,200,40);
	lastPageTextField = new JTextField(3);
	lastPageTextField.setBounds(250, 300, 50, 30);
	splitButton = new JButton("Click to split!");
//	Container cont = f1.getContentPane();
//	cont.setLayout(new FlowLayout());
	browseButton = new JButton("Browse!");
	browseButton.setBounds(250, 400, 100, 30);
//	JPanel pnl = new JPanel();
	add(background);
	add(label1);
	add(pdfTextField);
	add(browseButton);
	add(label2);
	add(startPageTextField);
	add(label3);
	add(lastPageTextField);
	add(splitButton);
//	cont.add(pnl);
	setLayout(new BorderLayout());
//	f1.setVisible(true);
//	f1.setSize(300, 450);
	browseButton.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent ae)
	{
	JFileChooser fileChooser = new JFileChooser();
	fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
	fileChooser.setAcceptAllFileFilterUsed(false);
	int rVal = fileChooser.showOpenDialog(null);
	if (rVal == JFileChooser.APPROVE_OPTION) {
	startPageTextField.setText(fileChooser.getSelectedFile().toString());
	}
	} 
	});
	splitButton.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent ae)
	{
	String pd1= pdfTextField.getText();
	int p1= Integer.parseInt(startPageTextField.getText());
	int p2= Integer.parseInt(lastPageTextField.getText());
	InputStream inputStream = null;
	try {
	inputStream = new FileInputStream(pd1);
	} catch (FileNotFoundException e) {
	e.printStackTrace();
	}
	OutputStream output = null;
	try {
	output = new FileOutputStream("/home/amisha/test.pdf");
	} catch (FileNotFoundException e) {
	e.printStackTrace();
	}
	Split.splitPDF(inputStream,output,p1,p2);
	}});
	}
	public static void splitPDF(InputStream inputStream,
	OutputStream outputStream, int fromPage, int toPage) {
	Document document = new Document();
	try {
	PdfReader inputPDF = new PdfReader(inputStream);
	int totalPages = inputPDF.getNumberOfPages();
	if(fromPage > toPage ) {
	fromPage = toPage;
	}
	if(toPage > totalPages) {
	toPage = totalPages;
	}
	PdfWriter writer = PdfWriter.getInstance(document, outputStream);
	document.open();
	PdfContentByte cb = writer.getDirectContent(); // Holds the PDF data
	PdfImportedPage page;
	while(fromPage <= toPage) {
	document.newPage();
	page = writer.getImportedPage(inputPDF, fromPage);
	cb.addTemplate(page, 0, 0);
	fromPage++;
	}
	outputStream.flush();
	document.close();
	outputStream.close();
	} catch (Exception e) {
	e.printStackTrace();
	}
	}
//	public static void main(String[] args) {
//split2 d=new split2();
//}
}