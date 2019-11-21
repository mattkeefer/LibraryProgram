package main;
import BreezySwing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class LoanBookDialog extends GBDialog {
	
	JComboBox comboMonth = addComboBox(1,1,1,1);
	JTextField monthField = addTextField("", 2,1,1,1);
	JComboBox comboDay = addComboBox(1,2,1,1);
	JTextField dayField = addTextField("", 2,2,1,1);
	JTextField yearField = addTextField("", 2,3,1,1);
	
	JButton exit = addButton("Return", 5,1,1,1);
	String[] months = {"Jan", "Feb", "Mar"};
	JComboBox month = new JComboBox(months);
	
	Library lib;
	
	public LoanBookDialog(JFrame frm, Library l) {
		super(frm);
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
		comboDay.setVisible(false);
		lib = l;
		comboMonth.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				comboDay.removeAllItems();
				comboDay.setVisible(true);
				setDayComboBox();
				
			}
		});
		setSize(400, 200);
		setTitle("View Books");
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
			break;
		case "February" :
			break;
		case "March" :
			comboDay.addItem(29);
			comboDay.addItem(30);
			comboDay.addItem(31);
			break;
		case "April" :
			comboDay.addItem(29);
			comboDay.addItem(30);
			break;
		case "May" :
			comboDay.addItem(29);
			comboDay.addItem(30);
			comboDay.addItem(31);
			break;
		case "June" :
			comboDay.addItem(29);
			comboDay.addItem(30);
			break;
		case "July" :
			comboDay.addItem(29);
			comboDay.addItem(30);
			comboDay.addItem(31);
			break;
		case "August" :
			comboDay.addItem(29);
			comboDay.addItem(30);
			comboDay.addItem(31);
			break;
		case "September" :
			comboDay.addItem(29);
			comboDay.addItem(30);
			break;
		case "October" :
			comboDay.addItem(29);
			comboDay.addItem(30);
			comboDay.addItem(31);
			break;
		case "November" :
			comboDay.addItem(29);
			comboDay.addItem(30);
			break;
		case "December" :
			comboDay.addItem(29);
			comboDay.addItem(30);
			comboDay.addItem(31);
			break;
		}
	}
	
	public void buttonClicked(JButton button) {
		if(button==exit) {
			dispose();
		}
	}
}