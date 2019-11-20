package main;
import java.util.*;

public class Library {

	private ArrayList<Book> library = new ArrayList<Book>();
	
	public void storeBook(Book b) {
		library.add(b);
	}
	
	public String getBook(int i) {
		return library.get(i).toString();
	}
}