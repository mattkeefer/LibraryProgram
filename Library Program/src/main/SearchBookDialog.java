package main;
import BreezySwing.*;
import java.awt.BorderLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class SearchBookDialog extends GBDialog {
	
	JLabel keywordLabel = addLabel("Enter keyword:", 1,1,1,1);
	JTextField input = addTextField("", 1,2,2,1);
	JPanel output = addPanel(2,1,3,1);
	JButton search = addButton("Search", 3,2,2,1);
	JButton exit = addButton("Back", 3,1,1,1);
	
	JTable table = null;
	DefaultTableModel model = null;
	Object[][] data;
	Library lib;

	public SearchBookDialog(JFrame frm, Library l) throws FormatException {
		super(frm);
		lib = l;
		if(lib.getSize()==0) {
			dispose();
			throw new FormatException("There are no books in the library.");
		}
		String[] columnNames = {"hi","bye"};
		data = new String[lib.getSize()][3];
		output.setLayout(new BorderLayout());
		table = new JTable(data, columnNames);
		model = new DefaultTableModel();
		model.setColumnCount(0);
		model.setRowCount(0);
		table.setModel(model);
		JScrollPane scrollpane = new JScrollPane(table);
		output.add(scrollpane);
		table.disable();
		
		setSize(750, 400);
		setTitle("Search Book");
		setVisible(true);
	}
	
	public void displayBooks(ArrayList<Book> books) {
		String[] columnNames = {"Title",
	            "Author",
	            "Availability",
	            "Borrower",
	            "Date Loaned",
	            "Overdue?"};
		model.setColumnIdentifiers(columnNames);
		model.setRowCount(0);
		String[] row = new String[6];
		for(Book b : books) {
			row[0] = b.getTitle();
			row[1] = b.getAuthor();
			if(b.isCheckedOut()) {
				if(b.isFuture()) {
					row[2] = "<html><font color='blue'>On Hold</font></html>";
				}
				else {
					row[2] = "<html><font color='red'>Loaned Out</font></html>";
				}
				row[3] = b.getBorrower();
				row[4] = b.getDateBorrowed();
				if(b.isOverdue()) {
					row[5] = "<html><font color='red'>Overdue</font></html>";
				}
				else {
					row[5] = "<html><font color='green'>Not Overdue</font></html>";
				}
			}
			else {
				row[2] = "<html><font color='green'>In Stock</font></html>";
				row[3] = "";
				row[4] = "";
				row[5] = "";
			}
			model.addRow(row);
		}
	}
	
	public void buttonClicked(JButton button) {
		if(button==exit) {
			dispose();
		}
		if(button==search) {
			try {
				model.setRowCount(0);
				displayBooks(lib.findBookFromTitle(input.getText()));
			}
			catch(FormatException e) {
				messageBox(e.getMessage());
			}
		}
	}
}