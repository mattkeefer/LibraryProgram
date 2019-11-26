package main;
import javax.swing.*;
import BreezySwing.*;

public class ReturnBookDialog extends GBDialog {

	JLabel bookLabel = addLabel("Select book:", 1,1,1,1);
	JComboBox bookSelection = addComboBox(1,2,1,1);
	JButton returnBook = addButton("Return Book", 2,2,1,1);
	JButton exit = addButton("Back", 2,1,1,1);
	
	Library lib;
	
	public ReturnBookDialog(JFrame frm, Library l) {
		super(frm);
		lib = l;
		for(int i=0; i<l.getSize(); i++) {
			if(l.getBook(i).isCheckedOut()) {
				bookSelection.addItem(l.getBook(i).getTitle());
			}
		}
		setSize(400, 200);
		setTitle("Return Books");
		setVisible(true);
	}
	
	public void buttonClicked(JButton button) {
		if(button==returnBook) {
			lib.getBook(lib.findLoanedOutBook(bookSelection.getSelectedIndex())).checkOut(false);
		}
		dispose();
	}
}
