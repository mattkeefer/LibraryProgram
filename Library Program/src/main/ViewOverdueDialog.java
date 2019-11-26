package main;
import javax.swing.*;
import BreezySwing.*;

public class ViewOverdueDialog extends GBDialog {
	
	JTextArea output = addTextArea("", 1,1,4,1);
	JButton exit = addButton("Back", 5,1,1,1);
	
	Library lib;

	public ViewOverdueDialog(JFrame frm, Library l) {
		super(frm);
		lib = l;
		output.setEditable(false);
		String out = "";
		for(int i=0; i<lib.getSize(); i++) {
			if(lib.getBook(i).isCheckedOut()) {
				if(lib.getBook(i).isOverdue()) {
					out += lib.getBook(i).getTitle() + "\n" + lib.getBook(i).getBorrower() +"\n\n";
				}
			}
		}
		setSize(400, 200);
		setTitle("View Overdue Books");
		setVisible(true);
	}
	
	public void buttonClicked(JButton button) {
		dispose();
	}
}