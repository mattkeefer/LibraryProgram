package main;
import BreezySwing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class LoanBookDialog extends GBDialog {
	
	JLabel bookLabel = addLabel("Select book:", 1,1,1,1);
	JComboBox bookSelection = addComboBox(1,2,1,1);
	JLabel borLabel = addLabel("Enter borrower:", 2,1,1,1);
	JTextField borrower = addTextField("", 2,2,1,1);
	JComboBox comboMonth = addComboBox(3,1,1,1);
	JComboBox comboDay = addComboBox(3,2,1,1);
	JComboBox comboYear = addComboBox(3,3,1,1);
	JButton loan = addButton("Check Out", 5,2,1,1);
	JButton exit = addButton("Return", 5,1,1,1);
	private int month = 0;
	
	Library lib;
	
	private boolean isLeapYear(int y) {
		return (y%4==0)&&(y%100!=0)||(y%400==0);
	}
	
	public LoanBookDialog(JFrame frm, Library l) {
		super(frm);
		for(int i=0; i<l.getSize(); i++) {
			if(!(l.getBook(i).isCheckedOut())) {
				bookSelection.addItem(l.getBook(i).getTitle());
			}
		}
		for(int i=0; i<=5000; i++) {
			comboYear.addItem(i);
			comboYear.setSelectedItem(2019);
		}
		comboMonth.addItem("January");
		comboMonth.addItem("February");
		comboMonth.addItem("March");
		comboMonth.addItem("April");
		comboMonth.addItem("May");
		comboMonth.addItem("June");
		comboMonth.addItem("July");
		comboMonth.addItem("August");
		comboMonth.addItem("September");
		comboMonth.addItem("October");
		comboMonth.addItem("November");
		comboMonth.addItem("December");
		
		comboMonth.setSelectedItem("January");
		setDayComboBox();
		comboDay.setSelectedItem(1);
		lib = l;
		comboMonth.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				comboDay.removeAllItems();
				setDayComboBox();
			}
		});
		comboYear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(isLeapYear((int)comboYear.getSelectedItem())) {
					comboDay.removeAllItems();
					setDayComboBox();
				}
			}
		});
		setSize(400, 200);
		setTitle("Loan Books");
		setVisible(true);
	}
	
	private void setDayComboBox() {
		
		for(int i=1; i<=28; i++) {
			comboDay.addItem(i);
		}
		switch(comboMonth.getSelectedItem().toString()) {
		case "January" :
			comboDay.addItem(29);
			comboDay.addItem(30);
			comboDay.addItem(31);
			month = 1;
			break;
		case "February" :
			month = 2;
			if(isLeapYear((int)comboYear.getSelectedItem())) {
				comboDay.addItem(29);
			}
			break;
		case "March" :
			month = 3;
			comboDay.addItem(29);
			comboDay.addItem(30);
			comboDay.addItem(31);
			break;
		case "April" :
			month = 4;
			comboDay.addItem(29);
			comboDay.addItem(30);
			break;
		case "May" :
			month = 5;
			comboDay.addItem(29);
			comboDay.addItem(30);
			comboDay.addItem(31);
			break;
		case "June" :
			month = 6;
			comboDay.addItem(29);
			comboDay.addItem(30);
			break;
		case "July" :
			month = 7;
			comboDay.addItem(29);
			comboDay.addItem(30);
			comboDay.addItem(31);
			break;
		case "August" :
			month = 8;
			comboDay.addItem(29);
			comboDay.addItem(30);
			comboDay.addItem(31);
			break;
		case "September" :
			month = 9;
			comboDay.addItem(29);
			comboDay.addItem(30);
			break;
		case "October" :
			month = 10;
			comboDay.addItem(29);
			comboDay.addItem(30);
			comboDay.addItem(31);
			break;
		case "November" :
			month = 11;
			comboDay.addItem(29);
			comboDay.addItem(30);
			break;
		case "December" :
			month = 12;
			comboDay.addItem(29);
			comboDay.addItem(30);
			comboDay.addItem(31);
			break;
		}
	}
	
	public void buttonClicked(JButton button) {
		if(button==loan) {
			try {
				if(borrower.getText().trim().equals("")) {
					throw new FormatException("Please enter borrower's name.");
				}
				else {
					lib.loanOutBook(lib.findInStockBook(bookSelection.getSelectedIndex()));
					lib.getBook(lib.findInStockBook(bookSelection.getSelectedIndex())).setBorrower(borrower.getText());
					lib.getBook(lib.findInStockBook(bookSelection.getSelectedIndex())).setDate(month, (int)comboDay.getSelectedItem(), (int)comboYear.getSelectedItem());
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