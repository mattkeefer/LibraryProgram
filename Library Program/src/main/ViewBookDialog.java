package main;
import BreezySwing.*;
import javax.swing.*;
public class ViewBookDialog extends GBDialog {

	JTextArea output = addTextArea("", 1,1,4,1);
	JButton exit = addButton("Back", 5,1,1,1);
	
	Library lib;
	
	public ViewBookDialog(JFrame frm, Library l) {
		super(frm);
		output.setEditable(false);
		lib = l;
		output.setText(lib.getLibrary());
		setSize(400, 200);
		setTitle("View Books");
		setVisible(true);
	}
	
	public void buttonClicked(JButton button) {
		dispose();
	}
}