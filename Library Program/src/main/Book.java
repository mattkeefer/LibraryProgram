package main;

public class Book {
	
	private String title;
	private String author;
	private Date date;
	private boolean checkedOut;
	
	public Book(String t, String a) {
		title = t;
		author = a;
		checkedOut = false;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public String toString() {
		return title + "\n" + author;
	}
	
	public void setDate(int m, int d, int y) {
		date = new Date(m, d, y);
	}
	
	public boolean isCheckedOut() {
		return checkedOut;
	}
	
	public void checkOut(boolean b) {
		checkedOut = b;
	}
}