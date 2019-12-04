package main;
import javax.swing.*;
import BreezySwing.*;

public class ReturnBookDialog extends GBDialog {

	JLabel bookLabel = addLabel("Select book:", 1,1,1,1);
	JComboBox bookSelection = addComboBox(1,2,1,1);
	JButton returnBook = addButton("Return Book", 2,2,1,1);
	JButton exit = addButton("Back", 2,1,1,1);
	
	Library lib;
	
	public ReturnBookDialog(JFrame frm, Library l) throws FormatException {
		super(frm);
		lib = l;
		if(lib.findLoanedOutBook(0)==-1) {
			dispose();
			throw new FormatException("There are no books loaned out.");
		}
		for(int i=0; i<l.getSize(); i++) {
			if(l.getBook(i).isCheckedOut()) {
				bookSelection.addItem(l.getBook(i).getTitle());
			}
		}
		setSize(400, 150);
		setTitle("Return Books");
		setVisible(true);
	}
	
	public ReturnBookDialog(JFrame ecd, Library l, Book b) {
		super(ecd);
		lib = l;
		bookSelection.addItem(b.getTitle());
		setSize(400, 150);
		setTitle("Return Single Book");
		setVisible(true);
	}
	
	public void buttonClicked(JButton button) {
		if(button==returnBook) {
			lib.getBook(lib.findLoanedOutBook(bookSelection.getSelectedIndex())).checkOut(false);
		}
		dispose();
	}
}
