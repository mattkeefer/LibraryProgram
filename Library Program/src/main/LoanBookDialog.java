package main;
import BreezySwing.*;
import javax.swing.*;
public class LoanBookDialog extends GBDialog {

//	JComboBox comboMonth = addComboBox(1,1,1,1);
//	JTextField monthField = addTextField("", 2,1,1,1);
//	JComboBox comboDay = addComboBox(1,2,1,1);
//	JTextField dayField = addTextField("", 2,2,1,1);
//	JTextField yearField = addTextField("", 2,3,1,1);
//	
//	JButton exit = addButton("Return", 5,1,1,1);
	String[] months = {"Jan", "Feb", "Mar"};
	JComboBox month = new JComboBox(months);
	
	Library lib;
	
	public LoanBookDialog(JFrame frm, Library l) {
		super(frm);
		setSize(400, 200);
		setTitle("View Books");
		setVisible(true);
		lib = l;
		
//		comboMonth.addItem("January");
//		comboMonth.addItem("February");
//		comboMonth.addItem("March");
//		comboMonth.addItem("April");
//		comboMonth.addItem("May");
//		comboMonth.addItem("June");
//		comboMonth.addItem("July");
//		comboMonth.addItem("August");
//		comboMonth.addItem("September");
//		comboMonth.addItem("October");
//		comboMonth.addItem("November");
//		comboMonth.addItem("December");
		
//		comboDay.addItem("1");
//		comboDay.addItem("2");
//		comboDay.addItem("3");
//		comboDay.addItem("4");
//		comboDay.addItem("5");
//		comboDay.addItem("6");
//		comboDay.addItem("7");
//		comboDay.addItem("8");
//		comboDay.addItem("9");
//		comboDay.addItem("10");
//		comboDay.addItem("11");
//		comboDay.addItem("12");
//		comboDay.addItem("13");
//		comboDay.addItem("14");
//		comboDay.addItem("15");
//		comboDay.addItem("16");
//		comboDay.addItem("17");
//		comboDay.addItem("18");
//		comboDay.addItem("19");
//		comboDay.addItem("20");
//		comboDay.addItem("21");
//		comboDay.addItem("22");
//		comboDay.addItem("23");
//		comboDay.addItem("24");
//		comboDay.addItem("25");
//		comboDay.addItem("26");
//		comboDay.addItem("27");
//		comboDay.addItem("28");
//		comboDay.addItem("29");
//		comboDay.addItem("30");
//		comboDay.addItem("31");
	}
	
//	public void buttonClicked(JButton button) {
//		if(button==exit) {
//			dispose();
//		}
//		else {
//			monthField.setText((String)comboMonth.getSelectedItem());
//			dayField.setText((String)comboDay.getSelectedItem());
//		}
//	}
}