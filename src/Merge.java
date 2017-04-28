import javax.swing.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;


import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.*;
import java.io.FileInputStream;


public class Merge extends JPanel {

	JLabel label1, label2;
	final JTextField fileTextField1, fileTextField2;
	JButton browseButton1, browseButton2, mergeButton;
	
public Merge()
{
	//JFrame f1=new JFrame();
	label1 = new JLabel("Enter first pdf:");
	label1.setBounds(100, 200, 150, 40);
	fileTextField1 = new JTextField(10);
	fileTextField1.setBounds(300, 200, 150, 40);
	browseButton1 = new JButton("Browse!");
	browseButton1.setBounds(320, 250, 100, 15);
	
	label2 = new JLabel("Enter second pdf:");
	label2.setBounds(100, 300, 150, 40);
	fileTextField2 = new JTextField(10);
	fileTextField2.setBounds(300, 300, 150, 40);
	browseButton2 = new JButton("Browse!");
	browseButton2.setBounds(320, 350, 100, 15);
	
	//JPanel pnl = new JPanel();
	add(label1);
	add(fileTextField1);
	add(browseButton1);
	add(label2);
	add(fileTextField2);
	add(browseButton2);
	
	//cont.add(pnl);
	
	mergeButton = new JButton("Merge!");
	mergeButton.setBounds(220,450,100,40);
	add(mergeButton);
	
	setLayout(new BorderLayout());
	
	mergeButton.addActionListener(new ActionListener(){
	
	public void actionPerformed(ActionEvent ae)
	
	{
	
	String pd1= fileTextField1.getText();
	
	String pd2= fileTextField2.getText();
	
	try {
	
	List<InputStream> pdfs = new ArrayList<InputStream>();
	
	pdfs.add(new FileInputStream(pd1));
	
	pdfs.add(new FileInputStream(pd2));
	
	OutputStream output = new FileOutputStream("/home/amisha/Documents/cd.pdf");
	
	Merge.concatPDFs(pdfs, output, true);
	
	} catch (Exception e) {
	
	e.printStackTrace();
	
	}
	
	} });
	
	
	
	browseButton1.addActionListener(new ActionListener(){
	
	public void actionPerformed(ActionEvent ae)
	
	{
	
	JFileChooser fileChooser = new JFileChooser();
	
	fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
	
	fileChooser.setAcceptAllFileFilterUsed(false);
	
	int rVal = fileChooser.showOpenDialog(null);
	
	if (rVal == JFileChooser.APPROVE_OPTION) {
	
	fileTextField1.setText(fileChooser.getSelectedFile().toString());
	
	}
	
	} });
	
	
	browseButton2.addActionListener(new ActionListener(){
	
	public void actionPerformed(ActionEvent ae)
	
	{
	
	JFileChooser fileChooser = new JFileChooser();
	
	fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
	
	fileChooser.setAcceptAllFileFilterUsed(false);
	
	int rVal = fileChooser.showOpenDialog(null);
	
	if (rVal == JFileChooser.APPROVE_OPTION) {
	
	fileTextField2.setText(fileChooser.getSelectedFile().toString());
	
	}
	
	} });}
	
	
	protected static void concatPDFs(List<InputStream> streamOfPDFFiles,
	
	OutputStream outputStream, boolean paginate) {
	
	Document document = new Document();
	
	try {
	
	List<InputStream> pdfs = streamOfPDFFiles;
	
	List<PdfReader> readers = new ArrayList<PdfReader>();
	
	int totalPages = 0;
	
	Iterator<InputStream> iteratorPDFs = pdfs.iterator();
	
	// Create Readers for the pdfs.
	
	while (iteratorPDFs.hasNext()) {
	
	InputStream pdf = iteratorPDFs.next();
	
	PdfReader pdfReader = new PdfReader(pdf);
	
	readers.add(pdfReader);
	
	totalPages += pdfReader.getNumberOfPages();
	
	}
	
	// Create a writer for the outputstream
	
	PdfWriter writer = PdfWriter.getInstance(document, outputStream);
	
	document.open();
	
	BaseFont bf = BaseFont.createFont(BaseFont.HELVETICA,
	
	BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
	
	PdfContentByte cb = writer.getDirectContent(); // Holds the PDF
	
	// data
	
	PdfImportedPage page;
	
	int currentPageNumber = 0;
	
	int pageOfCurrentReaderPDF = 0;
	
	Iterator<PdfReader> iteratorPDFReader = readers.iterator();
	
	// Loop through the PDF files and add to the output.
	
	while (iteratorPDFReader.hasNext()) {
	
	PdfReader pdfReader = iteratorPDFReader.next();
	
	// Create a new page in the target for each source page.
	
	while (pageOfCurrentReaderPDF < pdfReader.getNumberOfPages()) {
	
	document.newPage();
	
	pageOfCurrentReaderPDF++;
	
	currentPageNumber++;
	
	page = writer.getImportedPage(pdfReader,
	
	pageOfCurrentReaderPDF);
	
	cb.addTemplate(page, 0, 0);
	
	// Code for pagination.
	
	if (paginate) {
	
	cb.beginText();
	
	cb.setFontAndSize(bf, 9);
	
	cb.showTextAligned(PdfContentByte.ALIGN_CENTER, ""
	
	+ currentPageNumber + " of " + totalPages, 520,
	
	5, 0);
	
	cb.endText();
	
	}
	
	}
	
	pageOfCurrentReaderPDF = 0;
	
	}
	
	outputStream.flush();
	
	document.close();
	
	outputStream.close();
	
	} catch (Exception e) {
	
	e.printStackTrace();
	
	} finally {
	
	if (document.isOpen())
	
	document.close();
	
	}
	
	}
	//public static void main(String args[])
	//
	//{
	//Merge d=new Merge();
	//}

}

