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
	JButton viewButton = addButton("View Books", 1,4,1,1);
	JButton viewOverdueButton = addButton("View Overdue", 1,5,1,1);
	Library lib = new Library();
	
	public static void main(String[] args) {
		JFrame frm = new LibraryGUI();
		frm.setTitle("¿Donde esta la biblioteca?");
		frm.setSize(600, 100);
		frm.setVisible(true);
		frm.getContentPane().setBackground(new Color(204, 78, 92));
	}
	
	public void buttonClicked(JButton button) {
		if(button==addBookButton) {
			AddBookDialog abd = new AddBookDialog(this, lib);
		}
		if(button==viewButton) {
			ViewBookDialog vbd = new ViewBookDialog(this, lib);
		}
		if(button==loanBookButton) {
			LoanBookDialog lbd = new LoanBookDialog(this, lib);
		}
	}
}