package main;
import BreezySwing.*;
import java.awt.BorderLayout;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ViewBookDialog extends GBDialog {

	JPanel output = addPanel(1,1,4,1);
	JButton all = addButton("View All", 4,1,1,1);
	JButton available = addButton("View Available", 4,2,1,1);
	JButton borrowed = addButton("View Borrowed", 4,3,1,1);
	JButton overdue = addButton("View Overdue", 4,4,1,1);
	JButton exit = addButton("Back", 5,1,4,1);
	
	JTable table = null;
	DefaultTableModel model = null;
	Object[][] data;
	Library lib;
	
	public ViewBookDialog(JFrame frm, Library l) throws FormatException {
		super(frm);
		lib = l;
		if(lib.getSize()==0) {
			dispose();
			throw new FormatException("There are no books in the library.");
		}
		String[] columnNames = {"Title",
	            "Author",
	            "Availability"};
		data = new String[lib.getSize()][3];
		output.setLayout(new BorderLayout());
		table = new JTable(data, columnNames);
		model = new DefaultTableModel();
		model.setColumnIdentifiers(columnNames);
		table.setModel(model);
		JScrollPane scrollpane = new JScrollPane(table);
		output.add(scrollpane);
		table.disable();
		
		for(int i=0; i<lib.getSize(); i++) {
			addBookToTable(lib.getBook(i), 3);
		}
		
		setSize(800, 650);
		setTitle("View Books");
		setVisible(true);
	}
	
	public void buttonClicked(JButton button) {
		if(button == exit) {
			dispose();
		}
		if(button == all) {
			String[] columnNames = {"Title",
					"Author",
					"Availability"};
			model.setColumnIdentifiers(columnNames);
			model.setRowCount(0);
			for(int i=0; i<lib.getSize(); i++) {
				addBookToTable(lib.getBook(i), 3);
			}
			table.repaint();
		}
		if(button == available) {
			String[] columnNames = {"Title",
					"Author"};
			model.setColumnIdentifiers(columnNames);
			model.setRowCount(0);
			for(int i=0; i<lib.getSize(); i++) {
				if(!(lib.getBook(i).isCheckedOut())) {
					addBookToTable(lib.getBook(i), 2);
				}
			}
			table.repaint();
		}
		if(button == borrowed) {
			String[] columnNames = {"Title",
					"Author",
					"Borrower",
					"Date Loaned",
					"Overdue?"};
			model.setColumnIdentifiers(columnNames);
			model.setRowCount(0);
			for(int i=0; i<lib.getSize(); i++) {
				if(lib.getBook(i).isCheckedOut()) {
					addBookToTable(lib.getBook(i), 5);
				}
			}
			table.repaint();
		}
		if(button == overdue) {
			String[] columnNames = {"Title",
					"Author",
					"Borrower",
					"Date Loaned"};
			model.setColumnIdentifiers(columnNames);
			model.setRowCount(0);
			for(int i=0; i<lib.getSize(); i++) {
				if(lib.getBook(i).isCheckedOut()) {
					if(lib.getBook(i).isOverdue()) {
						addBookToTable(lib.getBook(i), 4);
					}
				}
			}
			table.repaint();
		}
	}
	
	private void addBookToTable(Book b, int c) {
		switch (c) {
		case 3:
			String[] row3 = new String[3];
			row3[0] = b.getTitle();
			row3[1] = b.getAuthor();
			if(b.isCheckedOut()) {
				row3[2] = "<html><font color='red'>Loaned Out</font></html>";
			}
			else {
				row3[2] = "<html><font color='green'>In Stock</font></html>";
			}
			model.addRow(row3);
			break;
		case 2:
			String[] row2 = new String[2];
			row2[0] = b.getTitle();
			row2[1] = b.getAuthor();
			model.addRow(row2);
			break;
		case 5:
			String[] row5 = new String[5];
			row5[0] = b.getTitle();
			row5[1] = b.getAuthor();
			row5[2] = b.getBorrower();
			row5[3] = b.getDateBorrowed();
			if(b.isOverdue()) {
				row5[4] = "<html><font color='red'>Overdue</font</html>";
			}
			else {
				row5[4] = "<html><font color='green'>Not Overdue</font</html>";
			}
			model.addRow(row5);
			break;
		case 4:
			String[] row4 = new String[4];
			row4[0] = b.getTitle();
			row4[1] = b.getAuthor();
			row4[2] = b.getBorrower();
			row4[3] = b.getDateBorrowed();
			model.addRow(row4);
			break;
		}
	}
}