package main;
import BreezySwing.*;
import javax.swing.*;
public class AddBookDialog extends GBDialog {

	JLabel bookName = addLabel("Title:", 1,1,1,1);
	JTextField bookTitle = addTextField("", 1,2,1,1);
	JLabel authorLabel = addLabel("Author:", 2,1,1,1);
	JTextField authorName = addTextField("", 2,2,1,1);
	JButton addBook = addButton("Add Book", 3,2,1,1);
	JButton exit = addButton("Back", 3,1,1,1);
	
	Library lib;
	
	public AddBookDialog(JFrame frm, Library l) {
		super(frm);
		lib = l;
		setSize(400, 200);
		setTitle("Add Book");
		setVisible(true);
	}
	
	public void buttonClicked(JButton button){
		if(button==addBook) {	
			try {
				if(bookTitle.getText().trim().equals("") || authorName.getText().trim().equals("")) {
					throw new FormatException("Cannot be blank.");
				}
				else {
					Book b = new Book(bookTitle.getText(), authorName.getText());
					lib.storeBook(b);
					dispose();
				}
			}
			catch(FormatException e) {
				messageBox(e.getMessage());
			}
		}
		else {
			dispose();
		}
	}
}