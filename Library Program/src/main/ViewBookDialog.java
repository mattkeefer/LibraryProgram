package main;
import BreezySwing.*;
import javax.swing.*;
public class ViewBookDialog extends GBDialog {

	JTextArea output = addTextArea("", 1,1,4,1);
	JButton exit = addButton("Return", 5,1,1,1);
	
	Library lib;
	
	public ViewBookDialog(JFrame frm, Library l) {
		super(frm);
		setSize(400, 200);
		setTitle("View Books");
		setVisible(true);
		output.setEditable(false);
		lib = l;
		output.setText(lib.getLibrary());
	}
	
	public void buttonClicked(JButton button) {
		dispose();
	}
}