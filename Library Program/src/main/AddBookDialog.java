package main;
import BreezySwing.*;
import javax.swing.*;
public class AddBookDialog extends GBDialog {

	JLabel bookName = addLabel("Title:", 1,1,1,1);
	JTextField bookTitle = addTextField("", 1,2,1,1);
	JLabel authorLabel = addLabel("Author:", 2,1,1,1);
	JTextField authorName = addTextField("", 2,2,1,1);
	JButton addBook = addButton("Add Book", 3,2,1,1);
	
	Library lib;
	
	public AddBookDialog(JFrame frm, Library l) {
		super(frm);
		lib = l;
		setSize(400, 200);
		setTitle("Add Book");
		setVisible(true);
	}
	
	public void buttonClicked(JButton button) {
		if(bookTitle.getText().trim().equals("") || authorName.getText().trim().equals("")) {
			messageBox("BIG BAD");
		}
		else {
			Book b = new Book(bookTitle.getText(), authorName.getText());
			lib.storeBook(b);
			dispose();
		}
	}
}