package main;
import java.util.*;

public class Library {

	private ArrayList<Book> library;
	
	public Library() {
		library = new ArrayList<Book>();
		storeBook(new Book("Matt", "Keefer"));
	}
	
	public void storeBook(Book b) {
		library.add(b);
	}
	
	public String getBook(int i) {
		return library.get(i).toString();
	}
	
	public int getSize() {
		return library.size();
	}
	
	public String getLibrary() {
		String out = "";
		for(Book b : library) {
			out += b.toString() + "\n";
		}
		return out;
	}
}