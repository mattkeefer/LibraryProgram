package main;
import BreezySwing.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import java.util.*;

public class ExtraCreditDialog extends GBDialog {

	JList<String> books = addList(1,1,1,2);
	JPanel output = addPanel(3,1,1,1);
	JButton exit = addButton("Back", 6,1,1,1);
	
	Library lib;
	JTable table = null;
	DefaultTableModel model = null;
	Object[][] data;
	JScrollPane scrollpane;

	private JFrame ec;
	
	public ExtraCreditDialog(JFrame frm, Library l) throws FormatException {
		super(frm);
		lib = l;
		if(lib.getSize()==0) {
			dispose();
			throw new FormatException("There are no books in the library.");
		}
		initializeList();
		String[] columnNames = {"1",
								"2",
								"3"};
		data = new String[lib.getSize()][3];
		output.setLayout(new BorderLayout());
		table = new JTable(data, columnNames);
		model = new DefaultTableModel();
		model.setColumnIdentifiers(columnNames);
		table.setModel(model);
		scrollpane = new JScrollPane(table);
		output.add(scrollpane);
		table.disable();
		scrollpane.setVisible(false);
		frm.getContentPane().revalidate();
		setSize(700, 350);
		setTitle("Extra Credit");
		setVisible(true);
	}
	
	private void initializeList() {
		ArrayList<Book> bookLibrary = lib.getLibrary();
		for(Book b : bookLibrary) {
			if(b.isCheckedOut()) {
				if(b.isFuture()) {
					addToList("<html>"+b.getTitle()+" - <font color='blue'>On Hold</font></html>");
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
		if(b.isCheckedOut()) {
			String[] columnNames = {"Title",
					"Author",
					"Availability",
					"Borrower",
					"Date Loaned",
					"Overdue?"};
			model.setColumnIdentifiers(columnNames);
			model.setRowCount(0);
			String[] row = new String[6];
			row[0] = b.getTitle();
			row[1] = b.getAuthor();
			if(b.isFuture()) {
				row[2] = "<html><font color='blue'>On Hold</font></html>";
			}
			else {
				row[2] = "<html><font color='red'>Loaned Out</font></html>";
			}
			row[3] = b.getBorrower();
			row[4] = b.getDateBorrowed();
			if(b.isOverdue()) {
				row[5] = "<html><font color='red'>Overdue</font</html>";
			}
			else {
				row[5] = "<html><font color='green'>Not Overdue</font</html>";
			}
			model.addRow(row);
		}
		else {
			String[] columnNames = {"Title",
					"Author",
					"Availability"};
			model.setColumnIdentifiers(columnNames);
			model.setRowCount(0);
			String[] row = new String[3];
			row[0] = b.getTitle();
			row[1] = b.getAuthor();
			row[2] = "<html><font color='green'>In Stock</font></html>";
			model.addRow(row);
		}
		table.repaint();
		scrollpane.setVisible(true);
		revalidate();
	}
	
	public void listDoubleClicked(JList<String> li, String selectedObj) {
		Book b = lib.getBook(li.getSelectedIndex());
		int index = li.getSelectedIndex();
		if(b.isCheckedOut()) {
			ReturnBookDialog rbd = new ReturnBookDialog(ec, lib, b, index);
			resetList();
			scrollpane.setVisible(false);
			revalidate();
		}
		else {
			LoanBookDialog lbd = new LoanBookDialog(ec, lib, b, index);
			resetList();
			scrollpane.setVisible(false);
			revalidate();
		}
	}
	
	public void buttonClicked(JButton button) {
		dispose();
	}
}