package main;
import java.util.*;

public class Library {

	private ArrayList<Book> library;
	
	public Library() {
		library = new ArrayList<Book>();
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
	
	//returns array list of books containing the specified keyword
	public ArrayList<Book> findBookFromTitle(String t) throws FormatException {
		ArrayList<Book> books = new ArrayList<Book>();
		for(int i=0; i<getSize(); i++) {
			if(getBook(i).getTitle().toLowerCase().contains(t.toLowerCase())) {
				books.add(getBook(i));
			}
		}
		if(books.size()!=0) {
			return books;
		}
		throw new FormatException("There are no books containing this keyword.");
	}
}