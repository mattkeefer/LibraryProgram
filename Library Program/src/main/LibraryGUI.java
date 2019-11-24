/*
 * Matt Keefer
 * Library Program
 * 12/3/19
 */
package main;
import javax.swing.*;
import BreezySwing.*;
import java.awt.*;

public class LibraryGUI extends GBFrame {
	
	JButton addBookButton = addButton("Add Book", 1,1,1,1);
	JButton loanBookButton = addButton("Loan Book", 1,2,1,1);
	JButton returnBookButton = addButton("Return Book", 1,3,1,1);
	JButton searchBookButton = addButton("Search", 1,4,1,1);
	JButton viewButton = addButton("View Books", 1,5,1,1);
	JButton viewOverdueButton = addButton("View Overdue", 1,6,1,1);
	
	Library lib = new Library();
	
	public static void main(String[] args) {
		JFrame frm = new LibraryGUI();
		frm.setTitle("¿Donde esta la biblioteca?");
		frm.setSize(800, 200);
		frm.setVisible(true);
		frm.getContentPane().setBackground(new Color(204, 78, 92));
	}
	
	public void buttonClicked(JButton button) {
		try {	
			if(button==addBookButton) {
				AddBookDialog abd = new AddBookDialog(this, lib);
			}
			if(button==viewButton) {
				ViewBookDialog vbd = new ViewBookDialog(this, lib);
			}
			if(button==loanBookButton) {
				if(lib.getInStockSize()!=0) {
					LoanBookDialog lbd = new LoanBookDialog(this, lib);
				}
				else {
					messageBox("There are no books in stock.");
				}
			}
		}
		catch(FormatException e) {
			messageBox(e.getMessage());
		}
	}
}