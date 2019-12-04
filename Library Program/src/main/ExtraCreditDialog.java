package main;
import BreezySwing.*;
import javax.swing.*;
import java.util.*;

public class ExtraCreditDialog extends GBDialog {

	JList<String> books = addList(1,1,1,2);
	JTextArea bookInfo = addTextArea("", 3,1,1,3);
	JButton exit = addButton("Back", 6,1,1,1);
	
	Library lib;
	private JFrame ec;
	
	public ExtraCreditDialog(JFrame frm, Library l) throws FormatException {
		super(frm);
		lib = l;
		if(lib.getSize()==0) {
			dispose();
			throw new FormatException("There are no books in the library.");
		}
		initializeList();
		setSize(500, 500);
		setTitle("Extra Credit");
		setVisible(true);
	}
	
	private void initializeList() {
		
		ArrayList<Book> bookLibrary = lib.getLibrary();
		for(Book b : bookLibrary) {
			if(b.isCheckedOut()) {
				if(b.isOverdue()) {
					addToList("<html>"+b.getTitle()+" - <font color='red'>Checked Out</font>, <font color='red'>Overdue</html>");
				}
				else {
					addToList("<html>"+b.getTitle()+" - <font color='red'>Checked Out</font></html>");
				}
			}
			else {
				addToList("<html>"+b.getTitle()+" - <font color='green'>Available</font></html>");
			}
		}
	}
	
	private void addToList(String str) {
		DefaultListModel<String> model = (DefaultListModel<String>)books.getModel();
		model.addElement(str);
	}
	
	private void resetList() {
		DefaultListModel<String> model = (DefaultListModel<String>)books.getModel();
		model.removeAllElements();
		initializeList();
	}
	
	public void listItemSelected(JList<String> li) {
		Book b = lib.getBook(li.getSelectedIndex());
		showBookInfo(b);
	}
	
	private void showBookInfo(Book b) {
		if(b.isCheckedOut() && b.isOverdue()) {
			bookInfo.setText("<html>Title: "+b.getTitle()+"\nAuthor: "+b.getAuthor()+"\n<font color='red'>Checked Out</font>\nBorrower: "+b.getBorrower()+"\nDate Loaned: "+b.getDateBorrowed()+"\n<font color='red'>Overdue</font></html>");
		}
		else if(b.isCheckedOut()) {
			bookInfo.setText("<html>Title: "+b.getTitle()+"\nAuthor: "+b.getAuthor()+"\n<font color='red'>Checked Out</font>\nBorrower: "+b.getBorrower()+"\nDate Loaned: "+b.getDateBorrowed()+"\n<font color='green'>Not Overdue</font></html>");
		}
		else {
			bookInfo.setText("<html>Title: "+b.getTitle()+"\nAuthor: "+b.getAuthor()+"\n<font color='green'>In Stock</font></html>");
		}
	}
	
	public void listDoubleClicked(JList<String> li, String selectedObj) {
		Book b = lib.getBook(li.getSelectedIndex());
		if(b.isCheckedOut()) {
			ReturnBookDialog rbd = new ReturnBookDialog(ec, lib, b);
			resetList();
			showBookInfo(b);
		}
		else {
			LoanBookDialog lbd = new LoanBookDialog(ec, lib, b);
			resetList();
			showBookInfo(b);
		}
	}
	
	public void buttonClicked(JButton button) {
		dispose();
	}
}