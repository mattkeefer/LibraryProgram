package main;
import java.util.*;

public class Library {

	private ArrayList<Book> library;
	private ArrayList<Book> inStock;
	
	public Library() {
		library = new ArrayList<Book>();
		library.add(new Book("Cat In The Hat", "Dr. Seuss"));
		library.add(new Book("The Grapes of Wrath", "John Steinbeck"));
		library.add(new Book("To Kill A Mockingbird", "Harper Lee"));
		library.add(new Book("Webster’s Dictionary", "Webster"));
		inStock = library;
	}
	
	public void storeBook(Book b) {
		library.add(b);
		inStock.add(b);
	}
	
	public Book getBook(int i) {
		return library.get(i);
	}
	
	public int getSize() {
		return library.size();
	}
	
	public String getLibrary() {
		String out = "";
		for(Book b : library) {
			out += b.toString() + "\n\n";
		}
		return out;
	}
	
	public Book getInStockBook(int i) {
		return inStock.get(i);
	}
	
	public int getInStockSize() {
		return inStock.size();
	}
	
	public void loanOutBook(Book b) {
		inStock.remove(b);
	}
}