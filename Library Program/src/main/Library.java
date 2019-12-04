package main;
import java.util.*;

public class Library {

	private ArrayList<Book> library;
	
	public Library() {
		library = new ArrayList<Book>();
		library.add(new Book("Cat In The Hat", "Dr. Seuss"));
		library.add(new Book("The Grapes of Wrath", "John Steinbeck"));
		library.add(new Book("To Kill A Mockingbird", "Harper Lee"));
		library.add(new Book("Webster�s Dictionary", "Webster"));
	}
	
	public void storeBook(Book b) {
		library.add(b);
	}
	
	public Book getBook(int i) {
		return library.get(i);
	}
	
	public int getSize() {
		return library.size();
	}
	
	public ArrayList<Book> getLibrary() {
		return library;
	}
	
	public void loanOutBook(int i) {
		library.get(i).checkOut(true);
	}
	
	public void returnBook(Book b) {
		int index = findBook(b);
		library.get(index).checkOut(false);
	}
	
	private int findBook(Book b) {
		int index;
		for(int i=0; i<library.size(); i++) {
			if(library.get(i).getTitle().equals(b.getTitle())) {
				index = i;
				return index;
			}
		}
		return -1;
	}
	
	public int findInStockBook(int index) {
		int book = 0;
		for (int i=0; i<library.size(); i++) {
			if(!(library.get(i).isCheckedOut())) {
				if(book == index) {
					return i;
				}
				book++;
			}
		}
		return -1;
	}
	
	public int findLoanedOutBook(int index) {
		int book = 0;
		for (int i=0; i<library.size(); i++) {
			if(library.get(i).isCheckedOut()) {
				if(book == index) {
					return i;
				}
				book++;
			}
		}
		return -1;
	}
	
	public Book findBookFromTitle(String t) throws FormatException {
		for(int i=0; i<getSize(); i++) {
			if(getBook(i).getTitle().equalsIgnoreCase(t)) {
				return getBook(i);
			}
		}
		throw new FormatException("The entered book does not exist within the library.");
	}
}